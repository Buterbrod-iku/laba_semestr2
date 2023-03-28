#include <iostream>

using namespace std;

int main()
{
    setlocale(LC_ALL, "");
    int a, b, c, min, max;
    cout << "Введите 3 числа" << endl;
    cin >> a;
    cin >> b;
    cin >> c;
    if (a > b && a > c) {
        max = a;
        if (b > c) {
            min = c;
        }
        else {
            min = b;
        }
    }
    else if (b > a && b > c) {
        max = b;
        if (a > c) {
            min = c;
        }
        else {
            min = a;
        }
    }
    else {
        max = c;
        if (b > a) {
            min = a;
        }
        else {
            min = b;
        }
    }
    cout << min + max;
    return 0;
}