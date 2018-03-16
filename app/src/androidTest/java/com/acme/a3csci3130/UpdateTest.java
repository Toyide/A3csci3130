package com.acme.a3csci3130;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.GeneralClickAction;
import android.support.test.espresso.action.GeneralLocation;
import android.support.test.rule.ActivityTestRule;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.Press;
import android.support.test.espresso.action.Tap;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import org.junit.Rule;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.anything;

/**
 * Created by Yide on 2018/3/15.
 */

public class UpdateTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.acme.a3csci3130", appContext.getPackageName());
    }

    @Rule
    public final ActivityTestRule<MainActivity> main = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testUpdate() throws Exception {
        onView(withId((R.id.listView)));
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId((R.id.email))).perform(click()).perform(replaceText("1111111111111@dal.ca"));;
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.updateButton)).perform(new GeneralClickAction(Tap.SINGLE, GeneralLocation.CENTER, Press.FINGER));

    }
}