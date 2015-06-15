package metier;

// Generated 3 juin 2015 10:21:18 by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Calendrier generated by hbm2java
 */
@Entity
@Table(name = "calendrier", catalog = "permispiste")
public class Calendrier implements java.io.Serializable {

	private Date datejour;
	List<Obtient> mesResultats = new ArrayList<Obtient>();
	private List<Inscrit> inscrits = new ArrayList<Inscrit>();

	public Calendrier() {
	}

	public Calendrier(Date datejour) {
		this.datejour = datejour;
	}

	public Calendrier(Date datejour, List<Obtient>  obtients) {
		this.datejour = datejour;
		this.mesResultats = obtients;
	}

	@Id
	@Temporal(value = TemporalType.DATE)
	@Column(name = "DATEJOUR", unique = true, nullable = false, length = 10)
	public Date getDatejour() {
		return this.datejour;
	}

	public void setDatejour(Date datejour) {
		this.datejour = datejour;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "calendrier")
	public List<Obtient> getObtients() {
		return this.mesResultats;
	}

	public void setObtients(List<Obtient> obtients) {
		this.mesResultats = obtients;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "calendrier")
	public List<Inscrit> getInscrits() {
		return this.inscrits;
	}

	public void setInscrits(List<Inscrit> inscrits) {
		this.inscrits = inscrits;
	}

}
