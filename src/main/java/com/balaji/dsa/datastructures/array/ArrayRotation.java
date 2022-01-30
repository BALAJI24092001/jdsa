package com.balaji.dsa.datastructures.array;
import java.util.Arrays;
public class ArrayRotation{
	int[] arr;
	int size;
	int noOfIndexsToRotate;

	public static void main(String[] args) {

		// testing
		ArrayRotation temp = new ArrayRotation(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 8, 2);
		printArray(temp.usingTempArray());
		printArray(temp.oneByOne());
		printArray(temp.jugglingAlgorithm());
		printArray(temp.reversalAlgorithm());
		printArray(temp.blockSwapAlgorithm());
		printArray(temp.clockwiseRotation());
		printArray(temp.blockSwapAlgorithm());
	}


	public ArrayRotation(int[] arr, int size, int noOfIndexsToRotate){
		this.arr = arr;
		this.size = size;
		this.noOfIndexsToRotate = noOfIndexsToRotate;
		this.noOfIndexsToRotate = this.noOfIndexsToRotate % this.size; // incase noOfIndexsToRotate is greater than size of array.

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
	

	public int[] jugglingAlgorithm(){
		int gcd = gcd(size, noOfIndexsToRotate);
		int[] arr1 = arr;
		for (int i = 0; i < gcd; i++) {
			int j = i; // create instance of i into j, to not mess with the looping variable value
			int temp = arr1[i]; // store the first loop start value
			while(true){
				int k = j + noOfIndexsToRotate; // create variable to find next location with + noOfIndexsToRotate size
				if(k >= size){ // if k is out of bound, we have to reduce the value of k to its n modulus
					k = k % size;
				}
				if(k == i){ // if k is same as i, we have to break, since the loop will be starting from the beginning.
					break;
				}
				arr1[ j ] = arr1[ k ];
				j = k;
			}
			arr1[j] = temp;
		}
		return arr1;
	}

	public int[] reversalAlgorithm(){
		int[] arr1 = arr;
		int[] firstArraySet = new int[noOfIndexsToRotate];
		int[] secondArraySet = new int[size - noOfIndexsToRotate];
		for (int i = 0; i < noOfIndexsToRotate; i++) {
			firstArraySet[i] = arr1[i];
		}
		for (int i = 0; i < size - noOfIndexsToRotate; i++) {
			secondArraySet[i] = arr1[noOfIndexsToRotate + i];
		}
		for (int i = 0; i < noOfIndexsToRotate; i++) {
			arr[i] = firstArraySet[noOfIndexsToRotate - 1 - i];
		}
		for (int i = 0; i < size - noOfIndexsToRotate; i++) {
			arr[noOfIndexsToRotate + i] = secondArraySet[size - noOfIndexsToRotate - 1 - i ];
		}
		for (int i = 0; i < (int)(size/2); i++) {
			int temp = arr[i];
			arr1[i] = arr1[size - 1 - i];
			arr1[size - 1 - i] = temp;
		}
		return arr1;
	}

	public int[] blockSwapAlgorithm(){
		int[] arr1 = arr;
		int n = size;
		int d = noOfIndexsToRotate;
		int ll = 0;
		int ul = n - 1;
		while(true){
			if(d == n - d){
				arr1 = swap(arr1, ll, ul, d);
				break;
			}
			else{
				if(d < n-d){
					arr1 = swap(arr1, ll, ul, d);
					ul = ul - d ;
					n = n - d;
				}
				else if(d > n - d){
					arr1 = swap(arr1, ll, ul, n - d);
					ll = ll + d;
					n = d;
				}
			}
		}
		return arr1;
	}


	public int[] swap(int[] temp, int ll, int ul, int d){
			for (int i = 0; i < d; i++) {
				int temp1 = temp[ll + i];
				temp[ll + i] = temp[ul - d + i + 1 ]; 
				temp[ul - d + i + 1] = temp1;
			}
			return temp;
		}

	public int[] clockwiseRotation(){
		int[] arr1 = arr;
		int temp;
		for (int i = 0; i < noOfIndexsToRotate; i++) {
			temp = arr1[size - 1];
			for (int j = size - 1; j > 0; j--) {
				arr1[j] = arr1[j - 1];
			}
			arr1[0] = temp;
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
	public static void printArray(int[] arrTemp){ // printing array for testing
		System.out.println(Arrays.toString(arrTemp));
		System.out.println("--------------------------");
	}
}
