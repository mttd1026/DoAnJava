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
@Table(name = "quoctich")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quoctich.findAll", query = "SELECT q FROM Quoctich q")
    , @NamedQuery(name = "Quoctich.findByMaQuocTich", query = "SELECT q FROM Quoctich q WHERE q.maQuocTich = :maQuocTich")
    , @NamedQuery(name = "Quoctich.findByTenQuocTich", query = "SELECT q FROM Quoctich q WHERE q.tenQuocTich = :tenQuocTich")})
public class Quoctich implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaQuocTich")
    private String maQuocTich;
    @Basic(optional = false)
    @Column(name = "TenQuocTich")
    private String tenQuocTich;

    public Quoctich() {
    }

    public Quoctich(String maQuocTich) {
        this.maQuocTich = maQuocTich;
    }

    public Quoctich(String maQuocTich, String tenQuocTich) {
        this.maQuocTich = maQuocTich;
        this.tenQuocTich = tenQuocTich;
    }

    public String getMaQuocTich() {
        return maQuocTich;
    }

    public void setMaQuocTich(String maQuocTich) {
        this.maQuocTich = maQuocTich;
    }

    public String getTenQuocTich() {
        return tenQuocTich;
    }

    public void setTenQuocTich(String tenQuocTich) {
        this.tenQuocTich = tenQuocTich;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maQuocTich != null ? maQuocTich.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quoctich)) {
            return false;
        }
        Quoctich other = (Quoctich) object;
        if ((this.maQuocTich == null && other.maQuocTich != null) || (this.maQuocTich != null && !this.maQuocTich.equals(other.maQuocTich))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ims.dao.Quoctich[ maQuocTich=" + maQuocTich + " ]";
    }
    
}
