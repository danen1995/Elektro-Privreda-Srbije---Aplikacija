package com.example.demo.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.klase.Tarifa;


@Repository
public interface TarifaRepository extends JpaRepository<Tarifa, Integer> {
	
	@Query("SELECT t FROM Tarifa t")
	public List<Tarifa> vratiSveTarife();

}
