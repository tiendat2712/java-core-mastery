package a.validation_try_catch_throw_throws;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ex07Exception_Finally {
	
	public static void main(String[] args) {
		System.out.println("Started writing file");

		String[] employees = mockData();
		File file = new File("data.txt");
		FileWriter fw = null;
		try {
			// open/connect file
			fw = new FileWriter(file);
			for (String employee: employees) {
				String newLine = createNewLine(employee);
				if (newLine != null) {
					fw.write(newLine + "\n");
					System.out.println(">>>> " + newLine);
				}
			}
			// save/close file --> invalid khi nội dung truyền vào bị exception
			// fw.close();
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			// save/close file --> invalid khi nội dung không bị exception
			// fw.close();
		} finally {
			// luôn được thực thì dùng try có bị exception, exception có bắt được hay ko
			close(fw);
		}
		
		System.out.println("Finished write file");
	}
	
	private static String createNewLine(String employee) {
		String newLine = null;
		try {
			String[] tokens = employee.split(", ");
			String id = tokens[0];
			String name = tokens[1];
			int age = Integer.parseInt(tokens[2]);
			int factor = (age - 18) * 2;
			newLine = id + ", " + name + ", " + factor;
		} catch(NumberFormatException | IndexOutOfBoundsException e) {
			System.out.println("Skip line --> " + employee + " is invalid format !!!");
		}
		return newLine;
	}
	
	private static void close(FileWriter fw) {
		try {
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String[] mockData() {
		return new String[] {
			"1, Le A, 26",
			"2, Le B, 22",
			"3, Le C, 2t",
			"4, Le D, 24",
			"5, Le E, 25",
			"6, Le F, 28",
			"7, Le G, 2o",
			// ............
			"80, Le X, 21",
			"81, Le Y, 22",
			// ............
			"100, Le W, 34"
		};
	}
	
}
