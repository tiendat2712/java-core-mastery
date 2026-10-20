package view;

import utils.CollectionUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import view.Ex07ConstructorReferenceExamples.TestCon;

public class Ex08ConstructorReference_TestData {

    public static void main(String[] args) {

        List<String> lines = readFile("lesson12-stream-api/src/testcon_data.txt");

        lines.forEach(line -> {
            System.out.println("line(string) -> " + line);
        });

        System.out.println("\n=\n");

        // convert line(string) to testcon(object)
        List<TestCon> result = map(lines, TestCon::transfer);
        result = map(lines, TestCon::new);

        CollectionUtils.generate("1. Converted Results", result);

    }

    // lines -> testcons
    // lines -> apples
    // lines -> employees
    private static <T, R> List<R> map(List<T> source, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        source.forEach(element -> {
            R r = function.apply(element);
            result.add(r);
        });
        return result;
    }

    private static List<String> readFile(String pathFile) {
        Path path = Paths.get(pathFile);
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }

}
