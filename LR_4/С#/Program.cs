using System;
using System.IO;


class Worker
{
public enum PositionPost{
    DIRECTOR,
    STUDENT,
    INTERN,
    WORKER,
    NULL
}
private
    string firstname;
    string rang;
    double money;
    PositionPost post; 
    DateTime now;

    public void setName(string firstnameInput) {
        firstname = firstnameInput;
    }

    public void setRang(string rangInput) {
        rang = rangInput;
    }

    public void setMoney(double moneyInput) {
        money = moneyInput;
    }

    public void setPost(string reduction){
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

    public void setNow(DateTime time) {
        now = time;
    }

    public string getName() {
        return firstname;
    }

    public string getRang() {
        return rang;
    }

    public double getMoney() {
        return money;
    }

    public PositionPost getPost() {
        return post;
    }

    public DateTime getNow(){
        return now;
    }

    public static void upMoneyOnePeople(Worker people) {
        people.money = people.money * 1.15;
    }

    public static void reversRangOnePeople(Worker people) {
        if (people.getName()[0] == 'I' && people.getName()[1] == 'v' && people.getName()[2] == 'a' && people.getName()[3] == 'n') {
            people.rang = "injener";
        }
    }

    public static List<string> diskIn(StreamReader fin) {
        string N;
        List<string> check = new List<string>();
        while ((N = fin.ReadLine()) != null) {
            check.Add(N);
        }

        return check;
    }

    public static void diskOut(StreamWriter fout, Worker people) {
        fout.WriteLine(people.getName());
        fout.WriteLine(people.getRang());
        fout.WriteLine(people.getMoney() + "\n");
    }
};

class HelloWorld {
    public static void upMoney(List<Worker> list) {
        for (int i = 0; i < list.Count; i++)
        {
            Worker.upMoneyOnePeople(list[i]);
        }
    }

    public static void reversRang(List<Worker> list) {
        for (int i = 0; i < list.Count; i++)
        {
            Worker.reversRangOnePeople(list[i]);
        }
    }

    public static List<Worker> inputDataConsole(int Count) {
        List<Worker> list = new List<Worker>();

        for (int i = 0; i < Count; i++)
        {
            Worker people = new Worker();
            Console.Write("Input firstname: ");
            string firstnameInput = Console.ReadLine();
            people.setName(firstnameInput);

            Console.Write("Input rang: ");
            string  rangInput = Console.ReadLine();
            people.setRang(rangInput);

            Console.Write("Input money: ");
            double moneyInput = Convert.ToInt32(Console.ReadLine());
            people.setMoney(moneyInput);

            Console.Write("Input post (D, I, S, W): ");
            string  post = Console.ReadLine();
            people.setPost(post);

            DateTime DateTime = DateTime.Now;
            people.setNow(DateTime);

            list.Add(people);
        }

        return list;
    }

    public static List<Worker> inputDataFList(List<string> check) {
        List<Worker> list = new List<Worker>();

        for (int i = 0; i < check.Count; i += 4)
        {
            Worker people = new Worker();
            
            people.setName(check[i]);
            people.setRang(check[i+1]);
            people.setMoney(Convert.ToDouble(check[i+2]));

            list.Add(people);
        }

        return list;
    }
    static void Main() {
        Console.WriteLine("how much people?");
        int Count = Convert.ToInt32(Console.ReadLine());

        List<Worker> listConsole = inputDataConsole(Count);

        Console.WriteLine("------");

        for (int i = 0; i < Count; i++)
        {
            Console.WriteLine(listConsole[i].getMoney());
        }

        Console.WriteLine("------");

        upMoney(listConsole);

        for (int i = 0; i < Count; i++)
        {
            Console.WriteLine(listConsole[i].getMoney());
        }

        Console.WriteLine("------");

        reversRang(listConsole);

        for (int i = 0; i < Count; i++)
        {
            Console.WriteLine(listConsole[i].getRang());
        }

        // part 2
        List<Worker> listFile = null;
        try
        {
            using (StreamReader fin = new StreamReader("test.txt"))
            {
                List<string> check = Worker.diskIn(fin);
                listFile = inputDataFList(check);
                
                fin.Close();
            }
        }
        catch(IOException e)
        {
            Console.WriteLine($"The file could not be opened: '{e}'");
        } 

        Console.WriteLine("------");

        for(int i = 0; i < listFile.Count; i++){
            Console.WriteLine(listFile[i].getName());
        }

        try
        {
            using (StreamWriter fout = new StreamWriter("res.txt")){
                for(int i = 0; i < listFile.Count; i++){
                    Worker.diskOut(fout, listFile[i]);
                }
                
                fout.Close();
            }
            
        }
        catch(IOException e)
        {
            Console.WriteLine($"The file could not be opened: '{e}'");
        } 

        //Part 3 enum
        string search = Console.ReadLine();

        for(int i = 0; i < listConsole.Count; i++){
            if(search.Equals(listConsole[i].getPost().ToString())){
                Console.WriteLine(listConsole[i].getName());
            }
        }

        Console.WriteLine("------");

        var sorted = listConsole.OrderBy(ob => ob.getNow()).ToArray();

        for(int i = 0; i < listConsole.Count; i++){
            Console.WriteLine(listConsole[i].getNow());
        }
    }
}
