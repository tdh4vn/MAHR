package vn.edu.techkids.mahr.enitity;

import java.util.ArrayList;

/**
 * Created by qhuydtvt on 3/6/2016.
 */
public class JobProperty {
    private String mPropertyName;
    private int mImageId;

    public JobProperty(String propertyName, int imageId) {
        this.mPropertyName = propertyName;
        this.mImageId = imageId;
    }

    public String getPropertyName (){ return mPropertyName;}
    public int getImageId() {return mImageId;}
}
