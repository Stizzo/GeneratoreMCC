package it.stizzo.fg2mcc;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Desktop;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.prefs.Preferences;
import javax.swing.SwingConstants;

public class wndIntro extends JFrame {

	public static JFrame frmIntro;
	public static JFrame frmFantagazzetta;
	public static JFrame frmPianetafantacalcio;
	public static JFrame frmGazzettaDelloSport;
	public static JFrame frmBonus;
	public static JFrame frmAbout;
	public static JFrame frmPreferenze;
	public static JFrame frmCaricamento;
	
	public static boolean gestioneNomeSuMCC = true;
	
	private static int altezzaControlli = 28;
	private static String carattere = "Arial";
	private static int dimensioniCarattere;

	public static int getDimensioniCarattere() {
		return dimensioniCarattere;
	}


	public static void setDimensioniCarattere(int dimensioniCarattere) {
		wndIntro.dimensioniCarattere = dimensioniCarattere;
	}


	public static String getCarattere() {
		return carattere;
	}


	public static void setCarattere(String carattere) {
		wndIntro.carattere = carattere;
	}


	public static int getAltezzaControlli() {
		return altezzaControlli;
	}


	public static void setAltezzaControlli(int altezzaControlli) {
		wndIntro.altezzaControlli = altezzaControlli;
	}


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
					Preferences prefImp = Preferences.userNodeForPackage(wndPreferenze.class);
					Preferences prefBonus = Preferences.userNodeForPackage(wndBonus.class);
					
					//Carico il carattere e la domensione del font:
					wndIntro.setCarattere(prefImp.get("stringaCarattere", "Gisha"));
					wndIntro.setDimensioniCarattere(Integer.parseInt(prefImp.get("stringaDimCarattere", "12")));
					
					frmPreferenze = new wndPreferenze();
					frmPreferenze.setVisible(false);
					frmFantagazzetta = new wndFantagazzetta();
					frmFantagazzetta.setVisible(false);
					frmPianetafantacalcio = new wndPianetaFantacalcio();
					frmPianetafantacalcio.setVisible(false);
					frmGazzettaDelloSport = new wndGazzettaDelloSport();
					frmGazzettaDelloSport.setVisible(false);
					frmIntro = new wndIntro();
					frmIntro.setVisible(true);
					frmBonus = new wndBonus();
					frmBonus.setVisible(false);
					frmAbout = new wndAbout();
					frmAbout.setVisible(false);
					frmCaricamento = new wndCaricamento();
					frmCaricamento.setVisible(false);
					
					
					
					//Carico e assegno i bonus/malus salvati:
					
					
					wndBonus.getTxtAmm().setText(prefBonus.get("Amm", "-0.5"));
					wndBonus.getTxtEsp().setText(prefBonus.get("Esp", "-1"));
					wndBonus.getTxtAss().setText(prefBonus.get("Ass", "1"));
					wndBonus.getTxtAuto().setText(prefBonus.get("Auto", "-2")); 
					wndBonus.getTxtGolSub().setText(prefBonus.get("GolSub", "-1"));
					wndBonus.getTxtPortImb().setText(prefBonus.get("PortImb", "0"));
					wndBonus.getTxtRigPar().setText(prefBonus.get("RigPar", "+3"));
					wndBonus.getTxtRigSba().setText(prefBonus.get("RigSba", "-3"));
					wndBonus.getTxtGolPor().setText(prefBonus.get("GolPor", "+3"));
					wndBonus.getTxtGolDif().setText(prefBonus.get("GolDif", "+3"));
					wndBonus.getTxtGolCen().setText(prefBonus.get("GolCen", "+3"));
					wndBonus.getTxtGolAtt().setText(prefBonus.get("GolAtt", "+3"));
					wndBonus.getTxtGolRig().setText(prefBonus.get("GolRig", "+3"));
					wndBonus.getTxtAutPor().setText(prefBonus.get("AutPor", "-2"));
					wndBonus.getTxtGolVittoria().setText(prefBonus.get("GolVit", "0"));
					wndBonus.getTxtGolPar().setText(prefBonus.get("Golpar", "0"));
					wndBonus.getChkGolRigGolNor().setSelected((prefBonus.getBoolean("CheckRig", true)));
					if (wndBonus.getChkGolRigGolNor().isSelected()){
						wndBonus.getBtnGolRigMinus().setEnabled(false);
						wndBonus.getBtnGolRigPlus().setEnabled(false);
						wndBonus.getTxtGolRig().setEnabled(false);
					} else {
						wndBonus.getBtnGolRigMinus().setEnabled(true);
						wndBonus.getBtnGolRigPlus().setEnabled(true);
						wndBonus.getTxtGolRig().setEnabled(true);
					}
					
					
					//carico e assegno le preferenze:
					
