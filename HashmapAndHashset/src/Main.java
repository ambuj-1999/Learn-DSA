import java.util.*;
public class Main {
    public static HashMap<String , Integer> createHashMap(){
        HashMap<String , Integer> hm = new HashMap<>();
        hm.put("Punjab", 12);
        hm.put("Haryana", 10);
        hm.put("Rajasthan", 20);
        hm.put("UP", 50);
        hm.remove("Rajasthan");
        System.out.println(hm.values());
        for(String state: hm.keySet()){
            System.out.println(state + ": " + hm.get(state));

        }

        return hm;

    }
    public static HashMap<Integer, Integer> getFrequencyMap(int[] arr){
        int n = arr.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i<n; i++){
            if(hm.containsKey(arr[i])){
                hm.put(arr[i], hm.get(arr[i])+1);
            }
            else{
                hm.put(arr[i], 1);
            }
        }
        return hm;
    }
    public static int[] createArray(){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        return arr;
    }
    public static HashSet<Integer> commonElement(HashSet<Integer> hs1, HashSet<Integer> hs2){
        HashSet<Integer> hs = new HashSet<>();
        for(int i:hs1){
            if(hs2.contains(i)) hs.add(i);
        }
        return hs;
    }
    public static HashSet<Integer> convertArrayToHashSet(int[] arr){
        int n = arr.length;
        HashSet<Integer> hs = new HashSet<>();
        for (int j : arr) {
            hs.add(j);
        }
        return hs;
    }
    public static void createHashSet(){
        HashSet<Integer> hs = new HashSet<Integer>();
        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(1);
        hs.add(3);
        hs.remove(3);
        hs.add(10);
        hs.add(20);

        System.out.println(hs);
        for(int i : hs){
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
//        createHashSet()
        int[] arr = createArray();
//        HashSet<Integer> hs = convertArrayToHashSet(arr);
//        System.out.println(hs);
//        int[] arr1 = createArray();
//        int[] arr2 = createArray();
//        HashSet<Integer> hs1 = convertArrayToHashSet(arr1);
//        HashSet<Integer> hs2 = convertArrayToHashSet(arr2);
//        HashSet<Integer> hs = commonElement(hs1,hs2);
//        System.out.println(hs);

//        System.out.println(createHashMap());
        HashMap<Integer, Integer> hm = getFrequencyMap(arr);
        System.out.println(hm);


    }
}