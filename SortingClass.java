
public class SortingClass {

	public void heapSort(int arrayToSort[]) 
	{ 
		int arrayLenght = arrayToSort.length; 

		for (int i = arrayLenght / 2 - 1; i >= 0; i--) 
			heapify(arrayToSort, arrayLenght, i); 

		// One by one extract an element from heap 
		for (int i=arrayLenght-1; i>0; i--) 
		{ 
			// Move current root to end 
			int temp = arrayToSort[0]; 
			arrayToSort[0] = arrayToSort[i]; 
			arrayToSort[i] = temp; 

			// call max heapify on the reduced heap 
			heapify(arrayToSort, i, 0); 
		} 
	} 

	public void heapify(int arrayToSort[], int n, int i) 
	{ 
		int largest = i; // Initialize largest as root if largest is not root it will be changed.
		int l = 2*i + 1; // left child = 2*i + 1 
		int r = 2*i + 2; // right child = 2*i + 2 

		//If left child is larger than root 
		if (l < n && arrayToSort[l] > arrayToSort[largest]) 
			largest = l; 

		//If right child is larger than root 
		if (r < n && arrayToSort[r] > arrayToSort[largest]) 
			largest = r; 

		//If largest is not root.
		if (largest != i) 
		{ 
			int swap = arrayToSort[i]; 
			arrayToSort[i] = arrayToSort[largest]; 
			arrayToSort[largest] = swap; 

			// Recursively heapify the affected sub-tree 
			heapify(arrayToSort, n, largest); 
		} 
	} 

	public void shellSort(int arrayToSort[]) {
		int arrayLenght = arrayToSort.length;

		//Start with a big gap, then reduce the gap. 
		for (int gap = arrayLenght / 2; gap > 0; gap /= 2) {
			// Do a gapped insertion sort for this gap size. 
			for (int i = gap; i < arrayLenght; i++) {
				int key = arrayToSort[i];
				int j = i;
				while (j >= gap && arrayToSort[j - gap] > key) {
					arrayToSort[j] = arrayToSort[j - gap];
					j -= gap;
				}
				//put key (the original a[i]) in its correct position.
				arrayToSort[j] = key;
			}
		}
	}

	public void dualPivotQuicksort(int[] arrayToSort, int left,int right, int div) {
		int len = right - left;
		//insertion sort for arrays which is lengths are smaller then 27
		if (len < 27) { 
			for (int i = left + 1; i <= right; i++) {

				for (int j = i; j > left && arrayToSort[j] < arrayToSort[j - 1]; j--) {
					swap(arrayToSort, j, j - 1);
				}
			}
			return;
		}

		int third = len / div;

		// "medians"
		int firstMedian = left + third;
		int secondMedian = right - third;

		if (firstMedian <= left) {
			firstMedian = left + 1;
		}

		if (secondMedian >= right) {
			secondMedian = right - 1;
		}

		if (arrayToSort[firstMedian] < arrayToSort[secondMedian]) {
			swap(arrayToSort, firstMedian, left);
			swap(arrayToSort, secondMedian, right);
		}

		else {
			swap(arrayToSort, firstMedian, right);
			swap(arrayToSort, secondMedian, left);
		}

		// pivots
		int pivot1 = arrayToSort[left];
		int pivot2 = arrayToSort[right];

		// pointers
		int less = left + 1;
		int great = right - 1;

		// sorting
		for (int k = less; k <= great; k++) {
			if (arrayToSort[k] < pivot1) {
				swap(arrayToSort, k, less++);
			}
			else if (arrayToSort[k] > pivot2) {
				while (k < great && arrayToSort[great] > pivot2) {
					great--;
				}
				swap(arrayToSort, k, great--);
				if (arrayToSort[k] < pivot1) {
					swap(arrayToSort, k, less++);
				}
			}
		}
		//swaps
		int dist = great - less;
		if (dist < 13) {
			div++;
		}
		swap(arrayToSort, less - 1, left);
		swap(arrayToSort, great + 1, right);
		//subarrays
		dualPivotQuicksort(arrayToSort, left, less - 2, div);
		dualPivotQuicksort(arrayToSort, great + 2, right, div);
		//equal elements
		if (dist > len - 13 && pivot1 != pivot2) {
			for (int k = less; k <= great; k++) {
				if (arrayToSort[k] == pivot1) {
					swap(arrayToSort, k, less++);
				}
				else if (arrayToSort[k] == pivot2) {
					swap(arrayToSort, k, great--);
					if (arrayToSort[k] == pivot1) {
						swap(arrayToSort, k, less++);
					}
				}
			}
		}
		//subarray
		if (pivot1 < pivot2) {
			dualPivotQuicksort(arrayToSort, less, great, div);
		}
	}

	private static void swap(int[] arrayToSort, int i, int j) {
		int temp = arrayToSort[i];
		arrayToSort[i] = arrayToSort[j];
		arrayToSort[j] = temp;
	}

	static void printArray(int array[]) { 
		int n = array.length; 
		for (int i=0; i<n; ++i) 
			System.out.println(array[i]+" "); 

	} 



}
