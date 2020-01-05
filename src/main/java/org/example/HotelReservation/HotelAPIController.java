package org.example.HotelReservation;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.List;

import org.example.HotelReservation.*;

@Controller
public class HotelAPIController {

	@Autowired
	private RecordService recordService;
	
	@RequestMapping(value="/HotelReservation/Booking", method=RequestMethod.POST)
			//produces=MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String storeRecords(@RequestParam(name="firstName") String firstName 
			, @RequestParam(name="lastName") String lastName) {
				
		//System.out.println("user input is "+firstName + "Last name is "+lastName);
		if(recordService.submitRecord(firstName, lastName))
			return "Succesfully Reserved";
		else
			return "Failure in Reservation of Room";
	}
	
	@RequestMapping(value="/HotelReservation", method=RequestMethod.GET)
	@ResponseBody
	public List<HotelModel> getRecords() {
		return recordService.getRecords();
	}
	
}
