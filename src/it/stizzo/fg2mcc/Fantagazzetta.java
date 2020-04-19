package it.stizzo.fg2mcc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.text.BadLocationException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Fantagazzetta {
	/*
	 * Classe che si occupa di contenere i metodi utilizzati per la gestione delle risorse di Fantagazzetta
	 */
	public static ArrayList<Correzione> co;
	public static ArrayList<Quotazione> q;

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void creaVotiRawTramiteXLS(String path_sorgente, String path_destinazione, boolean online, String numGiornata){
		//Importo il percorso del file excel e la lista dei calciatori
			try
	        {
				int colonna_incriminata = 0;
				PrintWriter writer = new PrintWriter(path_destinazione, "UTF-8"); 
				Workbook workbook;
				if (online){
				 workbook = WorkbookFactory.create(new URL(path_sorgente+numGiornata).openStream());
				}else{
				
				 workbook = WorkbookFactory.create(new File(path_sorgente));
				}
				//XSSFWorkbook workbook = new XSSFWorkbook(file);
				Sheet sheet = null;
				
				switch (Operazioni.redazione){
				case "Fantagazzetta": 
				sheet = workbook.getSheetAt(0); //Prendo il primo foglio di lavoro
					break;
				case "Statistico":
					sheet = workbook.getSheetAt(1);
					break;
				case "Italia":
					sheet = workbook.getSheetAt(2);
					break;	
			}
				
				
				Iterator<Row> rowIterator = sheet.iterator(); //itero ogni riga
				
				while (rowIterator.hasNext()){
					
					Row row = rowIterator.next();
					Iterator<Cell> cellIterator = row.cellIterator();
					
					while (cellIterator.hasNext()){
							Cell cell = cellIterator.next();
						
							switch (cell.getCellType()){
						case Cell.CELL_TYPE_BLANK:
							if (row.getCell(colonna_incriminata+1).getStringCellValue().isEmpty()){
								break;
								}else{
								writer.print("vuoto|");}
						break;
						case Cell.CELL_TYPE_STRING:
							if (cell.getColumnIndex() == colonna_incriminata){
								for (int i = 1; i < row.getPhysicalNumberOfCells(); i++){
									cellIterator.next();
								}
								break;
							}
							if (cellIterator.hasNext()){
								//System.out.print("|"+cell.toString());}
								writer.print(cell.toString()+"|");}
								else {
									//System.out.println("|"+cell.toString());}
									writer.println(cell.toString());}
							break;
						case Cell.CELL_TYPE_NUMERIC:
							//Arrotondo per 0.5 sia in eccesso che per difetto
							double valore = cell.getNumericCellValue();
							int parteintera = (int) valore;
							double differenza = valore-parteintera;
							if (differenza <= 0.24){
								valore = parteintera;
							}
							if (differenza >= 0.25 && differenza <= 0.74){
								valore = parteintera + 0.5;
							}
							if (differenza >= 0.75 && differenza <= 0.99){
								valore = parteintera + 1;
							}
							
							
							if (cellIterator.hasNext()){
								if (differenza == 0){
									if(cell.getColumnIndex()==3){
									writer.print(valore+"|");
									break;
									}
									//System.out.print("|"+parteintera);}
									writer.print(parteintera+"|");}
								else{
								
								//System.out.print("|"+valore);}
									writer.print(valore+"|");}
								}
							else {
								if (differenza == 0){
									//System.out.println("|"+parteintera);}
									writer.println(parteintera);}
								else{
								
								//System.out.println("|"+valore);}
									writer.println(valore);}
								}
						}
						
						
					}
				}
				
				writer.close();
				//JOptionPane.showMessageDialog(null, "Analisi dei voti di FantaGazzetta avvenuta con successo!");
				wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Creazione dei voti FantaGazzetta avvenuta con successo!", wndCaricamento.getVerde());
				
				
	        }
			catch (Exception e) {e.printStackTrace();
			//JOptionPane.showMessageDialog(null, e.getMessage());
			try {
				wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Errore nella creazione dei voti ("+ e.getMessage()+")\nSei sicuro di utilizzare il metodo giusto?", wndCaricamento.getRosso());
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
			}
			
		}
	
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
				arraySplittate[2], //cognome
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
	
	public static void creaQuotazioniTramiteTXT(String path_sorgente, String path_dest) throws FileNotFoundException{
		/*
		 * Prende in input due percorsi:
		 * - il primo del file excel (sorgente)
		 * - il secondo del file di destinazione "Quotazioni.txt"
		 * elabora il file excel e ne crea un file Quotazioni.txt con formato pseudo MCC
		 */
		PrintWriter writer;
		try {
			writer = new PrintWriter(path_dest, "UTF-8");
			String line;
			FileReader reader = new FileReader(path_sorgente);
			Scanner scanner = new Scanner(reader);
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				
				if (!line.contains("<tr><td>")){
					if (scanner.hasNext()){
						scanner.next();
					}
					
				} else {
					line = line.replaceAll(" Iniziale</th><th>Diff</th></tr><tr><td>","");
					line = line.replaceAll("<tr><td>","");
					line = line.replaceAll("</td><td>","|");
					line = line.replaceAll("</td></tr>","");
					line = line.replaceAll("</table>", "");
					line = line.replaceAll(",",".");
				//	System.out.println(line.toString()); Restituisce la lista, pu� tornare utile per estrapolare il file Quotazioni.txt con un writer
					writer.println(line.toString());
				}
			}
			writer.close();
			scanner.close();
		} catch (UnsupportedEncodingException e) {
			//JOptionPane.showMessageDialog(null, e.getMessage());
			try {
				wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+ "- Errore nella creazione del file delle quotazioni ("+e.getMessage() +")", wndCaricamento.getRosso());
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
		}	
		//JOptionPane.showMessageDialog(null, "Analisi delle quotazioni FantaGazzetta avvenuta con successo!");
		try {
			wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Creazione delle quotazioni FantaGazzetta avvenuta con successo!", wndCaricamento.getVerde());
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Quotazione> leggiQuotazioni(String path) throws FileNotFoundException{ //Crea gli oggetti Quotazione
		/*
		 * Legge le quotazioni salvate su un file Quotazioni.txt
		 * Per ogni riga del file crea un oggetto <Quotazione> e ne restituisce una lista
		 */
		ArrayList<Quotazione> risultato = new ArrayList<Quotazione>();
		
		

		String line;
		FileReader reader = new FileReader(path);
		Scanner scanner = new Scanner(reader);
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			String[] arraySplittate = line.split("\\|");
			
			Quotazione a = new Quotazione(
					Integer.parseInt(arraySplittate[0]), //id
							arraySplittate[1],  //ruolo
							arraySplittate[2],  //cognome
							arraySplittate[3],  //squadra
							Double.parseDouble(arraySplittate[4]),	//costo
							Double.parseDouble(arraySplittate[5]),	//costoIniziale
							Double.parseDouble(arraySplittate[6])	//differenza
							);
			risultato.add(a);
			
		}
		scanner.close();
		try {
			wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Lettura delle quotazioni Fantagazzetta avvenuta con successo!", wndCaricamento.getVerde());
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		
		return risultato;
	}
	
	public static void stampaAllenatori(ArrayList<CalciatoreRaw> cr, String path){
		ArrayList<CalciatoreRaw> temp = new ArrayList<CalciatoreRaw>();
	for (int i = 0; i<cr.size(); i++){
		if (cr.get(i).getRuolo().equals("ALL")){
			temp.add(cr.get(i));
		}
	}
	
	try {
		PrintWriter writer = new PrintWriter (path, "UTF-8");
		for (int j = 0; j < temp.size(); j++){
			writer.println(temp.get(j).getId()+"|"+temp.get(j).getCognome()+"|"+temp.get(j).getVoto());
		}
		writer.close();
		try {
			wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Creazione del file degli allenatori avvenuta con successo", wndCaricamento.getVerde());
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	} catch (FileNotFoundException | UnsupportedEncodingException e) {
		try {
			wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Errore durante la creazione del file degli allenatori ("+e.getMessage()+")", wndCaricamento.getVerde());
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
	}
	}

	public static void creaVotiRawTramiteTXT(String path_sorgente, String path_destinazione){ //METODO OBSOLETO
		
		PrintWriter writer;
		try {
			writer = new PrintWriter(path_destinazione, "UTF-8");
			String line;
			FileReader reader = new FileReader(path_sorgente);
			Scanner scanner = new Scanner(reader);
			
				line = scanner.nextLine();
			
				String line2 = line.substring(line.indexOf("<table border"), line.indexOf("Gdp</td></tr>"));
				line = line.replaceAll(line2, "");
				line = line.replaceAll("Gdv</td><td bgcolor=\"#D8D7D7\"", "");
				//String line3 = line.substring(line.indexOf("</td></tr><tr><td "), line.indexOf(">Gdp</td></tr>"));
				//line = line.replaceAll(line3, "");
				line = line.replaceAll("</td><td>", "|");
				line = line.replaceAll("<font color=\"#DA040E\"><b>", "");
				line = line.replaceAll("</b></font>", "");
				line = line.replaceAll("<tr><td>","");
				line = line.replaceAll("</table>", "");
				line = line.replaceAll("\"", "");
				line = line.replaceAll("Gdp</td></tr>","");
				line = line.replaceAll("</td></tr>", "\n");
				line = line.replaceAll("bgcolor=#D8D7D7>>","\n");
				line = line.replaceAll("</tr>","");
				//System.out.println(line);
				line = line.replaceAll(",01", ",0");
				line = line.replaceAll(",02", ",0");
				line = line.replaceAll(",03", ",0");
				line = line.replaceAll(",04", ",0");
				line = line.replaceAll(",05", ",0");
				line = line.replaceAll(",51", ",5");
				line = line.replaceAll(",52", ",5");
				line = line.replaceAll(",53", ",5");
				line = line.replaceAll(",54", ",5");
				line = line.replaceAll(",55", ",5");
				line = line.replaceAll(",", ".");
			Scanner scanner2 = new Scanner(line);
			while (scanner2.hasNextLine()) {
				line2 = scanner2.nextLine();
				if (!line2.startsWith("<tr>")){
					writer.println(line2.toString());
				}
			}
			
			
			
			scanner.close();
			scanner2.close();
			writer.close();
		} catch (UnsupportedEncodingException | FileNotFoundException | StringIndexOutOfBoundsException e) {
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

	public static void creaQuotazioniTramiteXLS(String path_sorgente, String path_dest) throws BadLocationException{
    
			PrintWriter writer;
			try {
				writer = new PrintWriter(path_dest, "UTF-8");
				Workbook workbook;
				workbook = WorkbookFactory.create(new File(path_sorgente));
			
			
			//XSSFWorkbook workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheetAt(0);;
			
			Iterator<Row> rowIterator = sheet.iterator(); //itero ogni riga
			
			while (rowIterator.hasNext()){
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				if (row.getRowNum() >=2){
				
				while (cellIterator.hasNext()){
						Cell cell = cellIterator.next();
	
								if (cell.getColumnIndex() != 6){
									if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
										Double value = Double.parseDouble(cell.toString());
										writer.print(value.intValue()+"|");
									}else{
										writer.print(cell+"|");
									}
									
								} else if (cell.getColumnIndex() == 6){
									
									Double value = Double.parseDouble(cell.toString());
									writer.print(value.intValue());
								}
				}
					
			writer.println();
			
				}
			}
			writer.close();
			//JOptionPane.showMessageDialog(null, "Analisi dei voti di FantaGazzetta avvenuta con successo!");
			wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Creazione delle quotazioni FantaGazzetta avvenuta con successo!", wndCaricamento.getVerde());
			} catch (Exception e){
				wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Problema nella creazione delle quotazioni - "+e.getMessage(), wndCaricamento.getRosso());
				e.getMessage();
			}
	}
}


