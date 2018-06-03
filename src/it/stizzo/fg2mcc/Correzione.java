package it.stizzo.fg2mcc;

public class Correzione {
private String CodiceRedazione;
private String CodiceMCC;
public Correzione(String idRedazione, String idMCC) {

	CodiceMCC = idMCC; //id corretto
	CodiceRedazione = idRedazione; //id sbagliato presente nelle quotazioni/voti
}
public String getCodiceMCC() {
	return CodiceMCC;
}
public void setCodiceMCC(String calciatoreMCC) {
	CodiceMCC = calciatoreMCC;
}
public String getCodiceRedazione() {
	return CodiceRedazione;
}
public void setCodiceRedazione(String calciatoreQuot) {
	CodiceRedazione = calciatoreQuot;
}

}
