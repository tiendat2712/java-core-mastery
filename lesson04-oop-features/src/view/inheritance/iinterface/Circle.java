package view.inheritance.iinterface;

public class Circle implements Shape{

    private int value;

    public Circle() {}

    public Circle(int value) {
        this.value = value;
    }

    @Override
    public void paint() {
        System.out.println("Circle --> Paint...");
    }

    @Override
    public void calS() {
        System.out.println("Circle --> CalS ....");
    }

    @Override
    public void onload() {
        System.out.println("Circle --> Onload ....");
    }
}
