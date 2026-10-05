package view.polymorphism.object;

public class Square extends Shape {

    // Lớp con: khi thừa kế từ cha là class
    //        : không bắt buộc phải override

    // --> expect: lớp con bắt buộc phải override các hàm trong KDL cha

    @Override
    void paint() {
        System.out.println("Square --> paint ...");
    }

    @Override
    void calS() {
        System.out.println("Square --> calS ... ");
    }

    void setBackGroundColor() {
        System.out.println("Square --> setBackGroundColor ... ");
    }
}
