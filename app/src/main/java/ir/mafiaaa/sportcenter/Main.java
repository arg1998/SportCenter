package ir.mafiaaa.sportcenter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.backtory.java.internal.BacktoryUser;

public class Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{



    BottomNavigationView bottomBar;
    //nav Drawer
    DrawerLayout drawerLayout;
    NavigationView navigationView;


    //fragments
    HomeFragment homeFragment;
    CupFragment cupFragment;
    WizardFragment wizardFragment;
    ChartsFragment chartsFragment;


    private void log(String s)
    {
        Log.i("NoEmulators", s);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);
        Log.d("AmirReza" , "Welcome Activity part");

        BacktoryUser me = BacktoryUser.getCurrentUser();

        if (me == null)
        {
            Intent intent = new Intent(Main.this, Register.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        }
        else {

            Log.d("shima", "id:" + R.id.cup);
            Log.d("shima", "id:" + R.id.predict);
            Log.d("shima", "id:" + R.id.home);
            Log.d("shima", "id:" + R.id.statistics);
            bottomBar = (BottomNavigationView) findViewById(R.id.bottomBar);
            drawerLayout = (DrawerLayout) findViewById(R.id.navDrawerLayout);
            navigationView = (NavigationView) findViewById(R.id.navView);


            navigationView.setNavigationItemSelectedListener(this);




            //init fragment
            homeFragment = new HomeFragment(this, drawerLayout);
            cupFragment = new CupFragment(this);
            wizardFragment = new WizardFragment(this);
            chartsFragment = new ChartsFragment(this);

            getSupportFragmentManager().beginTransaction().add(R.id.main_container, homeFragment).commit();

            bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int id = item.getItemId();
                    Log.d("shima", "id:" + id);
                    switch (id) {
                        case R.id.cup:
                            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, cupFragment).commit();
                            break;
                        case R.id.home:
                            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, homeFragment).commit();
                            break;
                        case R.id.predict:
                            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, wizardFragment).commit();
                            break;
                        case R.id.statistics:
                            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, chartsFragment).commit();
                            break;
                    }
                    return true;
                }
            });

            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
            }

        }
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.LogOut){
            BacktoryUser.logout();
            Intent intent = new Intent(this , Register.class);
            startActivity(intent);
            this.finish();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }
}



