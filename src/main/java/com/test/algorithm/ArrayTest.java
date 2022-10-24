package com.test.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ArrayTest {
  public static void main(String[] args) {
  	List<Integer> list = new ArrayList<>();
  	list.toArray(new Integer[]{1});
  	String s = "A man, a plan, a canal: Panamaa6688AAUJa";
    char[] chars = s.toLowerCase().toCharArray();
    System.out.println('k'<122);
        System.out.println(Arrays.toString(chars));
    //    int A[] = {3, 1, 2, 4};
    //    System.out.println(Arrays.toString(sortArrayByParityII(A)));
    //        System.out.println(countCharacters(new
    //        String[]{"dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin","ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb","ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl","boygirdlggnh","xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx","nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop","hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx","juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr","lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo","oxgaskztzroxuntiwlfyufddl","tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp","qnagrpfzlyrouolqquytwnwnsqnmuzphne","eeilfdaookieawrrbvtnqfzcricvhpiv","sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz","yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue","hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv","cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo","teyygdmmyadppuopvqdodaczob","qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs","qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"}, "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp"));
    //    System.out
    //        .println(countCharacters(new String[]{"hello", "world", "leetcode"},
    //        "welldonehoneyr"));
    //    minimumAbsDifference(new int[]{4, 2, 1, 3});

    //    int[] A = {1, 2, 3, 4};
    //    int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
    //    sumEvenAfterQueries(A, queries);

    //    int[] A = {8,4,5,0,0,0,0,7};
    //    duplicateZeros(A);

    //    int[] arr1 = {2, 21, 43, 38, 0, 42, 33, 7, 24, 13, 12, 27, 12, 24, 5, 23, 29, 48, 30, 31};
//        int[] arr2 = {2, 42, 38, 0, 43, 21};
//        List<Integer> al = new LinkedList<Integer>();
//    ((LinkedList<Integer>) al).addFirst(1);

    //    System.out.println(Arrays.toString(arr1));
    //    arr1 = relativeSortArray(arr1, arr2);
    //    System.out.println(Arrays.toString(arr1));
    //    Arrays.asList(arr1);

    //    findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2});
    //    solution(1,2,3,8);
//    permutation(new int[]{1, 2,3,4});
//    String a = "abb";
//    a.toCharArray();
//    System.out.print(a.indexOf('b'));
//    System.out.print(a.lastIndexOf('b'));
//    prefixesDivBy5(new int[]{1,0,1,0,0,0,0,0,0,0,0,1,1,1,0,0,1,0,1,1,1,1,1,1,0,0,0,1,0,1,1,1,1,0,1,1,0,1,0,1,0,0,0,1,0,0,0,0,0,1,0,0,1,1,0,0,1,1,1});
  }
  boolean isLowercaseLetter(char a){
    return a>=97 && a<=122;
  }

  public static int countSquares(int[][] matrix) {
    int col = matrix[0].length;
    int row = matrix.length;
    // System.out.println(col +" "+ row);
    int step = 2, res=0;
    int maxStep =  Math.min(row, col);
    int [][] temp = new int[row][col];

    for(int i= 0; i< row; i++){
      for(int j=0; j< col; j++){
        temp[i][j] = matrix[i][j];
        if(temp[i][j] == 1) res++;
      }
    }

    print(temp,row, col);
    // System.out.println(res +" maxStep= "+maxStep);
    while(step <= maxStep ){
      for(int i= 0; i< row-1; i++){
        for(int j=0; j< col-1; j++){

          // System.out.print(temp[i][j]);
          // System.out.println(" "+temp[i][j+1]);
          // System.out.print(temp[i+1][j]);
          // System.out.print(" "+temp[i+1][j+1]);
          if(temp[i][j] == 1 && temp[i][j+1] == 1 && temp[i+1][j] == 1 && temp[i+1][j+1] ==1) {
            temp[i][j] = 1;
            res++;
            // System.out.println(" "+res +" stp= "+step);
          }
          else{
            temp[i][j] =0;
          }
          // System.out.println("  = "+temp[i][j]);

        }

      }
      if(step == 1){
        for(int k= 0; k< row; k++){
          temp[k][col-1]=0;
        }
        for(int k= 0; k< col; k++){
          temp[row-1][k]=0;
        }
      }


      // print(temp,row, col);
      step++;
      // System.out.println(" stp= "+step+" ------");

    }


    return res;
  }

  static void  print(int [][] temp, int row, int col ){
    for(int i= 0; i< row; i++){
      for(int j=0; j< col; j++){
        if (j== (col - 1)) {
          System.out.println(temp[i][j]+"\t");
          continue;
        }
        System.out.print(temp[i][j] +"\t");
      }
    }

  }
  public int rob(int[] nums) {
    if(nums.length == 0) return 0;
    else if(nums.length == 1) return nums[0];
    else if(nums.length == 2) return Math.max(nums[0], nums[1]);

    else{
      nums[1] = Math.max(nums[0], nums[1]);
      for(int i=2; i<nums.length;i++){

        System.out.println( i-2 + " : "+nums[i-2]);
        System.out.println( i-1 + " : "+ nums[i-1]);
        System.out.println( i + " : "+nums[i]);
        nums[i] = Math.max(nums[i-2]+nums[i],nums[i-1]);
        System.out.println( i + " : "+nums[i] +"  ------");
      }
      System.out.println( "  ------");
      for(int i=2; i<nums.length;i++){

        System.out.println( i + " : "+nums[i] +"  ------");
      }
      return Math.max(nums[nums.length-1] + nums[nums.length-3], nums[nums.length-2]) ;
    }


  }
  public static List<Boolean> prefixesDivBy5(int[] A) {
    List<Boolean> res = new ArrayList<>();
    for(int i=0; i<A.length;i++){
      double temp = 0;
      for(int j=0; j<= i; j++){
        System.out.print("  temp= "+temp);
        if(A[j] == 1){
          temp = (double) (temp+Math.pow(2,(i-j)));
          System.out.print("   j= "+j+"  A[j]="+A[j]+"<<"+ (i-j)+"="+(A[j]<<(i-j)));
        }
        System.out.print("   thentemp= "+temp+"  ");
      }
      System.out.print("\ni="+ i+"  fin temp= "+temp+"  ");
      if(temp %5 == 0){
        res.add(true);
        System.out.print("  true  \n");
      }else{
        res.add(false);
        System.out.print("  false\n");
      }
    }
    return res;
  }
  public static void permutation(int[] a) {
    List<List<Integer>> list = new ArrayList<>();
    permutation(a, 0, a.length, list);
    for (List<Integer> l : list) {
      System.out.println(Arrays.toString(l.toArray()));
    }



  }

  public static int solution(int A, int B, int C, int D) {
    // write your code in Java SE 8
    int res = 0;
    if (A == B && C == D && A == 0 & D == 0) {
      return 1;
    }
    int[] temp = new int[5];
    temp[0] = A;
    temp[1] = B;
    temp[2] = C;
    temp[3] = D;
    //
    permutation(temp, 0, temp.length - 1);

    //    List<Integer> templist = new ArrayList<>();
    //    templist.add(A);
    //    templist.add(B);
    //    templist.add(C);
    //    templist.add(D);
    //    List<Integer> hour= new ArrayList<>();
    //    List<Integer> min= new ArrayList<>();

    //    int hl=-1,hr=-1,ml=-1,mr=-1;
    //    for(int i=0; i<4;i++){
    //      for(int j=0;j<4; j++){
    //        if(i!=j){
    //          int sum =temp[i]*10+temp[j];
    //          if(sum< 24){
    //             for(int m=0; m<4; m++){
    //               for(int n= 0; n<4; n++){
    //
    //               }
    //             }
    //          }
    //
    //
    //        }
    //      }
    //    }
    //
    //
    //
    //    for(int h: hour){
    //      System.out.println(" h=" + h);
    //      for(int m: min){
    //        System.out.println("    m=" + m);
    //        int a=h/10;
    //        int b=h%10;
    //        int c=m/10;
    //        int d=m%10;
    //        if(a+b+c+d == A+B+C+D){
    //          res++;
    //        }
    //
    //      }
    //    }
    //    System.out.println(res);
    return temp[4];
  }

  static void permutation(int[] arr, int start, int end, List<List<Integer>> res) {
    if (start == end) {
      List<Integer> list = new ArrayList<>();
      for (int i : arr) {
        list.add(i);
      }
//      System.out.println(list.toString());
      res.add(list);

    }

    for (int i = start; i < end; i++) {
      swap(arr, i, start);
      permutation(arr, start + 1, end,res);
      swap(arr, start, i);
    }
  }

  static void permutation(int[] arr, int start, int end) {
    if (start == end) {
      if (arr[0] * 10 + arr[1] < 24 && arr[2] * 10 + arr[3] < 60) {
        arr[4]++;
        System.out.print(arr[4]);
      }
    }

    for (int i = start; i < end; i++) {
      swap(arr, i, start);
      permutation(arr, start + 1, end);
      swap(arr, start, i);
    }
  }

  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private static class DescComparator implements Comparator<Integer> {
    TreeMap<Integer, Integer> map = new TreeMap<>();

    public DescComparator(TreeMap<Integer, Integer> tempMap) {
      this.map.putAll(tempMap);
    }

    @Override
    public int compare(Integer o1, Integer o2) {
      // System.out.print( (int)o2+ " o2= "+(Integer) map.get(o2));
      // System.out.println(" "+ (int)o1+" o1= "+ (Integer) map.get(o1));
      return map.get(o1) >= map.get(o2) ? 1 : -1;
    }
  }

  public static int findShortestSubArray(int[] nums) {

    TreeMap<Integer, Integer> map = countFrequency(nums);
    printMap(map);
    System.out.println();
    DescComparator dc = new DescComparator(map);
    TreeMap<Integer, Integer> newMap = new TreeMap<Integer, Integer>(dc);
    newMap.putAll(map);
    int firstKey = newMap.firstKey();
    System.out.println(" firstKey:" + firstKey + " " + newMap.get(firstKey));
    printMap(newMap);

    Map.Entry entry = newMap.firstEntry();
    System.out.println(entry.getKey() + ":" + entry.getValue());

    Set set = newMap.entrySet();
    Iterator i = set.iterator();

    int min = 500000;

    //         int temp = 0;
    //         List<Integer> list = new ArrayList<Integer>();

    //         while (i.hasNext()) {
    //             Map.Entry me = (Map.Entry)i.next();

    //             int key = (int) me.getKey();
    //             int value = (int) me.getValue();
    //             System.out.print(" key:"+ key);
    //             System.out.println(" value:"+ value);

    //             if(key == firstKey){
    //                 temp = value;
    //                 System.out.print(" temp:"+ temp);
    //                 System.out.print(" key:"+ key);
    //                 System.out.println(" value:"+ value);
    //             }

    //             if(list.size() == 0){
    //                   System.out.println(" --"+ key);
    //                 list.add(key);
    //             }else if(temp == (int)me.getValue() ){
    //                   System.out.println(key);
    //                     list.add(key);
    //             }else{
    //                 break;
    //             }
    //         }

    //         System.out.println(" list "+" size:"+list.size()+ list.toString());

    //         for(int num : list){
    //             int l=-1,h=-1;
    //             for(int j=0; j< nums.length; j++){
    //                 System.out.println(" num="+ num+" nums[j]="+ nums[j]);
    //                 if(nums[j] == num ){
    //                     if(l==-1){
    //                         l =  j;
    //                     }else{
    //                         h = j;
    //                     }
    //                 }
    //                 System.out.println(" l="+ l+" h="+ h +" min="+ min);
    //                 if(h > -1){
    //                       min = Math.min(h-l+1, min);
    //                 }

    //             }
    //         }

    return min;
  }

  static TreeMap countFrequency(int[] nums) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < nums.length; i++) {

      if (map.containsKey(nums[i])) {
        // System.out.println( nums[i]+ " a");
        map.put(nums[i], map.get(nums[i]) + 1);
      } else {
        // System.out.println( nums[i]+" b");
        map.put(nums[i], 1);
      }
    }
    return map;
  }

  public static int[] relativeSortArray(int[] arr1, int[] arr2) {
    System.out.println(arr1.length);
    int[] temp = new int[arr1.length];
    int k = 0;
    for (int i = 0; i < arr2.length; i++) {
      for (int j = 0; j < arr1.length; j++) {
        if (arr1[j] == arr2[i]) {
          temp[k] = arr1[j];
          System.out.println(" temp[k]=" + temp[k] + " k=" + k);
          k++;
          arr1[j] = -1;
        }
      }
    }
    System.out.println("\n k=" + k);
    Arrays.sort(arr1);
    System.out.println(arr1.length + "  " + Arrays.toString(arr1));
    for (int i = 0; i < arr1.length; i++) {
      System.out.println("i=" + i);
      if (arr1[i] != -1 && k < arr1.length) {
        temp[k] = arr1[i];
        System.out.println(" temp[k]=" + temp[k] + " k=" + k);
        k++;
      }
    }

    arr1 = temp;
    temp = null;
    return arr1;
  }

  public static void duplicateZeros(int[] arr) {

    int count = 0;

    for (int i : arr) {
      if (i == 0) {
        count++;
      }
    }

    int high = arr.length + count - 1;

    for (int i = arr.length - 1; i > -1; i--) {
      System.out.println(arr[i] + "  high= " + high);
      if (high > arr.length - 1) {
        if (arr[i] == 0) {
          high--;
          if (high <= arr.length - 1) {
            System.out.println(" high: " + high + " arr[high]: " + arr[high]);
            arr[high--] = arr[i];
          } else {
            high--;
          }
        } else {
          high--;
        }
      } else {
        if (arr[i] == 0) {
          arr[high] = arr[i];
          System.out.print(" high: " + high + " arr[high]: " + arr[high]);
          high--;
          arr[high] = arr[i];
          System.out.println(" high: " + high + " arr[high]: " + arr[high]);
          high--;
        } else {
          arr[high] = arr[i];
          System.out.println(" high: " + high + " arr[high]: " + arr[high]);
          high--;
        }
      }
    }

    System.out.println(Arrays.toString(arr));
  }

  public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
    int res[] = new int[A.length];
    int sum = 0;
    for (int j = 0; j < A.length; j++) {
      if (A[j] % 2 == 0) {
        sum += A[j];
      }
    }
    for (int i = 0; i < queries.length; i++) {
      res[i] = sum;
      int temp = A[queries[i][1]];
      if (temp % 2 == 0) {
        res[i] -= temp;
      }

      System.out.print(
          " i= " + i + " queries[i][1]= " + queries[i][1] + " queries[i][0] = " + queries[i][0]
              + " temp =" + A[queries[i][1]]);
      A[queries[i][1]] += queries[i][0];
      System.out.print("  A[queries[i][1]]= " + A[queries[i][1]]);

      if (A[queries[i][1]] % 2 == 0) {
        res[i] += A[queries[i][1]];
      }
      System.out.print(" res[i]: " + res[i]);
      System.out.println();
    }

    return res;
  }

  public static List<List<Integer>> minimumAbsDifference(int[] arr) {
    Arrays.sort(arr);
    TreeMap<Integer, List<List<Integer>>> map = new TreeMap<>();
    for (int i = 0; i < arr.length - 1; i++) {
      List<Integer> list = new ArrayList<Integer>();
      list.add(arr[i]);
      list.add(arr[i + 1]);
      if (map.containsKey(arr[i + 1] - arr[i])) {
        List<List<Integer>> res = map.get(arr[i + 1] - arr[i]);
        res.add(list);
        System.out.println(" contain: " + res.toString());
        map.put(arr[i + 1] - arr[i], res);
      } else {
        List<List<Integer>> res = new ArrayList<>();
        res.add(list);
        System.out.println(" first: " + res.toString());
        map.put(arr[i + 1] - arr[i], res);
      }
    }
    return map.get(map.firstKey());
  }

  public List<List<Integer>> minimumAbsDifference2(int[] arr) {
    Arrays.sort(arr);

    int min = Integer.MAX_VALUE;
    List<List<Integer>> res = new ArrayList<>();

    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i + 1] - arr[i] < min) {
        min = arr[i + 1] - arr[i];
      }
    }
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i + 1] - arr[i] == min) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(arr[i]);
        list.add(arr[i + 1]);
        res.add(list);
      }
    }

    return res;
  }

  static void printMap(Map map) {
    Set set = map.entrySet();
    Iterator i = set.iterator();

    while (i.hasNext()) {
      Map.Entry me = (Map.Entry) i.next();

      int key = (int) me.getKey();
      int value = (int) me.getValue();
      System.out.print(" key:" + key);
      System.out.println(" value:" + value);
    }
  }

  public static int countCharacters(String[] words, String chars) {

    int res = 0;
    int temp = 0;
    Set set = chars.chars().mapToObj(i -> (char) i).collect(Collectors.toSet());
    System.out.println(set.toString());
    for (String word : words) {
      Set s = word.chars().mapToObj(i -> (char) i).collect(Collectors.toSet());
      if (set.containsAll(s)) {
        res += word.length();
      }
    }

    return res;
  }

  public static int[] sortArrayByParityII(int[] A) {
    int right;
    for (int i = 0; i < A.length - 1; i++) {
      if (i % 2 == 0 && A[i] % 2 != 0) {
        right = i + 1;
        System.out
            .println(" right = " + right + " A[right]= " + A[right] + (right < (A.length - 1)));
        while (right < A.length) {
          if (right % 2 != 0 && A[right] % 2 == 0) {
            System.out.println(" before A[right]= " + A[right]);
            int temp = A[i];
            A[i] = A[right];
            A[right] = temp;

            System.out.println(" swap A[right]= " + A[right]);
            break;
          } else {
            right += 2;
          }
        }
      }
      if (i % 2 != 0 && A[i] % 2 == 0) {
        right = i + 1;
        while (right < A.length) {
          if (right % 2 == 0 && A[right] % 2 != 0) {
            int temp = A[i];
            A[i] = A[right];
            A[right] = temp;
            break;
          } else {
            right += 2;
          }
        }
      }
    }
    return A;
  }
}
