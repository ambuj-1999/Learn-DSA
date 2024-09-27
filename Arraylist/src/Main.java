import java.util.*;

public class Main {
    public static ArrayList<ArrayList<Integer>> TwoDArraylist(){
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        //System.out.println(arr);
        ArrayList<Integer> row0 = new ArrayList<>();
        row0.add(1);
        row0.add(2);
        arr.add(row0);
        //System.out.println(arr);

        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(3);
        arr.add(row1);
        //System.out.println(arr);
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(1);
        row2.add(2);
        row2.add(3);
        row2.add(4);
        arr.add(row2);
        //System.out.println(arr);

//        System.out.println(arr.size());
//        System.out.println(arr.get(0).size());
//        System.out.println(arr.get(1).size());
//        System.out.println(arr.get(2).size());

        //System.out.println(arr.get(0).get(0));

        arr.set(0, row2);
        //System.out.println(arr);

        arr.remove(arr.size()-1);
        //System.out.println(arr);

        arr.get(0).set(2,8);
        //System.out.println(arr);

        arr.add(row0);

        return arr;




    }
    public static void lineByLine(ArrayList<ArrayList<Integer>> arr){
        int n = arr.size();
        for(int i=0; i<n; i++){
            int rowSize = arr.get(i).size();
            for(int j=0; j<rowSize; j++){
                System.out.print(arr.get(i).get(j)+" ");
            }
            System.out.println();
        }

    }
    public static void basicOperations(){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        System.out.println(arr);
        System.out.println(arr.size());
        arr.add(0);
        arr.add(-5);
        arr.add(1);
        System.out.println(arr);
        System.out.println(arr.get(1));
        arr.remove(1);
        System.out.println(arr);
        arr.set(1,8);
        System.out.println(arr);
    }
    public static ArrayList<Integer> readArraylist(){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0; i<n; i++){
            arr.add(0, scn.nextInt());
        }
        return arr;

    }
    public static ArrayList<Integer> getMultiplesOf5Or7(ArrayList<Integer> arr){
        int n = arr.size();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i<n; i++){
            if(arr.get(i)%5==0 || arr.get(i)%7==0){
                result.add(arr.get(i));
            }
        }
        return result;
    }
    public static ArrayList<Integer> printBmMultiplesOfA(int a,int b){
        ArrayList<Integer> res  = new ArrayList<Integer>();
        for(int cnt = 1; cnt <= b; cnt++){
            res.add(a*cnt);
        }
        return res;
    }
    public static ArrayList<ArrayList<Integer>> printStairCase(){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<ArrayList<Integer>> x = new ArrayList<ArrayList<Integer>>();

        for(int i=1; i<=n; i++){
            ArrayList<Integer> res = new ArrayList<>();

            for(int j=1; j<=i; j++){
                res.add(j);
            }
            x.add(res);
        }
        return x;
    }
    public static void main(String[] args) {
        //Scanner scn = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> arr = TwoDArraylist();
        //ArrayList<Integer> res = getMultiplesOf5Or7(arr);
        //System.out.println(getMultiplesOf5Or7(arr));
        lineByLine(arr);

//        int a = scn.nextInt();
//        int b = scn.nextInt();
//        ArrayList<Integer> res = printBmMultiplesOfA(a,b);
//        System.out.println(res);

        //ArrayList<ArrayList<Integer>> arr = TwoDArraylist();
        ArrayList<ArrayList<Integer>> staircase = printStairCase();

        int x = staircase.size();

        for(int i=0; i<x; i++){
            System.out.println(staircase.get(i));
        }






    }
}