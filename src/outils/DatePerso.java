package outils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePerso {
	/**
	 * Display of today's date in <b> dd / mm / year </b> format
	 */
	public static String aujourdhui() {
		SimpleDateFormat formater = null;
		Date aujourdhui = new Date();
		formater = new SimpleDateFormat("dd/MM/yy");
		return formater.format(aujourdhui);
	}
	
	/**
	 * Time display in <b> HH h mm </b> format
	 */
	public static String maintenant() {
		SimpleDateFormat formater = null;
		Date aujourdhui = new Date();
		formater = new SimpleDateFormat("HH'h'mm");
		return formater.format(aujourdhui);
	}
	
	/**
	 * Entering a date by day, month and year <br>
	 * Date display so good format
	 */
	public static void  saisirDate() {
		int jour;
		do {
			System.out.println("Veuillez saisir le jour : "); 
		    jour = Clavier.lireInt();
		}while(jour < 1 || jour > 31);
	    
		int mois;
		do {
		    System.out.println("Veuillez saisir le mois : "); 
		    mois = Clavier.lireInt();
		}while(mois <1 || mois > 12);
	    
		int annee;
		do {
		    System.out.println("Veuillez saisir l'année : "); 
		    annee = Clavier.lireInt();
		}while(annee < 1);
		
	    stringEnDate(jour + "/" + mois + "/" + annee);
	}
	
	/**
	 * Displays if the year is bisextile
	 * @param annee
	 * @return boolean
	 */
	public static boolean isBissextile(int annee) {	
  		return annee % 400 == 0 || annee % 4 == 0 && annee % 100 != 0 ;
	}
	
	/**
	 * Returns the next bisextiele year from a date
	 * @param annee
	 * @return --> the next bisextile year
	 */
	public static int prochaineAnneeBisextile(int annee) {
		boolean bissextile;
		do {
			annee++;
			bissextile = isBissextile(annee); 
			
		}while (!bissextile);
		return annee; 
	}
	 
	/**
	 * Turns a string into a date
	 * @param maDate
	 */
	private static void stringEnDate(String maDate) {
    	SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
    	formater.setLenient(false); //will generate an error on incorrect dates style February 30th. Format becomes more strict.
	    try 
	    {
			Date stringDate = formater.parse(maDate);
			System.out.println(formater.format(stringDate)); 
	    
		} catch (ParseException e) {
			System.out.println("Attention ! " + maDate + " n'est pas une date valide");
		}
    }
}
