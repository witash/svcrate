package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class RateItem {
	private String businessKey;
	private AbsRateType rate;
	private String effectiveDate;
	private String expirationDate;
	private ServiceItem serviceItem;
	
	@Id
	public String getBusinessKey() {
		return businessKey;
	}
	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}
	public AbsRateType getRate() {
		return rate;
	}
	public void setRate(AbsRateType rate) {
		this.rate = rate;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	@ManyToOne
	public ServiceItem getServiceItem() {
		return serviceItem;
	}
	public void setServiceItem(ServiceItem serviceItem) {
		this.serviceItem = serviceItem;
	}
}
