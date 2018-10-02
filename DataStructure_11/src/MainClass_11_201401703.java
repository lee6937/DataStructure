public class MainClass_11_201401703 {
    public static void main(String args[]){
        IO_Manager_201401703 io = new IO_Manager_201401703();
        Sort_201401703 sort = new Sort_201401703();
        long start, end;
//        System.out.println("Start to Compare Each Sorting Methods Performance");
//        System.out.println("================BubbleSort_O(n^2)================");
//        sort.initDataSet(io.readData());
//        start = System.currentTimeMillis();
//        sort.bubbleSort();
//        end = System.currentTimeMillis();
//        System.out.println("Taken Time(ms) : " + (end-start));
//
//        System.out.println("================InsertionSort_O(n^2)================");
//        sort.initDataSet(io.readData());
//        start = System.currentTimeMillis();
//        sort.insertionSort();
//        end = System.currentTimeMillis();
//        System.out.println("Taken Time(ms) : " + (end-start));

        System.out.println("================MergeSort_O(nlog2(n))================");
        sort.initDataSet(io.readData());
        start = System.currentTimeMillis();
        sort.mergeSort(0,sort.getSize());
        end = System.currentTimeMillis();
        System.out.println("Taken Time(ms) : " + (end-start));

        System.out.println("================QuickSort_O(nlog2(n))================");
        sort.initDataSet(io.readData());
        start = System.currentTimeMillis();
        sort.quickSort(0, sort.getSize()-1);
        end = System.currentTimeMillis();
        System.out.println("Taken Time(ms) : " + (end-start));

    }

}
