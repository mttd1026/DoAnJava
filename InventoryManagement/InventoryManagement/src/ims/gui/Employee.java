/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.gui;

import ims.dal.EmployeeDAL;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NAT
 */
public class Employee extends javax.swing.JFrame {
    
    EmployeeDAL con;
    private int flag = 0;
    /**
     * Creates new form Employee
     */
    public Employee() {
        initComponents();
//        stateButton(true);
        setInfoDialog();
        con = new EmployeeDAL();
        showData();
        LoadDataCB();
        Keylistener();
    }
    public void HideTextBox (boolean a){
        jtfMaNV.setEnabled(a);    
    }
    
    public void showData() {
        String[] columnNames = {"MãNV", "MãLNV", "MãKhối" ,"MãTG","MãQT","MãDT"," Họ lót", "Tên", "Tên Tiếng Anh","Ngày Sinh", "Ngày Thay Đổi", "Giới Tính", "DTCty", "DTNhà"
                ," ECty", "ERiêng","Nơi Sinh", "Nguyên Quán", "Tạm Trú", "Thường Trú", "Hôn Nhân", "Bảo Hiểm","Ngày Thay Đổi CN","Ngày Bắt Đầu","Ngày Kết Thúc"
                ,"MãCV","MãLHĐ","MãPhòngCN","MãPhòngThuộc","MãNLV"
                };

        //Chua du lieu tu sql do vao jtable
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        jTable1.setModel(model);
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);

        String MaNV = "";
        String MaPhongCN = "";
        String MaCV = "";
        String MaLHD = "";
        String MaPhongThuoc = "";
//        String MaTo = "";
        String MaNLV = "";
        String MaLNV = "";
        String MaKhoi = "";
        String MaTG = "";
        String MaQT = "";
        String MaDT = "";
        String HoLot = "";
        String Ten = "";
        String TenTiengAnh = "";
        String NgaySinh = "";
        String NgayThayDoi = "";
        String NgayThayDoiCN = "";
        String NgayBatDau = "";
        String NgayKetThuc = "";
        String GioiTinh = "";
        String DTCty = "";
        String DTNha = "";
        String ECty = "";
        String ERieng = "";
        String NoiSinh = "";
        String NguyenQuan = "";
        String TamTru = "";
        String ThuongTru = "";
        String HonNhan = "";
        String BaoHiem = "";
        

