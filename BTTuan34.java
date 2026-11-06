import java.util.Scanner;

public class BTTuan34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CHUONG TRINH QUAN LY SACH (TUAN 3 & TUAN 4) ===");
        
        // --- BƯỚC 1: NHẬP THÔNG TIN SÁCH (Tuần 3 - Bài 1) ---
        System.out.print("Nhap ma sach: ");
        String maSach = scanner.nextLine();

        System.out.print("Nhap ten sach: ");
        String tenSach = scanner.nextLine();

        System.out.print("Nhap tac gia: ");
        String tacGia = scanner.nextLine();

        System.out.print("Nhap nam xuat ban: ");
        int namXuatBan = scanner.nextInt();

        System.out.print("Nhap don gia: ");
        double donGia = scanner.nextDouble();

        System.out.print("Nhap so luong: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng trống sau khi nhập số

        // --- BƯỚC 2: KIỂM TRA ĐIỀU KIỆN HỢP LỆ (Tuần 4 - Bài 1) ---
        // Giả sử năm hiện tại là 2026, năm xuất bản phải từ 1000 đến 2026
        boolean hopLe = (donGia > 0) && (soLuong >= 0) && (namXuatBan > 1000 && namXuatBan <= 2026);

        if (!hopLe) {
            System.out.println("\n[LOI] Thong tin sach khong hop le!");
            System.out.println("- Don gia sach phai lon hon 0.");
            System.out.println("- So luong phai lon hon hoac bang 0.");
            System.out.println("- Nam xuat ban phai tu 1001 den 2026.");
            scanner.close();
            return; // Dừng chương trình nếu dữ liệu sai
        }

        // --- BƯỚC 3: CHỌN LOẠI SÁCH (Tuần 4 - Bài 4) ---
        System.out.println("\n--- CHON LOAI SACH ---");
        System.out.println("1. Sach giao khoa");
        System.out.println("2. Sach kham khao");
        System.out.println("3. Sach van hoc");
        System.out.print("Nhap lua chon sach (1-3): ");
        int chonLoai = scanner.nextInt();
        
        String tenLoaiSach = "";
        switch (chonLoai) {
            case 1:
                tenLoaiSach = "Sach giao khoa";
                break;
            case 2:
                tenLoaiSach = "Sach kham khao";
                break;
            case 3:
                tenLoaiSach = "Sach van hoc";
                break;
            default:
                tenLoaiSach = "Sach khac";
                break;
        }

        // --- BƯỚC 4: TÍNH TOÁN TÀI CHÍNH (Tuần 3 - Bài 2, 3, 4) ---
        double thanhTien = donGia * soLuong;
        double phiVanChuyen = thanhTien * 0.05; // 5% giá trị sách
        double tongTienNhap = thanhTien + phiVanChuyen;

        // --- BƯỚC 5: PHÂN LOẠI GIÁ & TỒN KHO (Tuần 4 - Bài 2 & 3) ---
        // Phân loại giá
        String phanLoaiGia = "";
        if (donGia < 50000) {
            phanLoaiGia = "Sach gia thap";
        } else if (donGia <= 100000) {
            phanLoaiGia = "Sach gia trung binh";
        } else if (donGia <= 200000) {
            phanLoaiGia = "Sach gia cao";
        } else {
            phanLoaiGia = "Sach gia dat biet";
        }

        // Phân loại tồn kho
        String phanLoaiTonKho = "";
        if (soLuong == 0) {
            phanLoaiTonKho = "Het sach";
        } else if (soLuong <= 5) {
            phanLoaiTonKho = "Sap het";
        } else if (soLuong <= 20) {
            phanLoaiTonKho = "Con it";
        } else {
            phanLoaiTonKho = "Con nhieu";
        }

        // --- BƯỚC 6: HIỂN THỊ KẾT QUẢ RA MÀN HÌNH ---
        System.out.println("\n=========================================================");
        System.out.println("                  PHIEU NHAP KHO SACH                    ");
        System.out.println("=========================================================");
        System.out.println(" Ma sach       : " + maSach);
        System.out.println(" Ten sach      : " + tenSach);
        System.out.println(" Tac gia       : " + tacGia);
        System.out.println(" Nam xuat ban  : " + namXuatBan);
        System.out.println(" Loai sach     : " + tenLoaiSach);
        System.out.println(" Don gia       : " + donGia + " VNĐ (" + phanLoaiGia + ")");
        System.out.println(" So luong      : " + soLuong + " cuốn (" + phanLoaiTonKho + ")");
        System.out.println("---------------------------------------------------------");
        System.out.println(" Thanh tien    : " + thanhTien + " VNĐ");
        System.out.println(" Phi van chuyen: " + phiVanChuyen + " VNĐ (5%)");
        System.out.println(" Tong tien nhap: " + tongTienNhap + " VNĐ");
        System.out.println("=========================================================");

        scanner.close();
    }
}