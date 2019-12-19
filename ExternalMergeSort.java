/*
 * Name: Justin Yee
 * COSC 311
 * Project 2	
 * URL: <https://github.com/j9y/COSC-311>
 */
import java.util.Random;
import java.io.IOException;
import java.io.RandomAccessFile;
public class ExternalMergeSort {
	
	static  int size = 2000; 
	static Random r = new Random();
	static RandomAccessFile f1;
    static RandomAccessFile f2;

    static void merge(int arr[], int L[], int l, int R[], int r)
    {
    	/* Merge the temp arrays */
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
        
        // Initial index of merged subarry array 
        int k = 0; 
        while(i < l && j < r)
        {
            if (L[i] <= R[j]) 
            {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        /* Copy remaining elements of left[] if any */
        while(i<l) {
            arr[k] = L[i];
            k++;
            i++;
        }
        /* Copy remaining elements of right[] if any */
        while (j<r) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
	  
	    // Main function that sorts arr[l..r] using 
	    // merge() 
	 static void sort(int arr[], int size)
	 {
	        if(size<2) {
	            return;
	        }
	        // Find the middle point 
	        int m = size/2;
	        int[] l = new int[m];
	        int[] r = new int[size-m];
	      
	        for(int i=0; i<m; i++) { 
	            l[i] = arr[i];
	        }
	    
	        for(int j=m; j<size; j++) {
	            r[j-m] = arr[j];
	        }
	        // Sort first and second halves 
	        sort(l, m);
	        sort(r, size-m);

	        // Merge the sorted halves 
	        merge(arr, l, m, r, size-m);
	    }
	   static void addElems(int size) throws IOException {
	        f1.seek(0);
	        for(int i=0; i<size; i++){
	           int elem = r.nextInt(100);
	           f1.writeInt(elem);
	           System.out.print(+elem+ " ");
	        }
	    }
	   static void print(int size) throws IOException {
	        f2.seek(0);
	        for(int i = 0; i<size; i++){
	            int elem = f2.readInt();
	            System.out.print(+elem+ " ");
	        }
	    }
	   static void externalSort(int size, int mem) throws IOException {
			  // Create array in f1
		        f1.seek(0);
		        int arr[] = new int[mem];
		        for(int i=0; i < mem; i++) {
		            int x = f1.readInt();
		            arr[i] = x;
		        }
		        // Sort array
		        sort(arr, mem);
		        // Write sorted array to f2
		        for(int j=0; j < mem; j++) {
		            f2.writeInt(arr[j]);
		        } 
		    }
	   public static void main(String[] args) throws IOException {
	        try {
	            f1 = new RandomAccessFile("file1.raf", "rw");
	        } 
	        catch (IOException error) {
	        	System.out.println(error);
	        	}
	        
	        try {
	            f2 = new RandomAccessFile("file2.raf", "rw");
	        } 
	        catch (IOException error) {
	        	System.out.println(error);
	        	}
	        System.out.println("Unsorted File");
	      	addElems(size);  
	        int mem = size;
	        long startTime = System.nanoTime();
	        externalSort(size, mem);
	        long endTime = System.nanoTime();
	        long totalTime = endTime - startTime;
	        System.out.println("\nSorted file");
	        print(size);
	        System.out.println("\nTotal time for external merge sort is " + totalTime+" nanoseconds");
	    }
}