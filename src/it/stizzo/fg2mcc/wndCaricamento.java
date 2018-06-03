package it.stizzo.fg2mcc;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;

public class wndCaricamento extends JFrame {
	private static JTextPane console;
	private static JLabel lblLogo;
	private static StyledDocument doc;

	private static SimpleAttributeSet rosso;
	private static SimpleAttributeSet giallo;
	private static SimpleAttributeSet verde;
	private static SimpleAttributeSet imm_verde;
	private static SimpleAttributeSet imm_giallo;
	private static SimpleAttributeSet imm_rosso;
	
	public static SimpleAttributeSet getImm_verde() {
		return imm_verde;
	}

	public static void setImm_verde(SimpleAttributeSet imm_verde) {
		wndCaricamento.imm_verde = imm_verde;
	}

	public static SimpleAttributeSet getImm_giallo() {
		return imm_giallo;
	}

	public static void setImm_giallo(SimpleAttributeSet imm_giallo) {
		wndCaricamento.imm_giallo = imm_giallo;
	}

	public static SimpleAttributeSet getImm_rosso() {
		return imm_rosso;
	}

	public static void setImm_rosso(SimpleAttributeSet imm_rosso) {
		wndCaricamento.imm_rosso = imm_rosso;
	}

	public static SimpleAttributeSet getRosso() {
		return rosso;
	}

	public static void setRosso(SimpleAttributeSet rosso) {
		wndCaricamento.rosso = rosso;
	}

	public static SimpleAttributeSet getGiallo() {
		return giallo;
	}

	public static void setGiallo(SimpleAttributeSet giallo) {
		wndCaricamento.giallo = giallo;
	}

	public static SimpleAttributeSet getVerde() {
		return verde;
	}

	public static void setVerde(SimpleAttributeSet verde) {
		wndCaricamento.verde = verde;
	}

	public static JTextPane getConsole() {
		return console;
	}

	public static void setConsole(JTextPane console) {
		wndCaricamento.console = console;
	}

	public static JLabel getLblLogo() {
		return lblLogo;
	}

	public static void setLblLogo(JLabel lblLogo) {
		wndCaricamento.lblLogo = lblLogo;
	}
	
	public static StyledDocument getDoc() {
		return doc;
	}

	public static void setDoc(StyledDocument doc) {
		wndCaricamento.doc = doc;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("SeaGlassLookAndFeel");
		} catch (Exception e){
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wndCaricamento frame = new wndCaricamento();
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
	public wndCaricamento() {
		console = new JTextPane();
		console.setDropMode(DropMode.INSERT);
		console.setEditable(false);
		console.setBackground(Color.BLACK);
		doc = console.getStyledDocument();
		// build a style
		rosso = new SimpleAttributeSet();
		StyleConstants.setForeground(rosso, Color.decode("0xB02927"));
		giallo = new SimpleAttributeSet();
		StyleConstants.setForeground(giallo, Color.decode("0xBDBA1C"));
		verde = new SimpleAttributeSet();
		StyleConstants.setForeground(verde, Color.decode("0x1D9117"));
		imm_verde = new SimpleAttributeSet();
		StyleConstants.setIcon(imm_verde, new ImageIcon(getClass().getResource("/success-icon.png")));
		imm_giallo = new SimpleAttributeSet();
		StyleConstants.setIcon(imm_giallo, new ImageIcon(getClass().getResource("/Alert-icon.png")));
		imm_rosso = new SimpleAttributeSet();
		StyleConstants.setIcon(imm_rosso, new ImageIcon(getClass().getResource("/Stop-icon.png")));
		doc = console.getStyledDocument();
		
		
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png")));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setType(Type.POPUP);
		setResizable(false);
		setBounds(100, 100, 407, 470);
		getContentPane().setLayout(null);
		
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setBounds(10, 95, 381, 297);
		getContentPane().add(scrollpane);
		scrollpane.setBackground(Color.BLACK);
		//console.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		//console.setBackground(Color.BLACK);
		scrollpane.setViewportView(console);
		
		lblLogo = new JLabel("");
		lblLogo.setBounds(28, 11, 325, 73);
		//ImageIcon a = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/pianetafantacalcio_logo.png")).getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), java.awt.Image.SCALE_SMOOTH));
		//a.getImage().getScaledInstance(lblLogo.WIDTH, lblLogo.HEIGHT, java.awt.Image.SCALE_SMOOTH);
		//lblLogo.setIcon(a);
		getContentPane().add(lblLogo);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				wndIntro.frmCaricamento.setVisible(false);
				wndCaricamento.getConsole().setText("");
			}
		});
		btnOK.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		btnOK.setBounds(10, 403, 381, wndIntro.getAltezzaControlli());
		getContentPane().add(btnOK);
		
	}

	
}
