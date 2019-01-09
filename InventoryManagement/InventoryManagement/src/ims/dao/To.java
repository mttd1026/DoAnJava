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
@Table(name = "to")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "To.findAll", query = "SELECT t FROM To t")
    , @NamedQuery(name = "To.findByMaTo", query = "SELECT t FROM To t WHERE t.maTo = :maTo")
    , @NamedQuery(name = "To.findByTenTo", query = "SELECT t FROM To t WHERE t.tenTo = :tenTo")})
public class To implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaTo")
    private Integer maTo;
    @Basic(optional = false)
    @Column(name = "TenTo")
    private String tenTo;

    public To() {
    }

    public To(Integer maTo) {
        this.maTo = maTo;
    }

    public To(Integer maTo, String tenTo) {
        this.maTo = maTo;
        this.tenTo = tenTo;
    }

    public Integer getMaTo() {
        return maTo;
    }

    public void setMaTo(Integer maTo) {
        this.maTo = maTo;
    }

    public String getTenTo() {
        return tenTo;
    }

    public void setTenTo(String tenTo) {
        this.tenTo = tenTo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maTo != null ? maTo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof To)) {
            return false;
        }
        To other = (To) object;
        if ((this.maTo == null && other.maTo != null) || (this.maTo != null && !this.maTo.equals(other.maTo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ims.dao.To[ maTo=" + maTo + " ]";
    }
    
}
