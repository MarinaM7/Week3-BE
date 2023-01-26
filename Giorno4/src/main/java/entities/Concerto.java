package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "concerto")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Concerto extends Evento {

	@Enumerated(EnumType.STRING)
	private Genere genere;
	
	private boolean streaming;
	
	public Concerto(String titolo, LocalDate date, String descrizione, TipoEvento tipoEvento, int numeroMaxPartecipanti,
			Genere genere, boolean streaming) {
		super(titolo, date, descrizione, tipoEvento, numeroMaxPartecipanti);
		this.genere = genere;
		this.streaming = streaming;
	}
	
	
}
/*
	genere [CLASSICO, ROCK, POP]
	inStreaming [true, false]
*/