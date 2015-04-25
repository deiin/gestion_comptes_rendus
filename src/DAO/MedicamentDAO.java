package DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import ENTITE.Medicament;
import java.util.ArrayList;
import ENTITE.Famille;
import java.sql.ResultSetMetaData;
import java.util.Date;

/**
 *
 * @author Dan
 */


public class MedicamentDAO extends DAO<Medicament>{
    
    public ArrayList<Medicament> find(){
        ArrayList<Medicament> medicaments = new ArrayList();
            String type="";
            String tab1[]= new String[11];
            double tab2[] = new double[3];
            Famille tab3[] = new Famille[3];
            Medicament med;
            try{
                ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                        .executeQuery("Select * from medicament ORDER BY MED_DEPOTLEGAL desc");
                ResultSetMetaData rsmd = result.getMetaData();
                int nbcol = rsmd.getColumnCount();
                while(result.next()){
                    int i=0;
                    for(int j=0; j<nbcol; j++){
                        type=rsmd.getColumnTypeName(j+1);
                        if(type=="VARCHAR"){
                            if(j==2){
                                tab3[0]= new FamilleDAO().find(result.getString("FAM_CODE"));
                            }
                            else{
                                tab1[j]=result.getString(j+1);
                            }
                        }
                        else if(type=="DOUBLE"){
                            tab2[0]= result.getDouble(j+1);
                        }
                    }
                    med = new Medicament(tab1[0], tab1[1], tab3[0], tab1[3], tab1[4], tab1[5], tab2[0]);
                    medicaments.add(i, med);
                    i++;
                }
            } catch (SQLException e) {
		            e.printStackTrace();
		    }


                return medicaments;
    }
    
    public  Medicament find(String Matricule){
        Medicament med = new Medicament();
            try {
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE
            ).executeQuery("SELECT * FROM medicament WHERE MED_DEPOTLEGAL = '" +Matricule+ "' OR MED_NOMCOMMERCIAL = '" +Matricule+ "'");
            if(result.first()){
            		med = new Medicament(
                                result.getString("MED_DEPOTLEGAL"),
                                result.getString("MED_NOMCOMMERCIAL"),
                                new FamilleDAO().find(result.getString("FAM_CODE")),
                                result.getString("MED_COMPOSITION"),
                                result.getString("MED_EFFETS"),
                                result.getString("MED_CONTREINDIC"),
                                result.getDouble("MED_PRIXECHANTILLON")
                                    );            
            }
		    } catch (SQLException e) {
		            e.printStackTrace();
		    }
		   return med;
    }
    
    public Medicament find(int id){return new Medicament();}
    public Medicament find(String nom, Date date){return new Medicament();}
    public Medicament create(Medicament obj){return new Medicament();}
    public Medicament update(Medicament obj){return new Medicament();}
    public void delete(Medicament obj){}
    public ArrayList<Medicament> findOffre(String vis, int rap){return new ArrayList();}
    
}
