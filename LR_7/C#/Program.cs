using System;
class HelloWorld {
  static void Main() {
    try
        {
            using (StreamReader fin = new StreamReader("test.txt")){
                string N;
                List<string> check = new List<string>();
                while ((N = fin.ReadLine()) != null) {
                    check.Add(N);
                }

                for(int i = 0; i < check.Count; i += 2){
                    string[] words = check[i].Split(" ");
                    string cash = words[0];
                    words[0] = words[words.Length-1];
                    words[words.Length-1] = cash;
                    String resultWords = "";
                    for (int j = 0; j < words.Length; j++) {
                        resultWords += words[j] + " ";
                    }
                    Console.WriteLine(resultWords);
                }
            }
        }
        catch(IOException e)
        {
            Console.WriteLine($"The file could not be opened: '{e}'");
        } 
  }
}