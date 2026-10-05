package view.inheritance.iinterface;

public class Rectangle implements Shape, CssStyle {

    @Override
    public void paint() {
        System.out.println("Rectangle --> Paint ....");
    }

    @Override
    public void calS() {
        System.out.println("Rectangle --> CalS ....");
    }

    @Override
    public void setColor() {
        System.out.println("Rectangle --> Color ....");
    }

    @Override
    public void setBackgroundColor() {
        System.out.println("Rectangle --> Background Color....");
    }

    @Override
    public void onload() {
        System.out.println("Rectangle --> Onload ....");
    }
}
