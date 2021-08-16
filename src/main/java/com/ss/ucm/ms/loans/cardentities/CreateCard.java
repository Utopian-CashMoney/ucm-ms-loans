package com.ss.ucm.ms.loans.cardentities;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="create_card")
public class CreateCard implements Serializable {

	private static final long serialVersionUID = -8820963648316030320L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "ctype")
    private String ctype;
    
    @Column(name = "name")
    private String name;

    @Column(name = "apr")
    private BigDecimal apr;

    @Column(name = "perks")
    private String perks;
    
    
    public CreateCard() {}
    
    public CreateCard(String ctype, String name, BigDecimal apr, String perks) {
    	this.ctype = ctype;
        this.name = name;
        this.apr = apr;
        this.perks = perks;
    }
    
    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public String getC_type() {
		return ctype;
	}

	public void setC_type(String ctype) {
		this.ctype = ctype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getApr() {
		return apr;
	}

	public void setApr(BigDecimal apr) {
		this.apr = apr;
	}

	public String getPerks() {
		return perks;
	}

	public void setPerks(String perks) {
		this.perks = perks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apr == null) ? 0 : apr.hashCode());
		result = prime * result + ((ctype == null) ? 0 : ctype.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((perks == null) ? 0 : perks.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreateCard other = (CreateCard) obj;
		if (apr == null) {
			if (other.apr != null)
				return false;
		} else if (!apr.equals(other.apr))
			return false;
		if (ctype == null) {
			if (other.ctype != null)
				return false;
		} else if (!ctype.equals(other.ctype))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (perks == null) {
			if (other.perks != null)
				return false;
		} else if (!perks.equals(other.perks))
			return false;
		return true;
	}


	

	
	
    
    

}
