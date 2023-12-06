package v1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class IO {

	static int index;
	
	
	public static ArrayList<FilmSerija> citanjeCSV(String link) {
		int red = 0;
		ArrayList<FilmSerija> fsl = new ArrayList();
		try(BufferedReader br = new BufferedReader(new FileReader(link));) {
			
			String s;
			do {
				s = br.readLine();
	
				red++;

				String token[] = s.trim().split(",");

				FilmSerija fs = new FilmSerija();

				ArrayList<String> lista = null;

				index = 0;
				fs.setId(token[index]);// id
				index++;
				fs.setTip(token[index]);// tip
				index++;

				// ime
				if (token[index].charAt(0) == '"') {
					// imamo niz
					lista = listaKadTreba(token);
					fs.setIme(lista.toString());
					index++;
				} else {
					fs.setIme(token[index]);
					index++;
				}

				
				
				// reziser
				try {
					if (token[index].charAt(0) == '"') {
					// imamo niz
					lista = listaKadTreba(token);
					fs.setReziser((lista));
					index++;
				} else {
					ArrayList<String> pom = new ArrayList<String>();
					pom.add(token[index]);
					fs.setReziser(pom);
					index++;
				}
				} catch (StringIndexOutOfBoundsException e) {
					fs.setReziser(null);
					index++;
					
				}
				

				// Cast
				try {
					if (token[index].charAt(0) == '"') {// OVDE PUCA KAD JE POLJE PRAZNO
						// imamo niz
						lista = listaKadTreba(token);
						fs.setCast(lista);
						index++;
					} else {
						ArrayList<String> pom = new ArrayList<String>();
						pom.add(token[index]);
						fs.setCast(pom);

						index++;
					}
				} catch (StringIndexOutOfBoundsException e) {
					fs.setCast(null);
					index++;
					
				}
				
				// drzava
				try {
					
					if (token[index].charAt(0) == '"') {
						// imamo niz
						lista = listaKadTreba(token);
						fs.setDrzava(lista.stream().collect(Collectors.toMap(String::hashCode, e -> e)));
						index++;
					} else {
						ArrayList<String> pom = new ArrayList<String>();
						pom.add(token[index]);
						fs.setDrzava(pom.stream().collect(Collectors.toMap(String::hashCode, e -> e)));

						index++;
					}
				} catch (StringIndexOutOfBoundsException e) {
					fs.setDrzava(null);
					index++;

				}
				
				
				fs.setDatum_dodavanja(token[index]);// datum
				index++;
				
				try {//Godina izlaska
					fs.setGodina_izlazka( Integer.parseInt( token[index].trim().substring(0, 4)) );//Godina izlaska
				} catch (NumberFormatException e) {
					//e.printStackTrace();
					fs.setGodina_izlazka(-1);
					index++;
					
				}finally {
					index++;
				}
				
				//ogranicenje
				fs.setOgranicenje(token[index]);
				index++;
				
				// trajanje 
				fs.setTrajanje(token[index]);
				index++;
				
				
				//Listed in
				try {
					if (token[index].charAt(0) == '"') {// OVDE PUCA KAD JE POLJE PRAZNO
						// imamo niz
						lista = listaKadTreba(token);
						fs.setListed_in(lista);
						index++;
					} else {
						ArrayList<String> pom = new ArrayList<String>();
						pom.add(token[index]);
						fs.setListed_in(pom);
						index++;
					}
				} catch (Exception e) {
					fs.setListed_in(null);
					index++;
				
				}
								
				
				//Opis
				try {
					
						// imamo niz
						lista = listaKadTreba(token);
						fs.setOpis(lista.toString());
						index++;
					
				} catch (Exception e) {
					fs.setOpis(null);
					index++;
					
				}				
				

				fsl.add(fs);
				

			} while (s != null);

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Greska pri citanju iz fajla");
		} catch (NullPointerException np) {
			System.err.println("ZAVRSILI SMO CIRANJE SVIH REDOVA");
			//np.printStackTrace();	
		} finally {
			
			System.out.println("procitali smo: " + red + " redova ");
			
		}

		return fsl;
	}

	public static ArrayList<String> listaKadTreba(String[] tokeni) {

		ArrayList<String> novaLista = new ArrayList<String>();

		// Ubacimo prvi token bez "
		novaLista.add(tokeni[index].substring(1).trim());
		index++;

		while (tokeni[index].charAt(tokeni[index].length()-1) != '"') {
			novaLista.add(tokeni[index].trim());
			index++;
		}
		novaLista.add(tokeni[index].substring(0, tokeni[index].length() - 1).trim());
		//index++;
		return novaLista;

	}
}
