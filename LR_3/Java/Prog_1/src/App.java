import java.util.*;

public class App {
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
    public static void main(String[] args) throws Exception {
        Scanner inputNumber = new Scanner(System.in);
        int x1 = Integer.parseInt(inputNumber.nextLine());
        int x2 = Integer.parseInt(inputNumber.nextLine());
        int x3 = Integer.parseInt(inputNumber.nextLine());

        int result = minNumber(x1, x2, x3);

        System.out.println(result);
    }
}
