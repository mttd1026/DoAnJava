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
@Table(name = "tongiao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tongiao.findAll", query = "SELECT t FROM Tongiao t")
    , @NamedQuery(name = "Tongiao.findByMaTonGiao", query = "SELECT t FROM Tongiao t WHERE t.maTonGiao = :maTonGiao")
    , @NamedQuery(name = "Tongiao.findByTenTonGiao", query = "SELECT t FROM Tongiao t WHERE t.tenTonGiao = :tenTonGiao")})
public class Tongiao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaTonGiao")
    private String maTonGiao;
    @Basic(optional = false)
    @Column(name = "TenTonGiao")
    private String tenTonGiao;

    public Tongiao() {
    }

    public Tongiao(String maTonGiao) {
        this.maTonGiao = maTonGiao;
    }

    public Tongiao(String maTonGiao, String tenTonGiao) {
        this.maTonGiao = maTonGiao;
        this.tenTonGiao = tenTonGiao;
    }

    public String getMaTonGiao() {
        return maTonGiao;
    }

    public void setMaTonGiao(String maTonGiao) {
        this.maTonGiao = maTonGiao;
    }

    public String getTenTonGiao() {
        return tenTonGiao;
    }

    public void setTenTonGiao(String tenTonGiao) {
        this.tenTonGiao = tenTonGiao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maTonGiao != null ? maTonGiao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tongiao)) {
            return false;
        }
        Tongiao other = (Tongiao) object;
        if ((this.maTonGiao == null && other.maTonGiao != null) || (this.maTonGiao != null && !this.maTonGiao.equals(other.maTonGiao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ims.dao.Tongiao[ maTonGiao=" + maTonGiao + " ]";
    }
    
}
