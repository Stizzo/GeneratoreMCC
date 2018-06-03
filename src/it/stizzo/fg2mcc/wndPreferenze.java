package it.stizzo.fg2mcc;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.prefs.Preferences;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JList;

public class wndPreferenze extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JTextField txtReteIndirizzo;
	private static JTextField txtRetePorta;
	private static JCheckBox chkReteCopiaFTP;
	private static JCheckBox chkReteAggiornamenti;
	private static JTextField txtReteUsername;
	private static JPasswordField txtRetePassword;
	private static JTextField txtGenPercorso;
	private static JComboBox cmbGenDimFont;
	private static JComboBox cmbGenFont;
	private static JCheckBox chckbxGestisciIVoti;
	private static JCheckBox chckbxCaricaSuServer;
	private static JComboBox<String> cmbMetodo;
	private static JCheckBox chckbxVoto15Min;
	private JTextField txtAggiungiSquadra6Politico;
	private JComboBox cmbSquadre6Politico;
	private static JTextField txtVoto15Min;
	
	public JTextField getTxtAggiungiSquadra6Politico() {
		return txtAggiungiSquadra6Politico;
	}

	public void setTxtAggiungiSquadra6Politico(
			JTextField txtAggiungiSquadra6Politico) {
		this.txtAggiungiSquadra6Politico = txtAggiungiSquadra6Politico;
	}

	public JComboBox getCmbSquadre6Politico() {
		return cmbSquadre6Politico;
	}

	public void setCmbSquadre6Politico(JComboBox cmbSquadre6Politico) {
		this.cmbSquadre6Politico = cmbSquadre6Politico;
	}

	public static JComboBox<String> getCmbMetodo() {
		return cmbMetodo;
	}

	public static void setCmbMetodo(JComboBox<String> cmbMetodo) {
		wndPreferenze.cmbMetodo = cmbMetodo;
	}

	public static JCheckBox getChckbxGestisciIVoti() {
		return chckbxGestisciIVoti;
	}

	public static void setChckbxGestisciIVoti(JCheckBox chckbxGestisciIVoti) {
		wndPreferenze.chckbxGestisciIVoti = chckbxGestisciIVoti;
	}

	public static JCheckBox getChckbxCaricaSuServer() {
		return chckbxCaricaSuServer;
	}

	public static void setChckbxCaricaSuServer(JCheckBox chckbxCaricaSuServer) {
		wndPreferenze.chckbxCaricaSuServer = chckbxCaricaSuServer;
	}

	public static JComboBox getCmbGenDimFont() {
		return cmbGenDimFont;
	}

	public static void setCmbGenDimFont(JComboBox cmbGenDimFont) {
		wndPreferenze.cmbGenDimFont = cmbGenDimFont;
	}

	public static JComboBox getCmbGenFont() {
		return cmbGenFont;
	}

	public static void setCmbGenFont(JComboBox cmbGenFont) {
		wndPreferenze.cmbGenFont = cmbGenFont;
	}

	public static JTextField getTxtGenPercorso() {
		return txtGenPercorso;
	}

	public static void setTxtGenPercorso(JTextField txtGenPercorso) {
		wndPreferenze.txtGenPercorso = txtGenPercorso;
	}




	public static JTextField getTxtReteIndirizzo() {
		return txtReteIndirizzo;
	}

	public static void setTxtReteIndirizzo(JTextField txtReteIndirizzo) {
		wndPreferenze.txtReteIndirizzo = txtReteIndirizzo;
	}

	public static JTextField getTxtRetePorta() {
		return txtRetePorta;
	}

	public static JCheckBox getChckbxVoto15Min() {
		return chckbxVoto15Min;
	}

	public static void setChckbxVoto15Min(JCheckBox chckbxVoto15Min) {
		wndPreferenze.chckbxVoto15Min = chckbxVoto15Min;
	}

	public static JTextField getTxtVoto15Min() {
		return txtVoto15Min;
	}

	public static void setTxtVoto15Min(JTextField txtVoto15Min) {
		wndPreferenze.txtVoto15Min = txtVoto15Min;
	}

	public static void setTxtRetePorta(JTextField txtRetePorta) {
		wndPreferenze.txtRetePorta = txtRetePorta;
	}

	public static JCheckBox getChkReteCopiaFTP() {
		return chkReteCopiaFTP;
	}

	public static void setChkReteCopiaFTP(JCheckBox chkReteCopiaFTP) {
		wndPreferenze.chkReteCopiaFTP = chkReteCopiaFTP;
	}

	public static JCheckBox getChkReteAggiornamenti() {
		return chkReteAggiornamenti;
	}

	public static void setChkReteAggiornamenti(JCheckBox chkReteAggiornamenti) {
		wndPreferenze.chkReteAggiornamenti = chkReteAggiornamenti;
	}

	public static JTextField getTxtReteUsername() {
		return txtReteUsername;
	}

	public static void setTxtReteUsername(JTextField txtReteUsername) {
		wndPreferenze.txtReteUsername = txtReteUsername;
	}

	public static JPasswordField getTxtRetePassword() {
		return txtRetePassword;
	}

	public static void setTxtRetePassword(JPasswordField txtRetePassword) {
		wndPreferenze.txtRetePassword = txtRetePassword;
	}

	public static JCheckBox getChckbxControllaAggiornamentiAllavvio() {
		return chkReteAggiornamenti;
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
					wndPreferenze frame = new wndPreferenze();
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
	public wndPreferenze() {
		setTitle("Preferenze");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png")));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 510, 309);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 0, 504, 227);
		getContentPane().add(tabbedPane_1);
		
		JPanel panel = new JPanel();
		tabbedPane_1.addTab("Generale", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblPercorsoPredefinito = new JLabel("Percorso predefinito:");
		lblPercorsoPredefinito.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		lblPercorsoPredefinito.setBounds(10, 11, 147, wndIntro.getAltezzaControlli());
		panel.add(lblPercorsoPredefinito);
		
		txtGenPercorso = new JTextField();
		txtGenPercorso.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		txtGenPercorso.setBounds(167, 11, 223, wndIntro.getAltezzaControlli());
		panel.add(txtGenPercorso);
		txtGenPercorso.setColumns(10);
		
		JButton btnGenSfoglia = new JButton("Sfoglia...");
		btnGenSfoglia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Seleziona il percorso per i file di destinazione");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				chooser.showOpenDialog(null);
				txtGenPercorso.setText(chooser.getSelectedFile().toString());
			}
			});
		btnGenSfoglia.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		btnGenSfoglia.setBounds(400, 11, 89, wndIntro.getAltezzaControlli());
		panel.add(btnGenSfoglia);
		
		JLabel lblFont = new JLabel("Carattere:");
		lblFont.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		lblFont.setBounds(10, 50, 72, wndIntro.getAltezzaControlli());
		panel.add(lblFont);
		
		
		cmbGenFont = new JComboBox();
		cmbGenFont.setModel(new DefaultComboBoxModel(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()));
		cmbGenFont.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		cmbGenFont.setBounds(167, 50, 223, wndIntro.getAltezzaControlli());
		panel.add(cmbGenFont);
		cmbGenFont.setEnabled(false); //TODO
		
		cmbGenDimFont = new JComboBox();
		cmbGenDimFont.setModel(new DefaultComboBoxModel(new String[] {"8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18"}));
		cmbGenDimFont.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		cmbGenDimFont.setBounds(422, 50, 67, wndIntro.getAltezzaControlli());
		panel.add(cmbGenDimFont);
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("Modalità di calcolo", null, panel_1, null);
		panel_1.setLayout(null);
		
		chckbxGestisciIVoti = new JCheckBox("Gestisci i voti degli allenatori (solo Fantagazzetta)");
		chckbxGestisciIVoti.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				chckbxCaricaSuServer.setEnabled(chckbxGestisciIVoti.isSelected());
			}
		});
		chckbxGestisciIVoti.setSelected(false);
		chckbxGestisciIVoti.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		chckbxGestisciIVoti.setBounds(10, 7, 487, wndIntro.getAltezzaControlli());
		panel_1.add(chckbxGestisciIVoti);
		
		chckbxCaricaSuServer = new JCheckBox("Carica su server FTP anche i voti degli allenatori");
		chckbxCaricaSuServer.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		chckbxCaricaSuServer.setBounds(10, 38, 487, wndIntro.getAltezzaControlli());
		panel_1.add(chckbxCaricaSuServer);
		chckbxCaricaSuServer.setSelected(false);
		
		JLabel lblMetodoDiInput = new JLabel("Metodo di input del file dei Voti");
		lblMetodoDiInput.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		lblMetodoDiInput.setBounds(10, 86, 257, 28);
		panel_1.add(lblMetodoDiInput);
		
		cmbMetodo = new JComboBox<String>();
		cmbMetodo.setModel(new DefaultComboBoxModel(new String[] {"Ristrutturato (più preciso)", "Diretto (più veloce)"}));
		cmbMetodo.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		cmbMetodo.setBounds(277, 86, 178, wndIntro.getAltezzaControlli());
		panel_1.add(cmbMetodo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 73, 479, 2);
		panel_1.add(separator);
		
		JLabel label_1 = new JLabel("");
		label_1.setToolTipText("Il metodo \"ristrutturato\" necessita di aprire il file dei voti XLS e risalvarlo nello stesso formato XLS per convalidarne la struttura; \n Il metodo \"Diretto\" lo processa direttamente tramite un metodo sperimentale");
		label_1.setIcon(new ImageIcon(getClass().getResource("/Help.png")));
		label_1.setBounds(465, 86, 24, wndIntro.getAltezzaControlli());
		panel_1.add(label_1);
		
		chckbxVoto15Min = new JCheckBox("Voto personalizzato per i calciatori che giocano 15 min. (solo PianetaFantacalcio)");
		chckbxVoto15Min.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxVoto15Min.isSelected()){
					txtVoto15Min.setEnabled(true);;
				
				}else{
					txtVoto15Min.setEnabled(false);
				}
			}
		});
		chckbxVoto15Min.setBounds(10, 127, 445, wndIntro.getAltezzaControlli());
		chckbxVoto15Min.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		panel_1.add(chckbxVoto15Min);
		
		txtVoto15Min = new JTextField();
		txtVoto15Min.setText("5.5");
		txtVoto15Min.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		txtVoto15Min.setBounds(10, 160, 86, wndIntro.getAltezzaControlli());
		panel_1.add(txtVoto15Min);
		txtVoto15Min.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 118, 479, 2);
		panel_1.add(separator_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane_1.addTab("Voti d'ufficio", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lbl1 = new JLabel("Inserisci la squadra (MAIUSCOLO):");
		lbl1.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		lbl1.setBounds(10, 50, 265, wndIntro.getAltezzaControlli());
		panel_3.add(lbl1);
		
		txtAggiungiSquadra6Politico = new JTextField();
		txtAggiungiSquadra6Politico.setBounds(285, 50, 153, wndIntro.getAltezzaControlli());
		panel_3.add(txtAggiungiSquadra6Politico);
		txtAggiungiSquadra6Politico.setColumns(10);
		
		JButton btnAggiungiSquadra6Politico = new JButton("");
		btnAggiungiSquadra6Politico.setIcon(new ImageIcon(getClass().getResource("/add-icon.png")));
		btnAggiungiSquadra6Politico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!txtAggiungiSquadra6Politico.getText().equals("")){
					cmbSquadre6Politico.addItem(txtAggiungiSquadra6Politico.getText().trim());
					txtAggiungiSquadra6Politico.setText("");
				}
			}
		});
		btnAggiungiSquadra6Politico.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		btnAggiungiSquadra6Politico.setBounds(440, 50, 49, wndIntro.getAltezzaControlli());
		panel_3.add(btnAggiungiSquadra6Politico);
		
		JLabel lbl2 = new JLabel("Squadre a cui assegnare:");
		lbl2.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		lbl2.setBounds(10, 85, 214, wndIntro.getAltezzaControlli());
		panel_3.add(lbl2);
		
		cmbSquadre6Politico = new JComboBox();
		cmbSquadre6Politico.setBounds(234, 85, 204, wndIntro.getAltezzaControlli());
		panel_3.add(cmbSquadre6Politico);
		
		JLabel lblNewLabel_1 = new JLabel("Le squadre nella lista (in basso) saranno quelle alle quali verr\u00E0 assegnato il 6 politico.");
		lblNewLabel_1.setBounds(10, 11, 479, wndIntro.getAltezzaControlli());
		panel_3.add(lblNewLabel_1);
		
		JButton btnRimuoviSquadra6Politico = new JButton("");
		
		btnRimuoviSquadra6Politico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (cmbSquadre6Politico.getSelectedIndex() != -1){
				cmbSquadre6Politico.removeItemAt(cmbSquadre6Politico.getSelectedIndex());
				}
			}
		});
		btnRimuoviSquadra6Politico.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		btnRimuoviSquadra6Politico.setIcon(new ImageIcon(getClass().getResource("/delete-icon.png")));
		btnRimuoviSquadra6Politico.setBounds(440, 85, 49, wndIntro.getAltezzaControlli());
		panel_3.add(btnRimuoviSquadra6Politico);
		
		JPanel panel_2 = new JPanel();
		tabbedPane_1.addTab("Rete", null, panel_2, null);
		panel_2.setLayout(null);
		
		chkReteAggiornamenti = new JCheckBox("Controlla aggiornamenti all'avvio");
		chkReteAggiornamenti.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		chkReteAggiornamenti.setBounds(6, 7, 487, wndIntro.getAltezzaControlli());
		panel_2.add(chkReteAggiornamenti);
		
		chkReteCopiaFTP = new JCheckBox("Carica una copia dei file elaborati su server FTP");
		chkReteCopiaFTP.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		chkReteCopiaFTP.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (chkReteCopiaFTP.isSelected()){
					txtReteUsername.setEnabled(true);;
					txtRetePassword.setEnabled(true);
					txtReteIndirizzo.setEnabled(true);
					txtRetePorta.setEnabled(true);
				}else{
					txtReteUsername.setEnabled(false);
					txtRetePassword.setEnabled(false);
					txtReteIndirizzo.setEnabled(false);
					txtRetePorta.setEnabled(false);	
				}
			}
		});
		chkReteCopiaFTP.setBounds(6, 33, 487, wndIntro.getAltezzaControlli());
		panel_2.add(chkReteCopiaFTP);
		
		JLabel lblIndirizzoServer = new JLabel("Indirizzo server:");
		lblIndirizzoServer.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		lblIndirizzoServer.setBounds(32, 68, 115, wndIntro.getAltezzaControlli());
		panel_2.add(lblIndirizzoServer);
		
		txtReteIndirizzo = new JTextField();
		txtReteIndirizzo.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		txtReteIndirizzo.setEnabled(false);
		txtReteIndirizzo.setText("ftp.tuoserver.altervista.org");
		txtReteIndirizzo.setBounds(157, 68, 190, wndIntro.getAltezzaControlli());
		panel_2.add(txtReteIndirizzo);
		txtReteIndirizzo.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		lblUsername.setBounds(32, 107, 115, wndIntro.getAltezzaControlli());
		panel_2.add(lblUsername);
		
		JLabel lblPorta = new JLabel("Porta:");
		lblPorta.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		lblPorta.setBounds(369, 68, 52, wndIntro.getAltezzaControlli());
		panel_2.add(lblPorta);
		
		txtRetePorta = new JTextField();
		txtRetePorta.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		txtRetePorta.setEnabled(false);
		txtRetePorta.setText("21");
		txtRetePorta.setBounds(435, 68, 58, wndIntro.getAltezzaControlli());
		panel_2.add(txtRetePorta);
		txtRetePorta.setColumns(10);
		
		txtReteUsername = new JTextField();
		txtReteUsername.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		txtReteUsername.setText("username");
		txtReteUsername.setEnabled(false);
		txtReteUsername.setBounds(157, 107, 190, wndIntro.getAltezzaControlli());
		panel_2.add(txtReteUsername);
		txtReteUsername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		lblNewLabel.setBounds(32, 146, 115, wndIntro.getAltezzaControlli());
		panel_2.add(lblNewLabel);
		
		txtRetePassword = new JPasswordField();
		txtRetePassword.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		txtRetePassword.setEnabled(false);
		txtRetePassword.setBounds(157, 146, 190, wndIntro.getAltezzaControlli());
		panel_2.add(txtRetePassword);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Preferences prefs = Preferences.userNodeForPackage(wndPreferenze.class);
				
				prefs.put("TxtGenPercorso", getTxtGenPercorso().getText());
				prefs.putBoolean("ChkReteAggiornamenti", getChkReteAggiornamenti().isSelected());
				prefs.putBoolean("ChkReteCopiaFTP", getChkReteCopiaFTP().isSelected());
				prefs.put("TxtReteIndirizzo", getTxtReteIndirizzo().getText());
				prefs.put("TxtRetePassword", String.valueOf(getTxtRetePassword().getPassword()));
				prefs.put("TxtRetePorta", getTxtRetePorta().getText());
				prefs.put("TxtReteUsername", getTxtReteUsername().getText());
				//prefs.putInt("CmbGenFont", getCmbGenFont().getSelectedIndex());
				prefs.putInt("CmbGenDimFont", getCmbGenDimFont().getSelectedIndex());
				//prefs.put("stringaCarattere", getCmbGenFont().getSelectedItem().toString());
				prefs.put("stringaDimCarattere", getCmbGenDimFont().getSelectedItem().toString());
				wndPianetaFantacalcio.getTxtDest().setText(txtGenPercorso.getText());
				wndFantagazzetta.getTxtDest().setText(txtGenPercorso.getText());
				prefs.putBoolean("ChkGestisciAllenatori", getChckbxGestisciIVoti().isSelected());
				prefs.putBoolean("ChkCaricaSuServer", getChckbxCaricaSuServer().isSelected());
				prefs.putInt("CmbMetodo", getCmbMetodo().getSelectedIndex());
				wndIntro.frmPreferenze.setVisible(false);
				prefs.putBoolean("ChkVoto15Min", chckbxVoto15Min.isSelected());
				prefs.put("txtVoto15Min", txtVoto15Min.getText());
				
				//Aggiungo le squadra a cui applicare il 6 politico all'array in Operazioni
				if (cmbSquadre6Politico.getItemCount() != 0){
					Operazioni.squadre6politico.clear();
				for (int i = 0; i < cmbSquadre6Politico.getItemCount(); i++){
					Operazioni.squadre6politico.add(cmbSquadre6Politico.getItemAt(i).toString());
				}
			}
			}
		});
		btnOk.setBounds(383, 241, 111, wndIntro.getAltezzaControlli());
		getContentPane().add(btnOk);
		
		
	}
}
