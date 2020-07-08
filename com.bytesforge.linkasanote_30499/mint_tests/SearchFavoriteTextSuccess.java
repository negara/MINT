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
public class SearchFavoriteTextSuccess {

    @Rule
    public ActivityTestRule<LaanoActivity> mActivityTestRule = new ActivityTestRule<>(LaanoActivity.class);

    @Test
    public void searchFavoriteTextSuccess() {
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
        appCompatEditText.perform(scrollTo(), replaceText("a"), closeSoftKeyboard());
        
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
        tagsCompletionView2.perform(scrollTo(), replaceText("b c"), closeSoftKeyboard());
        
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
        appCompatEditText2.perform(scrollTo(), replaceText("ma"), closeSoftKeyboard());
        
        ViewInteraction tagsCompletionView3 = onView(
allOf(withId(R.id.favorite_tags),
childAtPosition(
childAtPosition(
withId(R.id.favorite_tags_layout),
0),
0)));
        tagsCompletionView3.perform(scrollTo(), click());
        
        ViewInteraction tagsCompletionView4 = onView(
allOf(withId(R.id.favorite_tags),
childAtPosition(
childAtPosition(
withId(R.id.favorite_tags_layout),
0),
0)));
        tagsCompletionView4.perform(scrollTo(), replaceText("d b"), closeSoftKeyboard());
        
        ViewInteraction tagsCompletionView5 = onView(
allOf(withId(R.id.favorite_tags), withText("d b"),
childAtPosition(
childAtPosition(
withId(R.id.favorite_tags_layout),
0),
0)));
        tagsCompletionView5.perform(pressImeActionButton());
        
        ViewInteraction appCompatButton2 = onView(
allOf(withId(R.id.add_button), withText("Create"),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.ScrollView")),
0),
3)));
        appCompatButton2.perform(scrollTo(), click());
        
        ViewInteraction actionMenuItemView = onView(
allOf(withId(R.id.toolbar_favorites_search), withContentDescription("Search"),
childAtPosition(
childAtPosition(
withId(R.id.toolbar),
2),
0),
isDisplayed()));
        actionMenuItemView.perform(click());
        
        ViewInteraction searchAutoComplete = onView(
allOf(withId(R.id.search_src_text),
childAtPosition(
allOf(withId(R.id.search_plate),
childAtPosition(
withId(R.id.search_edit_frame),
1)),
0),
isDisplayed()));
        searchAutoComplete.perform(replaceText("a"), closeSoftKeyboard());
        
        ViewInteraction searchAutoComplete2 = onView(
allOf(withId(R.id.search_src_text), withText("a"),
childAtPosition(
allOf(withId(R.id.search_plate),
childAtPosition(
withId(R.id.search_edit_frame),
1)),
0),
isDisplayed()));
        searchAutoComplete2.perform(pressImeActionButton());
        
        ViewInteraction searchAutoComplete3 = onView(
allOf(withId(R.id.search_src_text), withText("a"),
childAtPosition(
allOf(withId(R.id.search_plate),
childAtPosition(
withId(R.id.search_edit_frame),
1)),
0),
isDisplayed()));
        searchAutoComplete3.perform(replaceText("ma"));
        
        ViewInteraction searchAutoComplete4 = onView(
allOf(withId(R.id.search_src_text), withText("ma"),
childAtPosition(
allOf(withId(R.id.search_plate),
childAtPosition(
withId(R.id.search_edit_frame),
1)),
0),
isDisplayed()));
        searchAutoComplete4.perform(closeSoftKeyboard());
        
        ViewInteraction searchAutoComplete5 = onView(
allOf(withId(R.id.search_src_text), withText("ma"),
childAtPosition(
allOf(withId(R.id.search_plate),
childAtPosition(
withId(R.id.search_edit_frame),
1)),
0),
isDisplayed()));
        searchAutoComplete5.perform(pressImeActionButton());
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
