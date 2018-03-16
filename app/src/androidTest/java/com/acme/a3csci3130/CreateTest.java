package com.acme.a3csci3130;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.GeneralClickAction;
import android.support.test.espresso.action.GeneralLocation;
import android.support.test.rule.ActivityTestRule;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.Press;
import android.support.test.espresso.action.Tap;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import org.junit.Rule;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Yide on 2018/3/15.
 */

public class CreateTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.acme.a3csci3130", appContext.getPackageName());
    }

    @Rule
    public final ActivityTestRule<MainActivity> main = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testCreate() throws Exception {
        onView(withId(R.id.submitButton)).perform(new GeneralClickAction(Tap.SINGLE, GeneralLocation.CENTER, Press.FINGER));
        onView(withId((R.id.name))).perform(click()).perform(typeText("asdw"));
        onView(withId((R.id.email))).perform(click()).perform(typeText("asdasd@dal.ca"));
        onView(withId((R.id.Bnumber))).perform(click()).perform(typeText("123456789"));
        onView(withId((R.id.address))).perform(click()).perform(typeText("21 stasd st"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.submitButton)).perform(new GeneralClickAction(Tap.SINGLE, GeneralLocation.CENTER, Press.FINGER));
    }
}
