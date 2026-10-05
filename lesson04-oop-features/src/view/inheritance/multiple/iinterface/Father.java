package view.inheritance.multiple.iinterface;

public interface Father {

    void cooking();

    void running();

    default void coding() {
        isOdd();
        System.out.println("Father is coding");;
    }

    default void testing() {
        isOdd();
        System.out.println("Father is testing");
    }

    private boolean isOdd() {
        return true;
    }
}
