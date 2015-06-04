package DAO;

import ENTITE.Labo;
import ENTITE.Praticien;
import ENTITE.RapportVisite;
import ENTITE.Secteur;
import ENTITE.Visiteur;
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

/**
 *
 * @author Dan
 */
public class RapportVisiteDAO extends DAO<RapportVisite> {
    
    public RapportVisite create(RapportVisite obj){
        try {
                PreparedStatement prepare = this.connect
                        .prepareStatement("INSERT INTO rapport_visite (VIS_MATRICULE, RAP_NUM, PRA_NUM, RAP_DATE, RAP_BILAN, RAP_MOTIF)"+
                                            			"VALUES(?, ?, ?, ?, ?, ?)"
                                                    );
				prepare.setString(1, obj.getVisMatricule().getVisMatricule());
				prepare.setInt(2, obj.getRapNum());
				prepare.setShort(3, obj.getPraNum().getPraNum());
				prepare.setDate(4, new java.sql.Date(obj.getRapDate().getYear(), obj.getRapDate().getMonth(), obj.getRapDate().getDate()));
                                prepare.setString(5, obj.getRapBilan());
                                prepare.setString(6, obj.getRapMotif());
				
				prepare.executeUpdate();
				obj = this.find(obj.getRapNum());	
				
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
    }
    
    public RapportVisite update(RapportVisite obj){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try{
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE
            ).executeUpdate("UPDATE rapport_visite SET RAP_DATE='"+format.format(obj.getRapDate())+"',"
                    + " RAP_BILAN='"+obj.getRapBilan()+"',"
                    + " RAP_MOTIF='"+obj.getRapMotif()+"'"
                    + " where RAP_NUM="+obj.getRapNum()
            );
            obj = this.find(obj.getRapNum());
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        return obj;
    }
    
    public ArrayList<RapportVisite> find(){
        
        ArrayList<RapportVisite> rapports = new ArrayList();
            String col="";
            String type="";
            String tab1[]= new String[11];
            Date tab2[] = new Date[3];
            Visiteur tab3[] = new Visiteur[3];
            Praticien tab4[] = new Praticien[3];
            int tab5[] = new int[3];
            RapportVisite rap;
            try{
                ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                        .executeQuery("SELECT * FROM rapport_visite order by RAP_NUM DESC");
                ResultSetMetaData rsmd = result.getMetaData();
                int nbcol = rsmd.getColumnCount();
                while(result.next()){
                    int i=0;
                    for(int j=0; j<nbcol; j++){
                        type=rsmd.getColumnTypeName(j+1);
                        if(type=="VARCHAR"){
                            if(j==0){
                                tab3[0]= new VisiteurDAO().find(result.getString("VIS_MATRICULE"));
                            }
                            else{
                                tab1[j]=result.getString(j+1);
                            }
                        }
                        else if(type=="DATETIME"){
                            col="";
                            col+=result.getDate(j+1);
                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            Date date = format.parse(col);
                            tab2[0]= date;
                        }
                        else if(type=="SMALLINT"){
                            tab4[0] = new PraticienDAO().find(result.getInt("PRA_NUM"));
                        }
                        else if(type=="INT"){
                            tab5[0]= result.getInt("RAP_NUM");
                        }
                    }
                    rap = new RapportVisite(tab3[0], tab5[0], tab4[0], tab2[0], tab1[4], tab1[5]);
                    rapports.add(i, rap);
                    i++;
                }
            } catch (SQLException e) {
		            e.printStackTrace();
		    } catch (ParseException ex) {
            Logger.getLogger(VisiteurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }


                return rapports;
    }
    
    public RapportVisite find(int id){
        RapportVisite rapport = new RapportVisite();
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE
            ).executeQuery("SELECT * FROM rapport_visite WHERE RAP_NUM = "+id);
            if(result.first()){
            		rapport = new RapportVisite(
                                new VisiteurDAO().find(result.getString("VIS_MATRICULE")),
                                id,
                                new PraticienDAO().find(result.getShort("PRA_NUM")),
                                result.getDate("RAP_DATE"),
                                result.getString("RAP_BILAN"),
                                result.getString("RAP_MOTIF")
                                    ); 
            }
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rapport;
    }

    public RapportVisite find(String Matricule){return new RapportVisite();}
    public RapportVisite find(String nom, Date date){return new RapportVisite();}
    public void delete(RapportVisite obj){
        try{
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                    .executeUpdate("DELETE FROM rapport_visite Where RAP_NUM='"+obj.getRapNum()+"'");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public ArrayList<RapportVisite> updateOffre(ArrayList<RapportVisite> obj){return new ArrayList();}
    public ArrayList<RapportVisite> findOffre(String vis, int rap){return new ArrayList();}
    
}
