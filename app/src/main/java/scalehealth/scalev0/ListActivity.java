package scalehealth.scalev0;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import scalehealth.scalev0.data.DBHelper;
import scalehealth.scalev0.data.PatientDBService;
import scalehealth.scalev0.data.ScaleContract;
import scalehealth.scalev0.models.Patient;

public class ListActivity extends AppCompatActivity {

   private RecyclerView mRecyclerView;
   private LinearLayoutManager mLinearLayoutManager;
   private PatientRecyclerAdapter mAdapter;
    static PatientDBService patientDBService = new PatientDBService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        final DBHelper dbHelper = new DBHelper(getApplicationContext());
        Cursor patientCursor = patientDBService.getAllRows(dbHelper);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        ArrayList<Patient> patientList = new ArrayList<Patient>();
        if (patientCursor.moveToFirst()){
            do{
                Patient patientObj = new Patient();
                //TODO: Evaluate if this is the best option, incomplete class so dont have to load all the data for list.

                //patientObj.setName(patientCursor.getString(patientCursor.getColumnIndex("data")));
                patientObj.setName(patientCursor.getString(patientCursor.getColumnIndexOrThrow(ScaleContract.PatientInfo.COLUMN_NAME)));
                patientObj.setAge(patientCursor.getInt(patientCursor.getColumnIndexOrThrow(ScaleContract.PatientInfo.COLUMN_AGE)));
                patientObj.setSex(patientCursor.getInt(patientCursor.getColumnIndexOrThrow(ScaleContract.PatientInfo.COLUMN_SEX)));
                patientList.add(patientObj);
                // do what ever you want here
            }while(patientCursor.moveToNext());
        }
        patientCursor.close();
       /* patientList.add("Patient One");
        patientList.add("Patient Two");
        patientList.add("Patient Three");
        patientList.add("Patient Four");
        patientList.add("Patient Five");
        patientList.add("Patient Six");
        patientList.add("Patient Seven");*/

        mAdapter = new PatientRecyclerAdapter(patientList);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                Intent intent = new Intent(this, NewPatientActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_list:
                Intent listIntent = new Intent(this, ListActivity.class);
                startActivity(listIntent);
                finish();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
