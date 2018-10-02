package DataStructure;

import java.util.Random;

public class PerformanceMeasurement {
		
	private SortedArrayBag arrayBag;
	private SortedLinkedBag linkedBag;
	private Random rand;
	private int[] data;
	private long startTime, endTime, insertingTime, findingMaxTime;
	
	public void generateData() {
		data = new int[5000];
		rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		for (int i = 0; i < data.length; i++)
			data[i] = rand.nextInt();
	}
	public void testSortedArrayBag() {
		System.out.println("[Sorted Array]");
		for(int i = 0; i < 5; i++) {
			arrayBag = new SortedArrayBag((i+1)*1000);
			startTime = System.nanoTime();
			for(int j= 0; j <(i + 1)*1000; j++) {
				arrayBag.add(data[j]);
			}
			
			endTime = System.nanoTime();
			insertingTime = endTime - startTime;
			
			startTime =  System.nanoTime();
			arrayBag.max((i+1)*1000);
			endTime = System.nanoTime();
			findingMaxTime = endTime - startTime;
			
			System.out.println("크기"+ (i + 1)*1000 +",\t삽입하기 " + insertingTime + "\t최대값 찾기" + findingMaxTime);
		}
	}
	
	
			
	public void testSortedLinkedBag() {
		System.out.println("\n[Sorted Linked]");
	
		for(int i = 0; i < 5; i++) {
			linkedBag = new SortedLinkedBag((i+1)*1000);
			startTime = System.nanoTime();
			for (int j = 0; j < (i + 1)*1000;j++) {
				linkedBag.add(data[j]);
			}
			linkedBag.printResult();
			endTime = System.nanoTime();
			insertingTime = endTime - startTime;
			
			startTime = System.nanoTime();
			linkedBag.max((i+1)*1000);
			endTime = System.nanoTime();
			findingMaxTime = endTime - startTime;
			
			System.out.println("크기" + (i+1)*1000 + ",\t삽입하기" + insertingTime + "\t최대값 찾기" + findingMaxTime);
			
		}
	}
	
	}
	
	

