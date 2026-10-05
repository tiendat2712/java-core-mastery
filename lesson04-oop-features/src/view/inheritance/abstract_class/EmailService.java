package view.inheritance.abstract_class;

public abstract class EmailService {

    /*
      - phải có từ khóa abstract trước return_type ở hàm trừu tượng
      - nếu ko có access modifier thì mặc định là default (có phạm vi trong package) == giống class thường != interface
     */
    abstract void login();

    void login2Steps() {
        System.out.println("Email Service <Parent> --> Login 2Steps");
    }

}
