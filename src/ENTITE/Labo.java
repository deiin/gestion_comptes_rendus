package ENTITE;

/**
 *
 * @author Dan
 */


public class Labo {
    
    private String labCode;
    private String labNom;
    private String labChefvente;

    public Labo() {
    }

    public Labo(String labCode, String labNom, String labChefvente) {
        this.labCode = labCode;
        this.labNom=labNom;
        this.labChefvente=labChefvente;
        
    }

    public String getLabCode() {
        return labCode;
    }

    public String getLabNom() {
        return labNom;
    }

    public String getLabChefvente() {
        return labChefvente;
    }
    
}