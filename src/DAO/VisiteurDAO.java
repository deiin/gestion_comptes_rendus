package DAO;

/**
 *
 * @author Dan
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import ENTITE.Visiteur;
import DAO.DAO;
import ENTITE.Labo;
import ENTITE.Secteur;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VisiteurDAO extends DAO<Visiteur> {
    
        public ArrayList<Visiteur> find() {
            ArrayList<Visiteur> visiteurs = new ArrayList();
            String col="";
            String type="";
            String tab1[]= new String[11];
            Date tab2[] = new Date[3];
            Secteur tab3[] = new Secteur[3];
            Labo tab4[] = new Labo[3];
            Visiteur vis;
            try{
                ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                        .executeQuery("SELECT * FROM visiteur order by VIS_MATRICULE DESC");
                ResultSetMetaData rsmd = result.getMetaData();
                int nbcol = rsmd.getColumnCount();
                while(result.next()){
                    int i=0;
                    for(int j=0; j<nbcol; j++){
                        type=rsmd.getColumnTypeName(j+1);
                        if(type=="VARCHAR"){
                            if(j==7){
                                tab3[0]= new SecteurDAO().find(result.getString("SEC_CODE"));
                            }
                            else if (j==8){
                                tab4[0]= new LaboDAO().find(result.getString("LAB_CODE"));
                            }
                            else{
                                tab1[j]=result.getString(j+1);
                            }
                        }
                        else if(type=="DATETIME"){
                            col="";
                            type="Date";
                            col+=result.getDate(j+1);
                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            Date date = format.parse(col);
                            tab2[0]= date;
                        }
                    }
                    vis = new Visiteur(tab1[0], tab1[1], tab1[2], tab1[3], tab1[4], tab1[5], tab2[0], tab3[0], tab4[0]);
                    visiteurs.add(i, vis);
                    i++;
                }

            } catch (SQLException e) {
		            e.printStackTrace();
		    } catch (ParseException ex) {
            Logger.getLogger(VisiteurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }


                return visiteurs;
        }
        
        

	public Visiteur find(String nom, Date date) {
		Visiteur vis = new Visiteur();
                SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");
                String dateChange = formatdate.format(date);
		try {
            ResultSet result = this .connect
                                    .createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT * FROM visiteur WHERE VIS_NOM = '" +nom+ "' and VIS_DATEEMBAUCHE= '"+dateChange+"'"
                                             );
            if(result.first()){
            		vis = new Visiteur(
                                result.getString("VIS_MATRICULE"),
                                nom,
                                result.getString("VIS_PRENOM"),
                                result.getString("VIS_ADRESSE"),
                                result.getString("VIS_CP"),
                                result.getString("VIS_VILLE"),
                                date,
                                new SecteurDAO().find(result.getString("SEC_CODE")),
                                new LaboDAO().find(result.getString("LAB_CODE"))
                                    );            
            }
		    } catch (SQLException e) {
		            e.printStackTrace();
		    }
		   return vis;
	}
        
        
        
        
        public Visiteur find(String visMatricule) {
            Visiteur vis = new Visiteur();
            try {
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE
            ).executeQuery("SELECT * FROM visiteur WHERE VIS_MATRICULE = '" +visMatricule+ "'");
            if(result.first()){
            		vis = new Visiteur(
                                visMatricule,
                                result.getString("VIS_NOM"),
                                result.getString("VIS_PRENOM"),
                                result.getString("VIS_ADRESSE"),
                                result.getString("VIS_CP"),
                                result.getString("VIS_VILLE"),
                                result.getDate("VIS_DATEEMBAUCHE"),
                                new SecteurDAO().find(result.getString("SEC_CODE")),
                                new LaboDAO().find(result.getString("LAB_CODE"))
                                    );            
            }
		    } catch (SQLException e) {
		            e.printStackTrace();
		    }
		   return vis;
	}
        
        public Visiteur create(Visiteur obj) {
            try {
                PreparedStatement prepare = this.connect
                        .prepareStatement("INSERT INTO visiteur (VIS_MATRICULE, VIS_NOM, VIS_PRENOM, VIS_ADRESSE, VIS_CP, VIS_VILLE, VIS_DATEEMBAUCHE, SEC_CODE, LAB_CODE)"+
                                            			"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)"
                                                    );
				prepare.setString(1, obj.getVisMatricule());
                                prepare.setString(2, obj.getVisNom());
                                prepare.setString(3, obj.getVisPRENOM());
                                prepare.setString(4, obj.getVisAdresse());
                                prepare.setString(5, obj.getVisCp());
                                prepare.setString(6, obj.getVisVille());
				prepare.setDate(7, new java.sql.Date(obj.getVisDateembauche().getYear(), obj.getVisDateembauche().getMonth(), obj.getVisDateembauche().getDate()));
                                prepare.setString(8, obj.getSecCode().getSecCode());
                                prepare.setString(9, obj.getLabCode().getLabCode());
				
				prepare.executeUpdate();
				obj = this.find(obj.getVisMatricule());	
				
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
            return obj;
        }
	public Visiteur update(Visiteur obj) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try{
                this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE
                ).executeUpdate("UPDATE visiteur SET VIS_NOM='"+obj.getVisNom()+"',"
                        + " VIS_PRENOM='"+obj.getVisPRENOM()+"',"
                        + " VIS_ADRESSE='"+obj.getVisAdresse()+"',"
                        + " VIS_CP='"+obj.getVisCp()+"',"
                        + " VIS_VILLE='"+obj.getVisVille()+"',"
                        + " VIS_DATEEMBAUCHE='"+format.format(obj.getVisDateembauche())+"',"
                        + " SEC_CODE='"+obj.getSecCode().getSecCode()+"',"
                        + " LAB_CODE='"+obj.getLabCode().getLabCode()+"' "
                        + " where VIS_MATRICULE='"+obj.getVisMatricule()+"'"
                );
                obj = this.find(obj.getVisMatricule());

            }catch(SQLException e){
                e.printStackTrace();
            }
            return obj;
        }
	public void delete(Visiteur obj) {
            try{
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                    .executeUpdate("DELETE FROM visiteur Where VIS_MATRICULE='"+obj.getVisMatricule()+"'");
        }catch(SQLException e){
            e.printStackTrace();
        }
        }
        public Visiteur find(int id) {return new Visiteur();}
        public ArrayList<Visiteur> findOffre(String vis, int rap){return new ArrayList();}
    
}
