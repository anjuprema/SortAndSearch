package com.anju.sort;

import java.util.Arrays;

/**
 * Merge Sort: Divide and Conquer Rule
 * 
 * Implementation: Divide the array till it is 1 element length and when merging sort and join
 * Pros: For sorting large datasets with worst-case time complexity of O(N logN)
 * Cons: Memory constraint for storing sub-arrays. Merge Sort is slower than QuickSort which is more cache friendly (In-place).
 * 		 Merge sort is not an in-place sorting algorithm, which means it requires additional memory to store the sorted data.
 * */

public class MergeSortReccursive {
	private void merge(int[] arr, int[] leftArr, int leftArrLength, int [] rightArr, int rightArrLength) {
		int i=0; int j=0; int k=0;
		while(i<leftArrLength && j<rightArrLength) {
			if(leftArr[i] <= rightArr[j]) {
				arr[k++] = leftArr[i++];
			} else {
				arr[k++] = rightArr[j++];
			}			
		}
		
		while(i<leftArrLength) {
			arr[k++] = leftArr[i++];
		}
		
		while(j<rightArrLength) {
			arr[k++] = rightArr[j++];
		}
	}
	private void mergeSortReccursive(int[] arr, int arrLength) {
		if(arrLength < 2) return;
		
		int mid = arrLength/2;				
		int[] leftArr = new int[mid];
		int[] rightArr = new int[arrLength - mid];
		
		for(int i=0; i<leftArr.length; i++) {
			leftArr[i] = arr[i];
		}
		
		for(int i=0; i<rightArr.length; i++) {
			rightArr[i] = arr[mid+i];
		}
		
		mergeSortReccursive(leftArr, leftArr.length);
		mergeSortReccursive(rightArr, rightArr.length);
		
		merge(arr, leftArr, leftArr.length, rightArr, rightArr.length);
	}
	public static void main(String[] args) {
		int[] arr = {23, 14, 89, 67, 34, 99, 2, 110, 13, 1, 44, 14, 3};
		MergeSortReccursive ms = new MergeSortReccursive();
		System.out.println("Before Sort: "+ Arrays.toString(arr));	
		ms.mergeSortReccursive(arr, arr.length);
		System.out.println("After Sort: "+ Arrays.toString(arr));
	}
}
