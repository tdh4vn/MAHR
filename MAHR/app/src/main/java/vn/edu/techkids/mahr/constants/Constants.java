package vn.edu.techkids.mahr.constants;

/**
 * Created by hungtran on 3/6/16.
 */
public class Constants {


    public static final int MIN_AGE = 18;
    public static final int MAX_AGE = 60;

    public static final int MIN_HEIGHT = 150;
    public static final int MAX_HEIGHT = 190;

    public static final int MIN_WEIGHT = 40;
    public static final int MAX_WEIGHT = 190;

    public static final int MIN_XP = 0;
    public static final int MAX_XP = 10;



    public static String API_VIETNAM = "VN";
    public static String API_INDONESIA = "IN";
    public static String API_TAIWAN = "CH";

    public static String API_PARAM_DEGREE_SECONDARY_SCHOOL = "1";
    public static String API_PARAM_DEGREE_HIGH_SCHOOL = "2";
    public static String API_PARAM_DEGREE_COLLEGE = "3";
    public static String API_PARAM_DEGREE_UNIVERISTY = "4";

    /*public static final String KEY_VIETNAM = "KEYVIETNAM";
    public static final String KEY_INDONESIA = "KEYINDONESIA";*/

    public static String API_MAJOR_MALE_WORKER = "1";
    public static String API_MAJOR_FEMALE_WORKER = "2";
    public static String API_MAJOR_HOUSEMAID = "3";

    public static final String API_URL_ROOT = "http://api.mahr.adcviet.com/v1";
    public static final String API_URL_EXPERTISE = API_URL_ROOT + "/experiences";
    public static final String API_URL_PROFILE = API_URL_ROOT + "/profiles?expand=experiences";

    public static final String API_KEY_ITEMS ="items";

    public static final String API_DEFAULT_PHOTO_LINK = "http://rs829.pbsrc.com/albums/zz219/vinadragon/Son16.jpg~c200";

    public static String API_FILTER_PREFIX = "&filter[]=";
    public static String API_FILTER_EXPERTISE_FORMAT = API_FILTER_PREFIX + "exps+include+%s";
    public static String API_FILTER_AGE_FORMAT = API_FILTER_PREFIX + "age+beetween+%s,%s";
    public static String API_FILTER_HEIGHT_FORMAT = API_FILTER_PREFIX + "height+beetween+%s,%s";
    public static String API_FILTER_WEIGHT_FORMAT = API_FILTER_PREFIX + "weight+beetween+%s,%s";
    public static String API_FILTER_LANG_FORMAT = API_FILTER_PREFIX + "langs+include+%s";
    public static String API_FILTER_EXP_FORMAT = API_FILTER_PREFIX + "exp_year+beetween+%s,%s";
    public static String API_FILTER_DEGREE_FORMAT = API_FILTER_PREFIX + "educational_level+gte+%s";
    public static String API_FILTER_MAJOR_FORMAT = API_FILTER_PREFIX + "major+eq+%s";
    public static String API_FILTER_NATION_FORMAT = API_FILTER_PREFIX + "nation+eq+%s";
}
