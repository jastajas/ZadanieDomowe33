import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;

public class NumberReader {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("numbers.csv");
        BufferedReader bfr = new BufferedReader(fr);

        String tempNum = bfr.readLine();
        String[] numbersArr = tempNum.split(";");
        TreeMap<Integer, Integer> numbersMap1 = new TreeMap<>();
        TreeMap<Integer, Integer> numbersMap2 = new TreeMap<>();


        for (int i = 0; i < numbersArr.length; i++) {
            if (!numbersMap2.containsKey(Integer.valueOf(numbersArr[i]))){
                numbersMap2.put(Integer.valueOf(numbersArr[i]), 1);
            } else {
                int newVal = numbersMap2.get(Integer.valueOf(numbersArr[i]));
                newVal++;
                numbersMap2.replace(Integer.valueOf(numbersArr[i]),newVal);
            }
        }

        for (int i = 0; i < numbersArr.length; i++) {
            if(!numbersMap1.containsKey(Integer.valueOf(numbersArr[i]))){
                int r = 0;
                for (String num : numbersArr) {
                    if (num.equals(numbersArr[i]))
                        r++;
                }
                numbersMap1.put(Integer.valueOf(numbersArr[i]),r);
            }
        }

        Set<Integer> keySet1 = numbersMap1.keySet();

        for (Integer integer : keySet1) {
            System.out.println(integer + " - liczba wystąpień: " + numbersMap1.get(integer));
        }
        System.out.println();

        Set<Integer> keySet = numbersMap2.keySet();

        for (Integer integer : keySet) {
            System.out.println(integer + " - liczba wystąpień: " + numbersMap2.get(integer));
        }


    }
}
