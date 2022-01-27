package com.balaji.dsa.datastructures.array;
import java.util.Arrays;
public class ArrayRotation{
	int[] arr;
	int size;
	int noOfIndexsToRotate;


	public static void main(String[] args) {

		// testing
		ArrayRotation temp = new ArrayRotation(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 8, 2);
		System.out.println(Arrays.toString(temp.usingTempArray()));
		System.out.println("--------------------------");
		System.out.println(Arrays.toString(temp.oneByOne()));		
		System.out.println("--------------------------");
	}


	public ArrayRotation(int[] arr, int size, int noOfIndexsToRotate){
		this.arr = arr;
		this.size = size;
		this.noOfIndexsToRotate = noOfIndexsToRotate;
	}


	public int[] usingTempArray(){
		int[] temp;
		int[] arr1 = arr;
		temp = new int[noOfIndexsToRotate];

		for (int i = 0; i < noOfIndexsToRotate; i++) {
			temp[i] = arr[i];
			// stored all the values to be rotated
		}
		for (int i = 0; i < (size - noOfIndexsToRotate); i++) {
			arr1[i] = arr[i+noOfIndexsToRotate];
			// updating copied values with next values
		}
		for (int i = 0; i < noOfIndexsToRotate ; i++) {
			arr1[size-noOfIndexsToRotate+i] = temp[i];
			// updating the end values with the copied values
		}
		return arr1;
		// time complexity: O(n)
		// Auxilary space: O(d)
	}


	public int[] oneByOne(){
		int[] arr1 = arr;
		for (int i = 0; i < noOfIndexsToRotate; i++) {
			int temp = arr1[0];
			for (int j = 0; j < size - 1; j++) {
				arr1[j] = arr1[j+1];
			}
			arr1[size-1] = temp;
		}
		return arr1;
		// time complexity: O(d*n)
		// Auxilary space: O(1)
	}
	

	public int[] jugglingMethod(){
		int[] arr1 = arr;
	        d = d % n;
    		int i, j, k, temp;
        	int g_c_d = gcd(d, n);
        	for (i = 0; i < g_c_d; i++) {
            		/* move i-th values of blocks */
            		temp = arr1[i];
            		j = i;
            		while (true) {
            			k = j + d;
				if (k >= n)
        	        		k = k - n;
        	        	if (k == i)
                			break;
        			arr1[j] = arr1[k];
                		j = k;
            		}
            		arr1[j] = temp;
        	}
		return arr1;
	}


	 /*Function to get gcd of a and b*/
    	public int gcd(int a, int b){
        	if (b == 0)
            		return a;
        	else
        	    	return gcd(b, a % b);
    	}
}