        ResultSet rs = con.getData("SELECT * FROM nhanvien");
        try {
            while (rs.next()) {
                MaNV = rs.getString("MaNhanVien");
                MaLNV = rs.getString("MaLoaiNhanVien");
                MaPhongCN = rs.getString("MaPhongCN");
                MaLHD =rs.getString("MaLoaiHopDong");
                MaPhongThuoc =rs.getString("MaPhuThuoc");
//                MaTo =rs.getString("MaTo");
                MaCV =rs.getString("MaChucVu");
                MaKhoi = rs.getString("MaKhoi");
                MaTG = rs.getString("MaTonGiao");
                MaQT = rs.getString("MaQuocTich");
                MaDT = rs.getString("MaDanToc");
                HoLot = rs.getString("Ho");
                Ten = rs.getString("Ten");
                TenTiengAnh = rs.getString("TenTiengAnh");
                NgaySinh = rs.getString("NgaySinh");
                NgayThayDoi = rs.getString("NgayThayDoi");
                NgayThayDoiCN = rs.getString("NgayThayDoiCN");
                NgayBatDau = rs.getString("NgayBatDau");
                NgayKetThuc = rs.getString("NgayKetThuc");
                GioiTinh = rs.getString("GioiTinh");
                DTCty = rs.getString("DTCty");
                DTNha = rs.getString("DTNha");
                ECty = rs.getString("ECty");
                ERieng = rs.getString("ERieng");
                NoiSinh = rs.getString("NoiSinh");
                NguyenQuan = rs.getString("NguyenQuan");
                TamTru = rs.getString("TamTru");
                ThuongTru = rs.getString("ThuongTru");
                HonNhan = rs.getString("HonNhan");
                BaoHiem = rs.getString("BaoHiem");


                model.addRow(new Object[]{MaNV, MaLNV,MaPhongCN,MaLHD,MaPhongThuoc,MaCV, MaKhoi, MaTG, MaQT, MaDT, HoLot, Ten, TenTiengAnh, NgaySinh,
                    NgayThayDoi,NgayThayDoiCN,NgayBatDau,NgayKetThuc, GioiTinh, DTCty, DTNha, ECty, ERieng, NoiSinh, NguyenQuan, TamTru,ThuongTru,HonNhan,BaoHiem});
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LoadDataCB() {
        try {
            ResultSet rsLoaiHopDong = con.getData("SELECT * from loaihopdong");
            ResultSet rsChucVu = con.getData("SELECT * from chucvu");
            ResultSet rsLoaiNhanVien = con.getData("SELECT * from loainhanvien");
            ResultSet rsKhoi = con.getData("SELECT * from khoi");
            ResultSet rsPhongCN = con.getData("SELECT * from phong_tt_cn");
            ResultSet rsPhongThuoc = con.getData("SELECT * from phuthuocphong_tt_cn");
//            ResultSet rsTo = con.getData("SELECT * from to");
            ResultSet rsNoiLamViec = con.getData("SELECT * from noilamviec");
            ResultSet rsKhuVuc = con.getData("SELECT * from khuvuc");
            ResultSet rsGiamsatkhuvuc = con.getData("SELECT * from khuvuc");
            ResultSet rsTinh = con.getData("SELECT * from tinh_thanh");
            ResultSet rsHuyen = con.getData("SELECT * from huyen");
            
            while (rsLoaiHopDong.next()) {
                this.jcbLoaiHopDong.addItem(rsLoaiHopDong.getString("MaLoaiHopDong"));
            }
            while (rsChucVu.next()) {
                this.jcbChucvu.addItem(rsChucVu.getString("MaChucVu"));
            }
            while (rsLoaiNhanVien.next()) {
                this.jcbLoainhanvien.addItem(rsLoaiNhanVien.getString("MaLoaiNhanVien"));
            }
            while (rsKhoi.next()) {
                this.jcbKhoi.addItem(rsKhoi.getString("MaKhoi"));
            }
            while (rsPhongCN.next()) {
                this.jcbPhong.addItem(rsPhongCN.getString("MaPhongCN"));
            }
            while (rsPhongThuoc.next()) {
                this.jcbThuocPhong.addItem(rsPhongThuoc.getString("MaPhuThuoc"));
            }
//            while (rsTo.next()) {
//                this.jcbTo.addItem(rsTo.getString("TenTo"));
//            }  
            while (rsNoiLamViec.next()) {
                this.jcbNoiLV.addItem(rsNoiLamViec.getString("MaNoiLamViec"));
            }    
            while (rsKhuVuc.next()) {
                this.jcbKV.addItem(rsKhuVuc.getString("MaKhuVuc"));
            } 
            while (rsGiamsatkhuvuc.next()) {
                this.jcbGSKV.addItem(rsGiamsatkhuvuc.getString("MaKhuVuc"));
            }  
            while (rsTinh.next()) {
                this.jcbtinh.addItem(rsTinh.getString("MaTinhThanh"));
            }  
            while (rsTinh.next()) {
                this.jcbtinh1.addItem(rsTinh.getString("MaTinhThanh"));
            } 
            while (rsHuyen.next()) {
                this.jcbhuyen.addItem(rsHuyen.getString("MaHuyen"));
            } 
            while (rsHuyen.next()) {
                this.jcbhuyen1.addItem(rsHuyen.getString("MaHuyen"));
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Thông báo lỗi", 1);
        }
     }
     
     
    public void insertData() {
        String[] string = {jtfMaNV.getText(), jcbLoaiHopDong.getSelectedItem().toString(), jcbChucvu.getSelectedItem().toString(),
//            jcbTo.getSelectedItem().toString(),
            jcbLoainhanvien.getSelectedItem().toString(), jtfHoLot.getText(),jtfNgaySinh.getText(),jtfNgayThayDoi.getText(),jtfNgayThayDoiCN.getText(),jtfBD.getText(),jtfHDKT.getText(),
            jtfTen.getText(), jtfBHXH.getText(), jtfDCTT.getText(), jcbPhong.getSelectedItem().toString(), jtfNoisinh.getText(),
            jcbNoiLV.getSelectedItem().toString(), jcbKV.getSelectedItem().toString(), jcbKhoi.getSelectedItem().toString(),
            jcbThuocPhong.getSelectedItem().toString(),jcbtinh1.getSelectedItem().toString(),jcbhuyen.getSelectedItem().toString(),
            jcbhuyen1.getSelectedItem().toString(),jtfDTCTY.getText(),jtfDTN.getText(),jtfDTTT.getText(),jtfDantoc.getText(),
            jtfEmailCTY.getText(),jtfEmailRieng.getText(),jtfNguyenquan.getText(),jtfNoisinh.getText(),jtfqltt.getText(),
            jtfPhuong.getText(),jtfQuoctich.getText(),jtfTenTA.getText(),jtfTongiao.getText(),jtfTrinhdo.getText(),jtfPhuong1.getText(),
            jtfThuongtru.getText(), jtfTamtru.getText(), jcbGSKV.getSelectedItem().toString(), jcbtinh.getSelectedItem().toString()};
        int insert = con.EMPLOYEE_Insert(string);
        if (insert > 0) {
            JOptionPane.showMessageDialog(this, "Thêm Employee thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Thêm Employee không thành công!");
        }
       showData();
    }

    
     public void deleteData (){
        String[] stringSQL = {jtfMaNV.getText()};
        
        int delete = con.EMPLOYEE_Delete(stringSQL);
      
        if(delete > 0){
            JOptionPane.showMessageDialog(this,"Xóa thành công!");
        }else {
            JOptionPane.showMessageDialog(this,"Xóa không thành công!");
        }
        showData();
  
    }
     
    //Tắt chương trình bằng ESC
    public void Keylistener(){
        this.setFocusable(true);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    if(JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát chương trình?","Thông báo!",2)==0)                        
                        dispose();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });      
    }
     
    public  void setInfoDialog() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);        
        setResizable(false);
    }
//    public void stateButton(boolean value){
//        
//        btNew.setVisible(value);
//        btEdit.setVisible(value);
//        btDelete.setVisible(value);
//        btPrint.setVisible(value);
//        btClose.setVisible(value);
//        btSave.setVisible(!value);
//        btCancel.setVisible(!value);
//        
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btNew = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btPrint = new javax.swing.JButton();
        btClose = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jtfMaNV = new javax.swing.JTextField();
        jtfHoLot = new javax.swing.JTextField();
        jtfTen = new javax.swing.JTextField();
        jtfDTCTY = new javax.swing.JTextField();
        jtfBHXH = new javax.swing.JTextField();
        jtfEmailCTY = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jtfTenTA = new javax.swing.JTextField();
        jtfqltt = new javax.swing.JTextField();
        jrdNam = new javax.swing.JRadioButton();
        jrdNu = new javax.swing.JRadioButton();
        jLabel26 = new javax.swing.JLabel();
        jcbLoaiHopDong = new javax.swing.JComboBox<>();
        jcbChucvu = new javax.swing.JComboBox<>();
        jcbLoainhanvien = new javax.swing.JComboBox<>();
        jcbKhoi = new javax.swing.JComboBox<>();
        jcbPhong = new javax.swing.JComboBox<>();
        jcbThuocPhong = new javax.swing.JComboBox<>();
        jcbTo = new javax.swing.JComboBox<>();
        jcbNoiLV = new javax.swing.JComboBox<>();
        jcbKV = new javax.swing.JComboBox<>();
        jcbGSKV = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jtfBD = new javax.swing.JTextField();
        jtfHDKT = new javax.swing.JTextField();
        jtfNgayThayDoi = new javax.swing.JTextField();
        jtfNgayThayDoiCN = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jrdChua = new javax.swing.JRadioButton();
        jrddakethon = new javax.swing.JRadioButton();
        jtfNoisinh = new javax.swing.JTextField();
        jtfNguyenquan = new javax.swing.JTextField();
        jtfThuongtru = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jtfPhuong = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jcbtinh = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        jcbhuyen = new javax.swing.JComboBox<>();
        jtfTrinhdo = new javax.swing.JTextField();
        jtfDantoc = new javax.swing.JTextField();
        jtfQuoctich = new javax.swing.JTextField();
        jtfTongiao = new javax.swing.JTextField();
        jtfNgaySinh = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jtfDTN = new javax.swing.JTextField();
        jtfEmailRieng = new javax.swing.JTextField();
        jtfDTTT = new javax.swing.JTextField();
        jtfDCTT = new javax.swing.JTextField();
        jtfTamtru = new javax.swing.JTextField();
        jtfPhuong1 = new javax.swing.JTextField();
        jcbtinh1 = new javax.swing.JComboBox<>();
        jcbhuyen1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btNew.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Desktop\\Add-Folder-icon.png")); // NOI18N
        btNew.setPreferredSize(new java.awt.Dimension(75, 23));
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });

        btEdit.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Desktop\\document-edit-icon.png")); // NOI18N
        btEdit.setPreferredSize(new java.awt.Dimension(75, 23));
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });

        btDelete.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Desktop\\Delete-file-icon.png")); // NOI18N
        btDelete.setPreferredSize(new java.awt.Dimension(75, 23));
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btPrint.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Desktop\\copy-icon.png")); // NOI18N
        btPrint.setPreferredSize(new java.awt.Dimension(75, 23));
        btPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPrintActionPerformed(evt);
            }
        });

        btClose.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Desktop\\Users-Exit-icon.png")); // NOI18N
        btClose.setPreferredSize(new java.awt.Dimension(75, 23));
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActionPerformed(evt);
            }
        });

        btSave.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Desktop\\Save-icon.png")); // NOI18N
        btSave.setPreferredSize(new java.awt.Dimension(75, 23));
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        btCancel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Desktop\\Close-2-icon.png")); // NOI18N
        btCancel.setPreferredSize(new java.awt.Dimension(75, 23));
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin cơ bản", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel1.setText("Mã nhân viên:");

        jLabel2.setText("Họ lót:");

        jLabel3.setText("Tên:");

        jLabel5.setText("Loại hợp đồng:");

        jLabel6.setText("Hợp đòng từ ngày:");

        jLabel8.setText("Chức vụ:");

        jLabel9.setText("Ngày thay đổi:");

        jLabel10.setText("ĐT Cty:");

        jLabel11.setText("Bảo hiểm xã hội:");

        jLabel12.setText("Email Cty:");

        jLabel13.setText("Tên tiếng anh:");

        jLabel15.setText("Giới tính:");

        jLabel16.setText("Loại nhân viên:");

        jLabel17.setText("Khối:");

        jLabel18.setText("Phòng/TT/CN:");

        jLabel19.setText("Ngày thay đổi:");

        jLabel20.setText("PThuộc TT/BP:");

        jLabel21.setText("Tổ:");

        jLabel22.setText("Nơi làm việc:");

        jLabel23.setText("Đến:");

        jtfHoLot.setToolTipText("");

        jtfTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTenActionPerformed(evt);
            }
        });

        jLabel24.setText("Quản lý trực tiếp:");

        jLabel25.setText("Giảm sát khu vực:");

        jrdNam.setText("Nam");

        jrdNu.setText("Nữ");

        jLabel26.setText("Khu vực:");

        jLabel39.setText("jLabel39");

        jtfBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBDActionPerformed(evt);
            }
        });

        jtfHDKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfHDKTActionPerformed(evt);
            }
        });

        jtfNgayThayDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNgayThayDoiActionPerformed(evt);
            }
        });

        jtfNgayThayDoiCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNgayThayDoiCNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbLoaiHopDong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbChucvu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfEmailCTY))
                            .addComponent(jtfBHXH)
                            .addComponent(jtfTen)
                            .addComponent(jtfHoLot)
                            .addComponent(jtfMaNV)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfDTCTY, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtfBD, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel23)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfHDKT, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfNgayThayDoi)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jcbNoiLV, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                                .addComponent(jcbKV, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jcbThuocPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbTo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(jLabel26))
                            .addComponent(jtfqltt)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbKhoi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbLoainhanvien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfNgayThayDoiCN)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfTenTA)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jrdNam, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jrdNu)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbGSKV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel13)
                            .addComponent(jtfMaNV)
                            .addComponent(jtfTenTA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtfHoLot)
                            .addComponent(jLabel15)
                            .addComponent(jrdNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jrdNu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtfTen)
                            .addComponent(jLabel16)
                            .addComponent(jcbLoainhanvien))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jcbLoaiHopDong)
                            .addComponent(jcbKhoi)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel18)
                            .addComponent(jLabel23)
                            .addComponent(jcbPhong)
                            .addComponent(jtfBD)
                            .addComponent(jtfHDKT))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jtfNgayThayDoiCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel20)
                            .addComponent(jcbChucvu)
                            .addComponent(jcbThuocPhong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel21)
                            .addComponent(jcbTo)
                            .addComponent(jtfNgayThayDoi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22)
                            .addComponent(jtfDTCTY)
                            .addComponent(jtfEmailCTY)
                            .addComponent(jLabel26)
                            .addComponent(jcbNoiLV)
                            .addComponent(jcbKV))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jtfBHXH)
                            .addComponent(jLabel24)
                            .addComponent(jtfqltt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jcbGSKV)))
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin cá nhân", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel28.setText("Ngày sinh:");

        jLabel29.setText("Nơi sinh:");

        jLabel30.setText("Nguyên quán:");

        jLabel31.setText("Thường trú:");

        jrdChua.setText("Chưa kết hôn");

        jrddakethon.setText("Đã kết hôn");

        jLabel32.setText("Trình độ:");

        jLabel33.setText("Dân tộc:");

        jLabel34.setText("Quốc tịch:");

        jLabel35.setText("Tôn giáo:");

        jLabel36.setText("Xã/phường:");

        jLabel37.setText("Tỉnh:");

        jLabel38.setText("Huyện:");

        jcbhuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbhuyenActionPerformed(evt);
            }
        });

        jtfDantoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDantocActionPerformed(evt);
            }
        });

        jtfNgaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNgaySinhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jtfNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrdChua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrddakethon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jtfNoisinh)
                            .addComponent(jtfThuongtru))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel32))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfDantoc, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                    .addComponent(jtfTrinhdo))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel35))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfTongiao)
                                    .addComponent(jtfQuoctich)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfPhuong)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbtinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbhuyen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jtfNguyenquan))
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jrdChua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jrddakethon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel34)
                    .addComponent(jtfTrinhdo)
                    .addComponent(jtfQuoctich)
                    .addComponent(jtfNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(jtfNoisinh)
                            .addComponent(jLabel33)
                            .addComponent(jtfDantoc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(jtfNguyenquan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(jtfThuongtru)
                            .addComponent(jtfPhuong)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37)
                            .addComponent(jcbtinh)
                            .addComponent(jLabel38)
                            .addComponent(jcbhuyen)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel35)
                        .addComponent(jtfTongiao))))
        );

        jtfPhuong.getAccessibleContext().setAccessibleName("jftPhuong");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Địa chỉ nhà", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel40.setText("Điện thoại nhà:");

        jLabel41.setText("Email riêng:");

        jLabel42.setText("Tạm trú:");

        jLabel43.setText("Điện thoại tạm thời:");

        jLabel44.setText("Địa chỉ tạm thời:");

        jLabel45.setText("Xã/phường:");

        jLabel46.setText("Tỉnh:");

        jLabel47.setText("Huyện:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfDTN)
                    .addComponent(jtfEmailRieng)
                    .addComponent(jtfTamtru, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jtfPhuong1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbtinh1, 0, 252, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbhuyen1, 0, 253, Short.MAX_VALUE))
                    .addComponent(jtfDCTT)
                    .addComponent(jtfDTTT))
                .addGap(10, 10, 10))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jLabel43)
                    .addComponent(jtfDTN)
                    .addComponent(jtfDTTT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel44)
                    .addComponent(jtfEmailRieng)
                    .addComponent(jtfDCTT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jLabel45)
                    .addComponent(jLabel46)
                    .addComponent(jLabel47)
                    .addComponent(jtfTamtru)
                    .addComponent(jtfPhuong1)
                    .addComponent(jcbtinh1)
                    .addComponent(jcbhuyen1)))
        );

        jtfPhuong1.getAccessibleContext().setAccessibleName("jftPhuong");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(793, 793, 793)
                        .addComponent(btNew, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btClose, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 7, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btSave, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEdit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btPrint, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btClose, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getAccessibleContext().setAccessibleName("jftPhuong");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
//        stateButton(false);
        HideTextBox(true);
        btSave.setEnabled(true);
        flag = 1;
        btNew.setEnabled(false);
        btEdit.setEnabled(false);
        btDelete.setEnabled(false);
    }//GEN-LAST:event_btNewActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
