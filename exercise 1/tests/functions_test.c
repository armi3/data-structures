/*
============================================================================
Name        : functions_test.c
Author      : Fernanda Gonzalez
Description : Simple example of a CUnit unit test.
============================================================================
Compile (OSX Mojave at tests/): 
gcc -std=c99 -o functions_test functions_test.c -lcunit -v
============================================================================
Commands for profiling with Valgrind (OSX Mojave at "exercise 1"/):
    1. docker build -t memory-test:0.1 .
    2. docker run -ti -v $PWD:/test memory-test:0.1 bash -c \
    "cd /test/; gcc -std=c99 -o tests/functions_test tests/functions_test.c \
    -lcunit -v  && valgrind --leak-check=full -v tests/functions_test"
*/

#include "../src/functions.c"
#include "CUnit/Basic.h"

void mySumN_test() {
   // Check if first param matches with second[2]
   CU_ASSERT_EQUAL(mySumN(0), 0);
   CU_ASSERT_EQUAL(mySumN(9), 45);
   CU_ASSERT_EQUAL(mySumN(46340), 1073720970); // int max limit is 2147483647
   return;
}

int main() {
   // Initialize the CUnit test registry
   if (CUE_SUCCESS != CU_initialize_registry())
      return CU_get_error();

   // Sets the basic run mode, CU_BRM_VERBOSE will show maximum output of run details
   // Other choices are: CU_BRM_SILENT and CU_BRM_NORMAL
   CU_basic_set_mode(CU_BRM_VERBOSE);

   CU_pSuite pSuite = NULL;
   
   // Add a suite to the registry
   pSuite = CU_add_suite("mySumN_test_suite", 0, 0);

   // Always check if add was successful
   if (NULL == pSuite) {
   CU_cleanup_registry();
   return CU_get_error();
   }
   
   // Add the test to the suite
   if (NULL == CU_add_test(pSuite,"mySumN_test",mySumN_test)) {
   CU_cleanup_registry();
   return CU_get_error();
   }

   // Run the tests and show the run summary
   CU_basic_run_tests();
   return CU_get_error();
}