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
@Table(name = "huyen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Huyen.findAll", query = "SELECT h FROM Huyen h")
    , @NamedQuery(name = "Huyen.findByMaHuyen", query = "SELECT h FROM Huyen h WHERE h.maHuyen = :maHuyen")
    , @NamedQuery(name = "Huyen.findByTenHuyen", query = "SELECT h FROM Huyen h WHERE h.tenHuyen = :tenHuyen")})
public class Huyen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaHuyen")
    private String maHuyen;
    @Basic(optional = false)
    @Column(name = "TenHuyen")
    private String tenHuyen;

    public Huyen() {
    }

    public Huyen(String maHuyen) {
        this.maHuyen = maHuyen;
    }

    public Huyen(String maHuyen, String tenHuyen) {
        this.maHuyen = maHuyen;
        this.tenHuyen = tenHuyen;
    }

    public String getMaHuyen() {
        return maHuyen;
    }

    public void setMaHuyen(String maHuyen) {
        this.maHuyen = maHuyen;
    }

    public String getTenHuyen() {
        return tenHuyen;
    }

    public void setTenHuyen(String tenHuyen) {
        this.tenHuyen = tenHuyen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHuyen != null ? maHuyen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Huyen)) {
            return false;
        }
        Huyen other = (Huyen) object;
        if ((this.maHuyen == null && other.maHuyen != null) || (this.maHuyen != null && !this.maHuyen.equals(other.maHuyen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ims.dao.Huyen[ maHuyen=" + maHuyen + " ]";
    }
    
}
