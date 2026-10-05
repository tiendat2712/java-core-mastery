package view.inheritance.multiple.iinterface;

public class Child extends Human implements Father, Mother {

    @Override
    public void cooking() {
        System.out.println("Child is cooking");
    }

    @Override
    public void running() {
        System.out.println("Child is running");
    }

    @Override
    public void playBadminton() {
        System.out.println("Child is playing Badminton");
    }

    // Nếu trong các interface cha có các default method trùng phần khai báo với nhau
    // --> bắt buộc class con phải override lại
    @Override
    public void coding() {
         // Father.super.coding();
         // Mother.super.coding();
        System.out.println("Child is coding");
    }

}
