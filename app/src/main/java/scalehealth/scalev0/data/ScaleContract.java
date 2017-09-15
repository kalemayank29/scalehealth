package scalehealth.scalev0.data;

import android.provider.BaseColumns;

/**
 * Created by mayank on 9/13/17.
 */

public class ScaleContract {

    public static final class DoctorInfo implements BaseColumns{
        public static final String TABLE_NAME = "doctor";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String COLUMN_ONCO = "onco";
        public static final String COLUMN_LAT = "lat";  //latitude
        public static final String COLUMN_LONG = "long"; //longitude
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PHONE = "phone";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_PASSWORD = "password";
    }

    public static final class PatientInfo implements BaseColumns{
        public static final String TABLE_NAME = "patient";
        public static final String COLUMN_DOC_ID = "doctor_id";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_AGE = "age";
        public static final String COLUMN_SEX = "sex";
        public static final String COLUMN_BLOOD_GROUP = "blood_group";
        public static final String COLUMN_PHONE = "phone";
        public static final String COLUMN_PHOTO_ID = "photo_id";
        public static final String COLUMN_NOTE = "note";
    }
}
