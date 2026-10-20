package file.serialize;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import bean.Dish;
import model.DataModel;
import utils.FileUtils;

// Os -> output stream
public class Ex01FileOs {

    public static void main(String[] args) {

        File file = FileUtils.createNewFile("data/serialize.txt");

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);

            // data
            List<Dish> menu = DataModel.mockDishes();

            // ghi file
            oos.writeObject(menu);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // close and save file
            FileUtils.close(oos, fos);
        }

        // open file
        FileUtils.open(file);

    }

}