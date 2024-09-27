import java.util.*;
public class Main {
    //calculating prefix Sum.
    public static int[] prefixSum(int[] arr){
        int n =arr.length;
        int[] pf = new int[n];
        pf[0] = arr[0];
        for(int i=1; i<n; i++){
            pf[i] = pf[i-1]+arr[i];
        }
        return pf;

    }
    //Range Sum Query Problem using prefix sum.
    public static int[] rangeSumQuery(int[] arr){
        Scanner scn  = new Scanner(System.in);
        int m = scn.nextInt();
        int[][] B = new int[m][2];
        for(int i=0; i<m; i++){
            B[i][0] = scn.nextInt();
            B[i][1] = scn.nextInt();
        }
        int pf[] = prefixSum(arr);
        int[] ans = new int[m];
        for(int i=0; i<m; i++){
            int l = B[i][0],r = B[i][1];
            if(l==0){
                ans[i] = pf[B[i][1]];
            }
            else{
                ans[i] = pf[r]-pf[l-1];
            }

        }
        return ans;

    }
    //calculating odd prefix sum.
    public static int[] oddPrefixSum(int[] arr){
        int n = arr.length;
        int[] pf = new int[n];
        pf[0] = 0;
        for(int i=1; i<n; i++){
            if(i%2==0){
                pf[i] = pf[i-1];
            }
            else{
                pf[i] = pf[i-1]+arr[i];
            }
        }
        return pf;
    }
    //calculating even prefix sum.
    public static int[] evenPrefixSum(int[] arr){
        int n = arr.length;
        int[] pf = new int[n];
        pf[0] = arr[0];
        for(int i=1; i<n; i++){
            if(i%2==0){
                pf[i] = pf[i-1]+arr[i];
            }
            else{
                pf[i] = pf[i-1];
            }
        }
        return pf;
    }
    //special index problem using prefixsum.
    public static int specialIndex(int[] arr){
        int n = arr.length;
        int[] pfOdd = oddPrefixSum(arr);
        int[] pfEven = evenPrefixSum(arr);
        int count = 0;
        int sum_even_index,sum_odd_index,x,y,a,b;
        for(int i=0; i<n; i++){

            if(i==0){
                sum_even_index = pfOdd[n-1];
                sum_odd_index = pfEven[n-1]-pfEven[0];
                if(sum_even_index==sum_odd_index) count++;
            }
            else{
                x = pfEven[i-1];
                y = pfOdd[n-1]-pfOdd[i];
                sum_even_index = x+y;
                a = pfOdd[i-1];
                b = pfEven[n-1]-pfEven[i];
                sum_odd_index = a+b;
                if(sum_even_index==sum_odd_index) count++;
            }

        }
        return count;

    }
    //equilibrium index of an array using prefixsum.
    public static int equilibriumIndex(int[] arr){
        int[] pf = prefixSum(arr);
        int n = arr.length;
        int sum_at_lower,sum_at_higher;
        for(int i=0; i<n; i++){
            if(i==0) sum_at_lower=0;
            else sum_at_lower = pf[i-1];
            if(i==n-1) sum_at_higher=0;
            else sum_at_higher = pf[n-1]-pf[i];
            if(sum_at_higher==sum_at_lower) return i;
        }
        return -1;
    }
    //calculating suffix sum.
    public static int[] suffixSum(int[] arr){
        int n = arr.length;
        int[] sf = new int[n];
        sf[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--){
            sf[i] = sf[i+1]+arr[i];
        }
        return sf;
    }
    //pick from both sides problem using prefixsum, suffixsum,carryforward.
    public static int pickFromBothSides(int[] arr, int B){
        int[] pf = prefixSum(arr);
        int[] sf = suffixSum(arr);
        int N = arr.length;

        int maxSum = Math.max(pf[B-1],sf[N-B]);
        for(int i=1; i<B; i++){
            maxSum = Math.max(maxSum,pf[i-1]+sf[N-B+i]);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
//        int B = scn.nextInt();
//        int maxSum = pickFromBothSides(arr,B);
//        System.out.println(maxSum);
//        int[] rangeSumQuery = rangeSumQuery(arr);
//        for(int i:rangeSumQuery){
//            System.out.print(i+" ");
//        }

//        int specialIndex = specialIndex(arr);
//        System.out.println(specialIndex);

        int equilibriumIndex = equilibriumIndex(arr);
        System.out.println(equilibriumIndex);



    }
}