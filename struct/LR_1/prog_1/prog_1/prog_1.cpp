#include <iostream>
#include <vector>

using namespace std;
vector<int> sort(vector<int> vect, int count) {
    int min, cash;
    for (int i = 0; i < count - 1; i++)
    {
        min = i;
        for (int j = i + 1; j < count; j++)
        {
            if (vect[j] < vect[min]) {
                min = j;
            }
        }
        cash = vect[i];
        vect[i] = vect[min];
        vect[min] = cash;
    }
    return vect;
}

int print(vector<int> vect) {
    for (int i = 0; i < vect.size(); i++)
    {
        cout << vect[i] << ",";
    }
    cout << endl;
    return 0;
}

int main()
{
    int x1, x2, n;
    vector <int> K;
    vector <int> A;
    vector <int> M;
    cin >> x1;
    cin >> x2;
    cout << "<= 450" << endl;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int rand_number = 100 + rand() % (200 - 100 + 1);
        if (rand_number <= x1) {
            A.push_back(rand_number);
        }
        else if (rand_number >= x2) {
            M.push_back(rand_number);
        }
        else {
            K.push_back(rand_number);
        }
    }
    A = sort(A, A.size());
    M = sort(M, M.size());
    K = sort(K, K.size());
    print(K);
    cout << "---------------------------" << endl;
    print(A);
    cout << "---------------------------" << endl;
    print(M);
    return 0;
}