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
@Table(name = "phong_tt_cn")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PhongTtCn.findAll", query = "SELECT p FROM PhongTtCn p")
    , @NamedQuery(name = "PhongTtCn.findByMaPhongCN", query = "SELECT p FROM PhongTtCn p WHERE p.maPhongCN = :maPhongCN")
    , @NamedQuery(name = "PhongTtCn.findByTenPhongCN", query = "SELECT p FROM PhongTtCn p WHERE p.tenPhongCN = :tenPhongCN")
    , @NamedQuery(name = "PhongTtCn.findByMaPhuThuoc", query = "SELECT p FROM PhongTtCn p WHERE p.maPhuThuoc = :maPhuThuoc")})
public class PhongTtCn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaPhongCN")
    private Integer maPhongCN;
    @Basic(optional = false)
    @Column(name = "TenPhongCN")
    private String tenPhongCN;
    @Basic(optional = false)
    @Column(name = "MaPhuThuoc")
    private int maPhuThuoc;

    public PhongTtCn() {
    }

    public PhongTtCn(Integer maPhongCN) {
        this.maPhongCN = maPhongCN;
    }

    public PhongTtCn(Integer maPhongCN, String tenPhongCN, int maPhuThuoc) {
        this.maPhongCN = maPhongCN;
        this.tenPhongCN = tenPhongCN;
        this.maPhuThuoc = maPhuThuoc;
    }

    public Integer getMaPhongCN() {
        return maPhongCN;
    }

    public void setMaPhongCN(Integer maPhongCN) {
        this.maPhongCN = maPhongCN;
    }

    public String getTenPhongCN() {
        return tenPhongCN;
    }

    public void setTenPhongCN(String tenPhongCN) {
        this.tenPhongCN = tenPhongCN;
    }

    public int getMaPhuThuoc() {
        return maPhuThuoc;
    }

    public void setMaPhuThuoc(int maPhuThuoc) {
        this.maPhuThuoc = maPhuThuoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maPhongCN != null ? maPhongCN.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PhongTtCn)) {
            return false;
        }
        PhongTtCn other = (PhongTtCn) object;
        if ((this.maPhongCN == null && other.maPhongCN != null) || (this.maPhongCN != null && !this.maPhongCN.equals(other.maPhongCN))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ims.dao.PhongTtCn[ maPhongCN=" + maPhongCN + " ]";
    }
    
}
