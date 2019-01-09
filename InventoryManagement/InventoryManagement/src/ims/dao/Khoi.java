/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "khoi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Khoi.findAll", query = "SELECT k FROM Khoi k")
    , @NamedQuery(name = "Khoi.findByMaKhoi", query = "SELECT k FROM Khoi k WHERE k.maKhoi = :maKhoi")
    , @NamedQuery(name = "Khoi.findByTenKhoi", query = "SELECT k FROM Khoi k WHERE k.tenKhoi = :tenKhoi")})
public class Khoi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaKhoi")
    private String maKhoi;
    @Basic(optional = false)
    @Column(name = "TenKhoi")
    private String tenKhoi;

    public Khoi() {
    }

    public Khoi(String maKhoi) {
        this.maKhoi = maKhoi;
    }

    public Khoi(String maKhoi, String tenKhoi) {
        this.maKhoi = maKhoi;
        this.tenKhoi = tenKhoi;
    }

    public String getMaKhoi() {
        return maKhoi;
    }

    public void setMaKhoi(String maKhoi) {
        this.maKhoi = maKhoi;
    }

    public String getTenKhoi() {
        return tenKhoi;
    }

    public void setTenKhoi(String tenKhoi) {
        this.tenKhoi = tenKhoi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maKhoi != null ? maKhoi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Khoi)) {
            return false;
        }
        Khoi other = (Khoi) object;
        if ((this.maKhoi == null && other.maKhoi != null) || (this.maKhoi != null && !this.maKhoi.equals(other.maKhoi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ims.dao.Khoi[ maKhoi=" + maKhoi + " ]";
    }
    
}
