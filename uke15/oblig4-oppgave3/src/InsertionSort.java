import java.util.Arrays;

public class InsertionSort {


	public static <T extends Comparable<T>> void insertionSort(T[] data) {
		// antar at tabellen ikke inneholder noen null referanser
		for (int i = 1; i < data.length; i++) {
			T   elem = data[i];
			int j    = i - 1;
			while (j >= 0 && elem.compareTo(data[j]) < 1) {
				data[j + 1] = data[j];
				j--;
			}
			data[j + 1] = elem;
		}
	}


	public static void main(String[] args) {
		Integer[] arr = {7, 2, 5, 9, 5, 3};
		System.out.println(Arrays.toString(arr));
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
