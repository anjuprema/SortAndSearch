package com.anju.sort;

import java.util.Arrays;
/***
 * Implementation: Insert each element at its correct position starting from 1st. 
 * When an element smaller than sorted data is encountered, it is placed at correct position 
 * and rest array of array is moved forward. * 
 * 2, 3, 4, 12, [1], 23
 * ^_____________|    
 * 1, 2, 3, 4, 12, 23  
 * 
 * Pros: Insertion sort is best for small or partially sorted arrays, and only a few elements are misplaced in a complete big array.
 * Cons: Inefficient for large lists. Not as efficient as other sorting algorithms (merge sort, quick sort) for most cases
 * 
 * Best case (already sorted): O(n)
 * Worst case (reversed): O(n²)
 * 
 * */
public class InsertionSort {
	public void insertionSort(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			int key =  arr[i];
			
			int j=i-1;
			while(j>=0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;		
		}
	}
	public static void main(String[] args) {
		int[] arr = {2, 3, 23, 14, 27, 24, 43, 19, 57, 22, 17, 99, 1, 8, 102, 103};
		InsertionSort is = new InsertionSort();
		System.out.println("Before Sort: "+ Arrays.toString(arr));		
		is.insertionSort(arr);
		System.out.println("After Sort: "+ Arrays.toString(arr));
	}
}
