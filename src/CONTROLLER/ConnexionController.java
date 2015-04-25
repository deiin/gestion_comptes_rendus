package CONTROLLER;
import UI.ConnexionUI;
import DAO.DAO;
import DAO.VisiteurDAO;
import ENTITE.Visiteur;
import UI.MenuUI;
import static UI.ConnexionUI.error;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.WindowConstants;

/**
 *
 * @author Dan
 */
public class ConnexionController {
    private static String dateChange;
    private static Date date;
    
    
    public ConnexionController(){}
    
    
    public boolean getConnexion(String login, String mdp){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try{
            if(mdp.length()!=10)error.setText("login et/ou mot de passe incorecte");
            String annee= mdp.substring(7);
            String jours= mdp.substring(0, 2);
            String mois=obtenirMois(mdp.substring(3,6));
            mdp=annee+"-"+mois+"-"+jours;
            this.date=format.parse(mdp);
            DAO<Visiteur> visiteurDAO = new VisiteurDAO();
            Visiteur visiteur=visiteurDAO.find(login, this.date);
            dateChange = format.format(visiteur.getVisDateembauche());
        }catch(ParseException e){
            e.printStackTrace();
            error.setText("login et/ou mot de passe incorecte");
        }
        
        if(mdp.equalsIgnoreCase(dateChange)){
                        new MenuUI(login, date).setVisible(true);
                        return true;
        }else {
                        return false;
        }
    }
    
    public String obtenirMois(String lib){
        String []lib2 = {"jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec"}; 
        String mois="";
        for(int i=0; i<=11; i++){
            if(lib2[i].equals(lib) & (i<10)){
                mois = "0"+(i+1);
            }
            else if (lib2[i].equals(lib) & (i>=10)){
                mois =""+(i+1);
            }
        }
        return mois;
    }
    
}
