package com.anju.sort;

import java.util.Arrays;

/**
 * Better check MergeSortReccursive impl
 * */
public class MergeSort {
	private void merge(int[] arr, int left, int mid, int right) {
		int[] leftArr = new int[mid-left+1];
		int[] rightArr = new int[right-mid];
		
		for(int i=0; i<leftArr.length; i++) {
			leftArr[i] = arr[left+i];
		}
		for(int i=0; i<rightArr.length; i++) {
			rightArr[i] = arr[mid+ 1+ i];
		}
		
		int i=0; int j=0; int k=left;
		while(i<leftArr.length && j<rightArr.length) {
			if(leftArr[i] <= rightArr[j]) {
				arr[k++] = leftArr[i++];
			} else {
				arr[k++] = rightArr[j++];
			}
		}
		
		while(i<leftArr.length) {
			arr[k++] = leftArr[i++];
		}
		
		//System.out.println(right-mid);
		while(j<rightArr.length) {
			arr[k++] = rightArr[j++];
		}
	}
	private void mergeSortIterative(int[] arr) {
		int arrLen = arr.length;
		
		//1, 2, 4, 8, 16..
		for(int i=1; i<arrLen-1; i=2*i) {
			
			//Starting of left array
			//i=1, j ->0 , 2 , 4 , 6 , 8 , 10 
			//i=2, j ->0 , 4 , 8 
			//i=4, j ->0 , 8 
			//i=8, j ->0 
			for(int leftStart=0; leftStart<arrLen-1; leftStart=(leftStart+(2*i))) {
				//find mid & right end point
				int mid = Math.min((leftStart+(i-1)), arrLen-1);
				int rightEnd = Math.min((leftStart+(2*i)-1), arrLen-1);
				
				merge(arr, leftStart, mid, rightEnd);
			}			
		}
	}
	public static void main(String[] args) {
		int[] arr = {23, 14, 89, 67, 34, 99, 2, 110, 13, 1, 44, 14, 3};
		MergeSort ms = new MergeSort();
		System.out.println("Before Sort: "+ Arrays.toString(arr));	
		ms.mergeSortIterative(arr);
		System.out.println("After Sort: "+ Arrays.toString(arr));	
	}

}
