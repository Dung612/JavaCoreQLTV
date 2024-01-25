

public class Sach {
    private String maSach;
    private String tuaSach;
    private String tenTacGia;
    private String theLoai;
    private int namXB;

    public Sach(String maSach, String tuaSach, String tenTacGia, String theLoai, int namXB) {
        this.maSach = maSach;
        this.tuaSach = tuaSach;
        this.tenTacGia = tenTacGia;
        this.theLoai = theLoai;
        this.namXB = namXB;
    }
//set-get
	public String getMaSach() {
        return maSach;
    }

    public String getTuaSach() {
        return tuaSach;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public int getNamXB() {
        return namXB;
    }
   
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }
    public void setTuaSach(String tuaSach) {
        this.tuaSach = tuaSach;
    }
    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }
    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
    public void setNamXB(int namXB) {
        this.namXB = namXB;
    }


    @Override
    public String toString() {
        return "Mã sách: " + maSach + "\nTựa sách: " + tuaSach + "\nTên tác giả: " + tenTacGia + "\nThể loại: " + theLoai + "\nNăm XB: " + namXB + "\n";
    }
}

