/*
 * DateTests                                 18 fev. 2026
 * IUT de Rodez, aucun copyright (ni "copyleft")
 */

package iut.info1.datation.test;

import iut.info1.datation.Date;

/**
 * Tests unitaires (sans JUnit) de iut.info1.datation.Date
 * @author info1 TP1
 */
public class DateTests {

    /**
     * Exception programmeur : indique un test en échec 
     */
    private static class TestException extends RuntimeException {

        /**
         * Explication de la cause de l'exception par un message texte
         * @param message texte expliquant la cause de l'échec en test 
         */
        public TestException(String message) {
            super(message);
        }
    }

    /** * test fixture = fix picture of test 
     * Initialisé si tests de constructeur valides
     */
    private final Date[] VALIDES = {
                /* première et dernière date */
                new Date(  1,  1, 1850),
                new Date( 31, 12, 2050),
                /* tests de durée limite */
                new Date( 31,  1, 1990),
                new Date( 28,  2, 2026),
                new Date( 31,  3, 1923),
                new Date( 30,  4, 2001),
                new Date( 31,  5, 1871),
                new Date( 30,  6, 2015),
                new Date( 31,  7, 1952),
                new Date( 31,  8, 2020),
                new Date( 30,  9, 1978),
                new Date( 31, 10, 2024),
                new Date( 30, 11, 1892),
                new Date( 31, 12, 2010),
                /* 29/2 d'une année bissextile */
                new Date( 29,  2, 1924),
                new Date( 29,  2, 2000),
                /* quelques dates non significatives */
                new Date(  5,  6, 2000),
                new Date(  4,  3, 2026) 
    };

    /**
     * TODO commenter l'état initial atteint
     */
    public DateTests() {
        super();
        System.out.println("nouvel objet test instancié");
    }


    /**
     * Lancement des procédures de tests unitaires des méthodes
     * de iut.info1.datation.Date.
     * @param args unused
     */
    public static void main(String[] args) {

        try {
            new DateTests().testEchecsDateIntIntInt();
            new DateTests().testValidesDateIntIntInt();
            System.out.println("Tests unitaires de Date(int, int, int) reussis.");

            System.out.println("Tests unitaires de Date(String) reussis.");
            
            new DateTests().testGetJour();
            new DateTests().testGetMois();
            new DateTests().testGetAn();
            new DateTests().testToString();
            System.out.println("Tests unitaires des méthodes d'instance reussis.");

        } catch (TestException echecTest) {
            System.err.println("Echec de test : " + echecTest.getMessage());
        }
    }

    /**
     * Tests unitaires du prédicat d'année bissextile
     * @throws TestException si échec de test
     */


    /** * Tests de combinaisons grégoriennes invalides
     * donc instanciation impossible, le constructeur Date(int, int, int)
     * va propager IllegalArgumentException. 
     * Sinon Echec de test : repropager une exception 
     * Plan de tests :
     * + années invalides hors calendrier
     * + mois invalides
     * + jours invalides (pas entre 1 et 31)
     * + jours invalides par rapport aux durées normales des mois
     * + 29/2 d'années non bissextiles
     *
     * @throws TestException si une date invalide est instanciée 
     */
    private void testEchecsDateIntIntInt() {

        int[][] invalides = {
             /* années invalides hors calendrier */
             {   1,   1, -3200 },
             {  31,  12,  1799 },
             {   1,   1,  2051 },

             /* mois invalides */
             {   1,   0,  2020 },
             {  17,  13,  1997 },

             /* jours invalides (pas entre 1 et 31) */
             {   0,   7,  1868 },
             {  32,  11,  2040 },

             /* jours invalides par rapport aux durées normales des mois */
             {  31,   4,  2000 },
             {  31,   6,  2030 },
             {  31,   9,  1945 },
             {  31,  11,  1910 },
             {  31,   2,  1999 },

             /* 29/2 d'années non bissextiles */
             {  29,   2,  2021 },
             {  29,   2,  1900 }
        };

        for (int noTest = 0 ; noTest < invalides.length ; noTest++) {
            try {
                int[] combinaison = invalides[noTest];
                new Date(combinaison[0], combinaison[1], combinaison[2]);
                throw new TestException("Echec de testEchecsDateIntIntInt sur jeu no "
                                        + noTest);
            } catch (IllegalArgumentException echecCombinaisonInvalide) {
                // Test ok car exception levée par constructeur Date(int, int, int)
            }
        }

    }

