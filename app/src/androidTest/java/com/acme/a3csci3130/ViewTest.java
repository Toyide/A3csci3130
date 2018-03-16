package com.acme.a3csci3130;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.GeneralClickAction;
import android.support.test.espresso.action.GeneralLocation;
import android.support.test.espresso.action.Press;
import android.support.test.espresso.action.Tap;
import android.support.test.rule.ActivityTestRule;
import android.widget.ListView;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.containsString;


/**
 * Created by Yide on 2018/3/15.
 */

public class ViewTest {

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.acme.a3csci3130", appContext.getPackageName());
    }

    @Rule
    public final ActivityTestRule<MainActivity> main = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testView() throws Exception {
        onView(withId(R.id.listView));
        onData(anything()).inAdapterView(allOf(withId(R.id.listView),isCompletelyDisplayed())).atPosition(0).perform(click());
        onView(withId((R.id.name))).check(matches(withText("asdw")));
        onView(withId((R.id.email))).check(matches(withText("asdasd@dal.ca")));
        onView(withId((R.id.Bnumber))).check(matches(withText("123456789")));
        onView(withId((R.id.address))).check(matches(withText("21 stasd st")));
        onView(withId(R.id.Brole)).perform(click());
        onData(anything()).atPosition(0).perform(click());
        onView(withId(R.id.Brole)).check(matches(withSpinnerText(containsString("Fisher"))));
        onView(withId(R.id.province)).perform(click());
        onData(anything()).atPosition(0).perform(click());
        onView(withId(R.id.province)).check(matches(withSpinnerText(containsString("NS"))));
    }
}