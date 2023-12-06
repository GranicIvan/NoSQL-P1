package v1;

import java.io.File;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Glavni {

	
	public static void main(String[] args) {
		ArrayList<FilmSerija> filmoviSerije = IO.citanjeCSV("netflix_titles.csv");
		
//		System.out.println(filmoviSerije);
//		for(FilmSerija fs : filmoviSerije) {
//			System.out.println(fs);
//		}
		
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(new File("NetflixFilmovi.json"), filmoviSerije);
			System.out.println("Napravili smo JSON");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
