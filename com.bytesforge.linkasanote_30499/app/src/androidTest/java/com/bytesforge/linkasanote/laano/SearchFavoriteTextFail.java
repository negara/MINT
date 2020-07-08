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
public class SearchFavoriteTextFail {

    @Rule
    public ActivityTestRule<LaanoActivity> mActivityTestRule = new ActivityTestRule<>(LaanoActivity.class);

    @Test
    public void searchFavoriteTextFail() {
        ViewInteraction tabView = onView(
allOf(withContentDescription("Favorites"),
childAtPosition(
childAtPosition(
withId(R.id.tab_layout),
0),
1),
isDisplayed()));
        tabView.perform(click());
        
        ViewInteraction viewPager = onView(
allOf(withId(R.id.laano_view_pager),
childAtPosition(
childAtPosition(
withId(R.id.coordinator_layout),
1),
0),
isDisplayed()));
        viewPager.perform(swipeLeft());
        
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
allOf(withId(R.id.favorite_name),
childAtPosition(
childAtPosition(
withClassName(is("android.support.design.widget.TextInputLayout")),
0),
0)));
        appCompatEditText.perform(scrollTo(), replaceText("Spot"), closeSoftKeyboard());
        
        ViewInteraction tagsCompletionView = onView(
allOf(withId(R.id.favorite_tags),
childAtPosition(
childAtPosition(
withId(R.id.favorite_tags_layout),
0),
0)));
        tagsCompletionView.perform(scrollTo(), click());
        
        ViewInteraction tagsCompletionView2 = onView(
allOf(withId(R.id.favorite_tags),
childAtPosition(
childAtPosition(
withId(R.id.favorite_tags_layout),
0),
0)));
        tagsCompletionView2.perform(scrollTo(), replaceText("dog"), closeSoftKeyboard());
        
        ViewInteraction tagsCompletionView3 = onView(
allOf(withId(R.id.favorite_tags), withText("dog"),
childAtPosition(
childAtPosition(
withId(R.id.favorite_tags_layout),
0),
0)));
        tagsCompletionView3.perform(pressImeActionButton());
        
        ViewInteraction tagsCompletionView4 = onView(
allOf(withId(R.id.favorite_tags), withText(",, "),
childAtPosition(
childAtPosition(
withId(R.id.favorite_tags_layout),
0),
0)));
        tagsCompletionView4.perform(scrollTo(), replaceText(",, animal"));
        
        ViewInteraction tagsCompletionView5 = onView(
allOf(withId(R.id.favorite_tags), withText(",, animal"),
childAtPosition(
childAtPosition(
withId(R.id.favorite_tags_layout),
0),
0),
isDisplayed()));
        tagsCompletionView5.perform(closeSoftKeyboard());
        
        ViewInteraction tagsCompletionView6 = onView(
allOf(withId(R.id.favorite_tags), withText(",, animal"),
childAtPosition(
childAtPosition(
withId(R.id.favorite_tags_layout),
0),
0)));
        tagsCompletionView6.perform(pressImeActionButton());
        
        ViewInteraction appCompatCheckBox = onView(
allOf(withId(R.id.checkbox_and_gate),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.LinearLayout")),
1),
1)));
        appCompatCheckBox.perform(scrollTo(), click());
        
        ViewInteraction appCompatButton = onView(
allOf(withId(R.id.add_button), withText("Create"),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.ScrollView")),
0),
3)));
        appCompatButton.perform(scrollTo(), click());
        
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
        
        ViewInteraction appCompatEditText2 = onView(
allOf(withId(R.id.favorite_name),
childAtPosition(
childAtPosition(
withClassName(is("android.support.design.widget.TextInputLayout")),
0),
0)));
        appCompatEditText2.perform(scrollTo(), replaceText("Purr"), closeSoftKeyboard());
        
        ViewInteraction tagsCompletionView7 = onView(
allOf(withId(R.id.favorite_tags),
childAtPosition(
childAtPosition(
withId(R.id.favorite_tags_layout),
0),
0)));
        tagsCompletionView7.perform(scrollTo(), click());
        
        ViewInteraction tagsCompletionView8 = onView(
allOf(withId(R.id.favorite_tags),
childAtPosition(
childAtPosition(
withId(R.id.favorite_tags_layout),
0),
0)));
        tagsCompletionView8.perform(scrollTo(), replaceText("cat"), closeSoftKeyboard());
        
        ViewInteraction tagsCompletionView9 = onView(
allOf(withId(R.id.favorite_tags), withText("cat"),
childAtPosition(
childAtPosition(
withId(R.id.favorite_tags_layout),
0),
0)));
        tagsCompletionView9.perform(pressImeActionButton());
        
        ViewInteraction tagsCompletionView10 = onView(
allOf(withId(R.id.favorite_tags), withText(",, "),
childAtPosition(
childAtPosition(
withId(R.id.favorite_tags_layout),
0),
0)));
        tagsCompletionView10.perform(scrollTo(), replaceText(",, animal"));
        
        ViewInteraction tagsCompletionView11 = onView(
allOf(withId(R.id.favorite_tags), withText(",, animal"),
childAtPosition(
childAtPosition(
withId(R.id.favorite_tags_layout),
0),
0),
isDisplayed()));
        tagsCompletionView11.perform(closeSoftKeyboard());
        
        ViewInteraction tagsCompletionView12 = onView(
allOf(withId(R.id.favorite_tags), withText(",, animal"),
childAtPosition(
childAtPosition(
withId(R.id.favorite_tags_layout),
0),
0)));
        tagsCompletionView12.perform(pressImeActionButton());
        
        ViewInteraction appCompatCheckBox2 = onView(
allOf(withId(R.id.checkbox_and_gate),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.LinearLayout")),
1),
1)));
        appCompatCheckBox2.perform(scrollTo(), click());
        
        ViewInteraction appCompatButton2 = onView(
allOf(withId(R.id.add_button), withText("Create"),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.ScrollView")),
0),
3)));
        appCompatButton2.perform(scrollTo(), click());
        
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        
        ViewInteraction appCompatTextView = onView(
allOf(withId(R.id.title), withText("Search"),
childAtPosition(
childAtPosition(
withId(R.id.content),
0),
0),
isDisplayed()));
        appCompatTextView.perform(click());
        
        ViewInteraction searchAutoComplete = onView(
allOf(withId(R.id.search_src_text),
childAtPosition(
allOf(withId(R.id.search_plate),
childAtPosition(
withId(R.id.search_edit_frame),
1)),
0),
isDisplayed()));
        searchAutoComplete.perform(replaceText("dog"), closeSoftKeyboard());
        
        ViewInteraction searchAutoComplete2 = onView(
allOf(withId(R.id.search_src_text), withText("dog"),
childAtPosition(
allOf(withId(R.id.search_plate),
childAtPosition(
withId(R.id.search_edit_frame),
1)),
0),
isDisplayed()));
        searchAutoComplete2.perform(pressImeActionButton());
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
