package view.string.immutable;

import java.util.Arrays;

public class Ex05StringExercises {
	
	public static void main(String[] args) {
		/*
		Viết chương trình in ra danh sách bài nhạc mp3 có trong thư mục music
		Input:    String bh1  = d:/music/somthingyoulike.mp3
		          String bh2  = d:/music/foreoverandone.mp3
		          String bh3  = d:/music/takemetoyourheart.mov
		String [] arrStr = {bh1, bh2, bh3}
		
		Output:
		Danh sách bài hát mp3 trong thu muc d:/music gồm:
		   1.  somthingyoulike
		   2.  foreoverandone
		 */
		
		String[] songs = {
				"d:/music/somthingyoulike.mp3",
				"d:/music/happynewyear.mp4",
				"d:/music/hello.mp3",
				"d:/music/foreoverandone.mp3",
				"d:/music/takemetoyourheart.mov"
		};
		
		String[] mp3Songs = getMp3Songs(songs);
		printf(mp3Songs);
	}
	
	private static String[] getMp3Songs(String[] songs) {
		// somthingyoulike, foreoverandone, null
		String[] result = new String[songs.length];
		int count = 0;
		for (String song: songs) {
			if (song.endsWith(".mp3")) {
				int lastSlashIndex = song.lastIndexOf("/");
				int lastDotIndex = song.lastIndexOf(".");
				String name = song.substring(lastSlashIndex+1, lastDotIndex);
				result[count++] = name;
			}
		}
		return Arrays.copyOfRange(result, 0, count);
	}

	private static void printf(String[] elements) {
		for(int i = 0; i < elements.length; i++) {
			System.out.println((i+1) + ". " + elements[i]);
		}
	}
}
