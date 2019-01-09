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
@Table(name = "nhanvien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nhanvien.findAll", query = "SELECT n FROM Nhanvien n")
    , @NamedQuery(name = "Nhanvien.findByMaNhanVien", query = "SELECT n FROM Nhanvien n WHERE n.maNhanVien = :maNhanVien")
    , @NamedQuery(name = "Nhanvien.findByHo", query = "SELECT n FROM Nhanvien n WHERE n.ho = :ho")
    , @NamedQuery(name = "Nhanvien.findByTen", query = "SELECT n FROM Nhanvien n WHERE n.ten = :ten")
    , @NamedQuery(name = "Nhanvien.findByTenTiengAnh", query = "SELECT n FROM Nhanvien n WHERE n.tenTiengAnh = :tenTiengAnh")
    , @NamedQuery(name = "Nhanvien.findByNgaySinh", query = "SELECT n FROM Nhanvien n WHERE n.ngaySinh = :ngaySinh")
    , @NamedQuery(name = "Nhanvien.findByNgayThayDoi", query = "SELECT n FROM Nhanvien n WHERE n.ngayThayDoi = :ngayThayDoi")
    , @NamedQuery(name = "Nhanvien.findByNgayThayDoiCN", query = "SELECT n FROM Nhanvien n WHERE n.ngayThayDoiCN = :ngayThayDoiCN")
    , @NamedQuery(name = "Nhanvien.findByNgayBatDau", query = "SELECT n FROM Nhanvien n WHERE n.ngayBatDau = :ngayBatDau")
    , @NamedQuery(name = "Nhanvien.findByNgayKetThuc", query = "SELECT n FROM Nhanvien n WHERE n.ngayKetThuc = :ngayKetThuc")
    , @NamedQuery(name = "Nhanvien.findByGioiTinh", query = "SELECT n FROM Nhanvien n WHERE n.gioiTinh = :gioiTinh")
    , @NamedQuery(name = "Nhanvien.findByDTCty", query = "SELECT n FROM Nhanvien n WHERE n.dTCty = :dTCty")
    , @NamedQuery(name = "Nhanvien.findByDTNha", query = "SELECT n FROM Nhanvien n WHERE n.dTNha = :dTNha")
    , @NamedQuery(name = "Nhanvien.findByECty", query = "SELECT n FROM Nhanvien n WHERE n.eCty = :eCty")
    , @NamedQuery(name = "Nhanvien.findByERieng", query = "SELECT n FROM Nhanvien n WHERE n.eRieng = :eRieng")
    , @NamedQuery(name = "Nhanvien.findByNoiSinh", query = "SELECT n FROM Nhanvien n WHERE n.noiSinh = :noiSinh")
    , @NamedQuery(name = "Nhanvien.findByNguyenQuan", query = "SELECT n FROM Nhanvien n WHERE n.nguyenQuan = :nguyenQuan")
    , @NamedQuery(name = "Nhanvien.findByTamTru", query = "SELECT n FROM Nhanvien n WHERE n.tamTru = :tamTru")
    , @NamedQuery(name = "Nhanvien.findByThuongTru", query = "SELECT n FROM Nhanvien n WHERE n.thuongTru = :thuongTru")
    , @NamedQuery(name = "Nhanvien.findByHonNhan", query = "SELECT n FROM Nhanvien n WHERE n.honNhan = :honNhan")
    , @NamedQuery(name = "Nhanvien.findByBaoHiem", query = "SELECT n FROM Nhanvien n WHERE n.baoHiem = :baoHiem")
    , @NamedQuery(name = "Nhanvien.findByMaLoaiNhanVien", query = "SELECT n FROM Nhanvien n WHERE n.maLoaiNhanVien = :maLoaiNhanVien")
    , @NamedQuery(name = "Nhanvien.findByMaKhoi", query = "SELECT n FROM Nhanvien n WHERE n.maKhoi = :maKhoi")
    , @NamedQuery(name = "Nhanvien.findByMaTonGiao", query = "SELECT n FROM Nhanvien n WHERE n.maTonGiao = :maTonGiao")
    , @NamedQuery(name = "Nhanvien.findByMaQuocTich", query = "SELECT n FROM Nhanvien n WHERE n.maQuocTich = :maQuocTich")
    , @NamedQuery(name = "Nhanvien.findByMaDanToc", query = "SELECT n FROM Nhanvien n WHERE n.maDanToc = :maDanToc")
    , @NamedQuery(name = "Nhanvien.findByMaLoaiHopDong", query = "SELECT n FROM Nhanvien n WHERE n.maLoaiHopDong = :maLoaiHopDong")
    , @NamedQuery(name = "Nhanvien.findByMaNoiLamViec", query = "SELECT n FROM Nhanvien n WHERE n.maNoiLamViec = :maNoiLamViec")
    , @NamedQuery(name = "Nhanvien.findByMaPhongBan", query = "SELECT n FROM Nhanvien n WHERE n.maPhongBan = :maPhongBan")
    , @NamedQuery(name = "Nhanvien.findByMaPhongCN", query = "SELECT n FROM Nhanvien n WHERE n.maPhongCN = :maPhongCN")
    , @NamedQuery(name = "Nhanvien.findByMaChucVu", query = "SELECT n FROM Nhanvien n WHERE n.maChucVu = :maChucVu")
    , @NamedQuery(name = "Nhanvien.findByMaTinhThanh", query = "SELECT n FROM Nhanvien n WHERE n.maTinhThanh = :maTinhThanh")
    , @NamedQuery(name = "Nhanvien.findByMaHuyen", query = "SELECT n FROM Nhanvien n WHERE n.maHuyen = :maHuyen")
    , @NamedQuery(name = "Nhanvien.findByMaTo", query = "SELECT n FROM Nhanvien n WHERE n.maTo = :maTo")
    , @NamedQuery(name = "Nhanvien.findByMaPhuThuoc", query = "SELECT n FROM Nhanvien n WHERE n.maPhuThuoc = :maPhuThuoc")})
