/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.dao;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "loaihopdong")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loaihopdong.findAll", query = "SELECT l FROM Loaihopdong l")
    , @NamedQuery(name = "Loaihopdong.findByMaLoaiHopDong", query = "SELECT l FROM Loaihopdong l WHERE l.maLoaiHopDong = :maLoaiHopDong")
    , @NamedQuery(name = "Loaihopdong.findByTenHopDong", query = "SELECT l FROM Loaihopdong l WHERE l.tenHopDong = :tenHopDong")
    , @NamedQuery(name = "Loaihopdong.findByNgayBatDau", query = "SELECT l FROM Loaihopdong l WHERE l.ngayBatDau = :ngayBatDau")
    , @NamedQuery(name = "Loaihopdong.findByNgayKetThuc", query = "SELECT l FROM Loaihopdong l WHERE l.ngayKetThuc = :ngayKetThuc")})
public class Loaihopdong implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaLoaiHopDong")
    private String maLoaiHopDong;
    @Basic(optional = false)
    @Column(name = "TenHopDong")
    private String tenHopDong;
    @Basic(optional = false)
    @Column(name = "NgayBatDau")
    @Temporal(TemporalType.DATE)
    private Date ngayBatDau;
    @Basic(optional = false)
    @Column(name = "NgayKetThuc")
    @Temporal(TemporalType.DATE)
    private Date ngayKetThuc;

    public Loaihopdong() {
    }

    public Loaihopdong(String maLoaiHopDong) {
        this.maLoaiHopDong = maLoaiHopDong;
    }

    public Loaihopdong(String maLoaiHopDong, String tenHopDong, Date ngayBatDau, Date ngayKetThuc) {
        this.maLoaiHopDong = maLoaiHopDong;
        this.tenHopDong = tenHopDong;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMaLoaiHopDong() {
        return maLoaiHopDong;
    }

    public void setMaLoaiHopDong(String maLoaiHopDong) {
        this.maLoaiHopDong = maLoaiHopDong;
    }

    public String getTenHopDong() {
        return tenHopDong;
    }

    public void setTenHopDong(String tenHopDong) {
        this.tenHopDong = tenHopDong;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maLoaiHopDong != null ? maLoaiHopDong.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loaihopdong)) {
            return false;
        }
        Loaihopdong other = (Loaihopdong) object;
        if ((this.maLoaiHopDong == null && other.maLoaiHopDong != null) || (this.maLoaiHopDong != null && !this.maLoaiHopDong.equals(other.maLoaiHopDong))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ims.dao.Loaihopdong[ maLoaiHopDong=" + maLoaiHopDong + " ]";
    }
    
}
