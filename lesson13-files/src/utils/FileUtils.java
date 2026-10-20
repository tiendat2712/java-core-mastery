package utils;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class FileUtils {

    private FileUtils() {
    }

    public static void open(File file) {
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File createNewFile(String path) {
        File file = new File(path);

        if (file.exists()) {
            System.out.println(">>> File '" + path + "' is existed");
        } else {
            createNewDir(file.getParent());
            try {
                boolean isSuccess = file.createNewFile();
                System.out.println("File '" + path + "' is created successful ? " + isSuccess);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public static File createNewDir(String path) {
        File root = new File(path);
        if (!root.exists()) {
            root.mkdirs();
        }
        return root;
    }

    public static void close(AutoCloseable... autoCloseables) {
        for (AutoCloseable autoCloseable: autoCloseables) {
            if (autoCloseable != null) {
                try {
                    autoCloseable.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}