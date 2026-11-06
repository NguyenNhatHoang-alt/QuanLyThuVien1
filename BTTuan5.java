import java.util.Scanner;

public class BTTuan5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Khai báo các mảng để lưu thông tin cho n cuốn sách
        int n = 0;
        String[] maSach = null;
        String[] tenSach = null;
        String[] tacGia = null;
        double[] donGia = null;
        int[] soLuong = null;

        int chon;
        // BÀI 3: Menu lặp đến khi chọn Thoát (chọn 4)
        do {
            System.out.println("\n================ MENU QUẢN LÝ THƯ VIỆN ================");
            System.out.println("1. Nhập danh sách n cuốn sách");
            System.out.println("2. Hiển thị danh sách, tổng số lượng và tổng giá trị sách");
            System.out.println("3. Tìm kiếm sách theo mã sách");
            System.out.println("4. Thoát chương trình");
            System.out.println("=======================================================");
            System.out.print("Nhập lựa chọn của bạn (1-4): ");
            chon = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm sau khi nhập số

            switch (chon) {
                case 1:
                    // BÀI 1: Nhập n sách bằng vòng lặp
                    System.out.print("\nNhập số lượng sách cần quản lý (n): ");
                    n = scanner.nextInt();
                    scanner.nextLine(); // Xóa bộ đệm

                    // Cấp phát kích thước cho các mảng dựa trên n
                    maSach = new String[n];
                    tenSach = new String[n];
                    tacGia = new String[n];
                    donGia = new double[n];
                    soLuong = new int[n];

                    for (int i = 0; i < n; i++) {
                        System.out.println("\n--- Nhập thông tin cuốn sách thứ " + (i + 1) + " ---");
                        System.out.print("Nhập mã sách: ");
                        maSach[i] = scanner.nextLine();
                        System.out.print("Nhập tên sách: ");
                        tenSach[i] = scanner.nextLine();
                        System.out.print("Nhập tác giả: ");
                        tacGia[i] = scanner.nextLine();
                        System.out.print("Nhập đơn giá: ");
                        donGia[i] = scanner.nextDouble();
                        System.out.print("Nhập số lượng: ");
                        soLuong[i] = scanner.nextInt();
                        scanner.nextLine(); // Xóa bộ đệm
                    }
                    System.out.println("\n[THÔNG BÁO] Đã nhập thành công danh sách " + n + " cuốn sách!");
                    break;

                case 2:
                    // Kiểm tra xem đã nhập dữ liệu chưa
                    if (n == 0 || maSach == null) {
                        System.out.println("\n[LỖI] Chưa có dữ liệu sách! Vui lòng chọn chức năng 1 trước.");
                        break;
                    }

                    // BÀI 2: Tính tổng số lượng và tổng giá trị sách
                    int tongSoLuong = 0;
                    double tongGiaTri = 0;

                    System.out.println("\n====================== DANH SÁCH SÁCH TRONG THƯ VIỆN ======================");
                    System.out.printf("%-10s | %-20s | %-15s | %-10s | %-10s\n", "Mã sách", "Tên sách", "Tác giả", "Đơn giá", "Số lượng");
                    System.out.println("-------------------------------------------------------------------------");
                    
                    for (int i = 0; i < n; i++) {
                        System.out.printf("%-10s | %-20s | %-15s | %-10.1f | %-10d\n", 
                                          maSach[i], tenSach[i], tacGia[i], donGia[i], soLuong[i]);
                        
                        // Cộng dồn tổng số lượng và tổng giá trị (Đơn giá * Số lượng)
                        tongSoLuong += soLuong[i];
                        tongGiaTri += (donGia[i] * soLuong[i]);
                    }
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println(" Tổng số lượng sách trong kho : " + tongSoLuong + " cuốn");
                    System.out.println(" Tổng giá trị kho sách        : " + tongGiaTri + " VNĐ");
                    System.out.println("=========================================================================");
                    break;

                case 3:
                    // BÀI 4: Tìm sách theo mã
                    if (n == 0 || maSach == null) {
                        System.out.println("\n[LỖI] Chưa có dữ liệu sách để tìm kiếm!");
                        break;
                    }

                    System.out.print("\nNhập mã sách cần tìm kiếm: ");
                    String maTim = scanner.nextLine();
                    boolean timThay = false;

                    for (int i = 0; i < n; i++) {
                        // Dùng equalsIgnoreCase để so sánh mã (không phân biệt hoa thường)
                        if (maSach[i].equalsIgnoreCase(maTim)) {
                            System.out.println("\n>>> ĐÃ TÌM THẤY SÁCH <<<");
                            System.out.println("Mã sách      : " + maSach[i]);
                            System.out.println("Tên sách     : " + tenSach[i]);
                            System.out.println("Tác giả      : " + tacGia[i]);
                            System.out.println("Đơn giá      : " + donGia[i] + " VNĐ");
                            System.out.println("Số lượng     : " + soLuong[i] + " cuốn");
                            timThay = true;
                            break; // Tìm thấy thì dừng vòng lặp tìm kiếm
                        }
                    }

                    if (!timThay) {
                        System.out.println("\n[THÔNG BÁO] Không tìm thấy cuốn sách nào có mã là: " + maTim);
                    }
                    break;

                case 4:
                    System.out.println("\nCảm ơn bạn đã sử dụng chương trình quản lý thư viện. Tạm biệt!");
                    break;

                default:
                    System.out.println("\n[LỖI] Lựa chọn không hợp lệ! Vui lòng chọn từ số 1 đến 4.");
            }

        } while (chon != 4); // Lặp lại menu cho đến khi người dùng chọn 4 để thoát

        scanner.close();
    }
}