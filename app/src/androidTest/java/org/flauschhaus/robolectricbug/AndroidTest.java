package org.flauschhaus.robolectricbug;

import android.view.KeyEvent;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class AndroidTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void typing_enter_should_add_newline_to_result() {
        onView(withId(R.id.edit_with_enter)).perform(typeText("Some text."));
        onView(withId(R.id.edit_with_enter)).perform(pressKey(KeyEvent.KEYCODE_ENTER));
        onView(withId(R.id.edit_with_enter)).perform(typeTextIntoFocusedView("Other text."));

        onView(withId(R.id.edit_with_enter)).check(matches(withText("Some text.\nOther text.")));
    }

    @Test
    public void should_be_able_to_access_edit_text_on_the_bottom_of_the_screen() {
        onView(withId(R.id.edit_with_enter)).perform(typeText("First text."));
        onView(withId(R.id.edit_on_the_bottom_of_the_screen)).perform(closeSoftKeyboard(), typeText("Second text."));

        onView(withId(R.id.edit_on_the_bottom_of_the_screen)).check(matches(withText("Second text.")));
    }
}
