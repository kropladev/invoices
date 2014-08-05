package invoice.controller;

import invoice.model.enties.CounterStatus;
import invoice.model.enties.CounterStatusesReads;
import invoice.model.service.CounterService;
import invoice.model.service.ReadService;

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

@Controller
@RequestMapping("/reads")
public class ReadsController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ReadService readService;
	@Autowired
	private CounterService counterService;
	
	private final static String TABLE_TILE= "List of counter statuses reads";
	private final static String LIST_PAGE = "readList";

	/**
	 * Main site controller. Serves list of all counters from db
	 * 
	 * @param map Model map object
	 * @return View name: invoiceList
	 */
	@RequestMapping("/list")
	public String setupForm(Map<String, Object> map) {
		log.info("ReadController::GET /index.htm setupForm()");
		CounterStatusesReads read = new CounterStatusesReads();
		map.put("elem", read);
		map.put("elemList", readService.getAllElems());
		map.put("tableTitle", TABLE_TILE);
		map.put("counterList", counterService.getAllCounters());
		map.put("status", new CounterStatus());
//		log.info("counterList from DB:{}", map.get("counterList"));
		return LIST_PAGE;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute CounterStatusesReads elem, BindingResult result,
			@RequestParam String action, Map<String, Object> map) {

		log.info("Controller::POST /invoiceDo.htm doActions()");

		readService.delete(elem.getId());
		map.put("elemList", readService.getAllElems());
		map.put("tableTitle", TABLE_TILE);
		return LIST_PAGE;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute CounterStatusesReads elem, BindingResult result,
			Map<String, Object> map) {

		log.info("Controller::POST /counter/edit edit()");

		readService.edit(elem);

		map.put("elem", elem);
		map.put("elemList", readService.getAllElems());
		map.put("tableTitle", TABLE_TILE);
		return LIST_PAGE;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String add(@ModelAttribute CounterStatusesReads elem, BindingResult result,
			Map<String, Object> map) {

		log.info("Controller::POST /counter/add add()");

		readService.add(elem);

		map.put("elem", new CounterStatusesReads());
		map.put("elemList", readService.getAllElems());
		map.put("tableTitle", TABLE_TILE);
		return LIST_PAGE;
	}
	
	@RequestMapping("/new")
	@ResponseBody
	public CounterStatusesReads newForm() {
		log.info("CounterController::GET /new newForm()");
		return  new CounterStatusesReads();
	}

	@RequestMapping("/{elemId}/details")
	@ResponseBody
	public CounterStatusesReads ajaxInvoiceDetails(@PathVariable int elemId) {

		log.info("CounterController::POST /axInvDetails.htm ajaxInvoiceDetails()");
		CounterStatusesReads elemResult = new CounterStatusesReads();

		CounterStatusesReads searchedElem = readService.getElem(elemId);

		log.info("searchedCounter from DB:{}", searchedElem);

		elemResult = searchedElem != null ? searchedElem
				: new CounterStatusesReads();
		return elemResult;
	}

}
