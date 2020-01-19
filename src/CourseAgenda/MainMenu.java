/*
 * ICS4U Summative
 * Course Planner
 * Main Menu
 */
package CourseAgenda;

import java.awt.Dialog;
import javax.swing.JDialog;

/**
 *
 * @author S332679695
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    
    private Agenda Agenda;
    
    public MainMenu() {
        initComponents();
        Agenda = new Agenda();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Overview = new javax.swing.JButton();
        ShowAgenda = new javax.swing.JButton();
        MenuTitle = new javax.swing.JLabel();
        Company = new javax.swing.JLabel();

        jButton4.setBackground(new java.awt.Color(0, 102, 255));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        Overview.setBackground(new java.awt.Color(0, 102, 255));
        Overview.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        Overview.setForeground(new java.awt.Color(255, 255, 255));
        Overview.setText("Overview");
        Overview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OverviewActionPerformed(evt);
            }
        });

        ShowAgenda.setBackground(new java.awt.Color(0, 102, 255));
        ShowAgenda.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        ShowAgenda.setForeground(new java.awt.Color(255, 255, 255));
        ShowAgenda.setText("Agenda");
        ShowAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowAgendaActionPerformed(evt);
            }
        });

        MenuTitle.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        MenuTitle.setForeground(new java.awt.Color(255, 255, 255));
        MenuTitle.setText("Course Planner");

        Company.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Company.setText("by STCsoftware");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(Overview)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ShowAgenda)
                .addGap(97, 97, 97))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(MenuTitle)
                .addContainerGap(117, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Company)
                .addGap(175, 175, 175))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(MenuTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Company, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Overview)
                    .addComponent(ShowAgenda))
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    // when overview button is clicked
    private void OverviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OverviewActionPerformed
        JDialog jd = new JDialog();
        Overview overview = new Overview(Agenda);
        jd.setTitle("Overview");
        jd.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        jd.add(overview);
        jd.pack();
        jd.setLocationRelativeTo(null);
        jd.setVisible(true);
    }//GEN-LAST:event_OverviewActionPerformed

    // when agenda button is clicked
    private void ShowAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowAgendaActionPerformed
        JDialog jd = new JDialog();
        AgendaForm agendaUI = new AgendaForm(Agenda);
        jd.setTitle("Agenda");
        jd.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        jd.add(agendaUI);
        jd.pack();
        jd.setLocationRelativeTo(null);
        jd.setVisible(true);
    }//GEN-LAST:event_ShowAgendaActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Company;
    private javax.swing.JLabel MenuTitle;
    private javax.swing.JButton Overview;
    private javax.swing.JButton ShowAgenda;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
