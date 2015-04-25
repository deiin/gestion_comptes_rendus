package CONTROLLER;

import DAO.DAO;
import DAO.MedicamentDAO;
import DAO.OffrirDAO;
import DAO.PraticienDAO;
import DAO.RapportVisiteDAO;
import DAO.VisiteurDAO;
import ENTITE.Medicament;
import ENTITE.Offrir;
import ENTITE.Praticien;
import ENTITE.RapportVisite;
import ENTITE.Visiteur;
import UI.MenuUI;
import UI.RapportVisiteUI;
import static UI.RapportVisiteUI.Bilan;
import static UI.RapportVisiteUI.listPraticiens;
import static UI.RapportVisiteUI.numeroRapport;
import static UI.RapportVisiteUI.dateRapport;
import static UI.RapportVisiteUI.motifVisite;
import static UI.RapportVisiteUI.dateRapport;
import static UI.RapportVisiteUI.echantillons;
import static UI.RapportVisiteUI.listPraticiens;
import static UI.RapportVisiteUI.motifVisite;
import static UI.RapportVisiteUI.numeroRapport;
import static UI.RapportVisiteUI.erreurRap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultCellEditor;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dan
 */
public class RapportVisiteController {

    private JComboBox listMedicament = new JComboBox();
    private DAO<RapportVisite> rapportVisiteDAO = new RapportVisiteDAO();
    private RapportVisite rapportVisite = new RapportVisite();
    private DAO<Offrir> offrirDAO = new OffrirDAO();
    private Offrir offrir = new Offrir();
    private DAO<Praticien> praticienDAO = new PraticienDAO();
    private Visiteur visMatricule;
    private int rapNum;
    private Praticien praNum;
    private Date rapDate;
    private String rapBilan;
    private String rapMotif;
    private Medicament medicament;
    private short qte;
    private DAO<Medicament> medicamentDAO = new MedicamentDAO();
    private static int b = 0;

    public void tabEchantillon() {
        String[] comboData = new String[medicamentDAO.find().size()];
        for (int i = 0; i <= medicamentDAO.find().size() - 1; i++) {
            comboData[i] = medicamentDAO.find().get(i).getMedNomcommercial();
        }
        String[] titre = {"Médicament", "Nb. Echantillon"};
        Object[][] data = {
            {"", ""},
            {"", ""},
            {"", ""},
            {"", ""},
            {"", ""}};
        echantillons.setModel(new DefaultTableModel(data, titre));
        JComboBox combo = new JComboBox(comboData);
        combo.setEditable(true);
        echantillons.getColumn("Médicament").setCellEditor(new DefaultCellEditor(combo));

    }