					wndPreferenze.getTxtGenPercorso().setText(prefImp.get("TxtGenPercorso", Operazioni.pathDocumenti()));
					wndPreferenze.getChckbxControllaAggiornamentiAllavvio().setSelected(prefImp.getBoolean("ChkReteAggiornamenti", true));
					wndPreferenze.getChkReteCopiaFTP().setSelected(prefImp.getBoolean("ChkReteCopiaFTP", false));
					wndPreferenze.getTxtReteIndirizzo().setText(prefImp.get("TxtReteIndirizzo", "ftp.nomeutente.altervista.org/fcbe/dati/2013"));
					wndPreferenze.getTxtRetePassword().setText(prefImp.get("TxtRetePassword", ""));
					wndPreferenze.getTxtRetePorta().setText(prefImp.get("txtRetePorta", "21"));
					wndPreferenze.getTxtReteUsername().setText(prefImp.get("TxtReteUsername", "nomeutente"));
					//wndPreferenze.getCmbGenFont().setSelectedIndex(prefImp.getInt("CmbGenFont", -1));
					wndPreferenze.getCmbGenDimFont().setSelectedIndex(prefImp.getInt("CmbGenDimFont", 3));
					//wndIntro.setCarattere(wndPreferenze.getCmbGenFont().getSelectedItem().toString());
					wndIntro.setDimensioniCarattere(Integer.parseInt(wndPreferenze.getCmbGenDimFont().getSelectedItem().toString()));
					wndPreferenze.getChckbxGestisciIVoti().setSelected(prefImp.getBoolean("ChkGestisciAllenatori", false));
					wndPreferenze.getChckbxCaricaSuServer().setSelected(prefImp.getBoolean("ChkCaricaSuServer", false));
					wndPreferenze.getCmbMetodo().setSelectedIndex(prefImp.getInt("CmbMetodo", 1));
					wndPreferenze.getChckbxVoto15Min().setSelected(prefImp.getBoolean("ChkVoto15Min", false));
					wndPreferenze.getTxtVoto15Min().setText(prefImp.get("txtVoto15Min", "5.5"));
					//##################### Controllo gli aggiornamenti
					if (wndPreferenze.getChkReteAggiornamenti().isSelected()){
						Operazioni.controllaAggiornamenti();
					}
					if (wndPreferenze.getChckbxVoto15Min().isSelected()){
						wndPreferenze.getTxtVoto15Min().setEnabled(true);
					} else {
						wndPreferenze.getTxtVoto15Min().setEnabled(false);
					}
					
					
					
