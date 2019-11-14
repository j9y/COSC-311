/*
 * Name: Justin Yee
 * COSC 311
 * hw1105	
 * URL: <https://github.com/j9y/COSC-311>
 */
package hw1105;

import java.util.Random;

public class HW1105 {
	int hashTable [] = new int [11];
	
	public HW1105() {
		for (int i = 0; i < hashTable.length; i++) {
			hashTable[i] = 0;
		}
	}
	public int firstHashFun(int key) {
		int hashValue = 0;
		hashValue = key % hashTable.length;
		return hashValue;
	}
	public int secondHashFun(int key) {
		int hashValue = 0;
		hashValue = 7 - (key % 7);
		return hashValue;
	}
	public void addKeyToArray(int key) {
		int location = firstHashFun(key);
		if(hashTable[location] != 0) {
			location = secondHashFun(key);
		}
		hashTable[location] = key;
		System.out.println("Key: " +key+ " at Location: "+location);
 	}
	public void display() {
		System.out.println("Hash Table:");
		for(int i = 0; i < hashTable.length; i++) {
			System.out.println("Index: "+i+ " = " +hashTable[i]);
		}
	}
	public static void main(String[]args){
		HW1105 hash = new HW1105();
		Random rand = new Random();
		for(int i = 0; i < 8; i++) {
			int randomNum;
			if(i == 0) {
				randomNum = rand.nextInt(97);
			}
			else {
				randomNum = rand.nextInt(100);
			}
			hash.addKeyToArray(randomNum);
		}
		hash.display();
	}	
}
