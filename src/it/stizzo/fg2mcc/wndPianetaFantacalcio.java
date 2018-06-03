package it.stizzo.fg2mcc;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class wndPianetaFantacalcio extends JFrame {

	private static JPanel contentPane;
	private static JTextField txtMCC;
	private static JTextField txtCorrezioni;
	private static JTextField txtQuotazioni;
	private static JTextField txtVoti;
	private static JTextField txtGiornata;
	private static JTextField txtDest;

	public static JTextField getTxtMCC() {
		return txtMCC;
	}

	public static void setTxtMCC(JTextField txtMCC) {
		wndPianetaFantacalcio.txtMCC = txtMCC;
	}

	public static JTextField getTxtCorrezioni() {
		return txtCorrezioni;
	}

	public static void setTxtCorrezioni(JTextField txtCorrezioni) {
		wndPianetaFantacalcio.txtCorrezioni = txtCorrezioni;
	}

	public static JTextField getTxtQuotazioni() {
		return txtQuotazioni;
	}

	public static void setTxtQuotazioni(JTextField txtQuotazioni) {
		wndPianetaFantacalcio.txtQuotazioni = txtQuotazioni;
	}

	public static JTextField getTxtVoti() {
		return txtVoti;
	}

	public static void setTxtVoti(JTextField txtVoti) {
		wndPianetaFantacalcio.txtVoti = txtVoti;
	}

	public static JTextField getTxtGiornata() {
		return txtGiornata;
	}

	public static void setTxtGiornata(JTextField txtGiornata) {
		wndPianetaFantacalcio.txtGiornata = txtGiornata;
	}

	public static JTextField getTxtDest() {
		return txtDest;
	}

	public static void setTxtDest(JTextField txtDest) {
		wndPianetaFantacalcio.txtDest = txtDest;
	}

	/**
	 * Launch the application.
	 */
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
		//#############
		
		//#############
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wndPianetaFantacalcio frame = new wndPianetaFantacalcio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public wndPianetaFantacalcio() {
		setTitle("Generatore MCC | PianetaFantacalcio");
		setResizable(false);
		setFont(new Font("Nyala", Font.PLAIN, wndIntro.getDimensioniCarattere()+8));
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 559);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMccfcbe = new JMenu("Generatore MCC");
		menuBar.add(mnMccfcbe);
		
		JMenuItem mntmTornaAllaFinestra = new JMenuItem("Torna alla finestra di scelta");
		mntmTornaAllaFinestra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wndIntro.frmPianetafantacalcio.setVisible(false);
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
		
		JLabel lblVotiPianetafantacalcio = new JLabel("Generazione voti usando");
		lblVotiPianetafantacalcio.setForeground(new Color(153, 102, 204));
		lblVotiPianetafantacalcio.setFont(new Font(wndIntro.getCarattere(), Font.BOLD | Font.ITALIC, wndIntro.getDimensioniCarattere()+8));
		lblVotiPianetafantacalcio.setHorizontalAlignment(SwingConstants.CENTER);
		lblVotiPianetafantacalcio.setBounds(10, 11, 247, 83);
		contentPane.add(lblVotiPianetafantacalcio);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(getClass().getResource("/pianetafantacalcio_logo.png")));
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
		
		JLabel lblInserisciFileDi = new JLabel("Inserisci file di correzione cognomi:");
		lblInserisciFileDi.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		lblInserisciFileDi.setBounds(10, 174, 368, wndIntro.getAltezzaControlli());
		contentPane.add(lblInserisciFileDi);
		
		txtCorrezioni = new JTextField();
		txtCorrezioni.setEditable(false);
		txtCorrezioni.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		txtCorrezioni.setColumns(10);
		txtCorrezioni.setBounds(10, 199, 368, wndIntro.getAltezzaControlli());
		contentPane.add(txtCorrezioni);
		
		final JButton btnCorrezioniOffline = new JButton("Apri file offline");
		btnCorrezioniOffline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Seleziona il file con le correzioni dei cognomi");
				//chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				chooser.showOpenDialog(null);
				txtCorrezioni.setText(chooser.getSelectedFile().toString());
			}
		});
		btnCorrezioniOffline.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		btnCorrezioniOffline.setBounds(388, 199, 142, wndIntro.getAltezzaControlli());
		contentPane.add(btnCorrezioniOffline);
		
		JLabel lblInserisciQuotazioni = new JLabel("Inserisci voti:");
		lblInserisciQuotazioni.setToolTipText("Per file voti ristrutturato si intende il file excel con un'intestazione valida: attualmente il file pubblicato da PianetaFantacalcio \u00E8 in html. Per ristrutturarlo basta aprirlo in excel e successivamente \"salvarlo con nome\" con intestazione .xls.");
		lblInserisciQuotazioni.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		lblInserisciQuotazioni.setBounds(10, 289, 368, wndIntro.getAltezzaControlli());
		contentPane.add(lblInserisciQuotazioni);
		
		txtQuotazioni = new JTextField();
		txtQuotazioni.setEditable(false);
		txtQuotazioni.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		txtQuotazioni.setColumns(10);
		txtQuotazioni.setBounds(10, 255, 368, wndIntro.getAltezzaControlli());
		contentPane.add(txtQuotazioni);
		
		final JButton BtnQuotazioniOffline = new JButton("Apri file offline");
		BtnQuotazioniOffline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Seleziona il file xls con le quotazioni");
				//chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				chooser.showOpenDialog(null);
				txtQuotazioni.setText(chooser.getSelectedFile().toString());
			}
		});
		BtnQuotazioniOffline.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		BtnQuotazioniOffline.setBounds(388, 255, 142, wndIntro.getAltezzaControlli());
		contentPane.add(BtnQuotazioniOffline);
		
		txtVoti = new JTextField();
		txtVoti.setEditable(false);
		txtVoti.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		txtVoti.setColumns(10);
		txtVoti.setBounds(10, 314, 368, wndIntro.getAltezzaControlli());
		contentPane.add(txtVoti);
		
		JLabel label_1 = new JLabel("Inserisci quotazioni:");
		label_1.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		label_1.setBounds(10, 231, 368, wndIntro.getAltezzaControlli());
		contentPane.add(label_1);
		
		final JButton btnVotiOffline = new JButton("Apri file offline");
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
		btnVotiOffline.setBounds(388, 314, 142, wndIntro.getAltezzaControlli());
		contentPane.add(btnVotiOffline);
		
		JLabel lblInserisciNumeroGiornata = new JLabel("Inserisci numero giornata:");
		lblInserisciNumeroGiornata.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		lblInserisciNumeroGiornata.setBounds(10, 474, 161, wndIntro.getAltezzaControlli());
		contentPane.add(lblInserisciNumeroGiornata);
		
		txtGiornata = new JTextField();
		txtGiornata.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		txtGiornata.setColumns(10);
		txtGiornata.setBounds(180, 474, 77, wndIntro.getAltezzaControlli());
		contentPane.add(txtGiornata);
		
		final JButton btnMCCOnline = new JButton("Carica da online");
		btnMCCOnline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMCCOnline.setEnabled(false);
				btnMCCOffline.setEnabled(false);
				Operazioni.ca = Operazioni.leggiCalciatoriMCC(Operazioni.url_MCC,1);
				
			
				
			}
		});
		btnMCCOnline.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		btnMCCOnline.setBounds(388, 119, 142, wndIntro.getAltezzaControlli());
		contentPane.add(btnMCCOnline);
		
		final JButton btnCorrezioniOnline = new JButton("Carica da online");
		btnCorrezioniOnline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCorrezioniOffline.setEnabled(false);
				btnCorrezioniOnline.setEnabled(false);
			Pianetafantacalcio.co = Operazioni.leggiCorrezioni(Operazioni.url_CorrPF, 1);
			}
		});
		btnCorrezioniOnline.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		btnCorrezioniOnline.setBounds(388, 175, 142, wndIntro.getAltezzaControlli());
		contentPane.add(btnCorrezioniOnline);
		
		final JButton btnQuotazioniOnline = new JButton("Carica da online");
		btnQuotazioniOnline.setEnabled(false);
		btnQuotazioniOnline.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		btnQuotazioniOnline.setBounds(388, 231, 142, wndIntro.getAltezzaControlli());
		contentPane.add(btnQuotazioniOnline);
		
		final JButton btnVotiOnline = new JButton("Carica da online");
		btnVotiOnline.setEnabled(false);
		btnVotiOnline.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		btnVotiOnline.setBounds(388, 290, 142, wndIntro.getAltezzaControlli());
		contentPane.add(btnVotiOnline);
		
		
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 374, 520, 2);
		contentPane.add(separator_1);
		
		txtDest = new JTextField();
		txtDest.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		txtDest.setColumns(10);
		txtDest.setBounds(10, 411, 368, wndIntro.getAltezzaControlli());
		contentPane.add(txtDest);
		
		JLabel lblScegliIlPercorso = new JLabel("Scegli il percorso di destinazione");
		lblScegliIlPercorso.setToolTipText("Per file voti ristrutturato si intende il file excel con un'intestazione valida: attualmente il file pubblicato da PianetaFantacalcio \u00E8 in html. Per ristrutturarlo basta aprirlo in excel e successivamente \"salvarlo con nome\" con intestazione .xls.");
		lblScegliIlPercorso.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		lblScegliIlPercorso.setBounds(10, 387, 368, wndIntro.getAltezzaControlli());
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
		btnSfogliaDest.setBounds(388, 411, 142, wndIntro.getAltezzaControlli());
		contentPane.add(btnSfogliaDest);
		
		final JCheckBox chkSottocartella = new JCheckBox("Crea una sottocartella per i file generati");
		chkSottocartella.setSelected(true);
		chkSottocartella.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		chkSottocartella.setBounds(6, 444, 279, wndIntro.getAltezzaControlli());
		contentPane.add(chkSottocartella);
		
		
		
		JButton btnGeneraMCC = new JButton("GENERA VOTI MCC");
		btnGeneraMCC.setFont(new Font(wndIntro.getCarattere(), Font.BOLD, wndIntro.getDimensioniCarattere()+4));
		btnGeneraMCC.setBounds(294, 445, 236, 55);
		contentPane.add(btnGeneraMCC);
		
		final JRadioButton rdbGazzetta = new JRadioButton("Gazzetta dello Sport");
		rdbGazzetta.setToolTipText("Redazione Milano");
		rdbGazzetta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Operazioni.redazione = rdbGazzetta.getText();
			}
		});
		rdbGazzetta.setSelected(true);
		rdbGazzetta.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		rdbGazzetta.setBounds(6, 344, 190, wndIntro.getAltezzaControlli());
		contentPane.add(rdbGazzetta);
		
		final JRadioButton rdbCorriere = new JRadioButton("Corriere dello Sport");
		rdbCorriere.setToolTipText("Redazione Roma");
		rdbCorriere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operazioni.redazione = rdbCorriere.getText();
			}
		});
		rdbCorriere.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		rdbCorriere.setBounds(198, 344, 180, wndIntro.getAltezzaControlli());
		contentPane.add(rdbCorriere);
		
		final JRadioButton rdbTutto = new JRadioButton("TuttoSport");
		rdbTutto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operazioni.redazione = rdbTutto.getText();
			}
		});
		rdbTutto.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		rdbTutto.setBounds(388, 344, 142, wndIntro.getAltezzaControlli());
		contentPane.add(rdbTutto);
		
		ButtonGroup redazione = new ButtonGroup();
		redazione.add(rdbGazzetta);
		redazione.add(rdbCorriere);
		redazione.add(rdbTutto);
		
		btnGeneraMCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				ImageIcon a = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/pianetafantacalcio_logo.png")).getScaledInstance(wndCaricamento.getLblLogo().getWidth(), wndCaricamento.getLblLogo().getHeight(), java.awt.Image.SCALE_SMOOTH));
				wndCaricamento.getLblLogo().setIcon(a);
				wndIntro.frmCaricamento.setVisible(true);
				
				String nomeVotiRaw = "Voti_PF_RAW.txt";
				String nomeQuot = "Quot_PF.txt";
				String nomeNonTrov = "Calciatori_PF_non_corrispondenti.txt";
				
				if (chkSottocartella.isSelected()){
					txtDest.setText(txtDest.getText()+"\\MCC"+txtGiornata.getText()+"_"+System.currentTimeMillis());
					new File(txtDest.getText()).mkdir();
				}
				Operazioni.giornata = Integer.parseInt(txtGiornata.getText());
				
				//0 - Leggo calciatori
				if (Operazioni.ca.isEmpty()){
					/*try {
						wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "Tentativo di caricamento della lista dei calciatori", wndCaricamento.getVerde());
					} catch (BadLocationException e1) {
						e1.printStackTrace();}
					*/
					Operazioni.ca = Operazioni.leggiCalciatoriMCC(txtMCC.getText(),0);
				}else {
					try {
						wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Lista calciatori già caricata con successo", wndCaricamento.getVerde());
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
				//1 - Leggo Correzioni
				if (Pianetafantacalcio.co.isEmpty() && !txtCorrezioni.getText().isEmpty()){
					/*try {
						wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "Tentativo di lettura delle correzioni PianetaFantacalcio", wndCaricamento.getVerde());
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
					*/
					Pianetafantacalcio.co = Operazioni.leggiCorrezioni(txtCorrezioni.getText(),0);
				} else if (!Pianetafantacalcio.co.isEmpty()) {
					try {
						wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Correzioni PianetaFantacalcio già lette con successo", wndCaricamento.getVerde());
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
					}
				else {
					try {
						wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Correzioni PianetaFantacalcio non trovate", wndCaricamento.getGiallo());
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
				//2 - Controllo eventuali doppioni non gesiti nell'MCC
				ArrayList<Calciatore> nonGestiti = new ArrayList<Calciatore>();
				nonGestiti = Operazioni.controllaDuplicatiNonGestitiSuMCC(Operazioni.ca, Pianetafantacalcio.co);
				
				if (nonGestiti.size()!= 0){
					try {
						wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Trovati i seguenti duplicati non gestiti nelle correzioni sul file MCC:", wndCaricamento.getRosso());
					for (int i = 0; i < nonGestiti.size(); i++){
						wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"+ "+nonGestiti.get(i).getId()+" - "+nonGestiti.get(i).getCognome()+" - "+nonGestiti.get(i).getSquadra(), wndCaricamento.getRosso());
					}
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
				
				//3 - Creo Voti Raw
				if (!txtVoti.getText().isEmpty() && Operazioni.cr.isEmpty()){
					/*try {
					wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "Tentativo di creazione dei voti (raw) di PianetaFantacalcio", wndCaricamento.getVerde());
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
				*/
					if (wndPreferenze.getCmbMetodo().getSelectedIndex()==0){
						Pianetafantacalcio.creaVotiRawTramiteXLS(txtVoti.getText(), txtDest.getText()+"\\"+nomeVotiRaw);
							} else {
						Pianetafantacalcio.creaVotiRawTramiteTXT(txtVoti.getText(), txtDest.getText()+"\\"+nomeVotiRaw);
							}
				}
				else if (!Operazioni.cr.isEmpty()){
					try {
						wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Creazione dei voti (raw) di PianetaFantacalcio già avvenuta con successo", wndCaricamento.getVerde());
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
				else {
					try {
						wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Voti (raw) di PianetaFantacalcio non rilevati", wndCaricamento.getRosso());
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
				
				
				//4 - Creo Quotazioni
				if (Pianetafantacalcio.q.isEmpty() && !txtQuotazioni.getText().isEmpty()){
				try {
					//wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "Tentativo di lettura delle quotazioni", wndCaricamento.getVerde());
					Pianetafantacalcio.creaQuotazioni(txtQuotazioni.getText(), txtDest.getText()+"\\"+nomeQuot);
				} catch (FileNotFoundException e1) {
					try {
						wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Errore durante la lettura delle quotazioni ("+e1.getMessage()+")", wndCaricamento.getRosso());
					} catch (BadLocationException e2) {
						e2.printStackTrace();
					}
				}
				} else if (!Pianetafantacalcio.q.isEmpty()) {
					try {
						wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Lettura delle quotazioni già effettuata con successo", wndCaricamento.getVerde());
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
					
				} else {
					try {
						wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Quotazioni PianetaFantacalcio non trovate", wndCaricamento.getGiallo());
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
				//5 - Leggo Voti Raw
				try {
					//wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "Tentativo di lettura dei voti raw", wndCaricamento.getVerde());
					Operazioni.cr = Pianetafantacalcio.leggiVotiRaw(txtDest.getText()+"\\"+nomeVotiRaw);
				} catch (FileNotFoundException e1) {
					try {
						wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Errore durante la lettura dei voti RAW ("+e1.getMessage()+")", wndCaricamento.getRosso());
					} catch (BadLocationException e2) {
						e2.printStackTrace();
					}
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
				//6 - Leggo Quotazioni
				if (Pianetafantacalcio.q.isEmpty() && !wndPianetaFantacalcio.txtQuotazioni.equals("")){
				try {
					//wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "Tentativo di lettura delle quotazioni", wndCaricamento.getVerde());
					Pianetafantacalcio.q = Pianetafantacalcio.leggiQuotazioni(txtDest.getText()+"\\"+nomeQuot);
				} catch (FileNotFoundException e1) {
					try {
						wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Errore durante la lettura delle quotazioni ("+e1.getMessage()+")", wndCaricamento.getRosso());
					} catch (BadLocationException e2) {
						e2.printStackTrace();
					}
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
				}
				//7 - Correggo Cognomi
				//Operazioni.cr = Operazioni.correggiCognomi(Operazioni.cr, Pianetafantacalcio.co);
				//8 - Correggo Quotazioni
				//Pianetafantacalcio.q = Operazioni.correggiQuotazioni(Pianetafantacalcio.q, Pianetafantacalcio.co);
				
				//9 - Inserisco i voti ai calciatori (formatoMCC)
				try {
					wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Inserisco i voti ai calciatori", wndCaricamento.getVerde());
				} catch (BadLocationException e3) {
					e3.printStackTrace();
				}
				Operazioni.ca = Operazioni.formatoMCC(Operazioni.ca, Operazioni.cr, Pianetafantacalcio.co);
				//10 - Inserisco le quotazioni ai calciatori
				try {
					wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Inserisco le quotazioni ai calciatori", wndCaricamento.getVerde());
				} catch (BadLocationException e2) {
					e2.printStackTrace();
				}
				Operazioni.ca = Operazioni.inserisciQuotazioni(Operazioni.ca, Pianetafantacalcio.q, Pianetafantacalcio.co);
				//11 - Stampo i calciatori non corrispondenti
				
				try {
					//if (wndPreferenze.getCmbModVerifica().getItemAt(wndPreferenze.getCmbModVerifica().getSelectedIndex()).equals("File delle quotazioni")){
					//do la precedenza alle quotazioni (perchè ci sono tutti i calciatori)
					if (!Pianetafantacalcio.q.isEmpty()){
						Operazioni.stampaFuoriMCCdaQuotazione(Operazioni.fuoriMCCdaQuotazioni(Operazioni.ca, Pianetafantacalcio.q, Pianetafantacalcio.co), txtDest.getText()+"\\"+nomeNonTrov);
					} else {
						Operazioni.stampaFuoriMCCdaCalciatoreRaw(Operazioni.fuoriMCCdaCalciatoriRaw(Operazioni.ca, Operazioni.cr, Pianetafantacalcio.co), txtDest.getText()+"\\"+nomeNonTrov);
					}
					//System.out.println("CA = "+Operazioni.ca.size() + " - PF.Q = " + Pianetafantacalcio.q.size() + " - PF.CO = " + Pianetafantacalcio.co);
					ArrayList<Quotazione> quot_duplicati;
					ArrayList<Quotazione> quot_duplicati_non_gestiti;
					if (!Pianetafantacalcio.q.isEmpty()){
						quot_duplicati = Operazioni.controllaDuplicatiDaQuotazioni(Pianetafantacalcio.q, Pianetafantacalcio.co);
						quot_duplicati_non_gestiti = new ArrayList<Quotazione>();
						//Controllo se ci sono duplicati con le quotazioni
						
					if (quot_duplicati.size()>0){
						for (int z = 0; z < quot_duplicati.size(); z++){
							boolean trovato = false;
							if (Operazioni.esisteCorrezione(Pianetafantacalcio.co, quot_duplicati.get(z).getId()+"")){
								trovato = true;
							}
							if (!trovato){
								quot_duplicati_non_gestiti.add(quot_duplicati.get(z));
							}
						}
						}
						if (quot_duplicati_non_gestiti.size()>0){
						try {
							wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Trovati i seguenti duplicati nel file delle quotazioni:", wndCaricamento.getRosso());
							for (int i = 0; i < quot_duplicati_non_gestiti.size(); i++){
								wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"+ "+quot_duplicati_non_gestiti.get(i).getId()+" - " + quot_duplicati_non_gestiti.get(i).getCognome()+" - "+ quot_duplicati_non_gestiti.get(i).getSquadra(), wndCaricamento.getRosso());
							}
						} catch (BadLocationException e1) {
							e1.printStackTrace();
						}
					}
					
						//Controllo se ci sono duplicati sul file dei voti
						if (!Operazioni.cr.isEmpty()){
						ArrayList<CalciatoreRaw> voti_duplicati;
						ArrayList<CalciatoreRaw> voti_duplicati_non_gestiti;
						if (!Operazioni.cr.isEmpty()){
							voti_duplicati = Operazioni.controllaDuplicatiDaCalciatoriRaw(Operazioni.cr, Pianetafantacalcio.co);
							voti_duplicati_non_gestiti = new ArrayList<CalciatoreRaw>();
					
					if (voti_duplicati.size()>0){
						for (int z = 0; z < voti_duplicati.size(); z++){
							boolean trovato = false;
							if (Operazioni.esisteCorrezione(Pianetafantacalcio.co, voti_duplicati.get(z).getId()+"")){
								trovato = true;
							}
							if (!trovato){
								voti_duplicati_non_gestiti.add(voti_duplicati.get(z));
							}
						}
						}
						if (voti_duplicati_non_gestiti.size()>0){
						try {
							wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Trovati i seguenti duplicati nel file dei voti:", wndCaricamento.getRosso());
							for (int i = 0; i < voti_duplicati_non_gestiti.size(); i++){
								wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"+ "+voti_duplicati_non_gestiti.get(i).getId()+" - " + voti_duplicati_non_gestiti.get(i).getCognome(), wndCaricamento.getRosso());
							}
						} catch (BadLocationException e1) {
							e1.printStackTrace();
						}
						}
					}
						}
					}
					
				}catch (FileNotFoundException | UnsupportedEncodingException e1) {
						try {
							wndCaricamento.getDoc().insertString(wndCaricamento.getDoc().getLength(), "\n"+"- Errore nel generamento del file dei calciatori non corrispondenti ("+e1.getMessage()+")", wndCaricamento.getRosso());
						} catch (BadLocationException e2) {
							e2.printStackTrace();
						};
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
				//14 - Cancello tutti i valori di istanza
				getTxtCorrezioni().setText("");
				getTxtGiornata().setText("");
				getTxtMCC().setText("");
				getTxtQuotazioni().setText("");
				getTxtVoti().setText("");
				btnMCCOffline.setEnabled(true);
				btnMCCOnline.setEnabled(true);
				btnCorrezioniOffline.setEnabled(true);
				btnCorrezioniOnline.setEnabled(true);
				btnQuotazioniOnline.setEnabled(false);
				BtnQuotazioniOffline.setEnabled(true);
				btnVotiOffline.setEnabled(true);
				btnVotiOnline.setEnabled(false);
				Operazioni.ca.clear();
				Operazioni.cr.clear();
				Pianetafantacalcio.co.clear();
				Pianetafantacalcio.q.clear();
				getTxtDest().setText(wndPreferenze.getTxtGenPercorso().getText());
				nonGestiti.clear();
			}
		});

	}
}
