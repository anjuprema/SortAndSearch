package com.anju.search;

/*
 * 
 * */
public class BinarySearch {
	public static void binarySearch(int[] sortedArr, int searchFor, int start, int end) {
		int mid;
		while(start <= end) {
			mid = start + (end - start) /2;
			System.out.println("start"+ start +", end"+end+ ", mid"+mid);
			if(sortedArr[mid] == searchFor) {
				System.out.println("Found "+ searchFor + " at position "+ mid);
				break;
			}
			else if(sortedArr[mid] > searchFor) {
				end = mid - 1;				
			}
			else {
				start = mid + 1;
			}
		}
	}
	
	public static int binarySearchReccursive(int[] sortedArr, int searchFor, int start, int end) {
		int mid = start + (end - start) /2;
		System.out.println("start"+ start +", end"+end+ ", mid"+mid);
		if(start > end) return -1;
		if(sortedArr[mid] == searchFor) {
			return mid;
		}
		else if(sortedArr[mid] > searchFor) {
			return binarySearchReccursive(sortedArr, searchFor, start, mid - 1);				
		}
		else {
			return binarySearchReccursive(sortedArr, searchFor, mid + 1, end);
		}
	}
	public static void main(String[] args) {
		int[] sortedArr = {4, 6, 9, 21, 25, 27, 29, 37, 52, 99, 101};
		int searchFor = 101;
		
		int start = 0; int end = sortedArr.length-1; 
		binarySearch(sortedArr, searchFor, start, end);
		
		System.out.println("*******************");
		
		System.out.println("Found "+ searchFor +" at position "+ binarySearchReccursive(sortedArr, searchFor, start, end));
	}

}
