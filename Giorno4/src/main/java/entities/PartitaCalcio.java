package entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "partita_calcio")
@Getter
@Setter
@NoArgsConstructor
public class PartitaCalcio extends Evento {

	@Column(name = "squadradicasa")
	private String squadraCasa;
	
	@Column(name = "squadraospite")
	private String squadraOspite;
	
	@Column(name = "squadravincente")
	private String squadraVincente;
	
	@Column(name = "goalsquadradicasa")
	private int goalCasa;
	
	@Column(name = "goalsquadraospite")
	private int goalOspite;

	public PartitaCalcio(String titolo, LocalDate date, String descrizione, TipoEvento tipoEvento,
			int numeroMaxPartecipanti, String squadraCasa, String squadraOspite, String squadraVincente, int goalCasa,
			int goalOspite) {
		super(titolo, date, descrizione, tipoEvento, numeroMaxPartecipanti);
		this.squadraCasa = squadraCasa;
		this.squadraOspite = squadraOspite;
		this.squadraVincente = squadraVincente;
		this.goalCasa = goalCasa;
		this.goalOspite = goalOspite;
	}
	
	
}

/*
Squadra di casa (string)
Squadra ospite (string)
SquadraVincente (string) [null se pareggio]
numero Gol Squadra Di Casa
numero Gol Squadra Ospite
*/