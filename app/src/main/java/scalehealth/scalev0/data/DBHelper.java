package scalehealth.scalev0.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mayank on 9/13/17.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "scale.db";
    public static final int DATABASE_VERSION = 1;

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_DOCTOR_TABLE = " CREATE TABLE " +
                ScaleContract.DoctorInfo.TABLE_NAME + " ( " +
                ScaleContract.DoctorInfo._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ScaleContract.DoctorInfo.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                ScaleContract.DoctorInfo.COLUMN_ONCO + " BOOLEAN NOT NULL," +
                ScaleContract.DoctorInfo.COLUMN_LAT + " FLOAT," +
                ScaleContract.DoctorInfo.COLUMN_LONG + " FLOAT," +
                ScaleContract.DoctorInfo.COLUMN_NAME + " TEXT NOT NULL," +
                ScaleContract.DoctorInfo.COLUMN_PHONE + " TEXT NOT NULL," +
                ScaleContract.DoctorInfo.COLUMN_USERNAME + " TEXT NOT NULL," +
                ScaleContract.DoctorInfo.COLUMN_PASSWORD + " TEXT NOT NULL" +
                ");";

        final String SQL_CREATE_PATIENT_TABLE = "CREATE TABLE " +
                ScaleContract.PatientInfo.TABLE_NAME + " ( " +
                ScaleContract.PatientInfo._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ScaleContract.PatientInfo.COLUMN_DOC_ID + " INTEGER NOT NULL," +
                ScaleContract.PatientInfo.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                ScaleContract.PatientInfo.COLUMN_NAME + " TEXT NOT NULL," +
                ScaleContract.PatientInfo.COLUMN_AGE + " INTEGER NOT NULL," +
                ScaleContract.PatientInfo.COLUMN_SEX + " INTEGER NOT NULL," +
                ScaleContract.PatientInfo.COLUMN_BLOOD_GROUP + " TEXT NOT NULL," +
                ScaleContract.PatientInfo.COLUMN_PHONE + " TEXT NOT NULL," +
                ScaleContract.PatientInfo.COLUMN_PHOTO_ID + " TEXT NOT NULL," +
                ScaleContract.PatientInfo.COLUMN_NOTE + " LONGTEXT" +
                ");";


        sqLiteDatabase.execSQL(SQL_CREATE_DOCTOR_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_PATIENT_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ScaleContract.DoctorInfo.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
