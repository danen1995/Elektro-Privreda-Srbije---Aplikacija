package com.example.demo.repository;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.klase.*;

@Repository
public interface StavkaOcitavanjaRepository extends JpaRepository<StavkaOcitavanja, Integer>{

	@Query("SELECT s FROM StavkaOcitavanja s WHERE s.ocitavanje.idOcitavanja = ?1 ORDER BY s.idTarife.idTarife")
	public List<StavkaOcitavanja> vratiStavkeOcitavanja(BigDecimal idOcitavanja);
}
