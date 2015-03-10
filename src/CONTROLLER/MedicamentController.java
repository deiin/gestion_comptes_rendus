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
import java.util.ArrayList;
/**
 *
 * @author Dan
 */
public class MedicamentController {
    
    private ArrayList<Medicament> med = new MedicamentDAO().find();
    private ArrayList<Famille> fam = new FamilleDAO().find();
    private static int b=0;
    
    public MedicamentController(){}
    
    public void medPrécédent(){
        if(b!=0){
            b--;
            code.setText(med.get(b).getMedDepotlegal());
            nom.setText(med.get(b).getMedNomcommercial());
            composition.setText(med.get(b).getMedComposition());
            contreIndication.setText(med.get(b).getMedContreindic());
            effets.setText(med.get(b).getMedEffets());
            prix.setText(""+med.get(b).getMedPrixechantillon());
            famille.setSelectedItem(""+med.get(b).getFamCode().getFamLibelle());
        }
    }
    
    public void medSuivant(){
        if(b!=med.size()-1){
            b++;
            code.setText(med.get(b).getMedDepotlegal());
            nom.setText(med.get(b).getMedNomcommercial());
            composition.setText(med.get(b).getMedComposition());
            contreIndication.setText(med.get(b).getMedContreindic());
            effets.setText(med.get(b).getMedEffets());
            prix.setText(""+med.get(b).getMedPrixechantillon());
            famille.setSelectedItem(""+med.get(b).getFamCode().getFamLibelle());
        }
    
    }
    
    public void infoMed(int i){
        code.setText(med.get(i).getMedDepotlegal());
        nom.setText(med.get(i).getMedNomcommercial());
        composition.setText(med.get(i).getMedComposition());
        contreIndication.setText(med.get(i).getMedContreindic());
        effets.setText(med.get(i).getMedEffets());
        prix.setText(""+med.get(i).getMedPrixechantillon());

        for(int j=fam.size()-1; j>=0; j--){
                    MedicamentUI.famille.addItem(fam.get(j).getFamLibelle());
        }
        MedicamentUI.famille.setSelectedItem(""+med.get(i).getFamCode().getFamLibelle());
    }
    
}
