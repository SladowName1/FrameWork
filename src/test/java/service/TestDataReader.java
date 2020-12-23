package service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static final ResourceBundle user=ResourceBundle.getBundle(System.getProperty("user"));
    private static final ResourceBundle item=ResourceBundle.getBundle(System.getProperty("item"));

    public static String getUser(String key) {return user.getString(key); }

    public static String getItem(String key) { return item.getString(key); }
}
