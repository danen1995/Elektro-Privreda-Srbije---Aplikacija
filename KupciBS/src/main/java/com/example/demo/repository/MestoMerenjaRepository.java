package com.example.demo.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.klase.*;

@Repository
public interface MestoMerenjaRepository extends JpaRepository<MestoMerenja, Integer> {
	
	@Query("SELECT m FROM MestoMerenja m WHERE m.idPotrosaca.idPotrosaca = ?1")
	public MestoMerenja vratiMestoMerenjaZaPotrosaca(BigDecimal idPotrosaca);
}
