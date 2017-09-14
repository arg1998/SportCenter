package ir.mafiaaa.sportcenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class FormationActivity extends AppCompatActivity {

    public void log(String info){
        Log.i("AMP : ", info);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formation);
        log("0");

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayList arrayList = new ArrayList();

        log("1");

        arrayList.add("Formation : 3-5-2");
        arrayList.add("Formation : 4-3-3");
        arrayList.add("Formation : 4-4-2");
        arrayList.add("Formation : 5-3-2");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, arrayList);

        log("2");

        spinner.setAdapter(arrayAdapter);

        log("3");

        Formation352 formation352 = new Formation352();
        getSupportFragmentManager().beginTransaction().add( R.id.fragmentContainer, formation352).commit();

        log("4");

        /*spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (spinner.getAdapter().toString())
                Formation352 formation352 = new Formation352();
                getSupportFragmentManager().beginTransaction().add( R.id.fragmentContainer, formation352).commit();
            }
        });*/


    }
}
