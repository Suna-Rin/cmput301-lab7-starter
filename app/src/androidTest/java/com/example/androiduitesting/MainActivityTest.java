package com.example.androiduitesting;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Lab 7 UI tests:
 * 1) 点击列表是否切换到 ShowActivity
 * 2) ShowActivity 显示的城市名是否与点击项一致
 * 3) BACK 按钮是否返回 MainActivity
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> rule =
            new ActivityScenarioRule<>(MainActivity.class);

    /** 辅助：添加一个城市 "Edmonton" */
    private void addEdmonton() {
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(typeText("Edmonton"), closeSoftKeyboard());
        onView(withId(R.id.button_confirm)).perform(click());
    }

    /** 辅助：点击列表第 0 个条目 */
    private void openFirstItem() {
        onData(anything())
                .inAdapterView(withId(R.id.city_list))
                .atPosition(0)
                .perform(click());
    }

    // 1) 是否正确切换到 ShowActivity（检查 ShowActivity 根视图）
    @Test
    public void testActivitySwitched() {
        addEdmonton();
        openFirstItem();
        onView(withId(R.id.show_root)).check(matches(isDisplayed()));
    }

    // 2) 城市名是否一致
    @Test
    public void testCityNameConsistent() {
        addEdmonton();
        openFirstItem();
        onView(withId(R.id.text_city)).check(matches(withText("Edmonton")));
    }

    // 3) BACK 按钮能否返回主界面（列表再次可见）
    @Test
    public void testBackButton() {
        addEdmonton();
        openFirstItem();
        onView(withId(R.id.button_back)).perform(click());
        onView(withId(R.id.city_list)).check(matches(isDisplayed()));
    }
}
