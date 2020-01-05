package org.example.HotelReservation;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonView;

@Service
public class RecordService {

	@Autowired 
	private HotelRepository hotelRepository;
	
	public List<HotelModel> getRecords(){
		return hotelRepository.findAll();
	}
	public boolean submitRecord(String firstName , String lastName){
		HotelModel hotelModel = new HotelModel();
		hotelModel.setFirstName(firstName);
		hotelModel.setLastName(lastName);
		hotelRepository.save(hotelModel);
		return true;
	}
}
