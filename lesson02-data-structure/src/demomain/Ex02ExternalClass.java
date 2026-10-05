package demomain;

public class Ex02ExternalClass {
    public static void main(String[] args) {
        System.out.println("-- Test External Class with public/private --");

        Ex01TestMainMethod ex = new Ex01TestMainMethod();
        int a = ex.calSum(4,6);

        Ex01TestMainMethod.drawTriangleShortVer();

        System.out.println(ex.calSum(3,4));
        System.out.println(a);

        System.out.println("--------------- Main Finished ---------------");
    }
}
