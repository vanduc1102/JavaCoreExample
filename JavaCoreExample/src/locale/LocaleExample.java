package locale;

import java.util.Locale;

/**
 *
 * @author nvduc
 */
public class LocaleExample {

    private static final String LOCALE_SEPARATOR = "_|-|,";

    public static void main(String args[]) {
        String localeStr = "fr,vi-VN;q=0.8,fr;q=0.6";
        Locale locale = Locale.getDefault();
        System.out.println("Default locale " + locale);
        System.out.println("Locale.getDefault().getLanguage(); " + locale.getLanguage());
        System.out.println("Locale.US.getLanguage(); " + Locale.US.getLanguage());
        System.out.println("Locale.US.getLanguage(); " + convert(localeStr).getLanguage());
        System.out.println("convertLanguage() : " + convertLanguage(localeStr));
    }

    public static Locale convert(final String locale) {
        String[] terms;
        if (locale == null || locale.isEmpty()) {
            terms = Locale.getDefault().getLanguage().split(LOCALE_SEPARATOR);
        } else {
            terms = locale.split(LOCALE_SEPARATOR);
        }

        if (terms.length == 2) {
            return new Locale.Builder().setLanguage(terms[0]).setRegion(terms[1]).build();
        } else if (terms.length == 1) {
            return new Locale.Builder().setLanguage(terms[0]).build();
        }
        return Locale.getDefault();
    }
    
    public static String convertLanguage(String value){
        if(value.length() == 2 && !value.contains("-"))return value;
        String suffix;
        value = value.replaceAll("_", "-");
        suffix=value.replaceAll("(\\S*)[-_](\\S*)", "$2");
        value= value.replaceAll("[-_](\\S*)", "_"+suffix.toUpperCase(Locale.US));
        return value;
    }
}
