package a.validation_try_catch_throw_throws;

import exception.InvalidImageException;

public class Ex05Exception_Custom {

    /*
       Kiểm tra tính hợp lệ của hình ảnh
          + Tên file
          + Đuôi file (jpg, jpeg, png, svg)
     */
    private static String[] imageExtensions = {"jpg", "jpeg", "png", "svg"};

    public static void main(String[] args) {

        String[] images = {"hello.svg", "toi.png", "goodbye.txt", "ta.jpeg"};

        for(String file : images) {
            if(isValid(file)) {
                try {
                    throw new InvalidImageException("File is not an valid image");
                } catch (InvalidImageException e) {
                    System.out.println("e --> "+ e.getMessage());
                }
            }
            System.out.println("Uploaded'" + file + "' successfull");
        }

    }

    private static boolean isValid(String file) {
        for (String ext : imageExtensions) {
            if (file.endsWith(ext)) {
                return true;
            }
        }
        return false;
    }

}
