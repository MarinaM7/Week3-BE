package esercizio1;

import java.time.LocalDate;

import entities.Genere;
import entities.TipoEvento;

public class Main {
	
	public static void main(String[] args) {

		EventoDao e = new EventoDao();
	
		//e.insertConcerto();
		
		//e.getConcertoStreaming();
		
		//e.getConcertoPerGenere(Genere.POP);
		
		//e.insertPartiteCalcio();
		
		e.getPartiteVinteinCasa();
		
		e.closeEm();

	}

}
