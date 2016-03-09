package vn.edu.techkids.mahr.enitity;

import vn.edu.techkids.mahr.R;
import vn.edu.techkids.mahr.constants.Constants;

/**
 * Created by qhuydtvt on 3/7/2016.
 */
public class JobCriteria {

    private static JobCriteria inst = new JobCriteria();

    private String nationality;
    private String major;
    private int expertise = -1;
    private int minAge = -1;
    private int maxAge = -1;
    private int minHeight = -1;
    private int maxHeight = -1;
    private int minWeight = -1;
    private int maxWeight = -1;
    private int language = -1;
    private int minExperience = -1;
    private int maxExperience = -1;
    private int degree = -1;

    public static final int TOTAL_CRITERIA = 9;
    public static final int NATIONALITY_CRITERIA = 0;
    public static final int JOB_TYPE = 1;
    public static final int EXPERTISE = 2;
    public static final int AGE = 3;
    public static final int HEIGHT = 4;
    public static final int WEIGHT = 5;
    public static final int LANG = 6;
    public static final int EXP = 7;
    public static final int DEGREE = 8;

    private JobCriteriaListener mJobCriteriaListener;

    private JobCriteria() { }

    public static JobCriteria getInst() {return inst;}

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getExpertise() {
        return expertise;
    }

    public void setExpertise(int expertise) {
        this.expertise = expertise;
        notifyListener();
    }

    public void setAgeRange(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.notifyListener();
    }

    public String getAgeRange() {
        if(minAge == -1 || maxAge == -1) return null;
        return String.format("%d - %d", minAge, maxAge);
    }

    public String getWeightRange() {
        if(minWeight == -1 || maxWeight == -1) return null;
        return String.format("%d - %d", minWeight, maxWeight);
    }

    public String getHeightRange() {
        if(minHeight == -1 || maxHeight == -1) return null;
        return String.format("%d - %d", minHeight, maxHeight);
    }

    public String getExpRange() {
        if(minExperience == -1 || maxExperience == -1) return null;
        return String.format("%d - %d", minExperience, maxExperience);
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
        notifyListener();
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
        notifyListener();
    }

    public void setJobCriteriaListener(JobCriteriaListener jobCriteriaListener) {
        this.mJobCriteriaListener = jobCriteriaListener;
    }

    public int getMinHeight() {
        return minHeight;
    }

/*    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
        notifyListener();
    }*/

    public int getMaxHeight() {
        return maxHeight;
    }
/*
    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
        notifyListener();
    }*/

    public void setHeightRange(int minHeight, int maxHeight) {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.notifyListener();
    }

    public int getMinWeight() {
        return minWeight;
    }

    /*public void setMinWeight(int minWeight) {
        this.minWeight = minWeight;
        notifyListener();
    }*/

    public int getMaxWeight() {
        return maxWeight;
    }

    /*public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
        notifyListener();
    }*/

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
        notifyListener();
    }

    public String getLanguageAPIParam() {
        switch (language){
            case R.string.vietnam: return Constants.API_VIETNAM;
            case R.string.indonesia: return Constants.API_INDONESIA;
            case R.string.taiwan: return Constants.API_TAIWAN;
        }
        return "";
    }

    public int getDegree() {
        return degree;
    }

    private String getDegreeAPIParam() {
        switch (degree) {
            case R.string.secondary_school: return Constants.API_PARAM_DEGREE_SECONDARY_SCHOOL;
            case R.string.high_school: return Constants.API_PARAM_DEGREE_HIGH_SCHOOL;
            case R.string.college: return Constants.API_PARAM_DEGREE_COLLEGE;
            case R.string.university: return Constants.API_PARAM_DEGREE_UNIVERISTY;
        }
        return "";
    }


    public void setDegree(int degree) {
        this.degree = degree;
        notifyListener();
    }

    /*public void setMinExperience(int minExperience) {
        notifyListener();
        this.minExperience = minExperience;
    }

    public void setMaxExperience(int maxExperience) {
        notifyListener();
        this.maxExperience = maxExperience;
    }*/

    public void setExperienceRange(int minExperience,int maxExperience) {
        this.minExperience = minExperience;
        this.maxExperience = maxExperience;
        notifyListener();
    }

    public void setWeightRange(int minWeight,int maxWeight) {
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        notifyListener();
    }

    /*private void toAPIParam()

    public String getAPIParams() {

    }*/

    private void notifyListener() {
        if (this.mJobCriteriaListener != null) {
            mJobCriteriaListener.onJobCriteriaChange();
        }
    }

    /***********************************************************************************************/
    /******************************************* API ***********************************************/
    /***********************************************************************************************/
    private String getExpertiseAPIString() {
        if(expertise == -1) return "";
        return String.format(Constants.API_FILTER_EXPERTISE_FORMAT, this.expertise);
    }

    private String getAgeAPIString() {
        if(this.minAge == -1 || this.maxAge == -1) return "";
        return String.format(Constants.API_FILTER_AGE_FORMAT, this.minAge, this.maxAge);
    }

    private String getHeightAPIString() {
        if(this.minHeight == -1 || this.maxHeight == -1) return "";
        return String.format(Constants.API_FILTER_HEIGHT_FORMAT, this.minHeight, this.maxHeight);
    }

    private String getWeightAPIString() {
        if(this.minWeight == -1 || this.maxWeight == -1) return "";
        return String.format(Constants.API_FILTER_WEIGHT_FORMAT, this.minWeight, this.maxWeight);
    }

    private String getLangAPIString() {
        if(this.getLanguageAPIParam() == "") return "";
        return String.format(Constants.API_FILTER_LANG_FORMAT, this.getLanguageAPIParam());
    }

    private String getExperienceAPIString() {
        if(minExperience == -1 || maxExperience == -1) return "";
        return String.format(Constants.API_FILTER_EXP_FORMAT, this.minExperience, this.maxExperience);
    }

    private String getDegreeAPIString() {
        if(degree == -1) return "";
        return String.format(Constants.API_FILTER_DEGREE_FORMAT, getDegreeAPIParam());
    }

    private String getMajorAPIString() {
        if(major == null) return "";
        return String.format(Constants.API_FILTER_MAJOR_FORMAT, major);
    }

    private String getNationalityString() {
        if(nationality == null) return "";
        return String.format(Constants.API_FILTER_NATION_FORMAT, nationality);
    }

    public String getAPIString() {
        return Constants.API_URL_PROFILE +
                getExpertiseAPIString() +
                getAgeAPIString() +
                getHeightAPIString() +
                getWeightAPIString() +
                getLangAPIString() +
                getExperienceAPIString() +
                getDegreeAPIString() +
                getMajorAPIString() +
                getNationalityString();
    }
}