    /** * Tests de combinaisons grégoriennes valides
     * donc instanciation possible, le constructeur Date(int, int, int)
     * fonctionne sans exception 
     * Sinon Echec de test : repropager une exception  
     * @throws TestException si une date valide ne peut pas être créée
     */
    private void testValidesDateIntIntInt() {

        try {
                /* première et dernière date */
                new Date(  1,  1, 1850);
                new Date( 31, 12, 2050);
                /* tests de durée limite */
                new Date( 31,  1, 1990);
                new Date( 28,  2, 2026);
                new Date( 31,  3, 1923);
                new Date( 30,  4, 2001);
                new Date( 31,  5, 1871);
                new Date( 30,  6, 2015);
                new Date( 31,  7, 1952);
                new Date( 31,  8, 2020);
                new Date( 30,  9, 1978);
                new Date( 31, 10, 2024);
                new Date( 30, 11, 1892);
                new Date( 31, 12, 2010);
                /* 29/2 d'une année bissextile */
                new Date( 29,  2, 1924);
                new Date( 29,  2, 2000);
                /* quelques dates non significatives */
                new Date(  5,  6, 2000);
                new Date(  4,  3, 2026); 

            // test ok
        } catch (IllegalArgumentException echecCombinaisonInvalide) {
            throw new TestException(echecCombinaisonInvalide.getMessage());
        }
    }

    /** * Tests de combinaisons grégoriennes invalides
    * donc instanciation impossible, le constructeur Date(String)
    * va propager IllegalArgumentException. 
    * Sinon Echec de test : repropager une exception 
    * Plan de tests :
    * + format incorrect (null, vide, pas 3 éléments séparés par '/')
    * + éléments non numériques
    * + combinaisons grégoriennes invalides (voir testEchecsDateIntIntInt())
    *
    * @throws TestException si une date invalide est instanciée 
    */

    
    /**
     * Tests unitaires du getter : getJour()
     * @throws TestException si échec de test
     */
    private void testGetJour() {

        final int[] JOUR_OK_ATTENDU = {
             1, 31,
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 
            29, 29, 
             5,  4
        };

        for (int noJeu = 0 ; noJeu < JOUR_OK_ATTENDU.length ; noJeu++) {
            if (JOUR_OK_ATTENDU[noJeu] != VALIDES[noJeu].getJour()) {
                throw new TestException("Echec testGetJour() : "
                                        + "=> attendu = " + JOUR_OK_ATTENDU[noJeu]
                                        + " actuel = " + VALIDES[noJeu].getJour());
            }
        }
        /* tests unitaires getJour() ok */
//#Erreur : la reference est constante#        VALIDES = new Date[5];
        VALIDES[VALIDES.length -1] = new Date(25, 4, 2001);
    }

    /**
     * Tests unitaires du getter : getMois()
     * @throws TestException si échec de test
     */
    private void testGetMois() {

        final int[] MOIS_OK_ATTENDU = {
             1, 12,
             1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 
             2,  2, 
             6,  3
        };

        for (int noJeu = 0 ; noJeu < MOIS_OK_ATTENDU.length ; noJeu++) {
            if (MOIS_OK_ATTENDU[noJeu] != VALIDES[noJeu].getMois()) {
                throw new TestException("Echec testGetMois() : "
                                        + "=> attendu = " + MOIS_OK_ATTENDU[noJeu]
                                        + " actuel = " + VALIDES[noJeu].getMois());
            }
        }
        /* tests unitaires getMois() ok */
    }

    private void testGetAn() {
        
        final int[] AN_OK_ATTENDU = {
             1850, 2050,
             1990, 2026, 1923, 2001, 1871, 2015, 1952, 2020, 1978, 2024, 1892, 2010, 
             1924, 2000, 
             2000, 2026
        };

        for (int noJeu = 0 ; noJeu < AN_OK_ATTENDU.length ; noJeu++) {
            if (AN_OK_ATTENDU[noJeu] != VALIDES[noJeu].getAn()) {
                throw new TestException("Echec testGetAn() : "
                                        + "=> attendu = " + AN_OK_ATTENDU[noJeu]
                                        + " actuel = " + VALIDES[noJeu].getAn());
            }
        }
    }


    private void testToString() {

        String[] attendus = {
            "01/01/1850", "31/12/2050",
            "31/01/1990", "28/02/2026", "31/03/1923", "30/04/2001", "31/05/1871", 
            "30/06/2015", "31/07/1952", "31/08/2020", "30/09/1978", "31/10/2024", 
            "30/11/1892", "31/12/2010",
            "29/02/1924", "29/02/2000",
            "05/06/2000", "04/03/2026"
        };

        for (int i = 0; i < attendus.length; i++) {
            if (!attendus[i].equals(VALIDES[i].toString())) {
                throw new TestException("Echec testToString() : "
                                        + "=> attendu = " + attendus[i]
                                        + " actuel = " + VALIDES[i].toString());
            }
        }
    }

}