    public void rapEnregistrer() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<Offrir> offres = new ArrayList();
        Object objet = new Object();
        if(numeroRapport.getText().equals("")){
            erreurRap.setForeground(new java.awt.Color(204, 0, 0));
            erreurRap.setText("Aucun numéro de rapport, cliquer sur nouveau pour avoir un numéro");
        }
        else if(dateRapport.getText().equals("")){
            dateRapport.grabFocus();
            erreurRap.setForeground(new java.awt.Color(204, 0, 0));
            erreurRap.setText("Veuillez renseigner corectement la Date de la visite");
        }
        else if(motifVisite.getText().equals("")){
            motifVisite.grabFocus();
            erreurRap.setForeground(new java.awt.Color(204, 0, 0));
            erreurRap.setText("Veuillez renseigner corectement le Motif de la visite");
        }
        else if(Bilan.getText().equals("")){
            Bilan.grabFocus();
            erreurRap.setForeground(new java.awt.Color(204, 0, 0));
            erreurRap.setText("Veuillez renseigner corectement le Bilan de la visite");
        }else if(rapportVisiteDAO.find(Integer.parseInt(numeroRapport.getText())).getRapNum() == Integer.parseInt(numeroRapport.getText())) {
            System.out.println("OK");
            try {
                visMatricule = new VisiteurDAO().find(MenuUI.visMatricule);
                rapNum = Integer.parseInt(numeroRapport.getText());
                praNum = new PraticienDAO().find(listPraticiens.getSelectedIndex() + 1);
                rapDate = format.parse(dateRapport.getText());
                rapBilan = Bilan.getText();
                rapMotif = motifVisite.getText();
                rapportVisite = new RapportVisite(visMatricule, rapNum, praNum, rapDate, rapBilan, rapMotif);
                rapportVisiteDAO.update(rapportVisite);
                erreurRap.setForeground(new java.awt.Color(16, 107, 0));
                erreurRap.setText("Modification du rapport effectué");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            offrirDAO.delete(new Offrir(visMatricule, rapportVisiteDAO.find(rapNum), medicament, qte));
            for (int i = 0; i < echantillons.getRowCount(); i++) {
                for (int j = 0; j < echantillons.getColumnCount(); j++) {
                    String s = "" + echantillons.getValueAt(i, j);
                    if (echantillons.getColumnName(j) == "Médicament" && (s.length() > 0 && echantillons.getValueAt(i, j) != null)) {
                        medicament = medicamentDAO.find("" + echantillons.getValueAt(i, j));
                    } else if (echantillons.getColumnName(j) == "Nb. Echantillon" && (s.length() > 0 && echantillons.getValueAt(i, j) != null)) {
                        qte = (short) Integer.parseInt(s);
                    }
                }
                offrir = new Offrir(visMatricule, rapportVisiteDAO.find(rapNum), medicament, qte);
                offres.add(i, offrir);
            }
            for (int i = 0; i <= offres.size() - 1; i++) {
                offrirDAO.create(offres.get(i));
            }
        } else{
            try {
                visMatricule = new VisiteurDAO().find(MenuUI.visMatricule);
                rapNum = Integer.parseInt(numeroRapport.getText());
                praNum = new PraticienDAO().find(listPraticiens.getSelectedIndex()+1);
                rapDate = format.parse(dateRapport.getText());
                rapBilan = Bilan.getText();
                rapMotif = motifVisite.getText();
                rapportVisite = new RapportVisite(visMatricule, rapNum, praNum, rapDate, rapBilan, rapMotif);
                rapportVisiteDAO.create(rapportVisite);

            } catch (ParseException e) {
                e.printStackTrace();
            }
            erreurRap.setForeground(new java.awt.Color(16, 107, 0));
            erreurRap.setText("Enregistrement du rapport effectué");
            for (int i = 0; i < echantillons.getRowCount(); i++) {
                for (int j = 0; j < echantillons.getColumnCount(); j++) {
                    if (echantillons.getColumnName(j) == "Médicament" && echantillons.getValueAt(i, j) != "") {
                        medicament = medicamentDAO.find("" + echantillons.getValueAt(i, j));
                    } else if (echantillons.getColumnName(j) == "Nb. Echantillon" && echantillons.getValueAt(i, j) != "") {
                        qte = (short) Integer.parseInt("" + echantillons.getValueAt(i, j));
                    }
                }
                offrir = new Offrir(visMatricule, rapportVisiteDAO.find(rapNum), medicament, qte);
                offrirDAO.create(offrir);
            }
        }

    }

    public void rapNouveau() {
        int Num = rapportVisiteDAO.find().get(rapportVisiteDAO.find().size() - 1).getRapNum() + 1;
        numeroRapport.setText("" + Num);
        dateRapport.setText("");
        motifVisite.setText("");
        erreurRap.setText(" ");
        Bilan.setText("");
        listPraticiens.setSelectedIndex(0);
        for (int i = 0; i < echantillons.getRowCount(); i++) {
            for (int j = 0; j < echantillons.getColumnCount(); j++) {
                if (echantillons.getColumnName(j) == "Médicament") {
                    echantillons.setValueAt("", i, j);
                } else if (echantillons.getColumnName(j) == "Nb. Echantillon") {
                    echantillons.setValueAt("", i, j);
                }
            }
        }

    }

