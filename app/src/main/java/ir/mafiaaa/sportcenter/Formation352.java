package ir.mafiaaa.sportcenter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Formation352 extends Fragment {

    public void log(String info){
        Log.i("AMP : ", info);
    }

    public Formation352() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        log("6");
        return inflater.inflate(R.layout.fragment_formation352, container, false);
    }

}
