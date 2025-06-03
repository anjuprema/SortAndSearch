package com.anju.sort;

import java.util.Arrays;

/**
 * Quick Sort: Divide and Conquer by choosing a pivot. Common method to choose pivot is last element of arr
 * Refer: https://www.google.com/search?sca_esv=c59ccef057ebb78d&rlz=1C1GCEU_enDE1162DE1162&sxsrf=AE3TifPGIWWMCtiCZnh1IGuR_qejDTQpmg:1748875677735&q=quick+sort&udm=7&fbs=AIIjpHxU7SXXniUZfeShr2fp4giZ1Y6MJ25_tmWITc7uy4KIeoJTKjrFjVxydQWqI2NcOha3O1YqG67F0QIhAOFN_ob1xGdzU5Cnyn-oUzTul2B5TXRzAeIy3FI7wzggwHPeZE5cVxJF3TSy6VJy__A91WVw8jso2MVzslHtne5IBzFZ7wiBgKvuGJadfgZ9to9wUGx5Slqn&sa=X&sqi=2&ved=2ahUKEwjVnZzM_dKNAxXS1AIHHdMINyEQtKgLegQIEhAB&biw=1536&bih=730&dpr=1.25#fpstate=ive&vld=cid:b0ad2b76,vid:Vtckgz38QHs,st:0
 * 
 * Implementation: Choose a pivot element (last element of array). Needs 2 pointers i & j, i stsrts from low-1 (-1),
 * 				j starts from 0 - array length. Loop through j to see if element at j is less than pivot. 
 * 				If less then increment i & swap with it, If bigger no swap/ no i increment, only j will increment to check next element.
 * 				When it reaches end pivot is places at 'i'. After 1st iteration pivot element is at correct position. Now repeat the same
 * 				for left and right sub-arrays of pivot
 * 
 * Pros: Efficient on large data sets,  
 * 		low overhead as it only requires a small amount of memory to function, unlike merge sort it is cache friendly
 * Cons: Not a good choice for small data sets, worst-case time complexity of O(n2)
 * */
public class QuickSort {
	private void quickSortReccursive(int[] arr, int start, int end) {
		if(start >= end) return;
		
		int pivot = arr[end];
		int i = start-1; 
		int j;
		for(j=start; j<end; j++) {
			// we will swap only if element is less than pivot
			if(arr[j] < pivot) {
				//increment i, swap element at i&j
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		//place pivot in correct position
		i++;
		int temp = arr[i];
		arr[i] = arr[end];
		arr[end] = temp;
		
		quickSortReccursive(arr, start, i-1);
		quickSortReccursive(arr, i+1, end);		
	}
	public static void main(String[] args) {
		int[] arr = {23, 14, 89, 67, 34, 99, 2, 110, 13, 1, 44, 14, 3};
		QuickSort qs = new QuickSort();
		System.out.println("Before Sort: "+ Arrays.toString(arr));	
		qs.quickSortReccursive(arr, 0, arr.length-1);
		System.out.println("After Sort: "+ Arrays.toString(arr));

	}

}
