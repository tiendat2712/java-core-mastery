package view.thread;

import java.text.Normalizer;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex01ThreadDemo {
	
	public static void main(String[] args) {
		
		String hello = "hsauchsic92w2w";
		boolean x = hello.matches("[abc]");
		
		
		Pattern p = Pattern.compile("[abc]");
        Matcher m = p.matcher("hsauchsic92w2w");
        boolean y = m.matches();
		
		System.out.println("-- Start Main ---");
		printCurrentThread(7);
		
		Runnable taskA = new Runnable() {
			
			@Override
			public void run() {
				doTask(3);
				printCurrentThread(16);
				doTask();
			}
		};
		
		Thread t1 = new Thread(taskA, "Thread 1"); // new
		t1.start(); // start --> runnable --> run
		
		doTask(5);
		printCurrentThread(25);
		System.out.println("-- End Main ---");
	}
	
	public static String toNotAccentedWay1(String yourStr) { 
		String chgString = Normalizer.normalize(yourStr, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		chgString = pattern.matcher(chgString).replaceAll("").replaceAll("đ", "d").replaceAll("Đ", "D"); 
		return chgString;
	}
	
	private static void doTask(int seconds) {
		try {
			for (int i = 1; i <= seconds; i++) {
				TimeUnit.SECONDS.sleep(1);
				System.out.println(Thread.currentThread().getName() + " executes " + i + ("s"));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static void doTask() {
		System.out.println("Load Data From File x.txt");
	}
	
	private static void printCurrentThread(int line) {
		System.out.println("Current Thread(line " + line + ") --> '" + Thread.currentThread().getName() + "'");
	}
	
}
