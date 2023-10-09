import java.util.Scanner;

public class book {
    static Scanner scanner = new Scanner(System.in);
    static classBook[] classBooks = new classBook[100];
    static int idBook = 0;

    public static void main(String[] args) {
        while (true) {
            System.out.println("Nhập số từ 1 - 6 để thực hiện thao tác sau : ");
            System.out.println("1 . Thêm sách ");
            System.out.println("2 . Hiển thị thông tin sách");
            System.out.println("3 . Sắp xếp theo lợi nhuận tăng dần ");
            System.out.println("4 . Xóa sách theo mã  ");
            System.out.println("5 . Tìm kiếm tương đối theo tên sách hoặc mô tả");
            System.out.println("6 . Thay đổi thông tin sách theo mã sách");
            System.out.println("Nhập bất kì khác từ 1-6 để thoát");
            int input = Integer.parseInt(scanner.nextLine());
            handle(input);
        }
    }

    private static void handle(int input) {
        switch (input) {
            case 1:
                addBook();
                break;
            case 2:
                renderBook();
                break;
            case 3:
                arrange();
                break;
            case 4:
                deleteBook();
                break;
            case 5:
                searchBook();
                break;
            case 6:
                updateBook();
                break;
            default:
                System.exit(0);
        }
    }

    private static void renderBook() {
        for (int i = 0; i < idBook; i++) {
            classBooks[i].displayData();
        }
    }

    private static void addBook() {
        if (idBook < classBooks.length) {
            classBook classBook = new classBook();
            classBook.inputData(scanner);
            if (classBook.bookName.length() != 0 && classBook.author.length() != 0 && classBook.description.length() != 0 && classBook.importPrice > 0) {
                classBooks[idBook++] = classBook;
            } else {
                System.out.println("Bạn chưa nhập đủ giá trị cho từng trường");
            }
        } else {
            System.out.println("Danh sách sách đã đầy. Không thể thêm sách mới.");
        }
    }

    private static void deleteBook() {
        System.out.println("Nhập mã sách cần xóa");
        int masach = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < idBook; i++) {
            if (masach == classBooks[i].getIdBookBook()) {
                for (int j = i; j < idBook - 1; j++) {
                    classBooks[j] = classBooks[j + 1];
                }
                idBook--;
                System.out.println("Đã xóa thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy mã sách bạn vừa nhập");
    }

    private static void arrange() {
        for (int i = 0; i < idBook - 1; i++) {
            for (int j = 0; j < idBook - i - 1; j++) {
                if (classBooks[j].getInterset() > classBooks[j + 1].getInterset()) {
                    classBook temp = classBooks[j];
                    classBooks[j] = classBooks[j + 1];
                    classBooks[j + 1] = temp;
                }
            }
        }
        for (int k=0;k<idBook;k++){
            classBooks[k].displayData();
        }
    }

    private static void searchBook() {
        System.out.println("Nhập tên sách hoặc mô tả để tìm kiếm ");
        String search = scanner.nextLine().toLowerCase();
        for (int i = 0; i < idBook; i++) {
            if (classBooks[i].getBookName().toLowerCase().contains(search)
                    || classBooks[i].getDescription().toLowerCase().contains(search)) {
                classBooks[i].displayData();
            }
        }

    }
    private static void updateBook() {
        System.out.println("Nhập mã sách muốn sửa");
        int updateBook = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < idBook; i++) {
            if (updateBook == classBooks[i].getIdBookBook()) {
                System.out.println("Mã sách bạn muốn sửa là ");
                classBooks[i].displayData();
                classBooks[i].inputData(scanner);
                System.out.println("Cập Nhập Thành Công");
                return;
            }
        }
        System.out.println("Không có sách bạn muốn sửa");
    }}

