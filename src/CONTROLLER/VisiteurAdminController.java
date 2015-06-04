
package CONTROLLER;

/**
 *
 * @author Dan
 */

import DAO.DAO;
import DAO.LaboDAO;
import DAO.SecteurDAO;
import DAO.VisiteurDAO;
import ENTITE.Labo;
import ENTITE.Secteur;
import ENTITE.Visiteur;
import static UI.VisiteurAdminUI.adresse;
import static UI.VisiteurAdminUI.cp;
import static UI.VisiteurAdminUI.listelabo;
import static UI.VisiteurAdminUI.listevisiteurs;
import static UI.VisiteurAdminUI.nom;
import static UI.VisiteurAdminUI.prenom;
import static UI.VisiteurAdminUI.listesecteurs;
import static UI.VisiteurAdminUI.ville;
import static UI.VisiteurAdminUI.dateembauche;
import static UI.VisiteurAdminUI.matricule;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class VisiteurAdminController {
    private ArrayList<Labo> lab= new LaboDAO().find();
    private ArrayList<Secteur> sec= new SecteurDAO().find();
    private ArrayList<Visiteur> vis= new VisiteurDAO().find();
    private static int b=0;
    private static int n=0;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    
    public VisiteurAdminController(){}
    
    public void visPrecedent(){
        if(b!=0){
                b--;
                n--;
                nom.setText(vis.get(b).getVisNom());
                prenom.setText(vis.get(b).getVisPRENOM());
                adresse.setText(vis.get(b).getVisAdresse());
                cp.setText(vis.get(b).getVisCp());
                ville.setText(vis.get(b).getVisVille());
                listevisiteurs.setSelectedIndex(n);
                if(vis.get(b).getSecCode().getSecLibelle()==null){
                listesecteurs.setSelectedItem("");
                }
                else{
                listesecteurs.setSelectedItem(""+vis.get(b).getSecCode().getSecLibelle());
                }
                listelabo.setSelectedItem(""+vis.get(b).getLabCode().getLabNom());
                matricule.setText(vis.get(b).getVisMatricule());
                dateembauche.setText(format.format(vis.get(b).getVisDateembauche()));
        }
    }
    
    public void visSuivant(){
        if(b!=vis.size()-1){
            b++;
            n++;
            nom.setText(vis.get(b).getVisNom());
            prenom.setText(vis.get(b).getVisPRENOM());
            adresse.setText(vis.get(b).getVisAdresse());
            cp.setText(vis.get(b).getVisCp());
            ville.setText(vis.get(b).getVisVille());
            listevisiteurs.setSelectedIndex(n);
            if(vis.get(b).getSecCode().getSecLibelle()==null){
            listesecteurs.setSelectedItem("");
            }
            else{
            listesecteurs.setSelectedItem(""+vis.get(b).getSecCode().getSecLibelle());
            }
            listelabo.setSelectedItem(""+vis.get(b).getLabCode().getLabNom());
            matricule.setText(vis.get(b).getVisMatricule());
            dateembauche.setText(format.format(vis.get(b).getVisDateembauche()));
        }
    }
    
    
    public void infoVis(int i){
        nom.setText(vis.get(i).getVisNom());
        prenom.setText(vis.get(i).getVisPRENOM());
        adresse.setText(vis.get(i).getVisAdresse());
        cp.setText(vis.get(i).getVisCp());
        ville.setText(vis.get(i).getVisVille());
        for(int j=0; j<=vis.size()-1; j++){
            listevisiteurs.addItem(vis.get(j).getVisNom()+" "+vis.get(j).getVisPRENOM());
        }
        
        listesecteurs.addItem("");
        listelabo.addItem("");
        for(int j=sec.size()-1; j>=0; j--){
                listesecteurs.addItem(""+sec.get(j).getSecLibelle());
        }
        for(int j=lab.size()-1;j>=0; j--){
                    listelabo.addItem(""+lab.get(j).getLabNom());
        }
        
        listesecteurs.setSelectedItem(""+vis.get(i).getSecCode().getSecLibelle());
        listelabo.setSelectedItem(""+vis.get(i).getLabCode().getLabNom());
        matricule.setText(vis.get(i).getVisMatricule());
        dateembauche.setText(format.format(vis.get(i).getVisDateembauche()));
    
    }
    
    
    public void infoVisSelected(int i){
        nom.setText(vis.get(i).getVisNom());
        prenom.setText(vis.get(i).getVisPRENOM());
        adresse.setText(vis.get(i).getVisAdresse());
        cp.setText(vis.get(i).getVisCp());
        ville.setText(vis.get(i).getVisVille());
        listevisiteurs.setSelectedIndex(i);
        listesecteurs.setSelectedItem(""+vis.get(i).getSecCode().getSecLibelle());
        listelabo.setSelectedItem(""+vis.get(i).getLabCode().getLabNom());
        matricule.setText(vis.get(i).getVisMatricule());
        dateembauche.setText(format.format(vis.get(i).getVisDateembauche()));
    }
    
    public void ajouter(){
    
    }
    
    public void modifier(){
    
    }
    
    public void supprimer(){
    
    }
    
}
