package view.polymorphism.method;

public class Ex02OverrideDemo {

    public static void main(String[] args) {

        PolyChild pc = new PolyChild()  ;
        pc.log();
        pc.test();

        // tại sao mình không code 2 hàm log() riêng biệt ở PolyParent và PolyChild
        // mà phải tạo log() ở PolyParent rồi @Override lại ở PolyChild ?????

        /*

         */


    }

}
