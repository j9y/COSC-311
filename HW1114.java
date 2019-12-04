/*
 * Name: Justin Yee
 * COSC 311
 * hw1114	
 * URL: <https://github.com/j9y/COSC-311>
 */
package hw1114;

import java.util.Random;
import java.io.RandomAccessFile;
import java.io.IOException;
public class HW1114 {
	
	Random rand = new Random();
	
	public int firstHashFun(int key) {
		return key % 11;
	}
	public int seed() {
		return rand.nextInt(97);
	}
	public int addRandomNum() {
		return rand.nextInt(100);
	}
	public static void main(String[]args) throws IOException{
		HW1114 hash = new HW1114();
		RandomAccessFile raf = new RandomAccessFile("data.raf", "rw");
		for (int i = 0; i < 11; i++) {
			raf.writeInt(-1);
		}
		for (int i = 0; i < 8; i++) {
			if(i == 0) {
				int randNum = hash.seed();
				int key = hash.firstHashFun(randNum);
				raf.seek(key*4);
				if(raf.readInt() == -1) {
					raf.seek(key*4);
					raf.writeInt(randNum);
				}
				System.out.println("Random Generated Values:\n" +randNum);
			}
			else {
				int randNum = hash.addRandomNum();
				int key = hash.firstHashFun(randNum);
				raf.seek(key*4);
				if(raf.readInt() == -1) {
					raf.seek(key*4);
					raf.writeInt(randNum);
				}
				System.out.println(randNum);
			}
		}
		System.out.println("===========================================");
		raf.seek(0);
		for(int i = 0; i < raf.length()/4; i++) {
			System.out.println("byte Offset: "+i*4+ " int Index: " +i+ " int value: " + raf.readInt());
			System.out.println("===========================================");
		}
		raf.close();
	}	
}
		


