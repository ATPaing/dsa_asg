package SaleInformationSystem;

import java.util.HashMap;
import java.util.Scanner;

public class UtilityFunctions {
	static Scanner s = new Scanner(System.in);
	
	public static int ChooseRole() {
		System.out.println("Choose your role: \n 1) Admin \n 2) User");
		System.out.print("You are: ");
		int res = s.nextInt();
		s.nextLine();
		while (res < 1 || res >2) {
			System.out.println("Please choose between number 1 and 2");
			System.out.println("Choose your role: /n 1) Admin /n 2) User");
			res = s.nextInt();
			s.nextLine();
		}

		return res;
	}
	
	public static int ChooseAdminProcess() {
		System.out.println("=============================================");
		System.out.println("What function would you like to perform? \n 1) Enter new product \n 2) Search item \n 3) View all items \n 4) Update item \n 5) Delete item \n 0) Exit program");
		System.out.print("Please choose the number to perform the action: ");
		
		int chosenNum = s.nextInt();
		System.out.println("");
		return chosenNum;
	}
	
	public static int ChooseUserProcess() {
		System.out.println("=============================================");
		System.out.println("What function would you like to perform? \n 1) View items \n 2) Buy items \n 3) Search items \n 0) Exit program");
		System.out.print("Please choose the number to perform the action: ");
		
		int chosenNum = s.nextInt();
		System.out.println("");
		return chosenNum;
	}
	
	public static void askProductName() {
		// ask product name
		System.out.print("Please enter the product name: ");
		String pdtName = s.nextLine();
		while(pdtName == "") {
			System.out.print("Please enter the product name: ");
			pdtName = s.nextLine();
		}
		
		// ask item type
		System.out.println("Please enter the type of product: ");
		String pdtType = s.nextLine();
		while(pdtType  == "") {
			System.out.print("Please enter the product type: ");
			pdtType = s.nextLine();
		}
		
		// ask price
		System.out.println("Please enter the price: ");
		String pdtPrice = s.nextLine();
		while(pdtPrice == "") {
			System.out.print("Please enter the price: ");
			pdtPrice = s.nextLine();
		}
		
		// ask total stocks
		System.out.println("Please enter the available stock: ");
		String pdtStock = s.nextLine();
		while(pdtStock == "") {
			System.out.print("Please enter the available stocks: ");
			pdtStock = s.nextLine();
		}
		
	}
	
    public static void printTable(HashMap<String, String[]> hashMap) {
        // Define the header
        String[] headers = {"ID", "Name", "Type", "Price", "Stocks"};

        // Determine column widths
        int[] columnWidths = new int[headers.length];
        for (int i = 0; i < headers.length; i++) {
            columnWidths[i] = headers[i].length();
        }

        // Adjust column widths based on data
        for (String[] values : hashMap.values()) {
            for (int i = 0; i < values.length; i++) {
                columnWidths[i] = Math.max(columnWidths[i], values[i].length());
            }
        }

        // Print the header
        printRow(headers, columnWidths);
        printSeparator(columnWidths);

        // Print the data
        for (String[] values : hashMap.values()) {
            printRow(values, columnWidths);
        }
    }
	
    public static void printTableForUserView(HashMap<String, String[]> hashMap) {
        // Define the header
        String[] headers = {"No", "Name", "Type", "Price"};

        // Determine column widths
        int[] columnWidths = new int[headers.length];
        for (int i = 0; i < headers.length; i++) {
            columnWidths[i] = headers[i].length();
        }

        // Adjust column widths based on data
        int counter = 1;
        for (String[] values : hashMap.values()) {
            columnWidths[0] = Math.max(columnWidths[0], String.valueOf(counter).length());
            for (int i = 1; i <= 3; i++) { // Adjusted loop bounds
                columnWidths[i] = Math.max(columnWidths[i], values[i].length());
            }
            counter++;
        }

        // Print the header
        printRow(headers, columnWidths);
        printSeparator(columnWidths);

        // Print the data
        counter = 1; // reset the counter
        for (String[] values : hashMap.values()) {
            String[] userViewValues = {Integer.toString(counter), values[1], values[2], values[3]};
            printRow(userViewValues, columnWidths);
            counter++;
        }
        
    }

    
    public static void printSeparator(int[] columnWidths) {
        for (int width : columnWidths) {
            System.out.print("+");
            for (int i = 0; i < width + 2; i++) { // +2 for padding
                System.out.print("-");
            }
        }
        System.out.println("+");
    }
    
    
    
    public static void printRow(String[] row, int[] columnWidths) {
        for (int i = 0; i < row.length; i++) {
            System.out.printf("| %-"+columnWidths[i]+"s ", row[i]);
        }
        System.out.println("|");
    }
    
    //algorithms 
    
    
    // Function to perform merge sort on an array of string arrays
    public static void mergeSort(String[][] array) {
        if (array.length < 2) {
            return;
        }
        int mid = array.length / 2;
        String[][] left = new String[mid][];
        String[][] right = new String[array.length - mid][];

        // Split the array into two halves
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        // Recursively sort each half
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves
        merge(array, left, right);
    }

    // Merge function to merge two sorted arrays of string arrays
    private static void merge(String[][] array, String[][] left, String[][] right) {
        int i = 0, j = 0, k = 0;

        // Merge elements from left and right arrays
        while (i < left.length && j < right.length) {
            if (left[i][0].compareTo(right[j][0]) <= 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copy remaining elements of left array, if any
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Copy remaining elements of right array, if any
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
    
    // Function to perform binary search on a sorted array of string arrays
    public static int binarySearch(String[][] array, String target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Compare the target with the middle element
            int result = target.compareTo(array[mid][0]);

            // Check if target is present at mid
            if (result == 0) {
                return mid; // Target found
            }

            // If target is greater, ignore left half
            if (result > 0) {
                left = mid + 1;
            }
            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }
	
}
