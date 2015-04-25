package CONTROLLER;

import DAO.DAO;
import DAO.PraticienDAO;
import DAO.TypePraticienDAO;
import ENTITE.Praticien;
import ENTITE.TypePraticien;
import static UI.PraticienUI.adressePraticien;
import static UI.PraticienUI.coeffNot;
import static UI.PraticienUI.cpPraticien;
import static UI.PraticienUI.lieuExercice;
import static UI.PraticienUI.listPraticien;
import static UI.PraticienUI.nomPraticien;
import static UI.PraticienUI.numeroPraticien;
import static UI.PraticienUI.prenomPraticien;
import static UI.PraticienUI.villePraticien;

/**
 *
 * @author Dan
 */
public class PraticienController {
    
    private DAO<TypePraticien> typePraticienDAO = new TypePraticienDAO();
    private DAO<Praticien> praticienDAO = new PraticienDAO();
    private static int b=0;
    private static int n=0;
    public PraticienController(){}
    
    
    public void praSuivant(){
        if(b!=praticienDAO.find().size()-1){
            b++;
            n++;
            numeroPraticien.setText(""+praticienDAO.find().get(b).getPraNum());
            nomPraticien.setText(praticienDAO.find().get(b).getPraNom());
            prenomPraticien.setText(praticienDAO.find().get(b).getPraPrenom());
            adressePraticien.setText(praticienDAO.find().get(b).getPraAdresse());
            cpPraticien.setText(praticienDAO.find().get(b).getPraCp());
            villePraticien.setText(praticienDAO.find().get(b).getPraVille());
            coeffNot.setText(""+praticienDAO.find().get(b).getPraCoefnotoriete());
            listPraticien.setSelectedIndex(n);
            lieuExercice.setSelectedItem(""+praticienDAO.find().get(b).getTypCode().getTypLieu());   
        }
    
    }
    
    public void praPrécédent(){
        if(b!=0){
                b--;
                n--;
                numeroPraticien.setText(""+praticienDAO.find().get(b).getPraNum());
                nomPraticien.setText(praticienDAO.find().get(b).getPraNom());
                prenomPraticien.setText(praticienDAO.find().get(b).getPraPrenom());
                adressePraticien.setText(praticienDAO.find().get(b).getPraAdresse());
                cpPraticien.setText(praticienDAO.find().get(b).getPraCp());
                villePraticien.setText(praticienDAO.find().get(b).getPraVille());
                coeffNot.setText(""+praticienDAO.find().get(b).getPraCoefnotoriete());
                listPraticien.setSelectedIndex(n);
                lieuExercice.setSelectedItem(""+praticienDAO.find().get(b).getTypCode().getTypLieu());
        }
    }
    
    public void infoPra(int i){
        numeroPraticien.setText(""+praticienDAO.find().get(i).getPraNum());
        nomPraticien.setText(praticienDAO.find().get(i).getPraNom());
        prenomPraticien.setText(praticienDAO.find().get(i).getPraPrenom());
        adressePraticien.setText(praticienDAO.find().get(i).getPraAdresse());
        cpPraticien.setText(praticienDAO.find().get(i).getPraCp());
        villePraticien.setText(praticienDAO.find().get(i).getPraVille());
        coeffNot.setText(""+praticienDAO.find().get(i).getPraCoefnotoriete());
        for(int j=typePraticienDAO.find().size()-1;j>=0;j--){
            lieuExercice.addItem(""+typePraticienDAO.find().get(j).getTypLieu());
        }
        for(int j=0; j<=praticienDAO.find().size()-1; j++){
            listPraticien.addItem(praticienDAO.find().get(j).getPraNom()+" "+praticienDAO.find().get(j).getPraPrenom());
        }
        lieuExercice.setSelectedItem(""+praticienDAO.find().get(i).getTypCode().getTypLieu());
        
    }
    
    public void infoPraSelected(int i){
        numeroPraticien.setText(""+praticienDAO.find().get(i).getPraNum());
        nomPraticien.setText(praticienDAO.find().get(i).getPraNom());
        prenomPraticien.setText(praticienDAO.find().get(i).getPraPrenom());
        adressePraticien.setText(praticienDAO.find().get(i).getPraAdresse());
        cpPraticien.setText(praticienDAO.find().get(i).getPraCp());
        villePraticien.setText(praticienDAO.find().get(i).getPraVille());
        coeffNot.setText(""+praticienDAO.find().get(i).getPraCoefnotoriete());
        listPraticien.setSelectedIndex(i);
        lieuExercice.setSelectedItem(""+praticienDAO.find().get(i).getTypCode().getTypLieu());
    }
    
}