//        stateButton(true);
        HideTextBox(true);
         if (flag == 1) {
            insertData();
            btNew.setEnabled(true);
            btEdit.setEnabled(true);
            btDelete.setEnabled(true);
        }
        HideTextBox(false);
        btSave.setEnabled(false);
    }//GEN-LAST:event_btSaveActionPerformed

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
//        stateButton(false);
    }//GEN-LAST:event_btEditActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
//         stateButton(true);// TODO add your handling code here:
        HideTextBox(false);
        btSave.setEnabled(false);
        flag = 4;
        btNew.setEnabled(true);
        btEdit.setEnabled(true);
        btDelete.setEnabled(true);
    }//GEN-LAST:event_btCancelActionPerformed

    private void jtfTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTenActionPerformed

    private void btPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPrintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btPrintActionPerformed

    private void jcbhuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbhuyenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbhuyenActionPerformed

    private void jtfDantocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDantocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDantocActionPerformed

    private void btCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseActionPerformed
        // TODO add your handling code here:
         this.dispose();
    }//GEN-LAST:event_btCloseActionPerformed

    private void jtfBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBDActionPerformed

    private void jtfHDKTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfHDKTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfHDKTActionPerformed

    private void jtfNgayThayDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNgayThayDoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNgayThayDoiActionPerformed

    private void jtfNgayThayDoiCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNgayThayDoiCNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNgayThayDoiCNActionPerformed

    private void jtfNgaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNgaySinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNgaySinhActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // TODO add your handling code here:
        HideTextBox(true);
        btSave.setEnabled(true);
        if (flag == 3) {
            deleteData();
            btNew.setEnabled(true);
            btEdit.setEnabled(true);
            btDelete.setEnabled(true);
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btClose;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btPrint;
    private javax.swing.JButton btSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jcbChucvu;
    private javax.swing.JComboBox<String> jcbGSKV;
    private javax.swing.JComboBox<String> jcbKV;
    private javax.swing.JComboBox<String> jcbKhoi;
    private javax.swing.JComboBox<String> jcbLoaiHopDong;
    private javax.swing.JComboBox<String> jcbLoainhanvien;
    private javax.swing.JComboBox<String> jcbNoiLV;
    private javax.swing.JComboBox<String> jcbPhong;
    private javax.swing.JComboBox<String> jcbThuocPhong;
    private javax.swing.JComboBox<String> jcbTo;
    private javax.swing.JComboBox<String> jcbhuyen;
    private javax.swing.JComboBox<String> jcbhuyen1;
    private javax.swing.JComboBox<String> jcbtinh;
    private javax.swing.JComboBox<String> jcbtinh1;
    private javax.swing.JRadioButton jrdChua;
    private javax.swing.JRadioButton jrdNam;
    private javax.swing.JRadioButton jrdNu;
    private javax.swing.JRadioButton jrddakethon;
    private javax.swing.JTextField jtfBD;
    private javax.swing.JTextField jtfBHXH;
    private javax.swing.JTextField jtfDCTT;
    private javax.swing.JTextField jtfDTCTY;
    private javax.swing.JTextField jtfDTN;
    private javax.swing.JTextField jtfDTTT;
    private javax.swing.JTextField jtfDantoc;
    private javax.swing.JTextField jtfEmailCTY;
    private javax.swing.JTextField jtfEmailRieng;
    private javax.swing.JTextField jtfHDKT;
    private javax.swing.JTextField jtfHoLot;
    private javax.swing.JTextField jtfMaNV;
    private javax.swing.JTextField jtfNgaySinh;
    private javax.swing.JTextField jtfNgayThayDoi;
    private javax.swing.JTextField jtfNgayThayDoiCN;
    private javax.swing.JTextField jtfNguyenquan;
    private javax.swing.JTextField jtfNoisinh;
    private javax.swing.JTextField jtfPhuong;
    private javax.swing.JTextField jtfPhuong1;
    private javax.swing.JTextField jtfQuoctich;
    private javax.swing.JTextField jtfTamtru;
    private javax.swing.JTextField jtfTen;
    private javax.swing.JTextField jtfTenTA;
    private javax.swing.JTextField jtfThuongtru;
    private javax.swing.JTextField jtfTongiao;
    private javax.swing.JTextField jtfTrinhdo;
    private javax.swing.JTextField jtfqltt;
    // End of variables declaration//GEN-END:variables
}
