/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serial;

import BaseDatos.DBQueries;
import Entidades.Empleados;
import Entidades.Tarjetas;
import Entidades.Vehiculos;
import Voz.LeeTexto;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author J.Israel
 */
public class MonitorAcceso extends javax.swing.JFrame {

    Tarjetas tarjeta;
    Vehiculos vehiculo;
    Empleados empleado;
    
    public MonitorAcceso() {
        initComponents();
        myInit();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TagID1 = new javax.swing.JTextField();
        TagID2 = new javax.swing.JTextField();
        TagID3 = new javax.swing.JTextField();
        TagID4 = new javax.swing.JTextField();
        Barra = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        Consola = new javax.swing.JTextArea();
        Mensaje = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);

        jLabel2.setForeground(new java.awt.Color(255, 255, 51));
        jLabel2.setText("Modulo de lectura");

        TagID1.setEditable(false);
        TagID1.setBackground(new java.awt.Color(51, 51, 51));
        TagID1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        TagID1.setForeground(new java.awt.Color(153, 153, 153));
        TagID1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TagID1.setText("00");

        TagID2.setEditable(false);
        TagID2.setBackground(new java.awt.Color(51, 51, 51));
        TagID2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        TagID2.setForeground(new java.awt.Color(153, 153, 153));
        TagID2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TagID2.setText("00");

        TagID3.setEditable(false);
        TagID3.setBackground(new java.awt.Color(51, 51, 51));
        TagID3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        TagID3.setForeground(new java.awt.Color(153, 153, 153));
        TagID3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TagID3.setText("00");

        TagID4.setEditable(false);
        TagID4.setBackground(new java.awt.Color(51, 51, 51));
        TagID4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        TagID4.setForeground(new java.awt.Color(153, 153, 153));
        TagID4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TagID4.setText("00");

        Barra.setForeground(new java.awt.Color(0, 204, 0));

        Consola.setColumns(20);
        Consola.setRows(5);
        jScrollPane1.setViewportView(Consola);

        Mensaje.setForeground(new java.awt.Color(255, 255, 51));
        Mensaje.setText("Esperando...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(TagID1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TagID2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TagID3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TagID4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Mensaje)
                        .addContainerGap(37, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(Barra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Barra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TagID1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TagID2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TagID3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TagID4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Mensaje))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Fondo.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MonitorAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MonitorAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MonitorAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MonitorAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MonitorAcceso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar Barra;
    public static javax.swing.JTextArea Consola;
    private javax.swing.JLabel Mensaje;
    private javax.swing.JTextField TagID1;
    private javax.swing.JTextField TagID2;
    private javax.swing.JTextField TagID3;
    private javax.swing.JTextField TagID4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        Send_Receive serial = new Send_Receive();
        DBQueries consulta = new DBQueries();
        LeeTexto lee=new LeeTexto();
        serial.initialize();
        Thread t=new Thread() {
            @Override
            public void run() {
                //the following line will keep this app alive for 1000 seconds,
                //waiting for events to occur and responding to them (printing incoming messages to console).
                try {
                    int i = 0;
                    while(true){
                        if(!serial.getInformation().equals("")){
                            Mensaje.setText("Validando...");
                            Barra.setValue(i);
                            i++;
                        }
                        Thread.sleep(10);
                        if(i >= 100){
                            i = 0;
                            String idCard = serial.TAG_UID[0]+serial.TAG_UID[1]+serial.TAG_UID[2]+serial.TAG_UID[3];
                            System.out.println(idCard);
                            tarjeta = consulta.verificarIDCard(idCard);
                            if(tarjeta != null){
                                Toolkit.getDefaultToolkit().beep();
                                vehiculo = consulta.getVehiculo(tarjeta.getCveEmpleado());
                                if(tarjeta.getEstado().equals("enabled")){
                                    //JOptionPane.showMessageDialog(null, "La tarjeta ha sido validada correctamente", "SCAEI", JOptionPane.INFORMATION_MESSAGE);
                                    if(vehiculo != null){
                                        consulta.insertBitacora("Entrada", vehiculo.getCveMatricula());
                                        empleado = consulta.getEmpleado(tarjeta.getCveEmpleado());
                                        if(empleado != null){
                                            Toolkit.getDefaultToolkit().beep();
                                            LeeTexto.Lee("Bienvenido "+ empleado.getPriNombre() + " " + empleado.getApePaterno());
                                            //JOptionPane.showMessageDialog(null, "Bienvenido "+ empleado.getPriNombre() + " "+empleado.getApePaterno(), "SCAEI", JOptionPane.INFORMATION_MESSAGE);
                                            consulta.insertLogs("Activo", idCard);
                                        }
                                    }
                                }else{
                                    Toolkit.getDefaultToolkit().beep();
                                    //JOptionPane.showMessageDialog(null, "La tarjeta se encuentra desactivada (contacte al administrador)", "SCAEI", JOptionPane.INFORMATION_MESSAGE);
                                    LeeTexto.Lee("La tarjeta se encuentra desactivada (contacte al administrador)");  
                                    consulta.insertLogs("Inactivo", idCard);
                                }
                            }else{
                                Toolkit.getDefaultToolkit().beep();
                                //JOptionPane.showMessageDialog(null, "La tarjeta no se encuentra registrada en el sistema", "SCAEI", JOptionPane.ERROR_MESSAGE);
                                LeeTexto.Lee("La tarjeta no se encuentra registrada en el sistema");
                                consulta.insertLogs("Error", idCard);
                            }
                            Barra.setValue(i);
                            serial.setInformation("");
                            Consola.setText("");
                            TagID1.setText(serial.TAG_UID[0]);
                            TagID2.setText(serial.TAG_UID[1]);
                            TagID3.setText(serial.TAG_UID[2]);
                            TagID4.setText(serial.TAG_UID[3]);
                            Mensaje.setText(serial.getStatusLog());
                            Thread.sleep(5000);
                            reset();
                        }//END IF(mayor 100)
                    }
                } catch (InterruptedException ie) {}
            }
        };
        t.start();
        Consola.append("Started\n");
    }//END myInit()
    
    private void reset(){
        TagID1.setText("00");
        TagID2.setText("00");
        TagID3.setText("00");
        TagID4.setText("00");
        Mensaje.setText("Esperando...");
    }
    
}//END CLASS
