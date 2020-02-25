package com.apap.tu04.service;

import java.util.List;

import com.apap.tu04.model.PilotModel;

public interface PilotService {
	PilotModel getPilotdetailByLicenseNumber(String licenseNumber);
	void addPilot(PilotModel pilot);
	void delPilot(PilotModel pilot);
}
