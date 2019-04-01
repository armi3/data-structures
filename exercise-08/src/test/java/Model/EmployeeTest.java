package Model;
import org.testng.Assert;
import org.testng.annotations.*;

public class EmployeeTest {

    @Test
    public void testGetSsn() {
        Employee employee = new Employee();
        Assert.assertEquals(employee.getSsn(), 0);
    }

    @Test
    public void testGetName() {
        Employee employee = new Employee();
        Assert.assertEquals(employee.getName(), "N/A");
    }

    @Test
    public void testGetBookedDates() {
        Employee employee = new Employee();
        Assert.assertEquals(employee.getBookedDates(), 0);
    }

    @Test
    public void testGetNext() {
        Employee employee = new Employee();
        Assert.assertEquals(employee.getNext(), null);
    }
}