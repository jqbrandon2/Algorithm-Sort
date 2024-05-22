/**************************************************
Problem Set: Problem Set 3: Quicksort
Name: Brandon Evans
Date: 9/26/23
**************************************************/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class UASort {

	private int[] a = new int[19];
	private String[] b = new String[15];
	
	public static void main(String[] args) throws IOException {
		
		
		UASort arr = new UASort(); 
		arr.loadData(args[0],args[1],args[2],args[3]);
		
	}
	
	
	public String QuickSortAscNum(int[] A, int p, int r) {
		int q = 0;
		
		if (p < r) {
			q = PartitionAscNum(A,p,r);
			QuickSortAscNum(A, p, q-1);
			QuickSortAscNum(A, q+1, r);
		}
		return Arrays.toString(A);
		
	}
	
	public String QuickSortDescNum(int[] A, int p, int r) {
		int q = 0;
		
		if (p < r) {
			q = PartitionDescNum(A,p,r);
			QuickSortDescNum(A, p, q-1);
			QuickSortDescNum(A, q+1, r);
		}
		return Arrays.toString(A);
		
	}
	
	public String QuickSortAscString(String[] A, int p, int r) {
		int q = 0;
		
		if (p < r) {
			q = PartitionAscString(A,p,r);
			QuickSortAscString(A, p, q-1);
			QuickSortAscString(A, q+1, r);
		}
		return Arrays.toString(A);
		
	}
	
	public String QuickSortDescString(String[] A, int p, int r) {
		int q = 0;
		
		if (p < r) {
			q = PartitionDescString(A,p,r);
			QuickSortDescString(A, p, q-1);
			QuickSortDescString(A, q+1, r);
		}
		return Arrays.toString(A);
		
	}
	
	public int PartitionAscNum(int[]A, int p, int r) {
		int x = A[selectPivot(A, p, r)];
		int i = p-1;
		
		for(int j = p; j<r; j++) {
			if( A[j] <= x) {
				i = i+1;
				
				int temp1 = A[i];
				A[i] = A[j];
				A[j] = temp1;
			}
		}
		int temp2 = A[i+1];
		A[i+1] = A[r];
		A[r] = temp2;
		
		return i+1;
	}
	
	public int PartitionDescNum(int[]A, int p, int r) {
		int x = A[selectPivot(A, p, r)];
		int i = p-1;
		
		for(int j = p; j<r; j++) {
			if( A[j] > x) {
				i = i+1;
				
				int temp1 = A[i];
				A[i] = A[j];
				A[j] = temp1;
			}
		}
		int temp2 = A[i+1];
		A[i+1] = A[r];
		A[r] = temp2;
		
		return i+1;
	}
	
	public int PartitionAscString(String[]A, int p, int r) {
		String x = A[selectPivotString(A, p, r)];
		int i = p-1;
		
		for(int j = p; j<r; j++) {
			if( A[j].compareToIgnoreCase(x) <= 0) {
				i = i+1;
				
				String temp1 = A[i];
				A[i] = A[j];
				A[j] = temp1;
			}
		}
		String temp2 = A[i+1];
		A[i+1] = A[r];
		A[r] = temp2;
		
		return i+1;
	}
	
	public int PartitionDescString(String[]A, int p, int r) {
		String x = A[selectPivotString(A, p, r)];
		int i = p-1;
		
		for(int j = p; j<r; j++) {
			if( A[j].compareToIgnoreCase(x) > 0) {
				i = i+1;
				
				String temp1 = A[i];
				A[i] = A[j];
				A[j] = temp1;
			}
		}
		String temp2 = A[i+1];
		A[i+1] = A[r];
		A[r] = temp2;
		
		return i+1;
	}

	int selectPivot(int[] A, int p, int r) {
		int median = 0;
		int index1 = p;
		int index2 = (p+r)/2;
		int index3 = r;
		
		
		if (A.length >= 2 && A.length % 2 == 0) {
			median = (index1 + index2+ index3)/3;
		} else if (A.length >= 2 && A.length % 2 == 1) {
			median = index2;
		} else {
			median = index3;
		}
		
		return index3;
	}
	
	int selectPivotString(String[] A, int p, int r) {
		int median = 0;
		int index1 = p;
		int index2 = (p+r)/2;
		int index3 = r;
		
		
		if (A.length >= 2 && A.length % 2 == 0) {
			median = (index1 + index2+ index3)/3;
		} else if (A.length >= 2 && A.length % 2 == 1) {
			median = index2;
		} else {
			median = index3;
		}
		
		return index3;
	}
	
	 public void loadData(String inputDirectory, String outputDirectory, String value, String order) throws IOException {
	    	
		 	long begin = System.currentTimeMillis();
		 
		 	File folder = new File(inputDirectory);
	    	File[] listOfFiles = folder.listFiles();
	    	
	    	int counter = 0;
	    	
	    	for (File file : listOfFiles) {
	    		if (file.isFile()) {
	    			counter++;
	    			String fileName = file.getName();
	    			BufferedReader br = new BufferedReader(new FileReader(file));
	    			String line;
	    			
	    			while ((line = br.readLine()) != null) {
	    				
	    				String[] val = line.split("\n");    				
	    				
	    				for(int i = 0; i<val.length; i++) {
	    					a[i] = Integer.parseInt(val[i]);
	    					b[i] = val[i];
	    				}
	    					
	    				if(value.equals("numeric") && order.equals("ascending")) {
		    				QuickSortAscNum(a, 0, a.length-1);
		    				File out = new File(outputDirectory);
		    				File output = new File(out, fileName);
		    				FileWriter writer = new FileWriter(output);
		    				for(int i = 0; i<a.length; i++) {
		    					writer.write(a[i] + "\n");
		    				}
		    				writer.close();
		    			}
	    				
	    				if(value.equals("numeric") && order.equals("descending")) {
		    				QuickSortDescNum(a, 0, a.length-1);
		    				File out = new File(outputDirectory);
		    				File output = new File(out, fileName);
		    				FileWriter writer = new FileWriter(output);
		    				for(int i = 0; i<a.length; i++) {
		    					writer.write(a[i] + "\n");
		    				}
		    				writer.close();
		    			}
	    				
	    				if(value.equals("text") && order.equals("ascending")) {
		    				QuickSortAscString(b, 0, b.length-1);
		    				File out = new File(outputDirectory);
		    				File output = new File(out, fileName);
		    				FileWriter writer = new FileWriter(output);
		    				for(int i = 0; i<b.length; i++) {
		    					writer.write(b[i] + "\n");
		    				}
		    				writer.close();
		    			}
	    				
	    				if(value.equals("text") && order.equals("descending")) {
		    				QuickSortDescString(b, 0, b.length-1);
		    				File out = new File(outputDirectory);
		    				File output = new File(out, fileName);
		    				FileWriter writer = new FileWriter(output);
		    				for(int i = 0; i<b.length; i++) {
		    					writer.write(b[i] + "\n");
		    				}
		    				writer.close();
		    			}
	    				
	    				else { 
	    					System.out.println("You've entered the wrong format.");
	    				}
	    				
	    			}
	    			
	    			
	    			
	    			
	    		}
	    	}
	    long end = System.currentTimeMillis();
			
			
		System.out.println("Number of files sorted: \t" + counter);
		System.out.println("Input Directory: \t\t" + inputDirectory);
		System.out.println("Output Directory: \t\t" + outputDirectory);
		System.out.println();
		System.out.println("Start Time: \t\t\t" + begin);
		System.out.println("End Time: \t\t\t" + end);
		System.out.println("Elasped Time: \t\t\t" + ((end - begin)/1000));
			
			
	}
}