public class Nhanvien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaNhanVien")
    private Integer maNhanVien;
    @Basic(optional = false)
    @Column(name = "Ho")
    private String ho;
    @Basic(optional = false)
    @Column(name = "Ten")
    private String ten;
    @Basic(optional = false)
    @Column(name = "TenTiengAnh")
    private String tenTiengAnh;
    @Basic(optional = false)
    @Column(name = "NgaySinh")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;
    @Basic(optional = false)
    @Column(name = "NgayThayDoi")
    @Temporal(TemporalType.DATE)
    private Date ngayThayDoi;
    @Basic(optional = false)
    @Column(name = "NgayThayDoiCN")
    @Temporal(TemporalType.DATE)
    private Date ngayThayDoiCN;
    @Basic(optional = false)
    @Column(name = "NgayBatDau")
    @Temporal(TemporalType.DATE)
    private Date ngayBatDau;
    @Basic(optional = false)
    @Column(name = "NgayKetThuc")
    @Temporal(TemporalType.DATE)
    private Date ngayKetThuc;
    @Basic(optional = false)
    @Column(name = "GioiTinh")
    private boolean gioiTinh;
    @Basic(optional = false)
    @Column(name = "DTCty")
    private int dTCty;
    @Basic(optional = false)
    @Column(name = "DTNha")
    private int dTNha;
    @Basic(optional = false)
    @Column(name = "ECty")
    private String eCty;
    @Basic(optional = false)
    @Column(name = "ERieng")
    private String eRieng;
    @Basic(optional = false)
    @Column(name = "NoiSinh")
    private String noiSinh;
    @Basic(optional = false)
    @Column(name = "NguyenQuan")
    private String nguyenQuan;
    @Basic(optional = false)
    @Column(name = "TamTru")
    private String tamTru;
    @Basic(optional = false)
    @Column(name = "ThuongTru")
    private String thuongTru;
    @Basic(optional = false)
    @Column(name = "HonNhan")
    private boolean honNhan;
    @Basic(optional = false)
    @Column(name = "BaoHiem")
    private String baoHiem;
    @Basic(optional = false)
    @Column(name = "MaLoaiNhanVien")
    private String maLoaiNhanVien;
    @Basic(optional = false)
    @Column(name = "MaKhoi")
    private String maKhoi;
    @Basic(optional = false)
    @Column(name = "MaTonGiao")
    private String maTonGiao;
    @Basic(optional = false)
    @Column(name = "MaQuocTich")
    private String maQuocTich;
    @Basic(optional = false)
    @Column(name = "MaDanToc")
    private String maDanToc;
    @Basic(optional = false)
    @Column(name = "MaLoaiHopDong")
    private String maLoaiHopDong;
    @Basic(optional = false)
    @Column(name = "MaNoiLamViec")
    private String maNoiLamViec;
    @Basic(optional = false)
    @Column(name = "MaPhongBan")
    private int maPhongBan;
    @Basic(optional = false)
    @Column(name = "MaPhongCN")
    private String maPhongCN;
    @Basic(optional = false)
    @Column(name = "MaChucVu")
    private String maChucVu;
    @Basic(optional = false)
    @Column(name = "MaTinhThanh")
    private String maTinhThanh;
    @Basic(optional = false)
    @Column(name = "MaHuyen")
    private String maHuyen;
    @Basic(optional = false)
    @Column(name = "MaTo")
    private int maTo;
    @Basic(optional = false)
    @Column(name = "MaPhuThuoc")
    private int maPhuThuoc;

    public Nhanvien() {
    }

    public Nhanvien(Integer maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public Nhanvien(Integer maNhanVien, String ho, String ten, String tenTiengAnh, Date ngaySinh, Date ngayThayDoi, Date ngayThayDoiCN, Date ngayBatDau, Date ngayKetThuc, boolean gioiTinh, int dTCty, int dTNha, String eCty, String eRieng, String noiSinh, String nguyenQuan, String tamTru, String thuongTru, boolean honNhan, String baoHiem, String maLoaiNhanVien, String maKhoi, String maTonGiao, String maQuocTich, String maDanToc, String maLoaiHopDong, String maNoiLamViec, int maPhongBan, String maPhongCN, String maChucVu, String maTinhThanh, String maHuyen, int maTo, int maPhuThuoc) {
        this.maNhanVien = maNhanVien;
        this.ho = ho;
        this.ten = ten;
        this.tenTiengAnh = tenTiengAnh;
        this.ngaySinh = ngaySinh;
        this.ngayThayDoi = ngayThayDoi;
        this.ngayThayDoiCN = ngayThayDoiCN;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.gioiTinh = gioiTinh;
        this.dTCty = dTCty;
        this.dTNha = dTNha;
        this.eCty = eCty;
        this.eRieng = eRieng;
        this.noiSinh = noiSinh;
        this.nguyenQuan = nguyenQuan;
        this.tamTru = tamTru;
        this.thuongTru = thuongTru;
        this.honNhan = honNhan;
        this.baoHiem = baoHiem;
        this.maLoaiNhanVien = maLoaiNhanVien;
        this.maKhoi = maKhoi;
        this.maTonGiao = maTonGiao;
        this.maQuocTich = maQuocTich;
        this.maDanToc = maDanToc;
        this.maLoaiHopDong = maLoaiHopDong;
        this.maNoiLamViec = maNoiLamViec;
        this.maPhongBan = maPhongBan;
        this.maPhongCN = maPhongCN;
        this.maChucVu = maChucVu;
        this.maTinhThanh = maTinhThanh;
        this.maHuyen = maHuyen;
        this.maTo = maTo;
        this.maPhuThuoc = maPhuThuoc;
    }

    public Integer getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(Integer maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTenTiengAnh() {
        return tenTiengAnh;
    }

    public void setTenTiengAnh(String tenTiengAnh) {
        this.tenTiengAnh = tenTiengAnh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getNgayThayDoi() {
        return ngayThayDoi;
    }

    public void setNgayThayDoi(Date ngayThayDoi) {
        this.ngayThayDoi = ngayThayDoi;
    }

    public Date getNgayThayDoiCN() {
        return ngayThayDoiCN;
    }

    public void setNgayThayDoiCN(Date ngayThayDoiCN) {
        this.ngayThayDoiCN = ngayThayDoiCN;
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

    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getDTCty() {
        return dTCty;
    }

    public void setDTCty(int dTCty) {
        this.dTCty = dTCty;
    }

    public int getDTNha() {
        return dTNha;
    }

    public void setDTNha(int dTNha) {
        this.dTNha = dTNha;
    }

    public String getECty() {
        return eCty;
    }

    public void setECty(String eCty) {
        this.eCty = eCty;
    }

    public String getERieng() {
        return eRieng;
    }

    public void setERieng(String eRieng) {
        this.eRieng = eRieng;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getNguyenQuan() {
        return nguyenQuan;
    }

    public void setNguyenQuan(String nguyenQuan) {
        this.nguyenQuan = nguyenQuan;
    }

    public String getTamTru() {
        return tamTru;
    }

    public void setTamTru(String tamTru) {
        this.tamTru = tamTru;
    }

    public String getThuongTru() {
        return thuongTru;
    }

    public void setThuongTru(String thuongTru) {
        this.thuongTru = thuongTru;
    }

    public boolean getHonNhan() {
        return honNhan;
    }

    public void setHonNhan(boolean honNhan) {
        this.honNhan = honNhan;
    }

    public String getBaoHiem() {
        return baoHiem;
    }

    public void setBaoHiem(String baoHiem) {
        this.baoHiem = baoHiem;
    }

    public String getMaLoaiNhanVien() {
        return maLoaiNhanVien;
    }

    public void setMaLoaiNhanVien(String maLoaiNhanVien) {
        this.maLoaiNhanVien = maLoaiNhanVien;
    }

    public String getMaKhoi() {
        return maKhoi;
    }

    public void setMaKhoi(String maKhoi) {
        this.maKhoi = maKhoi;
    }

    public String getMaTonGiao() {
        return maTonGiao;
    }

    public void setMaTonGiao(String maTonGiao) {
        this.maTonGiao = maTonGiao;
    }

    public String getMaQuocTich() {
        return maQuocTich;
    }

    public void setMaQuocTich(String maQuocTich) {
        this.maQuocTich = maQuocTich;
    }

    public String getMaDanToc() {
        return maDanToc;
    }

    public void setMaDanToc(String maDanToc) {
        this.maDanToc = maDanToc;
    }

    public String getMaLoaiHopDong() {
        return maLoaiHopDong;
    }

    public void setMaLoaiHopDong(String maLoaiHopDong) {
        this.maLoaiHopDong = maLoaiHopDong;
    }

    public String getMaNoiLamViec() {
        return maNoiLamViec;
    }

    public void setMaNoiLamViec(String maNoiLamViec) {
        this.maNoiLamViec = maNoiLamViec;
    }

    public int getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(int maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    public String getMaPhongCN() {
        return maPhongCN;
    }

    public void setMaPhongCN(String maPhongCN) {
        this.maPhongCN = maPhongCN;
    }

    public String getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(String maChucVu) {
        this.maChucVu = maChucVu;
    }

    public String getMaTinhThanh() {
        return maTinhThanh;
    }

    public void setMaTinhThanh(String maTinhThanh) {
        this.maTinhThanh = maTinhThanh;
    }

    public String getMaHuyen() {
        return maHuyen;
    }

    public void setMaHuyen(String maHuyen) {
        this.maHuyen = maHuyen;
    }

    public int getMaTo() {
        return maTo;
    }

    public void setMaTo(int maTo) {
        this.maTo = maTo;
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
        hash += (maNhanVien != null ? maNhanVien.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nhanvien)) {
            return false;
        }
        Nhanvien other = (Nhanvien) object;
        if ((this.maNhanVien == null && other.maNhanVien != null) || (this.maNhanVien != null && !this.maNhanVien.equals(other.maNhanVien))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ims.dao.Nhanvien[ maNhanVien=" + maNhanVien + " ]";
    }
    
}
