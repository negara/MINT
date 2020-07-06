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
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class DeleteFavoriteTest {

    @Rule
    public ActivityTestRule<LaanoActivity> mActivityTestRule = new ActivityTestRule<>(LaanoActivity.class);

    @Test
    public void deleteFavoriteTest() {
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
        appCompatEditText.perform(scrollTo(), replaceText("TheOnlyFavorite"), closeSoftKeyboard());

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
        tagsCompletionView2.perform(scrollTo(), replaceText("fav"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.add_button), withText("Create"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        appCompatButton.perform(scrollTo(), click());

        ViewInteraction tabView2 = onView(
                allOf(withContentDescription("Notes"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tab_layout),
                                        0),
                                2),
                        isDisplayed()));
        tabView2.perform(click());

        ViewInteraction viewPager2 = onView(
                allOf(withId(R.id.laano_view_pager),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.coordinator_layout),
                                        1),
                                0),
                        isDisplayed()));
        viewPager2.perform(swipeLeft());

        ViewInteraction tabView3 = onView(
                allOf(withContentDescription("Favorites"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tab_layout),
                                        0),
                                1),
                        isDisplayed()));
        tabView3.perform(click());

        ViewInteraction viewPager3 = onView(
                allOf(withId(R.id.laano_view_pager),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.coordinator_layout),
                                        1),
                                0),
                        isDisplayed()));
        viewPager3.perform(swipeRight());

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.toolbar_favorites_filter), withContentDescription("Favorite filter"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.toolbar),
                                        2),
                                1),
                        isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.title), withText("All"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatTextView.perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction appCompatTextView2 = onView(
                allOf(withId(R.id.title), withText("Switch to Edit mode"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatTextView2.perform(click());

        ViewInteraction appCompatCheckBox = onView(
                allOf(withId(R.id.favorite_checkbox), withContentDescription("Select Favorite"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatCheckBox.perform(click());

        ViewInteraction actionMenuItemView2 = onView(
                allOf(withId(R.id.favorites_delete), withContentDescription("Delete"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.action_mode_bar),
                                        1),
                                0),
                        isDisplayed()));
        actionMenuItemView2.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(android.R.id.button1), withText("Delete"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.buttonPanel),
                                        0),
                                3)));
        appCompatButton2.perform(scrollTo(), click());

        ViewInteraction tabView4 = onView(
                allOf(withContentDescription("Favorites"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tab_layout),
                                        0),
                                1),
                        isDisplayed()));
        tabView4.perform(click());

        ViewInteraction tabView5 = onView(
                allOf(withContentDescription("Notes"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tab_layout),
                                        0),
                                2),
                        isDisplayed()));
        tabView5.perform(click());

        ViewInteraction viewPager4 = onView(
                allOf(withId(R.id.laano_view_pager),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.coordinator_layout),
                                        1),
                                0),
                        isDisplayed()));
        viewPager4.perform(swipeLeft());

        ViewInteraction tabView6 = onView(
                allOf(withContentDescription("Favorites"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tab_layout),
                                        0),
                                1),
                        isDisplayed()));
        tabView6.perform(click());

        ViewInteraction viewPager5 = onView(
                allOf(withId(R.id.laano_view_pager),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.coordinator_layout),
                                        1),
                                0),
                        isDisplayed()));
        viewPager5.perform(swipeRight());

        ViewInteraction actionMenuItemView3 = onView(
                allOf(withId(R.id.toolbar_favorites_filter), withContentDescription("Favorite filter"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.toolbar),
                                        2),
                                1),
                        isDisplayed()));
        actionMenuItemView3.perform(click());

        ViewInteraction appCompatTextView3 = onView(
                allOf(withId(R.id.title), withText("All"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatTextView3.perform(click());

        ViewInteraction textView = onView(
                allOf(withText("List is empty"),
                        childAtPosition(
                                allOf(withId(R.id.snackbar_layout),
                                        withParent(withId(R.id.laano_view_pager))),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("List is empty")));
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
