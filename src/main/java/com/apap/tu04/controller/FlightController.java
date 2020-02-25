package com.apap.tu04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.tu04.model.FlightModel;
import com.apap.tu04.model.PilotModel;
import com.apap.tu04.service.FlightService;
import com.apap.tu04.service.PilotService;

@Controller
public class FlightController {
	@Autowired
	private FlightService flightService;

	@Autowired
	private PilotService pilotService;

	@RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.GET)
	private String add(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		FlightModel flight = new FlightModel();
		PilotModel pilot = pilotService.getPilotdetailByLicenseNumber(licenseNumber);
		flight.setPilot(pilot);
		model.addAttribute("flight", flight);
		return "addFlight";
	}

	@RequestMapping(value = "/flight/add", method = RequestMethod.POST)
	private String addFlightSubmit(@ModelAttribute FlightModel flight) {
		flightService.addFlight(flight);
		return "add";
	}

	@RequestMapping(value = "/flight/delete/{id}", method = RequestMethod.GET)
	private String deleteFlight(@PathVariable(value="id")long id, Model model) {

		flightService.delFlight(id);
		return "delete";
	}

//	@RequestMapping(value = "/flight/delete/{licenseNumber}", method = RequestMethod.GET)
//	private String deletePilotSubmit(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
//		PilotModel pickPilot = pilotService.getPilotdetailByLicenseNumber(licenseNumber);
//		List<FlightModel> all = pickPilot.getPilotFlight();
//		model.addAttribute("pickPilot", pickPilot);
//		for (int i = 0; i < all.size(); i++) {
//			flightService.delFlight(all.get(i));
//		}
//		return "delete";
//	}

//	@RequestMapping(value="/flight/delete",method = RequestMethod.DELETE)
//	private String delete()
}
