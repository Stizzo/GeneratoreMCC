package it.stizzo.fg2mcc;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.prefs.Preferences;

public class wndBonus extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField txtAmm;
	private static JTextField txtEsp;
	private static JTextField txtAss;
	private static JTextField txtAuto;
	private static JTextField txtGolSub;
	private static JTextField txtRigSba;
	private static JTextField txtRigPar;
	private static JTextField txtGolCen;
	private static JTextField txtGolPor;
	private static JTextField txtGolAtt;
	private static JTextField txtGolDif;
	private static JTextField txtGolRig;
	private static JTextField txtPortImb;
	private static JCheckBox chkGolRigGolNor;
	private double soglia = 0.5;
	private static JTextField txtGolVittoria;
	private static JTextField txtGolPar;
	private static JTextField txtAutPor;
	private static Button btnGolRigMinus;
	private static Button btnGolRigPlus;
	
	
	
	public static Button getBtnGolRigMinus() {
		return btnGolRigMinus;
	}

	public static void setBtnGolRigMinus(Button btnGolRigMinus) {
		wndBonus.btnGolRigMinus = btnGolRigMinus;
	}

	public static Button getBtnGolRigPlus() {
		return btnGolRigPlus;
	}

	public static void setBtnGolRigPlus(Button btnGolRigPlus) {
		wndBonus.btnGolRigPlus = btnGolRigPlus;
	}

	public static JTextField getTxtAmm() {
		return txtAmm;
	}

	public static void setTxtAmm(JTextField txtAmm) {
		wndBonus.txtAmm = txtAmm;
	}

	public static JTextField getTxtEsp() {
		return txtEsp;
	}

	public static void setTxtEsp(JTextField txtEsp) {
		wndBonus.txtEsp = txtEsp;
	}

	public static JTextField getTxtAss() {
		return txtAss;
	}

	public static void setTxtAss(JTextField txtAss) {
		wndBonus.txtAss = txtAss;
	}

	public static JTextField getTxtAuto() {
		return txtAuto;
	}

	public static void setTxtAuto(JTextField txtAuto) {
		wndBonus.txtAuto = txtAuto;
	}

	public static JTextField getTxtGolSub() {
		return txtGolSub;
	}

	public static void setTxtGolSub(JTextField txtGolSub) {
		wndBonus.txtGolSub = txtGolSub;
	}

	public static JTextField getTxtRigSba() {
		return txtRigSba;
	}

	public static void setTxtRigSba(JTextField txtRigSba) {
		wndBonus.txtRigSba = txtRigSba;
	}

	public static JTextField getTxtRigPar() {
		return txtRigPar;
	}

	public static void setTxtRigPar(JTextField txtRigPar) {
		wndBonus.txtRigPar = txtRigPar;
	}

	public static JTextField getTxtGolCen() {
		return txtGolCen;
	}

	public static void setTxtGolCen(JTextField txtGolCen) {
		wndBonus.txtGolCen = txtGolCen;
	}

	public static JTextField getTxtGolPor() {
		return txtGolPor;
	}

	public static void setTxtGolPor(JTextField txtGolPor) {
		wndBonus.txtGolPor = txtGolPor;
	}

	public static JTextField getTxtGolAtt() {
		return txtGolAtt;
	}

	public static void setTxtGolAtt(JTextField txtGolAtt) {
		wndBonus.txtGolAtt = txtGolAtt;
	}

	public static JTextField getTxtGolDif() {
		return txtGolDif;
	}

	public static void setTxtGolDif(JTextField txtGolDif) {
		wndBonus.txtGolDif = txtGolDif;
	}

	public static JTextField getTxtGolRig() {
		return txtGolRig;
	}

	public static void setTxtGolRig(JTextField txtGolRig) {
		wndBonus.txtGolRig = txtGolRig;
	}

	public static JTextField getTxtPortImb() {
		return txtPortImb;
	}

	public static void setTxtPortImb(JTextField txtPortImb) {
		wndBonus.txtPortImb = txtPortImb;
	}

	public static JCheckBox getChkGolRigGolNor() {
		return chkGolRigGolNor;
	}

	public static void setChkGolRigGolNor(JCheckBox chkGolRigGolNor) {
		wndBonus.chkGolRigGolNor = chkGolRigGolNor;
	}

	public double getSoglia() {
		return soglia;
	}

	public void setSoglia(double soglia) {
		this.soglia = soglia;
	}

	public static JTextField getTxtGolVittoria() {
		return txtGolVittoria;
	}

	public static void setTxtGolVittoria(JTextField txtGolVittoria) {
		wndBonus.txtGolVittoria = txtGolVittoria;
	}

	public static JTextField getTxtGolPar() {
		return txtGolPar;
	}

	public static void setTxtGolPar(JTextField txtGolPar) {
		wndBonus.txtGolPar = txtGolPar;
	}
	
	

	public static JTextField getTxtAutPor() {
		return txtAutPor;
	}

	public static void setTxtAutPor(JTextField txtAutPor) {
		wndBonus.txtAutPor = txtAutPor;
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wndBonus frame = new wndBonus();
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
	public wndBonus() {
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Modifica valori Bonus/Malus");
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png")));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 523, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAmmonizione = new JLabel("Ammonizione:");
		lblAmmonizione.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		lblAmmonizione.setBounds(10, 9, 128, wndIntro.getAltezzaControlli());
		contentPane.add(lblAmmonizione);
		
		txtAmm = new JTextField();
		txtAmm.setEditable(false);
		txtAmm.setHorizontalAlignment(SwingConstants.CENTER);
		txtAmm.setText("-0.5");
		txtAmm.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		txtAmm.setBounds(148, 9, 59, 28);
		contentPane.add(txtAmm);
		txtAmm.setColumns(10);
		
		JLabel lblEspulsione = new JLabel("Espulsione:");
		lblEspulsione.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		lblEspulsione.setBounds(269, 9, 128, wndIntro.getAltezzaControlli());
		contentPane.add(lblEspulsione);
		
		txtEsp = new JTextField();
		txtEsp.setEditable(false);
		txtEsp.setHorizontalAlignment(SwingConstants.CENTER);
		txtEsp.setText("-1");
		txtEsp.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		txtEsp.setColumns(10);
		txtEsp.setBounds(404, 9, 59, wndIntro.getAltezzaControlli());
		contentPane.add(txtEsp);
		
		JLabel lblAssist = new JLabel("Assist:");
		lblAssist.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		lblAssist.setBounds(10, 37, 128, wndIntro.getAltezzaControlli());
		contentPane.add(lblAssist);
		
		txtAss = new JTextField();
		txtAss.setEditable(false);
		txtAss.setHorizontalAlignment(SwingConstants.CENTER);
		txtAss.setText("1");
		txtAss.setDropMode(DropMode.INSERT);
		txtAss.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		txtAss.setColumns(10);
		txtAss.setBounds(148, 37, 59, wndIntro.getAltezzaControlli());
		contentPane.add(txtAss);
		
		JLabel lblAutogol = new JLabel("Autogol:");
		lblAutogol.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		lblAutogol.setBounds(269, 37, 128, wndIntro.getAltezzaControlli());
		contentPane.add(lblAutogol);
		
		txtAuto = new JTextField();
		txtAuto.setEditable(false);
		txtAuto.setHorizontalAlignment(SwingConstants.CENTER);
		txtAuto.setText("-2");
		txtAuto.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		txtAuto.setColumns(10);
		txtAuto.setBounds(404, 37, 59, wndIntro.getAltezzaControlli());
		contentPane.add(txtAuto);
		
		JLabel lblGolSubito = new JLabel("Gol subito:");
		lblGolSubito.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		lblGolSubito.setBounds(10, 65, 128, wndIntro.getAltezzaControlli());
		contentPane.add(lblGolSubito);
		
		txtGolSub = new JTextField();
		txtGolSub.setEditable(false);
		txtGolSub.setHorizontalAlignment(SwingConstants.CENTER);
		txtGolSub.setText("-1");
		txtGolSub.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		txtGolSub.setColumns(10);
		txtGolSub.setBounds(148, 65, 59, wndIntro.getAltezzaControlli());
		contentPane.add(txtGolSub);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 98, 495, 3);
		contentPane.add(separator);
		
		JLabel lblRigoreSbagliato = new JLabel("Rigore sbagliato:");
		lblRigoreSbagliato.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		lblRigoreSbagliato.setBounds(269, 107, 128, wndIntro.getAltezzaControlli());
		contentPane.add(lblRigoreSbagliato);
		
		txtRigSba = new JTextField();
		txtRigSba.setEditable(false);
		txtRigSba.setHorizontalAlignment(SwingConstants.CENTER);
		txtRigSba.setText("-3");
		txtRigSba.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		txtRigSba.setColumns(10);
		txtRigSba.setBounds(404, 107, 59, wndIntro.getAltezzaControlli());
		contentPane.add(txtRigSba);
		
		JLabel lblRigoreParato = new JLabel("Rigore parato:");
		lblRigoreParato.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		lblRigoreParato.setBounds(10, 107, 128, wndIntro.getAltezzaControlli());
		contentPane.add(lblRigoreParato);
		
		txtRigPar = new JTextField();
		txtRigPar.setEditable(false);
		txtRigPar.setHorizontalAlignment(SwingConstants.CENTER);
		txtRigPar.setText("3");
		txtRigPar.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		txtRigPar.setColumns(10);
		txtRigPar.setBounds(148, 107, 59, wndIntro.getAltezzaControlli());
		contentPane.add(txtRigPar);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 142, 495, 3);
		contentPane.add(separator_1);
		
		JLabel lblGolPortiere = new JLabel("Gol portiere:");
		lblGolPortiere.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		lblGolPortiere.setBounds(10, 151, 128, wndIntro.getAltezzaControlli());
		contentPane.add(lblGolPortiere);
		
		JLabel lblGolCentrocampista = new JLabel("Gol centrocampista:");
		lblGolCentrocampista.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		lblGolCentrocampista.setBounds(10, 179, 128, wndIntro.getAltezzaControlli());
		contentPane.add(lblGolCentrocampista);
		
		txtGolCen = new JTextField();
		txtGolCen.setEditable(false);
		txtGolCen.setHorizontalAlignment(SwingConstants.CENTER);
		txtGolCen.setText("3");
		txtGolCen.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		txtGolCen.setColumns(10);
		txtGolCen.setBounds(148, 179, 59, wndIntro.getAltezzaControlli());
		contentPane.add(txtGolCen);
		
		txtGolPor = new JTextField();
		txtGolPor.setEditable(false);
		txtGolPor.setHorizontalAlignment(SwingConstants.CENTER);
		txtGolPor.setText("3");
		txtGolPor.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		txtGolPor.setColumns(10);
		txtGolPor.setBounds(148, 151, 59, wndIntro.getAltezzaControlli());
		contentPane.add(txtGolPor);
		
		JLabel lblGolDifensore = new JLabel("Gol difensore:");
		lblGolDifensore.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		lblGolDifensore.setBounds(269, 152, 128, wndIntro.getAltezzaControlli());
		contentPane.add(lblGolDifensore);
		
		JLabel lblGolAttaccante = new JLabel("Gol attaccante:");
		lblGolAttaccante.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		lblGolAttaccante.setBounds(269, 179, 128, wndIntro.getAltezzaControlli());
		contentPane.add(lblGolAttaccante);
		
		txtGolAtt = new JTextField();
		txtGolAtt.setEditable(false);
		txtGolAtt.setHorizontalAlignment(SwingConstants.CENTER);
		txtGolAtt.setText("3");
		txtGolAtt.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		txtGolAtt.setColumns(10);
		txtGolAtt.setBounds(404, 179, 59, wndIntro.getAltezzaControlli());
		contentPane.add(txtGolAtt);
		
		txtGolDif = new JTextField();
		txtGolDif.setEditable(false);
		txtGolDif.setHorizontalAlignment(SwingConstants.CENTER);
		txtGolDif.setText("3");
		txtGolDif.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		txtGolDif.setColumns(10);
		txtGolDif.setBounds(404, 151, 59, wndIntro.getAltezzaControlli());
		contentPane.add(txtGolDif);
		
		JLabel lblGolSuRigore = new JLabel("Gol su rigore:");
		lblGolSuRigore.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		lblGolSuRigore.setBounds(10, 207, 128, wndIntro.getAltezzaControlli());
		contentPane.add(lblGolSuRigore);
		
		txtGolRig = new JTextField();
		txtGolRig.setEditable(false);
		txtGolRig.setEnabled(false);
		txtGolRig.setHorizontalAlignment(SwingConstants.CENTER);
		txtGolRig.setText("3");
		txtGolRig.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		txtGolRig.setColumns(10);
		txtGolRig.setBounds(148, 207, 59, wndIntro.getAltezzaControlli());
		contentPane.add(txtGolRig);
		
		JLabel label = new JLabel("Portiere imbattuto:");
		label.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		label.setBounds(269, 65, 128, wndIntro.getAltezzaControlli());
		contentPane.add(label);
		
		txtPortImb = new JTextField();
		txtPortImb.setEditable(false);
		txtPortImb.setHorizontalAlignment(SwingConstants.CENTER);
		txtPortImb.setText("0");
		txtPortImb.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		txtPortImb.setColumns(10);
		txtPortImb.setBounds(404, 65, 59, wndIntro.getAltezzaControlli());
		contentPane.add(txtPortImb);
		
		
		Button btnEspMinus = new Button("-");
		btnEspMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEsp.setText((Double.parseDouble(txtEsp.getText())-soglia+""));
			}
		});
		btnEspMinus.setBounds(465, 9, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnEspMinus);
		
		Button btnEspPlus = new Button("+");
		btnEspPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEsp.setText((Double.parseDouble(txtEsp.getText())+soglia+""));
			}
		});
		btnEspPlus.setBounds(485, 9, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnEspPlus);
		
		Button btnAmmMinus = new Button("-");
		btnAmmMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAmm.setText((Double.parseDouble(txtAmm.getText())-soglia+""));
			}
		});
		btnAmmMinus.setBounds(209, 9, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnAmmMinus);
		
		Button btnAmmPlus = new Button("+");
		btnAmmPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAmm.setText((Double.parseDouble(txtAmm.getText())+soglia+""));
			}
		});
		btnAmmPlus.setBounds(229, 9, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnAmmPlus);
		
		Button btnAssMinus = new Button("-");
		btnAssMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAss.setText((Double.parseDouble(txtAss.getText())-soglia+""));
			}
		});
		btnAssMinus.setBounds(209, 37, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnAssMinus);
		
		Button btnAssPlus = new Button("+");
		btnAssPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAss.setText((Double.parseDouble(txtAss.getText())+soglia+""));
			}
		});
		btnAssPlus.setBounds(229, 37, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnAssPlus);
		
		Button btnGolSubMinus = new Button("-");
		btnGolSubMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGolSub.setText((Double.parseDouble(txtGolSub.getText())-soglia+""));
			}
		});
		btnGolSubMinus.setBounds(209, 65, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnGolSubMinus);
		
		Button btnGolSubPlus = new Button("+");
		btnGolSubPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGolSub.setText((Double.parseDouble(txtGolSub.getText())+soglia+""));
			}
		});
		btnGolSubPlus.setBounds(229, 65, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnGolSubPlus);
		
		Button btnRigParMinus = new Button("-");
		btnRigParMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRigPar.setText((Double.parseDouble(txtRigPar.getText())-soglia+""));
			}
		});
		btnRigParMinus.setBounds(209, 107, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnRigParMinus);
		
		Button btnRigParPlus = new Button("+");
		btnRigParPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRigPar.setText((Double.parseDouble(txtRigPar.getText())+soglia+""));
			}
		});
		btnRigParPlus.setBounds(229, 107, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnRigParPlus);
		
		Button btnGolPorMinus = new Button("-");
		btnGolPorMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGolPor.setText((Double.parseDouble(txtGolPor.getText())-soglia+""));
			}
		});
		btnGolPorMinus.setBounds(209, 151, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnGolPorMinus);
		
		Button btnGolPorPlus = new Button("+");
		btnGolPorPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGolPor.setText((Double.parseDouble(txtGolPor.getText())+soglia+""));
			}
		});
		btnGolPorPlus.setBounds(229, 151, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnGolPorPlus);
		
		Button btnGolCenMinus = new Button("-");
		btnGolCenMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGolCen.setText((Double.parseDouble(txtGolCen.getText())-soglia+""));
			}
		});
		btnGolCenMinus.setBounds(209, 179, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnGolCenMinus);
		
		Button btnGolCenPlus = new Button("+");
		btnGolCenPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGolCen.setText((Double.parseDouble(txtGolCen.getText())+soglia+""));
			}
		});
		btnGolCenPlus.setBounds(229, 179, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnGolCenPlus);
		
		btnGolRigMinus = new Button("-");
		btnGolRigMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGolRig.setText((Double.parseDouble(txtGolRig.getText())-soglia+""));
			}
		});
		btnGolRigMinus.setEnabled(false);
		btnGolRigMinus.setBounds(209, 207, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnGolRigMinus);
		
		btnGolRigPlus = new Button("+");
		btnGolRigPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGolRig.setText((Double.parseDouble(txtGolRig.getText())+soglia+""));
			}
		});
		btnGolRigPlus.setEnabled(false);
		btnGolRigPlus.setBounds(229, 207, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnGolRigPlus);
		
		Button btnAutoMinus = new Button("-");
		btnAutoMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAuto.setText((Double.parseDouble(txtAuto.getText())-soglia+""));
			}
		});
		btnAutoMinus.setBounds(465, 37, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnAutoMinus);
		
		Button btnAutoPlus = new Button("+");
		btnAutoPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAuto.setText((Double.parseDouble(txtAuto.getText())+soglia+""));
			}
		});
		btnAutoPlus.setBounds(485, 37, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnAutoPlus);
		
		Button btnPortImbMinus = new Button("-");
		btnPortImbMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPortImb.setText((Double.parseDouble(txtPortImb.getText())-soglia+""));
			}
		});
		btnPortImbMinus.setBounds(465, 65, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnPortImbMinus);
		
		Button btnPortImbPlus = new Button("+");
		btnPortImbPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPortImb.setText((Double.parseDouble(txtPortImb.getText())+soglia+""));
			}
		});
		btnPortImbPlus.setBounds(485, 65, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnPortImbPlus);
		
		Button btnRigSbaMinus = new Button("-");
		btnRigSbaMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRigSba.setText((Double.parseDouble(txtRigSba.getText())-soglia+""));
			}
		});
		btnRigSbaMinus.setBounds(465, 107, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnRigSbaMinus);
		
		Button btnRigSbaPlus = new Button("+");
		btnRigSbaPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRigSba.setText((Double.parseDouble(txtRigSba.getText())+soglia+""));
			}
		});
		btnRigSbaPlus.setBounds(485, 107, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnRigSbaPlus);
		
		Button btnGolDifMinus = new Button("-");
		btnGolDifMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGolDif.setText((Double.parseDouble(txtGolDif.getText())-soglia+""));
			}
		});
		btnGolDifMinus.setBounds(465, 151, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnGolDifMinus);
		
		Button btnGolDifPlus = new Button("+");
		btnGolDifPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGolDif.setText((Double.parseDouble(txtGolDif.getText())+soglia+""));	
			}
		});
		btnGolDifPlus.setBounds(485, 151, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnGolDifPlus);
		
		Button btnGolAttMinus = new Button("-");
		btnGolAttMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGolAtt.setText((Double.parseDouble(txtGolAtt.getText())-soglia+""));
			}
		});
		btnGolAttMinus.setBounds(465, 179, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnGolAttMinus);
		
		Button btnGolAttPlus = new Button("+");
		btnGolAttPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGolAtt.setText((Double.parseDouble(txtGolAtt.getText())+soglia+""));
			}
		});
		btnGolAttPlus.setBounds(485, 179, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnGolAttPlus);
		
		chkGolRigGolNor = new JCheckBox("Considera Gol rigore come Gol normale");
		chkGolRigGolNor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkGolRigGolNor.isSelected()){
					txtGolRig.setEnabled(false);
					btnGolRigMinus.setEnabled(false);
					btnGolRigPlus.setEnabled(false);
					
				}else{
					txtGolRig.setEnabled(true);
					btnGolRigMinus.setEnabled(true);
					btnGolRigPlus.setEnabled(true);
				}
			}
		});
		chkGolRigGolNor.setSelected(true);
		chkGolRigGolNor.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		chkGolRigGolNor.setBounds(10, 235, 471, wndIntro.getAltezzaControlli());
		contentPane.add(chkGolRigGolNor);
		
		JButton btnMemorizza = new JButton("OK");
		btnMemorizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Preferences prefs = Preferences.userNodeForPackage(wndBonus.class);
			
			prefs.put("Amm", getTxtAmm().getText());
			prefs.put("Esp", getTxtEsp().getText());
			prefs.put("Ass", getTxtAss().getText());
			prefs.put("Auto", getTxtAuto().getText()); 
			prefs.put("GolSub", getTxtGolSub().getText());
			prefs.put("PortImb", getTxtPortImb().getText());
			prefs.put("RigPar", getTxtRigPar().getText());
			prefs.put("RigSba", getTxtRigSba().getText());
			prefs.put("GolPor", getTxtGolPor().getText());
			prefs.put("GolDif", getTxtGolDif().getText());
			prefs.put("GolCen", getTxtGolCen().getText());
			prefs.put("GolAtt", getTxtGolAtt().getText());
			prefs.put("GolRig", getTxtGolRig().getText());
			prefs.put("AutPor", getTxtAutPor().getText());
			prefs.put("GolVit", getTxtGolVittoria().getText());
			prefs.put("Golpar", getTxtGolPar().getText());
			prefs.putBoolean("CheckRig", getChkGolRigGolNor().isSelected());
			wndIntro.frmBonus.setVisible(false);
			}
		});
		btnMemorizza.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		btnMemorizza.setBounds(365, 332, 140, wndIntro.getAltezzaControlli());
		contentPane.add(btnMemorizza);
		
		JButton btnPredefinite = new JButton("Predefinite");
		btnPredefinite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtAmm.setText("-0.5");
				txtEsp.setText("-1");
				txtAss.setText("+1");
				txtAuto.setText("-2");
				txtGolAtt.setText("+3");
				txtGolCen.setText("+3");
				txtGolDif.setText("+3");
				txtGolPor.setText("+3");
				txtGolRig.setText("+3");
				txtGolSub.setText("-1");
				txtPortImb.setText("+0");
				txtAutPor.setText("-2");
				txtRigPar.setText("+3");
				txtRigSba.setText("-3");
				txtGolVittoria.setText("0");
				txtGolPar.setText("0");
				chkGolRigGolNor.setSelected(true);
				txtGolRig.setEnabled(false);
				btnGolRigMinus.setEnabled(false);
				btnGolRigPlus.setEnabled(false);
			}
		});
		btnPredefinite.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()));
		btnPredefinite.setBounds(10, 332, 140, wndIntro.getAltezzaControlli());
		contentPane.add(btnPredefinite);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 270, 495, 3);
		contentPane.add(separator_2);
		
		JLabel lblGolVittoria = new JLabel("Gol vittoria:");
		lblGolVittoria.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		lblGolVittoria.setBounds(10, 279, 128, 28);
		contentPane.add(lblGolVittoria);
		
		txtGolVittoria = new JTextField();
		txtGolVittoria.setText("0");
		txtGolVittoria.setHorizontalAlignment(SwingConstants.CENTER);
		txtGolVittoria.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		txtGolVittoria.setEditable(false);
		txtGolVittoria.setColumns(10);
		txtGolVittoria.setBounds(148, 279, 59, wndIntro.getAltezzaControlli());
		contentPane.add(txtGolVittoria);
		
		Button btnGolVitMinus = new Button("-");
		btnGolVitMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGolVittoria.setText((Double.parseDouble(txtGolVittoria.getText())-soglia+""));
			}
		});
		btnGolVitMinus.setBounds(209, 279, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnGolVitMinus);
		
		Button btnGolVitPlus = new Button("+");
		btnGolVitPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGolVittoria.setText((Double.parseDouble(txtGolVittoria.getText())+soglia+""));
			}
		});
		btnGolVitPlus.setBounds(229, 279, 20, 28);
		contentPane.add(btnGolVitPlus);
		
		JLabel lblGolPareggio = new JLabel("Gol pareggio");
		lblGolPareggio.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		lblGolPareggio.setBounds(269, 279, 128, wndIntro.getAltezzaControlli());
		contentPane.add(lblGolPareggio);
		
		txtGolPar = new JTextField();
		txtGolPar.setText("0");
		txtGolPar.setHorizontalAlignment(SwingConstants.CENTER);
		txtGolPar.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		txtGolPar.setEditable(false);
		txtGolPar.setColumns(10);
		txtGolPar.setBounds(404, 279, 59, wndIntro.getAltezzaControlli());
		contentPane.add(txtGolPar);
		
		Button btnGolParMinus = new Button("-");
		btnGolParMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGolPar.setText((Double.parseDouble(txtGolPar.getText())-soglia+""));
			}
		});
		btnGolParMinus.setBounds(465, 279, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnGolParMinus);
		
		Button btnGolParPlus = new Button("+");
		btnGolParPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGolPar.setText((Double.parseDouble(txtGolPar.getText())+soglia+""));
			}
		});
		btnGolParPlus.setBounds(485, 279, 20, wndIntro.getAltezzaControlli());
		contentPane.add(btnGolParPlus);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 318, 495, 3);
		contentPane.add(separator_3);
		
		JLabel lblAutogolPortiere = new JLabel("Autogol Portiere:");
		lblAutogolPortiere.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		lblAutogolPortiere.setBounds(266, 207, 128, 28);
		contentPane.add(lblAutogolPortiere);
		
		txtAutPor = new JTextField();
		txtAutPor.setEditable(false);
		txtAutPor.setText("-2");
		txtAutPor.setHorizontalAlignment(SwingConstants.CENTER);
		txtAutPor.setFont(new Font(wndIntro.getCarattere(), Font.PLAIN, wndIntro.getDimensioniCarattere()+2));
		txtAutPor.setColumns(10);
		txtAutPor.setBounds(404, 207, 59, 28);
		contentPane.add(txtAutPor);
		
		Button btnAutPorMinus = new Button("-");
		btnAutPorMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtAutPor.setText((Double.parseDouble(txtAutPor.getText())-soglia+""));
			}
		});
		btnAutPorMinus.setBounds(465, 207, 20, 28);
		contentPane.add(btnAutPorMinus);
		
		Button btnAutPorPlus = new Button("+");
		btnAutPorPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAutPor.setText((Double.parseDouble(txtAutPor.getText())+soglia+""));
			}
		});
		btnAutPorPlus.setBounds(485, 207, 20, 28);
		contentPane.add(btnAutPorPlus);
	}
}
