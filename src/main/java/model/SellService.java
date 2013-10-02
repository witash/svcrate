package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class SellService {
	private String name;
	
	@Id
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
