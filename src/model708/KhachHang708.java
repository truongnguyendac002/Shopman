package model708;

public class KhachHang708 extends ThanhVien708 {
    private String diaChi;
    private String email;
    private String sdt;

    public KhachHang708(int id, String tenTaiKhoan, String matKhau, String vaiTro, String diaChi, String email, String sdt) {
        super(id, tenTaiKhoan, matKhau, vaiTro);
        this.diaChi = diaChi;
        this.email = email;
        this.sdt = sdt;
    }
    public KhachHang708(int id, String diaChi, String email, String sdt) {
        super(id);
        this.diaChi = diaChi;
        this.email = email;
        this.sdt = sdt;
    }

    // Getters và Setters
    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}

