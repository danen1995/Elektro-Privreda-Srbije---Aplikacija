/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.klase;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author Dane
 */
@Embeddable
public class StavkaRacunaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_STAVKE_RACUNA")
    private BigInteger idStavkeRacuna;
    @Basic(optional = false)
    @Column(name = "ID_RACUNA")
    @JsonManagedReference
    private BigInteger idRacuna;

    public StavkaRacunaPK() {
    }

    public StavkaRacunaPK(BigInteger idStavkeRacuna, BigInteger idRacuna) {
        this.idStavkeRacuna = idStavkeRacuna;
        this.idRacuna = idRacuna;
    }

    public BigInteger getIdStavkeRacuna() {
        return idStavkeRacuna;
    }

    public void setIdStavkeRacuna(BigInteger idStavkeRacuna) {
        this.idStavkeRacuna = idStavkeRacuna;
    }

    public BigInteger getIdRacuna() {
        return idRacuna;
    }

    public void setIdRacuna(BigInteger idRacuna) {
        this.idRacuna = idRacuna;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStavkeRacuna != null ? idStavkeRacuna.hashCode() : 0);
        hash += (idRacuna != null ? idRacuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StavkaRacunaPK)) {
            return false;
        }
        StavkaRacunaPK other = (StavkaRacunaPK) object;
        if ((this.idStavkeRacuna == null && other.idStavkeRacuna != null) || (this.idStavkeRacuna != null && !this.idStavkeRacuna.equals(other.idStavkeRacuna))) {
            return false;
        }
        if ((this.idRacuna == null && other.idRacuna != null) || (this.idRacuna != null && !this.idRacuna.equals(other.idRacuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication15.StavkaRacunaPK[ idStavkeRacuna=" + idStavkeRacuna + ", idRacuna=" + idRacuna + " ]";
    }
    
}
