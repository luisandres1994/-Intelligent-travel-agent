package proyectoai;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.domain.DFService;
import jade.domain.FIPANames;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.proto.ContractNetInitiator;
 
import java.util.Date;
import java.util.Vector;
 
public class Agenteturistico extends Agent {
 
    private int numeroDeOfertas;
 
    //Precio máximo que se pagará por un coche.
    public int precionMaximo;
    preferencias I;
    Object[] args;
    Vector propuestas=new Vector(3,1);
    String[] transporte,alojamiento,turista;
    public String donde,Como,comida,cuantos,hospedaje,actividades;
    boolean don,com,comid,cuant,hospe,acti;
    protected void setup() {
       
       args = this.getArguments();
        I=new preferencias(this);
        donde=Como=comida=cuantos=hospedaje=actividades="";
        
 
    } // Fin del setup
    
   
    public class iniciarcontranet extends SimpleBehaviour
    {
        private String Proveedor;
        public iniciarcontranet(String p)
        {
            Proveedor=p;
            
        }
        
        @Override
        public void action() {
                precionMaximo=23456;

            //Búsqueda del proveedor servicio  las páginas amarillas.
            ServiceDescription servicio = new ServiceDescription();
            servicio.setType(Proveedor);
            servicio.setName("Venta de "+Proveedor);
            DFAgentDescription descripcion = new DFAgentDescription();
            descripcion.addLanguages("Español");
            descripcion.addServices(servicio);
 
            try {
                DFAgentDescription[] resultados = DFService.search(Agenteturistico.this, descripcion);
                if (resultados.length <= 0) {
                    //no hay disponibilidad
                } else {
                    //Creamos el mensaje CFP(Call For Proposal) cumplimentando sus parámetros
                    ACLMessage mensajeCFP = new ACLMessage(ACLMessage.CFP);
                    for (DFAgentDescription agente:resultados) {
                        mensajeCFP.addReceiver(agente.getName());
                    }
            //Protocolo que vamos a utilizar
                    mensajeCFP.setProtocol(FIPANames.InteractionProtocol.FIPA_CONTRACT_NET);
                   if(Proveedor.equals("transporte"))
                    {
                        String tipo="";
                        if(Como!=null) tipo="tipo";
                        else Como="";
                         mensajeCFP.setContent("destino "+tipo+"/"+Proveedor+"/" +donde+" "+Como);
                    }else if(Proveedor.equals("alojamiento"))
                    {
                        String comid="";
                        if(comida!=null) comid="comida";
                        else comida="";
                        mensajeCFP.setContent("destino tipo cant_perso "+comid+"/"+Proveedor+"/"+donde+" "+hospedaje+" "+cuantos+" "+comida);
                    }
                    else if(Proveedor.equals("turista"))
                    { 
                        mensajeCFP.setContent("destino actividades cant_perso/"+Proveedor+"/"+donde+" "+actividades+" "+cuantos);
                    }
                    //Indicamos el tiempo que esperaremos por las ofertas.
                    mensajeCFP.setReplyByDate(new Date(System.currentTimeMillis() + 15000));
 
                    //Se añade el comportamiento que manejará las ofertas.
                    Agenteturistico.this.addBehaviour(new ManejoOpciones(Agenteturistico.this, mensajeCFP));
                }
                } catch (Exception e) {
                e.printStackTrace();
            }
        }

        

        @Override
        public boolean done() {
            return true;
        }
    }
    
    
     public void play()
    {
        addBehaviour(new iniciarcontranet("transporte"));
        addBehaviour(new iniciarcontranet("alojamiento"));
        addBehaviour(new iniciarcontranet("turista"));
    }
    private class ManejoOpciones extends ContractNetInitiator {
 
        public ManejoOpciones(Agent agente, ACLMessage plantilla) {
            super(agente, plantilla);
        }
 
        
        protected void handleRefuse(ACLMessage rechazo) {
            
        }
 
        //Manejador de respuestas de fallo.
        protected void handleFailure(ACLMessage fallo) {
            
            //Falló, por lo tanto, no recibiremos respuesta desde ese agente
            Agenteturistico.this.numeroDeOfertas--;
        }
 
        //Método colectivo llamado tras finalizar el tiempo de espera o recibir todas las propuestas.
        protected void handleAllResponses(Vector respuestas, Vector aceptados) {
 
        //Se comprueba si una oferta se paso del plazo
            if (respuestas.size() < numeroDeOfertas) {
                System.out.printf("las ofertas llegan tarde.\n");
            }
            
            
            
            //aqui se recibe las propuestas de un proveedor, se separan para luego armar las ofertas a mostrar
            for(Object resp:respuestas)
            {
                ACLMessage mensaje=(ACLMessage) resp;
                if (mensaje.getPerformative() == ACLMessage.PROPOSE){
                    ACLMessage respuesta=mensaje.createReply();
                    
                }
            }
            
            
            //Escogemos la mejor oferta
           
            ACLMessage aceptado = null;
            for (Object resp:respuestas) {
                ACLMessage mensaje = (ACLMessage) resp;
                if (mensaje.getPerformative() == ACLMessage.PROPOSE) {
                    ACLMessage respuesta = mensaje.createReply();
                    respuesta.setPerformative(ACLMessage.REJECT_PROPOSAL);
                    aceptados.add(respuesta);
 
                    //Si la oferta es adecuada al precio tope establecido
                    //se acepta la propuesta
                    int oferta = Integer.parseInt(mensaje.getContent());
                    if (oferta <= Integer.parseInt(I.getmaxprecio(mensaje.getOntology()))) {
                        aceptado = respuesta;
                    }
                    
                }
            }
            
            //Si hay una oferta aceptada se modifica su performativa.
            if (aceptado != null) {
                aceptado.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
            }
        }
 
        protected void handleInform(ACLMessage inform) {
           String[] res = inform.getContent().split("/");
           System.out.println("La propuesta del proveedor "+inform.getOntology());
           int i;
           for(i=0; i<res.length; i++)
           {
               System.out.println(res[i]);
           }
        }
    }
    }

