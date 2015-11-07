package org.thegeekhub.vbilyk.firsthometask.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import org.thegeekhub.vbilyk.firsthometask.R;
import org.thegeekhub.vbilyk.firsthometask.fourthhometask.FragmentFourth;
import org.thegeekhub.vbilyk.firsthometask.fragments.FragmentFifth;
import org.thegeekhub.vbilyk.firsthometask.fragments.FragmentFirst;
import org.thegeekhub.vbilyk.firsthometask.fragments.FragmentSecond;
import org.thegeekhub.vbilyk.firsthometask.fragments.FragmentThird;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static final String NAV_ITEM_ID = "nav_item_id";
    private static final long DRAWER_CLOSE_DELAY_MS = 250;
    private final Handler drawerActionHandler = new Handler();
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private int navItemId;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // load saved navigation state if present
        if (null == savedInstanceState) {
            navItemId = R.id.action_home_task_1;
        } else {
            navItemId = savedInstanceState.getInt(NAV_ITEM_ID);
        }

        // listen for navigation events
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        // select the correct nav menu item
        navigationView.getMenu().findItem(navItemId).setChecked(true);

        // set up the hamburger icon to open and close the drawer
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        navigate(navItemId);

    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_main, fragment)
                .commit();
    }

    public void navigate(int id) {
        switch (id) {
            case R.id.action_home_task_1:
                replaceFragment(new FragmentFirst()); // TODO: 06.11.2015
                break;
            case R.id.action_home_task_2:
                replaceFragment(new FragmentSecond());
                break;
            case R.id.action_home_task_3:
                replaceFragment(new FragmentThird());
                break;
            case R.id.action_home_task_4:
                replaceFragment(new FragmentFourth());
                break;
            case R.id.action_home_task_5:
                replaceFragment(new FragmentFifth());
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(final MenuItem menuItem) {
        // update highlighted item in the navigation menu
        navigationView.getMenu().findItem(navItemId).setChecked(false);
        menuItem.setChecked(true);
        navItemId = menuItem.getItemId();

        // allow some time after closing the drawer before performing real navigation
        // so the user can see what is happening
        drawerLayout.closeDrawer(GravityCompat.START);
        drawerActionHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                navigate(menuItem.getItemId());
            }
        }, DRAWER_CLOSE_DELAY_MS);
        return true;
    }

    @Override
    public void onConfigurationChanged(final Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (item.getItemId() == android.support.v7.appcompat.R.id.home) {
            return drawerToggle.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(NAV_ITEM_ID, navItemId);
    }
}
