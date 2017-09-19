package scalehealth.scalev0.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLInput;


import scalehealth.scalev0.models.Patient;

/**
 * Created by mayank on 9/18/17.
 */

public class PatientDBService {
    private static SQLiteDatabase db;

    public long insert(Patient patient, DBHelper dbHelper) {          // returns primary key of recently inserted row.

        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ScaleContract.PatientInfo.COLUMN_DOC_ID, patient.getDoctorId());
        values.put(ScaleContract.PatientInfo.COLUMN_NAME, patient.getName());
        values.put(ScaleContract.PatientInfo.COLUMN_AGE, patient.getAge());
        values.put(ScaleContract.PatientInfo.COLUMN_SEX, patient.isSex());
        values.put(ScaleContract.PatientInfo.COLUMN_BLOOD_GROUP, patient.getBloodGroup());
        values.put(ScaleContract.PatientInfo.COLUMN_PHONE, patient.getPhone());
        values.put(ScaleContract.PatientInfo.COLUMN_PHOTO_ID, patient.getPhotoId());

        long newRowId = db.insert(ScaleContract.PatientInfo.TABLE_NAME, null, values);
        db.close();
        return newRowId;

    }

    public Cursor getAllRows(DBHelper dbHelper){
        db = dbHelper.getWritableDatabase();
        Cursor  cursor = db.rawQuery("select * from patient",null);
        return cursor;
    }
}
