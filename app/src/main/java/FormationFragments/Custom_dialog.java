package FormationFragments;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ir.mafiaaa.sportcenter.Formation;
import ir.mafiaaa.sportcenter.ListItem;
import ir.mafiaaa.sportcenter.R;
import ir.mafiaaa.sportcenter.RecyclerFormationAdapter;



public class Custom_dialog extends Dialog {

    public static ArrayList strings;

    public int Formation;

    public static int Number;

    public String TAG = "AMP :";

    private FormationSelect.OnFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ListAdapter adapter2;
    private List<ListItem> listItems;

    public Activity c;
    public Dialog d;

    public Custom_dialog(Activity a, int Number, int formation) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
        this.Number = Number;
        this.Formation = formation;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);


        /*recyclerView = (RecyclerView) findViewById(R.id.recyclerView_formation);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        listItems = new ArrayList<>();

        for(int i =0; i<=10; i++ ){

            ListItem listItem = new ListItem(
                    "heading" + (i+1),
                    "Loren ipsum dummy text"
            );

            listItems.add(listItem);
        }

        adapter = new RecyclerFormationAdapter(listItems,getContext());

        recyclerView.setAdapter(adapter);*/


        //AMP !!!

        strings = new ArrayList();
        strings.add("محمد انصاری");
        strings.add("حسین ماهینی");
        strings.add("سیدجلال حسینی");
        strings.add("سیدجلال حسینی");
        strings.add("سیدجلال حسینی");
        strings.add("سیدجلال حسینی");
        strings.add("سیدجلال حسینی");
        strings.add("سیدجلال حسینی");
        strings.add("سیدجلال حسینی");
        strings.add("سیدجلال حسینی");

        adapter2 = new ArrayAdapter<ArrayList>(getContext(),android.R.layout.simple_list_item_1, strings);


        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter2);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "onItemClick: onItemClick");
                selected(position);

            }
        });

    }


    public void selected(int index){

        String playerName;
        playerName = strings.get(index).toString();
        Log.i(TAG, "selected: "+playerName);



        switch (Formation){

            case 352:
                Formation352.changePlayerName(playerName, Number);
                dismiss();
                break;

            case 433:
                Formation433.changePlayerName(playerName, Number);
                dismiss();
                break;

            case 442:
                Formation442.changePlayerName(playerName, Number);
                dismiss();
                break;

            case 532:
                Formation532.changePlayerName(playerName, Number);
                dismiss();
                break;

        }


    }
}
