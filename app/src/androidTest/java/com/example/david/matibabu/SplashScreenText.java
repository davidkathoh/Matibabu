package com.example.david.matibabu;




import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import static android.support.test.espresso.Espresso.onView;
import com.example.david.matibabu.introscreen.IntroScreen;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


/**
 * Created by david on 3/31/18.
 */
@RunWith(AndroidJUnit4.class)
public class SplashScreenText {
    @Rule
    public ActivityTestRule<IntroScreen> mScreenActivityTestRule
            = new ActivityTestRule<IntroScreen>(IntroScreen.class);
    @Test
    public void open_signup() throws Exception{
        onView(withId(R.id.signup)).perform(click())

                ;
    }
}
