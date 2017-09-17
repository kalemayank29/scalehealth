package scalehealth.scalev0;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import scalehealth.scalev0.data.DBHelper;
import scalehealth.scalev0.data.DoctorDBService;
import scalehealth.scalev0.data.ScaleContract;
import scalehealth.scalev0.models.Doctor;

public class LoginActivity extends AppCompatActivity {

    TextView usernameView, passwordView;
    String username, password;
    Button loginButton;
    static DoctorDBService doctorDBService = new DoctorDBService();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameView = findViewById(R.id.username);
        passwordView = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);
        final DBHelper dbHelper = new DBHelper(getApplicationContext());

       // Doctor dinesh = new Doctor(true,19.07,72.88,"Dinesh Pendharkar","9822559901","dinesh","aci");
        //Log.e("rowID",Long.toString(doctorDBService.insert(dinesh, dbHelper )));

        /*Cursor cursor = doctorDBService.getAllRows(dbHelper);
        Log.e("size",Integer.toString(cursor.getCount()));
        if (cursor.moveToFirst()){
            String username = cursor.getString(cursor.getColumnIndexOrThrow(ScaleContract.DoctorInfo.COLUMN_USERNAME));
            String password = cursor.getString(cursor.getColumnIndexOrThrow(ScaleContract.DoctorInfo.COLUMN_PASSWORD));

            Log.e(username,password);
        }*/

        //Log.e("total count",Integer.toString(doctorDBService.getRowCount(dbHelper)));
        //Doctor dinesh = new Doctor(true,19.07,72.88,"Dinesh Pendharkar","9822559901","dinesh","aci");
        //Log.e("rowID",Long.toString(doctorDBService.insert(dinesh, dbHelper )));



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Long id = 0L;
               username = usernameView.getText().toString();
               password = passwordView.getText().toString();

               Cursor cursor = doctorDBService.getDoctorLogin(username, password, dbHelper);

                if (cursor.moveToFirst()){
                        id = cursor.getLong(cursor.getColumnIndexOrThrow(ScaleContract.DoctorInfo._ID));
                      //  Log.e("Dinesh Id",Long.toString(id));
                }
                cursor.close();

                Intent patientList = new Intent(LoginActivity.this, ListActivity.class);
                if(id > 0) {
                    startActivity(patientList);
                    finish();
                }
                else {
                    AlertDialog alertDialog = new AlertDialog.Builder(LoginActivity.this).create();
                    alertDialog.setTitle("Not Found!");
                    alertDialog.setMessage("Username and Password could not be matched.");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();

                }

            }
        });



    }
}
