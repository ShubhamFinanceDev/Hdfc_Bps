package com.shubham.bbps.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

	private static final Logger LOGGER = LoggerFactory.getLogger(com.shubham.bbps.controller.IndexController.class);
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping
	public String sayHello() {
		LOGGER.info("inside IndexController");
		System.out.println(this.bCryptPasswordEncoder.encode("SH11080wTri4v2NOVdobjYPCTd3keQD415000.0"));
		System.out.println(this.bCryptPasswordEncoder.encode("SH11080wTri4v2NOVdobjYPCTd3keQD40.0"));
		System.out.println(this.bCryptPasswordEncoder.encode("SH11050wTri4v2NOVdobjYPCTd3keQD40.0"));
		System.out.println(this.bCryptPasswordEncoder.encode("SH11050wTri4v2NOVdobjYPCTd3keQD43000.0"));
		System.out.println(this.bCryptPasswordEncoder.encode("SH11060wTri4v2NOVdobjYPCTd3keQD40.0"));
		System.out.println(this.bCryptPasswordEncoder.encode("SH11060wTri4v2NOVdobjYPCTd3keQD41000.0"));
		System.out.println(this.bCryptPasswordEncoder.encode("SH11050wTri4v2NOVdobjYPCTd3keQD490.0"));

		return "Hello and Welcome to the EasyNotes application. You can create a new Note by making a POST request to /api/notes endpoint.";
	}
}
