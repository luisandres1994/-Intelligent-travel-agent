/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 
public class proveedor  extends Agent {
    
    private  Object[] args;
   
    protected void setup() {
          args = this.getArguments();
      
            
             //Registro del servicio de venta de coches en las páginas amarillas.
            ServiceDescription servicio = new ServiceDescription();
             servicio.setType("Autos");
            servicio.setName("Venta de coches");

            DFAgentDescription descripcion = new DFAgentDescription();
            descripcion.setName(getAID());
            descripcion.addLanguages("Español");
            descripcion.addServices(servicio);

            try {
                DFService.register(this, descripcion);
            } catch (FIPAException e) {
                e.printStackTrace();
            }
        
    //Se crea una plantilla que filtre los mensajes a recibir.
        MessageTemplate template = ContractNetResponder.createMessageTemplate(FIPANames.InteractionProtocol.FIPA_CONTRACT_NET);
 
        //Añadimos los comportamientos ante mensajes recibidos
        this.addBehaviour(new CrearOferta(this, template));
    }
 
    //Hacemos una simulación para que pueda dar que existe o no coche (sobre un 80% probab).
    private boolean existeCoche() {
        return (Math.random() * 100 > 20);
    }
 
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
            System.out.printf("Autos %s: Peticion de oferta recibida de %s.\n", this.myAgent.getLocalName(), cfp.getSender().getLocalName());
 
            //Comprobamos si existen ofertas disponibles
            if (proveedor.this.existeCoche()) {
                //Proporcionamos la información necesaria
                int precio = proveedor.this.obtenerPrecio();
                System.out.printf("Autos %s: Preparando oferta (%d euros).\n", this.myAgent.getLocalName(), precio);
 
                //Se crea el mensaje
                ACLMessage oferta = cfp.createReply();
                oferta.setPerformative(ACLMessage.PROPOSE);
                oferta.setContent(String.valueOf(precio));
                return oferta;
            } else {
                //Si no hay ofertas disponibles rechazamos el propose
                System.out.printf("Autos %s: No tenemos ofertas disponibles.\n", this.myAgent.getLocalName());
                throw new RefuseException("Fallo en la evaluación.");
            }
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
    
    
}