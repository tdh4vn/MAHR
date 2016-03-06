package vn.edu.techkids.mahr.enitity;

import java.util.ArrayList;

/**
 * Created by qhuydtvt on 3/6/2016.
 */
public class JobProperty {
    private int mPropertyNameId;
    private int mImageId;

    public JobProperty(int propertyNameId, int imageId) {
        this.mPropertyNameId = propertyNameId;
        this.mImageId = imageId;
    }

    /*public JobProperty(String propertyName, int imageId) {
        this.mPropertyName = propertyName;
        this.mImageId = imageId;
    }*/

    public int getPropertyNameId (){ return mPropertyNameId;}
    public int getImageId() {return mImageId;}
}
