/*
============================================================================
Name        : app.c
Author      : Fernanda Gonzalez
Description : Algorithm to find the sum of the first N natural numbers.
============================================================================
Compile (OSX Mojave in src/): cc -std=c99 -o app app.c functions.c
============================================================================
Instructions for memory profiling with Valgrind in OSX Mojave:
    1. cd into "exercise 1" directory
    2. docker build -t memory-test:0.1 .
    3. docker run -ti -v $PWD:/test memory-test:0.1 bash -c 
    "cd /test/; gcc -std=c99 -o src/app src/app.c src/functions.c -g 
    && valgrind --leak-check=full -v src/app"
============================================================================
*/

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