package com.anju.sort;

import java.util.Arrays;

/**
How It Works (Step-by-Step)
----------------------------
> Find the smallest item in the list.
> Swap it with the first item.
> Move to the next position and repeat until the whole list is sorted.
array 	-> 5, 3, 8, 1, 2
1st itr -> 1, 3, 8, 5, 2
2nd itr	-> 1, 2, 8, 5, 3
3rd itr	-> 1, 2, 3, 5, 8 ...

Time Complexity: O(n²)

Simple to understand
Not efficient for large lists
Good for small datasets
*/
public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {1, 5, 3, 8, 2};
		System.out.println("Before sorting -> ["+ Arrays.toString(arr) +"]");
		for(int i=0; i<arr.length; i++) {
			int position = i; int smallest = arr[i];
			//find the lowest number
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j] < arr[i] && arr[j] < smallest) {
					position = j;
					smallest = arr[j];
				}
			}
			// swap the smallest
			arr[position] = arr[i];
			arr[i] = smallest;
		}
		
		System.out.println("After sorting -> ["+ Arrays.toString(arr) +"]");
	}
}
