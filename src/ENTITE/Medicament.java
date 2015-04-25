package ENTITE;

/**
 *
 * @author Dan
 */
public class Medicament {
    private String medDepotlegal;
    private String medNomcommercial;
    private String medComposition;
    private String medEffets;
    private String medContreindic;
    private Double medPrixechantillon;
    private Famille famCode;
    
    public Medicament() {
    }

    public Medicament(String medDepotlegal, String medNomcommercial, Famille famCode, String medComposition, String medEffets, String medContreindic, Double medPrixechantillon) {
        this.medDepotlegal = medDepotlegal;
        this.medNomcommercial = medNomcommercial;
        this.medComposition = medComposition;
        this.medEffets = medEffets;
        this.medContreindic = medContreindic;
        this.medPrixechantillon = medPrixechantillon;
        this.famCode = famCode;
    }

    public String getMedDepotlegal() {
        return medDepotlegal;
    }

    public String getMedNomcommercial() {
        return medNomcommercial;
    }

    public String getMedComposition() {
        return medComposition;
    }

    public String getMedEffets() {
        return medEffets;
    }

    public String getMedContreindic() {
        return medContreindic;
    }

    public Double getMedPrixechantillon() {
        return medPrixechantillon;
    }

    public Famille getFamCode() {
        return famCode;
    }
    
}
