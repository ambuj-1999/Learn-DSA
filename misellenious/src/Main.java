import java.util.*;

public class Main{
    public static int[] sortArray(int[] arr){
        int n= arr.length;
        for(int i=1; i<n; i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return arr;
    }
    

    public static int findMaxTwoSum(int[] arr){
        int n= arr.length;
        int max=arr[0];
        int maxSum = 0;
        int j=0;
        for(int i=1; i<n; i++){
            if(arr[i]>max){
                max = arr[i];
                j = i;
            }
        }
        for(int i=0;i<n;i++){
            if(j!=i){
                if(max+arr[i]>maxSum){
                    maxSum = max+arr[i];
                }
            }

        }

        return maxSum;

    }


    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
//        int[] sortedArray = sortArray(arr);
//        for (int i=0; i<n; i++) {
//            System.out.print(sortedArray[i]+" ");
//        }

//        int maxSum = findMaxTwoSum(arr);
//        System.out.println(maxSum);
        int ans = maxMinSubarray3(arr);
        System.out.println(ans);

//        ArrayList<ArrayList<Integer>> ans=solve(arr);
//        int size = ans.size();
//        for(int i=0; i<size; i++){
//            int rowSize = ans.get(i).size();
//            for(int j=0; j<rowSize; j++){
//                System.out.print(ans.get(i).get(j)+" ");
//            }
//            System.out.println();
//
//        }


    }
}