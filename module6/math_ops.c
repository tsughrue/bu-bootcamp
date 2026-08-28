#include <stdio.h>

void print_math(int a, int b){
    int sum = a + b;
    int prd = a * b;

    printf("Sum: %d\n", sum);
    printf("Product: %d\n", prd);
} 

int main(){
    int a;
    int b;

    printf("Enter the first integer: ");
    scanf("%d", &a);

    printf("Enter the second integer: ");
    scanf("%d", &b);

    print_math(a,b);

    return 0;
}

