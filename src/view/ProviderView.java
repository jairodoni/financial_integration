/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ProviderController;
import dao.DBException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jairo
 */


public class ProviderView extends javax.swing.JFrame {

    /**
     * Creates new form ProviderView
     */
    private ProviderController controlador;
    
    public ProviderView() throws DBException {
        initComponents();
        
        this.setLocationRelativeTo(null);

        this.controlador = new ProviderController();

        preencheTabela();
    }

    
    public void preencheTabela() {
        for (int i = 0; i < this.controlador.getProviderList().size(); i++) {

            ((DefaultTableModel) this.ProviderTable.getModel()).addRow(
                    new Object[]{
                        this.controlador.getProviderList().get(i).getCompany_name(),
                        this.controlador.getProviderList().get(i).getTrade_name(),
                        this.controlador.getProviderList().get(i).getCnpj(),
                        this.controlador.getProviderList().get(i).getPhone(),
                        this.controlador.getProviderList().get(i).getEmail(),
                  }
            );
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ProviderTable = new javax.swing.JTable();
        ButtonBack = new javax.swing.JToggleButton();
        Title = new javax.swing.JLabel();
        Importar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panel");
        setResizable(false);

        ProviderTable.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        ProviderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Razão Social", "Nome Fantasia", "CNPJ", "Telefone", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ProviderTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(ProviderTable);
        if (ProviderTable.getColumnModel().getColumnCount() > 0) {
            ProviderTable.getColumnModel().getColumn(0).setResizable(false);
            ProviderTable.getColumnModel().getColumn(4).setResizable(false);
        }

        ButtonBack.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        ButtonBack.setText("Voltar");
        ButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBackActionPerformed(evt);
            }
        });

        Title.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        Title.setText("Fornecedores:");

        Importar.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        Importar.setText("Importar");
        Importar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(Title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(ButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Importar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(Title)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonBack)
                    .addComponent(Importar))
                .addGap(19, 19, 19))
        );

        setSize(new java.awt.Dimension(972, 550));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBackActionPerformed
        FMenu menuScreen  = new FMenu();
        
        menuScreen.setVisible(true);
        dispose();
    }//GEN-LAST:event_ButtonBackActionPerformed

    private void ImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportarActionPerformed
       try {
            this.controlador.importarDados();
            JOptionPane.showMessageDialog(rootPane, "Fornecedores importados com sucesso");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao importar");
            Logger.getLogger(ClientView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ImportarActionPerformed

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
            java.util.logging.Logger.getLogger(ProviderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProviderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProviderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProviderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ProviderView().setVisible(true);
                } catch (DBException ex) {
                    Logger.getLogger(ProviderView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ButtonBack;
    private javax.swing.JToggleButton Importar;
    private javax.swing.JTable ProviderTable;
    private javax.swing.JLabel Title;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
