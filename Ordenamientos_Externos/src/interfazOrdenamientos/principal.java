package interfazOrdenamientos;

import ordenacionBalanceada.OrdBalanceada;
import ordenacionDirecta.OrdDirecta;
import ordenacionNatural.OrdNatural;
import ordenacionPolifase.OrdPolifasica;
import java.awt.Color;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class principal extends javax.swing.JFrame {

    private OrdNatural natural;
    private OrdDirecta directa;
    private OrdBalanceada balanceada;
    private OrdPolifasica polifase;
    private long time_start, time_end;
    
    public principal() {
        initComponents();
        this.getContentPane().setBackground(new Color(0, 153, 153));
        setLocationRelativeTo(null);
        setTitle("Programación III");
        natural = new OrdNatural();
        directa = new OrdDirecta();
        balanceada = new OrdBalanceada();
        polifase = new OrdPolifasica(); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        DirectaSort = new javax.swing.JButton();
        NaturalSort = new javax.swing.JButton();
        BalanceadaSort = new javax.swing.JButton();
        PolifasicaSort = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        FileName = new javax.swing.JTextField();
        Campo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));
        setMaximumSize(new java.awt.Dimension(725, 419));
        setMinimumSize(new java.awt.Dimension(725, 419));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(21, 67, 96));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setRequestFocusEnabled(false);

        jPanel2.setBackground(new java.awt.Color(127, 179, 213));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ordenamientos \nExternos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Verdana", 0, 36))); // NOI18N

        DirectaSort.setBackground(new java.awt.Color(255, 204, 153));
        DirectaSort.setFont(new java.awt.Font("Verdana", 0, 25)); // NOI18N
        DirectaSort.setText("Directa");
        DirectaSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DirectaSortActionPerformed(evt);
            }
        });

        NaturalSort.setBackground(new java.awt.Color(179, 255, 104));
        NaturalSort.setFont(new java.awt.Font("Verdana", 0, 25)); // NOI18N
        NaturalSort.setText("Natural");
        NaturalSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NaturalSortActionPerformed(evt);
            }
        });

        BalanceadaSort.setBackground(new java.awt.Color(201, 201, 255));
        BalanceadaSort.setFont(new java.awt.Font("Verdana", 0, 25)); // NOI18N
        BalanceadaSort.setText("Balanceada");
        BalanceadaSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BalanceadaSortActionPerformed(evt);
            }
        });

        PolifasicaSort.setBackground(new java.awt.Color(255, 255, 153));
        PolifasicaSort.setFont(new java.awt.Font("Verdana", 0, 25)); // NOI18N
        PolifasicaSort.setText("Polifasica");
        PolifasicaSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PolifasicaSortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DirectaSort)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NaturalSort)
                .addGap(18, 18, 18)
                .addComponent(BalanceadaSort)
                .addGap(18, 18, 18)
                .addComponent(PolifasicaSort)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DirectaSort, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NaturalSort, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BalanceadaSort, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PolifasicaSort, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(41, 128, 185));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ordenamiento de archivos");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre del Archivo: ");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Escoga el campo a ordenar: ");

        FileName.setBackground(new java.awt.Color(127, 179, 213));
        FileName.setFont(new java.awt.Font("Verdana", 0, 25)); // NOI18N
        FileName.setForeground(new java.awt.Color(255, 255, 255));
        FileName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        Campo.setBackground(new java.awt.Color(255, 204, 153));
        Campo.setFont(new java.awt.Font("Verdana", 0, 25)); // NOI18N
        Campo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entero", "String", "Booleano", "Date" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(FileName)
                                    .addComponent(Campo, 0, 196, Short.MAX_VALUE))
                                .addGap(9, 9, 9))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FileName, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Campo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jPanel2.getAccessibleContext().setAccessibleName("Tipos de ordenamientos externos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Long enBytes(long valor)
    {
        return new Long(valor / 1024);
    }
    
    private void DirectaSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DirectaSortActionPerformed
        String tiempo_directa = "";
        try {
            time_start = System.currentTimeMillis();
            directa.sort(Campo.getSelectedIndex(), FileName.getText());
            time_end = System.currentTimeMillis();
            tiempo_directa = (String.valueOf((time_end-time_start)/1000)+" segundos");
            JOptionPane.showMessageDialog(new JFrame(),"   ARCHIVO ORDENADO  "+"\n"+" El tiempo es : "+tiempo_directa);
            FileName.setText("");
        } catch (IOException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(new JFrame(), "El archivo no existe!");
        } catch (ParseException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DirectaSortActionPerformed

    private void NaturalSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NaturalSortActionPerformed
        String tiempo_natural = "";
        try {
            time_start = System.currentTimeMillis();
            natural.sort(Campo.getSelectedIndex(), FileName.getText());
            time_end = System.currentTimeMillis();
            tiempo_natural = (String.valueOf((time_end-time_start)/1000)+" segundos");
            JOptionPane.showMessageDialog(new JFrame(),"   ARCHIVO ORDENADO  "+"\n"+" El tiempo es : "+tiempo_natural);
            FileName.setText("");
        } catch (IOException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(new JFrame(), "El archivo no existe!");
        } catch (ParseException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_NaturalSortActionPerformed

    private void BalanceadaSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BalanceadaSortActionPerformed
        String tiempo_balanceada = "";
        try {
            time_start = System.currentTimeMillis();
            balanceada.sort(Campo.getSelectedIndex(), FileName.getText());
            time_end = System.currentTimeMillis();
            tiempo_balanceada = (String.valueOf((time_end-time_start)/1000)+" segundos");
            JOptionPane.showMessageDialog(new JFrame(),"   ARCHIVO ORDENADO  "+"\n"+" El tiempo es : "+tiempo_balanceada);
            FileName.setText("");
        } catch (IOException ex) { 
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(new JFrame(), "El archivo no existe");
        } catch (ParseException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BalanceadaSortActionPerformed

    private void PolifasicaSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PolifasicaSortActionPerformed
        String tiempo_polifase = "";
        try {
            time_start = System.currentTimeMillis();
            polifase.sort(Campo.getSelectedIndex(), FileName.getText());
            time_end = System.currentTimeMillis();
            tiempo_polifase = (String.valueOf((time_end-time_start)/1000)+" segundos");
            JOptionPane.showMessageDialog(new JFrame(),"   ARCHIVO ORDENADO  "+"\n"+" El tiempo es : "+tiempo_polifase);
            FileName.setText("");
        } catch (IOException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(new JFrame(), "El archivo no existe!");
        } catch (ParseException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PolifasicaSortActionPerformed

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
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BalanceadaSort;
    private javax.swing.JComboBox<String> Campo;
    private javax.swing.JButton DirectaSort;
    private javax.swing.JTextField FileName;
    private javax.swing.JButton NaturalSort;
    private javax.swing.JButton PolifasicaSort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
