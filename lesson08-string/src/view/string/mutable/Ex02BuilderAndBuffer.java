package view.string.mutable;

public class Ex02BuilderAndBuffer {
	
	public static void main(String[] args) {
		
		// mutableTask: H1(sb, amount)
		StringTask mutableTask = new StringTask(100000);
		System.out.println("string length before: " + mutableTask.length());
		
		Thread t1 = new Thread(mutableTask, "T1");
		Thread t2 = new Thread(mutableTask, "T2");
		
		t1.start();
		t2.start();
		
		try {
			// wait for t1, t2 finish --> continue
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("string length after: " + mutableTask.length());
		
	}
	
	public static class StringTask implements Runnable {
		
		private StringBuilder sb;  // biến string mutable
		private final int amount; // số lượng phần tử muốn thêm vào sb
		
		public StringTask(int amount) {
			this.sb = new StringBuilder();
			this.amount = amount;
		}
		
		@Override
		public void run() {
			System.out.println("StringTask is being executed by " + Thread.currentThread().getName());
			for (int i = 1; i <= amount; i++) {
				sb.append("A");
			}
			System.out.println("StringTask is done !!!");
		}
		
		public int length() {
			return sb.length();
		}
	}
	
}
