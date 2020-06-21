package org.codefagsystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public class Fagsystem {
	
	@WebMethod
	public String createCustomer(String customerName) {
		return generateUniqueNr(customerName);
	}
	
	@WebMethod
	public String createContract(String customerNr) {
		return generateUniqueNr(customerNr);
	}
	
	@WebMethod
	public String updateContractStatus(String contractNr) {
		if((contractNr != null) && (!contractNr.trim().equalsIgnoreCase(""))) {
			return "avtale sendt";			
		}
		return "avtale ikke sendt";
	}
	
	public String generateUniqueNr(String val) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMYYHHMMssSSS");
		return formatter.format(LocalDateTime.now()) + "_" + val;		
	}

}
