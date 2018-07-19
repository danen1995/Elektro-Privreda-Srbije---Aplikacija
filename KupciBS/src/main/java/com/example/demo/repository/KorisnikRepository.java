package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.klase.Korisnik;
import com.example.demo.klase.Mesto;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {
	
	@Query("SELECT k FROM Korisnik k WHERE k.korisnickoIme = ?1 AND k.lozinka = ?2")
	public Korisnik logovanje(String user, String pass);


}