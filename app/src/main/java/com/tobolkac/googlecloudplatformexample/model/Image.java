package com.tobolkac.googlecloudplatformexample.model;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by clayt on 1/31/15.
 */
@RealmClass
public class Image extends RealmObject
{
    private Date timestamp;

    private String imageId;
    private byte[] image;

    public Date getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }

    public byte[] getImage()
    {
        return image;
    }

    public void setImage(byte[] image)
    {
        this.image = image;
    }

    public String getImageId()
    {
        return imageId;
    }

    public void setImageId(String imageId)
    {
        this.imageId = imageId;
    }
}
