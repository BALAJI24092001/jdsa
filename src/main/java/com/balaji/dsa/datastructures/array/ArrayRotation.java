package com.balaji.dsa.datastructures.array;
public class ArrayRotation{
	public static void main(String[] args) {
		int[] arr;
		int size;
		int noOfIndexsToRotate;
	}

	public arrayRotation(int[] arr, int size, int noOfIndexsToRotate){
		this.arr = arr;
		this.size = size;
		this.noOfIndexsToRotate = noOfIndexsToRotate;
	}
	public method1(){
		int[] temp;
		int[] arr1 = arr;
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
	}
	
}
