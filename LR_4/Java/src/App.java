import java.util.*;
import java.io.*;

class Worker
{
public enum PositionPost{
    DIRECTOR,
    STUDENT,
    INTERN,
    WORKER,
    NULL;
}
private
    String firstname;
    String rang;
    double money;
    PositionPost post; 
    Calendar now;

public
    void setName(String firstnameInput) {
        firstname = firstnameInput;
    }

    void setRang(String rangInput) {
        rang = rangInput;
    }

    void setMoney(double moneyInput) {
        money = moneyInput;
    }

    void setPost(String reduction){
        switch(reduction){
            case("D"):
                post = PositionPost.DIRECTOR;
                break;
            case("I"):
                post = PositionPost.INTERN;
                break;
            case("S"):
                post = PositionPost.STUDENT;
                break;
            case("W"):
                post = PositionPost.WORKER;
                break;
            default:
                post = PositionPost.NULL;
                break;
        }
    }

    void setNow(Calendar time) {
        now = time;
    }

    String getName() {
        return firstname;
    }

    String getRang() {
        return rang;
    }

    double getMoney() {
        return money;
    }

    PositionPost getPost() {
        return post;
    }

    Calendar getNow(){
        return now;
    }

    public static void upMoneyOnePeople(Worker people) {
        people.money = people.money * 1.15;
    }

    public static void reversRangOnePeople(Worker people) {
        if (people.getName().charAt(0) == 'I' && people.getName().charAt(1) == 'v' && people.getName().charAt(2) == 'a' && people.getName().charAt(3) == 'n') {
            people.rang = "injener";
        }
    }

    public static ArrayList<String> diskIn(FileReader fin) throws FileNotFoundException {
        Scanner Reader = new Scanner(fin);
        ArrayList<String> check = new ArrayList<String>();
        while (Reader.hasNextLine()) {
            String data = Reader.nextLine();
            check.add(data);
        }

        return check;
    }

    public static void diskOut(FileWriter fout, Worker people) throws IOException {
        fout.write(people.getName() + "\n");
        fout.write(people.getRang() + "\n");
        fout.write(String.valueOf(people.getMoney()) + "\n");
        fout.append("\n");
    }
};

public class App {
    public static void upMoney(ArrayList<Worker> list) {
        for (int i = 0; i < list.size(); i++)
        {
            Worker.upMoneyOnePeople(list.get(i));
        }
    }

    public static void reversRang(ArrayList<Worker> list) {
        for (int i = 0; i < list.size(); i++)
        {
            Worker.reversRangOnePeople(list.get(i));
        }
    }

    public static ArrayList<Worker> inputDataConsole(int count) {
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);

        ArrayList<Worker> list = new ArrayList<Worker>();

        for (int i = 0; i < count; i++)
        {
            Worker people = new Worker();
            System.out.print("Input firstname: ");
            String firstnameInput = inputString.nextLine();
            people.setName(firstnameInput);

            System.out.print("Input rang: ");
            String  rangInput = inputString.nextLine();
            people.setRang(rangInput);

            System.out.print("Input money: ");
            double moneyInput = input.nextDouble();
            people.setMoney(moneyInput);

            System.out.print("Input post (D, I, S, W): ");
            String  post = inputString.nextLine();
            people.setPost(post);

            Calendar calendar = Calendar.getInstance();
            people.setNow(calendar);

            list.add(people);
        }

        return list;
    }

    public static ArrayList<Worker> inputDataFList(ArrayList<String> check) {
        ArrayList<Worker> list = new ArrayList<Worker>();

        for (int i = 0; i < check.size(); i += 4)
        {
            Worker people = new Worker();
            
            people.setName(check.get(i));
            people.setRang(check.get(i+1));
            people.setMoney(Integer.parseInt(check.get(i+2)));

            list.add(people);
        }

        return list;
    }
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("how much people?");
        int count = input.nextInt();

        ArrayList<Worker> listConsole = inputDataConsole(count);

        System.out.println("------");

        for (int i = 0; i < count; i++)
        {
            System.out.println(listConsole.get(i).getMoney());
        }

        System.out.println("------");

        upMoney(listConsole);

        for (int i = 0; i < count; i++)
        {
            System.out.println(listConsole.get(i).getMoney());
        }

        System.out.println("------");

        reversRang(listConsole);

        for (int i = 0; i < count; i++)
        {
            System.out.println(listConsole.get(i).getRang());
        }

        // part 2
        ArrayList<Worker> listFile = null;
        try(FileReader fin = new FileReader("test.txt"))
        {
            ArrayList<String> check = Worker.diskIn(fin);
            listFile = inputDataFList(check);
             
            fin.close();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 

        System.out.println("------");

        for(int i = 0; i < listFile.size(); i++){
            System.out.println(listFile.get(i).getName());
        }

        try(FileWriter fout = new FileWriter("res.txt", false))
        {
            for(int i = 0; i < listFile.size(); i++){
                Worker.diskOut(fout, listFile.get(i));
            }
             
            fout.flush();
            fout.close();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 

        //Part 3 enum
        Scanner searchScanner = new Scanner(System.in);
        String search = searchScanner.nextLine();

        for(int i = 0; i < listConsole.size(); i++){
            if(listConsole.get(i).getPost().name().equalsIgnoreCase(search)){
                System.out.println(listConsole.get(i).getName());
            }
        }

        System.out.println("------");

        Collections.sort(listConsole, Comparator.comparing(Worker::getNow));

        for(int i = 0; i < listConsole.size(); i++){
            System.out.println(listConsole.get(i).getNow().getTime());
        }
    }
}
