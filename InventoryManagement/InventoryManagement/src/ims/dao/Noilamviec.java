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
@Table(name = "noilamviec")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Noilamviec.findAll", query = "SELECT n FROM Noilamviec n")
    , @NamedQuery(name = "Noilamviec.findByMaNoiLamViec", query = "SELECT n FROM Noilamviec n WHERE n.maNoiLamViec = :maNoiLamViec")
    , @NamedQuery(name = "Noilamviec.findByTenNoiLamViec", query = "SELECT n FROM Noilamviec n WHERE n.tenNoiLamViec = :tenNoiLamViec")
    , @NamedQuery(name = "Noilamviec.findByMaKhuVuc", query = "SELECT n FROM Noilamviec n WHERE n.maKhuVuc = :maKhuVuc")})
public class Noilamviec implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaNoiLamViec")
    private String maNoiLamViec;
    @Basic(optional = false)
    @Column(name = "TenNoiLamViec")
    private String tenNoiLamViec;
    @Basic(optional = false)
    @Column(name = "MaKhuVuc")
    private String maKhuVuc;

    public Noilamviec() {
    }

    public Noilamviec(String maNoiLamViec) {
        this.maNoiLamViec = maNoiLamViec;
    }

    public Noilamviec(String maNoiLamViec, String tenNoiLamViec, String maKhuVuc) {
        this.maNoiLamViec = maNoiLamViec;
        this.tenNoiLamViec = tenNoiLamViec;
        this.maKhuVuc = maKhuVuc;
    }

    public String getMaNoiLamViec() {
        return maNoiLamViec;
    }

    public void setMaNoiLamViec(String maNoiLamViec) {
        this.maNoiLamViec = maNoiLamViec;
    }

    public String getTenNoiLamViec() {
        return tenNoiLamViec;
    }

    public void setTenNoiLamViec(String tenNoiLamViec) {
        this.tenNoiLamViec = tenNoiLamViec;
    }

    public String getMaKhuVuc() {
        return maKhuVuc;
    }

    public void setMaKhuVuc(String maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maNoiLamViec != null ? maNoiLamViec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Noilamviec)) {
            return false;
        }
        Noilamviec other = (Noilamviec) object;
        if ((this.maNoiLamViec == null && other.maNoiLamViec != null) || (this.maNoiLamViec != null && !this.maNoiLamViec.equals(other.maNoiLamViec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ims.dao.Noilamviec[ maNoiLamViec=" + maNoiLamViec + " ]";
    }
    
}
