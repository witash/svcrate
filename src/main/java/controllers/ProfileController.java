package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.BasicRate;
import model.Company;
import model.Currency;
import model.RateItem;
import model.SellService;
import model.ServiceItem;
import model.SvcRateProfile;

@Controller
@RequestMapping("/rest")
public class ProfileController {

	@RequestMapping(value = "/profile", method=RequestMethod.GET)
	@ResponseBody
	public SvcRateProfile getProfileFor(){
			ArrayList<String> destList = new ArrayList<String>();
			destList.add("HKG");
			destList.add("SHA");
			destList.add("KTM");
			destList.add("PHH");
			destList.add("PHM");
			destList.add("SLO");
			destList.add("DAR");
			destList.add("UZB");
			destList.add("LAX");
			destList.add("PHO");
			destList.add("BKK");
			destList.add("SRW");
			destList.add("JFK");
			
			SvcRateProfile p = new SvcRateProfile();
			SellService ss = new SellService();
			ss.setName("Air Freight");
			SellService ss2 = new SellService();
			ss2.setName("Fuel Surcharge");
			Currency c = new Currency();
			c.setName("USD");
			BasicRate r = new BasicRate();
			r.setBusinessKey("R123");
			r.setCurrency(c);
			r.setAmount(2.12);
			RateItem ri1 = new RateItem();
			ri1.setBusinessKey("RI001");
			ri1.setRate(r);
			ri1.setEffectiveDate("01/01/2012");
			ri1.setExpirationDate("01/01/2013");
			
			Currency c2 = new Currency();
			c2.setName("EUR");
			BasicRate r2 = new BasicRate();
			r2.setBusinessKey("R123");
			r2.setCurrency(c2);
			r2.setAmount(3.12);
			RateItem ri2 = new RateItem();
			ri2.setBusinessKey("RI001");
			ri2.setRate(r2);
			ri2.setEffectiveDate("01/01/2012");
			ri2.setExpirationDate("01/01/2013");
			
			RateItem ri3 = new RateItem();
			ri3.setBusinessKey("RI001");
			ri3.setRate(r);
			ri3.setEffectiveDate("01/01/2013");
			ri3.setExpirationDate("01/01/2014");
			
			for(String destination : destList){
				ServiceItem si = new ServiceItem();
				si.setOrigin("SEA");
				si.setDestination(destination);
				si.setSellService(ss);
				si.getRateItems().add(ri1);
				si.getRateItems().add(ri2);
				si.getRateItems().add(ri3);
				p.getServiceItems().add(si);
				
				ServiceItem surcharge = new ServiceItem();
				surcharge.setSellService(ss2);
				surcharge.setOrigin("SEA");
				surcharge.setDestination(destination);
				surcharge.setPrimaryName(si.getSellService().getName());
				surcharge.getRateItems().add(ri1);
				
				p.getServiceItems().add(surcharge);
			}
			
			Company cq = new Company();
			cq.setBusinessKey("C10003");
			cq.setName("Tom's Test Company");
			cq.setAddress("11 Hickory St.");
			cq.setCity("Seattle");
			cq.setState("WA");
			cq.setCountry("US");
			
			p.setCompany(cq);
			return p;	
	}
}
