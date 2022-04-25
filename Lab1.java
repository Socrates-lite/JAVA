import java.util.Arrays;

public class Lab1 {
	
	public static void main(String[] args) {
		int[] list1 = {4, 7, 3, 2, 8, 1, 5};
		int[] list2 = new int[list1.length];
		
		if(partionable(list1,list2)) {System.out.println("partitioned");}
		else {
			System.out.println("cannot be partitioned");
		}
		System.out.println(Arrays.toString(list1));
		System.out.println(Arrays.toString(list2));
		System.out.println();
		
		int[] lista = {4, 7, 3, 2, 8, 1, 5};
		int[] listb = new int[list1.length];
		
		if(partionable2to1(lista,listb)) {System.out.println("partitioned");}
		else {
			System.out.println("cannot be partitioned");
		}
		System.out.println(Arrays.toString(lista));
		System.out.println(Arrays.toString(listb));
	}

	
	public static boolean partionable2to1(int[] list1, int[] list2) {
		return partionable2to1(list1, list2, 0);
	}
	
	
	public static boolean partionable2to1(int[] list1, int[] list2, int start) {
		
		int sum1 = 0;
		int sum2 = 0;
		//start = 0;
		
		for(int i = 0; i < list1.length ; i++) {
			sum1 += list1[i];
			sum2 += list2[i];
		}
		
		if (sum1 == ((2*sum2))) return true;
		
		for(int i = start; i < list1.length ; i++) {
			list2[i] = list1[i];
			list1[i] = 0;			//cut paste the number
			
			if(partionable2to1(list1,list2,i+1)) return true;
			
			list1[i] = list2[i];
			list2[i] = 0;
		}
		return false;
	}
	
	public static boolean partionable(int[] list1, int[] list2) {
		return partionable(list1, list2, 0);
	}
	
	
	public static boolean partionable(int[] list1, int[] list2, int start) {
		
		int sum1 = 0;
		int sum2 = 0;
		//start = 0;
		
		for(int i = 0; i < list1.length ; i++) {
			sum1 += list1[i];
			sum2 += list2[i];
		}
		
		if (sum1 == sum2) return true;
		
		for(int i = start; i < list1.length ; i++) {
			list2[i] = list1[i];
			list1[i] = 0;			//cut paste the number
			
			if(partionable(list1,list2,i+1)) return true;
			
			list1[i] = list2[i];
			list2[i] = 0;
		}
		return false;
	}
	
	
}


