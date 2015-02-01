package com.tobolkac.googlecloudplatformexample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tobolkac.googlecloudplatformexample.manager.ImageManager;
import com.tobolkac.googlecloudplatformexample.model.Image;

import io.realm.RealmResults;


public class MainActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    String[] data = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.image_recycler_view);


        // use a linear layout manager
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);



        //new GcmRegistrationAsyncTask(this).execute();
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        RealmResults<Image> images = ImageManager.getImages(this);
        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(this, images);

        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }
        if (id == R.id.action_camera)
        {
            Intent intent = new Intent(MainActivity.this, CameraFullScreenActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public static class MyAdapter extends RecyclerView.Adapter
    {
        private RealmResults<Image> mDataset;
        private Context context;

        public static class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public ImageView mImageView;
            public ViewHolder(View v) {
                super(v);
                mImageView = (ImageView) v.findViewById(R.id.image_list_image_view);
            }

        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter(Context context, RealmResults<Image> myDataset) {
            mDataset = myDataset;
            this.context = context;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.image_list_element, parent, false);


            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i)
        {
            final BitmapFactory.Options options = new BitmapFactory.Options();
//            options.inJustDecodeBounds = true;
//            BitmapFactory.decodeByteArray(mDataset.get(i).getImage(), 0, mDataset.get(i).getImage().length, options);
//
//            // Calculate inSampleSize
//            options.inSampleSize = calculateInSampleSize(options, ((ViewHolder) viewHolder).mImageView.getWidth(), ((ViewHolder) viewHolder).mImageView.getHeight());
//
//            // Decode bitmap with inSampleSize set
//            options.inJustDecodeBounds = false;
            Bitmap bitmap = BitmapFactory.decodeByteArray(mDataset.get(i).getImage(), 0, mDataset.get(i).getImage().length, options);
            ((ViewHolder) viewHolder).mImageView.setImageBitmap(bitmap);
            ((ViewHolder) viewHolder).mImageView.setTag(mDataset.get(i).getImageId());

            ((ViewHolder) viewHolder).mImageView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    showImagePreviewDialog((String) v.getTag());
                }
            });
        }

        private void showImagePreviewDialog(String imageId)
        {
            ImagePreviewDialog.newInstance(imageId).show(((Activity) context).getFragmentManager(), "");
        }

        private int calculateInSampleSize(
                BitmapFactory.Options options, int reqWidth, int reqHeight) {
            // Raw height and width of image
            final int height = options.outHeight;
            final int width = options.outWidth;
            int inSampleSize = 1;

            if (height > reqHeight || width > reqWidth) {

                final int halfHeight = height / 2;
                final int halfWidth = width / 2;

                // Calculate the largest inSampleSize value that is a power of 2 and keeps both
                // height and width larger than the requested height and width.
                while ((halfHeight / inSampleSize) > reqHeight
                        && (halfWidth / inSampleSize) > reqWidth) {
                    inSampleSize *= 2;
                }
            }

            return inSampleSize;
        }


        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.size();
        }
    }

}
