package metier;

// Generated 3 juin 2015 10:21:18 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ObtientId generated by hbm2java
 */
@Embeddable
public class ObtientId implements java.io.Serializable {

	private int numapprenant;
	private Date datejour;
	private int numaction;

	public ObtientId() {
	}

	public ObtientId(int numapprenant, Date datejour, int numaction) {
		this.numapprenant = numapprenant;
		this.datejour = datejour;
		this.numaction = numaction;
	}

	@Column(name = "NUMAPPRENANT", nullable = false)
	public int getNumapprenant() {
		return this.numapprenant;
	}

	public void setNumapprenant(int numapprenant) {
		this.numapprenant = numapprenant;
	}

	@Column(name = "DATEJOUR", nullable = false, length = 10)
	public Date getDatejour() {
		return this.datejour;
	}

	public void setDatejour(Date datejour) {
		this.datejour = datejour;
	}

	@Column(name = "NUMACTION", nullable = false)
	public int getNumaction() {
		return this.numaction;
	}

	public void setNumaction(int numaction) {
		this.numaction = numaction;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ObtientId))
			return false;
		ObtientId castOther = (ObtientId) other;

		return (this.getNumapprenant() == castOther.getNumapprenant())
				&& ((this.getDatejour() == castOther.getDatejour()) || (this
						.getDatejour() != null
						&& castOther.getDatejour() != null && this
						.getDatejour().equals(castOther.getDatejour())))
				&& (this.getNumaction() == castOther.getNumaction());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getNumapprenant();
		result = 37 * result
				+ (getDatejour() == null ? 0 : this.getDatejour().hashCode());
		result = 37 * result + this.getNumaction();
		return result;
	}

}
