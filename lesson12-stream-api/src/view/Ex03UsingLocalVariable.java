package view;

import bean.Apple;

import java.util.List;

public class Ex03UsingLocalVariable {

    /*
     *  -- LOCAL VARIABLE --
     *
     * 1 biến cục bộ(biến trong hàm) có thể được sử dụng trong
     * anonymous class/function mà ko cần phải truyền tham số qua constructor/method
     *
     * ==> Ngầm định những local variable này phải là final
     *
     * Vì: đang tự động truyền tham số qua hàm, mà khi truyền tham số qua hàm (hàm thực thi của class functional interface)
     *     100% ko thể cập nhật giá trị của biến(local) đó ở stack.
     *
     * --> đảm bảo --> final hoặc ngầm định là final
     *
     *  - trước Java 8 bắt buộc phải có từ khóa final
     *  - sau Java 8 nếu ko có final thì ngầm định hiểu là final
     *
     */

    public static void main(String[] args) {

        Runnable runnable = test(15);
        runnable.run();

        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Integer max = Integer.MIN_VALUE;

        list.forEach(number -> {
            if (max < number) {
                // max = number; // auto final
            }
        });

        System.out.println("max --> " + max);

    }

    private static Runnable test(int time) {
        String running = "running ...";
        Apple apple = new Apple();
        apple.setId(12);

        // implementation class
//        return new TestRunnable(time, running);

        /* anonymous class
        return new Runnable() {
            @Override
            public void run() {
                String student = "Adam";
                System.out.println(student + " is " + running + " in " + time + "(s)");
            }
        }; */

        // anonymous function
        return () -> {
//            apple = new Apple(); --> lỗi vì đang được ngầm định là final "final là final ở stack"
//            time = 10;           --> lỗi --> in a enclosing scope must be final
            apple.setId(15); // heap memory
            String student = "Adam";
            System.out.println("Apple id --> " + apple.getId());
            System.out.println(student + " is " + running + " in " + time + "(s)");
        };
    }

    // external class
    private static class TestRunnable implements Runnable {

        private int time;
        private String running;

        private TestRunnable(int time, String running) {
            this.time = time;
            this.running = running;

            running = "hello"; // cập nhật chắc chắn không được vì đang ngầm định running phải là final
        }

        @Override
        public void run() {
            String student = "Adam";
            System.out.println(student + " is " + running + " in " + time  + "(s)");
        }
    }

}


