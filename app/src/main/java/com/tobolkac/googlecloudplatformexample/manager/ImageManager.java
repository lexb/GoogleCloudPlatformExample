package com.tobolkac.googlecloudplatformexample.manager;

import android.content.Context;

import com.tobolkac.googlecloudplatformexample.model.Image;

import java.util.Date;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by clayt on 1/31/15.
 */
public class ImageManager
{

    public static void saveImage(Context context, byte[] imageData)
    {
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        Image image = realm.createObject(Image.class);

        image.setImageId(UUID.randomUUID().toString());
        image.setTimestamp(new Date());
        image.setImage(imageData);

        realm.commitTransaction();
    }

    public static RealmResults<Image> getImages(Context context)
    {
        Realm realm = Realm.getInstance(context);
        RealmQuery<Image> query = realm.where(Image.class);

        // Execute the query:
        RealmResults<Image> result1 = query.findAll();
        result1.sort("timestamp");
        return result1;
    }

    public static Image getImage(Context context, String imageId)
    {
        Realm realm = Realm.getInstance(context);
        RealmQuery<Image> query = realm.where(Image.class);

        query.equalTo("imageId", imageId);

        // Execute the query:
        RealmResults<Image> result1 = query.findAll();
        return result1.get(0);
    }


}
