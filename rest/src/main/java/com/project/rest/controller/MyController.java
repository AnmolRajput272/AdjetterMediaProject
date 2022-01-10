package com.project.rest.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.rest.entity.Call;
import com.project.rest.service.CallService;

@RestController
public class MyController {
	
	@Autowired CallService callservice;
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/getData")
	public String getData(@RequestBody List<Call> call) throws ParseException {
		return callservice.getDetails(call);
	}
}
