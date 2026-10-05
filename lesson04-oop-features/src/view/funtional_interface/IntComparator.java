package view.funtional_interface;

@FunctionalInterface
public interface IntComparator {

    int compare(int a, int b);

    // Để tạo 1 đối tượng cho IntComparator
    // --> dùng external class, anonymous class (new trực tiếp)

}
