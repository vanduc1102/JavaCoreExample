package locale;

import java.util.Locale;

/**
 *
 * @author nvduc
 */
public class LocaleExample {
    public static void main(String args[]){
        Locale locale = Locale.getDefault();
        System.out.println("Default locale "+ locale);
        System.out.println("Locale.getDefault().getLanguage(); "+ locale.getLanguage());
        System.out.println("Locale.US.getLanguage(); "+ Locale.US.getLanguage());
    }
}
