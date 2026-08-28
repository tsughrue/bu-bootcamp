#include <stdio.h>

void swap(int *a, int *b){
    int temp = *a;
    *a = *b;
    *b = temp;
}

void broken_swap(int a, int b){
    int temp = a;
    a = b;
    b = temp;
}


int main(){
    int x = 10;
    int y = 20;

    printf("Before swap: x = %d, y = %d\n", x, y);

    swap(&x, &y);
    printf("After swap: x = %d, y = %d\n", x, y);

    //This remains the same and doesn't swap becasue if you are just passing and swapping the values
    //then copies are sent to the function, not addresses
    broken_swap(x, y);
    printf("After broken swap: x = %d, y = %d\n", x, y);

    return 0;
}