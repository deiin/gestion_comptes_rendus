
package CONTROLLER;

import DAO.DAO;
import DAO.LaboDAO;
import DAO.SecteurDAO;
import DAO.VisiteurDAO;
import ENTITE.Labo;
import ENTITE.Secteur;
import ENTITE.Visiteur;
import static UI.VisiteurUI.adresseVisiteur;
import static UI.VisiteurUI.cpVisiteur;
import static UI.VisiteurUI.laboVisiteur;
import static UI.VisiteurUI.listVisiteurs;
import static UI.VisiteurUI.nomVisiteur;
import static UI.VisiteurUI.prenomVisiteur;
import static UI.VisiteurUI.secteurVisiteur;
import static UI.VisiteurUI.villeVisiteur;
import java.util.ArrayList;

/**
 *
 * @author Dan
 */
public class VisiteurController {
    private ArrayList<Labo> lab= new LaboDAO().find();
    private ArrayList<Secteur> sec= new SecteurDAO().find();
    private ArrayList<Visiteur> vis= new VisiteurDAO().find();
    private static int b=0;
    private static int n=0;
    
    public VisiteurController(){
    
    }
    public void visPrecedent(){
        if(b!=0){
                b--;
                n--;
                nomVisiteur.setText(vis.get(b).getVisNom());
                prenomVisiteur.setText(vis.get(b).getVisPRENOM());
                adresseVisiteur.setText(vis.get(b).getVisAdresse());
                cpVisiteur.setText(vis.get(b).getVisCp());
                villeVisiteur.setText(vis.get(b).getVisVille());
                listVisiteurs.setSelectedIndex(n);
                secteurVisiteur.setSelectedItem(""+vis.get(b).getSecCode().getSecLibelle());
                laboVisiteur.setSelectedItem(""+vis.get(b).getLabCode().getLabNom());    
        }
    }
    
    public void visSuivant(){
        if(b!=vis.size()-1){
            b++;
            n++;
            nomVisiteur.setText(vis.get(b).getVisNom());
            prenomVisiteur.setText(vis.get(b).getVisPRENOM());
            adresseVisiteur.setText(vis.get(b).getVisAdresse());
            cpVisiteur.setText(vis.get(b).getVisCp());
            villeVisiteur.setText(vis.get(b).getVisVille());
            listVisiteurs.setSelectedIndex(n);
            if(vis.get(b).getSecCode().getSecLibelle()==null){
            secteurVisiteur.setSelectedItem("");
            }
            else{
            secteurVisiteur.setSelectedItem(""+vis.get(b).getSecCode().getSecLibelle());
            }
            laboVisiteur.setSelectedItem(""+vis.get(b).getLabCode().getLabNom());   
        }
    }
    
    
    public void infoVis(int i){
        nomVisiteur.setText(vis.get(i).getVisNom());
        prenomVisiteur.setText(vis.get(i).getVisPRENOM());
        adresseVisiteur.setText(vis.get(i).getVisAdresse());
        cpVisiteur.setText(vis.get(i).getVisCp());
        villeVisiteur.setText(vis.get(i).getVisVille());
        for(int j=0; j<=vis.size()-1; j++){
            listVisiteurs.addItem(vis.get(j).getVisNom()+" "+vis.get(j).getVisPRENOM());
        }
        
        secteurVisiteur.addItem("");
        laboVisiteur.addItem("");
        for(int j=sec.size()-1; j>=0; j--){
                secteurVisiteur.addItem(""+sec.get(j).getSecLibelle());
        }
        for(int j=lab.size()-1;j>=0; j--){
                    laboVisiteur.addItem(""+lab.get(j).getLabNom());
        }
        
        secteurVisiteur.setSelectedItem(""+vis.get(i).getSecCode().getSecLibelle());
        laboVisiteur.setSelectedItem(""+vis.get(i).getLabCode().getLabNom());
    
    }
    
    
    public void infoVisSelected(int i){
        nomVisiteur.setText(vis.get(i).getVisNom());
        prenomVisiteur.setText(vis.get(i).getVisPRENOM());
        adresseVisiteur.setText(vis.get(i).getVisAdresse());
        cpVisiteur.setText(vis.get(i).getVisCp());
        villeVisiteur.setText(vis.get(i).getVisVille());
        listVisiteurs.setSelectedIndex(i);
        secteurVisiteur.setSelectedItem(""+vis.get(i).getSecCode().getSecLibelle());
        laboVisiteur.setSelectedItem(""+vis.get(i).getLabCode().getLabNom()); 
    }
    
}
