import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {

    public static String readFile(String path, Charset utf8) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, utf8);
    }

    public static void main(String[] args) throws IOException {
        String content = readFile("./src/main/resources/words_alpha.txt", StandardCharsets.UTF_8);
        String[] contentar = content.split("\\s+");
        for (int i = 0; i < contentar.length; i++) {
            contentar[i] = contentar[i].replaceAll("[^\\w]", "");
        }

        B_Tree mytree = new B_Tree(4);

        for(String i: contentar){
            mytree.insert(i);
        }

        mytree.printInorder(mytree.getRoot());

    }


}
