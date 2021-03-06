package DAO;

import ENTITE.Famille;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Dan
 */
public class FamilleDAO extends DAO<Famille> {
    
    public ArrayList<Famille> find(){
        ArrayList<Famille> familles = new ArrayList();
            String col="";
            String type="";
            String tab1[]= new String[11];
            Famille fam;
            try{
                ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                        .executeQuery("Select * from famille");
                ResultSetMetaData rsmd = result.getMetaData();
                int nbcol = rsmd.getColumnCount();
                while(result.next()){
                    int i=0;
                    for(int j=0; j<nbcol; j++){
                        type=rsmd.getColumnTypeName(j+1);
                                tab1[j]=result.getString(j+1);
                    }
                    fam = new Famille(
                            tab1[0], tab1[1]);
                    familles.add(i, fam);
                    i++;
                }
            } catch (SQLException e) {
		            e.printStackTrace();
		    }
                return familles;
    }
    
    public Famille find(String Matricule){
        Famille fam = new Famille();
            try {
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE
            ).executeQuery("SELECT * FROM famille WHERE FAM_CODE = '" +Matricule+ "'");
            if(result.first()){
            		fam = new Famille(
                                Matricule,
                                result.getString("FAM_LIBELLE")
                                    );            
            }
		    } catch (SQLException e) {
		            e.printStackTrace();
		    }
		   return fam;
    }
    
    public Famille find(int id){return new Famille();}
    public Famille find(String nom, Date date){return new Famille();}
    public Famille create(Famille obj){
        try {
                PreparedStatement prepare = this.connect
                        .prepareStatement("INSERT INTO famille (FAM_CODE, FAM_LIBELLE)"+
                                            			"VALUES(?, ?)"
                                                    );
                                prepare.setString(1, obj.getFamCode());
                                prepare.setString(2, obj.getFamLibelle());
				
				prepare.executeUpdate();
				obj = this.find(obj.getFamCode());	
				
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
        return obj;
    }

    public Famille update(Famille obj){
            try{
                this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE
                ).executeUpdate("UPDATE famille SET FAM_LIBELLE='"+obj.getFamLibelle()+"'"
                        + " where FAM_CODE="+obj.getFamCode()+"'"
                );
                obj = this.find(obj.getFamCode());

            }catch(SQLException e){
                e.printStackTrace();
            }
            return obj;
    }
    public void delete(Famille obj){
        try{
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                    .executeUpdate("DELETE FROM famille Where FAM_CODE='"+obj.getFamCode()+"'");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public ArrayList<Famille> findOffre(String vis, int rap){return new ArrayList();}
    
}
