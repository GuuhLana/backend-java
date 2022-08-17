package com.gtech.gtechsyst.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/check")
public class HealthCheckController {
	
	@GetMapping
	public ResponseEntity<String> checkStatus(){
		return ResponseEntity.ok("API ESTÁ DE PÉ");
	}
}
