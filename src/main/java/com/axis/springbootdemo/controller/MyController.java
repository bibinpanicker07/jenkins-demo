package com.axis.springbootdemo.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.axis.springbootdemo.entity.Cricketer;

@RestController
public class MyController {
	private static ArrayList<Cricketer> crickList;
	static {
		crickList = new ArrayList<>();
		crickList.add(new Cricketer(101,"sachin1",99,10,1,1,700));
		crickList.add(new Cricketer(102,"sachin2",119,180,4,5,200));
		crickList.add(new Cricketer(103,"sachin3",21,180,4,5,200));
		crickList.add(new Cricketer(104,"sachin4",912,180,4,5,200));
		crickList.add(new Cricketer(105,"sachin5",92,180,4,5,200));
	}
	
	@GetMapping("/message")
	public String getMessage() {
		return "Hello...my first SpringBoot Project..Gud...";
		
	}
	
	
	@GetMapping("/welcome")
	public String welcome() {
		return "WELCOME ALLLLLL";
		
	}
	
	@GetMapping("/cricket")
	public ArrayList<Cricketer> getCricket() {
		return crickList;
				
	}
	
	
	@GetMapping("/cricket/{cricketerId}")
	public Cricketer getCricketerById(@PathVariable int cricketerId){
		for(Cricketer ck:crickList) {
			if(ck.getCricketerId()==cricketerId) {
				return ck;
			}
		}
		return null;
	}
	
	
	@PostMapping("/cricket")
	public ResponseEntity<String> addCricketer(@RequestBody Cricketer cricketer){
		crickList.add(cricketer);
		return new ResponseEntity<String>("Cricketer Added Successfully..", HttpStatus.OK);
	}
	
	//UPDATE REQUEST
	@PutMapping("/cricketer/update/{id}")
	public ResponseEntity<String> updateCricketer(@PathVariable int id,@RequestBody Cricketer updatedCricketer){
		if(id!=updatedCricketer.getCricketerId())
			return new ResponseEntity<String>("Cricketer ids does not match",HttpStatus.BAD_REQUEST);
		int index=crickList.indexOf(updatedCricketer);
		if(index == -1) {
			return new ResponseEntity<String>("Cricketer with id : "+id+" not found",HttpStatus.NOT_FOUND);
		}
		else {
			crickList.get(index).setBalls(updatedCricketer.getBalls());
			crickList.get(index).setFours(updatedCricketer.getFours());
			crickList.get(index).setRunScored(updatedCricketer.getRunScored());
			crickList.get(index).setSixes(updatedCricketer.getSixes());
			crickList.get(index).setStrikeRate(updatedCricketer.getStrikeRate());
			return new ResponseEntity<String>("Cricketer data updated successfully ",HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/cricketer/delete/{cricketerId}")
	public ResponseEntity<String>deleteCricketer(@PathVariable int cricketerId){
	Cricketer cricketer = getCricketerById(cricketerId);
	if(cricketer==null) {
		return new ResponseEntity<String>("Crickter with id:"+cricketerId+" is nit found",HttpStatus.NOT_FOUND);
	}else {
		crickList.remove(cricketer);
		return new ResponseEntity<String>("Cricketer with id:"+cricketerId+" deleted successfully",HttpStatus.OK);
	}
	
	}
	
	
	

}
