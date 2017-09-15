package ir.mafiaaa.sportcenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import FormationFragments.Formation352;
import FormationFragments.Formation433;
import FormationFragments.Formation442;
import FormationFragments.Formation532;

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

        arrayList.add(getResources().getString(R.string.Formation_352));
        arrayList.add(getResources().getString(R.string.Formation_433));
        arrayList.add(getResources().getString(R.string.Formation_442));
        arrayList.add(getResources().getString(R.string.Formation_532));

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, arrayList);

        log("2");

        spinner.setAdapter(arrayAdapter);

        log("3");

        Formation352 formation352 = new Formation352();
        getSupportFragmentManager().beginTransaction().add( R.id.fragmentContainer, formation352).commit();

        log("4");


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (spinner.getSelectedItem().toString())
                {
                    case "ترکیب سه-پنج-دو":

                        Formation352 formation352 = new Formation352();
                        getSupportFragmentManager().beginTransaction().replace( R.id.fragmentContainer, formation352).commit();

                        break;
                    case "ترکیب چهار-سه-سه":

                        Formation433 formation433 = new Formation433();
                        getSupportFragmentManager().beginTransaction().replace( R.id.fragmentContainer, formation433).commit();

                        break;
                    case "ترکیب چهار-چهار-دو":

                        Formation442 formation442 = new Formation442();
                        getSupportFragmentManager().beginTransaction().replace( R.id.fragmentContainer, formation442).commit();

                        break;
                    case "ترکیب پنج-سه-دو":

                        Formation532 formation532 = new Formation532();
                        getSupportFragmentManager().beginTransaction().replace( R.id.fragmentContainer, formation532).commit();

                        break;
                }

                String text = spinner.getSelectedItem().toString();
                log(text);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                log("nothing");
            }
        });

    }
}