    public void rapPrecedent() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        erreurRap.setText(" ");
        if (b != 0) {
            b--;
            numeroRapport.setText("" + rapportVisiteDAO.find().get(b).getRapNum());
            dateRapport.setText(format.format(rapportVisiteDAO.find().get(b).getRapDate()));
            motifVisite.setText(rapportVisiteDAO.find().get(b).getRapMotif());
            Bilan.setText(rapportVisiteDAO.find().get(b).getRapBilan());
            listPraticiens.setSelectedItem(rapportVisiteDAO.find().get(b).getPraNum().getPraNom() + " " + rapportVisiteDAO.find().get(b).getPraNum().getPraPrenom());

            for (int i = 0; i < echantillons.getRowCount(); i++) {
                for (int j = 0; j < echantillons.getColumnCount(); j++) {
                    if (echantillons.getColumnName(j) == "Médicament") {
                        echantillons.setValueAt("", i, j);
                    } else if (echantillons.getColumnName(j) == "Nb. Echantillon") {
                        echantillons.setValueAt("", i, j);
                    }
                }
            }

            for (int i = 0; i < echantillons.getRowCount(); i++) {
                for (int j = 0; j < echantillons.getColumnCount(); j++) {
                    if (echantillons.getColumnName(j) == "Médicament") {
                        echantillons.setValueAt(offrirDAO.findOffre(rapportVisiteDAO.find().get(b).getVisMatricule().getVisMatricule(), rapportVisiteDAO.find().get(b).getRapNum()).get(i).getMedDepotlegal().getMedNomcommercial(), i, j);
                    } else if (echantillons.getColumnName(j) == "Nb. Echantillon") {
                        echantillons.setValueAt(offrirDAO.findOffre(rapportVisiteDAO.find().get(b).getVisMatricule().getVisMatricule(), rapportVisiteDAO.find().get(b).getRapNum()).get(i).getOffQte(), i, j);
                    }
                }
            }
        }
    }

    public void rapSuivant() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        erreurRap.setText(" ");
        if (b != rapportVisiteDAO.find().size() - 1) {
            b++;
            numeroRapport.setText("" + rapportVisiteDAO.find().get(b).getRapNum());
            dateRapport.setText(format.format(rapportVisiteDAO.find().get(b).getRapDate()));
            motifVisite.setText(rapportVisiteDAO.find().get(b).getRapMotif());
            Bilan.setText(rapportVisiteDAO.find().get(b).getRapBilan());
            listPraticiens.setSelectedItem(rapportVisiteDAO.find().get(b).getPraNum().getPraNom() + " " + rapportVisiteDAO.find().get(b).getPraNum().getPraPrenom());

            for (int i = 0; i < echantillons.getRowCount(); i++) {
                for (int j = 0; j < echantillons.getColumnCount(); j++) {
                    if (echantillons.getColumnName(j) == "Médicament") {
                        echantillons.setValueAt("", i, j);
                    } else if (echantillons.getColumnName(j) == "Nb. Echantillon") {
                        echantillons.setValueAt("", i, j);
                    }
                }
            }

            for (int i = 0; i < echantillons.getRowCount(); i++) {
                for (int j = 0; j < echantillons.getColumnCount(); j++) {
                    echantillons.setValueAt("", i, j);
                    if (echantillons.getColumnName(j) == "Médicament") {
                        echantillons.setValueAt(offrirDAO.findOffre(rapportVisiteDAO.find().get(b).getVisMatricule().getVisMatricule(), rapportVisiteDAO.find().get(b).getRapNum()).get(i).getMedDepotlegal().getMedNomcommercial(), i, j);
                    } else if (echantillons.getColumnName(j) == "Nb. Echantillon") {
                        echantillons.setValueAt(offrirDAO.findOffre(rapportVisiteDAO.find().get(b).getVisMatricule().getVisMatricule(), rapportVisiteDAO.find().get(b).getRapNum()).get(i).getOffQte(), i, j);
                    }
                }
            }
        }
    }

    public void infoRap() {
        for (int j = 1; j <= praticienDAO.find().size() - 1; j++) {
            listPraticiens.addItem(praticienDAO.find(j).getPraNom() + " " + praticienDAO.find(j).getPraPrenom());
        }
    }

}
