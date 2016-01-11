package enumtype;

public class EnumTest {

    Day day;

    public EnumTest(Day day) {
        this.day = day;
    }

    public void tellItLikeItIs() {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;

            case FRIDAY:
                System.out.println("Fridays are better.");
                break;

            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekends are best.");
                System.out.println("Day value : " +day.getValue());
                System.out.println("Day from value : " +Day.findByValue("Sunday"));
                break;

            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }

    public static void main(String[] args) {
        System.out.println("Get all values : ");
        for(Day value : Day.values()){
            System.out.print("key : "+ value.name());
            System.out.println(" | value: "+ value.toString());
        }
        EnumTest firstDay = new EnumTest(Day.MONDAY);
        firstDay.tellItLikeItIs();
        EnumTest thirdDay = new EnumTest(Day.WEDNESDAY);
        thirdDay.tellItLikeItIs();
        EnumTest fifthDay = new EnumTest(Day.FRIDAY);
        fifthDay.tellItLikeItIs();
        EnumTest sixthDay = new EnumTest(Day.SATURDAY);
        sixthDay.tellItLikeItIs();
        EnumTest seventhDay = new EnumTest(Day.SUNDAY);
        seventhDay.tellItLikeItIs();
    }
}
// Output :
/*
Get all values : 
key : SUNDAY | value: Sunday
key : MONDAY | value: Monday
key : TUESDAY | value: Tuesday
key : WEDNESDAY | value: Wednesday
key : THURSDAY | value: Thursday
key : FRIDAY | value: Friday
key : SATURDAY | value: Saturday
Mondays are bad.
Midweek days are so-so.
Fridays are better.
Weekends are best.
Day value : Saturday
Day from value : Sunday
Weekends are best.
Day value : Sunday
Day from value : Sunday
*/
