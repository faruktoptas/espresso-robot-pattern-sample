package com.example.espressorobot;

import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.runner.lifecycle.Stage;
import android.util.Log;

import com.jraska.falcon.FalconSpoonRule;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by ftoptas on 04/01/18.
 */

public class TestUtils {

    public static Activity getCurrentActivity() {
        final Activity[] currentActivity = {null};
        InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable() {
            public void run() {
                Collection<Activity> resumedActivity = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED);
                Iterator<Activity> it = resumedActivity.iterator();
                currentActivity[0] = it.next();
            }
        });

        return currentActivity[0];
    }

    public static void screenShot(FalconSpoonRule rule, String tag) {
        rule.screenshot(getCurrentActivity(), tag);
        Log.i("asd", "Screenshot taken: " + tag);
    }
}
