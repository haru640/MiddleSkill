import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class test1 {
    public static void main(String[] args) {
        // 改行
        System.out.println("問１");
        // 問１のメソッドを呼び出して出力してください（引数５と１０）
        int sumResult = sumTwoIntegers(5, 10);
        System.out.println(sumResult);
        
        // 改行
        System.out.println("問２");
        // 問２のメソッドを呼び出して出力してください（引数"しんぶんし"）
        boolean isPalindrome = isPalindrome("しんぶんし");
        System.out.println(isPalindrome);
        
        // 改行
        System.out.println("問３");
        // 問3のメソッドを呼び出して出力してください（引数,配列[5,3,1,9,4,8]）
        Integer[] i = {5, 3, 1, 9, 4, 8};
        Integer[] sortedArray = sortDescending(i);
        System.out.println( Arrays.toString(sortedArray));
        
        // 改行
        System.out.println("問４");
        // 問4のメソッドを呼び出して出力してください（引数,配列[5,3,1,9,4,8]）
        int[] k = {5, 3, 1, 9, 4, 8};
        int minIndex = findMinIndex(k);
        System.out.println(minIndex);
    }

    // 問題1: 2つの整数を受け取り、それらの和を返すメソッド
    public static int sumTwoIntegers(int a, int b) {
        return a + b;
    }

    // 問題2: 文字列を受け取り、その文字列が回文であるかどうかを返すメソッド
    public static boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    // 問題3: 整数の配列を受け取り、その配列の要素を降順にソートするメソッド
    public static Integer[] sortDescending(Integer[] array) {
        List<Integer> list = Arrays.asList(array);
        list.sort(Collections.reverseOrder());
        return list.toArray(new Integer[0]);
    }

    // 問題4: 整数の配列を受け取り、その配列の中で最小値を持つ要素のインデックスを返すメソッド
    public static int findMinIndex(int[] array) {
        if (array.length == 0) {
            return -1;
        }
        
        OptionalInt min = Arrays.stream(array).min();
        if (!min.isPresent()) {
            return -1;
        }

        return IntStream.range(0, array.length)
                        .filter(i -> array[i] == min.getAsInt())
                        .findFirst()
                        .orElse(-1);
    }
}