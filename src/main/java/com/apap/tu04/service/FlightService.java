package com.apap.tu04.service;

import java.util.List;

import com.apap.tu04.model.FlightModel;

public interface FlightService {
	void addFlight(FlightModel flight);
	void deleteFlight(FlightModel flight);
	void delFlight(long id);
}
