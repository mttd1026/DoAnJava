/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.dal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class EmployeeDAL {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/employee";
    static final String USER = "root";
    static final String PASS= "";
    Connection con = null;
    ResultSet rs = null;
    Statement state = null;
    
    //Ham ket noi
    public EmployeeDAL(){
        try {
        String dbURL = "jdbc:mysql://localhost/employee";
        String username = "root";
        String password = "";
        con = DriverManager.getConnection(DB_URL, USER, PASS);

        if (con != null) {
                System.out.println("Kết nối thành công");
            }
        }catch (SQLException ex) {
            Logger.getLogger(EmployeeDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    //Viet lay du lieu tu bang trong database
    public ResultSet getData(String stringSQL){
        try {
            state = con.createStatement();
            rs = state.executeQuery(stringSQL);
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    //Viet ham insert du lieu
    public int EMPLOYEE_Insert (String[] string){
        int row = 0;
        String insert = "INSERT INTO nhanvien(MaNhanVien, Ho, Ten, TenTiengAnh	, NgaySinh, NgayThayDoi,NgayThayDoiCN,NgayBatDau,NgayKetThuc, GioiTinh, DTCty, DTNha"
                + ", ECty, ERieng,NoiSinh, NguyenQuan, TamTru, ThuongTru, HonNhan, BaoHiem"
                + ", MaLoaiNhanVien, MaKhoi ,MaTonGiao,MaQuocTich,MaDanToc"
                + ", MaTinhThanh,MaLoaiHopDong,MaNoiLamViec,MaPhongBan,MaPhongCN,MaChucVu,MaHuyen,MaPhuThuoc) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stament;
        try {
            stament = con.prepareCall(insert);          
            stament.setString(1,string[0]);
            stament.setString(2,string[1]);
            stament.setString(3,string[2]);
            stament.setString(4,string[3]);
            stament.setString(5,string[4]);
            stament.setString(6,string[5]);
            stament.setString(7,string[6]);
            stament.setString(8,string[7]);
            stament.setString(9,string[8]);
            stament.setString(10,string[9]);
            stament.setString(11,string[10]);
            stament.setString(12,string[11]);
            stament.setString(13,string[12]);
            stament.setString(14,string[13]);
            stament.setString(15,string[14]);
            stament.setString(16,string[15]);
            stament.setString(17,string[16]);
            stament.setString(18,string[17]);
            stament.setString(19,string[18]);
            stament.setString(20,string[19]); 
            stament.setString(21,string[20]);
            stament.setString(22,string[21]); 
            stament.setString(23,string[22]);
            stament.setString(24,string[23]);
            stament.setString(25,string[24]);
            stament.setString(26,string[25]);
            stament.setString(27,string[26]);
            stament.setString(28,string[27]);
            stament.setString(29,string[28]);
            stament.setString(30,string[29]);
            stament.setString(31,string[30]);
            stament.setString(32,string[31]);
            stament.setString(33,string[32]);
       
            row = stament.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    public int EMPLOYEE_Delete(String[] stringSQL) {
        int row=0;
        String delete = "DELETE FROM nhanvien WHERE MaNhanVien=?";
        PreparedStatement ps;
        try {
            ps = con.prepareCall(delete);
            ps.setString(1,stringSQL[0]);
            
            row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    } 
}
