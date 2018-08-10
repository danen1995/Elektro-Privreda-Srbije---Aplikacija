package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.klase.Uplata;



@Repository
public interface UplataRepository extends JpaRepository<Uplata, Integer> {
	
	@Query("SELECT u FROM Uplata u WHERE u.idRacuna.idRacuna = ?1")
	public List<Uplata> vratiUplateRacuna(BigDecimal idRacuna);

}
