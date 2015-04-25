/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Dan
 */
public class VisiteurController {
    private static DAO<Visiteur> visiteurDAO = new VisiteurDAO();
    private static DAO<Secteur> secteurDAO = new SecteurDAO();
    private static DAO<Labo> laboDAO = new LaboDAO();
    private static int b=0;
    private static int n=0;
    
    public VisiteurController(){
    
    }
    public void visPrecedent(){
        if(b!=0){
                b--;
                n--;
                nomVisiteur.setText(visiteurDAO.find().get(b).getVisNom());
                prenomVisiteur.setText(visiteurDAO.find().get(b).getVisPRENOM());
                adresseVisiteur.setText(visiteurDAO.find().get(b).getVisAdresse());
                cpVisiteur.setText(visiteurDAO.find().get(b).getVisCp());
                villeVisiteur.setText(visiteurDAO.find().get(b).getVisVille());
                listVisiteurs.setSelectedIndex(n);
                secteurVisiteur.setSelectedItem(""+visiteurDAO.find().get(b).getSecCode().getSecLibelle());
                laboVisiteur.setSelectedItem(""+visiteurDAO.find().get(b).getLabCode().getLabNom());    
        }
    }
    
    public void visSuivant(){
        if(b!=visiteurDAO.find().size()-1){
            b++;
            n++;
            nomVisiteur.setText(visiteurDAO.find().get(b).getVisNom());
            prenomVisiteur.setText(visiteurDAO.find().get(b).getVisPRENOM());
            adresseVisiteur.setText(visiteurDAO.find().get(b).getVisAdresse());
            cpVisiteur.setText(visiteurDAO.find().get(b).getVisCp());
            villeVisiteur.setText(visiteurDAO.find().get(b).getVisVille());
            listVisiteurs.setSelectedIndex(n);
            if(visiteurDAO.find().get(b).getSecCode().getSecLibelle()==null){
            secteurVisiteur.setSelectedItem("");
            }
            else{
            secteurVisiteur.setSelectedItem(""+visiteurDAO.find().get(b).getSecCode().getSecLibelle());
            }
            laboVisiteur.setSelectedItem(""+visiteurDAO.find().get(b).getLabCode().getLabNom());   
        }
    }
    
    
    public void infoVis(int i){
        nomVisiteur.setText(visiteurDAO.find().get(i).getVisNom());
        prenomVisiteur.setText(visiteurDAO.find().get(i).getVisPRENOM());
        adresseVisiteur.setText(visiteurDAO.find().get(i).getVisAdresse());
        cpVisiteur.setText(visiteurDAO.find().get(i).getVisCp());
        villeVisiteur.setText(visiteurDAO.find().get(i).getVisVille());
        for(int j=0; j<=visiteurDAO.find().size()-1; j++){
            listVisiteurs.addItem(visiteurDAO.find().get(j).getVisNom()+" "+visiteurDAO.find().get(j).getVisPRENOM());
        }
        
        secteurVisiteur.addItem("");
        laboVisiteur.addItem("");
        for(int j=secteurDAO.find().size()-1; j>=0; j--){
                secteurVisiteur.addItem(""+secteurDAO.find().get(j).getSecLibelle());
        }
        for(int j=laboDAO.find().size()-1;j>=0; j--){
                    laboVisiteur.addItem(""+laboDAO.find().get(j).getLabNom());
        }
        
        secteurVisiteur.setSelectedItem(""+visiteurDAO.find().get(i).getSecCode().getSecLibelle());
        laboVisiteur.setSelectedItem(""+visiteurDAO.find().get(i).getLabCode().getLabNom());
    
    }
    
    
    public void infoVisSelected(int i){
        nomVisiteur.setText(visiteurDAO.find().get(i).getVisNom());
        prenomVisiteur.setText(visiteurDAO.find().get(i).getVisPRENOM());
        adresseVisiteur.setText(visiteurDAO.find().get(i).getVisAdresse());
        cpVisiteur.setText(visiteurDAO.find().get(i).getVisCp());
        villeVisiteur.setText(visiteurDAO.find().get(i).getVisVille());
        listVisiteurs.setSelectedIndex(i);
        secteurVisiteur.setSelectedItem(""+visiteurDAO.find().get(i).getSecCode().getSecLibelle());
        laboVisiteur.setSelectedItem(""+visiteurDAO.find().get(i).getLabCode().getLabNom()); 
    }
    
}
