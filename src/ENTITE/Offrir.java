package ENTITE;

/**
 *
 * @author Dan
 */
public class Offrir {
    private Visiteur visMatricule;
    private RapportVisite rapNum;
    private Medicament medDepotlegal;
    private short offQte;
    
    public Offrir(){
    }
    
    public Offrir(Visiteur visMatricule, RapportVisite rapNum, Medicament medDepotlegal, short offQte){
        this.visMatricule=visMatricule;
        this.rapNum=rapNum;
        this.medDepotlegal=medDepotlegal;
        this.offQte = offQte;
    
    }
    
    public Visiteur getVisMatricule(){
        return this.visMatricule;
    }
    
    public RapportVisite getRapNum(){
        return this.rapNum;
    }
    
    public Medicament getMedDepotlegal(){
        return this.medDepotlegal;
    }

    public short getOffQte(){
        return this.offQte;
    }
    
    
}
