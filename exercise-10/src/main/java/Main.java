import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;


public class Main {

    public static void main(String[] args) throws IOException {
        String content = readFile("./src/main/resources/words_alpha.txt", StandardCharsets.UTF_8);
        String[] contentArray = content.split("\\s+");
        for (int i = 0; i < contentArray.length; i++) {
            contentArray[i] = contentArray[i].replaceAll("[^\\w]", "");
        }



        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter degree of b-tree (greater than 3): ");
        int degree = 3;
        degree = Integer.parseInt(input.next(Pattern.compile("^([1-9][0-9]+|[3-9])$")));
        System.out.print("\nReceived. Building linked list...");

        long startTimeList = System.nanoTime();
        LinkedList list = new LinkedList();
        for(String i: contentArray){
            list.insert(i);
        }
        long endTimeList = System.nanoTime();
        long timeElapsedList = endTimeList - startTimeList;
        System.out.println("\nExecution time in seconds : " + timeElapsedList/1000000000);

        System.out.print("\nBuilding b-tree...");
        long startTimeTree = System.nanoTime();
        B_Tree tree = new B_Tree(degree);
        for(String i: contentArray){
            tree.insert(i);
        }
        long endTimeTree = System.nanoTime();
        long timeElapsedTree = endTimeTree - startTimeTree;
        System.out.println("\nExecution time in seconds : " + timeElapsedTree/1000000000);

        Scanner input2 = new Scanner(System.in);
        System.out.print("\nWant to print in-order tree? (y/n): ");
        String answer = input2.nextLine();
        if(answer.equals("y")){
            tree.printInorder(tree.root);
        }

        Scanner input3 = new Scanner(System.in);
        System.out.print("\nWhat string do you want to search both in the linked list and in the tree?");
        String answer2 = input3.nextLine();

        long startTimeS1 = System.nanoTime();
        System.out.println("\nNodes traversed in linked list: " + list.search(answer2));
        long endTimeS1 = System.nanoTime();
        long timeElapsedS1 = endTimeS1 - startTimeS1;
        System.out.println("\nSearch time in linked list, in seconds : " + timeElapsedS1/1000000000);

        long startTimeS2 = System.nanoTime();
        System.out.println("\nWord found in b-tree: " + Boolean.toString(tree.search(answer2, tree.root)));
        long endTimeS2 = System.nanoTime();
        long timeElapsedS2 = endTimeS2 - startTimeS2;
        System.out.println("\nSearch time in b-tree, in seconds : " + timeElapsedS2/1000000000);

    }

    public static String readFile(String path, Charset utf8) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, utf8);
    }


}
