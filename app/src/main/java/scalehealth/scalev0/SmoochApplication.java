package scalehealth.scalev0;

import android.app.Application;

import io.smooch.core.Smooch;

/**
 * Created by mayank on 9/11/17.
 */

public class SmoochApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Smooch.init(this, "02dtlsm8hi2b22woayehjsxk2");
    }
}
