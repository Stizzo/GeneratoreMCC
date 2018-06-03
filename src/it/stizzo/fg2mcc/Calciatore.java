package it.stizzo.fg2mcc;

public class Calciatore {
private int id;
private int giornata;
private String cognome;
private String squadra;
private int trasferito;
private int ruolo; 
private int presenza;
private double fantavoto;
private int minutiInf, minutiSup;
private double voto;
private int golSeg, golSub, golVit, golPar, assist, amm, esp, rigTir, rigSub, rigPar, rigSba, autogol, entrato, titolare, senzavt, incasa, valore;
public Calciatore(int id, int giornata, String cognome, String squadra,
		int trasferito, int ruolo, int presenza, double fantavoto,
		int minutiInf, int minutiSup, double voto, int golSeg, int golSub,
		int golVit, int golPar, int assist, int amm, int esp, int rigTir,
		int rigSub, int rigPar, int rigSba, int autogol, int entrato,
		int titolare, int senzavt, int incasa, int valore) {
	
	this.id = id;
	this.giornata = giornata;
	this.cognome = cognome;
	this.squadra = squadra;
	this.trasferito = trasferito;
	this.ruolo = ruolo;
	this.presenza = presenza;
	this.fantavoto = fantavoto;
	this.minutiInf = minutiInf;
	this.minutiSup = minutiSup;
	this.voto = voto;
	this.golSeg = golSeg;
	this.golSub = golSub;
	this.golVit = golVit;
	this.golPar = golPar;
	this.assist = assist;
	this.amm = amm;
	this.esp = esp;
	this.rigTir = rigTir;
	this.rigSub = rigSub;
	this.rigPar = rigPar;
	this.rigSba = rigSba;
	this.autogol = autogol;
	this.entrato = entrato;
	this.titolare = titolare;
	this.senzavt = senzavt;
	this.incasa = incasa;
	this.valore = valore;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getGiornata() {
	return giornata;
}
public void setGiornata(int giornata) {
	this.giornata = giornata;
}
public String getCognome() {
	return cognome;
}
public void setCognome(String cognome) {
	this.cognome = cognome;
}
public String getSquadra() {
	return squadra;
}
public void setSquadra(String squadra) {
	this.squadra = squadra;
}
public int getTrasferito() {
	return trasferito;
}
public void setTrasferito(int trasferito) {
	this.trasferito = trasferito;
}
public int getRuolo() {
	return ruolo;
}
public void setRuolo(int ruolo) {
	this.ruolo = ruolo;
}
public int getPresenza() {
	return presenza;
}
public void setPresenza(int presenza) {
	this.presenza = presenza;
}
public double getFantavoto() {
	return fantavoto;
}
public void setFantavoto(double fantavoto) {
	this.fantavoto = fantavoto;
}
public int getMinutiInf() {
	return minutiInf;
}
public void setMinutiInf(int minutiInf) {
	this.minutiInf = minutiInf;
}
public int getMinutiSup() {
	return minutiSup;
}
public void setMinutiSup(int minutiSup) {
	this.minutiSup = minutiSup;
}
public double getVoto() {
	return voto;
}
public void setVoto(double voto) {
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
public int getAssist() {
	return assist;
}
public void setAssist(int assist) {
	this.assist = assist;
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
public int getRigTir() {
	return rigTir;
}
public void setRigTir(int rigTir) {
	this.rigTir = rigTir;
}
public int getRigSub() {
	return rigSub;
}
public void setRigSub(int rigSub) {
	this.rigSub = rigSub;
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
public int getAutogol() {
	return autogol;
}
public void setAutogol(int autogol) {
	this.autogol = autogol;
}
public int getEntrato() {
	return entrato;
}
public void setEntrato(int entrato) {
	this.entrato = entrato;
}
public int getTitolare() {
	return titolare;
}
public void setTitolare(int titolare) {
	this.titolare = titolare;
}
public int getSenzavt() {
	return senzavt;
}
public void setSenzavt(int senzavt) {
	this.senzavt = senzavt;
}
public int getIncasa() {
	return incasa;
}
public void setIncasa(int incasa) {
	this.incasa = incasa;
}
public int getValore() {
	return valore;
}
public void setValore(int valore) {
	this.valore = valore;
}


}
