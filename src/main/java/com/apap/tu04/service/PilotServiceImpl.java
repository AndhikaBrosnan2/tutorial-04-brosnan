package com.apap.tu04.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tu04.model.PilotModel;
import com.apap.tu04.repository.PilotDb;

@Service
@Transactional
public class PilotServiceImpl implements PilotService {
	
	List<PilotModel> archivePilot;
	
	public PilotServiceImpl() {
		archivePilot = new ArrayList<>();
	}
	
	@Autowired
	private PilotDb pilotDb;
	
	@Override
	public PilotModel getPilotdetailByLicenseNumber(String licenseNumber) {
		return pilotDb.findByLicenseNumber(licenseNumber);
	}

	@Override
	public void addPilot(PilotModel pilot) {
		pilotDb.save(pilot);
		
	}
	
	@Override
	public void delPilot(PilotModel pilot) {
		pilotDb.deleteById(pilot.getId());
	}
}
