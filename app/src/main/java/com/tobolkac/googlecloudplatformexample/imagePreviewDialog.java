package com.tobolkac.googlecloudplatformexample;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by clayt on 1/31/15.
 */
public class ImagePreviewDialog extends DialogFragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.image_preview_dialog, container, false);

        ImageView image =  (ImageView) v.findViewById(R.id.image_list_image_view);



        return v;
    }
}
