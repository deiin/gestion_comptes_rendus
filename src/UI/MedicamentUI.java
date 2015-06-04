package UI;

import CONTROLLER.MedicamentController;

/**
 *
 * @author Dan
 */
public class MedicamentUI extends javax.swing.JFrame {

    private MedicamentController controller= new MedicamentController();
    
    public MedicamentUI() {
        initComponents();
        effets.setLineWrap(true);
        effets.setWrapStyleWord(true);
        contreIndication.setLineWrap(true);
        contreIndication.setWrapStyleWord(true);
        controller.infoMed(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        code = new javax.swing.JTextField();
        nom = new javax.swing.JTextField();
        composition = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        effets = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        contreIndication = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        prix = new javax.swing.JTextField();
        famille = new javax.swing.JComboBox();
        precedent = new javax.swing.JButton();
        suivant = new javax.swing.JButton();
        fermer = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 3, 238));
        jLabel1.setText("MEDICAMENTS");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(205, 11, 108, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Code");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 60, 120, 25);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nom commercial");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 88, 120, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Famille");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 119, 120, 25);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Composition");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 150, 120, 25);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Effets indésirables");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 178, 120, 25);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Contre indication");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 290, 120, 25);

        code.setEditable(false);
        getContentPane().add(code);
        code.setBounds(150, 60, 120, 25);

        nom.setEditable(false);
        getContentPane().add(nom);
        nom.setBounds(150, 90, 120, 25);

        composition.setEditable(false);
        composition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compositionActionPerformed(evt);
            }
        });
        getContentPane().add(composition);
        composition.setBounds(150, 150, 350, 25);

        jScrollPane1.setAutoscrolls(true);

        effets.setEditable(false);
        effets.setColumns(10);
        effets.setRows(5);
        effets.setAutoscrolls(false);
        effets.setMaximumSize(new java.awt.Dimension(200, 70));
        effets.setName(""); // NOI18N
        effets.setRequestFocusEnabled(false);
        effets.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(effets);
        effets.getAccessibleContext().setAccessibleName("");
        effets.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(150, 180, 350, 100);

        contreIndication.setEditable(false);
        contreIndication.setColumns(10);
        contreIndication.setRows(5);
        jScrollPane2.setViewportView(contreIndication);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(150, 290, 350, 100);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Prix échantillon");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 400, 120, 25);

        prix.setEditable(false);
        getContentPane().add(prix);
        prix.setBounds(150, 400, 60, 25);

        famille.setEnabled(false);
        getContentPane().add(famille);
        famille.setBounds(150, 120, 350, 25);

        precedent.setText("Précédent");
        precedent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precedentActionPerformed(evt);
            }
        });
        getContentPane().add(precedent);
        precedent.setBounds(170, 440, 100, 25);

        suivant.setText("Suivant");
        suivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suivantActionPerformed(evt);
            }
        });
        getContentPane().add(suivant);
        suivant.setBounds(290, 440, 100, 25);

        fermer.setText("Fermer");
        fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fermerActionPerformed(evt);
            }
        });
        getContentPane().add(fermer);
        fermer.setBounds(440, 440, 100, 25);
        getContentPane().add(jLabel9);
        jLabel9.setBounds(-80, -20, 670, 570);

        setSize(new java.awt.Dimension(586, 528));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void compositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_compositionActionPerformed

    private void fermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fermerActionPerformed
        setVisible(false);
    }//GEN-LAST:event_fermerActionPerformed

    private void precedentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precedentActionPerformed
        controller.medPrécédent();
    }//GEN-LAST:event_precedentActionPerformed

    private void suivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suivantActionPerformed
        controller.medSuivant();
    }//GEN-LAST:event_suivantActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MedicamentUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField code;
    public static javax.swing.JTextField composition;
    public static javax.swing.JTextArea contreIndication;
    public static javax.swing.JTextArea effets;
    public static javax.swing.JComboBox famille;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextField nom;
    private javax.swing.JButton precedent;
    public static javax.swing.JTextField prix;
    private javax.swing.JButton suivant;
    // End of variables declaration//GEN-END:variables
}