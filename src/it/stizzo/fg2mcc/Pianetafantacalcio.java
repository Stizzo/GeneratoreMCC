package it.stizzo.fg2mcc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Pianetafantacalcio {
	public static ArrayList<Correzione> co;
	public static ArrayList<Quotazione> q;
	
	public static void creaVotiRawTramiteXLS(String path_sorgente, String path_destinazione){
		//Importo il percorso del file excel e la lista dei calciatori
			try
	        {
				int colonna_incriminata = 0;
				
				PrintWriter writer = new PrintWriter(path_destinazione, "UTF-8");
				FileInputStream file = new FileInputStream(new File(path_sorgente));
				HSSFWorkbook workbook = new HSSFWorkbook(file);
				HSSFSheet sheet = workbook.getSheetAt(0); //Prendo il primo foglio di lavoro
				
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
								writer.print(cell.toString().trim()+"|");}
								else {
									//System.out.println("|"+cell.toString());}
									writer.println(cell.toString().trim());}
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
							break;
						}
						
						
					}
				}
				file.close();
				writer.close();
				//JOptionPane.showMessageDialog(null, "Analisi dei voti PianetaFantacalcio avvenuta con successo!");
				wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Creazione dei voti PianetaFantacalcio avvenuta con successo!", wndCaricamento.getVerde());
				
				
	        }
			catch (Exception e) {e.printStackTrace();
			try {
				wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Errore nella creazione dei voti (" + e.getMessage() +")", wndCaricamento.getRosso());
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
			//JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}

	public static ArrayList<CalciatoreRaw> leggiVotiRaw(String path) throws FileNotFoundException, BadLocationException{ //Crea gli oggetti CalciatoreRAW
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
			
			int golSeg = 0, golSub = 0, autogol = 0, assist = 0;
			String voto = "";
			switch (Operazioni.redazione){
			case "Gazzetta dello Sport": 
				String temp_voto;
				
				if (!arraySplittate[6].equals("s,v,") && arraySplittate[6].split("\\.")[1].length()==2){
					//Removed the second digit after the colon
					
					temp_voto = arraySplittate[6].substring(0, arraySplittate[6].length()-1);
					//remove the last digit
				} else {
					temp_voto = arraySplittate[6];
				}
				
				
				voto = (temp_voto);
				golSeg = Integer.parseInt(arraySplittate[7])-Integer.parseInt(arraySplittate[29]);
				golSub = Integer.parseInt(arraySplittate[8]);
				autogol = Integer.parseInt(arraySplittate[9]);
				assist = Integer.parseInt(arraySplittate[10]);
				break;
			case "Corriere dello Sport":
				voto = (arraySplittate[11]);
				golSeg = Integer.parseInt(arraySplittate[12])-Integer.parseInt(arraySplittate[29]);
				golSub = Integer.parseInt(arraySplittate[13]);
				autogol = Integer.parseInt(arraySplittate[14]);
				assist = Integer.parseInt(arraySplittate[15]);
				break;
			case "TuttoSport":
				voto = arraySplittate[16];
				golSeg = Integer.parseInt(arraySplittate[17])-Integer.parseInt(arraySplittate[29]);
				golSub = Integer.parseInt(arraySplittate[18]);
				autogol = Integer.parseInt(arraySplittate[19]);
				assist = Integer.parseInt(arraySplittate[20]);
				break;	
		}
	
			if (wndPreferenze.getChckbxVoto15Min().isSelected() && arraySplittate[5].equals("15")){
				voto = wndPreferenze.getTxtVoto15Min().getText();
			}
			
		CalciatoreRaw a = new CalciatoreRaw(
				Operazioni.verificaID(arraySplittate[0],arraySplittate[1].trim()), //ID
				Operazioni.verificaRuolo(arraySplittate[2],arraySplittate[1].trim()), //ruolo, prendo il primo ruolo
				arraySplittate[1].trim(), //cognome
				voto, //voto
				golSeg, //golSeg
				golSub, //golSub
				Integer.parseInt(arraySplittate[28]), //rigPar
				Integer.parseInt(arraySplittate[27]), //rigSba
				Integer.parseInt(arraySplittate[29]), //rigSeg
				autogol, //autogol
				Integer.parseInt(arraySplittate[23]),//amm
				Integer.parseInt(arraySplittate[24]),//esp
				assist,//assist
				0,//assistFermo
				Integer.parseInt(arraySplittate[25]),//golVit
				Integer.parseInt(arraySplittate[26]) //golPar
				);
		risultato.add(a);
		
		
		}
		scanner.close();
		wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Lettura dei voti PianetaFantacalcio avvenuta con successo", wndCaricamento.getVerde());
		return risultato;
	}
	
	public static void creaQuotazioni(String path_sorgente, String path_dest) throws FileNotFoundException{
		/*
		 * Prende in input due percorsi:
		 * - il primo del file excel (sorgente)
		 * - il secondo del file di destinazione "Quotazioni.txt"
		 * elabora il file excel e ne crea un file Quotazioni.txt con formato pseudo MCC
		 */
		
		try {
			PrintWriter writer = new PrintWriter(path_dest+".temp", "UTF-8");
			String line;
			FileReader reader = new FileReader(path_sorgente);
			Scanner scanner = new Scanner(reader);
			
			while (scanner.hasNext()) {
				
				line = scanner.nextLine().toString();
				
				
				if (line.trim().startsWith("</script><table><tr><td colspan=8 height=50 align=center")){
					
					line = line.replaceAll(" </td></font></table>",""); //ultima riga
					line = line.replaceAll(" </td><td align=center height=20>","|");
					line = line.replaceAll("</td><td align=center height=20>","|");
					line = line.replaceAll(" </td></font><font color=#FFFFFF face=Verdana size=3><tr><td align=center>",System.getProperty("line.separator")); //tutte le altre righe
					line = line.replaceAll("</td><font color=#FFFFFF face=Verdana size=3><tr><td align=center>", System.getProperty("line.separator")); //prima riga	
					writer.write(line.toString().trim());					
				}
			
			}
			scanner.close();
			writer.close();
			//Fine prima iterazione (c'è ancora la prima riga da cancellare, resetto lo scanner, salvo tutto in un array e lo ristampo su file)
			//Non posso tenere aperto un reader e un writer sullo stesso file!
			FileReader reader2 = new FileReader(path_dest+".temp");
			PrintWriter writer2 = new PrintWriter(path_dest, "UTF-8");
			Scanner scanner2 = new Scanner(reader2);
			ArrayList<String> righe = new ArrayList<String>();
			
			while (scanner2.hasNext()){
				line = scanner2.nextLine();
				righe.add(line);
			}
			righe.remove(0);
			for (int i = 0; i < righe.size(); i++){
				writer2.println(righe.get(i));
			}
		
		scanner2.close();
		writer2.close();
		File file = new File(path_dest+".temp");
		file.delete();
		} catch (UnsupportedEncodingException e) {
			//JOptionPane.showMessageDialog(null, e.getMessage());
			try {
				wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+ "- Errore nella creazione del file delle quotazioni ("+e.getMessage() +")", wndCaricamento.getRosso());
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
		}	
		//JOptionPane.showMessageDialog(null, "Analisi delle quotazioni PianetaFantacalcio avvenuta con successo!");
		try {
			wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Creazione delle quotazioni PianetaFantacalcio avvenuta con successo", wndCaricamento.getVerde());
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
	}

	public static ArrayList<Quotazione> leggiQuotazioni(String path) throws FileNotFoundException, BadLocationException{ //Crea gli oggetti Quotazione
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
							arraySplittate[2],  //ruolo
							arraySplittate[1].trim(),  //cognome
							arraySplittate[4],  //squadra
							Double.parseDouble(arraySplittate[6].replaceAll(",",".")),	//costo
							Double.parseDouble(arraySplittate[5].replaceAll(",",".")),	//costoIniziale
							Double.parseDouble(arraySplittate[7].replaceAll(",","."))	//differenza
							);
			risultato.add(a);
			
		}
		scanner.close();
		wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Lettura delle quotazioni PianetaFantacalcio avvenuta con successo!", wndCaricamento.getVerde());
		
		
		return risultato;
	}
	
	public static void creaVotiRawTramiteTXT(String path_sorgente, String path_destinazione){
		
		PrintWriter writer;
		try {
			writer = new PrintWriter(path_destinazione, "UTF-8");
			String line;
			FileReader reader = new FileReader(path_sorgente);
			Scanner scanner = new Scanner(reader);
			String tabella = new String();
			while (scanner.hasNextLine()){
				line = scanner.nextLine();
				if (line.startsWith("</script><table>")){
					tabella = line;
				}
			}
			
			
				String line2 = tabella.substring(tabella.indexOf("</script><table>"), tabella.indexOf("VTS"));
				tabella = tabella.replaceAll(line2, "");
				tabella = tabella.replaceAll("VTS</strong></td><font color=#FFFFFF face=Verdana size=3><tr><td align=left height=20>","");
				tabella = tabella.replaceAll(" </td><td align=left height=20>", "|");
				tabella = tabella.replaceAll(" </td><td align=center height=20>", "|");
				tabella = tabella.replaceAll("</td><td align=left height=20>", "|");
				tabella = tabella.replaceAll(" </td><td align=center height=20 bgcolor=#ebacf5>","|");
				tabella = tabella.replaceAll("</td><td align=center height=20 bgcolor=#ebacf5>","|");
				tabella = tabella.replaceAll(" </td><td align=center height=20 bgcolor=#c0291e>", "|");
				tabella = tabella.replaceAll(" </td><td align=center height=20 bgcolor=#79AEFF>","|");
				tabella = tabella.replaceAll("</td><td align=center height=20>", "|");
				tabella = tabella.replaceAll(" </td></font><font color=#FFFFFF face=Verdana size=3><tr><td align=left height=20>", "\n");
				tabella = tabella.replaceAll(" </td></font></table> <!--","");
				tabella = tabella.replaceAll(",",".");
				tabella = tabella.replaceAll("s.v.", "s,v,");
				tabella = tabella.replaceAll("</td><td align=center height=20 bgcolor='white'>", "|");
				tabella = tabella.replaceAll("</td><td align=center height=20 bgcolor='green'>", "|");
				//System.out.println(tabella);
				
				Scanner scanner2 = new Scanner(tabella);
				while (scanner2.hasNextLine()) {
					String linea = scanner2.nextLine();
						writer.println(linea.toString());
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
			wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Creazione dei voti PianetaFantacalcio avvenuta con successo!", wndCaricamento.getVerde());
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
