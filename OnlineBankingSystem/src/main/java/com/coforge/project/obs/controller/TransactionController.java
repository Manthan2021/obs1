package com.coforge.project.obs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.project.obs.model.Transact;
import com.coforge.project.obs.service.TransactionService;

@RestController
@RequestMapping(value="/txn")
public class TransactionController {
	
	@Autowired
	private TransactionService tService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Transact> saveTxn(@RequestBody Transact transact)
	{
		return new ResponseEntity<>(tService.savetxn(transact),HttpStatus.CREATED);
	}
	
	
	
	
	@GetMapping("/all/{id}")
	public ResponseEntity<List<Transact>> getAllTxn(String id){
		
		return new ResponseEntity<>(tService.getalltxn(id),HttpStatus.OK);
	}
	

@GetMapping("/get/{id}")
    public ResponseEntity<Transact> getLastTxn(@PathVariable String id) {
		
		return new ResponseEntity<>(tService.getlasttxn(id),HttpStatus.OK);
	}
	
	
	


}
