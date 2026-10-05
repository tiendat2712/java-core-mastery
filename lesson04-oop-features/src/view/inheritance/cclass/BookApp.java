package view.inheritance.cclass;

import java.math.BigDecimal;

public class BookApp {

    public static void main(String[] args) {

        /*
           Cho ứng dụng quản lí thông tin sách trong cửa hàng
           Thông tin sách
           + sách tham khảo: mã, tên, nhà xuất bản, thuế
           + sách giáo khoa: mã, tên, nhà xuất bản, trạng thái, giảm giá (%)

           Trạng thái (MOI/CU/TRA_LAI/ .....) -->

           Dùng enum thay vì true/false:
                 --> Khi muốn lưu trữ tập hợp các giá trị là hằng số, bất biến <immutable>
                 --> KDl đối tượng:
                     Lưu trữ tập các đối tượng là immutable bên trong nó
                 ===> Default empty constructor của KDL enum là 'private' (unmodifiable)

           Tạo danh sách N cuốn sách (mảng)
           --> thực hiện việc mua k/N cuốn sách và tính tổng tiền phải chi trả:
         */

        Book[] books = mockBooks();
//        Book[] salesBooks = {books[0], books[1], books[2], books[4], books[6]};
        Book[] salesBooks = {books[1]};

        BigDecimal totalOfMoney = BigDecimal.ZERO;

        for(Book book : salesBooks) {


            BigDecimal multicand = book instanceof TextBook
                    ? bd(100)
                    .subtract(bd(((TextBook) book).getDiscount()))
                    .divide(bd(100))
                    : (book instanceof ReferenceBook)
                    ? bd(1)
                    .add(((ReferenceBook) book).getTax().divide(bd(100)))
                    : bd(1);

            BigDecimal salesPrice = book.getSalePrice().multiply(multicand);

            totalOfMoney = totalOfMoney.add(salesPrice);
        }

        System.out.println("Total of money: " + totalOfMoney);



//			if(book instanceof TextBook) {
//				TextBook tb = (TextBook)book; // ép kiểu book -> TextBook
//				salesPrice = salesRrice.multiply(bd(100).subtract(tb.getDiscount()));
//
//
//			} else if (book instanceof ReferenceBook) {
//				ReferenceBook ref = (ReferenceBook)book;
//				salesPrice = salesPrice.multiply(bd(1).add(ref.getTax().divide(bd(100))));
//			}
            //totalOfMoney = totalOfMoney.add(book.getSalePrice());

//        }




        /*
               'instanceof' ----- == ----> book != null && bookRuntimeClass == TextBook.class
               tương đương với đoạn code:

               Class<?> bookRuntimeClass = book.getClass(); --> nguy hiểm vì book có thể bị null
                                                            --> lúc runtime ko gọi được class

               if(book != null && bookRuntimeClass == TextBook.class) {
                   ..........
               } else if (book != null && bookRuntimeClass == ReferenceBook.class) {
                   ..........
               }
             */


    }

    private static Book[] mockBooks() {
        return new Book[]{
                new TextBook("SGK-291", "Viet Nam", bd(50000), "Toán 7", BookStatus.NEW, 2),
                new TextBook("SGK-360", "Campuchia", bd(80000), "Toán 9", BookStatus.NEW, 5),
                new TextBook("SGK-296", "Viet Nam", bd(90000), "Toán 7", BookStatus.OLD, 2),
                new TextBook("SGK-353", "Thai Lan", bd(70000), "Toán 5", BookStatus.NEW, 10),
                new TextBook("SGK-244", "Trung Quoc", bd(80000), "Toán 3", BookStatus.OLD, 2),
                new TextBook("SGK-212", "Han Quoc", bd(60000), "Toán 11", BookStatus.NEW, 7),
                new ReferenceBook("SGK-21", "Germany", bd(40000), "Cambridge 1", bd(7.6)),
                new ReferenceBook("SGK-22", "Finland", bd(30000), "Cambridge 2", bd(9)),
                new ReferenceBook("SGK-25", "USA", bd(45000), "Cambridge 3", bd(10)),
                new ReferenceBook("SGK-26", "England", bd(57600), "Cambridge 4", bd(6)),
                new ReferenceBook("SGK-27", "England", bd(85800), "Cambridge 5", bd(2.5))
        };
    }

    private static BigDecimal bd(double value) {
        return BigDecimal.valueOf(value);
    }
}
