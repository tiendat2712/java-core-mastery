package view.inheritance.abstract_class;

public class BusinessEmailServiceImpl extends EmailService {

    @Override
    void login() {
        System.out.println("Business Email Service --> Login");
    }

    @Override
    void login2Steps() {
        System.out.println("Business Email Service --> Login 2Steps");
    }

}
