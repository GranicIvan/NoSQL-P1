package v1;

import java.util.ArrayList;

public class FilmSerija {

	private String id;
	private String tip;
	private String ime;
	private ArrayList<String> reziser;
	private ArrayList<String> cast;
	private ArrayList<String> drzava;
	private String datum_dodavanja;
	private int godina_izlazka;
	private String trajanje;
	private ArrayList<String> listed_in; //TODO Prevedi nekao
	private String opis;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTip() {
		return tip;
	}
	
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public String getIme() {
		return ime;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public ArrayList<String> getReziser() {
		return reziser;
	}
	
	public void setReziser(ArrayList<String> reziser) {
		this.reziser = reziser;
	}
	
	public ArrayList<String> getCast() {
		return cast;
	}
	
	public void setCast(ArrayList<String> cast) {
		this.cast = cast;
	}
	
	public ArrayList<String> getDrzava() {
		return drzava;
	}
	
	public void setDrzava(ArrayList<String> drzava) {
		this.drzava = drzava;
	}
	
	public String getDatum_dodavanja() {
		return datum_dodavanja;
	}
	
	public void setDatum_dodavanja(String datum_dodavanja) {
		this.datum_dodavanja = datum_dodavanja;
	}
	
	public int getGodina_izlazka() {
		return godina_izlazka;
	}
	
	public void setGodina_izlazka(int godina_izlazka) {
		this.godina_izlazka = godina_izlazka;
	}
	
	public String getTrajanje() {
		return trajanje;
	}
	
	public void setTrajanje(String trajanje) {
		this.trajanje = trajanje;
	}
	
	public ArrayList<String> getListed_in() {
		return listed_in;
	}
	
	public void setListed_in(ArrayList<String> listed_in) {
		this.listed_in = listed_in;
	}
	
	public String getOpis() {
		return opis;
	}
	
	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	

	
	
	
	
	
}
