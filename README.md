# data-structures
Course exercises in different languages about data structures, CI and testing.

## exercise 1
- Algorithm to find the sum of the first N natural numbers.
- Code in C
- Demo: https://youtu.be/8mKBWEocZ48
- **Unit testing** with dockerized CUnit
- **Profiling** with dockerized Valgrind:
  - Memory profiling with Memcheck tool
  - Heap, allocation tree and stack profiling with Massif tool
  - Call profiling with Callgrind tool
  
### walkthrough
Get the program compiled and running:
```
git clone https://github.com/armi3/data-structures.git; \
cd exercise\ 1/src && cc -std=c99 -o app app.c functions.c && ./app
```

Build Ubuntu 16 based container with CUnit and Valgrind:
```
cd .. && docker build -t memory-test:0.1 .
```

Test the program's methods with dockerized CUnit:
```
docker run -ti -v $PWD:/test memory-test:0.1 bash -c \
"cd /test/; gcc -std=c99 -o tests/functions_test tests/functions_test.c -lcunit -v; \
tests/functions_test"
```

##### Profile program with dockerized Valgrind
Heap, allocation tree and stack profiling:
```
docker run -ti -v $PWD:/test memory-test:0.1 bash -c \
"cd /test/; gcc -std=c99 -o src/app src/app.c src/functions.c -g; \
valgrind --tool=massif --stacks=yes --massif-out-file=profiling/massif_app src/app; \
ms_print profiling/massif_app"
```
Memory profiling:
```
docker run -ti -v $PWD:/test memory-test:0.1 bash -c \
"cd /test/; gcc -std=c99 -o src/app src/app.c src/functions.c -g; \
valgrind --leak-check=full -v src/app"
```
Call profiling:
```
docker run -ti -v $PWD:/test memory-test:0.1 bash -c \
"cd /test/; gcc -std=c99 -o src/app src/app.c src/functions.c -g; \
valgrind --tool=callgrind --callgrind-out-file=profiling/callgrind_app -v src/app; \
valgrind callgrind_annotate --tree=both --auto=yes profiling/callgrind_app"
```

##### Profile test with dockerized Valgrind
Heap, allocation tree and stack profiling:
```
docker run -ti -v $PWD:/test memory-test:0.1 bash -c \
"cd /test/; gcc -std=c99 -o tests/functions_test tests/functions_test.c -g -lcunit -v; \
valgrind --tool=massif --stacks=yes --massif-out-file=profiling/massif_functions_test tests/functions_test; \
ms_print profiling/massif_functions_test"
```
Memory profiling:
```
docker run -ti -v $PWD:/test memory-test:0.1 bash -c \
"cd /test/; gcc -std=c99 -o tests/functions_test tests/functions_test.c -g -lcunit -v; \
valgrind --leak-check=full -v tests/functions_test"
```
Call profiling:
```
docker run -ti -v $PWD:/test memory-test:0.1 bash -c \
"cd /test/; gcc -std=c99 -o tests/functions_test tests/functions_test.c -g -lcunit -v; \
valgrind --tool=callgrind --callgrind-out-file=profiling/callgrind_functions_test -v tests/functions_test; \
valgrind callgrind_annotate --tree=both --auto=yes profiling/callgrind_functions_test"
```

### resources
- https://medium.com/@marinalimeira/tdd-using-cunit-first-steps-5c4c2a8655e6
- http://www.cs.colby.edu/maxwell/courses/tutorials/maketutor/
- https://www.gungorbudak.com/blog/2018/06/13/memory-leak-testing-with-valgrind-on-macos-using-docker-containers/
- https://www.cs.cmu.edu/afs/cs.cmu.edu/project/cmt-40/Nice/RuleRefinement/bin/valgrind-3.2.0/docs/html/ms-manual.html
- https://accu.org/index.php/journals/1884 
