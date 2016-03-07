package vn.edu.techkids.mahr.enitity;

/**
 * Created by qhuydtvt on 3/7/2016.
 */
public class JobCriteria {

    private static JobCriteria inst = new JobCriteria();

    private String nationality;
    private String jobType;
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

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public int getExpertise() {
        return expertise;
    }


    public void setExpertise(int expertise) {
        this.expertise = expertise;
        notifyListener();
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

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
        notifyListener();
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
        notifyListener();
    }

    public int getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(int minWeight) {
        this.minWeight = minWeight;
        notifyListener();
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
        notifyListener();
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
        notifyListener();
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
        notifyListener();
    }

    public void setMinExperience(int minExperience) {
        notifyListener();
        this.minExperience = minExperience;
    }

    public void setMaxExperience(int maxExperience) {
        notifyListener();
        this.maxExperience = maxExperience;
    }

    private void notifyListener() {
        if (this.mJobCriteriaListener != null) {
            mJobCriteriaListener.onJobCriteriaChange();
        }
    }
}
