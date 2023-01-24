package esercizio1;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Evento;
import entities.TipoEvento;

public class EventoDao {
	
	private static final String persistenceUnit = "Giorno2";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();

	public void insertEvento(String titolo, LocalDate date, String descrizione, TipoEvento tipoEvento, int numeroMaxPartecipanti ) {
		
		try {
			
			Evento e = new Evento();
			e.setTitolo(titolo);
			e.setDate(date);
			e.setDescrizione(descrizione);
			e.setTipoEvento(tipoEvento);
			e.setNumeroMaxPartecipanti(numeroMaxPartecipanti);
			
			
			t.begin();
			em.persist(e);
			t.commit();
			
			System.out.println("Evento inserito correttamente!");
		}
		catch(Exception e) {
			System.out.println("Errore nell'inserimento dell'evento");
		}
		
	}

	public void getEventoById(int id) {
		Evento e = em.find(Evento.class, id);
		
		if( e == null ) {
			System.out.println( "Evento con id " + id + " non è stato trovato!" );
			return;
		}
		
		System.out.println( "Dati Evento #" + id );
		System.out.printf("Titolo: %s | Data: %s | Descrizione: %s | Tipo Evento: %s | Numero massimo partecipanti: %d%n", e.getTitolo(), e.getDate().toString(), e.getDescrizione(), e.getTipoEvento().toString(), e.getNumeroMaxPartecipanti());
	}
	
	public void deleteEventoById(int id) {
		Evento e = em.find(Evento.class, id);
		
		if( e == null ) {
			System.out.println( "Evento con id " + id + " non è stato trovato!" );
			return;
		}
		
		t.begin();
		em.remove(e);
		t.commit();
		
		System.out.println( "Evento con id " + id + " è stato eliminato!" );
	}
	
	public void refresh(Evento o) {
		em.refresh(o);
	}

	public void closeEm() {
		em.close();
		emf.close();
	}
	
}
