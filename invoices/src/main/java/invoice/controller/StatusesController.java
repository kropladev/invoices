package invoice.controller;

import invoice.model.enties.CounterStatus;
import invoice.model.enties.Invoice;
import invoice.model.service.InvoiceService;
import invoice.model.service.StatusService;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.google.gson.Gson;

@Controller
@RequestMapping("/status")
public class StatusesController {
	private final Logger log= LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StatusService statusService;
	private final static String TABLE_TILE= "List of counter statuses";
	
	/**
	 * Main site controller. Triggered on application  start.
	 * Serves list of all invoices from db
	 * @param map Model map object
	 * @return View name: invoiceList
	 */
	@RequestMapping("/list")
	public String setupForm(Map<String, Object> map){
		log.info("StatusesController::GET /index.htm setupForm()");
		CounterStatus status = new CounterStatus();
		map.put("status", status);
		map.put("statusList", statusService.getAllStatuses());
		log.info("statusList from DB:{}", map.get("statusList"));
		map.put("tableTitle", TABLE_TILE);
		return "invList";
	}
}
