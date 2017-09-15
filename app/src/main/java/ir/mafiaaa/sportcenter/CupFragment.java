package ir.mafiaaa.sportcenter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Shima on 9/15/2017.
 */

public class CupFragment extends Fragment {

    private AppCompatActivity contex;

    public CupFragment(AppCompatActivity contex)
    {
        this.contex = contex;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_cup, container, false);
        return rootView;
    }

}
