package view.inheritance.abstract_class;

public class InheritanceAbstractClassDemo {

    public static void main(String[] args) {

        // Anonymous class
        EmailService emailService = new EmailService() {
            @Override
            void login() {
                System.out.println("Email Service <Parent> --> Login");
            }
        };
        emailService.login();
        emailService.login2Steps();

        System.out.println("\n===========================\n");

        EmailService emailService1 = new BusinessEmailServiceImpl();
        emailService1.login();
        emailService1.login2Steps();

        System.out.println("\n===========================\n");

        EmailService emailService2 = new StandardEmailServiceImpl();
        emailService2.login();
        emailService2.login2Steps();

        /*
           ====>
           Để tạo 1 đối tượng cho biến KDL abstract class:
           Dùng - external class
                - anonymous class
                  ==> có thể có 1 hoặc nhiều hàm trừu tượng
         */

        /**
           Phân biệt interface và abstract class ?
           - interface:
           - abstract class:
         */

    }
}
