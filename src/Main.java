
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ThuVien library = new ThuVien();
        Scanner scanner = new Scanner(System.in);
        //menu
        while (true) {
            System.out.println("\n----- MENU -------");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Tìm kiếm");
            System.out.println("3. Thêm sách");
            System.out.println("4. Sửa thông tin sách");
            System.out.println("5. Xóa sách");
            System.out.println("0. Thoát");
            System.out.print("Mời chọn: ");

            int choice1;
            try {
                choice1 = Integer.parseInt(scanner.nextLine()); 
                
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy nhập một số.");
                continue; 
            }
            

            switch (choice1) {
                case 1:
                    DisplayMenu(library, scanner);
                    break;
                case 2:
                    searchMenu(library, scanner);
                    break;
                case 3:
                    addBookMenu(library, scanner);
                    break;
                case 4:
                    updateBookMenu(library, scanner);
                    break;
                case 5:
                    deleteBookMenu(library, scanner);
                    break;
                case 0:
                    System.out.println("Chương trình đã kết thúc.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại.");
                    break;
            }
        }
    }
    //search
    private static void searchMenu(ThuVien library, Scanner scanner) {
        while (true) {
            System.out.println("\n---- SEARCH ----");
            System.out.println("1. Tìm theo mã sách");
            System.out.println("2. Tìm theo tựa sách");
            System.out.println("3. Tìm theo tên tác giả");
            System.out.println("0. Quay lại");
            System.out.print("Mời chọn: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine()); 
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy nhập một số.");
                continue; 
            }
           
            
            
            switch (choice) {
                case 1:
                    System.out.print("Nhập mã sách: ");
                    String maSach = scanner.nextLine();
                    Sach foundBook = library.searchByCode(maSach);
                    if (foundBook != null) {
                        System.out.println("Sách được tìm thấy:\n" + foundBook);
                    } else {
                        System.out.println("Không tìm thấy sách với mã sách " + maSach);
                    }
                    break;
                case 2:
                    System.out.print("Nhập tựa sách: ");
                    String tuaSach = scanner.nextLine();
                    List<Sach> booksByTitle = library.searchByTitle(tuaSach);
                    if (!booksByTitle.isEmpty()) {
                        System.out.println("Sách được tìm thấy:");
                        for (Sach book : booksByTitle) {
                            System.out.println(book);
                        }
                    } else {
                        System.out.println("Không tìm thấy sách với tựa sách " + tuaSach);
                    }
                    break;
                case 3:
                    System.out.print("Nhập tên tác giả: ");
                    String tenTacGia = scanner.nextLine();
                    List<Sach> booksByAuthor = library.searchByAuthor(tenTacGia);
                    if (!booksByAuthor.isEmpty()) {
                        System.out.println("Sách được tìm thấy:");
                        for (Sach book : booksByAuthor) {
                            System.out.println(book);
                        }
                    } else {
                        System.out.println("Không tìm thấy sách của tác giả " + tenTacGia);
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại.");
                    break;
            }
        }
    }
    //hien thi
    private static void DisplayMenu(ThuVien library, Scanner scanner) {
        while (true) {
            System.out.println("\n---- Hiển thị ----");
            System.out.println("1. theo mã sách");
            System.out.println("2. theo tựa sách");
            System.out.println("3. theo tên tác giả");
            System.out.println("4. theo năm sản xuất");
            System.out.println("0. Quay lại");
            System.out.print("Mời chọn: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine()); // Đọc lựa chọn dưới dạng số
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy nhập một số.");
                continue; 
            }
           
            
            
            switch (choice) {
                case 1:
                	System.out.println("Sách được hiển thị theo mã sách");
                	System.out.println("------------------------------------------------");
                	library.displayBooks1();
                	break;
                case 2:
                	System.out.println("Sách được hiển thị theo tựa sách");
                	System.out.println("------------------------------------------------");
                	library.displayBooks2();
                	break;
                case 3:
                	System.out.println("Sách được hiển thị theo tên tác giả");
                	System.out.println("------------------------------------------------");
                	library.displayBooks3();
                	break;
                case 4:
                	System.out.println("Sách được hiển thị theo năm sản xuất");
                	System.out.println("------------------------------------------------");
                	library.displayBooks4();
                	break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại.");
                    break;
            }
        }
    }

    //add sach
    private static void addBookMenu(ThuVien library, Scanner scanner) {
        System.out.print("Nhập mã sách: ");
        String maSach = scanner.nextLine();
        System.out.print("Nhập tựa sách: ");
        String tuaSach = scanner.nextLine();
        System.out.print("Nhập tên tác giả: ");
        String tenTacGia = scanner.nextLine();
        System.out.print("Nhập thể loại: ");
        String theLoai = scanner.nextLine();
        System.out.print("Nhập năm xuất bản: ");
        int namXB = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng trống

        Sach newBook = new Sach(maSach, tuaSach, tenTacGia, theLoai, namXB);
        library.addBook(newBook);
        System.out.println("Sách đã được thêm vào thư viện.");
    }
    //sua sach
    private static void updateBookMenu(ThuVien library, Scanner scanner) {
        System.out.print("Nhập mã sách cần sửa: ");
        String maSach = scanner.nextLine();
        Sach bookToEdit = library.searchByCode(maSach);

        if (bookToEdit != null) {
            System.out.print("Nhập tựa sách mới: ");
            String tuaSach = scanner.nextLine();
            System.out.print("Nhập tên tác giả mới: ");
            String tenTacGia = scanner.nextLine();
            System.out.print("Nhập thể loại mới: ");
            String theLoai = scanner.nextLine();
            System.out.print("Nhập năm xuất bản mới: ");
            int namXB = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng trống
             
            library.updateBook(maSach, tuaSach, tenTacGia, theLoai, namXB);
            System.out.println("Sách đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy sách với mã sách " + maSach);
        }
    }
    //xoa sach
    private static void deleteBookMenu(ThuVien library, Scanner scanner) {
        System.out.print("Nhập mã sách cần xóa: ");
        String maSach = scanner.nextLine();
        Sach bookToDelete = library.searchByCode(maSach);

        if (bookToDelete != null) {
            library.deleteBook(maSach);
            System.out.println("Sách đã được xóa khỏi thư viện.");
        } else {
            System.out.println("Không tìm thấy sách với mã sách " + maSach);
        }
    }
}
