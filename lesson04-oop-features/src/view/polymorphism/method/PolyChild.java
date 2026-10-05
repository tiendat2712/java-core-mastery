package view.polymorphism.method;

public class PolyChild extends PolyParent {

    int sum(int a, int b) {
        return a + b;
    }

    @Override // annotation
    void log() {
        System.out.println("PolyChild --> log ........");
    }

}
