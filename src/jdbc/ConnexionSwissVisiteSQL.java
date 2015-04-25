/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnexionSwissVisiteSQL {
    
    /* URL connection */
    
    private static String url ="jdbc:mysql://localhost:3306/swiss_visite?zeroDateTimeBehavior=convertToNull";
    
    /* Nom user */
    
    private static String user="root";
    
    /*Mot de passe user*/
    
    private static String mdp ="Ligfy!";
    
    /* Objet de connection */
    
    private static Connection connect;
    
    /* Méthode qui va retourner notre instance et la créer si elle n'esxiste pas */
    
    public static Connection getInstance(){
        if(connect==null){
            try{
                connect=DriverManager.getConnection(url, user, mdp);
            } catch(SQLException e){
                e.printStackTrace();
            
            }
        }
        return connect;
    
    }
    
    
    
}
