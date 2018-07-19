/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.klase;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author Dane
 */
@Entity
@Table(name = "POTROSAC")
@XmlRootElement
@NamedQueries({ 
		@NamedQuery(name = "Potrosac.vratiSvePotrosace", query = "SELECT p FROM Potrosac p"),
		@NamedQuery(name = "Potrosac.vratiPotrosaceZaKupca", query = "SELECT p from Potrosac p INNER JOIN Kupac k ON p.idKupca = k.idKupca WHERE k.idKupca =?1"),
		@NamedQuery(name = "Potrosac.findAll", query = "SELECT p FROM Potrosac p"),
		@NamedQuery(name = "Potrosac.findByIdPotrosaca", query = "SELECT p FROM Potrosac p WHERE p.idPotrosaca = :idPotrosaca"),
		@NamedQuery(name = "Potrosac.findByEdBroj", query = "SELECT p FROM Potrosac p WHERE p.edBroj = :edBroj"),
		@NamedQuery(name = "Potrosac.findByKategorijaPotrosnje", query = "SELECT p FROM Potrosac p WHERE p.kategorijaPotrosnje = :kategorijaPotrosnje"),
		@NamedQuery(name = "Potrosac.findByOdobrenaSnaga", query = "SELECT p FROM Potrosac p WHERE p.odobrenaSnaga = :odobrenaSnaga"),
		@NamedQuery(name = "Potrosac.findByVrstaSnabdevanja", query = "SELECT p FROM Potrosac p WHERE p.vrstaSnabdevanja = :vrstaSnabdevanja") })
public class Potrosac implements Serializable {

	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@Column(name = "ID_POTROSACA")
	private BigDecimal idPotrosaca;
	@Basic(optional = false)
	@Column(name = "ED_BROJ")
	private String edBroj;
	@Column(name = "KATEGORIJA_POTROSNJE")
	private String kategorijaPotrosnje;
	@Column(name = "ODOBRENA_SNAGA")
	private BigDecimal odobrenaSnaga;
	@Column(name = "VRSTA_SNABDEVANJA")
	private String vrstaSnabdevanja;
	@JoinColumn(name = "ID_ADRESE_MM", referencedColumnName = "ID_ADRESE")
	@ManyToOne
	@JsonManagedReference
	private Adresa idAdreseMm;
	@JoinColumn(name = "ID_KUPCA", referencedColumnName = "ID_KUPCA")
	@ManyToOne
	@JsonManagedReference
	private Kupac idKupca;

	public Potrosac() {
	}

	public Potrosac(BigDecimal idPotrosaca) {
		this.idPotrosaca = idPotrosaca;
	}

	public Potrosac(BigDecimal idPotrosaca, String edBroj) {
		this.idPotrosaca = idPotrosaca;
		this.edBroj = edBroj;
	}

	public BigDecimal getIdPotrosaca() {
		return idPotrosaca;
	}

	public void setIdPotrosaca(BigDecimal idPotrosaca) {
		this.idPotrosaca = idPotrosaca;
	}

	public String getEdBroj() {
		return edBroj;
	}

	public void setEdBroj(String edBroj) {
		this.edBroj = edBroj;
	}

	public String getKategorijaPotrosnje() {
		return kategorijaPotrosnje;
	}

	public void setKategorijaPotrosnje(String kategorijaPotrosnje) {
		this.kategorijaPotrosnje = kategorijaPotrosnje;
	}

	public BigDecimal getOdobrenaSnaga() {
		return odobrenaSnaga;
	}

	public void setOdobrenaSnaga(BigDecimal odobrenaSnaga) {
		this.odobrenaSnaga = odobrenaSnaga;
	}

	public String getVrstaSnabdevanja() {
		return vrstaSnabdevanja;
	}

	public void setVrstaSnabdevanja(String vrstaSnabdevanja) {
		this.vrstaSnabdevanja = vrstaSnabdevanja;
	}

	public Adresa getIdAdreseMm() {
		return idAdreseMm;
	}

	public void setIdAdreseMm(Adresa idAdreseMm) {
		this.idAdreseMm = idAdreseMm;
	}

	public Kupac getIdKupca() {
		return idKupca;
	}

	public void setIdKupca(Kupac idKupca) {
		this.idKupca = idKupca;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idPotrosaca != null ? idPotrosaca.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Potrosac)) {
			return false;
		}
		Potrosac other = (Potrosac) object;
		if ((this.idPotrosaca == null && other.idPotrosaca != null)
				|| (this.idPotrosaca != null && !this.idPotrosaca.equals(other.idPotrosaca))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "klase.Potrosac[ idPotrosaca=" + idPotrosaca + " ]";
	}

}
