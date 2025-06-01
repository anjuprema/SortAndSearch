package com.anju.sort;

import java.util.Arrays;

/***
 * Simplest Sorting Algo. 
 * 
 * Implementation: Repeatedly swap adjacent elements if they are in wrong order. 
 * 		If in an inner loop a swap dosen't happen means array is already sorted and we can
 * 		skip further outer loops. This adds on optimization. After 1st iteration of inner loop
 * 		the largest element is correctly places at arrays end location
 * Pros: Efficient for small or mostly-sorted arrays
 * Cons: Not efficient for large datasets(better to use MergeSort/Quicksort)
 * 
 * Time Complexity: O(n^2) which makes it very slow for large data sets
 * */
public class BubbleSort {
	public void bubbleSortRecurssive(int[] arr, int arrLength) {
		if(arrLength == 1) return;
		boolean swapped = false;
		
		for(int i=0; i<arrLength-1; i++) {
			if(arr[i] > arr[i+1]) {
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
				swapped = true;
			}
		}
		
		if(!swapped) return;
		
		bubbleSortRecurssive(arr, arrLength-1);
	}	
	
	public void bubbleSort(int[] arr) {
		int temp; boolean swapped;
		for(int i=0; i<arr.length; i++) {
			swapped = false;
			for(int j=0; j<arr.length-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = true;
				}
			}
			
			//if no swapps happens in a loop then all are sorted, we can break free
			if(!swapped) break;
		}
	}
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 23, 14, 27, 24, 43, 19, 57, 22, 17, 99, 1, 8, 102, 103};
		BubbleSort bs = new BubbleSort();
		System.out.println("Before Sort: "+ Arrays.toString(arr));		
		//bs.bubbleSort(arr);
		bs.bubbleSortRecurssive(arr, arr.length);
		System.out.println("After Sort: "+ Arrays.toString(arr));
	}
}
