package com.bytesforge.linkasanote.laano;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.bytesforge.linkasanote.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ClearClipboardTest {

    @Rule
    public ActivityTestRule<LaanoActivity> mActivityTestRule = new ActivityTestRule<>(LaanoActivity.class);

    @Test
    public void clearClipboardTest() {
        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab_add),
                        childAtPosition(
                                allOf(withId(R.id.coordinator_layout),
                                        childAtPosition(
                                                withId(R.id.drawer_layout),
                                                0)),
                                2),
                        isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.link_link),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.design.widget.TextInputLayout")),
                                        0),
                                0)));
        appCompatEditText.perform(scrollTo(), replaceText("CopyMe"), closeSoftKeyboard());

        ViewInteraction appCompatCheckBox = onView(
                allOf(withId(R.id.checkbox_disabled),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                1)));
        appCompatCheckBox.perform(scrollTo(), click());

        ViewInteraction linearLayout = onView(
                allOf(withContentDescription("Copy"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        0),
                                1),
                        isDisplayed()));
        linearLayout.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.link_name),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.design.widget.TextInputLayout")),
                                        0),
                                0)));
        appCompatEditText2.perform(scrollTo(), click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.link_name),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.design.widget.TextInputLayout")),
                                        0),
                                0)));
        appCompatEditText3.perform(scrollTo(), longClick());

        ViewInteraction linearLayout2 = onView(
                allOf(withContentDescription("Paste"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        1),
                                0),
                        isDisplayed()));
        linearLayout2.perform(click());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.link_name),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.design.widget.TextInputLayout")),
                                        0),
                                0)));
        appCompatEditText4.perform(scrollTo(), replaceText("CopyMe"), closeSoftKeyboard());

        ViewInteraction editText = onView(
                allOf(withId(R.id.link_name), withText("CopyMe"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        editText.check(matches(withText("CopyMe")));

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.AppBarLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        pressBack();

        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.fab_add),
                        childAtPosition(
                                allOf(withId(R.id.coordinator_layout),
                                        childAtPosition(
                                                withId(R.id.drawer_layout),
                                                0)),
                                2),
                        isDisplayed()));
        floatingActionButton2.perform(click());

        ViewInteraction tagsCompletionView = onView(
                allOf(withId(R.id.link_tags),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.link_tags_layout),
                                        0),
                                0)));
        tagsCompletionView.perform(scrollTo(), click());

        ViewInteraction tagsCompletionView2 = onView(
                allOf(withId(R.id.link_tags),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.link_tags_layout),
                                        0),
                                0)));
        tagsCompletionView2.perform(scrollTo(), click());

        ViewInteraction tagsCompletionView3 = onView(
                allOf(withId(R.id.link_tags),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.link_tags_layout),
                                        0),
                                0)));
        tagsCompletionView3.perform(scrollTo(), click());

        ViewInteraction tagsCompletionView4 = onView(
                allOf(withId(R.id.link_tags),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.link_tags_layout),
                                        0),
                                0)));
        tagsCompletionView4.perform(scrollTo(), click());

        ViewInteraction tagsCompletionView5 = onView(
                allOf(withId(R.id.link_tags),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.link_tags_layout),
                                        0),
                                0)));
        tagsCompletionView5.perform(scrollTo(), click());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.link_link),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.design.widget.TextInputLayout")),
                                        0),
                                0)));
        appCompatEditText5.perform(scrollTo(), longClick());

        ViewInteraction linearLayout3 = onView(
                allOf(withContentDescription("Paste"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        1),
                                0),
                        isDisplayed()));
        linearLayout3.perform(click());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.link_link),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.design.widget.TextInputLayout")),
                                        0),
                                0)));
        appCompatEditText6.perform(scrollTo(), replaceText("CopyMe"), closeSoftKeyboard());

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.link_link), withText("CopyMe"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        editText2.check(matches(withText("CopyMe")));

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

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.title), withText("Clear clipboard"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction floatingActionButton3 = onView(
                allOf(withId(R.id.fab_add),
                        childAtPosition(
                                allOf(withId(R.id.coordinator_layout),
                                        childAtPosition(
                                                withId(R.id.drawer_layout),
                                                0)),
                                2),
                        isDisplayed()));
        floatingActionButton3.perform(click());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.link_link),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.design.widget.TextInputLayout")),
                                        0),
                                0)));
        appCompatEditText7.perform(scrollTo(), longClick());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.link_link),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.design.widget.TextInputLayout")),
                                        0),
                                0)));
        appCompatEditText8.perform(scrollTo(), longClick());

        ViewInteraction linearLayout4 = onView(
                allOf(withContentDescription("Paste"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        1),
                                0),
                        isDisplayed()));
        linearLayout4.perform(click());

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.link_link), withText("*Link"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        editText3.check(matches(withText("*Link")));
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
