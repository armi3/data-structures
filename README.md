# Data structures
This is a collection of implementations I did for my university data structures course. Each exercise has testing, profiling, a demo recording and some useful resources. Java, C and Python were used.

# Table of contents
1. [Exercise 1 🧮](#exercise-1-)
2. [Exercise 2 (Stacks)](#exercise-2-stacks)
3. [Exercise 3 (Arrays) 💳](#exercise-3-arrays-)
4. [Exercise 4 (Matrices) 🛒](#exercise-4-matrices-)
5. [Exercise 5 (Strings) 📊](#exercise-5-strings-)
6. [Exercise 6 (Structs)](#exercise-6-structs)
7. [Exercise 7 (Circular Linked List) 🎧](#exercise-7-circular-linked-list-)
8. [Exercise 8 (Queue and Simply Linked List) 📆](#exercise-8-queue-and-simply-linked-list-)
9. [Exercise 9 (B-tree) 🌳](#exercise-9-b-tree-)
10. [Laboratory (Dijkstra's SPF algorithm)](#laboratory-dijkstras-spf-algorithm-)
11. [Final project (Boxit) 📦](#final-project-boxit-)


# Exercise 1 🧮
- Algorithm to find the sum of the first N natural numbers.
- Code in C
- Demo: https://youtu.be/8mKBWEocZ48
- **Unit testing** with dockerized CUnit
- **Profiling** with dockerized Valgrind:
  - Memory profiling with Memcheck tool
  - Heap, allocation tree and stack profiling with Massif tool
  - Call profiling with Callgrind tool
  
## Walkthrough
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

## Profile program with dockerized Valgrind
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

## Profile test with dockerized Valgrind
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

## Resources
- https://medium.com/@marinalimeira/tdd-using-cunit-first-steps-5c4c2a8655e6
- http://www.cs.colby.edu/maxwell/courses/tutorials/maketutor/
- https://www.gungorbudak.com/blog/2018/06/13/memory-leak-testing-with-valgrind-on-macos-using-docker-containers/
- https://www.cs.cmu.edu/afs/cs.cmu.edu/project/cmt-40/Nice/RuleRefinement/bin/valgrind-3.2.0/docs/html/ms-manual.html
- https://accu.org/index.php/journals/1884 


# Exercise 2 (Stacks) 
- Algorithm to implement a stack data structure.
- Code in Java
- Demo: https://youtu.be/9xWy4dNyj6g
- **Unit testing** with JUnit 5
- **Profiling** with JProfiler

## Resources
- https://www.codejava.net/coding/java-getter-and-setter-tutorial-from-basics-to-best-practices
- https://beginnersbook.com/2013/12/java-constructor-chaining-with-example/
- https://medium.com/@isaacjumba/overview-of-inheritance-interfaces-and-abstract-classes-in-java-3fe22404baf8
- https://howtodoinjava.com/junit5/


# Exercise 3 (Arrays) 💳
- Debits and credits manager.
- Code in Java
- Demo: https://youtu.be/w2oijZ4PeYE
- **Unit testing** with JUnit 5
- **Profiling** with JProfiler

## resources
- https://www.youtube.com/watch?v=LiiZnYbcliw


# Exercise 4 (Matrices) 🛒
- Shopping cart and payment methods manager.
- Code in Java
- Demo: https://youtu.be/ERi7V_H97Us
- **Unit testing** with JUnit 5
- **Profiling** with JProfiler


# Exercise 5 (Strings) 📊
- Returns a histogram with the top 10 most repeated chars.
- Code in Java
- Demo: https://youtu.be/uZgNDzgXhUM
- **Unit testing** with JUnit 5
- **Profiling** with JProfiler

## Resources
- https://www.geeksforgeeks.org/sorting-2d-array-according-values-given-column-java/
- https://loremipsum.io/
- https://www.programiz.com/java-programming/examples/frequency-character
- https://docs.google.com/presentation/d/1UfxPAHc7W4U5hQYChK7INW4Pm5MANKBbGUI0gLfLj5M/edit#slide=id.g4eb1243f07_0_148


# Exercise 6 (Structs)
- Returns point's quadrant implementing a struct (class without methods).
- Code in Java
- Demo: https://youtu.be/J9PImk7_7ho
- **Unit testing** with JUnit 5
- **Profiling** with JProfiler

## Resources
- https://docs.google.com/presentation/d/1Is38TeAGZMuUgPuWvaB0-ltH3hd9G1y9TRDdYtVFI3o/edit#slide=id.g4ec0fab4d5_0_71

# Exercise 7 (Circular Linked List) 🎧
- Music player simulation implementing a circular linked list.
- Code in Java
- Demo: https://youtu.be/dOMIVKmkuMM
- **Unit testing** with JUnit 5
- **Profiling** with JProfiler

# Exercise 8 (Queue and Simply Linked List) 📆
- Stores scheduled jobs in queue and updates linked list of employees.
- Code in Java
- **Unit testing** with TestNG
- **Profiling** with JProfiler
- Demo: https://youtu.be/9Br9xS27suI

# Exercise 9 (B-tree) 🌳
- Compares linked list performance versus b-tree.
- Code in Java
- Demo: https://youtu.be/1zJ_lNlY4vg
- **Unit testing** with TestNG
- **Profiling** with JProfiler

## Resources
- https://www.cs.usfca.edu/~galles/visualization/BTree.html

# Laboratory (Dijkstra's SPF algorithm) 💷
- Uses the shortest path first algorithm to find exchange rates.
- Code in Python

# Final project (Boxit) 📦
- Boxit is a desktop prototype app for creating suscription boxes.
- Implements the data structures learned throughout this course.
- Code in Java
- Demo: https://youtu.be/8nPCmNAcdlc
- **Unit testing** with TestNG
- **Profiling** with JProfiler
- **Front end** with JavaFX

## Screenshots
![Spotlight](https://i.imgur.com/4q5cVZk.png)
![Lab](https://i.imgur.com/2355aqr.png)
