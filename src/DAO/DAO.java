/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ENTITE.Offrir;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import jdbc.ConnexionSwissVisiteSQL;

public abstract class DAO<T> {
    public Connection connect = ConnexionSwissVisiteSQL.getInstance();
    
    
    /* Permet de récupérer un objet */
    
    public abstract ArrayList<T> find();
    
    /* Permet de récupérer un objet via un ID 
     * @param id */
    
    public abstract T find(int id);
    
    /* Permet de récupérer un objet via un Matricule 
     * @param Matricule */
    
    public abstract T find(String Matricule);
    
    /* Permet de récupérer un objet via un nom et une date 
     * @param nom
     * @param date */
    
    public abstract T find(String nom, Date date);
    /* Permet de créer une entrée dans la base de données par rapport à un objet
     * @ param obj */
    
    public abstract T create(T obj);
    
    /* Permet de mettre à jour les données d'une entrée dans la base  
     * @param obj */
    
    public abstract T update(T obj);
    
    /* Permet la suppression d'une entrée dans une base 
    * @param obj */
    
    public abstract void delete(T obj);
    
    /* Permet de récupérer un à plusieurs objets via un nom et une date 
     * @param matricule
     * @param num */
    
    public abstract ArrayList<T> findOffre(String matricule, int num);
    
}
