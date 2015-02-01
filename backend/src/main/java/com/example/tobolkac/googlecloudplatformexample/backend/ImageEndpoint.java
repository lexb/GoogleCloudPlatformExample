package com.example.tobolkac.googlecloudplatformexample.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

import java.util.Date;
import java.util.logging.Logger;

import javax.inject.Named;

import static com.example.tobolkac.googlecloudplatformexample.backend.OfyService.ofy;

/**
 * Created by clayt on 2/1/15.
 */
@Api(name = "image", version = "v1", namespace = @ApiNamespace(ownerDomain = "backend.googlecloudplatformexample.tobolkac.example.com",
        ownerName = "backend.googlecloudplatformexample.tobolkac.example.com", packagePath = ""))
public class ImageEndpoint
{
    private static final Logger log = Logger.getLogger(RegistrationEndpoint.class.getName());

    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

    @ApiMethod(name = "saveImage")
    public void saveImage(@Named("imageId") String imageid, @Named("timestamp") Date timestamp, @Named("imageData") byte[] imageData)
    {
        ImageRecord record = new ImageRecord();
        //record.setImageId(image.get);
        ofy().save().entity(record).now();
    }
}
