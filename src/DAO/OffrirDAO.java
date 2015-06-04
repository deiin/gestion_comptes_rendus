package DAO;

import ENTITE.Medicament;
import ENTITE.Offrir;
import ENTITE.RapportVisite;
import ENTITE.Visiteur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Dan
 */
public class OffrirDAO extends DAO<Offrir> {
    
    public ArrayList<Offrir> findOffre(String vis, int rap){
        ArrayList<Offrir> offres = new ArrayList();
        String col="";
        String type="";
        Visiteur tab1[] = new Visiteur[1];
        RapportVisite tab2[] = new RapportVisite[1];
        Medicament tab3[] = new Medicament[1];
        short tab4[] = new short[1];
        Offrir off;
        
        try{
                ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                        .executeQuery("Select * FROM offrir WHERE VIS_MATRICULE='"+vis+"' AND RAP_NUM="+rap+" ORDER BY MED_DEPOTLEGAL desc");
                ResultSetMetaData rsmd = result.getMetaData();
                int nbcol = rsmd.getColumnCount();
                while(result.next()){
                    int i=0;
                    for(int j=0; j<nbcol; j++){
                        type=rsmd.getColumnTypeName(j+1);
                        if(type=="VARCHAR"){
                            if(j==0){
                                tab1[0]= new VisiteurDAO().find(result.getString("VIS_MATRICULE"));
                            }
                            else{
                                tab3[0]=new MedicamentDAO().find(result.getString("MED_DEPOTLEGAL"));
                            }
                        }
                        else if(type=="INT"){
                            tab2[0]= new RapportVisiteDAO().find(result.getInt("RAP_NUM"));
                        }
                        else{
                            tab4[0] = result.getShort("OFF_QTE");
                        }
                    }
                    off = new Offrir(tab1[0], tab2[0], tab3[0], tab4[0]);
                    offres.add(i, off);
                    i++;
                }
            } catch (SQLException e) {
		            e.printStackTrace();
		    }
        
        return offres;
    }

    public Offrir create(Offrir obj) {
        try {
                PreparedStatement prepare = this.connect
                        .prepareStatement("INSERT INTO offrir (VIS_MATRICULE, RAP_NUM, MED_DEPOTLEGAL, OFF_QTE)"+
                                            			"VALUES(?, ?, ?, ?)"
                                                    );
				prepare.setString(1, obj.getVisMatricule().getVisMatricule());
				prepare.setInt(2, obj.getRapNum().getRapNum());
				prepare.setString(3, obj.getMedDepotlegal().getMedDepotlegal());
				prepare.setShort(4, obj.getOffQte());
                                
				prepare.executeUpdate();
				obj = this.find(obj.getRapNum().getRapNum());	
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
    }
    
    public void delete(Offrir obj) {
        try{
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                    .executeUpdate("DELETE FROM offrir Where RAP_NUM='"+obj.getRapNum().getRapNum()+"' AND VIS_MATRICULE='"+obj.getVisMatricule().getVisMatricule()+"'");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    public Offrir find(String Matricule) {return new Offrir();}
    public Offrir find(String nom, Date date) {return new Offrir();}
    public ArrayList<Offrir> find() {return new ArrayList();}
    public Offrir find(int id) {return new Offrir();}
    public Offrir update(Offrir obj){return obj;}
    
    
    
}
