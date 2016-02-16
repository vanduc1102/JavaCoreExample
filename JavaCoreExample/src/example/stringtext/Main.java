package example.stringtext;

/**
 *
 * @author nvduc
 */
public class Main {
    public static void main(String[] args) {
        String name="Duc\\Nguyen";
        System.out.println("LastIndex of String "+name.lastIndexOf("\\") );
        System.out.println("LastIndex of String "+name.lastIndexOf('\\') );
        
    }
}
