package invoice.controller;

import invoice.model.enties.Invoice;
import invoice.model.service.InvoiceService;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class InvoiceController {
	private final Logger log= LoggerFactory.getLogger(this.getClass());
	@Autowired
	private InvoiceService invoiceService;
	
	/**
	 * Main site controller. Triggered on application  start.
	 * Serves list of all invoices from db
	 * @param map Model map object
	 * @return View name: invoiceList
	 */
	@RequestMapping("/index")
	public String setupForm(Map<String, Object> map){
		log.info("Controller::GET /index.htm setupForm()");
		Invoice invoice = new Invoice();
		map.put("invoice", invoice);
		map.put("invoiceList", invoiceService.getAllInvoices());
		log.info("invoiceList from DB:{}", map.get("invoiceList"));
		return "invoicesList";
	}
	
	/**
	 * Actions on submitting the form with single invoice details.
	 * Actions:  ADD, UPDATE
	 * @param invoice Invoice entity from the model
	 * @param result Bindings object
	 * @param action Action type: ADD,UPDATE
	 * @param map 
	 * @return View name: invoiceList
	 */
	@RequestMapping(value="/invoiceDo",method=RequestMethod.POST)
	public String doActions(@ModelAttribute Invoice invoice,BindingResult result, @RequestParam String action, Map<String,Object> map){

		log.info("Controller::POST /invoiceDo.htm doActions()");
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
		return "invoicesList";
	}
	
	@RequestMapping(value="/axInvDetails",method=RequestMethod.POST , produces= "application/json;charset=UTF-8")
	public @ResponseBody String ajaxInvoiceDetails(@RequestParam final int invoiceId, Map<String,Object> map){
			
			log.info("Controller::POST /axInvDetails.htm ajaxInvoiceDetails()");
			Invoice invoiceResult = new Invoice();
	
			Invoice searchedInvoice = invoiceService.getInvoice(invoiceId);
			
			log.info("searchedInvoice from DB:{}",searchedInvoice);
			
			invoiceResult = searchedInvoice!=null? searchedInvoice: new Invoice() ;
			String json = new Gson().toJson(invoiceResult);
		    Gson gson = new Gson();

			log.info("invoiceResult in JSON:{}", json);
			
			//map.put("invoice", invoiceResult);
			//map.put("invoiceList", invoiceService.getAllInvoices());
		return json;
	}
	
	/**
	 * getting all information about single invoice and serving it in model
	 * @param invoiceId id of the invoice
	 * @param result Bindings from side to oper on invoiceId
	 * @return
	 */
	@RequestMapping(value="/invoiceDetails",method=RequestMethod.GET)
	public String retrieveInvoiceDetails(@ModelAttribute final int invoiceId,BindingResult result){
		log.info("Controller:: /invoiceDetails.htm retrieveInvoiceDetais()");
		Invoice invoiceResult = invoiceService.getInvoice(invoiceId);
		
	return "";
	}	
}
