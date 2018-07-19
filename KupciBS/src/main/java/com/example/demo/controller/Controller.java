package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.klase.Korisnik;
import com.example.demo.repository.KorisnikRepository;

@RestController
public class Controller {
	
	  @Autowired
	  KorisnikRepository korisnikRepository;

	  @GetMapping("/logovanje")
	  public @ResponseBody Korisnik logovanje(@RequestParam(value="user") String user, @RequestParam(value = "pass") String pass) {
		  return korisnikRepository.logovanje(user, pass);
	  }
	  

}