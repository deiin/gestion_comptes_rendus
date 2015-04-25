package UI;
/**
 *
 * @author Dan
 */
import CONTROLLER.VisiteurController;

public class VisiteurUI extends javax.swing.JFrame {

    public VisiteurUI() {
        initComponents();
        new VisiteurController().infoVis(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        listVisiteurs = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        valider = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nomVisiteur = new javax.swing.JTextField();
        prenomVisiteur = new javax.swing.JTextField();
        adresseVisiteur = new javax.swing.JTextField();
        cpVisiteur = new javax.swing.JTextField();
        villeVisiteur = new javax.swing.JTextField();
        secteurVisiteur = new javax.swing.JComboBox();
        laboVisiteur = new javax.swing.JComboBox();
        suivant = new javax.swing.JButton();
        précédent = new javax.swing.JButton();
        fermer = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Chercher ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(25, 51, 75, 25);

        listVisiteurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listVisiteursActionPerformed(evt);
            }
        });
        getContentPane().add(listVisiteurs);
        listVisiteurs.setBounds(116, 52, 150, 25);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 3, 238));
        jLabel2.setText("VISITEURS");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(196, 11, 90, 17);

        valider.setText("OK");
        valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerActionPerformed(evt);
            }
        });
        getContentPane().add(valider);
        valider.setBounds(277, 51, 75, 25);

        jSeparator1.setForeground(new java.awt.Color(0, 102, 255));
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(25, 85, 272, 2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nom");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(25, 105, 70, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Prenom");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(25, 131, 70, 25);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Adresse");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(25, 160, 70, 25);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Ville");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(25, 186, 70, 25);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Secteur");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(25, 212, 70, 25);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Labo");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(25, 238, 70, 25);

        nomVisiteur.setEditable(false);
        nomVisiteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomVisiteurActionPerformed(evt);
            }
        });
        getContentPane().add(nomVisiteur);
        nomVisiteur.setBounds(114, 105, 150, 25);

        prenomVisiteur.setEditable(false);
        prenomVisiteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prenomVisiteurActionPerformed(evt);
            }
        });
        getContentPane().add(prenomVisiteur);
        prenomVisiteur.setBounds(114, 131, 150, 25);

        adresseVisiteur.setEditable(false);
        adresseVisiteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adresseVisiteurActionPerformed(evt);
            }
        });
        getContentPane().add(adresseVisiteur);
        adresseVisiteur.setBounds(114, 157, 150, 25);

        cpVisiteur.setEditable(false);
        getContentPane().add(cpVisiteur);
        cpVisiteur.setBounds(114, 183, 50, 25);

        villeVisiteur.setEditable(false);
        villeVisiteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                villeVisiteurActionPerformed(evt);
            }
        });
        getContentPane().add(villeVisiteur);
        villeVisiteur.setBounds(165, 183, 150, 25);

        secteurVisiteur.setEnabled(false);
        secteurVisiteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secteurVisiteurActionPerformed(evt);
            }
        });
        getContentPane().add(secteurVisiteur);
        secteurVisiteur.setBounds(114, 209, 150, 25);

        laboVisiteur.setEnabled(false);
        getContentPane().add(laboVisiteur);
        laboVisiteur.setBounds(114, 235, 150, 25);

        suivant.setText("Suivant");
        suivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suivantActionPerformed(evt);
            }
        });
        getContentPane().add(suivant);
        suivant.setBounds(230, 270, 100, 25);

        précédent.setText("Précédent");
        précédent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                précédentActionPerformed(evt);
            }
        });
        getContentPane().add(précédent);
        précédent.setBounds(110, 270, 100, 25);

        fermer.setText("Fermer");
        fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fermerActionPerformed(evt);
            }
        });
        getContentPane().add(fermer);
        fermer.setBounds(370, 270, 100, 25);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/logo2.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(-16, -16, 510, 360);

        getAccessibleContext().setAccessibleDescription("");

        setSize(new java.awt.Dimension(500, 371));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void villeVisiteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_villeVisiteurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_villeVisiteurActionPerformed

    private void fermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fermerActionPerformed
        setVisible(false);
    }//GEN-LAST:event_fermerActionPerformed

    private void listVisiteursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listVisiteursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listVisiteursActionPerformed

    private void nomVisiteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomVisiteurActionPerformed
        // Nom
    }//GEN-LAST:event_nomVisiteurActionPerformed

    private void prenomVisiteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prenomVisiteurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prenomVisiteurActionPerformed

    private void adresseVisiteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adresseVisiteurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adresseVisiteurActionPerformed

    private void précédentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_précédentActionPerformed
        new VisiteurController().visPrecedent();
    }//GEN-LAST:event_précédentActionPerformed

    private void suivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suivantActionPerformed
        new VisiteurController().visSuivant();
    }//GEN-LAST:event_suivantActionPerformed

    private void validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerActionPerformed
        new VisiteurController().infoVisSelected(listVisiteurs.getSelectedIndex());
    }//GEN-LAST:event_validerActionPerformed

    private void secteurVisiteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secteurVisiteurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secteurVisiteurActionPerformed

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
            java.util.logging.Logger.getLogger(VisiteurUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisiteurUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisiteurUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisiteurUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisiteurUI().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField adresseVisiteur;
    public static javax.swing.JTextField cpVisiteur;
    private javax.swing.JButton fermer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JComboBox laboVisiteur;
    public static javax.swing.JComboBox listVisiteurs;
    public static javax.swing.JTextField nomVisiteur;
    public static javax.swing.JTextField prenomVisiteur;
    private javax.swing.JButton précédent;
    public static javax.swing.JComboBox secteurVisiteur;
    private javax.swing.JButton suivant;
    private javax.swing.JButton valider;
    public static javax.swing.JTextField villeVisiteur;
    // End of variables declaration//GEN-END:variables

}
