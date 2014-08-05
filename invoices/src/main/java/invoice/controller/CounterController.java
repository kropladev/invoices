package invoice.controller;

import invoice.model.enties.Counter;
import invoice.model.enties.Invoice;
import invoice.model.service.CounterService;
import invoice.model.service.InvoiceService;

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
@RequestMapping("/counter")
public class CounterController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CounterService counterService;
	private final static String TABLE_TILE= "List of counters";

	/**
	 * Main site controller. Serves list of all counters from db
	 * 
	 * @param map Model map object
	 * @return View name: invoiceList
	 */
	@RequestMapping("/list")
	public String setupForm(Map<String, Object> map) {
		log.info("CounterController::GET /index.htm setupForm()");
		Counter counter = new Counter();
		map.put("counter", counter);
		map.put("counterList", counterService.getAllCounters());
		map.put("tableTitle", "List of  counters");
		log.info("counterList from DB:{}", map.get("counterList"));
		map.put("tableTitle", TABLE_TILE);
		return "counterList";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute Counter counter, BindingResult result,
			@RequestParam String action, Map<String, Object> map) {

		log.info("Controller::POST /invoiceDo.htm doActions()");

		counterService.delete(counter.getId());
		map.put("counterList", counterService.getAllCounters());
		map.put("tableTitle", TABLE_TILE);
		return "counterList";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute Counter counter, BindingResult result,
			Map<String, Object> map) {

		log.info("Controller::POST /counter/edit edit()");

		counterService.edit(counter);

		map.put("counter", counter);
		map.put("counterList", counterService.getAllCounters());
		map.put("tableTitle", TABLE_TILE);
		return "counterList";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String add(@ModelAttribute Counter counter, BindingResult result,
			Map<String, Object> map) {

		log.info("Controller::POST /counter/add add()");

		counterService.add(counter);

		map.put("counter", new Counter());
		map.put("counterList", counterService.getAllCounters());
		map.put("tableTitle", TABLE_TILE);
		return "counterList";
	}
	
	@RequestMapping("/new")
	@ResponseBody
	public Counter newForm() {
		log.info("CounterController::GET /new newForm()");
		return  new Counter();
	}

	@RequestMapping("/{counterId}/details")
	@ResponseBody
	public Counter ajaxInvoiceDetails(@PathVariable int counterId) {

		log.info("CounterController::POST /axInvDetails.htm ajaxInvoiceDetails()");
		Counter counterResult = new Counter();

		Counter searchedCounter = counterService.getCounter(counterId);

		log.info("searchedCounter from DB:{}", searchedCounter);

		counterResult = searchedCounter != null ? searchedCounter
				: new Counter();
		return counterResult;
	}

}
