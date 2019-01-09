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
@Table(name = "khuvuc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Khuvuc.findAll", query = "SELECT k FROM Khuvuc k")
    , @NamedQuery(name = "Khuvuc.findByMaKhuVuc", query = "SELECT k FROM Khuvuc k WHERE k.maKhuVuc = :maKhuVuc")
    , @NamedQuery(name = "Khuvuc.findByTenKhuVuc", query = "SELECT k FROM Khuvuc k WHERE k.tenKhuVuc = :tenKhuVuc")})
public class Khuvuc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaKhuVuc")
    private String maKhuVuc;
    @Basic(optional = false)
    @Column(name = "TenKhuVuc")
    private String tenKhuVuc;

    public Khuvuc() {
    }

    public Khuvuc(String maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
    }

    public Khuvuc(String maKhuVuc, String tenKhuVuc) {
        this.maKhuVuc = maKhuVuc;
        this.tenKhuVuc = tenKhuVuc;
    }

    public String getMaKhuVuc() {
        return maKhuVuc;
    }

    public void setMaKhuVuc(String maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
    }

    public String getTenKhuVuc() {
        return tenKhuVuc;
    }

    public void setTenKhuVuc(String tenKhuVuc) {
        this.tenKhuVuc = tenKhuVuc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maKhuVuc != null ? maKhuVuc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Khuvuc)) {
            return false;
        }
        Khuvuc other = (Khuvuc) object;
        if ((this.maKhuVuc == null && other.maKhuVuc != null) || (this.maKhuVuc != null && !this.maKhuVuc.equals(other.maKhuVuc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ims.dao.Khuvuc[ maKhuVuc=" + maKhuVuc + " ]";
    }
    
}
