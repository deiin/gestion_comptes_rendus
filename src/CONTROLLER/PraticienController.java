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
import java.util.ArrayList;

/**
 *
 * @author Dan
 */
public class PraticienController {
    private ArrayList<TypePraticien> type= new TypePraticienDAO().find();
    private ArrayList<Praticien> pra = new PraticienDAO().find();
    private static int b=0;
    private static int n=0;
    public PraticienController(){}
    
    public void praSuivant(){
        if(b!=pra.size()-1){
            b++;
            n++;
            numeroPraticien.setText(""+pra.get(b).getPraNum());
            nomPraticien.setText(pra.get(b).getPraNom());
            prenomPraticien.setText(pra.get(b).getPraPrenom());
            adressePraticien.setText(pra.get(b).getPraAdresse());
            cpPraticien.setText(pra.get(b).getPraCp());
            villePraticien.setText(pra.get(b).getPraVille());
            coeffNot.setText(""+pra.get(b).getPraCoefnotoriete());
            listPraticien.setSelectedIndex(n);
            lieuExercice.setSelectedItem(""+pra.get(b).getTypCode().getTypLieu());   
        }
    
    }
    
    public void praPrécédent(){
        if(b!=0){
                b--;
                n--;
                numeroPraticien.setText(""+pra.get(b).getPraNum());
                nomPraticien.setText(pra.get(b).getPraNom());
                prenomPraticien.setText(pra.get(b).getPraPrenom());
                adressePraticien.setText(pra.get(b).getPraAdresse());
                cpPraticien.setText(pra.get(b).getPraCp());
                villePraticien.setText(pra.get(b).getPraVille());
                coeffNot.setText(""+pra.get(b).getPraCoefnotoriete());
                listPraticien.setSelectedIndex(n);
                lieuExercice.setSelectedItem(""+pra.get(b).getTypCode().getTypLieu());
        }
    }
    
    public void infoPra(int i){
        numeroPraticien.setText(""+pra.get(i).getPraNum());
        nomPraticien.setText(pra.get(i).getPraNom());
        prenomPraticien.setText(pra.get(i).getPraPrenom());
        adressePraticien.setText(pra.get(i).getPraAdresse());
        cpPraticien.setText(pra.get(i).getPraCp());
        villePraticien.setText(pra.get(i).getPraVille());
        coeffNot.setText(""+pra.get(i).getPraCoefnotoriete());
        for(int j=type.size()-1;j>=0;j--){
            lieuExercice.addItem(""+type.get(j).getTypLieu());
        }
        for(int j=0; j<=pra.size()-1; j++){
            listPraticien.addItem(pra.get(j).getPraNom()+" "+pra.get(j).getPraPrenom());
        }
        lieuExercice.setSelectedItem(""+pra.get(i).getTypCode().getTypLieu());
        
    }
    
    public void infoPraSelected(int i){
        numeroPraticien.setText(""+pra.get(i).getPraNum());
        nomPraticien.setText(pra.get(i).getPraNom());
        prenomPraticien.setText(pra.get(i).getPraPrenom());
        adressePraticien.setText(pra.get(i).getPraAdresse());
        cpPraticien.setText(pra.get(i).getPraCp());
        villePraticien.setText(pra.get(i).getPraVille());
        coeffNot.setText(""+pra.get(i).getPraCoefnotoriete());
        listPraticien.setSelectedIndex(i);
        lieuExercice.setSelectedItem(""+pra.get(i).getTypCode().getTypLieu());
    }
    
}
