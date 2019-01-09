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
@Table(name = "dantoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dantoc.findAll", query = "SELECT d FROM Dantoc d")
    , @NamedQuery(name = "Dantoc.findByMaDanToc", query = "SELECT d FROM Dantoc d WHERE d.maDanToc = :maDanToc")
    , @NamedQuery(name = "Dantoc.findByTenDanToc", query = "SELECT d FROM Dantoc d WHERE d.tenDanToc = :tenDanToc")})
public class Dantoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaDanToc")
    private String maDanToc;
    @Basic(optional = false)
    @Column(name = "TenDanToc")
    private String tenDanToc;

    public Dantoc() {
    }

    public Dantoc(String maDanToc) {
        this.maDanToc = maDanToc;
    }

    public Dantoc(String maDanToc, String tenDanToc) {
        this.maDanToc = maDanToc;
        this.tenDanToc = tenDanToc;
    }

    public String getMaDanToc() {
        return maDanToc;
    }

    public void setMaDanToc(String maDanToc) {
        this.maDanToc = maDanToc;
    }

    public String getTenDanToc() {
        return tenDanToc;
    }

    public void setTenDanToc(String tenDanToc) {
        this.tenDanToc = tenDanToc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maDanToc != null ? maDanToc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dantoc)) {
            return false;
        }
        Dantoc other = (Dantoc) object;
        if ((this.maDanToc == null && other.maDanToc != null) || (this.maDanToc != null && !this.maDanToc.equals(other.maDanToc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ims.dao.Dantoc[ maDanToc=" + maDanToc + " ]";
    }
    
}
