#include <iostream>

using namespace std;

int main()
{
    setlocale(LC_ALL, "");
    int N;
    float X, Z;
    cout << "Введите кол-во р. на вклад" << endl;
    cin >> X;
    cout << "Введите кол-во лет" << endl;
    cin >> N;
    cout << "Введите процент" << endl;
    cin >> Z;
    for (int i = 0; i < N; i++)
    {
        X = X * (Z / 100 + 1);
    }
    cout << X; 
}