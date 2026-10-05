package view.inheritance.cclass;

// enum --> private constructor
public enum BookStatus {

    // Để truy cập các biến(đ)

    // NEW --> BookStatus NEW = new BookStatus();
    // OLD --> BookStatus OLD = new BookStatus();

    // NEW("mới") --> BookStatus NEW = new BookStatus("mới");
    // OLD("cũ") --> BookStatus OLD = new BookStatus("cũ"); --> cần 1 thuộc tính value + constructor tương ứng

    // BookStatus[] statuses = BookStatus.values();

    //

    NEW("mới"),
    OLD("cũ");

    private String value;

    // trong enum class nếu ko khai báo access modifier ở constructor thì mặc đình là --> private
    BookStatus() {
    }

    BookStatus(String value) { // --> private
        this.value = value;
    }
}
