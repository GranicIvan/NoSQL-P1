package v1;

import java.util.ArrayList;

public class Glavni {

	
	public static void main(String[] args) {
		ArrayList<FilmSerija> filmoviSerije = IO.citanjeCSV("netflix_titles.csv");
		
//		System.out.println(filmoviSerije);
		for(FilmSerija fs : filmoviSerije) {
			System.out.println(fs);
		}
	}
	
	
}
