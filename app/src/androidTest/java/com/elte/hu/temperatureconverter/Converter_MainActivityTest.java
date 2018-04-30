package com.elte.hu.temperatureconverter;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

import com.elte.hu.temperatureconverter.Converter_Main;
import com.elte.hu.temperatureconverter.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class Converter_MainActivityTest {

    @Rule
    public ActivityTestRule<Converter_Main> mActivityTestRule = new ActivityTestRule<>(Converter_Main.class);

    @Test
    public void converter_celsus_to_farenheit() {


        ViewInteraction appCompatEditText2= onView(withId(R.id.temperatureValue));

        appCompatEditText2.perform(replaceText("27"), closeSoftKeyboard());

        ViewInteraction appCompatRadioButton= onView(withId(R.id.cTofRadio));

        appCompatRadioButton.perform(click());

        ViewInteraction appCompatButton= onView(withId(R.id.convertBtn));

        appCompatButton.perform(click());




       ViewInteraction editText= onView(withId(R.id.temperatureValue));
       editText.check(matches(withText("80.6")));

    }




    @Test
    public void converter_fareinheit_to_celsius() {


        ViewInteraction appCompatEditText2= onView(withId(R.id.temperatureValue));

        appCompatEditText2.perform(replaceText("68"), closeSoftKeyboard());

        ViewInteraction appCompatRadioButton= onView(withId(R.id.fTocRadio));

        appCompatRadioButton.perform(click());

        ViewInteraction appCompatButton= onView(withId(R.id.convertBtn));

        appCompatButton.perform(click());




        ViewInteraction editText= onView(withId(R.id.temperatureValue));
        editText.check(matches(withText("20.0")));

    }




    @Test
    public void two_Operations() {
        //Entering first value
        ViewInteraction appCompatEditText = onView(withId(R.id.temperatureValue));
        appCompatEditText.perform(replaceText("68"), closeSoftKeyboard());

        //choosinh celsius to farenheit
        ViewInteraction appCompatRadioButton = onView(withId(R.id.cTofRadio));
        appCompatRadioButton.perform(click());

        //press convert
        ViewInteraction appCompatButton = onView(withId(R.id.convertBtn));
        appCompatButton.perform(click());

        //change farenheit to celsius
        ViewInteraction appCompatRadioButton2 = onView(withId(R.id.fTocRadio));
        appCompatRadioButton2.perform(click());

        //press convert again
        ViewInteraction appCompatButton2 = onView(withId(R.id.convertBtn));
        appCompatButton2.perform(click());

        // check if we obtain the same value on the screen
        ViewInteraction editText= onView(withId(R.id.temperatureValue));
        editText.check(matches(withText("68.0")));

    }



    @Test
    public void reset() {
        //press on the text screen
        ViewInteraction appCompatEditText = onView(withId(R.id.temperatureValue));
        appCompatEditText.perform(click());


        //Entering first value
        ViewInteraction appCompatEditText2 = onView(withId(R.id.temperatureValue));
        appCompatEditText2.perform(replaceText("50"), closeSoftKeyboard());

        //press reset button
        ViewInteraction appCompatButton = onView(withId(R.id.resetBtn));
        appCompatButton.perform(click());


        //Entering another value
        ViewInteraction appCompatEditText3 = onView(withId(R.id.temperatureValue));
        appCompatEditText3.perform(replaceText("40"), closeSoftKeyboard());

        //choosinh celsius to farenheit
        ViewInteraction appCompatRadioButton = onView(withId(R.id.cTofRadio));
        appCompatRadioButton.perform(click());

        //press convert
        ViewInteraction appCompatButton2 = onView(withId(R.id.convertBtn));
        appCompatButton2.perform(click());

        // check if we obtain the correct value on the screen
        ViewInteraction editText= onView(withId(R.id.temperatureValue));
        editText.check(matches(withText("104.0")));
    }


    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
