/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.breaze.demo_home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author simon
 */
public class OrganismoDAO {
    private Connection conn;   // <–– the connection stays here as an attribute

    public OrganismoDAO() {
        this.conn = MySQLConnection.getInstance().getConnection();
    }

    public List<Organismo> buscarTodos() throws SQLException {
        String sql = "SELECT id, nombre, especie FROM organismo";
        List<Organismo> lista = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(mapRow(rs));
            }
        } finally {
            if (rs != null) {
                try {
                    rs.close(); 
                } catch (SQLException ignored) {
                    System.out.println("Error closing result set");
                }
            }
                
            if (ps != null){
                try {
                    ps.close(); 
                } catch (SQLException ignored) {
                    System.out.println("Error closing prepared statement");
                }
            }
        }

        return lista;
    }
    
    
    private Organismo mapRow(ResultSet rs) throws SQLException {
        Organismo o = new Organismo();
        o.setId(rs.getInt("id"));
        o.setNombre(rs.getString("nombre"));
        o.setEspecie(rs.getString("especie"));
        return o;
    }
}
