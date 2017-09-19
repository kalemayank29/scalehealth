package scalehealth.scalev0;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NavUtils;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import scalehealth.scalev0.models.Patient;


/*
 private void galleryAddPic() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(mCurrentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }

 */

// android:src="@android:drawable/ic_menu_gallery"

public class NewPatientActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    Button photoId;
    EditText name, age, bloodGroup, phone;
    String mCurrentPhotoPath;
    static ImageView imgId;
    Patient newPatient;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_patient);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        newPatient = new Patient();
        photoId = (Button) findViewById(R.id.camera);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        bloodGroup = findViewById(R.id.blood_group);
        phone = findViewById(R.id.phone);

        photoId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newPatient.setName(name.getText().toString());
                newPatient.setAge(Integer.parseInt(age.getText().toString()));
                newPatient.setBloodGroup(bloodGroup.getText().toString());
                newPatient.setPhone(phone.getText().toString());
                dispatchTakePictureIntent();
            }
        });




    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        verifyStoragePermissions(this);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            //Log.e("here","here");
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
                ex.printStackTrace();
                Log.e("Error","Error creating the file");
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {

                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                //galleryAddPic();
                addImageToGallery(getApplicationContext());


            }
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.male:
                if (checked)
                    newPatient.setSex(0);
                    break;
            case R.id.female:
                if (checked)
                    newPatient.setSex(1);
                    // Ninjas rule
                    break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /*File imgFile = new  File(mCurrentPhotoPath);
        if(imgFile.exists()) {
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            ImageView myImage = (ImageView) findViewById(R.id.img_id);
            myImage.setImageBitmap(myBitmap);
        }*/

        //Log.e(newPatient.getName(),newPatient.getPhone());

        //TODO: Store patients here?? or pass key-value pairs to next activity.

        Intent intent = new Intent(this,ImageDisplayActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("patient", newPatient);
        intent.putExtras(bundle);
        intent.putExtra("imgURI",mCurrentPhotoPath);
        startActivity(intent);
    }


    public void addImageToGallery(final Context context) {

        ContentValues values = new ContentValues();

        values.put(MediaStore.Images.Media.DATE_TAKEN, System.currentTimeMillis());
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
        values.put(MediaStore.MediaColumns.DATA, mCurrentPhotoPath);

        context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());  // Change to patientId + timestamp
        String imageFileName = "JPEG_" + timeStamp + "_";
        //File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);       //Files made available to the gallery.
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        Log.e("Photo path", mCurrentPhotoPath);
        return image;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
