/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoai;

import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author admin
 */
public class preferencias extends javax.swing.JFrame {

    Agenteturistico a;
    ButtonGroup grupo_donde= new ButtonGroup();
    ButtonGroup grupo_como= new ButtonGroup();
    ButtonGroup grupo_hospedaje= new ButtonGroup();
    ButtonGroup grupo_personas= new ButtonGroup();
    public preferencias(Agenteturistico ag) {
        a=ag;
        initComponents();
        //Definir el aspecto de la interfaz
        this.setSize(978, 725);
        this.setTitle("Agente Turistico");
        JLabel fondo=new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/interfaz_preferencias.jpg")));
        fondo.setFocusable(false);
        fondo.setSize(this.getSize());
        this.setResizable(true);
        this.add(fondo);
        this.setVisible(true);
       
        //Se declaran los ButtonGroup para que el cliente no seleccione multiples opciones
        
        //Grupon lugar
        
        grupo_donde.add(montaña);
        grupo_donde.add(playa);
        grupo_donde.add(campo);
        grupo_donde.add(ciudad);
        grupo_donde.add(selva);
        
        //Grupo medio de transporte
        
        grupo_como.add(tren);
        grupo_como.add(avion);
        grupo_como.add(carro);

        //Grupo hospedaje
        grupo_hospedaje.add(hotel);
        grupo_hospedaje.add(posada);   
        
        //Grupo Cantidad de personas
        grupo_personas.add(solo);
        grupo_personas.add(pareja);
        
        //Las demas columnas: actividades y comidas no se agrupan ya que el cliente puede elegir mas de una opcion

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        montaña = new javax.swing.JRadioButton();
        playa = new javax.swing.JRadioButton();
        campo = new javax.swing.JRadioButton();
        ciudad = new javax.swing.JRadioButton();
        selva = new javax.swing.JRadioButton();
        tren = new javax.swing.JRadioButton();
        carro = new javax.swing.JRadioButton();
        avion = new javax.swing.JRadioButton();
        criolla = new javax.swing.JRadioButton();
        vegetariana = new javax.swing.JRadioButton();
        gourmet = new javax.swing.JRadioButton();
        pareja = new javax.swing.JRadioButton();
        solo = new javax.swing.JRadioButton();
        posada = new javax.swing.JRadioButton();
        hotel = new javax.swing.JRadioButton();
        escalada = new javax.swing.JRadioButton();
        yoga = new javax.swing.JRadioButton();
        masajes = new javax.swing.JRadioButton();
        ski_acuatico = new javax.swing.JRadioButton();
        moto_acuatica = new javax.swing.JRadioButton();
        excursion = new javax.swing.JRadioButton();
        bici_patines = new javax.swing.JRadioButton();
        visitas = new javax.swing.JRadioButton();
        grupo = new javax.swing.JSpinner();
        familia = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        precio_hospedaje = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        precio_act = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        precio_act1 = new javax.swing.JTextField();
        Play = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        montaña.setBackground(new java.awt.Color(255, 255, 255));
        montaña.setName("montaña"); // NOI18N

        playa.setBackground(new java.awt.Color(255, 255, 255));
        playa.setName("playa"); // NOI18N

        campo.setBackground(new java.awt.Color(255, 255, 255));
        campo.setName("campo"); // NOI18N

        ciudad.setBackground(new java.awt.Color(255, 255, 255));
        ciudad.setName("ciudad"); // NOI18N

        selva.setBackground(new java.awt.Color(255, 255, 255));
        selva.setName("selva"); // NOI18N

        tren.setBackground(new java.awt.Color(255, 255, 255));
        tren.setName("tren"); // NOI18N

        carro.setBackground(new java.awt.Color(255, 255, 255));
        carro.setName("carro"); // NOI18N

        avion.setBackground(new java.awt.Color(255, 255, 255));
        avion.setName("avion"); // NOI18N

        criolla.setBackground(new java.awt.Color(255, 255, 255));
        criolla.setName("criolla"); // NOI18N

        vegetariana.setBackground(new java.awt.Color(255, 255, 255));
        vegetariana.setName("vegetariana"); // NOI18N

        gourmet.setBackground(new java.awt.Color(255, 255, 255));
        gourmet.setName("gourmet"); // NOI18N

        pareja.setBackground(new java.awt.Color(255, 255, 255));
        pareja.setName("2"); // NOI18N

        solo.setBackground(new java.awt.Color(255, 255, 255));
        solo.setName("1"); // NOI18N

        posada.setBackground(new java.awt.Color(255, 255, 255));
        posada.setName("posada"); // NOI18N

        hotel.setBackground(new java.awt.Color(255, 255, 255));
        hotel.setName("hotel"); // NOI18N

        escalada.setBackground(new java.awt.Color(255, 255, 255));
        escalada.setName("escalada"); // NOI18N

        yoga.setBackground(new java.awt.Color(255, 255, 255));
        yoga.setName("yoga"); // NOI18N

        masajes.setBackground(new java.awt.Color(255, 255, 255));
        masajes.setName("masajes"); // NOI18N

        ski_acuatico.setBackground(new java.awt.Color(255, 255, 255));
        ski_acuatico.setName("ski acuatica"); // NOI18N

        moto_acuatica.setBackground(new java.awt.Color(255, 255, 255));
        moto_acuatica.setName("monto acuatica"); // NOI18N

        excursion.setBackground(new java.awt.Color(255, 255, 255));
        excursion.setName("excursion"); // NOI18N

        bici_patines.setBackground(new java.awt.Color(255, 255, 255));
        bici_patines.setName("bici o patinaje"); // NOI18N

        visitas.setBackground(new java.awt.Color(255, 255, 255));
        visitas.setName("visitas"); // NOI18N

        jLabel1.setText("Precio máx. hospedaje");

        precio_hospedaje.setName("preciohospedaje"); // NOI18N

        jLabel2.setText("Precio máx. actividades");

        precio_act.setName("precioact"); // NOI18N

        jLabel3.setText("Precio máx. trasnporte");

        precio_act1.setName("preciotransporte"); // NOI18N

        Play.setText("Buscar Ofertas");
        Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ciudad)
                            .addComponent(selva)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(playa)
                                    .addComponent(montaña)
                                    .addComponent(campo)
                                    .addComponent(Play, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(112, 112, 112)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(avion)
                                    .addComponent(tren)
                                    .addComponent(carro)
                                    .addComponent(vegetariana)
                                    .addComponent(gourmet)
                                    .addComponent(criolla))))
                        .addGap(220, 220, 220)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(solo)
                            .addComponent(pareja)
                            .addComponent(hotel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(familia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(grupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(posada)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(precio_act, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(precio_hospedaje, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(precio_act1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(excursion)
                        .addGap(190, 190, 190))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(escalada)
                            .addComponent(moto_acuatica)
                            .addComponent(ski_acuatico)
                            .addComponent(masajes)
                            .addComponent(yoga)
                            .addComponent(visitas)
                            .addComponent(bici_patines))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(255, 255, 255)
                            .addComponent(montaña))
                        .addComponent(tren, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(solo)
                            .addComponent(excursion))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playa, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(avion, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pareja, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(escalada, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo)
                    .addComponent(carro)
                    .addComponent(moto_acuatica)
                    .addComponent(grupo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ski_acuatico)
                        .addComponent(ciudad))
                    .addComponent(familia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selva)
                    .addComponent(masajes))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(precio_hospedaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(yoga)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vegetariana)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(precio_act, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hotel)
                    .addComponent(gourmet)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(visitas)
                        .addGap(13, 13, 13))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(precio_act1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(bici_patines))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(criolla)))
                            .addGap(8, 8, 8))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(posada)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Play, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayActionPerformed
        // TODO add your handling code here:
        a.play();
    }//GEN-LAST:event_PlayActionPerformed

    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getName();
            }
        }

        return null;
    }
    
    
  
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Play;
    private javax.swing.JRadioButton avion;
    private javax.swing.JRadioButton bici_patines;
    private javax.swing.JRadioButton campo;
    private javax.swing.JRadioButton carro;
    private javax.swing.JRadioButton ciudad;
    private javax.swing.JRadioButton criolla;
    private javax.swing.JRadioButton escalada;
    private javax.swing.JRadioButton excursion;
    private javax.swing.JSpinner familia;
    private javax.swing.JRadioButton gourmet;
    private javax.swing.JSpinner grupo;
    private javax.swing.JRadioButton hotel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton masajes;
    private javax.swing.JRadioButton montaña;
    private javax.swing.JRadioButton moto_acuatica;
    private javax.swing.JRadioButton pareja;
    private javax.swing.JRadioButton playa;
    private javax.swing.JRadioButton posada;
    private javax.swing.JTextField precio_act;
    private javax.swing.JTextField precio_act1;
    private javax.swing.JTextField precio_hospedaje;
    private javax.swing.JRadioButton selva;
    private javax.swing.JRadioButton ski_acuatico;
    private javax.swing.JRadioButton solo;
    private javax.swing.JRadioButton tren;
    private javax.swing.JRadioButton vegetariana;
    private javax.swing.JRadioButton visitas;
    private javax.swing.JRadioButton yoga;
    // End of variables declaration//GEN-END:variables
}
