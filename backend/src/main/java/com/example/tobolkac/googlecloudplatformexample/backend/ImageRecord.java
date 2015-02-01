package com.example.tobolkac.googlecloudplatformexample.backend;

import com.googlecode.objectify.annotation.Entity;

import java.util.Date;

/**
 * Created by clayt on 2/1/15.
 */
@Entity
public class ImageRecord
{
    private String imageId;
    private byte[] imageData;
    private Date timestamp;

    public String getImageId()
    {
        return imageId;
    }

    public void setImageId(String imageId)
    {
        this.imageId = imageId;
    }

    public byte[] getImageData()
    {
        return imageData;
    }

    public void setImageData(byte[] imageData)
    {
        this.imageData = imageData;
    }

    public Date getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }
}
