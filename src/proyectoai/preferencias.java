/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoai;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author admin
 */
public class preferencias extends javax.swing.JFrame {

    Agenteturistico a;
    public preferencias(Agenteturistico ag) {
        a=ag;
        initComponents();
        
        this.setSize(978, 725);
        this.setTitle("Agente Turistico");
        JLabel fondo=new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/interfaz_preferencias.jpg")));
        fondo.setFocusable(false);
        fondo.setSize(this.getSize());
        this.add(fondo);
        this.setVisible(true);
        
        ButtonGroup grupo_donde= new ButtonGroup();
        grupo_donde.add(montaña);
        grupo_donde.add(playa);
        grupo_donde.add(campo);
        grupo_donde.add(ciudad);
        grupo_donde.add(selva);
        
        ButtonGroup grupo_como= new ButtonGroup();
        grupo_como.add(tren);
        grupo_como.add(avion);
        grupo_como.add(carro);

        ButtonGroup grupo_hospedaje= new ButtonGroup();
        grupo_hospedaje.add(hotel);
        grupo_hospedaje.add(posada);   
        
        ButtonGroup grupo_personas= new ButtonGroup();
        grupo_personas.add(solo);
        grupo_personas.add(pareja);

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

        playa.setBackground(new java.awt.Color(255, 255, 255));

        campo.setBackground(new java.awt.Color(255, 255, 255));

        ciudad.setBackground(new java.awt.Color(255, 255, 255));

        selva.setBackground(new java.awt.Color(255, 255, 255));

        tren.setBackground(new java.awt.Color(255, 255, 255));

        carro.setBackground(new java.awt.Color(255, 255, 255));

        avion.setBackground(new java.awt.Color(255, 255, 255));

        criolla.setBackground(new java.awt.Color(255, 255, 255));

        vegetariana.setBackground(new java.awt.Color(255, 255, 255));

        gourmet.setBackground(new java.awt.Color(255, 255, 255));

        pareja.setBackground(new java.awt.Color(255, 255, 255));

        solo.setBackground(new java.awt.Color(255, 255, 255));

        posada.setBackground(new java.awt.Color(255, 255, 255));

        hotel.setBackground(new java.awt.Color(255, 255, 255));

        escalada.setBackground(new java.awt.Color(255, 255, 255));

        yoga.setBackground(new java.awt.Color(255, 255, 255));

        masajes.setBackground(new java.awt.Color(255, 255, 255));

        ski_acuatico.setBackground(new java.awt.Color(255, 255, 255));

        moto_acuatica.setBackground(new java.awt.Color(255, 255, 255));

        excursion.setBackground(new java.awt.Color(255, 255, 255));

        bici_patines.setBackground(new java.awt.Color(255, 255, 255));

        visitas.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Precio máx. hospedaje");

        jLabel2.setText("Precio máx. actividades");

        jLabel3.setText("Precio máx. trasnporte");

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(hotel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ciudad)
                                    .addComponent(selva)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(campo)
                                                .addGap(216, 216, 216))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(playa, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(montaña, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(Play, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(tren)
                                            .addComponent(avion)
                                            .addComponent(carro)
                                            .addComponent(vegetariana)
                                            .addComponent(gourmet)
                                            .addComponent(criolla))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(218, 218, 218)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(posada)
                                            .addComponent(pareja)
                                            .addComponent(solo)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(grupo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(familia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(239, 239, 239)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(montaña))
                        .addComponent(tren, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(solo, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(excursion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(grupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ski_acuatico)
                        .addComponent(ciudad))
                    .addComponent(familia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selva)
                    .addComponent(masajes))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vegetariana)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(precio_hospedaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(yoga))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(precio_act, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(gourmet)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(visitas)
                                .addGap(13, 13, 13))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(precio_act1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(criolla))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(bici_patines))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Play, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(hotel)
                        .addGap(40, 40, 40)
                        .addComponent(posada)))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayActionPerformed
        // TODO add your handling code here:
        a.play();
    }//GEN-LAST:event_PlayActionPerformed

  
    
    
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
