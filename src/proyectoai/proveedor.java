
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
   private static Connection con;
   
   private static ResultSet rset;
    private static Statement stmt;
    
    String query;
    protected void setup() {
          args = this.getArguments();
      
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
            } catch (FIPAException e) {
                e.printStackTrace();
            }
        
        MessageTemplate template = ContractNetResponder.createMessageTemplate(FIPANames.InteractionProtocol.FIPA_CONTRACT_NET);
 
        this.addBehaviour(new CrearOferta(this, template));
        
     
    }
    
    
    private void loadDB() throws ClassNotFoundException, SQLException, IOException
    {
        //coneccion a la base de datos.
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "AGENTE", "123456");
    }
 
 
    //Calculamos un precio para el coche aleatoriamente (estará entre 8000 y 30000).
    private int obtenerPrecio() {
        return (int) (Math.random() * 22000) + 8000;
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
                 try {
                        loadDB();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 
                //construye la consulta que se realizara sobre la base de datos
                 //segun las preferencias recibidas por el agente turistico
                String[] consulta=cfp.getContent().split("/");
                String[] select=consulta[0].split(" ");
                String[] from=consulta[1].split(" ");
                String[] where=consulta[2].split(" ");
                query="select ";
                int i;
                for(i=0; i<select.length; i++)
                    query=query+(String)args[0]+"."+select[i]+", ";
                query+=(String)args[0]+".precio from "+(String)args[0]+" where ";
                
                String aux=query;
                for(i=0; i<where.length-1; i++)
                {
                    /*try {
                        stmt = con.createStatement();
                        rset= stmt.executeQuery(query);
                    } catch (SQLException ex) {
                        Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                    
                    //if(!rset.next())encontro =false;
                    query+=(String)args[0]+"."+select[i]+"="+where[i]+", ";
                    
                }
                query+=(String)args[0]+"."+select[i]+"="+where[i]+"; ";
                
               
                
        
                if(encontro)
                {
                ACLMessage oferta = cfp.createReply();
                oferta.setPerformative(ACLMessage.PROPOSE);
                oferta.setContent(String.valueOf(proveedor.this.obtenerPrecio()));
                    return oferta;
                }else
                {
                    //Si no hay ofertas disponibles rechazamos el propose
                throw new RefuseException("Fallo la solicitud.");
                }
        }
 
        protected ACLMessage prepareResultNotification(ACLMessage cfp, ACLMessage propose, ACLMessage accept) throws FailureException {
            //Hemos recibido una aceptación de nuestra oferta, enviamos los resultados
            
                String res="";
            if (devolveroferta()) {
                
                /*try {
                    stmt = con.createStatement();
                    rset= stmt.executeQuery(query);
                while(rset.next()) res+=rset.toString()+"/ ";
                } catch (SQLException ex) {
                    Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);
                }*/
     
 
                ACLMessage inform = accept.createReply();
                inform.setPerformative(ACLMessage.INFORM);
                inform.setContent(res);
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