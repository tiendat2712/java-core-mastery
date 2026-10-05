package view.io;

import java.util.Scanner;

public class Ex01IoBasicDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập SBD : ");
        String id = sc.nextLine();

        System.out.println("Nhập username : ");
        String us = sc.nextLine();

        System.out.println("Nhập password : ");
        String pw = sc.nextLine();

        System.out.println("Nhập tuổi : ");
        int age = sc.nextInt();

        // cách 1:
        sc.nextLine(); // -> cho Enter khi nhập age ăn vào line code 22
        // cách 2:
        // dùng int age = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập email : ");
        String email = sc.nextLine(); // Trôi lệnh --> Trước: Nhập dữ liệu ko phải chuỗi <int age>
                                      //               Sau  : Nhập dữ liệu chuỗi

        System.out.println("** __ ---- __ **");

        System.out.println("1 --> SBD = " + id);
        System.out.println("2 --> Username = " + us);
        System.out.println("3 --> Password = " + pw);
        System.out.println("4 --> Age = " + age);
        System.out.println("5 --> Email = " + email);

        System.out.println("** __ ---- __ **");

        // close connection
        sc.close();

    }

}
