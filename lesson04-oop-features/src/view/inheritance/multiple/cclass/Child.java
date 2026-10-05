package view.inheritance.multiple.cclass;

public class Child extends Father /*, Mother */ {

    // Java không hỗ trợ đa thừa kế
    // Vì có trường hợp các class cha có 'chung hàm khai báo'
    // Nếu class con không bắt buộc override hàm từ cha

    // --> Khi lấy con gọi hàm chung thì sẽ ko biết gọi đến class nào
    // ==> compile error thay vì đợi gọi

    // Bắt bẻ: vậy ở class con override lại hàm chung thì sao ?
    // --> đó chính là ràng buộc khi con implement interface ==> đa thực thi

    // Java không hỗ trợ đa thừa kế --- nhưng hỗ trợ đa thực thi

    @Override
    void playing() {
        System.out.println("Child is playing");
    }

    public static void main(String[] args) {

        Father f = new Child();
        f.cooking();
        f.playing();
        f.running();

    }
}
