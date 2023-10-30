package model708;

import java.time.LocalDate;
import java.util.List;

public class HoaDonNhapHang708 {
    private int id;
    private LocalDate ngayNhapHang;
    private List<HangNhap708> dsHangNhap;
    private double tongTien;
    
    public HoaDonNhapHang708() {
      }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getNgayNhapHang() {
        return ngayNhapHang;
    }

    public void setNgayNhapHang(LocalDate ngayNhapHang2) {
        this.ngayNhapHang = ngayNhapHang2;
    }

    public List<HangNhap708> getDsHangNhap() {
        return dsHangNhap;
    }

    public void setDsHangNhap(List<HangNhap708> dsHangNhap) {
        this.dsHangNhap = dsHangNhap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
}
