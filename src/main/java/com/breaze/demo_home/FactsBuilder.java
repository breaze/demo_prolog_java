/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.breaze.demo_home;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.jpl7.Query;

/**
 *
 * @author simon
 */
public class FactsBuilder {
    private Connection conn;
    
    public FactsBuilder(){
        this.conn = MySQLConnection.getInstance().getConnection();
    }
    
    public static boolean construirFactsOrganismo(){
        OrganismoDAO dao = new OrganismoDAO();
        try{
            List<Organismo> lista = dao.buscarTodos();
            
            for(Organismo t : lista){
                StringBuilder sb = new StringBuilder();
                sb.append("assertz(organismo(")
                        .append(t.getId()).append(",")
                        .append(t.getNombre()).append(",")
                        .append(t.getEspecie()).append("))");
                PrologQueryExecutor.createDynamicFact(sb.toString());
            }
        }catch(SQLException e){
            System.out.println("Error retrieving data");
        }
        return true;
    }
    
    

    
}
