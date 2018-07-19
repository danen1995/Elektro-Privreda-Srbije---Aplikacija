package com.example.demo.repository;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.klase.*;

@Repository
public interface PotrosacRepository extends JpaRepository<Potrosac, Integer> {
	

	public List<Potrosac> vratiSvePotrosace();
	
	@Query("SELECT p from Potrosac p INNER JOIN Kupac k ON p.idKupca = k.idKupca WHERE k.idKupca =?1")
	public List<Potrosac> vratiPotrosaceZaKupca(BigDecimal idKupca);
}