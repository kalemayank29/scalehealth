package scalehealth.scalev0.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import scalehealth.scalev0.models.Doctor;

/**
 * Created by mayank on 9/16/17.
 */

public class DoctorDBService {
    private static SQLiteDatabase db;

    public void DoctorDBService() {
    }

    public long insert(Doctor doctor, DBHelper dbHelper) {          // returns primary key of recently inserted row.
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ScaleContract.DoctorInfo.COLUMN_ONCO, doctor.isOncologist());
        values.put(ScaleContract.DoctorInfo.COLUMN_LAT, doctor.getLatitude());
        values.put(ScaleContract.DoctorInfo.COLUMN_LONG, doctor.getLongitude());
        values.put(ScaleContract.DoctorInfo.COLUMN_NAME, doctor.getName());
        values.put(ScaleContract.DoctorInfo.COLUMN_PHONE, doctor.getPhone());
        values.put(ScaleContract.DoctorInfo.COLUMN_USERNAME, doctor.getUsername());
        values.put(ScaleContract.DoctorInfo.COLUMN_PASSWORD, doctor.getPassword());

        long newRowId = db.insert(ScaleContract.DoctorInfo.TABLE_NAME, null, values);
        db.close();
        return newRowId;
    }

    public Cursor getDoctorLogin(String username, String password, DBHelper dbHelper) {          // returns primary key of recently inserted row.
        db = dbHelper.getWritableDatabase();

        Log.e(username, password);

        String[] projection = {
                ScaleContract.DoctorInfo._ID,
                ScaleContract.DoctorInfo.COLUMN_USERNAME,
                ScaleContract.DoctorInfo.COLUMN_PASSWORD

        };

        String selection = ScaleContract.DoctorInfo.COLUMN_USERNAME + " = ?" + " AND " +
                ScaleContract.DoctorInfo.COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {username, password};

        // How you want the results sorted in the resulting Cursor
        String sortOrder = null;

        Cursor cursor = db.query(
                ScaleContract.DoctorInfo.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );
        Log.e("size",Integer.toString(cursor.getCount()));
        //db.close();
        return cursor;
    }

    public Cursor getAllRows(DBHelper dbHelper){
        db = dbHelper.getWritableDatabase();
        Cursor  cursor = db.rawQuery("select * from doctor",null);
        return cursor;
    }

}
