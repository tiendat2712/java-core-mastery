package view.polymorphism.object;

public class Shape {

    // lớp cha: tạo hàm chung
    //        : chưa biết phần thực thi sẽ như thế nào

    // khai báo: KDL_TV tenHam(tham số)
    // thực thi: {}

    // --> tạo hàm không có phần thực thi (không cho phép trong class)

    void paint() {
        // unknown implementation
        System.out.println("Shape --> paint ... ");
    }

    void calS() {
        // unknown implementation
        System.out.println("Shape --> calS ... ");
    }

}
