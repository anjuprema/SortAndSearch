package com.anju.search;

import java.util.Arrays;

/*
 Prerequisite: Sorted array
 Logic: Validate an exclude 1st and last position. Check on places that are powers of 2 (1, 2, 4, 8, 16... etc)
 Check till we reach a place where value is > value we are checking and perform binary search between last 2 place
 [4, 7, 14, 23, 27, 44, 55, 78]
     |   |       |            
     1   2       4              8..
     
Pros: Applying Binary Search on the entire dataset may prove to be costly. 
Exponential Search can reduce this data into smaller, easily searchable partitions.
 
 * */
public class ExponentialSearch {
	public static void exponentialSearch(int[] arr, int searchFor) {
		if(arr[0] == searchFor || arr[arr.length-1] == searchFor) {
			System.out.println("Located "+ searchFor +" in array");
		} else {
			int index = 1;
			
			while(index < arr.length && arr[index] <= searchFor) {
				index = index * 2;
			}
			int foundAt = Arrays.binarySearch(arr, index/2, Math.min(index, arr.length), searchFor);
			System.out.println("Located "+ searchFor +" in array at "+foundAt);
		}
	}
	public static void main(String[] args) {
		int[] arr = {4, 7, 14, 23, 27, 44, 55, 78};
		int searchFor = 56;
		exponentialSearch(arr, searchFor);
	}

}
