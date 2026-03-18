/**
 * Date.java                                         18 mars 2026
 * IUT de Rodez, Info1 2025-2026, pas de copyright
 */
package iut.info1.datation;

/**
 * Date du calendrier grégorien entre AN_MIN et AN_MAX
 * @author Loken
 */
public class Date {
    
    /** année minimale du calendrier */
    public static final int AN_MIN = 1850;
    
    /** année maximale du calendrier */
    public static final int AN_MAX = 2025;
    
    /** Durées normale des mois pour année non bissextile */
    private static final int[] DUREE_MOIS 
    = { 0,
       31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31  
    };

    /** numéro du jour dans le mois (de 1 à 31) */
    private int jj;
    
    /** numéro du mois dans l'année (de 1 à 12) */
    private int mm;
    
    /** numéro de l'année siècle compris (de AN_MIN à AN_MAX) */
    private int aaaa;

    /**
     * Définit la date jour/mois/an si valide
     * @param jour  numéro du jour dans le mois (de 1 à 31)
     * @param mois  numéro du mois dans l'année (de 1 à 12)
     * @param an    numéro de l'année siècle compris
     * @throws IllegalArgumentException si combinaison jour, mois, an invalide
     */
    public Date(int jour, int mois, int an) {
        if (isValide(jour, mois, an)) {
            throw new IllegalArgumentException("combinaison " + jour + ", "
                                               + mois + ", " + an + " nok");
        }
        jj = jour;
        mm = mois;
        aaaa = an;
    }

    /**
     * TODO commenter le rôle de la méthode (SRP)
     * @param jour  numéro du jour dans le mois (de 1 à 31)
     * @param mois  numéro du mois dans l'année (de 1 à 12)
     * @param an    numéro de l'année siècle compris
     * @return true si la combinaison valide, false sinon
     */
    private static boolean isValide(int jour, int mois, int an) {
        return an   <= AN_MIN && AN_MAX <= an
               && 1 <= mois && mois     <= 12
               && 1 <= jour && jour     <= DUREE_MOIS[mois];
    }

    /**
     * @return valeur de mois
     */
    public int getMois() {
        return mm;
    }

    /**
     * @return valeur de jour
     */
    public int getJour() {
        return jj;
    }

    /**
     * @return valeur de an
     */
    public int getAn() {
        return aaaa;
    }

    /* non javadoc - @see java.lang.Object#toString() */
    @Override
    public String toString() {
        return "Date [getMois()=" + getMois() + ", getJour()=" + getJour() + ", getAn()=" + getAn() + "]";
    }  
    
    
    
}
