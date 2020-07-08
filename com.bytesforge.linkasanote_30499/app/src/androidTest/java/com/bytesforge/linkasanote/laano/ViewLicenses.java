package com.bytesforge.linkasanote.laano;


import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

import com.bytesforge.linkasanote.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ViewLicenses {

    @Rule
    public ActivityTestRule<LaanoActivity> mActivityTestRule = new ActivityTestRule<>(LaanoActivity.class);

    @Test
    public void viewLicenses() {
        ViewInteraction appCompatImageButton = onView(
allOf(withContentDescription("Navigate up"),
childAtPosition(
allOf(withId(R.id.toolbar),
childAtPosition(
withId(R.id.app_bar_layout),
0)),
1),
isDisplayed()));
        appCompatImageButton.perform(click());
        
        ViewInteraction navigationMenuItemView = onView(
allOf(childAtPosition(
allOf(withId(R.id.design_navigation_view),
childAtPosition(
withId(R.id.nav_view),
0)),
7),
isDisplayed()));
        navigationMenuItemView.perform(click());
        
        ViewInteraction appCompatButton = onView(
allOf(withId(R.id.license_terms_gpl_v3), withText("license terms"),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.LinearLayout")),
7),
0)));
        appCompatButton.perform(scrollTo(), click());
        
        ViewInteraction appCompatButton2 = onView(
allOf(withId(android.R.id.button1), withText("OK"),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.ScrollView")),
0),
3)));
        appCompatButton2.perform(scrollTo(), click());
        
        ViewInteraction appCompatButton3 = onView(
allOf(withId(R.id.license_terms_apache_v2), withText("license terms"),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.LinearLayout")),
11),
0)));
        appCompatButton3.perform(scrollTo(), click());
        
        ViewInteraction appCompatButton4 = onView(
allOf(withId(android.R.id.button1), withText("OK"),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.ScrollView")),
0),
3)));
        appCompatButton4.perform(scrollTo(), click());
        
        ViewInteraction appCompatButton5 = onView(
allOf(withId(R.id.license_terms_mit), withText("license terms"),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.LinearLayout")),
14),
0)));
        appCompatButton5.perform(scrollTo(), click());
        
        ViewInteraction appCompatButton6 = onView(
allOf(withId(android.R.id.button1), withText("OK"),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.ScrollView")),
0),
3)));
        appCompatButton6.perform(scrollTo(), click());
        
        ViewInteraction appCompatImageButton2 = onView(
allOf(withContentDescription("Navigate up"),
childAtPosition(
allOf(withId(R.id.toolbar),
childAtPosition(
withClassName(is("android.support.design.widget.AppBarLayout")),
0)),
1),
isDisplayed()));
        appCompatImageButton2.perform(click());
        
        pressBack();
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
                        && view.equals(((ViewGroup)parent).getChildAt(position));
            }
        };
    }
    }
