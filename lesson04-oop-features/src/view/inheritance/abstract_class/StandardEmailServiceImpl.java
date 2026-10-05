package view.inheritance.abstract_class;

public class StandardEmailServiceImpl extends EmailService {

    @Override
    void login() {
        System.out.println("Standard Email Service --> Login");
    }

}
