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
@Table(name = "KESZLET")
@NamedQueries({
    @NamedQuery(name = "Keszlet.findAll", query = "SELECT k FROM Keszlet k order by k.termekKod"),
    @NamedQuery(name = "Keszlet.findByTermekKod", query = "SELECT k FROM Keszlet k WHERE k.termekKod = :termekKod"),
    @NamedQuery(name = "Keszlet.findByTermekNev", query = "SELECT k FROM Keszlet k WHERE k.termekNev = :termekNev"),
    @NamedQuery(name = "Keszlet.findByBeszerzesiAr", query = "SELECT k FROM Keszlet k WHERE k.beszerzesiAr = :beszerzesiAr"),
    @NamedQuery(name = "Keszlet.findByEladasiAr", query = "SELECT k FROM Keszlet k WHERE k.eladasiAr = :eladasiAr"),
    @NamedQuery(name = "Keszlet.findByMennyisegEgysege", query = "SELECT k FROM Keszlet k WHERE k.mennyisegEgysege = :mennyisegEgysege"),
    @NamedQuery(name = "Keszlet.findByMennyiseg", query = "SELECT k FROM Keszlet k WHERE k.mennyiseg = :mennyiseg")})
public class Keszlet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "TERMEK_KOD")
    private Integer termekKod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TERMEK_NEV")
    private String termekNev;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BESZERZESI_AR")
    private double beszerzesiAr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ELADASI_AR")
    private double eladasiAr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "MENNYISEG_EGYSEGE")
    private String mennyisegEgysege;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MENNYISEG")
    private int mennyiseg;

    public Keszlet() {
    }

    public Keszlet(Integer termekKod) {
        this.termekKod = termekKod;
    }

    public Keszlet(Integer termekKod, String termekNev, double beszerzesiAr, double eladasiAr, String mennyisegEgysege, int mennyiseg) {
        this.termekKod = termekKod;
        this.termekNev = termekNev;
        this.beszerzesiAr = beszerzesiAr;
        this.eladasiAr = eladasiAr;
        this.mennyisegEgysege = mennyisegEgysege;
        this.mennyiseg = mennyiseg;
    }

    public Integer getTermekKod() {
        return termekKod;
    }

    public void setTermekKod(Integer termekKod) {
        this.termekKod = termekKod;
    }

    public String getTermekNev() {
        return termekNev;
    }

    public void setTermekNev(String termekNev) {
        this.termekNev = termekNev;
    }

    public double getBeszerzesiAr() {
        return beszerzesiAr;
    }

    public void setBeszerzesiAr(double beszerzesiAr) {
        this.beszerzesiAr = beszerzesiAr;
    }

    public double getEladasiAr() {
        return eladasiAr;
    }

    public void setEladasiAr(double eladasiAr) {
        this.eladasiAr = eladasiAr;
    }

    public String getMennyisegEgysege() {
        return mennyisegEgysege;
    }

    public void setMennyisegEgysege(String mennyisegEgysege) {
        this.mennyisegEgysege = mennyisegEgysege;
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
        hash += (termekKod != null ? termekKod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Keszlet)) {
            return false;
        }
        Keszlet other = (Keszlet) object;
        if ((this.termekKod == null && other.termekKod != null) || (this.termekKod != null && !this.termekKod.equals(other.termekKod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "myentities.Keszlet[ termekKod=" + termekKod + " ]";
    }
    
}
