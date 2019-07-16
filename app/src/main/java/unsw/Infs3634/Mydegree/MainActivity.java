package unsw.Infs3634.Mydegree;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public static final String TAG_N = "Navi";
    public TextView appBarTxt;
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private float lastTranslate = 0.0f;
    private ImageView imgLeftToolbar;
    private boolean isOpenOrClose = false;
    private ActionBarDrawerToggle drawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);
        startActivity(new Intent(MainActivity.this, HomeActivity.class));
        finish();


    }

    @Override
    public void setContentView(int layout) {

        View parentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main, null);
        FrameLayout frame = (FrameLayout) parentView.findViewById(R.id.frame);
        getLayoutInflater().inflate(layout, frame, true);
        super.setContentView(parentView);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        appBarTxt = (TextView) findViewById(R.id.toolbar_title);
        imgLeftToolbar = (ImageView) findViewById(R.id.toolbar_menu_img);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        setUpNavigationView();

        Log.i(TAG_N, "Navigation views set.");
        drawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open_drawer, R.string.close_drawer) {
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float moveFactor = (drawerView.getWidth() * slideOffset);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    findViewById(R.id.navigaion_open_layout).setTranslationX(moveFactor);
                } else {
                    TranslateAnimation anim = new TranslateAnimation(lastTranslate, moveFactor, 0.0f, 0.0f);
                    anim.setDuration(0);
                    anim.setFillAfter(true);
                    findViewById(R.id.navigaion_open_layout).startAnimation(anim);
                    lastTranslate = moveFactor;

                }
            }
        };


        imgLeftToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpenOrClose)
                    drawer.closeDrawers();
                else
                    drawer.openDrawer(GravityCompat.START);


            }
        });


    }


    private void setUpNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        startActivity(new Intent(MainActivity.this, HomepageActivity.class));
                        finish();
                        break;

                    case R.id.nav_topic:
                        startActivity(new Intent(MainActivity.this, MenuActivity.class));
                        finish();
                        break;

                    case R.id.nav_video:
                        startActivity(new Intent(MainActivity.this, VideoActivity.class));
                        finish();
                        break;

                    case R.id.nav_quiz:
                        startActivity(new Intent(MainActivity.this, QuizSelectionActivity.class));
                        finish();
                        break;


                    case R.id.nav_search:
                        startActivity(new Intent(MainActivity.this, NotesActivity.class));
                        finish();
                        break;

                    default:
                        startActivity(new Intent(MainActivity.this, HomeActivity.class));
                        finish();
                }
                Log.i(TAG_N, "Drawer item intents set.");

                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);
                return true;
            }
        });

    }

}
