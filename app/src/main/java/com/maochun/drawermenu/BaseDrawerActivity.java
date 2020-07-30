package com.maochun.drawermenu;

import android.os.Build;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.TranslateAnimation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class BaseDrawerActivity extends AppCompatActivity {

    protected static int                                        mSelectedMenuId = -1;

    protected DrawerLayout                                      mDrawerLayout;
    protected Toolbar                                           mToolbar;
    protected ActionBarDrawerToggle                             mDrawerToggle;
    protected NavigationView.OnNavigationItemSelectedListener   mNavViewSelectListener;
    protected NavigationView                                    mNavigationView;
    private float                                               mLastTranslate = 0.0f;

    protected void initDrawer(){
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                mToolbar,
                R.string.open,
                R.string.close) {

            @Override
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                //getActionBar().setTitle(mTitle);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //getActionBar().setTitle(mDrawerTitle);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset)
            {
                super.onDrawerSlide(drawerView, slideOffset);

                float moveFactor = (mNavigationView.getWidth() * slideOffset);

                ConstraintLayout frame = findViewById(R.id.constraint_layout_main);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
                    frame.setTranslationX(moveFactor);
                }else {
                    TranslateAnimation anim = new TranslateAnimation(mLastTranslate, moveFactor, 0.0f, 0.0f);
                    anim.setDuration(0);
                    anim.setFillAfter(true);
                    frame.startAnimation(anim);

                    mLastTranslate = moveFactor;
                }


            }
        };

        mNavViewSelectListener = new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                //mDrawerLayout.closeDrawer(GravityCompat.START);
                mDrawerLayout.closeDrawer(Gravity.LEFT);


                item.setChecked(true);
                mSelectedMenuId = item.getItemId();

                int id = item.getItemId();
                if (id == R.id.menu_main_item1) {
                    Log.i("", "tap menu item 1");
                    handleMenuItem1();
                    return false;
                }else if (id == R.id.menu_main_item2) {
                    Log.i("", "tap menu item 2");
                    handleMenuItem2();
                    return false;
                }else if (id == R.id.menu_main_item3){
                    Log.i("", "tap menu item 3");
                    handleMenuItem3();
                    return false;
                }else if (id == R.id.menu_main_item4){
                    Log.i("", "tap menu item 4");
                    handleMenuItem4();
                }

                return false;
            }
        };
    }

    protected void handleMenuItem1(){

    }

    protected void handleMenuItem2(){

    }

    protected void handleMenuItem3(){

    }

    protected void handleMenuItem4(){

    }

}
