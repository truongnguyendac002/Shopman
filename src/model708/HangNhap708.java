package model708;

public class HangNhap708 extends HangHoa708 {
    private double donGia;
    private int soLuong;
    private int idHangHoa;
    private int idHoaDon;

    // Constructors

    public HangNhap708() {
        super();
    }

    public HangNhap708(int id, String ten, String loai, String moTa, int nhaCungCapID, double donGia, int soLuong, int idHangHoa) {
        super(id, ten, loai, moTa, nhaCungCapID);
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.idHangHoa = idHangHoa;
    }

    // Getter and Setter methods

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getIdHangHoa() {
        return idHangHoa;
    }

    public void setIdHangHoa(int idHangHoa) {
        this.idHangHoa = idHangHoa;
    }

	public int getIdHoaDon() {
		return idHoaDon;
	}

	public void setIdHoaDon(int idHoaDon) {
		this.idHoaDon = idHoaDon;
	}
}
