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
@Table(name = "loainhanvien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loainhanvien.findAll", query = "SELECT l FROM Loainhanvien l")
    , @NamedQuery(name = "Loainhanvien.findByMaLoaiNhanVien", query = "SELECT l FROM Loainhanvien l WHERE l.maLoaiNhanVien = :maLoaiNhanVien")
    , @NamedQuery(name = "Loainhanvien.findByTenLoaiNhanVien", query = "SELECT l FROM Loainhanvien l WHERE l.tenLoaiNhanVien = :tenLoaiNhanVien")})
public class Loainhanvien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaLoaiNhanVien")
    private String maLoaiNhanVien;
    @Basic(optional = false)
    @Column(name = "TenLoaiNhanVien")
    private String tenLoaiNhanVien;

    public Loainhanvien() {
    }

    public Loainhanvien(String maLoaiNhanVien) {
        this.maLoaiNhanVien = maLoaiNhanVien;
    }

    public Loainhanvien(String maLoaiNhanVien, String tenLoaiNhanVien) {
        this.maLoaiNhanVien = maLoaiNhanVien;
        this.tenLoaiNhanVien = tenLoaiNhanVien;
    }

    public String getMaLoaiNhanVien() {
        return maLoaiNhanVien;
    }

    public void setMaLoaiNhanVien(String maLoaiNhanVien) {
        this.maLoaiNhanVien = maLoaiNhanVien;
    }

    public String getTenLoaiNhanVien() {
        return tenLoaiNhanVien;
    }

    public void setTenLoaiNhanVien(String tenLoaiNhanVien) {
        this.tenLoaiNhanVien = tenLoaiNhanVien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maLoaiNhanVien != null ? maLoaiNhanVien.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loainhanvien)) {
            return false;
        }
        Loainhanvien other = (Loainhanvien) object;
        if ((this.maLoaiNhanVien == null && other.maLoaiNhanVien != null) || (this.maLoaiNhanVien != null && !this.maLoaiNhanVien.equals(other.maLoaiNhanVien))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ims.dao.Loainhanvien[ maLoaiNhanVien=" + maLoaiNhanVien + " ]";
    }
    
}
