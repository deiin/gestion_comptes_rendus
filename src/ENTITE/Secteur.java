package ENTITE;

/**
 *
 * @author Dan
 */

import java.util.Date;


public class Secteur {
    private String secCode;
    private String secLibelle;
    
    public Secteur() {
    }

    public Secteur(String secCode, String secLibelle) {
        this.secCode = secCode;
        this.secLibelle=secLibelle;
    }

    public String getSecCode() {
        return secCode;
    }

    public String getSecLibelle() {
        return secLibelle;
    }

    
    
}
