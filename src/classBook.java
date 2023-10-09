import java.util.Scanner;

public class classBook {
    int   idBook=1;
    String bookName;
    String author;
    String description;
    double importPrice;
    double exportPrice;
    float interset;
    boolean bookStatus;
    private static int totalBooks = 1;
    public classBook(){
        this.idBook=totalBooks++;
    }
    public int getIdBookBook() {
        return idBook;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterset() {
        return interset;
    }

    public void setInterset(float interset) {
        this.interset = interset;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public classBook(String bookName, String author, String description, double importPrice, double exportPrice, float interset, boolean bookStatus) {
        this.bookName = bookName;
        this.author = author;
        this.description = description;
        this.importPrice = importPrice;
        this.exportPrice = importPrice * 1.2;
        this.interset = (float) (exportPrice - importPrice);
        this.bookStatus = bookStatus;
    };
public void displayData(){
    System.out.println("Mã sách là " + idBook+
            " Tên Sách Là : " + bookName+
            " Tác giả : " + author+
            " Mô Tả : " + description+
            " Gía Nhập : " + importPrice+
            " Gía Xuất : " + exportPrice +
            " Lợi Nhuận : " + interset+
            " Trạng Thái :  " + !bookStatus

    );
}
public void inputData(Scanner scanner){
    System.out.println("Nhập Tên Sách");
    this.bookName = scanner.nextLine();
    System.out.println("Nhập Tác Gỉa");
    this.author = scanner.nextLine();
    System.out.println("Mô Tả Sách");
    this.description = scanner.nextLine();
    System.out.println("Gía Nhập");
    this.importPrice = Double.parseDouble(scanner.nextLine());
    this.exportPrice = importPrice * 1.2;
    this.interset = (float) (exportPrice - importPrice);
}
}

