package com.example.david.matibabu;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import static android.support.test.espresso.Espresso.onView;
import com.example.david.matibabu.listpatient.PatientListActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by david on 4/2/18.
 */
@RunWith(AndroidJUnit4.class)
public class RecycleViewTest {

    @Rule()
    public ActivityTestRule<PatientListActivity> mRule =
            new ActivityTestRule<PatientListActivity>(PatientListActivity.class);


}
