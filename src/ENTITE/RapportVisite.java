package ENTITE;

/**
 *
 * @author Dan
 */

import java.util.Date;


public class RapportVisite {
    
    private Integer rapNum;
    private Date rapDate;
    private String rapBilan;
    private String rapMotif;
    private Visiteur visMatricule;
    private Praticien praNum;
    
    public RapportVisite() {
    }

    public RapportVisite(Visiteur visMatricule, Integer rapNum, Praticien praNum, Date rapDate, String rapBilan, String rapMotif) {
        this.rapNum = rapNum;
        this.visMatricule = visMatricule;
        this.praNum = praNum;
        this.rapDate= rapDate;
        this.rapBilan = rapBilan;
        this.rapMotif = rapMotif;
    }

    public Integer getRapNum() {
        return rapNum;
    }

    public Date getRapDate() {
        return rapDate;
    }

    public String getRapBilan() {
        return rapBilan;
    }

    public String getRapMotif() {
        return rapMotif;
    }

    public Visiteur getVisMatricule() {
        return visMatricule;
    }

    public Praticien getPraNum() {
        return praNum;
    }
    
}
