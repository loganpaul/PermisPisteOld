package metier;

// Generated 3 juin 2015 10:21:18 by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Jeu generated by hbm2java
 */
@Entity
@Table(name = "jeu", catalog = "permispiste")
public class Jeu implements java.io.Serializable {

	private int numjeu;
	private String libellejeu;
	
	private List<Action> mesActions = new ArrayList<Action>();
	private List<Mission> mesMissions = new ArrayList<Mission>();
	

	public Jeu() {
	}

	public Jeu(int numjeu) {
		this.numjeu = numjeu;
	}

	public Jeu(int numjeu, String libellejeu, List<Mission> missions, List<Action> actions) {
		this.numjeu = numjeu;
		this.libellejeu = libellejeu;
		this.mesMissions = missions;
		this.mesActions = actions;
	}

	@Id
	@Column(name = "NUMJEU", unique = true, nullable = false)
	public int getNumjeu() {
		return this.numjeu;
	}

	public void setNumjeu(int numjeu) {
		this.numjeu = numjeu;
	}

	@Column(name = "LIBELLEJEU", length = 25)
	public String getLibellejeu() {
		return this.libellejeu;
	}

	public void setLibellejeu(String libellejeu) {
		this.libellejeu = libellejeu;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jeu")
	public List<Mission> getMissions() {
		return this.mesMissions;
	}

	public void setMissions(List<Mission> missions) {
		this.mesMissions = missions;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "appartient", catalog = "permispiste", joinColumns = { @JoinColumn(name = "NUMJEU", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "NUMACTION", nullable = false, updatable = false) })
	public List<Action> getActions() {
		return this.mesActions;
	}

	public void setActions(List<Action> actions) {
		this.mesActions = actions;
	}

}
