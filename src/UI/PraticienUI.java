package UI;

import CONTROLLER.PraticienController;
/**
 *
 * @author Dan
 */
public class PraticienUI extends javax.swing.JFrame {
    private PraticienController controller=new PraticienController();
    /**
     * Creates new form Praticien
     */
    public PraticienUI() {
        initComponents();
        controller.infoPra(0);
    }
    
    public PraticienUI(int Pra){
        initComponents();
        controller.infoPra(0);
        controller.infoPraSelected(Pra);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        listPraticien = new javax.swing.JComboBox();
        valider = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        numeroPraticien = new javax.swing.JTextField();
        nomPraticien = new javax.swing.JTextField();
        prenomPraticien = new javax.swing.JTextField();
        adressePraticien = new javax.swing.JTextField();
        cpPraticien = new javax.swing.JTextField();
        villePraticien = new javax.swing.JTextField();
        coeffNot = new javax.swing.JTextField();
        lieuExercice = new javax.swing.JComboBox();
        precedent = new javax.swing.JButton();
        suivant = new javax.swing.JButton();
        fermer = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Chercher");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 40, 100, 25);

        getContentPane().add(listPraticien);
        listPraticien.setBounds(160, 40, 150, 25);

        valider.setText("OK");
        valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerActionPerformed(evt);
            }
        });
        getContentPane().add(valider);
        valider.setBounds(320, 40, 75, 25);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 3, 238));
        jLabel2.setText("PATRICIENS");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(206, 11, 100, 18);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Numéro");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 89, 70, 25);

        jSeparator1.setForeground(new java.awt.Color(0, 102, 255));
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(10, 74, 367, 10);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Nom");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(11, 120, 70, 25);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Prenom");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(11, 151, 70, 25);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Adresse");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(11, 177, 70, 25);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Ville");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(11, 203, 70, 25);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Coeff. Notoriété");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(11, 229, 120, 25);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Lieu d'exercice");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(11, 255, 120, 25);

        numeroPraticien.setEditable(false);
        numeroPraticien.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        getContentPane().add(numeroPraticien);
        numeroPraticien.setBounds(161, 86, 150, 25);

        nomPraticien.setEditable(false);
        nomPraticien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomPraticienActionPerformed(evt);
            }
        });
        getContentPane().add(nomPraticien);
        nomPraticien.setBounds(161, 117, 150, 25);

        prenomPraticien.setEditable(false);
        getContentPane().add(prenomPraticien);
        prenomPraticien.setBounds(161, 148, 150, 25);

        adressePraticien.setEditable(false);
        getContentPane().add(adressePraticien);
        adressePraticien.setBounds(161, 174, 150, 25);

        cpPraticien.setEditable(false);
        getContentPane().add(cpPraticien);
        cpPraticien.setBounds(161, 200, 50, 25);

        villePraticien.setEditable(false);
        getContentPane().add(villePraticien);
        villePraticien.setBounds(212, 200, 150, 25);

        coeffNot.setEditable(false);
        coeffNot.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        getContentPane().add(coeffNot);
        coeffNot.setBounds(161, 226, 150, 25);

        lieuExercice.setEnabled(false);
        getContentPane().add(lieuExercice);
        lieuExercice.setBounds(161, 252, 150, 25);

        precedent.setText("Précédent");
        precedent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precedentActionPerformed(evt);
            }
        });
        getContentPane().add(precedent);
        precedent.setBounds(80, 300, 100, 25);

        suivant.setText("Suivant");
        suivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suivantActionPerformed(evt);
            }
        });
        getContentPane().add(suivant);
        suivant.setBounds(210, 300, 100, 25);

        fermer.setText("Fermer");
        fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fermerActionPerformed(evt);
            }
        });
        getContentPane().add(fermer);
        fermer.setBounds(370, 300, 100, 25);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/logo2.jpg"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(-10, -6, 510, 370);

        setSize(new java.awt.Dimension(502, 386));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fermerActionPerformed
        setVisible(false);
    }//GEN-LAST:event_fermerActionPerformed

    private void suivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suivantActionPerformed
       controller.praSuivant();
    }//GEN-LAST:event_suivantActionPerformed

    private void precedentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precedentActionPerformed
       controller.praPrécédent();
    }//GEN-LAST:event_precedentActionPerformed

    private void validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerActionPerformed
        controller.infoPraSelected(listPraticien.getSelectedIndex());
    }//GEN-LAST:event_validerActionPerformed

    private void nomPraticienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomPraticienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomPraticienActionPerformed

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
            java.util.logging.Logger.getLogger(PraticienUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PraticienUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PraticienUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PraticienUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PraticienUI().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField adressePraticien;
    public static javax.swing.JTextField coeffNot;
    public static javax.swing.JTextField cpPraticien;
    private javax.swing.JButton fermer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JComboBox lieuExercice;
    public static javax.swing.JComboBox listPraticien;
    public static javax.swing.JTextField nomPraticien;
    public static javax.swing.JTextField numeroPraticien;
    private javax.swing.JButton precedent;
    public static javax.swing.JTextField prenomPraticien;
    private javax.swing.JButton suivant;
    private javax.swing.JButton valider;
    public static javax.swing.JTextField villePraticien;
    // End of variables declaration//GEN-END:variables

}
