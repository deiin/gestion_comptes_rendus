package ENTITE;

/**
 *
 * @author Dan
 */

import java.util.Date;


public class TypePraticien {
    private String typCode;
    private String typLibelle;
    private String typLieu;

    public TypePraticien() {
    }

    public TypePraticien(String typCode, String typLibelle, String typLieu) {
        this.typCode = typCode;
        this.typLibelle = typLibelle;
        this.typLieu = typLieu;
    }

    public String getTypCode() {
        return typCode;
    }
    
    public String getTypLibelle() {
        return typLibelle;
    }

    public String getTypLieu() {
        return typLieu;
    }
  
}
