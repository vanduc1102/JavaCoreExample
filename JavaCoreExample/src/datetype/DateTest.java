package datetype;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author nvduc
 */
public class DateTest {
     public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println("Date "+ calendar);
        Date date = new Date();
        System.out.println("Date "+ date.toString());
        List<String> arrStr = new ArrayList<>();
        arrStr.add("Duc");
        arrStr.add("NGUYEN");
        arrStr.add("HA");
        arrStr.add("NAM");
        System.out.println("List string "+ arrStr.toString());
    }
}
