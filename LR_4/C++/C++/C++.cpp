#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Worker {
private:
    string firstname;
    string rang;
    int money;

public:
    Worker(string firstnameInput, string rangInput, int moneyInput){
        firstname = firstnameInput;
        firstname = rangInput;
        firstname = moneyInput;
    }

    /*void setName(string firstnameInput) {
        firstname = firstnameInput;
    }

    void setRang(string rangInput) {
        firstname = rangInput;
    }

    void setMoney(int moneyInput) {
        firstname = moneyInput;
    }*/

    string getName() {
        return firstname;
    }

    string getRang() {
        return rang;
    }

    int getMoney() {
        return money;
    }

    void upMoney(vector<Worker> list) {
        for (int i = 0; i < list.size(); i++)
        {
            list[i].money = list[i].money * 1.15;
        }
    }

    void reversRang(vector<Worker> list) {
        for (int i = 0; i < list.size(); i++)
        {
            if (list[i].firstname[0] == 'I' && list[i].firstname[0] == 'v' && list[i].firstname[0] == 'a' && list[i].firstname[0] == 'n') {
                list[i].rang = "injener";
            }
        }
    }
};

int main()
{
    setlocale(LC_ALL, "");
    string firstnameInput, rangInput;
    int moneyInput, count;

    vector <Worker> list;

    cout << "how much people?" << endl;
    cin >> count;
    for (int i = 0; i < count; i++)
    {
        
        cout << "Input firstname: ";
        getline(cin, firstnameInput);
        /*people.setName(firstnameInput);*/
        cin.get();

        cout << "Input rang: ";
        getline(cin, rangInput);
        /*people.setRang(rangInput);*/
        cin.get();

        cout << "Input money: ";
        cin >> moneyInput;
        /*people.setMoney(moneyInput);*/

        Worker people(firstnameInput, rangInput, moneyInput);

        list.push_back(people);
    }

    for (int i = 0; i < count; i++)
    {
        cout << list[i].getName() << endl;
    }
    cout << "------" << endl;
    
    return 0;
}