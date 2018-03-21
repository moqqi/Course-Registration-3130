package com.example.csci3130_baseproject;

/**
 * Created by raghdakashgari on 2018-03-21.
 */
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;



@RunWith(AndroidJUnit4.class)
public class DailyScheduleUI_ETest{
    private String mStringToBetyped;


    @Rule
    public ActivityTestRule <MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void init(){
        mActivityRule.getActivity().getSupportFragmentManager().beginTransaction();
    }

    @Test
    public void displayingSchedule_test() {
        // Type text and then press the button.
        onView(withId(R.id.button2)).perform(click()); //R.id.button2
        onView(withId(R.id.textView1)).check(matches(isDisplayed()));
    }
}
