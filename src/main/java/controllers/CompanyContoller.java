package controllers;

import model.Company;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest")
public class CompanyContoller {

	@RequestMapping(value = "/company", method=RequestMethod.GET)
	@ResponseBody
	public Company getCompany(){
		return new Company();
	}
		
}
