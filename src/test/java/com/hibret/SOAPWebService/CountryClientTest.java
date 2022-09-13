package com.hibret.SOAPWebService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import soapwebservice.hibret.com.soap_web_service.Currency;
import soapwebservice.hibret.com.soap_web_service.Country;

@SpringBootTest
public class CountryClientTest {
	
    @Autowired
    CountryRepository client;
    
    
	   @Test
	    public void givenCountryService_whenCountryEthiopia_thenCapitalIsAddisAbaba() {
	        Country response = client.findCountry("Ethiopia");
	        assertEquals("Addis Ababa", response.getCapital());
	    }

	    @Test
	    public void givenCountryService_whenCountrySpain_thenCurrencyEUR() {
	        Country response = client.findCountry("Spain");
	        assertEquals(Currency.EUR, response.getCurrency());
	    }
	    
	    @Test
	    public void givenUnknownCountryService_thenCapitalIsNotAddisAbaba() {
	        Country response = client.findCountry("Poland");
	        assertNotEquals("Addis Ababa", response.getCapital());
	    }
}
