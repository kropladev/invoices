package pl.kropladev.invoice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.kropladev.invoice.model.enties.Invoice;
import pl.kropladev.invoice.model.service.InvoiceService;

@Controller
public class InvoiceController {
	@Autowired
	private InvoiceService invoiceService;
	
	@RequestMapping("/index")
	public String setupForm(Map<String, Object> map){
		System.out.println("TEST");
		Invoice invoice = new Invoice();
		map.put("invoice", invoice);
		map.put("invoiceList", invoiceService.getAllInvoices());
		return "invoice";
	}
	
	@RequestMapping(value="/invoiceDo",method=RequestMethod.POST)
	public String doActions(@ModelAttribute Invoice invoice,BindingResult result, @RequestParam String action, Map<String,Object> map){
		Invoice invoiceResult = new Invoice();
		
		switch(action.toLowerCase()){
		case "add":
			invoiceService.add(invoice);
			invoiceResult = invoice;
			break;
		case "edit":
			invoiceService.edit(invoice);
			invoiceResult = invoice;
			break;
		case "delete":
			invoiceService.delete(invoice.getId());
			invoiceResult = new Invoice();
			break;
		case "search":
			Invoice searchedInvoice = invoiceService.getInvoice(invoice.getId());
			
			invoiceResult = searchedInvoice!=null? searchedInvoice: new Invoice() ;
			break;
		}
		
		map.put("invoice", invoiceResult);
		map.put("invoiceList", invoiceService.getAllInvoices());
		return "invoice";
	}
}
