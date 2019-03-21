import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        B_Tree mytree = new B_Tree(6);
        String s = "Que soy su nene que soy su bebe Se pone loquita cuando me ve en la TV";
        String[] words = s.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^\\w]", "");
        }
        String[] words2 = {"a", "b", "c", "d"};
        System.out.println(Arrays.toString(words));
        System.out.println("bbcita");

//        for(String i: words){
//            mytree.insert(i);
//        }

        mytree.insert("c");
        mytree.insert("c");
        mytree.insert("c");
        mytree.insert("c");
        mytree.insert("c");
        mytree.insert("c");
        mytree.insert("b"); // 7 first after new root pushed
        mytree.insert("a"); //8
        mytree.insert("A");
//        mytree.insert(words[3]);
//        mytree.insert(words[4]);
//        mytree.insert(words[5]);
//        mytree.insert(words[0]);
//        mytree.insert(words[3]);

        if(Interpreter.isGreater("soy", "Que")){
            System.out.println("bbcita is greater");
        } else {
            System.out.println("bbcita is NOT greater");
        }

    }
}
