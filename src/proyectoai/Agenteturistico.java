
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
    public String donde,Como,comida,cuantos,hospedaje,actividades;
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
                    mensajeCFP.setContent("destino tipo/ "+Proveedor+" /selva carro");
 
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
            int mejorOferta = Integer.MAX_VALUE;
            AID mejorAutos = null;
            ACLMessage aceptado = null;
            for (Object resp:respuestas) {
                ACLMessage mensaje = (ACLMessage) resp;
                if (mensaje.getPerformative() == ACLMessage.PROPOSE) {
                    ACLMessage respuesta = mensaje.createReply();
                    respuesta.setPerformative(ACLMessage.REJECT_PROPOSAL);
                    aceptados.add(respuesta);
 
                    //Si la oferta es la mejor (inferior a todas las otras)
                    //Se almacena su precio y el AID de la venta de autos que la hizo.
                    int oferta = Integer.parseInt(mensaje.getContent());
                    if (oferta <= precionMaximo && oferta <= mejorOferta) {
                        mejorOferta = oferta;
                        mejorAutos = mensaje.getSender();
                        aceptado = respuesta;
                    }
                }
            }
            
            //Si hay una oferta aceptada se modifica su performativa.
            if (aceptado != null) {
                aceptado.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
            }
        }
 
        
    }
    }

