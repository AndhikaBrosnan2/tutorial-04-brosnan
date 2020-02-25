package com.apap.tu04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tu04.model.PilotModel;
import com.apap.tu04.service.PilotService;

@Controller
public class PilotController {

	@Autowired
	private PilotService pilotService;

	@RequestMapping("/")
	private String home() {
		return "home";
	}

	@RequestMapping(value = "/pilot/view", method = RequestMethod.GET)
	public String view(@RequestParam(value = "licenseNumber", required = false) String licenseNumber, Model model) {

		PilotModel archive = pilotService.getPilotdetailByLicenseNumber(licenseNumber);

		if (licenseNumber == null) {
			model.addAttribute("licenseNumber", "error message");
			return "errorPage";
		}

		model.addAttribute("pilot", archive);
		model.addAttribute("listFlight", archive.getPilotFlight());
		return "view-pilot";
	}

	// per Pilot-an
	@RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
	private String addPilot(Model model) {
		model.addAttribute("pilot", new PilotModel());
		return "addPilot";
	}

	@RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
	private String addPilotSubmit(@ModelAttribute PilotModel pilot) {
		pilotService.addPilot(pilot);
		return "add";
	}

	@RequestMapping(value = "/pilot/delete", method = RequestMethod.GET)
	private String deletePilotSubmit(@RequestParam(value = "licenseNumber") String licenseNumber, Model model) {
		PilotModel pickPilot = pilotService.getPilotdetailByLicenseNumber(licenseNumber);
		model.addAttribute("pickPilot", pickPilot);
		pilotService.delPilot(pickPilot);
		return "delete";
	}
}
