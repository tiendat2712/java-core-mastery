package view.inheritance.multiple.iinterface;

public class DemoMain {

    public static void main(String[] args) {

        Mother mother = new Child();
        mother.cooking(); // child's cooking
        mother.playBadminton();

        System.out.println("\n==========================\n");

        Father father = new Child();
        father.cooking(); // child's cooking
        father.running();
        father.coding();
        father.testing();

        System.out.println("\n==========================\n");

        Human human = new Child();
        human.cooking(); // child's cooking
        human.jumping();

    }
}