					//##################### CREO GLI ARRAY
					Operazioni.ca = new ArrayList<Calciatore>();
					Operazioni.cr = new ArrayList<CalciatoreRaw>();
					Operazioni.squadre6politico = new ArrayList<String>();
					Fantagazzetta.co = new ArrayList<Correzione>();
					Fantagazzetta.q = new ArrayList<Quotazione>();
					Pianetafantacalcio.co = new ArrayList<Correzione>();
					Pianetafantacalcio.q = new ArrayList<Quotazione>();
					wndFantagazzetta.getTxtDest().setText(wndPreferenze.getTxtGenPercorso().getText());
					wndPianetaFantacalcio.getTxtDest().setText(wndPreferenze.getTxtGenPercorso().getText());
					wndGazzettaDelloSport.getTxtDest().setText(wndPreferenze.getTxtGenPercorso().getText());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public wndIntro() {
		frmIntro = new JFrame();
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png")));
		getContentPane().setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		setResizable(false);
		setTitle("Generatore MCC " + Operazioni.version);// + "_rev" + Operazioni.versione_rev);
		setBounds(100, 100, 532, 403);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		JButton btnFantagazzetta = new JButton("");
		btnFantagazzetta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				//WindowEvent closing = new WindowEvent(frmIntro,WindowEvent.WINDOW_CLOSING);
				//frmIntro.dispatchEvent(new WindowEvent(frmIntro,WindowEvent.WINDOW_CLOSING));
				Operazioni.redazione = "Fantagazzetta";
				frmIntro.setVisible(false);
				frmFantagazzetta.setVisible(true);
				//wndFantaGazzetta.frmFantaGazzetta.dispatchEvent(new WindowEvent(wndFantaGazzetta.frmFantaGazzetta, WindowEvent.WINDOW_GAINED_FOCUS));
				//wndFantagazzetta.main(null);
			//Windows_home.main(null);
			//wndIntro.this.frmIntro.setVisible(false);
			}
		});
		btnFantagazzetta.setIcon(new ImageIcon(getClass().getResource("/fantagazzetta_logo.png")));
		btnFantagazzetta.setBounds(10, 127, 278, 97);
		getContentPane().add(btnFantagazzetta);
		
		JButton btnPianetaFantacalcio = new JButton("");
		btnPianetaFantacalcio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Operazioni.redazione = "Gazzetta dello Sport";
				frmIntro.setVisible(false);
				frmPianetafantacalcio.setVisible(true);
			}
		});
		btnPianetaFantacalcio.setIcon(new ImageIcon(getClass().getResource("/pianetafantacalcio_logo.png")));
		btnPianetaFantacalcio.setBounds(10, 251, 278, 97);
		getContentPane().add(btnPianetaFantacalcio);
		
		JButton btnFGVoti = new JButton("Visita la pagina dei voti");
		btnFGVoti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Desktop.isDesktopSupported())
					try {
						Desktop.getDesktop().browse(new URI("http://www.fantagazzetta.com/voti-fantagazzetta-serie-A"));
					} catch (IOException | URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		btnFGVoti.setBounds(298, 127, 219, 23);
		getContentPane().add(btnFGVoti);
		
		JButton btnFGQuot = new JButton("Visita la pagina delle quotazioni");
		btnFGQuot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Desktop.isDesktopSupported())
					try {
						Desktop.getDesktop().browse(new URI("http://www.fantagazzetta.com/quotazioni-serie-A"));
					} catch (IOException | URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		btnFGQuot.setBounds(298, 161, 219, 23);
		getContentPane().add(btnFGQuot);
		
		JButton btnPFQuot = new JButton("Visita la pagina delle quotazioni");
		btnPFQuot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Desktop.isDesktopSupported())
					try {
						Desktop.getDesktop().browse(new URI("http://www.pianetafantacalcio.it/Giocatori_Quotazioni.asp"));
					} catch (IOException | URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		btnPFQuot.setBounds(298, 285, 219, 23);
		getContentPane().add(btnPFQuot);
		
		JButton btnPFVot = new JButton("Visita la pagina dei voti");
		btnPFVot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Desktop.isDesktopSupported())
					try {
						Desktop.getDesktop().browse(new URI("http://www.pianetafantacalcio.it/Voti_Ufficiali.asp"));
					} catch (IOException | URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		btnPFVot.setBounds(298, 251, 219, 23);
		getContentPane().add(btnPFVot);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 238, 507, 2);
		getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/GeneratoreMCC_logo4.png")));
		lblNewLabel.setBounds(10, 11, 507, 86);
		getContentPane().add(lblNewLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 114, 507, 2);
		getContentPane().add(separator_1);
		
		JButton btnGS = new JButton("");
		
		btnGS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmIntro.setVisible(false);
				frmGazzettaDelloSport.setVisible(true);
			}
			
		});
		btnGS.setIcon(new ImageIcon(getClass().getResource("/gazzettadellosport_logo.png")));
		btnGS.setBounds(10, 372, 278, 97);
		getContentPane().add(btnGS);
		
		JButton btnGSVot = new JButton("Visita la pagina dei voti");
		btnGSVot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported())
					try {
						Desktop.getDesktop().browse(new URI("http://www.gazzetta.it/calcio/fantanews/voti/serie-a-2015-16/index.htm"));
					} catch (IOException | URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnGSVot.setBounds(298, 372, 219, 23);
		getContentPane().add(btnGSVot);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 359, 507, 2);
		getContentPane().add(separator_2);
	}
	
	public static JFrame getFrmIntro() {
		return frmIntro;
	}


	public static void setFrmIntro(JFrame frmIntro) {
		wndIntro.frmIntro = frmIntro;
	}


	public static JFrame getFrmFantagazzetta() {
		return frmFantagazzetta;
	}


	public static void setFrmFantagazzetta(JFrame frmFantagazzetta) {
		wndIntro.frmFantagazzetta = frmFantagazzetta;
	}


	public static JFrame getFrmPianetafantacalcio() {
		return frmPianetafantacalcio;
	}


	public static void setFrmPianetafantacalcio(JFrame frmPianetafantacalcio) {
		wndIntro.frmPianetafantacalcio = frmPianetafantacalcio;
	}


	public static JFrame getFrmBonus() {
		return frmBonus;
	}


	public static void setFrmBonus(JFrame frmBonus) {
		wndIntro.frmBonus = frmBonus;
	}


	public static JFrame getFrmAbout() {
		return frmAbout;
	}


	public static void setFrmAbout(JFrame frmAbout) {
		wndIntro.frmAbout = frmAbout;
	}


	public static JFrame getFrmPreferenze() {
		return frmPreferenze;
	}


	public static void setFrmPreferenze(JFrame frmPreferenze) {
		wndIntro.frmPreferenze = frmPreferenze;
	}
}
