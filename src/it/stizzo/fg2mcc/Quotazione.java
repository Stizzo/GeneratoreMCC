package it.stizzo.fg2mcc;

public class Quotazione {
	private int id;
	private String ruolo;
	private String cognome;
	private String squadra;
	private double costo;
	private double costoIniziale;
	private double differenza;
	public Quotazione(int id, String ruolo, String cognome, String squadra,
			double costo, double costoIniziale, double differenza) {
	
		this.id = id;
		this.ruolo = ruolo;
		this.cognome = cognome;
		this.squadra = squadra;
		this.costo = costo;
		this.costoIniziale = costoIniziale;
		this.differenza = differenza;
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
	public String getSquadra() {
		return squadra;
	}
	public void setSquadra(String squadra) {
		this.squadra = squadra;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public double getCostoIniziale() {
		return costoIniziale;
	}
	public void setCostoIniziale(double costoIniziale) {
		this.costoIniziale = costoIniziale;
	}
	public double getDifferenza() {
		return differenza;
	}
	public void setDifferenza(double differenza) {
		this.differenza = differenza;
	}
	

}
