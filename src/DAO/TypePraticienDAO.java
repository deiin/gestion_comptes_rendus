
package DAO;

import ENTITE.TypePraticien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;



public class TypePraticienDAO extends DAO<TypePraticien> {

    public ArrayList<TypePraticien> find(){
         ArrayList<TypePraticien> typesPraticiens = new ArrayList();
            String col="";
            String type="";
            String tab1[]= new String[11];
            TypePraticien typ;
            try{
                ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                        .executeQuery("Select * from type_praticien");
                ResultSetMetaData rsmd = result.getMetaData();
                int nbcol = rsmd.getColumnCount();
                while(result.next()){
                    int i=0;
                    for(int j=0; j<nbcol; j++){
                        type=rsmd.getColumnTypeName(j+1);
                                tab1[j]=result.getString(j+1);
                    }
                    typ = new TypePraticien(tab1[0], tab1[1], tab1[2]);
                    typesPraticiens.add(i, typ);
                    i++;
                }

            } catch (SQLException e) {
		            e.printStackTrace();
		    }


                return typesPraticiens;
    }

    public TypePraticien find(String Matricule){
        TypePraticien typePra = new TypePraticien();
            try {
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE
            ).executeQuery("SELECT * FROM type_praticien WHERE TYP_CODE = '" +Matricule+ "'");
            if(result.first()){
            		typePra = new TypePraticien(
                                Matricule,
                                result.getString("TYP_LIBELLE"),
                                result.getString("TYP_LIEU"));            
            }
		    } catch (SQLException e) {
		            e.printStackTrace();
		    }
		   return typePra;
    }
    
    public TypePraticien find(int id){return new TypePraticien();}
    public TypePraticien find(String nom, Date date){return new TypePraticien();}
    public TypePraticien create(TypePraticien obj){
        try {
                PreparedStatement prepare = this.connect
                        .prepareStatement("INSERT INTO type_praticien (TYP_CODE, TYP_LIBELLE, TYP_LIEU)"+
                                            			"VALUES(?, ?, ?)"
                                                    );
				prepare.setString(1, obj.getTypCode());
                                prepare.setString(2, obj.getTypLibelle());
                                prepare.setString(3, obj.getTypLieu());
				
				prepare.executeUpdate();
				obj = this.find(obj.getTypCode());	
				
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
        return obj;
    
    }
    public TypePraticien update(TypePraticien obj){
            try{
                this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE
                ).executeUpdate("UPDATE type_praticien SET TYP_LIEU='"+obj.getTypLieu()+"',"
                        + "TYP_LIBELLE='"+obj.getTypLibelle()+"',"
                        + "where TYP_CODE="+obj.getTypCode()+"'"
                );
                obj = this.find(obj.getTypCode());

            }catch(SQLException e){
                e.printStackTrace();
            }
            return obj;
    }
    public void delete(TypePraticien obj){
        try{
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                    .executeUpdate("DELETE FROM type_praticien Where TYP_CODE='"+obj.getTypCode()+"'");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public ArrayList<TypePraticien> findOffre(String vis, int rap){return new ArrayList();} 
}
