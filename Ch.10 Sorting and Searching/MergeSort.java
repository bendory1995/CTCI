import java.util.*;
public class MergeSort{

    public static void main(String[] args){
        Random rand = new Random();
        int [] numbers = new int[10];

        for(int i = 0; i < numbers.length; i++){
            numbers[i] = rand.nextInt(100000);
        }
        System.out.println("before: ");
        printArray(numbers);

        mergeSort(numbers);
        System.out.println("after: ");
        printArray(numbers);
    }

    private static void mergeSort(int [] array){
        int [] helper = new int [array.length];
        mergeSort(array, helper, 0, array.length-1);
    }

    private static void mergeSort(int [] array, int [] helper, int low, int high){
        if (low < high){
            int middle = low + (high-low)/2;
            mergeSort(array, helper, low, middle);
            mergeSort(array, helper, middle+1, high);
            merge(array, helper, low, middle, high);
        }
    }

    private static void merge(int [] array, int [] helper, int low, int middle, int high){
        for (int i = low; i < high ;i ++){
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        while(helperLeft <= middle && helperRight <= high){
            if(helper[helperLeft] <= helper[helperRight]){
                array[current] = helper[helperLeft];
                helperLeft++;
            }
            else{
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        int remaining = middle - helperLeft;
        for(int i = 0; i <= remaining; i++){
            array[current+i] = helper[helperLeft+i];
        }

    }

    private static void printArray(int [] numbers){
        for(int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i]);
        }
        System.out.println();
    }
}