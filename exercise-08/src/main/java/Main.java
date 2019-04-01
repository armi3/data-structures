import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Factory factory = new Factory();
        ControllerInterface controller = factory.createController(
                factory.createSchedule(),
                factory.createPortfolio(),
                factory.createView());

        List<String> lines = Files.readAllLines(Paths.get("./src/main/resources/database.txt"), StandardCharsets.UTF_8);
        String[] database = lines.toArray(new String[lines.size()]);
        controller.getPortfolio().loadPortfolio(database);
        controller.printPortfolio();

        int menuChoice = 0;
        do{
            switch(menuChoice) {
                case 0:
                    menuChoice = controller.getView().promptActionWithMenu();
                    break;
                case 1:
                    menuChoice = controller.assignToRandom();
                    break;
                case 2:
                    menuChoice = controller.assignToSpecific();
                    break;
                case 3:
                    menuChoice = controller.printPortfolio();
                    break;
                case 4:
                    menuChoice = controller.updatePortfolio();
                    break;
                case 6:
                    menuChoice = controller.getView().promptAction();
                    break;
            }

        } while(!String.valueOf(menuChoice).equals("5"));
        System.exit(0);

    }

}
