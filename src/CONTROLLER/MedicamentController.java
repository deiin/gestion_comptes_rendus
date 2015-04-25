package CONTROLLER;

import DAO.DAO;
import DAO.FamilleDAO;
import DAO.MedicamentDAO;
import ENTITE.Famille;
import ENTITE.Medicament;
import UI.MedicamentUI;
import static UI.MedicamentUI.code;
import static UI.MedicamentUI.composition;
import static UI.MedicamentUI.contreIndication;
import static UI.MedicamentUI.effets;
import static UI.MedicamentUI.famille;
import static UI.MedicamentUI.nom;
import static UI.MedicamentUI.prix;

/**
 *
 * @author Dan
 */
public class MedicamentController {
    
    private DAO<Medicament> medicamentDAO = new MedicamentDAO();
    private DAO<Famille> familleDAO = new FamilleDAO();
    private static int b=0;
    
    public MedicamentController(){}
    
    public void medPrécédent(){
        if(b!=0){
            b--;
            code.setText(medicamentDAO.find().get(b).getMedDepotlegal());
            nom.setText(medicamentDAO.find().get(b).getMedNomcommercial());
            composition.setText(medicamentDAO.find().get(b).getMedComposition());
            contreIndication.setText(medicamentDAO.find().get(b).getMedContreindic());
            effets.setText(medicamentDAO.find().get(b).getMedEffets());
            prix.setText(""+medicamentDAO.find().get(b).getMedPrixechantillon());
            famille.setSelectedItem(""+medicamentDAO.find().get(b).getFamCode().getFamLibelle());
        }
    }
    
    public void medSuivant(){
        if(b!=medicamentDAO.find().size()-1){
            b++;
            code.setText(medicamentDAO.find().get(b).getMedDepotlegal());
            nom.setText(medicamentDAO.find().get(b).getMedNomcommercial());
            composition.setText(medicamentDAO.find().get(b).getMedComposition());
            contreIndication.setText(medicamentDAO.find().get(b).getMedContreindic());
            effets.setText(medicamentDAO.find().get(b).getMedEffets());
            prix.setText(""+medicamentDAO.find().get(b).getMedPrixechantillon());
            famille.setSelectedItem(""+medicamentDAO.find().get(b).getFamCode().getFamLibelle());
        }
    
    }
    
    public void infoMed(int i){
        code.setText(medicamentDAO.find().get(i).getMedDepotlegal());
        nom.setText(medicamentDAO.find().get(i).getMedNomcommercial());
        composition.setText(medicamentDAO.find().get(i).getMedComposition());
        contreIndication.setText(medicamentDAO.find().get(i).getMedContreindic());
        effets.setText(medicamentDAO.find().get(i).getMedEffets());
        prix.setText(""+medicamentDAO.find().get(i).getMedPrixechantillon());

        for(int j=familleDAO.find().size()-1; j>=0; j--){
                    MedicamentUI.famille.addItem(familleDAO.find().get(j).getFamLibelle());
        }
        MedicamentUI.famille.setSelectedItem(""+medicamentDAO.find().get(i).getFamCode().getFamLibelle());
    }
    
}
