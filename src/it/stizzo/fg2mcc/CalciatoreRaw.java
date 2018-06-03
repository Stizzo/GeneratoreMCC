package it.stizzo.fg2mcc;

public class CalciatoreRaw {
	private int id;
	private String ruolo;
	private String cognome;
	private String voto;
	private int golSeg;
	private int golSub;
	private int rigPar;
	private int rigSba;
	private int rigSeg;
	private int autogol;
	private int amm;
	private int esp;
	private int assist;
	private int assistFermo;
	private int golVit;
	private int golPar;
	
	public CalciatoreRaw(int id, String ruolo, String cognome, String voto,
			int golSeg, int golSub, int rigPar, int rigSba, int rigSeg,
			int autogol, int amm, int esp, int assist, int assistFermo,
			int golVit, int golPar) {
		this.id = id;
		this.ruolo = ruolo;
		this.cognome = cognome;
		this.voto = voto;
		this.golSeg = golSeg;
		this.golSub = golSub;
		this.rigPar = rigPar;
		this.rigSba = rigSba;
		this.rigSeg = rigSeg;
		this.autogol = autogol;
		this.amm = amm;
		this.esp = esp;
		this.assist = assist;
		this.assistFermo = assistFermo;
		this.golVit = golVit;
		this.golPar = golPar;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getVoto() {
		return voto;
	}
	public void setVoto(String voto) {
		this.voto = voto;
	}
	public int getGolSeg() {
		return golSeg;
	}
	public void setGolSeg(int golSeg) {
		this.golSeg = golSeg;
	}
	public int getGolSub() {
		return golSub;
	}
	public void setGolSub(int golSub) {
		this.golSub = golSub;
	}
	public int getRigPar() {
		return rigPar;
	}
	public void setRigPar(int rigPar) {
		this.rigPar = rigPar;
	}
	public int getRigSba() {
		return rigSba;
	}
	public void setRigSba(int rigSba) {
		this.rigSba = rigSba;
	}
	public int getRigSeg() {
		return rigSeg;
	}
	public void setRigSeg(int rigSeg) {
		this.rigSeg = rigSeg;
	}
	public int getAutogol() {
		return autogol;
	}
	public void setAutogol(int autogol) {
		this.autogol = autogol;
	}
	public int getAmm() {
		return amm;
	}
	public void setAmm(int amm) {
		this.amm = amm;
	}
	public int getEsp() {
		return esp;
	}
	public void setEsp(int esp) {
		this.esp = esp;
	}
	public int getAssist() {
		return assist;
	}
	public void setAssist(int assist) {
		this.assist = assist;
	}
	public int getAssistFermo() {
		return assistFermo;
	}
	public void setAssistFermo(int assistFermo) {
		this.assistFermo = assistFermo;
	}
	public int getGolVit() {
		return golVit;
	}
	public void setGolVit(int golVit) {
		this.golVit = golVit;
	}
	public int getGolPar() {
		return golPar;
	}
	public void setGolPar(int golPar) {
		this.golPar = golPar;
	}
	
	
	public double getVotoNum(){
		double valore;
		try{
		valore = Double.parseDouble(getVoto());
		}catch (java.lang.NumberFormatException e){
			valore = 0;
		}		
		return valore;
	}
	
	public double getFantaVoto(){
		double ammonizione = Double.parseDouble(wndBonus.getTxtAmm().getText());
		double espulsione = Double.parseDouble(wndBonus.getTxtEsp().getText());
		double gol_rigore = Double.parseDouble(wndBonus.getTxtGolRig().getText());
		double golsubito = Double.parseDouble(wndBonus.getTxtGolSub().getText());
		double assist = Double.parseDouble(wndBonus.getTxtAss().getText());
		double autogol = Double.parseDouble(wndBonus.getTxtAuto().getText());
		double rigoresbagliato = Double.parseDouble(wndBonus.getTxtRigSba().getText());
		double rigoreparato = Double.parseDouble(wndBonus.getTxtRigPar().getText());
		double gol_portiere = Double.parseDouble(wndBonus.getTxtGolPor().getText());
		double gol_difensore = Double.parseDouble(wndBonus.getTxtGolDif().getText());
		double gol_centrocampista = Double.parseDouble(wndBonus.getTxtGolCen().getText());
		double gol_attaccante = Double.parseDouble(wndBonus.getTxtGolAtt().getText());
		double portiere_imbattuto = Double.parseDouble(wndBonus.getTxtPortImb().getText());
		double autogol_portiere = Double.parseDouble(wndBonus.getTxtAutPor().getText());
		boolean goal_come_rigori = wndBonus.getChkGolRigGolNor().isSelected();
		double gol_pareggio = Double.parseDouble(wndBonus.getTxtGolPar().getText());
		double gol_vittoria = Double.parseDouble(wndBonus.getTxtGolVittoria().getText());
		
		double totbonus = 0;
		double voto = getVotoNum();
		
			if (getVoto().equals("6*") || getVoto().equals("s,v,")){
			if (getRuolo() == "P" && getEsp()==0){
				voto = 6;
			} else if (getEsp()>=1){
				voto = 5;
			} else if (getAssist() >=1 || getAssistFermo() >=1 || getAutogol() >=1 || getGolSeg() >=1 || getGolSub() >=1 || getRigPar() >=1 || getRigSba() >=1 || getRigSeg() >=1){
				voto = 6;
			}
			else {return 0;}
		}
		
		
		totbonus = 
				(getAmm()*ammonizione)+
				(getAssist()*assist)+
				(getAssistFermo()*assist)+
				(getAutogol()*autogol)+
				(getEsp()*espulsione)+
				//(getGolSeg()*gol)+
				(getGolSub()*golsubito)+
				(getRigPar()*rigoreparato)+
				(getRigSba()*rigoresbagliato)+
				//(getRigSeg()*gol)
				(getGolPar()*gol_pareggio)+
				(getGolVit()*gol_vittoria)
				;
		
		int totGoal;
		if (goal_come_rigori){
			totGoal = getGolSeg() + getRigSeg();
		}else{
			totGoal = getGolSeg();
			totbonus = totbonus + getRigSeg()*gol_rigore;
		}
		if (totGoal > 0){
			if (getRuolo().equals("P")){
				totbonus = totbonus + (gol_portiere*totGoal);
			}
			if (getRuolo().equals("D")){
				totbonus = totbonus + (gol_difensore*totGoal);
			}
			if (getRuolo().equals("C")){
				totbonus = totbonus + (gol_centrocampista*totGoal);
			}
			if (getRuolo().equals("A")){
				totbonus = totbonus + (gol_attaccante*totGoal);
			}
		}
		if (getRuolo().equals("P") && getVotoNum()!=0 && getGolSub()==0){
			totbonus = totbonus + portiere_imbattuto;
		}
		//Gestisco l'autogol del portiere: aggiungo il malus per il portiere e tolgo quello generico
		if (getRuolo().equals("P") && getAutogol()>0){
			totbonus = totbonus + autogol_portiere - autogol;
		}
		return voto+totbonus;
	}
}