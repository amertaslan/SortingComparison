import java.util.Random;

public class Test {
	private static SortingClass sortObject = new SortingClass();
	private static int[] array;
	private static int[] arrayToSort;
	private static int incValue = 0;
	private static int decValue = 100000;
	private static int randomValue = 0;
	private static Random random = new Random();
	private static long startTime = 0;
	private static long endTime = 0;
	
	public static void main(String[] args) {

			//equals array implementation.
//		array = new int[1000];
//		for (int i = 0; i < 1000; i++) {
//			array[i] = 1;
//		}
//		array = new int[10000];
//		for (int i = 0; i < 10000; i++) {
//			array[i] = 1;
//		}
//		array = new int[100000];
//		for (int i = 0; i < 100000; i++) {
//			array[i] = 1;
//		}
		
			//decreasing array implementation.
//		array = new int[1000];
//		for (int i = 0; i < 1000; i++) {
//			array[i] = decValue;
//			decValue--;
//		}
//		array = new int[10000];
//		for (int i = 0; i < 10000; i++) {
//			array[i] = decValue;
//			decValue--;
//		}
//		array = new int[100000];
//		for (int i = 0; i < 100000; i++) {
//			array[i] = decValue;
//			decValue--;
//		}
		
			//increasing array implementation.
//		array = new int[1000];
//		for (int i = 0; i < 1000; i++) {
//			array[i] = incValue;
//			incValue++;
//		}
//		array = new int[10000];
//		for (int i = 0; i < 10000; i++) {
//			array[i] = incValue;
//			incValue++;
//			
//		}
//		array = new int[100000];
//		for (int i = 0; i < 100000; i++) {
//			array[i] = incValue;
//			incValue++;
//		}
		
			//random array implementation.
//		array = new int[1000];
//		for (int i = 0; i < 1000; i++) {
//			randomValue = random.nextInt();
//			array[i] = randomValue;
//		}
		array = new int[10000];
		for (int i = 0; i < 10000; i++) {
			randomValue = random.nextInt();
			array[i] = randomValue;	
		}
//		array = new int[100000];
//		for (int i = 0; i < 100000; i++) {
//			randomValue = random.nextInt();
//			array[i] = randomValue;
//		}
		
		arrayToSort = array;
		
//		startTime = System.nanoTime();
//		sortObject.heapSort(arrayToSort);
//		endTime = System.nanoTime();
		
//		startTime = System.nanoTime();
//		sortObject.shellSort(arrayToSort);
//		endTime = System.nanoTime();
		
		startTime = System.nanoTime();
		sortObject.dualPivotQuicksort(arrayToSort, 0, arrayToSort.length - 1, 3);
		endTime = System.nanoTime();
		
		//printing sorted array and timevalue.
		SortingClass.printArray(arrayToSort);
		System.out.println(endTime-startTime);
	}
}
