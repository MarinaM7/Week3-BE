package esercizio1;

import java.time.LocalDate;

import entities.TipoEvento;

public class Main {
	
	public static void main(String[] args) {

		EventoDao e = new EventoDao();
		
//		e.insertEvento("Evento di beneficenza", LocalDate.ofYearDay(2020, 20), "descrizione evento beneficenza", TipoEvento.PUBBLICO, 100);
//		e.insertEvento("Evento sportivo", LocalDate.ofYearDay(2019, 12), "descrizione evento sportivo", TipoEvento.PUBBLICO, 300);
//		e.insertEvento("Evento festa", LocalDate.ofYearDay(2023, 20), "descrizione festa privata", TipoEvento.PRIVATO, 30);
//		e.insertEvento("Evento culturale", LocalDate.ofYearDay(2009, 9), "descrizione evento culturale", TipoEvento.PRIVATO, 50);
		
		e.getEventoById(4);
//		e.deleteEventoById(1);

		
		e.closeEm();

	}

}
