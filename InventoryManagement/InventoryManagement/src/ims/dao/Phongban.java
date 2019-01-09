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
@Table(name = "phongban")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phongban.findAll", query = "SELECT p FROM Phongban p")
    , @NamedQuery(name = "Phongban.findByMaPhongBan", query = "SELECT p FROM Phongban p WHERE p.maPhongBan = :maPhongBan")
    , @NamedQuery(name = "Phongban.findByTenPhongBan", query = "SELECT p FROM Phongban p WHERE p.tenPhongBan = :tenPhongBan")})
public class Phongban implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaPhongBan")
    private Integer maPhongBan;
    @Basic(optional = false)
    @Column(name = "TenPhongBan")
    private String tenPhongBan;

    public Phongban() {
    }

    public Phongban(Integer maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    public Phongban(Integer maPhongBan, String tenPhongBan) {
        this.maPhongBan = maPhongBan;
        this.tenPhongBan = tenPhongBan;
    }

    public Integer getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(Integer maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maPhongBan != null ? maPhongBan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phongban)) {
            return false;
        }
        Phongban other = (Phongban) object;
        if ((this.maPhongBan == null && other.maPhongBan != null) || (this.maPhongBan != null && !this.maPhongBan.equals(other.maPhongBan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ims.dao.Phongban[ maPhongBan=" + maPhongBan + " ]";
    }
    
}
