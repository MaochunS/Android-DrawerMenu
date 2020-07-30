package com.maochun.drawermenu;


import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.google.android.material.navigation.NavigationView;

public class MainActivity extends BaseDrawerActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.colorBlack));

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view_main_menu);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_main);

        initDrawer();

        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        mNavigationView.setNavigationItemSelectedListener(mNavViewSelectListener);
        Menu menu = mNavigationView.getMenu();
        if (menu != null){
            MenuItem menuItem = menu.getItem(0);
            if (menuItem != null) {
                menuItem.setChecked(true);
            }
        }
    }
}