package it.stizzo.fg2mcc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.JCheckBox;

public class wndGazzettaDelloSport extends JFrame {

	private static JPanel contentPane;
	private static JTextField txtMCC;
	private static JTextField txtVoti;
	String nomeVotiRaw = "Voti_FG_RAW.txt";
	String nomeQuot = "Quot_FG.txt";
	String nomeNonTrov = "Calciatori_FG_non_corrispondenti.txt";
	public static JTextField getTxtMCC() {
		return txtMCC;
	}


	public static void setTxtMCC(JTextField txtMCC) {
		wndGazzettaDelloSport.txtMCC = txtMCC;
	}


	public static JTextField getTxtVoti() {
		return txtVoti;
	}


	public static void setTxtVoti(JTextField txtVoti) {
		wndGazzettaDelloSport.txtVoti = txtVoti;
	}


	public static JTextField getTxtGiornata() {
		return txtGiornata;
	}


	public static void setTxtGiornata(JTextField txtGiornata) {
		wndGazzettaDelloSport.txtGiornata = txtGiornata;
	}


	public static JTextField getTxtDest() {
		return txtDest;
	}


	public static void setTxtDest(JTextField txtDest) {
		wndGazzettaDelloSport.txtDest = txtDest;
	}


	private static JTextField txtGiornata;
	private static JTextField txtDest;
	
	
	public static void main(String[] args) {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wndGazzettaDelloSport frame = new wndGazzettaDelloSport();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public wndGazzettaDelloSport() {
		setTitle("Generatore MCC | Gazzetta dello Sport");
		setResizable(false);
		setFont(new Font("Nyala", Font.PLAIN, wndIntro.getDimensioniCarattere()+8));
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 432);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMccfcbe = new JMenu("Generatore MCC");
		menuBar.add(mnMccfcbe);
		
		JMenuItem mntmTornaAllaFinestra = new JMenuItem("Torna alla finestra di scelta");
		mntmTornaAllaFinestra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				wndIntro.frmGazzettaDelloSport.setVisible(false);
				wndIntro.frmIntro.setVisible(true);
			}
		});
		mnMccfcbe.add(mntmTornaAllaFinestra);
		
		JMenuItem mntmEsci = new JMenuItem("Esci");
		mntmEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnMccfcbe.add(mntmEsci);
		
		JMenu mnOpzioni = new JMenu("Opzioni");
		menuBar.add(mnOpzioni);
		
		JMenuItem mntmModificaValoriBonusmalus = new JMenuItem("Modifica valori bonus/malus");
		mntmModificaValoriBonusmalus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wndIntro.frmBonus.setVisible(true);
			}
		});
		mnOpzioni.add(mntmModificaValoriBonusmalus);
		
		JMenuItem mntmPreferenze = new JMenuItem("Preferenze");
		mntmPreferenze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wndIntro.frmPreferenze.setVisible(true);
			}
		});
		mnOpzioni.add(mntmPreferenze);
		
		JMenu menu = new JMenu("?");
		menuBar.add(menu);
		
		JMenuItem mntmVisitaLaPagina = new JMenuItem("Visita la pagina nel forum");
		mntmVisitaLaPagina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Desktop.isDesktopSupported())
					try {
						Desktop.getDesktop().browse(new URI("http://www.fantacalciobazar.altervista.org/showthread.php?mode=linear&tid=7372&pid=37203"));
					} catch (IOException | URISyntaxException e) {
						e.printStackTrace();
					}
			}
		});
		menu.add(mntmVisitaLaPagina);
		
		JMenuItem mntmVisitaIlProgetto = new JMenuItem("Visita il progetto in Google Code");
		mntmVisitaIlProgetto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Desktop.isDesktopSupported())
					try {
						Desktop.getDesktop().browse(new URI("https://code.google.com/p/fg2mcc"));
					} catch (IOException | URISyntaxException e) {
						e.printStackTrace();
					}
			}
		});
		menu.add(mntmVisitaIlProgetto);
		
		JMenuItem mntmAboutMccfcbe = new JMenuItem("About GeneratoreMCC");
		mntmAboutMccfcbe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wndIntro.frmAbout.setVisible(true);
			}
		});
		menu.add(mntmAboutMccfcbe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVotiGazzettaDelloSport = new JLabel("Generazione voti usando");
		lblVotiGazzettaDelloSport.setForeground(new Color(50, 50, 60));
		lblVotiGazzettaDelloSport.setFont(new Font(wndIntro.getCarattere(), Font.BOLD | Font.ITALIC, wndIntro.getDimensioniCarattere()+8));
		lblVotiGazzettaDelloSport.setHorizontalAlignment(SwingConstants.CENTER);
		lblVotiGazzettaDelloSport.setBounds(10, 11, 247, 83);
		contentPane.add(lblVotiGazzettaDelloSport);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(getClass().getResource("/gazzettadellosport_logo.png")));
		label.setBounds(251, 11, 279, 83);
		contentPane.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 105, 520, 2);
		contentPane.add(separator);
		
		JLabel lblInserisciStrutturaMcc = new JLabel("Inserisci struttura MCC:");
		lblInserisciStrutturaMcc.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		lblInserisciStrutturaMcc.setBounds(10, 118, 368, wndIntro.getAltezzaControlli());
		contentPane.add(lblInserisciStrutturaMcc);
		
		txtMCC = new JTextField();
		txtMCC.setEditable(false);
		txtMCC.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		txtMCC.setBounds(10, 143, 368, wndIntro.getAltezzaControlli());
		contentPane.add(txtMCC);
		txtMCC.setColumns(10);
		
		final JButton btnMCCOffline = new JButton("Apri file offline");
		btnMCCOffline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Seleziona il file con la struttura MCC");
				//chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				chooser.showOpenDialog(null);
				txtMCC.setText(chooser.getSelectedFile().toString());
			}
		});
		btnMCCOffline.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		btnMCCOffline.setBounds(388, 143, 142, wndIntro.getAltezzaControlli());
		contentPane.add(btnMCCOffline);
		
		JLabel lblInserisciQuotazioni = new JLabel("Inserisci voti:");
		lblInserisciQuotazioni.setToolTipText("Per file voti ristrutturato si intende il file excel con un'intestazione valida: attualmente il file pubblicato da GazzettaDelloSport \u00E8 in html. Per ristrutturarlo basta aprirlo in excel e successivamente \"salvarlo con nome\" con estensione .xls.");
		lblInserisciQuotazioni.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		lblInserisciQuotazioni.setBounds(10, 182, 368, wndIntro.getAltezzaControlli());
		contentPane.add(lblInserisciQuotazioni);
		
		txtVoti = new JTextField();
		txtVoti.setEditable(false);
		txtVoti.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		txtVoti.setColumns(10);
		txtVoti.setBounds(10, 207, 368, wndIntro.getAltezzaControlli());
		contentPane.add(txtVoti);
		
		final JButton btnVotiOffline = new JButton("Apri file offline");
		btnVotiOffline.setEnabled(false);
		btnVotiOffline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Seleziona il file xls con i voti");
				//chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				chooser.showOpenDialog(null);
				txtVoti.setText(chooser.getSelectedFile().toString());
			}
		});
		btnVotiOffline.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		btnVotiOffline.setBounds(388, 207, 142, wndIntro.getAltezzaControlli());
		contentPane.add(btnVotiOffline);
		
		JLabel lblInserisciNumeroGiornata = new JLabel("Inserisci numero giornata:");
		lblInserisciNumeroGiornata.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		lblInserisciNumeroGiornata.setBounds(10, 342, 161, wndIntro.getAltezzaControlli());
		contentPane.add(lblInserisciNumeroGiornata);
		
		txtGiornata = new JTextField();
		txtGiornata.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		txtGiornata.setColumns(10);
		txtGiornata.setBounds(180, 342, 77, wndIntro.getAltezzaControlli());
		contentPane.add(txtGiornata);
		
		final JButton bntMCCOnline = new JButton("Carica da online");
		bntMCCOnline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMCCOffline.setEnabled(false);
				bntMCCOnline.setEnabled(false);
				Operazioni.ca = Operazioni.leggiCalciatoriMCC(Operazioni.url_MCC,1);
				
			}
		});
		bntMCCOnline.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		bntMCCOnline.setBounds(388, 119, 142, wndIntro.getAltezzaControlli());
		contentPane.add(bntMCCOnline);
		
		final JButton btnVotiOnline = new JButton("Carica da online");
		btnVotiOnline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GazzettaDelloSport.creaVotiRawTramiteTXT(txtDest.getText()+"\\"+nomeVotiRaw);
			}
		});
		btnVotiOnline.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		btnVotiOnline.setBounds(388, 183, 142, wndIntro.getAltezzaControlli());
		contentPane.add(btnVotiOnline);
		
		
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 242, 520, 2);
		contentPane.add(separator_1);
		
		txtDest = new JTextField();
		txtDest.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		txtDest.setColumns(10);
		txtDest.setBounds(10, 279, 368, wndIntro.getAltezzaControlli());
		contentPane.add(txtDest);
		
		
		JLabel lblScegliIlPercorso = new JLabel("Scegli il percorso di destinazione");
		lblScegliIlPercorso.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		lblScegliIlPercorso.setBounds(10, 255, 368, wndIntro.getAltezzaControlli());
		contentPane.add(lblScegliIlPercorso);
		
		JButton btnSfogliaDest = new JButton("Sfoglia...");
		btnSfogliaDest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Seleziona il percorso per i file di destinazione");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				chooser.showOpenDialog(null);
				txtDest.setText(chooser.getSelectedFile().toString());
				
			}
		});
		btnSfogliaDest.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		btnSfogliaDest.setBounds(388, 279, 142, wndIntro.getAltezzaControlli());
		contentPane.add(btnSfogliaDest);
		
		final JCheckBox chkSottocartella = new JCheckBox("Crea una sottocartella per i file generati");
		chkSottocartella.setSelected(true);
		chkSottocartella.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		chkSottocartella.setBounds(6, 312, 279, wndIntro.getAltezzaControlli());
		contentPane.add(chkSottocartella);
		
		
		
		JButton btnGeneraMCC = new JButton("GENERA VOTI MCC");
		btnGeneraMCC.setFont(new Font(wndIntro.getCarattere(), Font.BOLD, wndIntro.getDimensioniCarattere()+4));
		btnGeneraMCC.setBounds(294, 313, 236, 55);
		contentPane.add(btnGeneraMCC);
		
		JButton btnCampioncini = new JButton("Campioncini");
		btnCampioncini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//##################################################################
			//########### CAMPIONCINI ##########################################
				
				
			}
		});
		btnCampioncini.setBounds(294, 486, 89, 23);
		contentPane.add(btnCampioncini);
		
		btnGeneraMCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (chkSottocartella.isSelected()){
					txtDest.setText(txtDest.getText()+"\\MCC"+txtGiornata.getText()+"_"+System.currentTimeMillis());
					new File(txtDest.getText()).mkdir();
				}
				Operazioni.giornata = Integer.parseInt(txtGiornata.getText());
				
				ImageIcon a = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/GazzettaDelloSport_logo.png")).getScaledInstance(wndCaricamento.getLblLogo().getWidth(), wndCaricamento.getLblLogo().getHeight(), java.awt.Image.SCALE_SMOOTH));
				wndCaricamento.getLblLogo().setIcon(a);
				wndIntro.frmCaricamento.setVisible(true);
				
				//0 - Leggo calciatori
				if (Operazioni.ca.isEmpty()){
					Operazioni.ca = Operazioni.leggiCalciatoriMCC(txtMCC.getText(),0);
				}
			else {
				try {
					wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Lista calciatori già caricata con successo", wndCaricamento.getVerde());
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
			}
				
				
				
				
			
				
				//5 - Leggo Voti Raw
				try {
					//wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "Tentativo di lettura dei voti raw", wndCaricamento.getVerde());
					Operazioni.cr = GazzettaDelloSport.leggiVotiRaw(txtDest.getText()+"\\"+nomeVotiRaw);
				} catch (FileNotFoundException e1) {
					try {
						wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Errore durante la lettura dei voti RAW ("+e1.getMessage()+")", wndCaricamento.getRosso());
					} catch (BadLocationException e2) {
						e2.printStackTrace();
					}
				}
				
				
				//12 - Creo il file MCC finale
				String giornata_testo;
				if (Operazioni.giornata <= 9){
					giornata_testo = "0"+Operazioni.giornata;
				} else {
					giornata_testo = Operazioni.giornata+"";
				}
				Operazioni.stampaMCC(Operazioni.ca, txtDest.getText()+"\\"+"MCC"+giornata_testo+".txt");
				//13 - Carico il file su server FTP
				if (wndPreferenze.getChkReteCopiaFTP().isSelected()){
					Operazioni.caricaSuServerFTP(txtDest.getText(), "MCC"+giornata_testo+".txt");
				}
				
				
				//16 - Cancello tutti i valori di istanza
				getTxtGiornata().setText("");
				getTxtMCC().setText("");
				
				getTxtVoti().setText("");
				btnMCCOffline.setEnabled(true);
				bntMCCOnline.setEnabled(true);
			
				btnVotiOffline.setEnabled(true);
				btnVotiOnline.setEnabled(false);
				Operazioni.ca.clear();
				Operazioni.cr.clear();
				
				getTxtDest().setText(wndPreferenze.getTxtGenPercorso().getText());
				
			}
		});

	}
}
