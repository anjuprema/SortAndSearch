package com.anju.sort;

import java.util.Arrays;

/**
 * Heap Sort: Build Heap tree from array, convert it to Max-heap using heapify() and move it to end of array
 * Implementation: 
 * 		Step 1: Have to convert array to binary tree (no need to physically translate). While traversing array,
 * 				element at position 'i' will have its left leaf item at (2*i +1) and right leaf item at (2*i +2)
 * 		Step 2: Identify all the non-leaf nodes and see if any left is bigger than node, 
 * 				starting from the 1st non-leaf node at (arrLength/2 -1) back to root at 0.
 * 		Step 3: Perform heapify() to build Max-heap. For each non-leaf node, biggest of right/left leaf is swapped with root. 
 * 				If a swap happens build max-heap for new parent node. After heapify() the biggest in array will be at position 0
 * 		Step 4: Swap the biggest element at position 0 to the end of array. Now as the biggest element is set in position,
 * 				decrease the array length by 1 and repeat till array is all sorted (recursive call till arrLength reaches 1) 
 * */

public class HeapSort {
	/**
	 * This method will consider a node at 'position', and if it sees its left/right child is bigger 
	 * then swaps it to make the node biggest than its children
	 * */
	private void heapify(int[] arr, int arrlength, int position) {
		// The element at provided 'position' will be compared against its child left & right nodes
		// The largest of child will be swapped to the 'position'
		
		int largestPosition = position; // assume largest is at position
		int leftChildPosition = 2*position + 1; 
		int rightChildPosition = 2*position + 2; 
		
		//if left child available and is largest
		if(leftChildPosition < arrlength && arr[leftChildPosition] > arr[largestPosition]) {
			largestPosition = leftChildPosition;
		}
		
		//if right child is available and is largest
		if(rightChildPosition < arrlength && arr[rightChildPosition] > arr[largestPosition]) {
			largestPosition = rightChildPosition;
		}
		
		//if a swapping is required
		if(position != largestPosition) {
			int temp = arr[position];
			arr[position] = arr[largestPosition];
			arr[largestPosition] = temp;
			
			//as a swap occured we need to heapify the new largest position
			heapify(arr, arrlength, largestPosition);
		}
	}
	/*
	 * For the considered array this method will
	 * 1. Loops through all non-leaf nodes and pushes the biggest element in array to Root-arr[0]
	 * 2. Swaps the biggest element at arr[0] to end of array
	 * 3. Decreases the array size by 1(as last element is in position) and repeats till array length reaches 1(last element)
	 * */
	private void heapSortRecursive(int[] arr, int arrLength) {
		//recursively perform till array length reaches 1(last element)
		if(arrLength <= 1) return;
		
		// 1. traverse from 1 level up the leaf nodes till root to create a max tree
		//                    (23)
		//				/    			\
		//			(14)  		          (89)           <- any node at position i will have (2*i + 1) as left node & (2*i + 2) as right node
		//         /    \               /       \
		//		(67)     (34)        (99)         (2)    <- node 1 level above leaf node is at position (arrLength/2 -1)
		//     /   \     /  \       /   \        /
		//   (110) (13) (1) (44)   (14) (3)    (9)
		// 2. heapify() will swap values to make the root the max value(max tree)
		
		//Step 1:
		for(int i=arrLength/2-1; i>=0; i--) { // on completing the loop, the largest element to root/arr[0]
			heapify(arr, arrLength, i);
		}
		
		//Now the max element at arr[0] need to be moved to 
		//last of array by swapping and arrayLength needs to be reduced by 1 
		//as the biggest has already taken the correct position
		
		//Step 2:
		int temp = arr[0];
		arr[0] = arr[arrLength-1];
		arr[arrLength-1] = temp;
		
		//Step 3:
		heapSortRecursive(arr, arrLength-1);
	}
	public static void main(String[] args) {
		int[] arr = {23, 14, 89, 67, 34, 99, 2, 110, 13, 1, 44, 14, 3, 9};
		HeapSort hs = new HeapSort();
		System.out.println("Before Sort: "+ Arrays.toString(arr));	
		hs.heapSortRecursive(arr, arr.length);
		System.out.println("After Sort: "+ Arrays.toString(arr));
	}
}
