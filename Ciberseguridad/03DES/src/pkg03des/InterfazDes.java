package pkg03des;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class InterfazDes extends javax.swing.JFrame {

    Funciones call = new Funciones();
    
    public InterfazDes() {
        initComponents();
        this.setLocationRelativeTo(null);
        rutacifrar.setEditable(false);
        rutadescifrado.setEditable(false);
        resultado.setEditable(false);
        jfc = new javax.swing.JFileChooser();
        jfd = new javax.swing.JFileChooser();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cargartxt1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cargartxt2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        rutadescifrado = new javax.swing.JTextField();
        rutacifrar = new javax.swing.JTextField();
        cifrarbutton = new javax.swing.JButton();
        descifrarbutton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        rutacifrar1 = new javax.swing.JTextField();
        abrircifrado = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultado = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Carga el archivo a cifrar (.txt)");

        cargartxt1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cargartxt1.setForeground(new java.awt.Color(102, 102, 102));
        cargartxt1.setText("Cargar .txt");
        cargartxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargartxt1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CIFRADO Y DESCIFRADO DES");

        cargartxt2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cargartxt2.setForeground(new java.awt.Color(102, 102, 102));
        cargartxt2.setText("Cargar .txt");
        cargartxt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargartxt2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Carga el archivo a descifrar (.txt)");

        rutadescifrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rutadescifradoActionPerformed(evt);
            }
        });

        cifrarbutton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cifrarbutton.setForeground(new java.awt.Color(102, 102, 102));
        cifrarbutton.setText("Cifrar");
        cifrarbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cifrarbuttonActionPerformed(evt);
            }
        });

        descifrarbutton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descifrarbutton.setForeground(new java.awt.Color(102, 102, 102));
        descifrarbutton.setText("Descifrar");
        descifrarbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descifrarbuttonActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        abrircifrado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        abrircifrado.setForeground(new java.awt.Color(102, 102, 102));
        abrircifrado.setText("Abrir");
        abrircifrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrircifradoActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(resultado);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rutacifrar1)
                                        .addGap(56, 56, 56))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(91, 91, 91)
                                        .addComponent(abrircifrado, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rutacifrar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cargartxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rutadescifrado, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cargartxt2)))
                        .addGap(59, 59, 59))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(cifrarbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(descifrarbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cargartxt1)
                            .addComponent(cargartxt2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rutacifrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rutadescifrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cifrarbutton)
                            .addComponent(descifrarbutton)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(rutacifrar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(abrircifrado)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargartxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargartxt1ActionPerformed
        jfc.showOpenDialog(this);
        File archivocif = jfc.getSelectedFile();
        if(archivocif != null){
            rutacifrar.setText(archivocif.getAbsolutePath());
            
        }
    }//GEN-LAST:event_cargartxt1ActionPerformed
    
    private void cargartxt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargartxt2ActionPerformed
        jfc.showOpenDialog(this);
        File archivodcif = jfc.getSelectedFile();
        if(archivodcif != null){
            rutadescifrado.setText(archivodcif.getAbsolutePath());
        }
    }//GEN-LAST:event_cargartxt2ActionPerformed

    private void rutadescifradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rutadescifradoActionPerformed

    }//GEN-LAST:event_rutadescifradoActionPerformed

    private void cifrarbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cifrarbuttonActionPerformed
        try {
        // Obtener la ruta del archivo seleccionado
        String rutaArchivo = rutacifrar.getText();
        
        if (rutaArchivo != null && !rutaArchivo.isEmpty()) {
            File archivocif = new File(rutaArchivo);
            if (!archivocif.exists()) {
                jTextArea1.setText("Error: El archivo seleccionado no existe.");
                return;
            }
            
            // Pasar el archivo a la función ciFrar
            String rutaArchivoCifrado = Funciones.ciFrar(archivocif);
            
            // Mostrar resultado o mensaje de éxito
            jTextArea1.setText("Archivo cifrado correctamente.\nArchivo cifrado guardado en: " + rutaArchivoCifrado);
            rutacifrar1.setText(rutaArchivoCifrado);
        } else {
            jTextArea1.setText("Error: No has seleccionado ningún archivo para cifrar.");
        }
    } catch (Exception e) {
        // Maneja la excepción, muestra mensaje de error
        jTextArea1.setText("Error durante el cifrado: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_cifrarbuttonActionPerformed

    private void descifrarbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descifrarbuttonActionPerformed
        try {
        // Obtener la ruta del archivo seleccionado
        String rutaArchivo = rutadescifrado.getText();
        
        if (rutaArchivo != null && !rutaArchivo.isEmpty()) {
            File archivodcif = new File(rutaArchivo);
            if (!archivodcif.exists()) {
                jTextArea1.setText("Error: El archivo seleccionado no existe.");
                return;
            }
            
            // Pasar el archivo a la función desCifrar
            String rutaArchivoDescifrado = Funciones.desCifrar(archivodcif);
            
            // Mostrar resultado o mensaje de éxito
            jTextArea1.setText("Archivo descifrado correctamente.\nArchivo descifrado guardado en: " + rutaArchivoDescifrado);
        } else {
            jTextArea1.setText("Error: No has seleccionado ningún archivo para descifrar.");
        }
    } catch (Exception e) {
        // Maneja la excepción, muestra mensaje de error
        jTextArea1.setText("Error durante el descifrado: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_descifrarbuttonActionPerformed

    private void abrircifradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrircifradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_abrircifradoActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazDes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazDes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazDes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazDes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(InterfazDes.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(InterfazDes.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(InterfazDes.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(InterfazDes.class.getName()).log(Level.SEVERE, null, ex);
                }
                new InterfazDes().setVisible(true);
            }
        });
    }
    private javax.swing.JFileChooser jfc;
    private javax.swing.JFileChooser jfd;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrircifrado;
    private javax.swing.JButton cargartxt1;
    private javax.swing.JButton cargartxt2;
    private javax.swing.JButton cifrarbutton;
    private javax.swing.JButton descifrarbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane resultado;
    private javax.swing.JTextField rutacifrar;
    private javax.swing.JTextField rutacifrar1;
    private javax.swing.JTextField rutadescifrado;
    // End of variables declaration//GEN-END:variables
}

