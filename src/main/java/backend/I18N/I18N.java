package backend.I18N;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;


import java.text.MessageFormat;
import java.util.*;
import java.util.List;

public final class I18N {

    private static final ObjectProperty<Locale> locale;

    static {
        locale = new SimpleObjectProperty<>(getDefaultLocale());
        locale.addListener(((observable, oldValue, newValue) -> Locale.setDefault(newValue)));
    }

    public static List<Locale> getSupportedLocales() {
        return new ArrayList<>(Arrays.asList(Locale.ENGLISH, Locale.GERMAN));
    }

    public static Locale getDefaultLocale() {
        Locale sysDefault = Locale.getDefault();
        return getSupportedLocales().contains(sysDefault) ? sysDefault : Locale.ENGLISH;
    }

    public static Locale getLocale() {
        return locale.get();
    }

    public static void setLocale(Locale locale) {
        localeProperty().set(locale);
        Locale.setDefault(locale);
    }

    public static ObjectProperty<Locale> localeProperty() {
        return locale;
    }

    public static String get(final String key, final Object... args){
        ResourceBundle bundle = ResourceBundle.getBundle("lang/lang", getLocale());
        return MessageFormat.format(bundle.getString(key), args);

    }

    public static StringBinding createStringBinding(final String key, Object... args){
        return Bindings.createStringBinding(() ->get(key, args), locale);

    }








}