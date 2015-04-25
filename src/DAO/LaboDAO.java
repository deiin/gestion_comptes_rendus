package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ENTITE.Labo;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Dan
 */
public class LaboDAO extends DAO<Labo> {
     
    public ArrayList<Labo> find(){
        ArrayList<Labo> listlabo = new ArrayList();
            String col="";
            String type="";
            String tab1[]= new String[11];
            Labo lab;
            try{
                ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                        .executeQuery("Select * from labo");
                ResultSetMetaData rsmd = result.getMetaData();
                int nbcol = rsmd.getColumnCount();
                while(result.next()){
                    int i=0;
                    for(int j=0; j<nbcol; j++){
                        type=rsmd.getColumnTypeName(j+1);
                                tab1[j]=result.getString(j+1);
                    }
                    lab = new Labo(tab1[0], tab1[1], tab1[2]);
                    listlabo.add(i, lab);
                    i++;
                }
            } catch (SQLException e) {
		            e.printStackTrace();
		    }
                return listlabo;
    }
    
    public Labo find(String Matricule){
        Labo lab = new Labo();
            try {
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE
            ).executeQuery("SELECT * FROM labo WHERE LAB_CODE = '" +Matricule+ "'");
            if(result.first()){
            		lab = new Labo(
                                Matricule,
                                result.getString("LAB_NOM"),
                                result.getString("LAB_CHEFVENTE"));            
            }
		    } catch (SQLException e) {
		            e.printStackTrace();
		    }
		   return lab;
    }
    
    public Labo find(int id){return new Labo();}
    public Labo find(String nom, Date date){return new Labo();}
    public Labo create(Labo obj){return new Labo();}
    public Labo update(Labo obj){return new Labo();}
    public void delete(Labo obj){}
    public ArrayList<Labo> findOffre(String vis, int rap){return new ArrayList();}
}
