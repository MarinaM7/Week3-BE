package esercizio1;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Concerto;
import entities.Evento;
import entities.Genere;
import entities.PartitaCalcio;
import entities.TipoEvento;

public class EventoDao {
	
	private static final String persistenceUnit = "Giorno4";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();

	public void insertConcerto() {
		
		try {
			
			Concerto c1 = new Concerto("Concerto", LocalDate.ofYearDay(2002, 12), "Dua Lipa", TipoEvento.PUBBLICO, 1000, Genere.POP, false);
			Concerto c2 = new Concerto("Concerto", LocalDate.ofYearDay(2020, 17), "Chopin", TipoEvento.PRIVATO, 45, Genere.CLASSICO, true);
			Concerto c3 = new Concerto("Concerto", LocalDate.ofYearDay(2010, 8), "CageTheElephant", TipoEvento.PUBBLICO, 3000, Genere.ROCK, false);
			
			t.begin();
			em.persist(c1);
			em.persist(c2);
			em.persist(c3);
			t.commit();
			
			System.out.println("Evento inserito correttamente!");
		}
		catch(Exception e) {
			System.out.println("Errore nell'inserimento dell'evento");
		}
		
	}

	public void getConcertoStreaming() {
		Query q = em.createQuery("SELECT c FROM Concerto c WHERE streaming = false");
		List<Concerto> resf = q.getResultList();
		
		System.out.println("Concerti dal vivo");
		for(Concerto c: resf) {
			System.out.println(c + " | Descrizione: " + c.getDescrizione() + " | Data: " + c.getDate() + " | Tipo: " + c.getTipoEvento());
		}
		
		
		Query q2 = em.createQuery("SELECT c FROM Concerto c WHERE streaming = true");
		List<Concerto> rest = q2.getResultList();
		
		System.out.println("Concerti streaming");
		for(Concerto c: rest) {
			System.out.println(c + " | Descrizione: " + c.getDescrizione() + " | Data: " + c.getDate() + " | Tipo: " + c.getTipoEvento());
		}
		
	}
	
	public void getConcertoPerGenere(Genere genere) {
		Query q = em.createQuery("SELECT c FROM Concerto c WHERE genere = :n");
		q.setParameter("n", genere);
		List<Concerto> result = q.getResultList();
		
		System.out.println("Concerti per genere: " + genere.toString());
		for(Concerto c: result) {
			System.out.println(c + " | Descrizione: " + c.getDescrizione() + " | Data: " + c.getDate() + " | Tipo: " + c.getTipoEvento());
		}
		
	}
	
	public void insertPartiteCalcio() {
		
		try {
			
			PartitaCalcio p1 = new PartitaCalcio("Partita", LocalDate.ofYearDay(2022, 10), "Amichevole", TipoEvento.PUBBLICO, 11, "Casax", "Agpxs", "Casax", 3, 1);
			PartitaCalcio p2 = new PartitaCalcio("Partita", LocalDate.ofYearDay(2018, 27), "Torneo", TipoEvento.PRIVATO, 40, "Hosk", "Extrt", "Extrt", 2, 4 );
			PartitaCalcio p3 = new PartitaCalcio("Partita", LocalDate.ofYearDay(2017, 18), "Decisiva", TipoEvento.PUBBLICO, 25, "Rpz", "Fcx", "Fcx", 0, 1 );
			
			t.begin();
			em.persist(p1);
			em.persist(p2);
			em.persist(p3);
			t.commit();
			
			System.out.println("Evento inserito correttamente!");
		}
		catch(Exception e) {
			System.out.println("Errore nell'inserimento dell'evento");
		}
		
	}
	
	public void getPartiteVinteinCasa() {
		Query q = em.createQuery("SELECT p FROM PartitaCalcio p ");
		List <PartitaCalcio> results = q.getResultList();
		
		System.out.println("Partite vinte dalla squadra in casa:");
		for (PartitaCalcio p: results) {
			if(p.getGoalCasa() > p.getGoalOspite()) {
				System.out.println(p);
				System.out.println("Nome squadra vincente: " + p.getSquadraCasa() + " | Goal: " + p.getGoalCasa());
				System.out.println("Nome squadra perdente: " + p.getSquadraOspite() + " | Goal: " + p.getGoalOspite());
				
			}
		}
	}

	public void closeEm() {
		em.close();
		emf.close();
	}
	
}

// getConcertiInStreaming(true/false)
// getConcertiPerGenere(List<GenereConcerto>)
// getPartiteVinteInCasa
// getPartiteVinteInTrasferta
// getPartitePareggiate
