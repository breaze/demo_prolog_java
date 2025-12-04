/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.breaze.demo_home;

import java.util.List;
import org.jpl7.Query;

/**
 *
 * @author simon
 */
public class Demo_home {

    public static void main(String[] args) {
        String rules = "consult('prolog.pl')";
       
        Query q = new Query(rules);

        if (q.hasSolution()) {
            System.out.println("Archivo Prolog cargado correctamente.");
        }
        FactsBuilder.construirFactsOrganismo();
        List<Organismo> lista = PrologQueryExecutor.getAnimals("organismo(Id, jaguar, Especie)");
        for(Organismo o : lista){
            System.out.println("Nombre: " + o.getId());
            System.out.println("Nombre: " + o.getNombre());
            System.out.println("Nombre: " + o.getEspecie());
        }      
        List<Depredacion> depredaciones = PrologQueryExecutor.getDepredaciones("depreda(Depredador, Presa).");
        for(Depredacion d : depredaciones){
            System.out.println("Depredador: " + d.getDepredador());
            System.out.println("Presa: " + d.getPresa());
        }   
        
    }
}
