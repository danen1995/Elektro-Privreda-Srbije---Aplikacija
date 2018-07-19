/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.klase;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dane
 */
@Entity
@Table(name = "RACUN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Racun.findAll", query = "SELECT r FROM Racun r"),
    @NamedQuery(name = "Racun.findByIdRacuna", query = "SELECT r FROM Racun r WHERE r.idRacuna = :idRacuna"),
    @NamedQuery(name = "Racun.findByDatumIzdavanja", query = "SELECT r FROM Racun r WHERE r.datumIzdavanja = :datumIzdavanja"),
    @NamedQuery(name = "Racun.findByMestoIzdavanja", query = "SELECT r FROM Racun r WHERE r.mestoIzdavanja = :mestoIzdavanja"),
    @NamedQuery(name = "Racun.findByDatumPrometa", query = "SELECT r FROM Racun r WHERE r.datumPrometa = :datumPrometa"),
    @NamedQuery(name = "Racun.findByPozivNaBroj", query = "SELECT r FROM Racun r WHERE r.pozivNaBroj = :pozivNaBroj"),
    @NamedQuery(name = "Racun.findByUkupanIznos", query = "SELECT r FROM Racun r WHERE r.ukupanIznos = :ukupanIznos")})
public class Racun implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_RACUNA")
    private BigDecimal idRacuna;
    @Column(name = "DATUM_IZDAVANJA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumIzdavanja;
    @Column(name = "MESTO_IZDAVANJA")
    private String mestoIzdavanja;
    @Column(name = "DATUM_PROMETA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumPrometa;
    @Column(name = "POZIV_NA_BROJ")
    private String pozivNaBroj;
    @Column(name = "UKUPAN_IZNOS")
    private BigDecimal ukupanIznos;
    @Lob
    @Column(name = "RACUN")
    private Serializable racun;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "racun")
    private Collection<StavkaRacuna> stavkaRacunaCollection;
    @OneToMany(mappedBy = "idRacuna")
    private Collection<Uplata> uplataCollection;
    @JoinColumn(name = "ID_OP", referencedColumnName = "ID_OP")
    @ManyToOne
    private ObracunskiPeriod idOp;
    @JoinColumn(name = "ID_OCITAVANJA", referencedColumnName = "ID_OCITAVANJA")
    @ManyToOne
    private Ocitavanje idOcitavanja;
    @JoinColumn(name = "ID_POTROSACA", referencedColumnName = "ID_POTROSACA")
    @ManyToOne
    private Potrosac idPotrosaca;

    public Racun() {
    }

    public Racun(BigDecimal idRacuna) {
        this.idRacuna = idRacuna;
    }

    public BigDecimal getIdRacuna() {
        return idRacuna;
    }

    public void setIdRacuna(BigDecimal idRacuna) {
        this.idRacuna = idRacuna;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public String getMestoIzdavanja() {
        return mestoIzdavanja;
    }

    public void setMestoIzdavanja(String mestoIzdavanja) {
        this.mestoIzdavanja = mestoIzdavanja;
    }

    public Date getDatumPrometa() {
        return datumPrometa;
    }

    public void setDatumPrometa(Date datumPrometa) {
        this.datumPrometa = datumPrometa;
    }

    public String getPozivNaBroj() {
        return pozivNaBroj;
    }

    public void setPozivNaBroj(String pozivNaBroj) {
        this.pozivNaBroj = pozivNaBroj;
    }

    public BigDecimal getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(BigDecimal ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public Serializable getRacun() {
        return racun;
    }

    public void setRacun(Serializable racun) {
        this.racun = racun;
    }

    @XmlTransient
    public Collection<StavkaRacuna> getStavkaRacunaCollection() {
        return stavkaRacunaCollection;
    }

    public void setStavkaRacunaCollection(Collection<StavkaRacuna> stavkaRacunaCollection) {
        this.stavkaRacunaCollection = stavkaRacunaCollection;
    }

    @XmlTransient
    public Collection<Uplata> getUplataCollection() {
        return uplataCollection;
    }

    public void setUplataCollection(Collection<Uplata> uplataCollection) {
        this.uplataCollection = uplataCollection;
    }

    public ObracunskiPeriod getIdOp() {
        return idOp;
    }

    public void setIdOp(ObracunskiPeriod idOp) {
        this.idOp = idOp;
    }

    public Ocitavanje getIdOcitavanja() {
        return idOcitavanja;
    }

    public void setIdOcitavanja(Ocitavanje idOcitavanja) {
        this.idOcitavanja = idOcitavanja;
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
        hash += (idRacuna != null ? idRacuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Racun)) {
            return false;
        }
        Racun other = (Racun) object;
        if ((this.idRacuna == null && other.idRacuna != null) || (this.idRacuna != null && !this.idRacuna.equals(other.idRacuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication15.Racun[ idRacuna=" + idRacuna + " ]";
    }
    
}
