package ENTITE;

/**
 *
 * @author Dan
 */


import java.util.Date;

public class Praticien {
    
    private Short praNum;
    private String praNom;
    private String praPrenom;
    private String praAdresse;
    private String praCp;
    private String praVille;
    private Double praCoefnotoriete;
    private TypePraticien typCode;
    
    
    public Praticien() {
    }

    public Praticien(Short praNum, String praNom, String praPrenom, String praAdresse, String praCp, String praVille, Double praCoefnotoriete, TypePraticien typCode) {
        this.praNum = praNum;
        this.praNom = praNom;
        this.praPrenom = praPrenom;
        this.praAdresse = praAdresse;
        this.praCp = praCp;
        this.praVille = praVille;
        this.praCoefnotoriete = praCoefnotoriete;
        this.typCode = typCode;
        
    }

    public Short getPraNum() {
        return praNum;
    }

    public String getPraNom() {
        return praNom;
    }

    public String getPraPrenom() {
        return praPrenom;
    }

    public String getPraAdresse() {
        return praAdresse;
    }

    public String getPraCp() {
        return praCp;
    }

    public String getPraVille() {
        return praVille;
    }

    public Double getPraCoefnotoriete() {
        return praCoefnotoriete;
    }

    public TypePraticien getTypCode() {
        return typCode;
    }
    
}
