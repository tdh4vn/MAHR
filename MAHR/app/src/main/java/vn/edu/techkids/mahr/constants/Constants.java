package vn.edu.techkids.mahr.constants;

/**
 * Created by hungtran on 3/6/16.
 */
public class Constants {
    public static final String KEY_VIETNAM = "KEYVIETNAM";
    public static final String KEY_INDONESIA = "KEYINDONESIA";

    public static final int MIN_AGE = 18;
    public static final int MAX_AGE = 60;

    public static final int MIN_HEIGHT = 150;
    public static final int MAX_HEIGHT = 190;

    public static final int MIN_WEIGHT = 40;
    public static final int MAX_WEIGHT = 190;

    public static final int MIN_XP = 0;
    public static final int MAX_XP = 10;

    public static final String API_URL_ROOT = "http://api.mahr.adcviet.com/v1";
    public static final String API_URL_EXPERTISE = API_URL_ROOT + "/experiences";
    public static final String API_URL_PROFILE = API_URL_ROOT + "/profiles?expand=";

    public static String API_LANG_VIETNAM = "VN";
    public static String API_LANG_INDONESIA = "IN";
    public static String API_LANG_TAIWAN = "CH";

    public static String API_MAJOR_MALE_WORKER = "1";
    public static String API_MAJOR_FEMALE_WORKER = "2";
    public static String API_MAJOR_HOUSEMAID = "3";
}
