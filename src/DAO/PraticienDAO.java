package DAO;

/**
 *
 * @author Dan
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import ENTITE.Praticien;
import java.util.ArrayList;
import ENTITE.TypePraticien;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PraticienDAO extends DAO<Praticien>{

    public ArrayList<Praticien> find(){
        ArrayList<Praticien> praticiens = new ArrayList();
            String type="";
            String tab1[]= new String[11];
            double tab2[] = new double[3];
            TypePraticien tab3[] = new TypePraticien[3];
            short tab4[] = new short[3];
            Praticien pra;
            try{
                ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                        .executeQuery("Select * from praticien order by PRA_NUM desc");
                ResultSetMetaData rsmd = result.getMetaData();
                int nbcol = rsmd.getColumnCount();
                while(result.next()){
                    int i=0;
                    for(int j=0; j<nbcol; j++){
                        type=rsmd.getColumnTypeName(j+1);
                        if(type=="VARCHAR"){
                            if(j==7){
                                tab3[0]= new TypePraticienDAO().find(result.getString("TYP_CODE"));
                            }
                            else{
                                tab1[j]=result.getString(j+1);
                            }
                        }
                        else if(type=="DOUBLE"){
                            tab2[0]= result.getDouble(j+1);
                        }
                        else if(type=="SMALLINT"){
                            tab4[0]= result.getShort(j+1);
                        }
                    }
                    pra = new Praticien(tab4[0], tab1[1], tab1[2], tab1[3], tab1[4], tab1[5], tab2[0], tab3[0]);
                    praticiens.add(i, pra);
                    i++;
                }
            } catch (SQLException e) {
		            e.printStackTrace();
		    }
                return praticiens;
    }
    
    public Praticien find(int id){
        Praticien pra = new Praticien();
            try{
                ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE
                ).executeQuery("SELECT * FROM praticien WHERE PRA_NUM ="+id);
                if(result.first()){
                            pra = new Praticien(
                                    (short)id,
                                    result.getString("PRA_NOM"),
                                    result.getString("PRA_PRENOM"),
                                    result.getString("PRA_ADRESSE"),
                                    result.getString("PRA_CP"),
                                    result.getString("PRA_VILLE"),
                                    result.getDouble("PRA_COEFNOTORIETE"),
                                    new TypePraticienDAO().find(result.getString("TYP_CODE"))
                                        );            
                }
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        return pra;
    }
    
    public Praticien find(String Matricule){return new Praticien();}
    public Praticien find(String nom, Date date){return new Praticien();}
    public Praticien create(Praticien obj){
        try {
                PreparedStatement prepare = this.connect
                        .prepareStatement("INSERT INTO praticien (PRA_NUM, PRA_NOM, PRA_PRENOM, PRA_ADRESSE, PRA_CP, PRA_VILLE, PRA_COEFNOTORIETE, TYP_CODE)"+
                                            			"VALUES(?, ?, ?, ?, ?, ?, ?, ?)"
                                                    );
				prepare.setShort(1, obj.getPraNum());
                                prepare.setString(2, obj.getPraNom());
                                prepare.setString(3, obj.getPraPrenom());
                                prepare.setString(4, obj.getPraAdresse());
                                prepare.setString(5, obj.getPraCp());
                                prepare.setString(6, obj.getPraVille());
				prepare.setDouble(7, obj.getPraCoefnotoriete());
                                prepare.setString(8, obj.getTypCode().getTypCode());
				
				prepare.executeUpdate();
				obj = this.find(obj.getPraNum());	
				
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
        return obj;
    }
    
    public Praticien update(Praticien obj){
            try{
                this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE
                ).executeUpdate("UPDATE praticien SET PRA_NOM='"+obj.getPraNom()+"',"
                        + " PRA_PRENOM='"+obj.getPraPrenom()+"',"
                        + " PRA_ADRESSE='"+obj.getPraAdresse()+"',"
                        + " PRA_CP='"+obj.getPraCp()+"',"
                        + " PRA_VILLE='"+obj.getPraVille()+"',"
                        + " PRA_COEFNOTORIETE='"+obj.getPraCoefnotoriete()+"',"
                        + " TYP_CODE='"+obj.getTypCode().getTypCode()+"' "
                        + " where PRA_NUM='"+obj.getPraNum()+"'"
                );
                obj = this.find(obj.getPraNum());

            }catch(SQLException e){
                e.printStackTrace();
            }
            return obj;
    
    }
    public void delete(Praticien obj){
        try{
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                    .executeUpdate("DELETE FROM praticien Where PRA_NUM='"+obj.getPraNum()+"'");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public ArrayList<Praticien> findOffre(String vis, int rap){return new ArrayList();}
    
}
