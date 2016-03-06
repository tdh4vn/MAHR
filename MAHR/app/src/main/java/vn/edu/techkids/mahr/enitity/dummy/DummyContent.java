package vn.edu.techkids.mahr.enitity.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Person> ITEMS = new ArrayList<Person>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Person> ITEM_MAP = new HashMap<String, Person>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(Person item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static Person createDummyItem(int position) {
        String link = "http://binhminhstudio.com/Uploads/Picture/ChanDung/hinh_3.jpg";
        return new Person(position ,link, "Nguyen Quang Huy", "CNC", 18);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class Person {
        public String id;
        public String photoLink;
        public String name;
        public int age;
        public String expersion;

        public Person(int id,String photoLink,String name, String expersion, int age) {
            this.id = (new Integer(id)).toString();
            this.photoLink = photoLink;
            this.name = name;
            this.expersion = expersion;
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
