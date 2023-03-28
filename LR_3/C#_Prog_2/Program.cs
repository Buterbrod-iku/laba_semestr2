using System;
class HelloWorld {
    public static List<int> inputData(){
        List<int> list = new List<int>(); 
        for(int i = 0; i < 10; i++){
            int element = Convert.ToInt32(Console.ReadLine());
            list.Add(element);
        }
        return list;
    }

    public static int minTemperature(List<int> list){
        int minElement = list[0];
        int minIndex = 0;

        for(int i = 0; i < list.Count; i++){
            if (list[i] < minElement){
                minElement = list[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static List<int> maxTemperature(List<int> list, int minIndex){
        List<int> result = new List<int>();
        int maxElement = list[minIndex];
        int maxIndex = 0;

        for(int i = 0; i < 3; i++){
            for(int j = minIndex; j < list.Count; j++){
                if(list[j] > maxElement){
                    maxElement = list[j];
                    maxIndex = j;
                }
            }
            result.Add(list[maxIndex]);
            list[maxIndex] = -99;
            maxElement = list[minIndex];
        }

        return result;
    }

    public static void printResult(List<int> result){
        for(int i = 0; i < result.Count; i++){
            Console.Write(result[i] + "\t");
        }
    }
    static void Main() {
        List<int> list = inputData();
        int minIndex = minTemperature(list);
        List<int> result = maxTemperature(list, minIndex);
        printResult(result);
    }
}