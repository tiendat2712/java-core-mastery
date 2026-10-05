package a.validation_try_catch_throw_throws;

import java.io.File;
import java.io.IOException;

public class Ex04Exception_ThrowThrows {

    // validation: validate trước đoạn code có khả năng bị exception
    // try...catch: đưa đoạn code có khả năng bị exception vào khối try

    // throw_throws:
    // throw: ném exception trước khi đoạn code có khả năng bị exception xảy ra
    //      : ném khi mà exception xảy ra hay ko phụ thuộc vào param truyền vào lúc gọi hàm
    //
    // throws: ném compile exception ra ở chỗ khai báo hàm để nơi gọi hàm phải xử lí lỗi

    // compile, runtime exception
    // trong hàm: nếu mình throw new runtime exception (RE)
    //            -> tại chỗ khai báo hàm không bắt buộc phải throws
    //               và nếu phải throws RE thì nó cũng vô nghĩa (RE không bắt buộc phải xử lí tại compile)

    // trong hàm: nếu mình throw new compile exception (CE)
    //            -> tại chỗ khai báo hàm bắt buộc phải throws ra CE (vì CE bắt buộc phải xử lí tại compile)
    //               để chỗ gọi hàm biết bên trong hàm có CE và bắt buộc phải xử lí

    // multiple exception
    // custom exception

    public static void main(String[] args) {

        System.out.println("Ex04 - Started");
        try {
            createFile("test.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ex04 - End");
    }

    private static File createFile(String path) throws IOException {
        File file = new File(path);

        if(file.exists()) {
            System.out.println(" --> File "+ file.getName() + " available");
            return file;
        }

        boolean isSuccess = file.createNewFile();

        String message = isSuccess ? "successful" : "failed";

        if(isSuccess) {
            System.out.println("File " + file.getName() + " is created " + message);
        }

        return file;
    }
}
