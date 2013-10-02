package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class ServiceItem {
	private String origin;
	private String destination;
	private String businessKey;
	private SellService sellService;
	private String primaryName;
	
	Set<RateItem> rateItems = new HashSet<RateItem>();
	
	@Id
	public String getBusinessKey() {
		return businessKey;
	}

	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}

	@OneToOne
	public SellService getSellService() {
		return sellService;
	}

	public void setSellService(SellService sellService) {
		this.sellService = sellService;
	}

	@OneToMany
	public Set<RateItem> getRateItems() {
		return rateItems;
	}

	public void setRateItems(Set<RateItem> rateItems) {
		this.rateItems = rateItems;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getPrimaryName() {
		return primaryName;
	}

	public void setPrimaryName(String primaryName) {
		this.primaryName = primaryName;
	}	
}
