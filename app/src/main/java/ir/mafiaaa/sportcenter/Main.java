package ir.mafiaaa.sportcenter;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class Main extends AppCompatActivity {


    Toolbar toolbar;
    BottomNavigationView bottomBar;
    //nav Drawer
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);
        Log.d("shima" , "id:" + R.id.cup) ;
        Log.d("shima" , "id:" + R.id.predict) ;
        Log.d("shima" , "id:" + R.id.home) ;
        Log.d("shima" , "id:" + R.id.statistics) ;
        bottomBar = (BottomNavigationView) findViewById(R.id.bottomBar);

        toolbar = (Toolbar) findViewById(R.id.customToolBar);
        setSupportActionBar(toolbar);

        HomeFragment homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container,homeFragment).commit();

        bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Log.d("shima" , "id:" + id) ;
                switch (id){
                    case R.id.cup:
                        CupFragment cupFragment = new CupFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_container,cupFragment).commit();
                        break;
                    case R.id.home:
                        HomeFragment homeFragment = new HomeFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_container,homeFragment).commit();
                        break;
                    case R.id.predict:
                        WizardFragment wizardFragment = new WizardFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_container,wizardFragment).commit();
                        break;
                    case R.id.statistics:
                        ChartsFragment chartsFragment = new ChartsFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_container,chartsFragment).commit();
                        break;
                }
                return true;
            }
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }



        drawerLayout = (DrawerLayout) findViewById(R.id.navDrawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navView);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this ,drawerLayout , toolbar ,R.string.open_drawer , R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

         if(id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}



