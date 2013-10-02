package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SvcRateProfile {
	private List<ServiceItem> serviceItems = new ArrayList<ServiceItem>();
	private Company company;
	
	
	public List<ServiceItem> getServiceItems() {
		return serviceItems;
	}

	public void setServiceItems(List<ServiceItem> serviceItems) {
		this.serviceItems = serviceItems;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
