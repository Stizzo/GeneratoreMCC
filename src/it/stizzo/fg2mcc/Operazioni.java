package it.stizzo.fg2mcc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;

public class Operazioni {
	public static String version = "2.2.13";
	public static boolean beta_versione = false;	//disabilità il controllo versione
	public static ArrayList<Calciatore> ca;
	public static ArrayList<CalciatoreRaw> cr;
	public static int giornata;
	public static String redazione;
	public static ArrayList<String> squadre6politico;
	//public static String versione_rev = "77";
	

	public static final String url_MCC = "http://www.fantacalciando.altervista.org/GeneratoreMCC/Struttura_MCC.txt";
	public static final String url_CorrFG = "http://www.fantacalciando.altervista.org/GeneratoreMCC/Correzioni_FG.txt";
	public static final String url_CorrPF = "http://www.fantacalciando.altervista.org/GeneratoreMCC/Correzioni_PF.txt";
	public static final String url_versione = "http://www.fantacalciando.altervista.org/GeneratoreMCC/Versione.txt";
	public static final String url_Voti_GDS = "http://www.gazzetta.it/calcio/fantanews/voti/serie-a-2015-16/";
	public static final String url_Voti_Fantagazzetta = "http://www.fantagazzetta.com/Servizi/Excel.ashx?type=1&s=2016-17&t=214441567717&g=";
	
