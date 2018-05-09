package com.example.david.matibabu;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import com.example.david.matibabu.home.HomeActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by david on 4/5/18.
 */
@RunWith(AndroidJUnit4.class)
public class HomeSreenText {

    @Rule
    public ActivityTestRule<HomeActivity> mHomeActivityActivityTestRule
            = new ActivityTestRule<HomeActivity>(HomeActivity.class);

    @Test
    public void textTime() throws Exception{
        onView(withId(R.id.txt_date)).perform(click());


    }


}
