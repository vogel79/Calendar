import domain.Calendar;
import domain.Date;
import exception.InvalidDateFormatException;
import org.junit.jupiter.api.*;
import service.Addition;
import service.Deletion;
import service.Delta;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalendarTests {

    @BeforeAll
    public static void setUp() {
        try {
           Calendar d1 = new Calendar("23/08/1979", "17:25:00", "dd/mm/yyyy hh:mm:ss");
            Assertions.assertEquals(d1.getDate().getDate(), 23);
        } catch (InvalidDateFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @Order(1)
        public void createDate() {
        try {
            Calendar d1 = new Calendar("23/08/-1", "17:25:00", "dd/mm/yyyy hh:mm:ss");
        } catch (InvalidDateFormatException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals("Введён неверный год! Должен быть не меньше 0", e.getMessage());
        }
    }

    @Test
    @Order(2)
    public void createDate2() {
        try {
            Calendar d1 = new Calendar("29/02/2001", "00:00:00", "dd/mm/yyyy hh:mm:ss");
        } catch (InvalidDateFormatException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals("Введена неверная дата!", e.getMessage());
        }
    }

    @Test
    @Order(3)
    public void createDate3() {
        try {
            Calendar d1 = new Calendar("29/02/2000", "00:00:00", "dd/mm/yyyy hh:mm:ss");
            Assertions.assertEquals(d1.getDate().getDate(), 29);
        } catch (InvalidDateFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @Order(4)
    public void addDays() {
        try {
            Calendar d1 = new Calendar("29/02/2000", "00:00:00", "dd/mm/yyyy hh:mm:ss");
            Date date = Addition.addDays(365, d1.getDate());
            System.out.println(date.toString());
            Assertions.assertEquals(date.toString(), "28.2.2001 0:0:0");
        } catch (InvalidDateFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @Order(5)
    public void delHours() {
        try {
            Calendar d1 = new Calendar("01/01/2000", "23:55:00", "dd/mm/yyyy hh:mm:ss");
            Date date = Deletion.delHours(48, d1.getDate());
            System.out.println(date.toString());
            Assertions.assertEquals(date.toString(), "30.12.1999 23:55:0");
        } catch (InvalidDateFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @Order(6)
    public void delta() {
        try {
            Calendar d1 = new Calendar("01/01/2000", "23:55:00", "dd/mm/yyyy hh:mm:ss");
            Calendar d2 = new Calendar("01/01/2001", "23:55:00", "dd/mm/yyyy hh:mm:ss");
            long delta = Delta.getNumberOfDays(d1 , d2);
            System.out.println(delta);
            Assertions.assertEquals(delta, 366);
        } catch (InvalidDateFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @Order(7)
    public void delta2() {
        try {
            Calendar d1 = new Calendar("01/01/2001", "23:55:00", "dd/mm/yyyy hh:mm:ss");
            Calendar d2 = new Calendar("01/01/2002", "23:55:00", "dd/mm/yyyy hh:mm:ss");
            long delta = Delta.getNumberOfDays(d1 , d2);
            System.out.println(delta);
            Assertions.assertEquals(delta, 365);
        } catch (InvalidDateFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
