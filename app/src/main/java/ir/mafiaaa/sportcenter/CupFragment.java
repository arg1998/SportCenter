package ir.mafiaaa.sportcenter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_cup, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView_cup_league);
        LeagueRankingAdapter adapter = new LeagueRankingAdapter(contex);
        recyclerView.setLayoutManager(new LinearLayoutManager(contex , LinearLayoutManager.VERTICAL , false));
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        return rootView;
    }

}
