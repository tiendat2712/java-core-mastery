package view;

import functional.IntCheck;

import java.util.Arrays;

import static utils.ArrayUtils.*;

public class Ex03ArrayOperations {

    public static void main(String[] args) {

        /**
         *
         * Cho 1 mang danh sach so nguyen duong [1,20]
         * Yeu cau:
         * 1. Tim kiem nhung phan tu la so chan trong mang
         * 2. Tim kiem nhung phan tu la so le trong mang
         * 3. Tim kiem nhung phan tu la so nguyen to trong mang
         * 4. Tim kiem nhung phan tu la so hanh phuc trong mang
         * --> Strategy pattern !!
         */

        int[] digits = {1, 4, 6, 14, 13, 12, 20};
//        generate("1. Get even numbers --> ", getEvenNumbers(digits));
        generate("2. Get even numbers --> ", getNumbers(digits, nb -> nb % 2 ==0));

        generate("2. Get odd numbers --> ", getNumbers(digits, nb -> nb % 2 != 0));
        generate("3. Get prime numbers --> ", getNumbers(digits, nb -> isPrime(nb)));

    }

    /*
       - element % 2 == 0                      Input: int element
       - element % 2 != 0  -- Strategy IO: ==> Output: boolean    ==>
       - isPrime(element)
     */
    private static int[] getNumbers(int[] elements, IntCheck intCheck) {
        int[] target = new int[elements.length];

        int count = 0;

        for (int element : elements) { // forEach()
            if (intCheck.test(element)) {
                target[count++] = element;
            }
        }

        return Arrays.copyOfRange(target, 0, count);
    }

    private static int[] getPrimeNumbers(int[] elements) {
        int[] target = new int[elements.length];

        int count = 0;

        for (int element : elements) { // forEach()
            if (isPrime(element)) {
                target[count++] = element;
            }
        }

        return Arrays.copyOfRange(target, 0, count);
    }

    private static boolean isPrime(int number) {
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % 2 == 0) {
                return false;
            }
        }

        return true;
    }

}
