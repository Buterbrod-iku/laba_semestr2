#include <iostream>
#include <string>
#include <fstream>
#include <vector>
#include <sstream>

using namespace std;

int main()
{
    ifstream fin("C:/Users/setInterval/Desktop/C++/semestr_2/LR_7/C++/test.txt");
    string N;
    vector <string> check;
    for (string N; getline(fin, N); ) {
        check.push_back(N);
    }
    vector <string> words;

    for (int i = 0; i < check.size(); i += 2) {
        
        string word;
        stringstream ss(check[i]);
        while (ss >> word) {
            words.push_back(word);
        }
        string cash = words[0];
        words[0] = words[words.size() - 1];
        words[words.size() - 1] = cash;
        string resultWords = "";
        for (int j = 0; j < words.size(); j++) {
            resultWords += words[j] + " ";
        }
        cout << resultWords << endl;
        words.clear();
    }
}