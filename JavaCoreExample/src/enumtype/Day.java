package enumtype;

/**
 *
 * @author nvduc
 */
public enum Day {

    SUNDAY("Sunday"), MONDAY("Monday"), TUESDAY("Tuesday"), WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"), FRIDAY("Friday"), SATURDAY("Saturday");
    
    private final String value;

    Day(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return value;
    }

    public static Day findByValue(String value) {
        for (Day v : values()) {
            if (v.toString().equals(value)) {
                return v;
            }
        }
        return null;
    }
}
