
import java.util.*;

public class Main {

    //Elements removal.(T.C=O(NlogN),S.C=O(1))
    public static int elementsRemoval(Integer[] arr){
        int n = arr.length;
        Arrays.sort(arr, Collections.reverseOrder());
        int sum=0;
        int minSum = 0;

        //first Approach
//        for(int i=0; i<n; i++){
//            sum+=arr[i];
//            minSum+=sum;
//        }
//        return minSum;

        //Second Approach.
//        for(int i=n-1; i>=0; i--){
//            minSum += arr[i]*(n-i);
//        }
//        return minSum;

        //Third Approach.
        for(int i=0; i<n; i++){
            minSum += arr[i]*(i+1);
        }
        return minSum;
    }

    //Noble integer.
    public static int nobleInteger(Integer[] arr){
        int n = arr.length;
        int count = 0;
        int cnt = 0;

        //Approach1 BRUTE FORCE T.C = O(N^2)
//        for(int i=0; i<n; i++){
//            int count = 0;
//            for(int j=i+1; j<n; j++){
//                if(arr[i]<arr[j]){
//                    count++;
//                }
//            }
//            if(count == arr[i]){
//                cnt++;
//            }
//        }

        //Approach2 sorting the array. T.C=O(NlogN)
        Arrays.sort(arr,Collections.reverseOrder());
        if(arr[0]==0){
            cnt++;
        }
        for(int i=1; i<n; i++){
            if(arr[i]!=arr[i-1]){
                count = i;
            }
            if(count==arr[i]){
                cnt++;
            }
        }

        return cnt;
    }

    //Bth Smallest Element in the given array.
    public static int bThSmallestElement(Integer[] arr,int B){
        int n = arr.length;
        for(int i=0; i<B; i++){
            int curr_min = arr[i];
            int min_idx = i;
            for(int j=i+1; j<n; j++){
                if(arr[j]<curr_min){
                    curr_min = arr[j];
                    min_idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
        return arr[B-1];
    }



    public static void main(String[] args) {
        Scanner scn = new Scanner (System.in);
        int n =  scn.nextInt();
        Integer[] arr = new Integer[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
//        int elements_removal = elementsRemoval(arr);
//        System.out.println(elements_removal);

//        int noble_integer = nobleInteger(arr);
//        System.out.println(noble_integer);
        int B = scn.nextInt();

        int bth_smallest_element = bThSmallestElement(arr, B);
        System.out.println(bth_smallest_element);


    }
}