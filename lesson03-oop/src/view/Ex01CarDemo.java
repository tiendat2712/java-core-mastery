package view;

import bean.Car;

public class Ex01CarDemo {

    public static void main(String[] args) {

        Car.model = "Audi";

        //Tạo n đối tượng car
        Car c1 = new Car();
        c1.setId("C1"); // c1.id = "C1";
        c1.setColor("Yellow"); // c1.color = "Yellow";
        c1.setSalesPrice(550d); // c1.salesPrice = 550d;
        Car.model = "Audi Update";

        Car c2 = new Car("C2", "White", 800);
        Car c3 = new Car("C3", "Black", 800);
        Car c4 = new Car("C4", "Red", 620);

		/*
		  1/ Phân biệt khi nào dùng Constructor, getter, setter ?
		     Trả lời:
		        + Khi tạo ra một đối tượng để lưu trữ (tạo ô nhớ mới ở HEAP): constructor
		        + Khi muốn cập nhật giá trị(cập nhật lại giá trị tại ô nhớ trên HEAP): setter
		        + Khi muốn lấy giá trị từng thuộc tính : getter

		  2/ Tại sao phải khai báo thuộc tính class là private, rồi sau đó dùng getter, setter để truy cập
		     mà không khai báo thẳng là public để code ngắn gọn ?
		      + public --> được phép truy cập từ bất kỳ class nào --> giống FOP
		               --> không quản lý dữ liệu riêng của từng đối tượng(class)

		      + private --> chỉ được phép truy cập từ class hiện tại
		                -->bên ngoài chỉ có thể truy cập thông qua phương thức getter, setter để thao tác với giá trị

		      + bên ngoài không thể thay đổi cấu trúc dữ liệu của thuộc tính bên trong class
		      + bên ngoài nên truy cập tăng/giảm, thay đổi giá trị của thuộc tính chứ không nên biết chính xác giá trị
		      (nguồn gốc) đó như nào

		      class Company {
              private double balance; // quỹ lương

              public Company(double balance) {
                      this.balance = balance;
              }

              public void payment(Employee employee, double salary) {
                      this.balance = this.balance - salary;
                      employee.plusIncome(salary);
              }

              public double getBalance() {
                      return balance;
              }

              -------------- -------------- -------------
              class Employee {
              private double income; // thu nhập

              public void plusIncome(double salary) {
                      this.income = this.income + salary;
              }

              public double getIncome() {
                      return income;
              }
              }

		 */

        System.out.println("c1 --> " + c1);
        System.out.println("c2 --> " + c2);
        System.out.println("c3 --> " + c3);
        System.out.println("c4 --> " + c4);

    }

}