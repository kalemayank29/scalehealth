package scalehealth.scalev0;

import android.content.Intent;
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
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;

import scalehealth.scalev0.data.DBHelper;
import scalehealth.scalev0.data.PatientDBService;
import scalehealth.scalev0.models.Patient;

public class ImageDisplayActivity extends AppCompatActivity {

    static ImageView image;
    Button save;
    static PatientDBService patientDBService = new PatientDBService();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_display);

        image = (ImageView) findViewById(R.id.img);
        save = findViewById(R.id.save);

        final DBHelper dbHelper = new DBHelper(getApplicationContext());

        Bundle extras = getIntent().getExtras();
        String mCurrentPhotoPath = extras.getString("imgURI");
        final Patient newPatient = (Patient) extras.getSerializable("patient");
        Log.e(newPatient.getName(),newPatient.getPhone());
        File file = new File(mCurrentPhotoPath);
        Uri uri = Uri.fromFile(file);
        newPatient.setPhotoId(uri.toString());
        Picasso.with(getApplicationContext()).load(uri).resize(1200,800).into(image);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    Long rowID = patientDBService.insert(newPatient, dbHelper);
                    Intent intent = new Intent(ImageDisplayActivity.this, ListActivity.class);
                    startActivity(intent);
                }
                catch(Exception e){
                    e.printStackTrace();
                }


            }
        });

    }




}
