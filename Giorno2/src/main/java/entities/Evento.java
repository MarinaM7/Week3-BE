package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="eventi")
@Getter
@Setter
@ToString
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String titolo;
	private LocalDate date;
	private String descrizione;
	
	@Enumerated(EnumType.STRING)
	private TipoEvento tipoEvento;
	
	private int numeroMaxPartecipanti;
}
