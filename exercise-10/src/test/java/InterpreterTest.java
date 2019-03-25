import org.testng.Assert;
import org.testng.annotations.Test;

public class InterpreterTest {

    @Test(groups = {"dev"}, description = "interpreter interface")
    public void testIsGreater() {
        Assert.assertTrue(Interpreter.isGreater("zzz", "aaa"));
    }
}