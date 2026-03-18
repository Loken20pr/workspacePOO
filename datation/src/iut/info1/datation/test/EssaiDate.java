/**
 * EssaiDate.java                                         18 mars 2026
 * IUT de Rodez, Info1 2025-2026, pas de copyright
 */
package iut.info1.datation.test;

import iut.info1.datation.Date;

/**
 * Exemple de mise en oeuvre de la classe iut.info1.datation.Date
 * @author loken
 */
public class EssaiDate {

    /**
     * Créé des dates grégoriennes et mettre en oeuvre quelques 
     * comportements
     * @param args non utilisé
     */
    public static void main(String[] args) {
        
        Date actuelle;
        Date debile;
        
        actuelle = new Date(18, 3, 2026);
        debile   = new Date(83, 3, -5452026);
        
        System.out.println("actuelle = " + actuelle);
        System.out.println("debile = " + debile);

    }

}
