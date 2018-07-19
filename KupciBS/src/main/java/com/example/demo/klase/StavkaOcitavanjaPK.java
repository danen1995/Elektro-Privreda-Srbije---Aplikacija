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
public class StavkaOcitavanjaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_STAVKE_OC")
    private BigInteger idStavkeOc;
    @Basic(optional = false)
    @Column(name = "ID_OCITAVANJA")
    @JsonManagedReference
    private BigInteger idOcitavanja;

    public StavkaOcitavanjaPK() {
    }

    public StavkaOcitavanjaPK(BigInteger idStavkeOc, BigInteger idOcitavanja) {
        this.idStavkeOc = idStavkeOc;
        this.idOcitavanja = idOcitavanja;
    }

    public BigInteger getIdStavkeOc() {
        return idStavkeOc;
    }

    public void setIdStavkeOc(BigInteger idStavkeOc) {
        this.idStavkeOc = idStavkeOc;
    }

    public BigInteger getIdOcitavanja() {
        return idOcitavanja;
    }

    public void setIdOcitavanja(BigInteger idOcitavanja) {
        this.idOcitavanja = idOcitavanja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStavkeOc != null ? idStavkeOc.hashCode() : 0);
        hash += (idOcitavanja != null ? idOcitavanja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StavkaOcitavanjaPK)) {
            return false;
        }
        StavkaOcitavanjaPK other = (StavkaOcitavanjaPK) object;
        if ((this.idStavkeOc == null && other.idStavkeOc != null) || (this.idStavkeOc != null && !this.idStavkeOc.equals(other.idStavkeOc))) {
            return false;
        }
        if ((this.idOcitavanja == null && other.idOcitavanja != null) || (this.idOcitavanja != null && !this.idOcitavanja.equals(other.idOcitavanja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication15.StavkaOcitavanjaPK[ idStavkeOc=" + idStavkeOc + ", idOcitavanja=" + idOcitavanja + " ]";
    }
    
}
