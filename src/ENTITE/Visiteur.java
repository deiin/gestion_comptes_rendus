package ENTITE;

/**
 *
 * @author Dan
 */

import java.util.Date;


public class Visiteur {
    private String visMatricule = new String();
    private String visNom = new String();
    private String visPRENOM = new String();
    private String visAdresse = new String();
    private String visCp = new String();
    private String visVille = new String();
    private Date visDateembauche = new Date();
    private Secteur secCode = new Secteur();
    private Labo labCode = new Labo();
    
    public Visiteur() {
    }
    
    public Visiteur(String visMatricule, String visNom, String visPRENOM, String visAdresse, String visCp, String visVille, Date visDateembauche, Secteur secCode, Labo labCode){
        this.visMatricule=visMatricule;
        this.visNom=visNom;
        this.visPRENOM=visPRENOM;
        this.visAdresse=visAdresse;
        this.visCp=visCp;
        this.visVille=visVille;
        this.visDateembauche=visDateembauche;
        this.secCode=secCode;
        this.labCode=labCode;
    }

    public String getVisMatricule() {
        return visMatricule;
    }

    public String getVisNom() {
        return visNom;
    }

    public String getVisPRENOM() {
        return visPRENOM;
    }

    public String getVisAdresse() {
        return visAdresse;
    }
    
    public String getVisCp() {
        return visCp;
    }

    public String getVisVille() {
        return visVille;
    }

    public Date getVisDateembauche() {
        return visDateembauche;
    }

    public Secteur getSecCode() {
        return secCode;
    }
    
    public Labo getLabCode() {
        return labCode;
    }

}
