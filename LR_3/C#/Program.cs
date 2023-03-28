using System;
class HelloWorld {
    public static int minNumber(int x1, int x2, int x3){
        if(x1 <= x2 && x1 <= x2){
            return x1;
        }
        else if (x2 <= x1 && x2 <= x3) {
            return x2;
        }
        else if (x3 <= x1 && x3 <= x2){
            return x3;
        }
        return x1;
    }
    static void Main() {
        int x1 = Convert.ToInt32(Console.ReadLine());
        int x2 = Convert.ToInt32(Console.ReadLine());
        int x3 = Convert.ToInt32(Console.ReadLine());

        int result = minNumber(x1, x2, x3);

        Console.WriteLine(result);
    }
}