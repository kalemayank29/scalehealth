package scalehealth.scalev0;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;

public class ImageDisplayActivity extends AppCompatActivity {

    static ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_display);

        image = (ImageView) findViewById(R.id.img);
        Bundle extras = getIntent().getExtras();

        String mCurrentPhotoPath = extras.getString("imgURI");
        Log.e("Photo @@" , mCurrentPhotoPath);
        File file = new File(mCurrentPhotoPath);
        Uri uri = Uri.fromFile(file);

        Picasso.with(getApplicationContext()).load(uri).resize(1200,800).into(image);
        //image.setImageBitmap(bmp);
        //
        //image.setImageURI(uri);
    }


}
