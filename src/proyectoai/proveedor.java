
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
    private Vector vector=new Vector(20, 5);
   private static Connection con;
   
   private static ResultSet rset;
    private static Statement stmt,stmt1;
    int id_dim;
    String query;
    protected void setup() {
          args = this.getArguments();
      
            ServiceDescription servicio = new ServiceDescription();
             servicio.setType((String) args[0]);
            servicio.setName("Venta de "+(String) args[0]);

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
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "AGENTE", "123456");
    }
 
    //Hacemos una simulación para que pueda dar que existe o no coche (sobre un 80% probab).
 
 
    //Calculamos un precio para el coche aleatoriamente (estará entre 8000 y 30000).
    private int obtenerPrecio() {
        return (int) (Math.random() * 22000) + 8000;
    }
 
    // Simula fallos en el cálculo de precios.
    private boolean devolverPrecio() {
        return (int) (Math.random() * 10) > 1;
    }
 
    private class CrearOferta extends ContractNetResponder {
        public CrearOferta(Agent agente, MessageTemplate plantilla) {
            super(agente, plantilla);
        }
 
        protected ACLMessage prepareResponse(ACLMessage cfp) throws NotUnderstoodException, RefuseException {
                
            
                 try {
                        loadDB();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
                String[] consulta=cfp.getContent().split("/");
                String[] select=consulta[0].split(" ");
                String[] from=consulta[1].split(" ");
                String[] where=consulta[2].split(" ");
                query="select ";
                int i;
                for(i=0; i<select.length; i++)
                    query=query+(String)args[0]+"."+select[i]+", ";
                query+=(String)args[0]+".precio from "+(String)args[0]+" where ";
                for(i=0; i<where.length-1; i++)
                    query+=(String)args[0]+"."+select[i]+"="+where[i]+", ";
                query+=(String)args[0]+"."+select[i]+"="+where[i]+"; ";
                System.out.println(query);
                
                ACLMessage oferta = cfp.createReply();
                oferta.setPerformative(ACLMessage.PROPOSE);
                oferta.setContent(String.valueOf(proveedor.this.obtenerPrecio()));
                return oferta;
            
        }
 
        protected ACLMessage prepareResultNotification(ACLMessage cfp, ACLMessage propose, ACLMessage accept) throws FailureException {
            //Hemos recibido una aceptación de nuestra oferta, enviamos el albarán
            System.out.printf("Autos %s: Hay una posible oferta.\n", this.myAgent.getLocalName());
 
            if (devolverPrecio()) {
                System.out.printf("Autos %s: Enviando contrato de compra.\n", this.myAgent.getLocalName());
 
                ACLMessage inform = accept.createReply();
                inform.setPerformative(ACLMessage.INFORM);
                return inform;
            } else {
                System.out.printf("Autos %s: Vaya!, ha fallado al enviar el contrato.\n", this.myAgent.getLocalName());
                throw new FailureException("Error al enviar contrato.");
            }
        }
 
        protected void handleRejectProposal(ACLMessage cfp, ACLMessage propose, ACLMessage reject) {
            //Nuestra oferta por el coche ha sido rechazada
            System.out.printf("Autos %s: Oferta rechazada por su excesivo precio.\n", this.myAgent.getLocalName());
        }
    }
    
    
   private boolean leerarchivo()
   {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
         
         archivo = new File ("/transporte.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         String linea;
         while((linea=br.readLine())!=null)
            vector.add(linea);
      }
      catch(Exception e){
         e.printStackTrace();
         return false;
      }finally{
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
      
        return true;
       
   }
    
}