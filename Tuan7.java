import java.util.ArrayList;

// Lớp Sach đặt chung trong file (không có từ khóa "public")
class Sach {
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
    }

    public String getMaSach() {
        return maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void hienThiThongTin() {
        System.out.println("--------------------------------------------------");
        System.out.println("Mã sách      : " + maSach);
        System.out.println("Tiêu đề      : " + tieuDe);
        System.out.println("Tác giả      : " + tacGia);
        System.out.println("Năm xuất bản : " + namXuatBan);
        System.out.println("Số lượng     : " + soLuong);
    }
}

// Lớp chính chứa hàm main phải là "public" và trùng tên file Test.java
public class Tuan7 {
    public static void main(String[] args) {
        ArrayList<Sach> danhSachSach = new ArrayList<>();

        // Tạo và thêm các đối tượng Sach vào danh sách
        danhSachSach.add(new Sach("S01", "Lập trình Java cơ bản", "Nguyễn Văn A", 2023, 10));
        danhSachSach.add(new Sach("S02", "Cấu trúc dữ liệu và giải thuật", "Trần Thị B", 2022, 5));
        danhSachSach.add(new Sach("S03", "Clean Code", "Robert C. Martin", 2021, 8));
        danhSachSach.add(new Sach("S04", "Head First Java", "Kathy Sierra", 2024, 6));

        // 1. Hiển thị danh sách
        System.out.println("=== DANH SÁCH SÁCH TRONG THƯ VIỆN ===");
        for (Sach s : danhSachSach) {
            s.hienThiThongTin();
        }

        // 2. Thống kê số lượng
        System.out.println("\nTổng số đầu sách: " + danhSachSach.size());
        int tongSoLuong = 0;
        for (Sach s : danhSachSach) {
            tongSoLuong += s.getSoLuong();
        }
        System.out.println("Tổng số quyển sách: " + tongSoLuong);

        // 3. Tìm sách theo mã
        String maCanTim = "S02";
        System.out.println("\n=== TÌM SÁCH MÃ: " + maCanTim + " ===");
        boolean timThay = false;
        for (Sach s : danhSachSach) {
            if (s.getMaSach().equalsIgnoreCase(maCanTim)) {
                s.hienThiThongTin();
                timThay = true;
                break;
            }
        }
        if (!timThay) {
            System.out.println("Không tìm thấy sách mã " + maCanTim);
        }

        // 4. Xóa sách theo mã
        String maCanXoa = "S03";
        for (int i = 0; i < danhSachSach.size(); i++) {
            if (danhSachSach.get(i).getMaSach().equalsIgnoreCase(maCanXoa)) {
                danhSachSach.remove(i);
                System.out.println("\nĐã xóa sách mã " + maCanXoa);
                break;
            }
        }

        // 5. Hiển thị lại danh sách sau khi xóa
        System.out.println("\n=== DANH SÁCH SAU KHI XÓA ===");
        for (Sach s : danhSachSach) {
            s.hienThiThongTin();
        }
    }
}