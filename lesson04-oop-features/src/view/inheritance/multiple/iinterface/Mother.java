package view.inheritance.multiple.iinterface;

public interface Mother {

    void cooking();
    void playBadminton();

    default void coding() {
        isOdd();
        System.out.println("Mother is coding");;
    }

    private boolean isOdd() {
        return true;
    }
}
