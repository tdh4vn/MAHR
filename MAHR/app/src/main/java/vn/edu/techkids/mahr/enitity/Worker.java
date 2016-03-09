package vn.edu.techkids.mahr.enitity;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import vn.edu.techkids.mahr.constants.Constants;

/**
 * Created by qhuydtvt on 3/9/2016.
 */
public class Worker {

    private int id;
    private String code;
    private String name;
    private int gender;
    private String nationality;
    private int birthyear;
    private String birthday;
    private int height;
    private int weight;
    private String mobile_number;
    private int education_level;
    private String avatar;
    private String excel_path;
    private int age;

    public List<Expertise> experiences;

    private static ArrayList<Worker> workerArrayList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getGender() {
        return gender;
    }

    public String getNationality() {
        return nationality;
    }

    public int getBirthyear() {
        return birthyear;
    }

    public String getBirthday() {
        return birthday;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public int getEducation_level() {
        return education_level;
    }

    public String getAvatar() {
        if(avatar == null || avatar == "")
            return Constants.API_DEFAULT_PHOTO_LINK;
        return avatar;
    }

    public String getExcel_path() {
        return excel_path;
    }

    public int getAge() {
        return age;
    }

    public List<Expertise> getExperiences() {
        return experiences;
    }

    public String getExpertiseString() {
        String ret = "";
        int size = experiences.size();
        if(size > 0) {
            Log.d("getExpertiseString", String.valueOf(size));
            for (int i = 0; i < size; i++) {
                String name = experiences.get(i).getName();
                if(name != null && name != "") {
                    ret += name;
                    if (i < size - 1) ret += ", ";
                }
            }
        }
        return ret;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setBirthyear(int birthyear) {
        this.birthyear = birthyear;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public void setEducation_level(int education_level) {
        this.education_level = education_level;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setExcel_path(String excel_path) {
        this.excel_path = excel_path;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setExperiences(List<Expertise> experiences) {
        this.experiences = experiences;
    }

    public static ArrayList<Worker> getWorkerArrayList() {
        return workerArrayList;
    }

    public static void loadJsonToList(JSONObject jsonObject) {
        JSONArray jsonArray = null;
        Gson gson = new Gson();
        workerArrayList.clear();
        try {
            jsonArray = jsonObject.getJSONArray(Constants.API_KEY_ITEMS);
            for(int idx = 0; idx < jsonArray.length(); idx++) {
                JSONObject jsonWorker = jsonArray.getJSONObject(idx);
                Worker worker = gson.fromJson(jsonWorker.toString(), Worker.class);
                workerArrayList.add(worker);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /*private String photoLink;


    private int age;
    private ArrayList<Expertise> expertiseArrayList;
    private String mobileNumber;
    private int degree;


    private String expersion;*/

    /*public Worker(int id, String photoLink, String name, String expersion, int age) {
        this.id = id;
        this.photoLink = photoLink;
        this.name = name;
        this.expersion = expersion;
        this.age = age;
    }*/

    /*public static final String API_KEY_ID = "id";
    public static final String API_KEY_CODE = "code";
    public static final String API_KEY_NAME = "name";
    public static final String API_KEY_GENDER = "gender";
    public static final String API_KEY_NATIONALITY = "nationality";
    public static final String API_KEY_BIRTHYEAR = "birthyear";
    public static final String API_KEY_BIRTHDAY = "birthday";
    public static final String API_KEY_HEIGHT = "height";
    public static final String API_KEY_WEIGHT = "weight";
    public static final String API_KEY_MOBILE_NUMBER = "mobile_number";
    public static final String API_KEY_DEGREE = "educational_level";
    public static final String API_KEY_EXCEL_PATH = "excel_path";
    public static final String API_KEY_CREATED_AT = "created_at";
    public static final String API_KEY_AGE = "age";

    public Worker(JSONObject jsonObject) {
        try {
            this.id = jsonObject.getInt(API_KEY_ID);
            this.code = jsonObject.getString(API_KEY_CODE);
            this.name = jsonObject.getString(API_KEY_NAME);
            this.gender = jsonObject.getInt(API_KEY_GENDER);
            this.nationality = jsonObject.getString(API_KEY_NATIONALITY);
            this.birthYear = jsonObject.getInt(API_KEY_BIRTHYEAR);
            this.birthDay = jsonObject.getString(API_KEY_BIRTHDAY);
            this.height = jsonObject.getInt(API_KEY_HEIGHT);
            this.weight = jsonObject.getInt(API_KEY_WEIGHT);
            this.mobileNumber = jsonObject.getString(API_KEY_MOBILE_NUMBER);
            this.degree = jsonObject.getInt(API_KEY_DEGREE);
            *//*this.excelPath = jsonObject.getString()*//*

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }*/
/*
    @Override
    public String toString() {
        return name;
    }*/
}
