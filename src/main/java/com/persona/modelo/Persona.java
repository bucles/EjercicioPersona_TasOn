/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persona.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marco
 */
@Entity
@Table(name = "PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByPercedula", query = "SELECT p FROM Persona p WHERE p.percedula = :percedula")
    , @NamedQuery(name = "Persona.findByPernombres", query = "SELECT p FROM Persona p WHERE p.pernombres = :pernombres")
    , @NamedQuery(name = "Persona.findByPerapellidopaterno", query = "SELECT p FROM Persona p WHERE p.perapellidopaterno = :perapellidopaterno")
    , @NamedQuery(name = "Persona.findByPerapellidomaterno", query = "SELECT p FROM Persona p WHERE p.perapellidomaterno = :perapellidomaterno")
    , @NamedQuery(name = "Persona.findByPertelefono", query = "SELECT p FROM Persona p WHERE p.pertelefono = :pertelefono")
    , @NamedQuery(name = "Persona.findByPerestadocivil", query = "SELECT p FROM Persona p WHERE p.perestadocivil = :perestadocivil")
    , @NamedQuery(name = "Persona.findByPergenero", query = "SELECT p FROM Persona p WHERE p.pergenero = :pergenero")
    , @NamedQuery(name = "Persona.findByPernacionalidad", query = "SELECT p FROM Persona p WHERE p.pernacionalidad = :pernacionalidad")
    , @NamedQuery(name = "Persona.findByPerfechanacimiento", query = "SELECT p FROM Persona p WHERE p.perfechanacimiento = :perfechanacimiento")
    , @NamedQuery(name = "Persona.findByPerlugarnacimiento", query = "SELECT p FROM Persona p WHERE p.perlugarnacimiento = :perlugarnacimiento")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERCEDULA")
    private Long percedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PERNOMBRES")
    private String pernombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PERAPELLIDOPATERNO")
    private String perapellidopaterno;
    @Size(max = 100)
    @Column(name = "PERAPELLIDOMATERNO")
    private String perapellidomaterno;
    @Column(name = "PERTELEFONO")
    private Integer pertelefono;
    @Size(max = 40)
    @Column(name = "PERESTADOCIVIL")
    private String perestadocivil;
    @Size(max = 30)
    @Column(name = "PERGENERO")
    private String pergenero;
    @Size(max = 40)
    @Column(name = "PERNACIONALIDAD")
    private String pernacionalidad;
    @Column(name = "PERFECHANACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date perfechanacimiento;
    @Size(max = 100)
    @Column(name = "PERLUGARNACIMIENTO")
    private String perlugarnacimiento;

    public Persona() {
    }

    public Persona(Long percedula) {
        this.percedula = percedula;
    }

    public Persona(Long percedula, String pernombres, String perapellidopaterno) {
        this.percedula = percedula;
        this.pernombres = pernombres;
        this.perapellidopaterno = perapellidopaterno;
    }

    public Long getPercedula() {
        return percedula;
    }

    public void setPercedula(Long percedula) {
        this.percedula = percedula;
    }

    public String getPernombres() {
        return pernombres;
    }

    public void setPernombres(String pernombres) {
        this.pernombres = pernombres;
    }

    public String getPerapellidopaterno() {
        return perapellidopaterno;
    }

    public void setPerapellidopaterno(String perapellidopaterno) {
        this.perapellidopaterno = perapellidopaterno;
    }

    public String getPerapellidomaterno() {
        return perapellidomaterno;
    }

    public void setPerapellidomaterno(String perapellidomaterno) {
        this.perapellidomaterno = perapellidomaterno;
    }

    public Integer getPertelefono() {
        return pertelefono;
    }

    public void setPertelefono(Integer pertelefono) {
        this.pertelefono = pertelefono;
    }

    public String getPerestadocivil() {
        return perestadocivil;
    }

    public void setPerestadocivil(String perestadocivil) {
        this.perestadocivil = perestadocivil;
    }

    public String getPergenero() {
        return pergenero;
    }

    public void setPergenero(String pergenero) {
        this.pergenero = pergenero;
    }

    public String getPernacionalidad() {
        return pernacionalidad;
    }

    public void setPernacionalidad(String pernacionalidad) {
        this.pernacionalidad = pernacionalidad;
    }

    public Date getPerfechanacimiento() {
        return perfechanacimiento;
    }

    public void setPerfechanacimiento(Date perfechanacimiento) {
        this.perfechanacimiento = perfechanacimiento;
    }

    public String getPerlugarnacimiento() {
        return perlugarnacimiento;
    }

    public void setPerlugarnacimiento(String perlugarnacimiento) {
        this.perlugarnacimiento = perlugarnacimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (percedula != null ? percedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.percedula == null && other.percedula != null) || (this.percedula != null && !this.percedula.equals(other.percedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.personaModelo.Persona[ percedula=" + percedula + " ]";
    }
    
}
