package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ENTITE.Secteur;
import java.sql.ResultSetMetaData;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Dan
 */
public class SecteurDAO extends DAO<Secteur> {
    
    public ArrayList<Secteur> find(){
        ArrayList<Secteur> secteurs = new ArrayList();
            String col="";
            String type="";
            String tab1[]= new String[11];
            Secteur sec;
            try{
                ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                        .executeQuery("Select * from secteur");
                ResultSetMetaData rsmd = result.getMetaData();
                int nbcol = rsmd.getColumnCount();
                while(result.next()){
                    int i=0;
                    for(int j=0; j<nbcol; j++){
                        type=rsmd.getColumnTypeName(j+1);
                                tab1[j]=result.getString(j+1);
                    }
                    sec = new Secteur(
                            tab1[0], tab1[1]);
                    secteurs.add(i, sec);
                    i++;
                }

            } catch (SQLException e) {
		            e.printStackTrace();
		    }


                return secteurs;
    }

    public Secteur find(String Matricule){
        Secteur sec = new Secteur();
            try {
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE
            ).executeQuery("SELECT * FROM secteur WHERE SEC_CODE = '" +Matricule+ "'");
            if(result.first()){
            		sec = new Secteur(
                                Matricule,
                                result.getString("SEC_LIBELLE")
                                    );            
            }
		    } catch (SQLException e) {
		            e.printStackTrace();
		    }
		   return sec;
    }

    public Secteur find(int id){return new Secteur();}
    public Secteur find(String nom, Date date){return new Secteur();}
    public Secteur create(Secteur obj){return new Secteur();}
    public Secteur update(Secteur obj){return new Secteur();}
    public void delete(Secteur obj){}
    public ArrayList<Secteur> findOffre(String vis, int rap){return new ArrayList();}
    
}
