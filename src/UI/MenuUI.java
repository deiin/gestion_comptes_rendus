package UI;

import DAO.VisiteurDAO;
import ENTITE.Visiteur;
import DAO.DAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MenuUI extends javax.swing.JFrame {
    private DAO<Visiteur> visiteurDAO = new VisiteurDAO();
    public static String visMatricule;

    public MenuUI() {
        initComponents();
    }
    public MenuUI(String login, Date date){
        initComponents();
        this.visMatricule=visiteurDAO.find(login, date).getVisMatricule();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rapport = new javax.swing.JButton();
        visiteurs = new javax.swing.JButton();
        praticiens = new javax.swing.JButton();
        medicaments = new javax.swing.JButton();
        quitter = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        rapport.setMaximumSize(new java.awt.Dimension(40, 10));
        rapport.setMinimumSize(new java.awt.Dimension(40, 10));
        rapport.setPreferredSize(new java.awt.Dimension(40, 10));
        rapport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rapportActionPerformed(evt);
            }
        });
        getContentPane().add(rapport);
        rapport.setBounds(290, 100, 25, 25);

        visiteurs.setMaximumSize(new java.awt.Dimension(40, 10));
        visiteurs.setMinimumSize(new java.awt.Dimension(40, 10));
        visiteurs.setPreferredSize(new java.awt.Dimension(40, 10));
        visiteurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visiteursActionPerformed(evt);
            }
        });
        getContentPane().add(visiteurs);
        visiteurs.setBounds(290, 130, 25, 25);

        praticiens.setMaximumSize(new java.awt.Dimension(40, 10));
        praticiens.setMinimumSize(new java.awt.Dimension(40, 10));
        praticiens.setPreferredSize(new java.awt.Dimension(40, 10));
        praticiens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                praticiensActionPerformed(evt);
            }
        });
        getContentPane().add(praticiens);
        praticiens.setBounds(290, 160, 25, 25);

        medicaments.setMaximumSize(new java.awt.Dimension(40, 10));
        medicaments.setMinimumSize(new java.awt.Dimension(40, 10));
        medicaments.setPreferredSize(new java.awt.Dimension(40, 10));
        medicaments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicamentsActionPerformed(evt);
            }
        });
        getContentPane().add(medicaments);
        medicaments.setBounds(290, 190, 25, 25);

        quitter.setMaximumSize(new java.awt.Dimension(40, 10));
        quitter.setMinimumSize(new java.awt.Dimension(40, 10));
        quitter.setPreferredSize(new java.awt.Dimension(40, 10));
        quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterActionPerformed(evt);
            }
        });
        getContentPane().add(quitter);
        quitter.setBounds(290, 220, 25, 25);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Comptes-rendus");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(330, 100, 120, 25);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Visiteurs");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(330, 130, 120, 25);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Praticiens");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(330, 160, 120, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Medicaments");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(330, 190, 120, 25);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Quitter");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(330, 220, 120, 25);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Gestion des comptes rendus");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(190, 24, 204, 34);

        jPanel1.setBackground(new java.awt.Color(51, 106, 154));
        jPanel1.setLayout(null);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/logo3.jpg"))); // NOI18N
        jPanel1.add(jLabel7);
        jLabel7.setBounds(70, 110, 100, 70);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-20, 0, 230, 350);

        jPanel2.setBackground(new java.awt.Color(51, 106, 154));
        jPanel2.setLayout(null);
        getContentPane().add(jPanel2);
        jPanel2.setBounds(-20, -20, 690, 90);

        setSize(new java.awt.Dimension(612, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void visiteursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visiteursActionPerformed
                new VisiteurUI().setVisible(true);
    }//GEN-LAST:event_visiteursActionPerformed

    private void rapportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rapportActionPerformed
                new RapportVisiteUI().setVisible(true);
    }//GEN-LAST:event_rapportActionPerformed

    private void praticiensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_praticiensActionPerformed
                new PraticienUI().setVisible(true);
    }//GEN-LAST:event_praticiensActionPerformed

    private void medicamentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicamentsActionPerformed
                new MedicamentUI().setVisible(true);
    }//GEN-LAST:event_medicamentsActionPerformed

    private void quitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterActionPerformed
                setVisible(false);
                System.exit(0);
    }//GEN-LAST:event_quitterActionPerformed

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
            java.util.logging.Logger.getLogger(MenuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton medicaments;
    private javax.swing.JButton praticiens;
    private javax.swing.JButton quitter;
    private javax.swing.JButton rapport;
    private javax.swing.JButton visiteurs;
    // End of variables declaration//GEN-END:variables

}
