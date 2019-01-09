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
@Table(name = "tinh_thanh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TinhThanh.findAll", query = "SELECT t FROM TinhThanh t")
    , @NamedQuery(name = "TinhThanh.findByMaTinhThanh", query = "SELECT t FROM TinhThanh t WHERE t.maTinhThanh = :maTinhThanh")
    , @NamedQuery(name = "TinhThanh.findByTenTinhThanh", query = "SELECT t FROM TinhThanh t WHERE t.tenTinhThanh = :tenTinhThanh")})
public class TinhThanh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaTinhThanh")
    private Integer maTinhThanh;
    @Basic(optional = false)
    @Column(name = "TenTinhThanh")
    private String tenTinhThanh;

    public TinhThanh() {
    }

    public TinhThanh(Integer maTinhThanh) {
        this.maTinhThanh = maTinhThanh;
    }

    public TinhThanh(Integer maTinhThanh, String tenTinhThanh) {
        this.maTinhThanh = maTinhThanh;
        this.tenTinhThanh = tenTinhThanh;
    }

    public Integer getMaTinhThanh() {
        return maTinhThanh;
    }

    public void setMaTinhThanh(Integer maTinhThanh) {
        this.maTinhThanh = maTinhThanh;
    }

    public String getTenTinhThanh() {
        return tenTinhThanh;
    }

    public void setTenTinhThanh(String tenTinhThanh) {
        this.tenTinhThanh = tenTinhThanh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maTinhThanh != null ? maTinhThanh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TinhThanh)) {
            return false;
        }
        TinhThanh other = (TinhThanh) object;
        if ((this.maTinhThanh == null && other.maTinhThanh != null) || (this.maTinhThanh != null && !this.maTinhThanh.equals(other.maTinhThanh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ims.dao.TinhThanh[ maTinhThanh=" + maTinhThanh + " ]";
    }
    
}
