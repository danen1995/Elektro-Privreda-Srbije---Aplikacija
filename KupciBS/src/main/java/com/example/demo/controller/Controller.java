package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.klase.*;

import com.example.demo.repository.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
public class Controller {

	@Autowired
	private KorisnikRepository korisnikRepository;
	@Autowired
	private PotrosacRepository potrosacRepository;
	@Autowired
	private KupacRepository kupacRepository;
	@Autowired
	private RacunRepository racunRepository;
	@Autowired
	private StavkaRacunaRepository stavkaRacunaRepository;
	@Autowired
	private MestoMerenjaRepository mestoMerenjaRepository;
	@Autowired
	private StavkaOcitavanjaRepository stavkaOcitavanjaRepository;
	@Autowired
	private TarifaRepository tarifaRepository;

	@PostMapping("/logovanje")
	public @ResponseBody Wrapper<Korisnik> logovanje(@RequestParam(value = "user") String user,
			@RequestParam(value = "pass") String pass) {
		Wrapper<Korisnik> wrapper;
		Korisnik korisnik = korisnikRepository.logovanje(user, pass);
		if (korisnik == null) {
			korisnik = korisnikRepository.postoji(user);
			if (korisnik == null) {
				wrapper = new Wrapper<Korisnik>(Wrapper.USER_NOT_FOUND, "Korisnik sa nalogom " + user + " ne postoji.",
						null);
			} else
				wrapper = new Wrapper<Korisnik>(Wrapper.USER_PASSWORD_DOES_NOT_MATCH, "Pogresna lozinka.", korisnik);
		} else
			wrapper = new Wrapper<Korisnik>(Wrapper.USER_AUTHENTICATED, "", korisnik);

		return wrapper;
	}

	@GetMapping("/vratiSvePotrosace")
	public @ResponseBody List<Potrosac> vratiSvePotrosace() {
		return potrosacRepository.vratiSvePotrosace();
	}

	@GetMapping("/osnovniPodaci")
	public @ResponseBody Kupac vratiOsnovnePodatkeKorisnika(@RequestParam(value = "korID") BigDecimal korID) {
		return kupacRepository.vratiOsnovnePodatke(korID);
	}

	@GetMapping("/vratiPotrosaceZaKupca")
	public @ResponseBody List<Potrosac> vratiPotrosaceZaKupca(@RequestParam(value = "idKupca") BigDecimal idKupca) {
		List<Potrosac> potrosaci = potrosacRepository.vratiPotrosaceZaKupca(idKupca);
		if (potrosaci.get(0).getIdAdreseMm() == null)
			System.out.println("Adress null");
		return potrosaci;
	}

	@GetMapping("/vratiRacuneZaPotrosaca")
	public @ResponseBody List<Racun> vratiRacuneZaPotrosaca(
			@RequestParam(value = "idPotrosaca") BigDecimal idPotrosaca) {
		return racunRepository.vratiRacuneZaPotrosaca(idPotrosaca);
	}

	@GetMapping("/vratiSveRacune")
	public @ResponseBody List<Racun> vratiSveRacune() {
		return racunRepository.findAll();
	}

	@GetMapping("/vratiStavkeRacuna")
	public @ResponseBody List<StavkaRacuna> vratiStavkeRacuna(
			@RequestParam(value = "idRacuna") BigDecimal idRacuna) {
		return stavkaRacunaRepository.vratiStavkeRacuna(idRacuna);
	}

	@PostMapping("/registracija")
	public @ResponseBody Korisnik registrujKorisnika(@RequestBody Korisnik korisnik) {
		korisnik.setIdKorisnika(BigDecimal.ZERO);
		return korisnikRepository.save(korisnik);

	}

	@GetMapping("/registracijaBrojila")
	public @ResponseBody Korisnik registracijaBrojila(@RequestParam(value = "brojBrojila") BigDecimal brojBrojila,
			@RequestParam(value = "edBroj") String edBroj) {
		return korisnikRepository.registracijaBrojila(brojBrojila, edBroj);
	}

	@GetMapping("/vratiPdf")
	public ResponseEntity<byte[]> vratiPdf(@RequestParam(value = "idRacuna") BigDecimal idRacuna) {
		Blob racun = racunRepository.vratiPdf(idRacuna);
		byte[] contents;
		ResponseEntity<byte[]> response = null;
		try {
			contents = racun.getBytes(1, (int) racun.length());
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.parseMediaType("application/png")); // application/pdf
			String filename = "output.png";
			headers.setContentDispositionFormData(filename, filename);
			headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
			response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return response;
	}

	@GetMapping("/vratiKupcaZaEdBb")
	public @ResponseBody Wrapper<Kupac> vratiKupcaZaEdBrojiBrojBrojila(@RequestParam(value = "edBroj") String edBroj,
			@RequestParam(value = "brojBrojila") BigDecimal brojBrojila) {
		Wrapper<Kupac> wrapper;
		Kupac kupac = kupacRepository.vratiKupcaZaEdBrojiBrojBrojila(edBroj, brojBrojila);
		if (kupac == null)
			wrapper = new Wrapper<Kupac>(Wrapper.BUYER_INVALID,
					"Ne postoji kupac sa unetom kombinacijom ED broja i broja brojila.", null);
		else {
			Korisnik korisnik = korisnikRepository.vratiKorisnikaZaKupca(kupac);
			if (korisnik == null)
				wrapper = new Wrapper<Kupac>(Wrapper.BUYER_WITHOUT_ACCOUNT, "", kupac);
			else
				wrapper = new Wrapper<Kupac>(Wrapper.BUYER_HAS_ACCOUNT, "", kupac);
		}
		return wrapper;
	}

	@GetMapping("/vratiMestoMerenjaZaPotrosaca")
	public @ResponseBody MestoMerenja vratiMestoMerenjaZaPotrosaca(
			@RequestParam(value = "idPotrosaca") BigDecimal idPotrosaca) {
		return mestoMerenjaRepository.vratiMestoMerenjaZaPotrosaca(idPotrosaca);
	}
	
	@GetMapping("/vratiStavkeOcitavanja")
	public @ResponseBody List<StavkaOcitavanja> vratiStavkeOcitavanja(
			@RequestParam(value = "idOcitavanja") BigDecimal idOcitavanja) {		
		return stavkaOcitavanjaRepository.vratiStavkeOcitavanja(idOcitavanja);
	}
	
	@GetMapping("/vratiSveTarife")
	public @ResponseBody List<Tarifa> vratiSveTarife() {		
		return tarifaRepository.vratiSveTarife();
	}

}