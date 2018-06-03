package it.stizzo.fg2mcc;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class wndAbout extends JFrame {

	private JPanel contentPane;

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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wndAbout frame = new wndAbout();
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
	public wndAbout() {
		setAlwaysOnTop(true);
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("About GeneratoreMCC " + Operazioni.version );//+ "_rev" + Operazioni.versione_rev);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png")));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 400, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GeneratoreMCC " + Operazioni.version );//+ "_rev" + Operazioni.versione_rev);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Gisha", Font.BOLD, 10));
		lblNewLabel.setBounds(10, 11, 363, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblUnoStrumentoPer = new JLabel("Uno strumento per:");
		lblUnoStrumentoPer.setFont(new Font("Gisha", Font.PLAIN, 14));
		lblUnoStrumentoPer.setBounds(9, 142, 364, 14);
		contentPane.add(lblUnoStrumentoPer);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/fcbe_logo.png")));
		lblNewLabel_1.setBounds(9, 167, 363, 84);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("/GeneratoreMCC_logo4mini.png")));
		lblNewLabel_2.setBounds(10, 36, 363, 78);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 129, 364, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 125, 364, 2);
		contentPane.add(separator_1);
		
		JLabel lblDisegnatoESviluppato = new JLabel("Disegnato e sviluppato da");
		lblDisegnatoESviluppato.setFont(new Font("Gisha", Font.PLAIN, 14));
		lblDisegnatoESviluppato.setBounds(10, 262, 364, 14);
		contentPane.add(lblDisegnatoESviluppato);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(getClass().getResource("/Stizzo_logo.jpg")));
		lblNewLabel_3.setBounds(10, 287, 114, 103);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblStefanoIzzostizzo = new JLabel("Stefano Izzo (Stizzo)");
		lblStefanoIzzostizzo.setFont(new Font("Gisha", Font.PLAIN, 14));
		lblStefanoIzzostizzo.setBounds(134, 287, 239, 14);
		contentPane.add(lblStefanoIzzostizzo);
		
		JButton btnNewButton = new JButton("Facebook");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Desktop.isDesktopSupported())
					try {
						Desktop.getDesktop().browse(new URI("https://www.facebook.com/Stizzo89"));
					} catch (IOException | URISyntaxException e) {
						
						e.printStackTrace();
					}
			}
		});
		btnNewButton.setFont(new Font("Gisha", Font.PLAIN, 14));
		btnNewButton.setBounds(134, 367, 106, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Twitter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Desktop.isDesktopSupported())
					try {
						Desktop.getDesktop().browse(new URI("https://www.twitter.com/Stizzo89"));
					} catch (IOException | URISyntaxException e) {
						
						e.printStackTrace();
					}
			}
		});
		btnNewButton_1.setFont(new Font("Gisha", Font.PLAIN, 14));
		btnNewButton_1.setBounds(267, 367, 106, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblContattamiSu = new JLabel("Contattami su:");
		lblContattamiSu.setFont(new Font("Gisha", Font.PLAIN, 12));
		lblContattamiSu.setBounds(134, 348, 239, 14);
		contentPane.add(lblContattamiSu);
		
		JLabel lblHaiUnideaPer = new JLabel("Hai un'idea per migliorare GeneratoreMCC?");
		lblHaiUnideaPer.setFont(new Font("Gisha", Font.PLAIN, 12));
		lblHaiUnideaPer.setBounds(134, 331, 239, 14);
		contentPane.add(lblHaiUnideaPer);
	}
}
