/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myentities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Balázs
 */
@Entity
@Table(name = "JELENTES")
@NamedQueries({
    @NamedQuery(name = "Jelentes.findAll", query = "SELECT j FROM Jelentes j"),
    @NamedQuery(name = "Jelentes.findBySorszam", query = "SELECT j FROM Jelentes j WHERE j.sorszam = :sorszam"),
    @NamedQuery(name = "Jelentes.findByDatum", query = "SELECT j FROM Jelentes j WHERE j.datum = :datum"),
    @NamedQuery(name = "Jelentes.findByMuvelet", query = "SELECT j FROM Jelentes j WHERE j.muvelet = :muvelet"),
    @NamedQuery(name = "Jelentes.findByTermekKod", query = "SELECT j FROM Jelentes j WHERE j.termekKod = :termekKod"),
    @NamedQuery(name = "Jelentes.findByTermekNev", query = "SELECT j FROM Jelentes j WHERE j.termekNev = :termekNev"),
    @NamedQuery(name = "Jelentes.findByMennyiseg", query = "SELECT j FROM Jelentes j WHERE j.mennyiseg = :mennyiseg")})
public class Jelentes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "SORSZAM")
    private Integer sorszam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DATUM")
    private String datum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MUVELET")
    private String muvelet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TERMEK_KOD")
    private int termekKod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TERMEK_NEV")
    private String termekNev;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MENNYISEG")
    private int mennyiseg;

    public Jelentes() {
    }

    public Jelentes(Integer sorszam) {
        this.sorszam = sorszam;
    }

    public Jelentes(Integer sorszam, String datum, String muvelet, int termekKod, String termekNev, int mennyiseg) {
        this.sorszam = sorszam;
        this.datum = datum;
        this.muvelet = muvelet;
        this.termekKod = termekKod;
        this.termekNev = termekNev;
        this.mennyiseg = mennyiseg;
    }

    public Integer getSorszam() {
        return sorszam;
    }

    public void setSorszam(Integer sorszam) {
        this.sorszam = sorszam;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getMuvelet() {
        return muvelet;
    }

    public void setMuvelet(String muvelet) {
        this.muvelet = muvelet;
    }

    public int getTermekKod() {
        return termekKod;
    }

    public void setTermekKod(int termekKod) {
        this.termekKod = termekKod;
    }

    public String getTermekNev() {
        return termekNev;
    }

    public void setTermekNev(String termekNev) {
        this.termekNev = termekNev;
    }

    public int getMennyiseg() {
        return mennyiseg;
    }

    public void setMennyiseg(int mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sorszam != null ? sorszam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jelentes)) {
            return false;
        }
        Jelentes other = (Jelentes) object;
        if ((this.sorszam == null && other.sorszam != null) || (this.sorszam != null && !this.sorszam.equals(other.sorszam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "myentities.Jelentes[ sorszam=" + sorszam + " ]";
    }
    
}
