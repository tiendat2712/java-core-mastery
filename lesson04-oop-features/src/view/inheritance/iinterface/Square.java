package view.inheritance.iinterface;

public class Square implements Shape {

    @Override
    public void paint() {
        System.out.println("Square --> Paint...");
    }

    @Override
    public void calS() {
         System.out.println("Square --> CalS ....");
    }

    @Override
    public void onload() {
        System.out.println("Square --> Onload ....");
    }
}