	public static int ID_temp = 999;
	
public static ArrayList<Calciatore> formatoMCC(ArrayList<Calciatore> a, ArrayList<CalciatoreRaw> b, ArrayList<Correzione> c){ //Converte i CalciatoreRAW in Calciatore
	/*
	 * Prende in input un array di <Calciatore> e ci aggiunge i voti/valori presi da un altro array di <CalciatoreRaw>
	 */
	String idCorretto;
	
	
	for (int i = 0; i < b.size(); i++){
		if (esisteCorrezione(c,""+b.get(i).getId())){
			idCorretto = cercaCorrezione(c, ""+b.get(i).getId());
			
			for (int j = 0; j < a.size(); j++){
				if (idCorretto.equals(""+a.get(j).getId())){
					a.get(j).setGiornata(Operazioni.giornata);
					if (b.get(i).getVotoNum()!=0){	
						a.get(j).setPresenza(1);
						a.get(j).setMinutiSup(1);
					} else {
						a.get(j).setMinutiInf(1);
						//a.get(j).setSenzavt(1);
					}
					
					a.get(j).setFantavoto(b.get(i).getFantaVoto());
					a.get(j).setVoto(b.get(i).getVotoNum());
					a.get(j).setGolSeg(b.get(i).getGolSeg()+b.get(i).getRigSeg());
					a.get(j).setGolSub(b.get(i).getGolSub());
					a.get(j).setGolVit(b.get(i).getGolVit());
					a.get(j).setGolPar(b.get(i).getGolPar());
					a.get(j).setAssist(b.get(i).getAssist());
					a.get(j).setAmm(b.get(i).getAmm());
					a.get(j).setEsp(b.get(i).getEsp());
					a.get(j).setRigTir(b.get(i).getRigSeg()+b.get(i).getRigSba()); 
					a.get(j).setRigSub(0); //Rigori subiti mancante come paramentro nel calciatoriRaw
					a.get(j).setRigPar(b.get(i).getRigPar());
					a.get(j).setRigSba(b.get(i).getRigSba());
					a.get(j).setAutogol(b.get(i).getAutogol());
			
				}
			}
		} else {
			
				//GESTIONE DEI NOMI ALL'INTERNO DELLA STRUTTURA MCC
				if (wndIntro.gestioneNomeSuMCC){
					for (int j = 0; j < a.size(); j++){
						 a.get(j).getCognome();
						String[] cognome =  a.get(j).getCognome().split(" ");
						String cognomeSenzaNome = "";
						for (int z = 0; z < cognome.length;z++){
							if (Character.isUpperCase(cognome[z].charAt(1)) || String.valueOf(cognome[z].charAt(1)).equals("\'")){
								cognomeSenzaNome = cognomeSenzaNome + " " + cognome[z];
								}
						}
						cognomeSenzaNome = cognomeSenzaNome.trim();
						if (b.get(i).getCognome().equals(cognomeSenzaNome)){
							a.get(j).setGiornata(Operazioni.giornata);
							if (b.get(i).getVotoNum()!=0){	
								a.get(j).setPresenza(1);
								a.get(j).setMinutiSup(1);
							} else {
								a.get(j).setMinutiInf(1);
								//a.get(j).setSenzavt(1);
							}
							

							a.get(j).setFantavoto(b.get(i).getFantaVoto());
							a.get(j).setVoto(b.get(i).getVotoNum());
							a.get(j).setGolSeg(b.get(i).getGolSeg()+b.get(i).getRigSeg());
							a.get(j).setGolSub(b.get(i).getGolSub());
							a.get(j).setGolVit(b.get(i).getGolVit());
							a.get(j).setGolPar(b.get(i).getGolPar());
							a.get(j).setAssist(b.get(i).getAssist());
							a.get(j).setAmm(b.get(i).getAmm());
							a.get(j).setEsp(b.get(i).getEsp());
							a.get(j).setRigTir(b.get(i).getRigSeg()+b.get(i).getRigSba()); 
							a.get(j).setRigSub(0); //Rigori subiti mancante come paramentro nel calciatoriRaw
							a.get(j).setRigPar(b.get(i).getRigPar());
							a.get(j).setRigSba(b.get(i).getRigSba());
							a.get(j).setAutogol(b.get(i).getAutogol());
							
						}
					}
				}
			 else {
				 //GESTIONE SENZA NOMI ALL'INTERNO DELLA STRUTTURA MCC
				for (int j = 0; j < a.size(); j++){
				if (b.get(i).getCognome().equals(a.get(j).getCognome())){
					a.get(j).setGiornata(Operazioni.giornata);
					if (b.get(i).getVotoNum()!=0){	
						a.get(j).setPresenza(1);
						a.get(j).setMinutiSup(1);
					} else {
						a.get(j).setMinutiInf(1);
						//a.get(j).setSenzavt(1);
					}
					

					a.get(j).setFantavoto(b.get(i).getFantaVoto());
					a.get(j).setVoto(b.get(i).getVotoNum());
					a.get(j).setGolSeg(b.get(i).getGolSeg()+b.get(i).getRigSeg());
					a.get(j).setGolSub(b.get(i).getGolSub());
					a.get(j).setGolVit(b.get(i).getGolVit());
					a.get(j).setGolPar(b.get(i).getGolPar());
					a.get(j).setAssist(b.get(i).getAssist());
					a.get(j).setAmm(b.get(i).getAmm());
					a.get(j).setEsp(b.get(i).getEsp());
					a.get(j).setRigTir(b.get(i).getRigSeg()+b.get(i).getRigSba()); 
					a.get(j).setRigSub(0); //Rigori subiti mancante come paramentro nel calciatoriRaw
					a.get(j).setRigPar(b.get(i).getRigPar());
					a.get(j).setRigSba(b.get(i).getRigSba());
					a.get(j).setAutogol(b.get(i).getAutogol());
					
				}
			}
		}
	}
		
	}

//for (int j = 0; j < a.size(); j++){
//	System.out.println(a.get(j).getId()+"|"+gui.giornata+"|"+"\""+a.get(j).getCognome()+"\""+"|"+a.get(j).getSquadra()+"|"+a.get(j).getTrasferito()+"|"+a.get(j).getRuolo()+"|"+a.get(j).getPresenza()+"|"+a.get(j).getFantavoto()+"|"+a.get(j).getMinutiInf()+"|"+a.get(j).getMinutiSup()+"|"+a.get(j).getVoto()+"|"+a.get(j).getGolSeg()+"|"+a.get(j).getGolSub()+"|"+a.get(j).getGolVit()+"|"+a.get(j).getGolPar()+"|"+a.get(j).getAssist()+"|"+a.get(j).getAmm()+"|"+a.get(j).getEsp()+"|"+a.get(j).getRigTir()+"|"+a.get(j).getRigSub()+"|"+a.get(j).getRigPar()+"|"+a.get(j).getRigSba()+"|"+a.get(j).getAutogol()+"|"+a.get(j).getEntrato()+"|"+a.get(j).getTitolare()+"|"+a.get(j).getSenzavt()+"|"+a.get(j).getIncasa()+"|"+a.get(j).getValore());
//}
	return a;
}

public static ArrayList<Quotazione> fuoriMCCdaQuotazioni(ArrayList<Calciatore> a, ArrayList<Quotazione> c, ArrayList<Correzione> co){ //Trova i calciatori con i cognomi non corrispondenti tra il file MCC e il file delle quotazioni
	/*Dato un array di calciatori a e dato un array di quotazioni c:
	 * restituisce i nomi dei calciatori quotati che non trovano corrispondenza nella lista dei calciatori
	 */
	String idCorretto;
	
	ArrayList<Quotazione> risultato = new ArrayList<Quotazione>();
	boolean trovato = false;
	for (int i = 0; i < c.size(); i ++){
		if (!esisteCorrezione(co, ""+c.get(i).getId())){
		trovato = false;
		for (int j = 0; j < a.size(); j++){
			if (wndIntro.gestioneNomeSuMCC){
				
				String[] cognome =  a.get(j).getCognome().split(" ");
				String cognomeSenzaNome = "";
				for (int z = 0; z < cognome.length;z++){
					if (Character.isUpperCase(cognome[z].charAt(1)) || String.valueOf(cognome[z].charAt(1)).equals("\'")){
						cognomeSenzaNome = cognomeSenzaNome + " " + cognome[z];
						}
				}
				cognomeSenzaNome = cognomeSenzaNome.trim();
				
				if (c.get(i).getCognome().equals(cognomeSenzaNome)){
					trovato = true;
				}
			}else{
				if (c.get(i).getCognome().equals(a.get(j).getCognome())){
					trovato = true;
				}
			}
			
		}
		
		if (!trovato){
			risultato.add(c.get(i));
			
		
		}
	}
	}
	return risultato;
	}

public static ArrayList<CalciatoreRaw> fuoriMCCdaCalciatoriRaw(ArrayList<Calciatore> a, ArrayList<CalciatoreRaw> c, ArrayList<Correzione> co){ //Trova i calciatori con i cognomi non corrispondenti tra il file MCC e il file delle quotazioni
	/*Dato un array di calciatori a e dato un array di CalciatoreRaw:
	 * restituisce i nomi dei calciatori che non trovano corrispondenza tra la lista dei calciatori MCC e la lista dei calciatori con i voti
	 */
	String idCorretto;
	
	ArrayList<CalciatoreRaw> risultato = new ArrayList<CalciatoreRaw>();
	boolean trovato = false;
	for (int i = 0; i < c.size(); i ++){
		if (!esisteCorrezione(co, ""+c.get(i).getId())){
		trovato = false;
		for (int j = 0; j < a.size(); j++){
			if (wndIntro.gestioneNomeSuMCC){
				
				String[] cognome =  a.get(j).getCognome().split(" ");
				String cognomeSenzaNome = "";
				for (int z = 0; z < cognome.length;z++){
					if (Character.isUpperCase(cognome[z].charAt(1)) || String.valueOf(cognome[z].charAt(1)).equals("\'")){
						cognomeSenzaNome = cognomeSenzaNome + " " + cognome[z];
						}
				}
				cognomeSenzaNome = cognomeSenzaNome.trim();
				
				if (c.get(i).getCognome().equals(cognomeSenzaNome)){
					trovato = true;
				}
				
			}else{
				if (c.get(i).getCognome().equals(a.get(j).getCognome())){
					trovato = true;
				}
			}
			
		}
		
		if (!trovato){
			risultato.add(c.get(i));
			
		}
	}
	}
	return risultato;
	}

public static ArrayList<Calciatore> inserisciQuotazioni(ArrayList<Calciatore> a, ArrayList<Quotazione> c, ArrayList<Correzione> co){ //Aggiunge le quotazioni ai Calciatore
	/*
	 * Aggiunge i valori  delle quotazioni dei calciatori da un array di <Quotazione> ad un array di <Calciatore>
	 */
	
	for (int i = 0; i < c.size(); i ++){
		if (esisteCorrezione(co, ""+c.get(i).getId())){
			String idCorretto = cercaCorrezione(co, ""+c.get(i).getId());
			for (int j = 0; j < a.size(); j++){
				if (idCorretto.equals(""+a.get(j).getId())){
					a.get(j).setValore((int) c.get(i).getCosto());
					
				}
			}	
		} else {
			if (wndIntro.gestioneNomeSuMCC){
				for (int g = 0; g < a.size(); g++){
				String[] cognome =  a.get(g).getCognome().split(" ");
				String cognomeSenzaNome = "";
				for (int z = 0; z < cognome.length;z++){
					if (Character.isUpperCase(cognome[z].charAt(1)) || String.valueOf(cognome[z].charAt(1)).equals("\'")){
					cognomeSenzaNome = cognomeSenzaNome + " " + cognome[z];
					
					}
				}
				cognomeSenzaNome = cognomeSenzaNome.trim();
				
					//System.out.println(c.get(i).getCognome() +" - " + cognomeSenzaNome);
				if (c.get(i).getCognome().equals(cognomeSenzaNome)){
					a.get(g).setValore((int) c.get(i).getCosto());
					//System.out.println("Quotazione "+cognomeSenzaNome + " - " + c.get(i).getCosto());
				
				}
				}
			}else{
				
			}
		for (int j = 0; j < a.size(); j++){
			if (c.get(i).getCognome().equals(a.get(j).getCognome())){
				a.get(j).setValore((int) c.get(i).getCosto());
			}
		}
		
	}

	}
		return a;
	
	
	
}

/* METODI RIMPIAZZATI PER VIA DELLA NON UNIVOCITA' DEI NOMI

public static ArrayList<CalciatoreRaw> correggiCognomi(ArrayList<CalciatoreRaw> b, ArrayList<Correzione> d){
	for (int i = 0; i <d.size();i++){
		for (int j = 0; j<b.size(); j++){
			if (d.get(i).getCalciatoreQuot().equals(b.get(j).getCognome())){
				b.get(j).setCognome(d.get(i).getCalciatoreMCC());
			}
		}
	}
	try {
		wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Nomi dei Calciatori corretti con successo", wndCaricamento.getVerde());
	} catch (BadLocationException e) {
		e.printStackTrace();
	}
	return b;
	
}

public static ArrayList<Quotazione> correggiQuotazioni(ArrayList<Quotazione> c, ArrayList<Correzione> d){
	for (int i = 0; i < d.size(); i++){
		for (int j = 0; j < c.size(); j++){
			if (d.get(i).getCalciatoreQuot().equals(c.get(j).getCognome())){
				c.get(j).setCognome(d.get(i).getCalciatoreMCC());
			}
		}
	}
	
	try {
		wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Nomi dei Calciatori delle quotazioni corretti con successo", wndCaricamento.getVerde());
	} catch (BadLocationException e) {
		e.printStackTrace();
	}
return c;
}
*/

public static ArrayList<Calciatore> leggiCalciatoriMCC(String path, int online) { //Crea gli oggetti Calciatore dal file MCC
	/*
	 * Metodo che si occupa di leggere la lista dei calciatori nel formato MCC
	 */
	ArrayList<Calciatore> risultato = new ArrayList<Calciatore>();
	Scanner scanner = null;
	String line;
	FileReader reader;
	try {
	if (online == 1){
			URL url = new URL(path);
			scanner = new Scanner(url.openStream());
	} else {
	reader = new FileReader(path);
	scanner = new Scanner(reader);
	}
	} catch (IOException e) {
	JOptionPane.showMessageDialog(null,"Impossibile connettersi al server");
		try {
			wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Errore nella lettura dei Calciatori MCC (" +e.getMessage() +")", wndCaricamento.getRosso());
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
	e.printStackTrace();
	}
	while (scanner.hasNextLine()) {
		line = scanner.nextLine();
		String[] arraySplittate = line.split("\\|");
		
		
		//Creazione di un calciatore scartando i parametri "di giornata"
			Calciatore a = new Calciatore(
					Integer.parseInt(arraySplittate[0]), 					//id
					Integer.parseInt(arraySplittate[1]), 					 //giornata
									arraySplittate[2].replaceAll("\"", "").trim(),  //cognome
									arraySplittate[3],  					//squadra
					Integer.parseInt(arraySplittate[4]),  					//trasferito
					Integer.parseInt(arraySplittate[5]),  					//ruolo
					0,  				//presenza
					0.0,  				//fantavoto
					0,  				//minutiInf
					0,  				//minutiSup
					0.0, 				//voto
					0, 					//golSeg
					0, 					//golSub
					0, 					//golVit
					0, 					//golPar
					0, 					//assist
					0, 					//amm
					0, 					//esp
					0, 					//rigTir
					0, 					//rigSub
					0, 					//rigPar
					0, 					//rigSba
					0, 					//autogol
					0, 					//entrato
					0, 					//titolare
					0, 					//senzavt
					0, 					//incasa
					Integer.parseInt(arraySplittate[27]));	//valore	Il valore rimane aggiornato nel caso venga trasferito
			risultato.add(a);
		
		
		//Creazione di un calciatore leggendone tutti i parametri
	/*	Calciatore a = new Calciatore(
	*			Integer.parseInt(arraySplittate[0]), 					//id
	*			Integer.parseInt(arraySplittate[1]), 					 //giornata
	*							arraySplittate[2].replaceAll("\"", ""),  //cognome
	*							arraySplittate[3],  					//squadra
	*			Integer.parseInt(arraySplittate[4]),  					//trasferito
	*			Integer.parseInt(arraySplittate[5]),  					//ruolo
	*			Integer.parseInt(arraySplittate[6]),  					//presenza
	*			Double.parseDouble(arraySplittate[7].replaceAll(",", ".")),  //fantavoto
	*			Integer.parseInt(arraySplittate[8]),  					//minutiInf
	*			Integer.parseInt(arraySplittate[9]),  					//minutiSup
	*			Double.parseDouble(arraySplittate[10].replaceAll(",",".")), //voto
	*			Integer.parseInt(arraySplittate[11]), 					//golSeg
	*			Integer.parseInt(arraySplittate[12]), 					//golSub
	*			Integer.parseInt(arraySplittate[13]), 					//golVit
	*			Integer.parseInt(arraySplittate[14]), 					//golPar
	*			Integer.parseInt(arraySplittate[15]), 					//assist
	*			Integer.parseInt(arraySplittate[16]), 					//amm
	*			Integer.parseInt(arraySplittate[17]), 					//esp
	*			Integer.parseInt(arraySplittate[18]), 					//rigTir
	*			Integer.parseInt(arraySplittate[19]), 					//rigSub
	*			Integer.parseInt(arraySplittate[20]), 					//rigPar
	*			Integer.parseInt(arraySplittate[21]), 					//rigSba
	*			Integer.parseInt(arraySplittate[22]), 					//autogol
	*			Integer.parseInt(arraySplittate[23]), 					//entrato
	*			Integer.parseInt(arraySplittate[24]), 					//titolare
	*			Integer.parseInt(arraySplittate[25]), 					//senzavt
	*			Integer.parseInt(arraySplittate[26]), 					//incasa
	*			Integer.parseInt(arraySplittate[27]));					//valore
	*	risultato.add(a);
	*/	
	}
	scanner.close();
	//JOptionPane.showMessageDialog(null, "Lettura e caricamento della struttura MCC avvenuta con successo!");
	try {
		wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "- Caricamento della lista dei calciatori avvenuta con successo", wndCaricamento.getVerde());
	} catch (BadLocationException e1) {
		e1.printStackTrace();}
	return risultato;
	
}

public static ArrayList<String> leggiSquadre(String path) throws FileNotFoundException{ //Legge le squadre
	/*
	 * Si occupa di leggere le squadre (metodo inutilizzato)
	 */
	ArrayList<String> risultato = new ArrayList<String>();
	String line;
	FileReader reader = new FileReader(path);
	Scanner scanner = new Scanner(reader);
	while (scanner.hasNextLine()) {
		line = scanner.nextLine();
		risultato.add(line.toString());
	}
	scanner.close();
	JOptionPane.showMessageDialog(null, "Caricamento squadre avvenuto con successo: "+path);
	return risultato;
	
}

public static void stampaMCC(ArrayList<Calciatore> a, String path_destinazione){ //Stampa il file MCC finito
	/*
	 * Prende in input la lista dei calciatori e un percorso.
	 * Crea il file MCCXX.txt con i valori dell'array <Calciatore>
	 */
	
	
		try {
			PrintWriter writer = new PrintWriter(path_destinazione, "UTF-8");
			for (int i=0; i<a.size();i++){
				//Controllo se il calciatore ha il 6 politico:
				boolean trovato_sv = false;
				double voto;
				double fantavoto;
				for (int z = 0; z < Operazioni.squadre6politico.size(); z++){
					if (a.get(i).getSquadra().equals("\""+Operazioni.squadre6politico.get(z)+"\"")){
						
						trovato_sv = true;
					}
				}
				if (trovato_sv){
					voto = 6.0;
					fantavoto = 6.0;
				} else {
					voto = a.get(i).getVoto();
					fantavoto = a.get(i).getFantavoto();
				}
				
				
				writer.println(a.get(i).getId()+"|"
			+Operazioni.giornata+"|\""
			+a.get(i).getCognome()+"\"|"
			+a.get(i).getSquadra()+"|"
			+a.get(i).getTrasferito()+"|"
			+a.get(i).getRuolo()+"|"
			+a.get(i).getPresenza()+"|"
			//+a.get(i).getFantavoto()+"|"
			+fantavoto+"|"
			+a.get(i).getMinutiInf()+"|"
			+a.get(i).getMinutiSup()+"|"
			//+a.get(i).getVoto()+"|"
			+voto+"|"
			+a.get(i).getGolSeg()+"|"
			+a.get(i).getGolSub()+"|"
			+a.get(i).getGolVit()+"|"
			+a.get(i).getGolPar()+"|"
			+a.get(i).getAssist()+"|"
			+a.get(i).getAmm()+"|"
			+a.get(i).getEsp()+"|"
			+a.get(i).getRigTir()+"|"
			+a.get(i).getRigSub()+"|"
			+a.get(i).getRigPar()+"|"
			+a.get(i).getRigSba()+"|"
			+a.get(i).getAutogol()+"|"
			+a.get(i).getEntrato()+"|"
			+a.get(i).getTitolare()+"|"
			+a.get(i).getSenzavt()+"|"
			+a.get(i).getIncasa()+"|"
			+a.get(i).getValore());
			}
			writer.close();
			try {
				wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- File MCC generato con successo!!!", wndCaricamento.getVerde());
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
			try {
				wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Errore nel generamento del file MCC ("+e.getMessage()+")", wndCaricamento.getRosso());
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
		}
	
}

public static ArrayList<Correzione> leggiCorrezioni(String path, int online){ //Crea gli oggetti Correzione
	/*
	 * Metodo che si occupa di leggere il file di testo Correzioni.txt e di creare i relativi oggetti
	 */
	ArrayList<Correzione> d = new ArrayList<Correzione>();	
	Scanner scanner = null;
	String line;
	FileReader reader;
	try {
	if (online == 1){
			URL url = new URL(path);
			scanner = new Scanner(url.openStream());
	} else {
	reader = new FileReader(path);
	scanner = new Scanner(reader);
	}
	} catch (IOException e) {
	//JOptionPane.showMessageDialog(null,e.getMessage());
		try {
			wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Errore nella lettura delle correzioni ("+e.getMessage() +")", wndCaricamento.getRosso());
		} catch (BadLocationException e1) {
			
			e1.printStackTrace();
		}	
	e.printStackTrace();
	}
	while (scanner.hasNextLine()) {
		line = scanner.nextLine();
		String[] arraySplittate = line.split("\\|");
		
		Correzione a = new Correzione(
				arraySplittate[0], //CalciatoreQuot
				arraySplittate[1]); //CalciatoreMCC
		d.add(a);
	}
	scanner.close();
	//JOptionPane.showMessageDialog(null, "Correzioni caricate con successo!");
	try {
		wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Caricamento della correzioni avvenuto con successo", wndCaricamento.getVerde());
	} catch (BadLocationException e1) {
		e1.printStackTrace();}
return d;
}

public static void stampaFuoriMCCdaQuotazione(ArrayList<Quotazione> z, String path) throws FileNotFoundException, UnsupportedEncodingException{ //Stampa un file txt con i calciatori con il cognome non corrispondente
	PrintWriter writer = new PrintWriter(path, "UTF-8");
	for (int i = 0; i < z.size(); i++){
		writer.println(z.get(i).getId() + " - " + z.get(i).getCognome()+" - " +z.get(i).getSquadra());
		//System.out.println(z.get(i).getId() + " - " + z.get(i).getCognome()+" - " +z.get(i).getSquadra());
	}
	writer.close();		
	try {
		wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- File dei calciatori non trovati generato con successo", wndCaricamento.getVerde());
	} catch (BadLocationException e) {
		e.printStackTrace();
	}

}

public static void stampaFuoriMCCdaCalciatoreRaw(ArrayList<CalciatoreRaw> z, String path) throws FileNotFoundException, UnsupportedEncodingException{ //Stampa un file txt con i calciatori con il cognome non corrispondente
	PrintWriter writer = new PrintWriter(path, "UTF-8");
	for (int i = 0; i < z.size(); i++){
		if (!z.get(i).getRuolo().equals("ALL")){
		writer.println(z.get(i).getId() + " - " + z.get(i).getCognome());
		}
		//System.out.println(z.get(i).getId() + " - " + z.get(i).getCognome()+" - " +z.get(i).getSquadra());
	}
	writer.close();		
	try {
		wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- File dei calciatori non trovati generato con successo", wndCaricamento.getVerde());
	} catch (BadLocationException e) {
		e.printStackTrace();
	}

}

public static void controllaAggiornamenti(){
	if (beta_versione){
		return;
	}
	
	try {
		URL url = new URL(Operazioni.url_versione);
		Scanner scanner = new Scanner(url.openStream());
		String line = scanner.nextLine().toString();
		if (line.equals("EndOfSupport")){
			System.exit(0);
		}else if (!line.equals(Operazioni.version)){
			JOptionPane.showMessageDialog(null, "E' disponibile una versione più aggiornata."+"\n"+"Controlla il forum per ulteriori dettagli."+"\n\n"+"Versione attuale: "+Operazioni.version+"\n"+"Ultima versione disponibile: "+line);
			scanner.close();
		}
	} catch (IOException e) {
		JOptionPane.showMessageDialog(null, "Impossibile collegarsi al server per il controllo degli aggiornamenti.\nVerifica di essere connesso ad internet e riavvia il programma per scaricare gli ultimi file ed aggiornamenti.");
		e.printStackTrace();
	}
}

public static int verificaID(String presuntoID, String calciatore){
	int ID;
try{
	ID = Integer.parseInt(presuntoID);
	}
	catch(Exception e){
		ID = ID_temp;
		ID_temp--;
		try {
			wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Rilevato il seguente calciatore senza ID nel file dei voti: "+calciatore+";"+"\n"+"Verrà utilizzato temporaneamente l'ID "+ID+" in fase di elaborazione.", wndCaricamento.getGiallo());
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
	//JOptionPane.showMessageDialog(null, "Rilevato il seguente calciatore senza ID nel file dei voti: "+calciatore+";"+"\n"+"Verrà utilizzato temporaneamente l'ID "+ID+" in fase di elaborazione.");
	}
return ID;
}

public static String verificaRuolo(String presuntoRuolo, String calciatore){
	String ruolo = presuntoRuolo;
	if (presuntoRuolo == ""){
		JOptionPane.showMessageDialog(null, "Errore nel rilevamento del ruolo del calciatore "+calciatore+";"+"\n"+"Verrà utilizzato temporaneamente il ruolo 'Z'");
	ruolo = "Z";
	}
return ruolo;
}

public static void caricaSuServerFTP(String percorsoFileLocale, String nomeFileSuServer){
	
	String server = wndPreferenze.getTxtReteIndirizzo().getText();
    int port = Integer.parseInt(wndPreferenze.getTxtRetePorta().getText());
    String user = wndPreferenze.getTxtReteUsername().getText();
    String pass = String.valueOf(wndPreferenze.getTxtRetePassword().getPassword());

    FTPClient ftpClient = new FTPClient();
    try {

        ftpClient.connect(server, port);
        ftpClient.login(user, pass);
        ftpClient.enterLocalPassiveMode();

        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

        // APPROACH #1: uploads first file using an InputStream
        File firstLocalFile = new File(percorsoFileLocale+"\\"+nomeFileSuServer);

        String firstRemoteFile = nomeFileSuServer;
        InputStream inputStream = new FileInputStream(firstLocalFile);

        try {
			wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Connessione stabilita, inizio a caricare il file " + nomeFileSuServer + " tramite FTP", wndCaricamento.getVerde());
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
        boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
        inputStream.close();
        if (done) {
        	try {
				wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- File "+ nomeFileSuServer +" uploadato con successo", wndCaricamento.getVerde());
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
        }
    } catch (IOException ex) {
        System.out.println("Error: " + ex.getMessage());
        ex.printStackTrace();
    } finally {
        try {
            if (ftpClient.isConnected()) {
                ftpClient.logout();
                ftpClient.disconnect();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

public static String pathDocumenti(){
		String path_destinazione = new JFileChooser().getCurrentDirectory().toString();
		return path_destinazione;
	}
	
public static boolean esisteCorrezione(ArrayList<Correzione> correzioni, String id){
	boolean trovato = false;
	for (int i = 0;i < correzioni.size(); i++){
		if (correzioni.get(i).getCodiceRedazione().equals(id)){
			trovato = true;
		}
	}
	return trovato;
}

public static String cercaCorrezione(ArrayList<Correzione> correzioni, String id){
	String risultato = "";
	for (int i = 0; i < correzioni.size(); i++){
		if (correzioni.get(i).getCodiceRedazione().equals(id)){
			risultato = correzioni.get(i).getCodiceMCC();
		}
	}
	return risultato;
}

public static ArrayList<Quotazione> controllaDuplicatiDaQuotazioni (ArrayList<Quotazione> q, ArrayList<Correzione> c){
	//TODO: implementare controllo incrociato con correzioni
	ArrayList<Quotazione> risultato = new ArrayList<Quotazione>();
	
	for (int i = 0; i < q.size(); i++){
		boolean trovato = false;
		for (int j = q.size()-1; j >=0; j--){
			if (q.get(i).getId() != q.get(j).getId() && q.get(i).getCognome().equals(q.get(j).getCognome())){
				trovato = true;
				risultato.add(q.get(j));
				q.remove(j);
			}
			
			}
		if (trovato){
			risultato.add(q.get(i));
			q.remove(i);
		}
	}
	//System.out.println(risultato.size());
	return risultato;
	
}

public static ArrayList<CalciatoreRaw> controllaDuplicatiDaCalciatoriRaw (ArrayList<CalciatoreRaw> q, ArrayList<Correzione> c){
	//TODO: implementare controllo incrociato con correzioni
	ArrayList<CalciatoreRaw> risultato = new ArrayList<CalciatoreRaw>();
	
	for (int i = 0; i < q.size(); i++){
		boolean trovato = false;
		for (int j = q.size()-1; j >=0; j--){
			if (q.get(i).getId() != q.get(j).getId() && q.get(i).getCognome().equals(q.get(j).getCognome())){
				trovato = true;
				risultato.add(q.get(j));
				q.remove(j);
			}
			
			}
		if (trovato){
			risultato.add(q.get(i));
			q.remove(i);
		}
	}
	//System.out.println(risultato.size());
	return risultato;
	
}

public static ArrayList<Calciatore> controllaDuplicatiNonGestitiSuMCC (ArrayList<Calciatore> ca2, ArrayList<Correzione> c){
	ArrayList<Calciatore> ca = (ArrayList<Calciatore>) ca2.clone();
	ArrayList<Calciatore> risultato = new ArrayList<Calciatore>();
	for (int i = 0; i < ca.size()-1; i++){
		boolean trovato = false;
		for (int j = ca.size()-1; j > i; j--){
			if (ca.get(i).getId() != ca.get(j).getId() && ca.get(i).getCognome().equals(ca.get(j).getCognome())){
				trovato = true;
				risultato.add(ca.get(j));
				ca.remove(j);
			}
			}
		if (trovato){
			risultato.add(ca.get(i));
			ca.remove(i);
		}
	}
	if (risultato.size()!=0){
		for (int l = risultato.size()-1; l >= 0; l--){
			for (int k = 0; k < c.size(); k++){	
				if (risultato.get(l).getId() == Integer.parseInt(c.get(k).getCodiceMCC())){
					risultato.remove(l);
					break;
				}
			}
		}
		}
	
	return risultato;
	
}

private ArrayList<String> removeDuplicates(ArrayList<String> list_with_duplicates){
	ArrayList<String> result = new ArrayList<String>();
	Set<String> removeDuplicates = new HashSet<>();
	removeDuplicates.addAll(list_with_duplicates);
	result.clear();
	result.addAll(removeDuplicates);
	return result;
}
}

