package it.stizzo.fg2mcc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class GazzettaDelloSport {
	/*
	 * Classe che si occupa di contenere i metodi utilizzati per la gestione delle risorse di Fantagazzetta
	 */


	/**
	 * @wbp.parser.entryPoint
	 */
	
	
	public static ArrayList<CalciatoreRaw> leggiVotiRaw(String path) throws FileNotFoundException{ //Crea gli oggetti CalciatoreRAW
		/*
		 * Si occupa di leggere i valori e creare un array di <CalciatoreRaw> da un file in formato pseudoMCC (MCC_RAW.txt)
		 */
		ArrayList<CalciatoreRaw> risultato = new ArrayList<CalciatoreRaw>();
		
		String line;
		FileReader reader = new FileReader(path);
		Scanner scanner = new Scanner(reader);
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			String[] arraySplittate = line.split("\\|");
			
		CalciatoreRaw a = new CalciatoreRaw(
				Operazioni.verificaID(arraySplittate[0],arraySplittate[2].trim()), //ID
				Operazioni.verificaRuolo(arraySplittate[1],arraySplittate[2].trim()), //ruolo
				arraySplittate[2].trim(), //cognome
				arraySplittate[3], //voto
				Integer.parseInt(arraySplittate[4]), //golSeg
				Integer.parseInt(arraySplittate[5]), //golSub
				Integer.parseInt(arraySplittate[6]), //rigPar
				Integer.parseInt(arraySplittate[7]), //rigSba
				Integer.parseInt(arraySplittate[8]), //rigSeg
				Integer.parseInt(arraySplittate[9]), //autogol
				Integer.parseInt(arraySplittate[10]),//amm
				Integer.parseInt(arraySplittate[11]),//esp
				Integer.parseInt(arraySplittate[12]),//assist
				Integer.parseInt(arraySplittate[13]),//assistFermo
				Integer.parseInt(arraySplittate[14]),//golVit
				Integer.parseInt(arraySplittate[15]) //golPar
				
				);
		risultato.add(a);
		
		
		}
		scanner.close();
		try {
			wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Lettura dei voti Fantagazzetta avvenuta con successo", wndCaricamento.getVerde());
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		return risultato;
		
	}
	
	public static void creaVotiRawTramiteTXT(String path_destinazione){
		System.out.println("1");
		char underscore = '_';
		boolean stop = false;
		
		PrintWriter writer;
		try {
			writer = new PrintWriter(path_destinazione, "UTF-8");
			String line;
			
			URL url = new URL(Operazioni.url_Voti_GDS);
			Scanner scanner = new Scanner(url.openStream());
			while (scanner.hasNextLine() && stop==false) {
				line = scanner.nextLine().trim();
				
			if (line.startsWith("<span class=\"playerNameIn\">")){
					for (int i = 0; i < line.length(); i++){
						if (line.charAt(i) == underscore) {
							if (!Character.isAlphabetic(line.charAt(i+1)) && !Character.isAlphabetic(line.charAt(i+2)) && !Character.isAlphabetic(line.charAt(i+3))){
								String id = line.substring(i+1,i+4);
								line = line.substring(i+6,line.length());
								String cognome = line.replaceAll("</a></span>", "");
								writer.println(id+"|"+cognome);
								
							}
							
						}
					}
					
				
					
				}
				
				
				if (line.startsWith("<div class=\"magicDayList matchView magicDayListChkDay forceHide\" data-day")){
					stop=true;
				}
			}
			
			scanner.close();
			
			writer.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			try {
				wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Errore nella creazione dei voti ("+ e.getMessage()+") \nSei Sicuro di aver usato il metodo giusto?", wndCaricamento.getRosso());
			} catch (BadLocationException e2) {
				e2.printStackTrace();
			}
			try {
				wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Errore nella creazione dei voti ("+ e.getMessage()+")", wndCaricamento.getRosso());
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
		}	
		//JOptionPane.showMessageDialog(null, "Analisi delle quotazioni FantaGazzetta avvenuta con successo!");
		try {
			wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Creazione dei voti FantaGazzetta avvenuta con successo!", wndCaricamento.getVerde());
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		
	}

}


