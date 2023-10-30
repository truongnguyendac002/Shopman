package model708;

public class NhanVien708 extends ThanhVien708 {
    private String viTri;
    private String maNhanVien;

    public NhanVien708(int id, String tenTaiKhoan, String matKhau, String vaiTro, String viTri, String maNhanVien) {
        super(id, tenTaiKhoan, matKhau, vaiTro);
        this.viTri = viTri;
        this.maNhanVien = maNhanVien;
    }

    // Getters và Setters
    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
}

