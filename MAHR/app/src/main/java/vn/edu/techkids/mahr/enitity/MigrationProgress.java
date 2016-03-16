package vn.edu.techkids.mahr.enitity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by qhuydtvt on 3/16/2016.
 */
public class MigrationProgress {

    @SerializedName("profile_id")
    private int profileId;

    @SerializedName("factory")
    private String factory;

    @SerializedName("department")
    private String department;

    @SerializedName("company")
    private String company;

    @SerializedName("1_passport_status")
    private int passportStatus;

    @SerializedName("1_passport_end_date")
    private String passportEndDate;

    @SerializedName("2_legal_status")
    private int legalStatus;

    @SerializedName("2_legel_end_date")
    private String legalEndDate;

    @SerializedName("3_health_status")
    private int healthStatus;

    @SerializedName("3_health_end_date")
    private String healthEndDate;

    @SerializedName("4_file_status")
    private int fileStatus;

    @SerializedName("4_file_end_date")
    private String fileEndDate;

    @SerializedName("5_office_status")
    private int officeStatus;

    @SerializedName("5_office_start_date")
    private String officeStartDate;

    @SerializedName("5_office_end_date")
    private String officeEndDate;

    @SerializedName("6_visa_status")
    private int visaStatus;

    @SerializedName("6_visa_start_date")
    private String visaStartDate;

    @SerializedName("6_visa_end_date")
    private String visaEndDate;

    @SerializedName("7_flight_status")
    private int flightStatus;

    @SerializedName("7_flight_end_date")
    private String flightEndDate;

    @SerializedName("8_finish")
    private int finish;

    @SerializedName("profile")
    private Worker profile;

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getPassportStatus() {
        return passportStatus;
    }

    public void setPassportStatus(int passportStatus) {
        this.passportStatus = passportStatus;
    }

    public String getPassportEndDate() {
        return passportEndDate;
    }

    public void setPassportEndDate(String passportEndDate) {
        this.passportEndDate = passportEndDate;
    }

    public int getLegalStatus() {
        return legalStatus;
    }

    public void setLegalStatus(int legalStatus) {
        this.legalStatus = legalStatus;
    }

    public String getLegalEndDate() {
        return legalEndDate;
    }

    public void setLegalEndDate(String legalEndDate) {
        this.legalEndDate = legalEndDate;
    }

    public int getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(int healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getHealthEndDate() {
        return healthEndDate;
    }

    public void setHealthEndDate(String healthEndDate) {
        this.healthEndDate = healthEndDate;
    }

    public int getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(int fileStatus) {
        this.fileStatus = fileStatus;
    }

    public String getFileEndDate() {
        return fileEndDate;
    }

    public void setFileEndDate(String fileEndDate) {
        this.fileEndDate = fileEndDate;
    }

    public int getOfficeStatus() {
        return officeStatus;
    }

    public void setOfficeStatus(int officeStatus) {
        this.officeStatus = officeStatus;
    }

    public String getOfficeStartDate() {
        return officeStartDate;
    }

    public void setOfficeStartDate(String officeStartDate) {
        this.officeStartDate = officeStartDate;
    }

    public String getOfficeEndDate() {
        return officeEndDate;
    }

    public void setOfficeEndDate(String officeEndDate) {
        this.officeEndDate = officeEndDate;
    }

    public int getVisaStatus() {
        return visaStatus;
    }

    public void setVisaStatus(int visaStatus) {
        this.visaStatus = visaStatus;
    }

    public String getVisaStartDate() {
        return visaStartDate;
    }

    public void setVisaStartDate(String visaStartDate) {
        this.visaStartDate = visaStartDate;
    }

    public String getVisaEndDate() {
        return visaEndDate;
    }

    public void setVisaEndDate(String visaEndDate) {
        this.visaEndDate = visaEndDate;
    }

    public int getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(int flightStatus) {
        this.flightStatus = flightStatus;
    }

    public String getFlightEndDate() {
        return flightEndDate;
    }

    public void setFlightEndDate(String flightEndDate) {
        this.flightEndDate = flightEndDate;
    }

    public int getFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }

    public Worker getProfile() {
        return profile;
    }

    public void setProfile(Worker profile) {
        this.profile = profile;
    }
}
