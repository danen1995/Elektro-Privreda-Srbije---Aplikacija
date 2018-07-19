package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.klase.Racun;

@Repository
public interface RacunRepository extends JpaRepository<Racun, Integer> {
	
	@Query("SELECT r FROM Racun r INNER JOIN Potrosac p on r.idPotrosaca=p.idPotrosaca WHERE r.idPotrosaca = ?1")
	public List<Racun> vratiRacuneZaPotrosaca(BigDecimal idPotrosaca);
}
