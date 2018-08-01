package com.example.demo.controller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.klase.*;

import com.example.demo.repository.KorisnikRepository;
import com.example.demo.repository.KupacRepository;
import com.example.demo.repository.PotrosacRepository;
import com.example.demo.repository.RacunRepository;
import com.example.demo.repository.StavkaRacunaRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



@RestController
public class Controller {
	
	  @Autowired
	  KorisnikRepository korisnikRepository;
	  @Autowired
	  PotrosacRepository potrosacRepository;
	  @Autowired
	  KupacRepository kupacRepository;
	  @Autowired
	  RacunRepository racunRepository;
	  @Autowired
	  StavkaRacunaRepository stavkaRacunaRepository;
	  

	  @GetMapping("/logovanje")
	  public @ResponseBody Korisnik logovanje(@RequestParam(value="user") String user, @RequestParam(value = "pass") String pass) {
		  return korisnikRepository.logovanje(user, pass);
	  }
	  
	  @GetMapping("/vratiSvePotrosace")
	  public @ResponseBody List<Potrosac> vratiSvePotrosace() {
		  return potrosacRepository.vratiSvePotrosace();
	  }
	  
		
	  @GetMapping("/osnovniPodaci")
	  public @ResponseBody Kupac vratiOsnovnePodatkeKorisnika(@RequestParam(value="korID") BigDecimal korID) {
		  return kupacRepository.vratiOsnovnePodatke(korID);
	  }
	
	  @GetMapping("/vratiPotrosaceZaKupca")
	  public @ResponseBody List<Potrosac> vratiPotrosaceZaKupca(@RequestParam(value="idKupca") BigDecimal idKupca) {
		  return potrosacRepository.vratiPotrosaceZaKupca(idKupca);
	  }
	  
	  @GetMapping("/vratiRacuneZaPotrosaca")
	  public @ResponseBody List<Racun> vratiRacuneZaPotrosaca(@RequestParam(value="idPotrosaca") BigDecimal idPotrosaca) {
		  return racunRepository.vratiRacuneZaPotrosaca(idPotrosaca);
	  }
	  
	  @GetMapping("/vratiSveRacune")
	  public @ResponseBody List<Racun> vratiSveRacune() {
		  return racunRepository.findAll();
	  }
	  
	  @GetMapping("/vratiSveStavkeRacuna")
	  public @ResponseBody List<StavkaRacuna> vratiSveStavkeRacuna(@RequestParam(value="idRacuna") BigDecimal idRacuna) {
		  return stavkaRacunaRepository.vratiStavkeRacuna(idRacuna);
	  }
	  
	  @GetMapping("/korisnici")
	  public @ResponseBody List<Korisnik> korisnici() {
		  return korisnikRepository.findAll();
	  }
	  
	  @PostMapping("/registracija")
	  public @ResponseBody Korisnik registrujKorisnika(@RequestBody String str) {
		  Gson gson = new GsonBuilder().create();
	      Korisnik korisnik = gson.fromJson(str, Korisnik.class);
		  return korisnikRepository.save(korisnik);
	  }
	  
	  @GetMapping("/daLiVecPostojiKorisnikZaEdBb")
	  public @ResponseBody Korisnik registracijaBrojila(@RequestParam(value="brojBrojila") BigDecimal brojBrojila, @RequestParam(value = "edBroj") String edBroj) {
		  return korisnikRepository.registracijaBrojila(brojBrojila, edBroj);
	  }
	  
		@GetMapping("/vratiPdf")
		public @ResponseBody String vratiPdf(@RequestParam(value = "idRacuna") BigDecimal idRacuna) throws SQLException, IOException {
			
			Blob racun = racunRepository.vratiPdf(idRacuna);
			//InputStream in = racun.getBinaryStream();
			int len = (int) racun.length();
			byte[] bytes = racun.getBytes(1l, len);
			File fajl = new File("racun.pdf");
			fajl.createNewFile();
			FileOutputStream fos = new FileOutputStream("racun.pdf", false);
			fos.write(bytes);
			//uspesno napuni fajl
			//ne znam kako da ga konvertujemo u json
			Gson gson = new GsonBuilder().create();
			String jsonInString = gson.toJson(bytes);
			System.out.println(jsonInString);
			return jsonInString;

		}
		
		@GetMapping("/vratiKupcaZaEdBb")
		  public @ResponseBody Kupac vratiKupcaZaEdBrojiBrojBrojila(@RequestParam(value = "edBroj") String edBroj,@RequestParam(value="brojBrojila") BigDecimal brojBrojila) {
			  return kupacRepository.vratiKupcaZaEdBrojiBrojBrojila(edBroj,brojBrojila);
		  }
		
		@GetMapping("/potrosacEdBr")
		  public @ResponseBody Potrosac vratiPotrosacaZaEdBrojIBrojBrojila(@RequestParam(value="brojBrojila") BigDecimal brojBrojila, @RequestParam(value = "edBroj") String edBroj) {
			  return potrosacRepository.vratiPotrosacaZaEdIBr(brojBrojila, edBroj);
		  }
}