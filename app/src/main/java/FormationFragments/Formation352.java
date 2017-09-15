package FormationFragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import ir.mafiaaa.sportcenter.Formation;
import ir.mafiaaa.sportcenter.R;


public class Formation352 extends Fragment implements FormationSelect.OnFragmentInteractionListener {

    FormationSelect selectFragment;

    AppCompatActivity contxet;

    public void log(String info){
        Log.i("AMP : ", info);
    }

    public Formation352(AppCompatActivity context) {
        // Required empty public constructor
        this.contxet = context;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        log("6");

        //contxet.getSupportFragmentManager().beginTransaction().add(R.id.rightCont, selectFragment).commit();

        return inflater.inflate(R.layout.fragment_formation352, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView num1 = (ImageView) view.findViewById(R.id.img1);
        ImageView num2 = (ImageView) view.findViewById(R.id.img2);
        ImageView num3 = (ImageView) view.findViewById(R.id.img3);
        ImageView num4 = (ImageView) view.findViewById(R.id.img4);
        ImageView num5 = (ImageView) view.findViewById(R.id.img5);
        ImageView num6 = (ImageView) view.findViewById(R.id.img6);
        ImageView num7 = (ImageView) view.findViewById(R.id.img7);
        ImageView num8 = (ImageView) view.findViewById(R.id.img8);
        ImageView num9 = (ImageView) view.findViewById(R.id.img9);
        ImageView num10 = (ImageView) view.findViewById(R.id.img10);
        ImageView num11 = (ImageView) view.findViewById(R.id.img11);

        selectFragment = new FormationSelect();



        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case R.id.img1:
                        log("num1");
                        show_Right_Frag();
                        break;

                    case R.id.img2:
                        show_Right_Frag();
                        break;

                    case R.id.img3:
                        show_Right_Frag();
                        break;

                    case R.id.img4:
                        show_left_Frag();
                        break;
                    case R.id.img5:
                        show_Right_Frag();
                        break;

                    case R.id.img6:
                        show_left_Frag();
                        break;

                    case R.id.img7:
                        show_Right_Frag();
                        break;

                    case R.id.img8:
                        show_Right_Frag();
                        break;

                    case R.id.img9:
                        show_left_Frag();
                        break;

                    case R.id.img10:
                        show_Right_Frag();
                        break;

                    case R.id.img11:
                        show_left_Frag();
                        break;

                }
            }
        };


        num1.setOnClickListener(clickListener);
        num2.setOnClickListener(clickListener);
        num3.setOnClickListener(clickListener);
        num4.setOnClickListener(clickListener);
        num5.setOnClickListener(clickListener);
        num6.setOnClickListener(clickListener);
        num7.setOnClickListener(clickListener);
        num8.setOnClickListener(clickListener);
        num9.setOnClickListener(clickListener);
        num10.setOnClickListener(clickListener);
        num11.setOnClickListener(clickListener);
    }


    public void show_Right_Frag(){
        contxet.getSupportFragmentManager().beginTransaction().add(R.id.rightCont, selectFragment).commit();
    }

    public void show_left_Frag(){
        contxet.getSupportFragmentManager().beginTransaction().add(R.id.leftCont, selectFragment).commit();
    }

    public void num1(){
    }

    public void num2(){

    }

    public void num3(){

    }

    public void num4(){

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
