package model708;

public class HangHoa708 {
    private int id;
    private String ten;
    private String loai;
    private String mota;
    private int nhaCungCapID;
    public HangHoa708() {
    }
    public HangHoa708(int id, String ten, String loai, String mota, int nhaCungCapID) {
        this.id = id;
        this.ten = ten;
        this.loai = loai;
        this.mota = mota;
        this.nhaCungCapID = nhaCungCapID;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getNhaCungCapID() {
        return nhaCungCapID;
    }

    public void setNhaCungCapID(int nhaCungCapID) {
        this.nhaCungCapID = nhaCungCapID;
    }
}
