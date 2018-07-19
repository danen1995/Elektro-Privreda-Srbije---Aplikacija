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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author Dane
 */
@Entity
@Table(name = "MESTO_MERENJA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MestoMerenja.findAll", query = "SELECT m FROM MestoMerenja m"),
    @NamedQuery(name = "MestoMerenja.findByIdMm", query = "SELECT m FROM MestoMerenja m WHERE m.idMm = :idMm"),
    @NamedQuery(name = "MestoMerenja.findByBrBrojila", query = "SELECT m FROM MestoMerenja m WHERE m.brBrojila = :brBrojila"),
    @NamedQuery(name = "MestoMerenja.findByObracunskaSnaga", query = "SELECT m FROM MestoMerenja m WHERE m.obracunskaSnaga = :obracunskaSnaga")})
public class MestoMerenja implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_MM")
    private BigDecimal idMm;
    @Basic(optional = false)
    @Column(name = "BR_BROJILA")
    private BigInteger brBrojila;
    @Basic(optional = false)
    @Column(name = "OBRACUNSKA_SNAGA")
    private BigInteger obracunskaSnaga;
    @OneToMany(mappedBy = "idMm")
    @JsonBackReference
    private Collection<Ocitavanje> ocitavanjeCollection;
    @JoinColumn(name = "ID_ADRESE_MM", referencedColumnName = "ID_ADRESE")
    @ManyToOne
    private Adresa idAdreseMm;
    @JoinColumn(name = "ID_POTROSACA", referencedColumnName = "ID_POTROSACA")
    @ManyToOne
    @JsonManagedReference
    private Potrosac idPotrosaca;

    public MestoMerenja() {
    }

    public MestoMerenja(BigDecimal idMm) {
        this.idMm = idMm;
    }

    public MestoMerenja(BigDecimal idMm, BigInteger brBrojila, BigInteger obracunskaSnaga) {
        this.idMm = idMm;
        this.brBrojila = brBrojila;
        this.obracunskaSnaga = obracunskaSnaga;
    }

    public BigDecimal getIdMm() {
        return idMm;
    }

    public void setIdMm(BigDecimal idMm) {
        this.idMm = idMm;
    }

    public BigInteger getBrBrojila() {
        return brBrojila;
    }

    public void setBrBrojila(BigInteger brBrojila) {
        this.brBrojila = brBrojila;
    }

    public BigInteger getObracunskaSnaga() {
        return obracunskaSnaga;
    }

    public void setObracunskaSnaga(BigInteger obracunskaSnaga) {
        this.obracunskaSnaga = obracunskaSnaga;
    }

    @XmlTransient
    public Collection<Ocitavanje> getOcitavanjeCollection() {
        return ocitavanjeCollection;
    }

    public void setOcitavanjeCollection(Collection<Ocitavanje> ocitavanjeCollection) {
        this.ocitavanjeCollection = ocitavanjeCollection;
    }

    public Adresa getIdAdreseMm() {
        return idAdreseMm;
    }

    public void setIdAdreseMm(Adresa idAdreseMm) {
        this.idAdreseMm = idAdreseMm;
    }

    public Potrosac getIdPotrosaca() {
        return idPotrosaca;
    }

    public void setIdPotrosaca(Potrosac idPotrosaca) {
        this.idPotrosaca = idPotrosaca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMm != null ? idMm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MestoMerenja)) {
            return false;
        }
        MestoMerenja other = (MestoMerenja) object;
        if ((this.idMm == null && other.idMm != null) || (this.idMm != null && !this.idMm.equals(other.idMm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication15.MestoMerenja[ idMm=" + idMm + " ]";
    }
    
}
