import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

// Lớp cha
class Sach {
    private String maSach;
    protected int soLuong;
    protected double donGia;
    protected Date ngaynhap;
    protected String nxb;

    // Phương thức chung để lớp con ghi đè (@Override)
    public double Thanhtien() {
        return 0;
    }

    public Sach(String maSach, int soLuong, double donGia, Date ngaynhap, String nxb) {
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.ngaynhap = ngaynhap;
        this.nxb = nxb;
    }

    public String getMaSach() {
        return maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public String getNxb() {
        return nxb;
    }

    public void inthongtinsach() {
        System.out.println("--------------------------------------------------");
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ngay nhap: " + ngaynhap);
        System.out.println("NXB: " + nxb);
        System.out.println("So luong: " + soLuong);
        System.out.println("Don gia: " + donGia);
        System.out.println("Thanh tien: " + Thanhtien());
    }
}

// Lớp con kế thừa cha "Sach" - Sách giáo khoa
class Sachgiaokhoa extends Sach {
    public String tinhTrang;

    public Sachgiaokhoa(String tinhTrang, String maSach, int soLuong, double donGia, Date ngaynhap, String nxb) {
        super(maSach, soLuong, donGia, ngaynhap, nxb);
        this.tinhTrang = tinhTrang;
    }

    @Override
    public double Thanhtien() {
        if (tinhTrang.equalsIgnoreCase("Moi")) {
            return soLuong * donGia;
        } else {
            return soLuong * donGia * 0.5;
        }
    }

    @Override
    public void inthongtinsach() {
        System.out.println("[Sach giao khoa]");
        super.inthongtinsach();
        System.out.println("Tinh trang: " + tinhTrang);
    }
}

// Lớp con kế thừa cha "Sach" - Sách tham khảo
class Sachthamkhao extends Sach {
    public double thue;

    public Sachthamkhao(double thue, String maSach, int soLuong, double donGia, Date ngaynhap, String nxb) {
        super(maSach, soLuong, donGia, ngaynhap, nxb);
        this.thue = thue;
    }

    @Override
    public double Thanhtien() {
        return soLuong * donGia + thue;
    }

    @Override
    public void inthongtinsach() {
        System.out.println("[Sach tham khao]");
        super.inthongtinsach();
        System.out.println("Thue: " + thue);
    }
}

public class BTTuan9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Sach> dsSach = new ArrayList<>();

        System.out.print("Nhap so luong sach can nhap: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        // 1. Nhập danh sách các loại sách
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhap thong tin cuon sach thu " + (i + 1) + " ---");
            System.out.print("Chon loai sach (1: Sach giao khoa, 2: Sach tham khao): ");
            int loai = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Ma sach: ");
            String maSach = sc.nextLine().trim();

            System.out.print("Ngay nhap (yyyy-MM-dd, vi du 2026-11-26): ");
            Date ngayNhap = Date.valueOf(sc.nextLine().trim());

            System.out.print("Nha xuat ban: ");
            String nxb = sc.nextLine().trim();

            System.out.print("So luong: ");
            int soLuong = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Don gia: ");
            double donGia = Double.parseDouble(sc.nextLine().trim());

            if (loai == 1) {
                System.out.print("Tinh trang (Moi / Cu): ");
                String tinhTrang = sc.nextLine().trim();
                dsSach.add(new Sachgiaokhoa(tinhTrang, maSach, soLuong, donGia, ngayNhap, nxb));
            } else if (loai == 2) {
                System.out.print("Thue: ");
                double thue = Double.parseDouble(sc.nextLine().trim());
                dsSach.add(new Sachthamkhao(thue, maSach, soLuong, donGia, ngayNhap, nxb));
            } else {
                System.out.println("Loai sach khong hop le, bo qua cuon nay!");
            }
        }

        // 2. Xuất danh sách các loại sách
        System.out.println("\n================ DANH SACH SACH ================");
        for (Sach s : dsSach) {
            s.inthongtinsach();
        }

        // 3. Tính tổng thành tiền cho từng loại & trung bình cộng đơn giá sách tham khảo
        double tongTienSGK = 0;
        double tongTienSTK = 0;
        double tongDonGiaSTK = 0;
        int demSTK = 0;

        for (Sach s : dsSach) {
            if (s instanceof Sachgiaokhoa) {
                tongTienSGK += s.Thanhtien();
            } else if (s instanceof Sachthamkhao) {
                tongTienSTK += s.Thanhtien();
                tongDonGiaSTK += s.getDonGia();
                demSTK++;
            }
        }

        System.out.println("\n================ THONG KE TIEN ================");
        System.out.println("Tong thanh tien Sach giao khoa: " + tongTienSGK);
        System.out.println("Tong thanh tien Sach tham khao: " + tongTienSTK);

        if (demSTK > 0) {
            double trungBinhDonGiaSTK = tongDonGiaSTK / demSTK;
            System.out.println("Trung binh cong don gia Sach tham khao: " + trungBinhDonGiaSTK);
        } else {
            System.out.println("Khong co Sach tham khao de tinh trung binh cong don gia.");
        }

        // 4. Xuất ra các sách giáo khoa của nhà xuất bản X
        System.out.print("\nNhap ten nha xuat ban X can tim Sach giao khoa: ");
        String nxbX = sc.nextLine().trim();

        System.out.println("================ SACH GIAO KHOA CUA NXB " + nxbX + " ================");
        boolean timThay = false;
        for (Sach s : dsSach) {
            if (s instanceof Sachgiaokhoa && s.getNxb().equalsIgnoreCase(nxbX)) {
                s.inthongtinsach();
                timThay = true;
            }
        }
        if (!timThay) {
            System.out.println("Khong tim thay sach giao khoa nao cua NXB " + nxbX);
        }

        sc.close();
    }
}