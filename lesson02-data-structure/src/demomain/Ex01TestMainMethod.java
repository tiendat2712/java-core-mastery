package demomain;

public class Ex01TestMainMethod {
    /*
       Cú pháp khi tạo 1 hàm:
       --> [access modifier] [static] return_type method_name(parameters) {
              body: implementation
       }
       - access modifier: public, private, protected
       - static: thuộc phạm vi của class
                 lấy class(chứa nó) để gọi hàm static
       - return_type: kiểu dữ liệu trả về
                      void: ko có trả về gì cả
                      !void: trả về để sử dụng lại KQ trả về
       - method_name: tên hàm <đại diện cho chức năng>
       - parameters: danh sách tham số
                     đầu vào của hàm
     */
    public static void main(String[] args) {
        Ex01TestMainMethod ex = new Ex01TestMainMethod();
        drawTriangle();
        drawTriangleShortVer();
        System.out.println(ex.calSum(2,3));

    }

    private static void drawTriangle() {
        System.out.println("* ");
        System.out.println("* *");
        System.out.println("* * *");
        System.out.println("* * * *");
        System.out.println("* * * * *");
    }

    public static void drawTriangleShortVer() {
        for (int i = 1; i <= 5; i++) {          // hàng
            for (int j = 1; j <= i; j++) {      // số sao trên mỗi hàng
                System.out.print("* ");
            }
            System.out.println();               // xuống dòng sau mỗi hàng
        }
    }

    public int calSum(int a, int b) {
        return a + b;
    }
}
