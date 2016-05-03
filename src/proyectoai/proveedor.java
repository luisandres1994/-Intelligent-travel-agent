
package proyectoai;

import jade.core.Agent;
import jade.domain.DFService;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPANames;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.FailureException;
import jade.domain.FIPAAgentManagement.NotUnderstoodException;
import jade.domain.FIPAAgentManagement.RefuseException;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.ContractNetResponder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class proveedor  extends Agent {
    
    private  Object[] args;
   private  Connection con;
   
   private static ResultSet rset;
    private static Statement stmt;
    
    String query;
    String aux;
    protected void setup() {
          args = this.getArguments();
          
           // this.getAID().setLocalName((String) args[0]);
            ServiceDescription servicio = new ServiceDescription();
             servicio.setType((String) args[0]);
            servicio.setName("Venta de "+(String) args[0]);
           //se inscribe en las paginas amarillas (directorio facilitador)
            DFAgentDescription descripcion = new DFAgentDescription();
            descripcion.setName(getAID());
            descripcion.addLanguages("Español");
            descripcion.addServices(servicio);

            try {
                DFService.register(this, descripcion);
            } catch (FIPAException e) {  e.printStackTrace();}
        
        MessageTemplate template = ContractNetResponder.createMessageTemplate(FIPANames.InteractionProtocol.FIPA_CONTRACT_NET);
        this.addBehaviour(new CrearOferta(this, template));
    }
    
    
   
 
 
    //mandamos solo  el paquete con el precio mas barato
    private int obtenerPrecio() throws SQLException {
        try {
                        stmt = con.createStatement();
                        String Query="select min("+(String)args[0]+".precio) as minimo from "+(String)args[0]+" where "+aux;
                        rset= stmt.executeQuery(Query);
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);
                    }
        if(rset.next());
        int r=rset.getInt(1);
        stmt.close();
        return r;
    }
 
    // Simula fallos en la entrega de ofertas
    private boolean devolveroferta() {
        return (int) (Math.random() * 10) > 1;
    }
 
    private class CrearOferta extends ContractNetResponder {
        public CrearOferta(Agent agente, MessageTemplate plantilla) {
            super(agente, plantilla);
        }
 
        protected ACLMessage prepareResponse(ACLMessage cfp) throws NotUnderstoodException, RefuseException {
                
                boolean encontro=true;
                query="";
                //levantamos la base de datos ORACLE
                
                 try{   
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "AGENTE", "123456");
                   
                }catch(SQLException slex){System.out.print(slex);}
                 catch(ClassNotFoundException clex){System.out.print(clex);}
                
                //construye la consulta que se realizara sobre la base de datos
                 //segun las preferencias recibidas por el agente turistico
                
                String[] consulta=cfp.getContent().split("/");
                
                String[] select=consulta[0].split(" ");
                String[] from=consulta[1].split(" ");
                String[] where=consulta[2].split(" ");
                
                 
               //se agregan las condiciones a la consulta y se verifican una por una, de no cumplirse una el agente
                //rechaza el cfp porque no hay disponibilidad con las condiciones dadas
                aux="";
                query="select * from "+(String) args[0]+" where ";
                
                int i;
                for(i=0; i<where.length-1; i++)
                {
                    aux+=(String)args[0]+"."+select[i]+"='"+where[i]+"'";
                    query+=(String)args[0]+"."+select[i]+"='"+where[i]+"'";
                    try { //verificacion de condiciones una por una
                        stmt = con.createStatement();
                        System.out.println(query);
                        rset= stmt.executeQuery(query);
                        if(!rset.next())encontro =false; //no puede dar disponibilidad
                        stmt.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);}
                    
                    aux+=" and ";
                    query+=" and ";          
                }
                aux+=(String)args[0]+"."+select[i]+"='"+where[i]+"' ";
                query+=(String)args[0]+"."+select[i]+"='"+where[i]+"' ";
                    try {
                        stmt = con.createStatement();
                        rset= stmt.executeQuery(query);
                        if(!rset.next())encontro =false;
                        stmt.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex); }
                
               
               //si encontro disponibilidad
                if(encontro)
                {
                ACLMessage oferta = cfp.createReply();
                oferta.setPerformative(ACLMessage.PROPOSE);
                    try {
                     oferta.setContent(String.valueOf(proveedor.this.obtenerPrecio()));
                    } catch (SQLException ex) {
                        Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);}
                    oferta.setOntology((String)args[0]);
                return oferta;
                }else
                {
                    //Si no hay ofertas disponibles rechazamos el propose
                    throw new RefuseException("Fallo la solicitud.");
                }
        }
        

        //Hemos recibido una aceptación de nuestra oferta, enviamos los resultados
        protected ACLMessage prepareResultNotification(ACLMessage cfp, ACLMessage propose, ACLMessage accept) throws FailureException {
            
            
                String res="";
                int i;
            if (devolveroferta()) 
            {
                try {
                    //armamos ya la consulta general con las condiciones dadas
                    //se envia los resultados de cada fila de la consulta separadas por /
                    stmt = con.createStatement();
                    rset= stmt.executeQuery("select * from "+(String)args[0]+" where "+aux);
                    while(rset.next()) 
                    {
                         for(i=1; i<=rset.getMetaData().getColumnCount(); i++)
                             res+=rset.getString(i)+" ";

                        res+="/ ";
                    }
                } catch (SQLException ex) {Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex); }
     
 
                ACLMessage inform = accept.createReply();
                inform.setPerformative(ACLMessage.INFORM);
                inform.setContent(res);
                inform.setOntology((String)args[0]);
                return inform;
                
            } else {
                //algun error enviando informe de resultados
                throw new FailureException("Error al enviar contrato.");
            }
        }
 
        protected void handleRejectProposal(ACLMessage cfp, ACLMessage propose, ACLMessage reject) {
            
            
        }
    }
    
    
   
    
}