package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="eventi")
@Getter
@Setter
@ToString
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Evento {

	@Id
	@GeneratedValue
	private int id;
	
	private String titolo;
	private LocalDate date;
	private String descrizione;
	
	@Enumerated(EnumType.STRING)
	private TipoEvento tipoEvento;
	
	private int numeroMaxPartecipanti;
	
	public Evento(String titolo, LocalDate date, String descrizione, TipoEvento tipoEvento,
			int numeroMaxPartecipanti) {
		this.titolo = titolo;
		this.date = date;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMaxPartecipanti = numeroMaxPartecipanti;
	}

}
