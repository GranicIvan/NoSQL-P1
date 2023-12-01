package v1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class IO {

	public static ArrayList<FilmSerija> citanjeCSV(String link) {
		int red = 0;
		ArrayList<FilmSerija> fsl = new ArrayList();
		try {
			BufferedReader br = new BufferedReader(new FileReader(link));
			String s;
			do {
				s = br.readLine();
				System.out.println("imamo s");
				System.out.println(s);
				red++;

				String token[] = s.trim().split(",");

				FilmSerija fs = new FilmSerija();

				ArrayList<String> lista = null;

				Integer index = 0;
				fs.setId(token[index]);// id
				index++;
				fs.setTip(token[index]);// tip
				index++;

				// ime
				if (token[index].charAt(0) == '"') {
					// imamo niz
					lista = listaKadTreba(token, index);
					fs.setIme(lista.toString());
					index++;
				} else {
					fs.setIme(token[index]);
					index++;
				}

				// reziser
				if (token[index].charAt(0) == '"') {
					// imamo niz
					lista = listaKadTreba(token, index);
					fs.setReziser((lista));
					index++;
				} else {
					ArrayList<String> pom = new ArrayList();
					pom.add(token[index]);
					fs.setReziser(pom);
					index++;
				}

				// Cast
				try {
					if (token[index].charAt(0) == '"') {// OVDE PUCA KAD JE POLJE PRAZNO
						// imamo niz
						lista = listaKadTreba(token, index);
						fs.setCast(lista);
						index++;
					} else {
						ArrayList<String> pom = new ArrayList();
						pom.add(token[index]);
						fs.setCast(pom);

						index++;
					}
				} catch (StringIndexOutOfBoundsException e) {
					fs.setCast(null);
				}

				// drzava
				if (token[index].charAt(0) == '"') {
					// imamo niz
					lista = listaKadTreba(token, index);
					fs.setDrzava(lista);
					index++;
				} else {
					ArrayList<String> pom = new ArrayList();
					pom.add(token[index]);
					fs.setDrzava(pom);

					index++;
				}

				fsl.add(fs);
				// -----
				System.out.println("################################################################");
				for (String str : token) {
					System.out.println(str);
				}
				System.out.println("################################################################");

			} while (s != null);

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Greska pri citanju iz fajla");
		} catch (NullPointerException np) {
			System.err.println("ZAVRSILI SMO CIRANJE SVIH REDOVA");
			np.printStackTrace();
		} finally {
			System.out.println("procitali smo: " + red + " redova ");
		}

		return fsl;
	}

	public static ArrayList<String> listaKadTreba(String[] tokeni, Integer index) {

		ArrayList<String> novaLista = new ArrayList();

		// Ubacimo prvi token bez "
		novaLista.add(tokeni[index].substring(1).trim());
		index++;

		while (tokeni[index].charAt(tokeni[index].length()) != '"') {
			novaLista.add(tokeni[index].trim());
			index++;
		}
		novaLista.add(tokeni[index].substring(0, tokeni[index].length() - 1).trim());
		index++;
		return novaLista;

	}
}
