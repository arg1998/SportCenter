package ir.mafiaaa.sportcenter;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Shima on 9/15/2017.
 */

public class HomeFragment extends Fragment {

    private AppCompatActivity context;
    DrawerLayout drawerLayout;

    public HomeFragment (AppCompatActivity context , DrawerLayout drawerLayout){
        this.context = context;
        this.drawerLayout = drawerLayout;
    }

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        toolbar = (Toolbar) rootView.findViewById(R.id.Tool_Bar2);
        context.setSupportActionBar(toolbar);

        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) rootView.findViewById(R.id.Collapse_ToolBar);
        recyclerView.setHasFixedSize(true);




        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        listItems = new ArrayList<>();



            ListItem listItem1 = new ListItem(
                    "رتبه تیم" ,
                    "1"
            );

            ListItem listItem2 = new ListItem(
                "لیگ" ,
                "لیگ خلیج فارس"
            );

             ListItem listItem3 = new ListItem(
                "بازی پیش رو" ,
                "استقلال - پرسپولیس"
             );

             ListItem listItem4 = new ListItem(
                "ضریب پیشنهاد" ,
                "4"
             );

            listItems.add(listItem1);
            listItems.add(listItem2);
            listItems.add(listItem3);
            listItems.add(listItem4);


        adapter = new RecyclerAdapter(listItems,getContext());
        recyclerView.setAdapter(adapter);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(context ,drawerLayout , toolbar ,R.string.open_drawer , R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        return rootView;

    }

}
