import java.io.*;
import java.util.*;

public class ThuVien {
    private List<Sach> books;
    private String dataFilePath = "C:/j78_BaiTapCuoiKhoa/book_data.txt"; //file e kb yeu cau la ng dung nhap tu ngoai vao hay co dinh 
    																	//nen e de co dinh 

    public ThuVien() {
        books = new ArrayList<>();
        loadBooksFromFile();
    }

    public void loadBooksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    String maSach = parts[0].trim();
                    String tuaSach = parts[1].trim();
                    String tenTacGia = parts[2].trim();
                    String theLoai = parts[3].trim();
                    int namXB = Integer.parseInt(parts[4].trim());

                    Sach sach = new Sach(maSach, tuaSach, tenTacGia, theLoai, namXB);
                    books.add(sach);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveBooksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFilePath))) {
            for (Sach book : books) {
                writer.write(book.getMaSach() + ";" + book.getTuaSach() + ";" + book.getTenTacGia() + ";" + book.getTheLoai() + ";" + book.getNamXB());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBook(Sach book) {
        books.add(book);
        saveBooksToFile();
    }

    public void deleteBook(String maSach) {
        books.removeIf(book -> book.getMaSach().equals(maSach));
        saveBooksToFile();
    }

    public void updateBook(String maSach, String tuaSach, String tenTacGia, String theLoai, int namXB) {
        for (Sach book : books) {
            if (book.getMaSach().equals(maSach)) {
                
                book.setTuaSach(tuaSach);
                book.setTenTacGia(tenTacGia);
                book.setTheLoai(theLoai);
                book.setNamXB(namXB);
                saveBooksToFile();
                return;
            }
        }
        System.out.println("Không tìm thấy sách với mã sách " + maSach);
    }

    public void displayBooks1() {
        Collections.sort(books, Comparator.comparingInt(book -> Integer.parseInt(book.getMaSach())));
        for (Sach book : books) {
            System.out.println(book);
        }
    }
    public void displayBooks2() {

    	Collections.sort(books, Comparator.comparing(Sach::getTuaSach)); 

        for (Sach book : books) {
            System.out.println(book);
        }
    }
    public void displayBooks3() {

    	Collections.sort(books, Comparator.comparing(Sach::getTenTacGia)); 

        for (Sach book : books) {
            System.out.println(book);
        }
    }
    public void displayBooks4() {
    	 Comparator<Sach> comparator = Comparator.comparingInt(book -> book.getNamXB()); //xap xep theo nxb voi nam lon len tren = cach dao ngươc
    			 Collections.sort(books, comparator.reversed()); //bang reversed
        for (Sach book : books) {
            System.out.println(book);
        }
    }

    public List<Sach> searchByTitle(String title) {
        List<Sach> result = new ArrayList<>();
        for (Sach book : books) {
            if (book.getTuaSach().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Sach> searchByAuthor(String author) {
        List<Sach> result = new ArrayList<>();
        for (Sach book : books) {
            if (book.getTenTacGia().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public Sach searchByCode(String maSach) {
        for (Sach book : books) {
            if (book.getMaSach().equalsIgnoreCase(maSach)) {
                return book;
            }
        }
        return null;
    }
}

