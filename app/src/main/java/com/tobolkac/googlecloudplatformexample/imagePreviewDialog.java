package com.tobolkac.googlecloudplatformexample;

import android.app.DialogFragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tobolkac.googlecloudplatformexample.manager.ImageManager;
import com.tobolkac.googlecloudplatformexample.model.Image;

/**
 * Created by clayt on 1/31/15.
 */
public class ImagePreviewDialog extends DialogFragment
{

    private static final String IMAGE_ID_KEY = "ImageIdKey";

    public static ImagePreviewDialog newInstance(String imageId)
    {
        ImagePreviewDialog dialog = new ImagePreviewDialog();
        Bundle b = new Bundle();
        b.putString(IMAGE_ID_KEY, imageId);
        dialog.setArguments(b);
        return dialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        int style=DialogFragment.STYLE_NO_TITLE;
        int theme=android.R.style.Theme_Translucent;
        setStyle(style, theme);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.image_preview_dialog, container, false);

        String imageId = getArguments().getString(IMAGE_ID_KEY);

        ImageView image =  (ImageView) v.findViewById(R.id.image_preview);

        Image i = ImageManager.getImage(getActivity(), imageId);

        Bitmap bitmap = BitmapFactory.decodeByteArray(i.getImage(), 0, i.getImage().length);
        image.setImageBitmap(bitmap);

        return v;
    }
}
