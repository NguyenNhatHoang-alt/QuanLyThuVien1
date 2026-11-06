import java.util.ArrayList;
import java.util.Scanner;

// Lớp Sach đại diện cho thông tin của một cuốn sách (Bài 3)
class Sach {
    String maSach;
    String tenSach;
    double donGia;
    int soLuong;

    // Hàm khởi tạo (Constructor) để gán dữ liệu ban đầu
    public Sach(String maSach, String tenSach, double donGia, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }
}

public class BTTuan6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Khởi tạo ArrayList chứa danh sách các cuốn sách (thay đổi kích thước linh hoạt)
        ArrayList<Sach> danhSachSach = new ArrayList<>();
        int chon;

        // BÀI 4: Xây dựng menu hoàn chỉnh lặp liên tục đến khi chọn Thoát
        do {
            System.out.println("\n=================== MENU QUẢN LÝ THƯ VIỆN ===================");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị danh sách sách");
            System.out.println("3. Tìm sách theo mã");
            System.out.println("4. Xóa sách theo mã");
            System.out.println("5. Sửa thông tin sách theo mã");
            System.out.println("6. Tính tổng số lượng sách");
            System.out.println("7. Tính tổng giá trị sách trong kho");
            System.out.println("8. Thoát chương trình");
            System.out.println("=============================================================");
            System.out.print("Nhập lựa chọn của bạn (1-8): ");
            chon = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm sau khi nhập số

            switch (chon) {
                case 1: // Thêm sách
                    System.out.println("\n--- NHẬP THÔNG TIN SÁCH MỚI ---");
                    System.out.print("Nhập mã sách: ");
                    String ma = scanner.nextLine();
                    System.out.print("Nhập tên sách: ");
                    String ten = scanner.nextLine();
                    System.out.print("Nhập đơn giá: ");
                    double gia = scanner.nextDouble();
                    System.out.print("Nhập số lượng: ");
                    int sl = scanner.nextInt();
                    scanner.nextLine(); // Xóa bộ đệm

                    // Tạo đối tượng sách mới và thêm vào ArrayList
                    Sach sachMoi = new Sach(ma, ten, gia, sl);
                    danhSachSach.add(sachMoi);
                    System.out.println("[THÔNG BÁO] Thêm sách thành công!");
                    break;

                case 2: // Hiển thị sách
                    if (danhSachSach.isEmpty()) {
                        System.out.println("\n[THÔNG BÁO] Thư viện hiện chưa có cuốn sách nào!");
                    } else {
                        System.out.println("\n======================== DANH SÁCH SÁCH TRONG THƯ VIỆN ========================");
                        System.out.printf("%-10s | %-25s | %-12s | %-10s\n", "Mã sách", "Tên sách", "Đơn giá", "Số lượng");
                        System.out.println("-------------------------------------------------------------------------------");
                        for (Sach s : danhSachSach) {
                            System.out.printf("%-10s | %-25s | %-12.1f | %-10d\n", s.maSach, s.tenSach, s.donGia, s.soLuong);
                        }
                        System.out.println("===============================================================================");
                    }
                    break;

                case 3: // Tìm sách theo mã
                    if (danhSachSach.isEmpty()) {
                        System.out.println("\n[THÔNG BÁO] Thư viện chưa có dữ liệu để tìm kiếm!");
                        break;
                    }
                    System.out.print("\nNhập mã sách cần tìm: ");
                    String maTim = scanner.nextLine();
                    boolean timThay = false;

                    for (Sach s : danhSachSach) {
                        if (s.maSach.equalsIgnoreCase(maTim)) {
                            System.out.println("\n>>> ĐÃ TÌM THẤY SÁCH <<<");
                            System.out.println("Mã sách  : " + s.maSach);
                            System.out.println("Tên sách : " + s.tenSach);
                            System.out.println("Đơn giá  : " + s.donGia + " VNĐ");
                            System.out.println("Số lượng : " + s.soLuong + " cuốn");
                            timThay = true;
                            break;
                        }
                    }
                    if (!timThay) {
                        System.out.println("\n[THÔNG BÁO] Không tìm thấy cuốn sách có mã: " + maTim);
                    }
                    break;

                case 4: // Xóa sách theo mã
                    if (danhSachSach.isEmpty()) {
                        System.out.println("\n[THÔNG BÁO] Thư viện chưa có sách để xóa!");
                        break;
                    }
                    System.out.print("\nNhập mã sách cần xóa: ");
                    String maXoa = scanner.nextLine();
                    boolean daXoa = false;

                    for (int i = 0; i < danhSachSach.size(); i++) {
                        if (danhSachSach.get(i).maSach.equalsIgnoreCase(maXoa)) {
                            danhSachSach.remove(i); // Xóa phần tử khỏi ArrayList
                            System.out.println("\n[THÔNG BÁO] Đã xóa thành công sách có mã: " + maXoa);
                            daXoa = true;
                            break;
                        }
                    }
                    if (!daXoa) {
                        System.out.println("\n[THÔNG BÁO] Không tìm thấy mã sách cần xóa.");
                    }
                    break;

                case 5: // Sửa thông tin sách theo mã
                    if (danhSachSach.isEmpty()) {
                        System.out.println("\n[THÔNG BÁO] Thư viện chưa có sách để sửa!");
                        break;
                    }
                    System.out.print("\nNhập mã sách cần sửa thông tin: ");
                    String maSua = scanner.nextLine();
                    boolean daSua = false;

                    for (Sach s : danhSachSach) {
                        if (s.maSach.equalsIgnoreCase(maSua)) {
                            System.out.print("Nhập tên sách mới: ");
                            s.tenSach = scanner.nextLine();
                            System.out.print("Nhập đơn giá mới: ");
                            s.donGia = scanner.nextDouble();
                            System.out.print("Nhập số lượng mới: ");
                            s.soLuong = scanner.nextInt();
                            scanner.nextLine(); // Xóa bộ đệm

                            System.out.println("\n[THÔNG BÁO] Cập nhật thông tin sách thành công!");
                            daSua = true;
                            break;
                        }
                    }
                    if (!daSua) {
                        System.out.println("\n[THÔNG BÁO] Không tìm thấy mã sách cần sửa.");
                    }
                    break;

                case 6: // Tính tổng số lượng
                    int tongSoLuong = 0;
                    for (Sach s : danhSachSach) {
                        tongSoLuong += s.soLuong;
                    }
                    System.out.println("\n>>> Tổng số lượng tất cả sách trong kho: " + tongSoLuong + " cuốn");
                    break;

                case 7: // Tính tổng giá trị
                    double tongGiaTri = 0;
                    for (Sach s : danhSachSach) {
                        tongGiaTri += (s.donGia * s.soLuong);
                    }
                    System.out.println("\n>>> Tổng giá trị kho sách (Đơn giá × Số lượng): " + tongGiaTri + " VNĐ");
                    break;

                case 8: // Thoát chương trình
                    System.out.println("\nCảm ơn bạn đã sử dụng chương trình quản lý thư viện. Tạm biệt!");
                    break;

                default:
                    System.out.println("\n[LỖI] Lựa chọn không hợp lệ! Vui lòng chọn từ số 1 đến 8.");
            }

        } while (chon != 8);

        scanner.close();
    }
}