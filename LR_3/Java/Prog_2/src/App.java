import java.lang.reflect.Array;
import java.util.*;

public class App {
    public static ArrayList inputData(){
        ArrayList list = new ArrayList<Integer>(); 
        Scanner inputNumber = new Scanner(System.in);
        for(int i = 0; i < 10; i++){
            int element = inputNumber.nextInt();
            list.add(element);
        }
        return list;
    }

    public static int minTemperature(ArrayList<Integer> list){
        int minElement = list.get(0);
        int minIndex = 0;

        for(int i = 0; i < list.size(); i++){
            if (list.get(i) < minElement){
                minElement = list.get(i);
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static ArrayList maxTemperature(ArrayList<Integer> list, int minIndex){
        ArrayList result = new ArrayList<Integer>();
        int maxElement = list.get(minIndex);
        int maxIndex = 0;

        for(int i = 0; i < 3; i++){
            for(int j = minIndex; j < list.size(); j++){
                if(list.get(j) > maxElement){
                    maxElement = list.get(j);
                    maxIndex = j;
                }
            }
            result.add(list.get(maxIndex));
            list.set(maxIndex, -99);
            maxElement = list.get(minIndex);
        }

        return result;
    }

    public static void printResult(ArrayList<Integer> result){
        for(int i = 0; i < result.size(); i++){
            System.out.printf(result.get(i) + "\t");
        }
    }
    public static void main(String[] args) throws Exception {
        ArrayList list = inputData();
        int minIndex = minTemperature(list);
        ArrayList result = maxTemperature(list, minIndex);
        printResult(result);
    }
}
