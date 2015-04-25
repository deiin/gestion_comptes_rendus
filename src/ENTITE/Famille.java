package ENTITE;

/**
 *
 * @author Dan
 */

public class Famille {
    
    
    private String famCode;
    private String famLibelle;

    public Famille() {
    }

    public Famille(String famCode, String famLibelle) {
        this.famCode = famCode;
        this.famLibelle = famLibelle;
    }

    public String getFamCode() {
        return famCode;
    }

    public String getFamLibelle() {
        return famLibelle;
    }
}
