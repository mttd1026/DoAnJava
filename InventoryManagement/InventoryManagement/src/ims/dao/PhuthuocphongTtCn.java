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
@Table(name = "phuthuocphong_tt_cn")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PhuthuocphongTtCn.findAll", query = "SELECT p FROM PhuthuocphongTtCn p")
    , @NamedQuery(name = "PhuthuocphongTtCn.findByMaPhuThuoc", query = "SELECT p FROM PhuthuocphongTtCn p WHERE p.maPhuThuoc = :maPhuThuoc")
    , @NamedQuery(name = "PhuthuocphongTtCn.findByTenPhuThuoc", query = "SELECT p FROM PhuthuocphongTtCn p WHERE p.tenPhuThuoc = :tenPhuThuoc")})
public class PhuthuocphongTtCn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaPhuThuoc")
    private Integer maPhuThuoc;
    @Basic(optional = false)
    @Column(name = "TenPhuThuoc")
    private String tenPhuThuoc;

    public PhuthuocphongTtCn() {
    }

    public PhuthuocphongTtCn(Integer maPhuThuoc) {
        this.maPhuThuoc = maPhuThuoc;
    }

    public PhuthuocphongTtCn(Integer maPhuThuoc, String tenPhuThuoc) {
        this.maPhuThuoc = maPhuThuoc;
        this.tenPhuThuoc = tenPhuThuoc;
    }

    public Integer getMaPhuThuoc() {
        return maPhuThuoc;
    }

    public void setMaPhuThuoc(Integer maPhuThuoc) {
        this.maPhuThuoc = maPhuThuoc;
    }

    public String getTenPhuThuoc() {
        return tenPhuThuoc;
    }

    public void setTenPhuThuoc(String tenPhuThuoc) {
        this.tenPhuThuoc = tenPhuThuoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maPhuThuoc != null ? maPhuThuoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PhuthuocphongTtCn)) {
            return false;
        }
        PhuthuocphongTtCn other = (PhuthuocphongTtCn) object;
        if ((this.maPhuThuoc == null && other.maPhuThuoc != null) || (this.maPhuThuoc != null && !this.maPhuThuoc.equals(other.maPhuThuoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ims.dao.PhuthuocphongTtCn[ maPhuThuoc=" + maPhuThuoc + " ]";
    }
    
}
