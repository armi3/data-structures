#include "stdio.h"
#include "functions.h"
int main()
{
    int n;
    printf("\n Enter n: ");
    scanf("%u", &n);
    int sum = mySumN(n);
    printf("\n The sum of the n first natural numbers is: %d", sum);
    return 0;
}
