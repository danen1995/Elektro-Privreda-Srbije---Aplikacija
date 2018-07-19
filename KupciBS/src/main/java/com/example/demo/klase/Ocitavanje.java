/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.klase;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dane
 */
@Entity
@Table(name = "OCITAVANJE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ocitavanje.findAll", query = "SELECT o FROM Ocitavanje o"),
    @NamedQuery(name = "Ocitavanje.findByIdOcitavanja", query = "SELECT o FROM Ocitavanje o WHERE o.idOcitavanja = :idOcitavanja"),
    @NamedQuery(name = "Ocitavanje.findByPrethodnoVt", query = "SELECT o FROM Ocitavanje o WHERE o.prethodnoVt = :prethodnoVt"),
    @NamedQuery(name = "Ocitavanje.findByPrethodnoMt", query = "SELECT o FROM Ocitavanje o WHERE o.prethodnoMt = :prethodnoMt"),
    @NamedQuery(name = "Ocitavanje.findByNovoVt", query = "SELECT o FROM Ocitavanje o WHERE o.novoVt = :novoVt"),
    @NamedQuery(name = "Ocitavanje.findByNovoMt", query = "SELECT o FROM Ocitavanje o WHERE o.novoMt = :novoMt")})
public class Ocitavanje implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_OCITAVANJA")
    private BigDecimal idOcitavanja;
    @Column(name = "PRETHODNO_VT")
    private BigInteger prethodnoVt;
    @Column(name = "PRETHODNO_MT")
    private BigInteger prethodnoMt;
    @Column(name = "NOVO_VT")
    private BigInteger novoVt;
    @Column(name = "NOVO_MT")
    private BigInteger novoMt;
    @JoinColumn(name = "ID_MM", referencedColumnName = "ID_MM")
    @ManyToOne
    private MestoMerenja idMm;
    @OneToMany(mappedBy = "idOcitavanja")
    private Collection<Racun> racunCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ocitavanje")
    private Collection<StavkaOcitavanja> stavkaOcitavanjaCollection;

    public Ocitavanje() {
    }

    public Ocitavanje(BigDecimal idOcitavanja) {
        this.idOcitavanja = idOcitavanja;
    }

    public BigDecimal getIdOcitavanja() {
        return idOcitavanja;
    }

    public void setIdOcitavanja(BigDecimal idOcitavanja) {
        this.idOcitavanja = idOcitavanja;
    }

    public BigInteger getPrethodnoVt() {
        return prethodnoVt;
    }

    public void setPrethodnoVt(BigInteger prethodnoVt) {
        this.prethodnoVt = prethodnoVt;
    }

    public BigInteger getPrethodnoMt() {
        return prethodnoMt;
    }

    public void setPrethodnoMt(BigInteger prethodnoMt) {
        this.prethodnoMt = prethodnoMt;
    }

    public BigInteger getNovoVt() {
        return novoVt;
    }

    public void setNovoVt(BigInteger novoVt) {
        this.novoVt = novoVt;
    }

    public BigInteger getNovoMt() {
        return novoMt;
    }

    public void setNovoMt(BigInteger novoMt) {
        this.novoMt = novoMt;
    }

    public MestoMerenja getIdMm() {
        return idMm;
    }

    public void setIdMm(MestoMerenja idMm) {
        this.idMm = idMm;
    }

    @XmlTransient
    public Collection<Racun> getRacunCollection() {
        return racunCollection;
    }

    public void setRacunCollection(Collection<Racun> racunCollection) {
        this.racunCollection = racunCollection;
    }

    @XmlTransient
    public Collection<StavkaOcitavanja> getStavkaOcitavanjaCollection() {
        return stavkaOcitavanjaCollection;
    }

    public void setStavkaOcitavanjaCollection(Collection<StavkaOcitavanja> stavkaOcitavanjaCollection) {
        this.stavkaOcitavanjaCollection = stavkaOcitavanjaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOcitavanja != null ? idOcitavanja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ocitavanje)) {
            return false;
        }
        Ocitavanje other = (Ocitavanje) object;
        if ((this.idOcitavanja == null && other.idOcitavanja != null) || (this.idOcitavanja != null && !this.idOcitavanja.equals(other.idOcitavanja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication15.Ocitavanje[ idOcitavanja=" + idOcitavanja + " ]";
    }
    
}
