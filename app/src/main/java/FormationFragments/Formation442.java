package FormationFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ir.mafiaaa.sportcenter.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Formation442 extends Fragment {


    FormationSelect selectFragment;

    View view;

    public void log(String info){
        Log.i("AMP : ", info);
    }

    public static TextView n1;
    public static TextView n2;
    public static TextView n3;
    public static TextView n4;
    public static TextView n5;
    public static TextView n6;
    public static TextView n7;
    public static TextView n8;
    public static TextView n9;
    public static TextView n10;
    public static TextView n11;

    public Formation442() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_formation442, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.view = view;

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

        n1 = (TextView) view.findViewById(R.id.n1);
        n2 = (TextView) view.findViewById(R.id.n2);
        n3 = (TextView) view.findViewById(R.id.n3);
        n4 = (TextView) view.findViewById(R.id.n4);
        n5 = (TextView) view.findViewById(R.id.n5);
        n6 = (TextView) view.findViewById(R.id.n6);
        n7 = (TextView) view.findViewById(R.id.n7);
        n8 = (TextView) view.findViewById(R.id.n8);
        n9 = (TextView) view.findViewById(R.id.n9);
        n10 = (TextView) view.findViewById(R.id.n10);
        n11 = (TextView) view.findViewById(R.id.n11);

        n1.setText("علیرضا بیرانوند");

        n2.setText("حسین ماهینی");
        n3.setText("شجاع خلیل‌زاده");
        n4.setText("سیدجلال حسینی");
        n5.setText("محمد انصاری");

        n6.setText("فرشاد احمدزاده");
        n7.setText("کمال کامیابی‌نیا");
        n8.setText("احمد نوراللهی");
        n9.setText("احسان علوان‌زاده");

        n10.setText("علی علیپور");
        n11.setText("مهدی طارمی");


        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case R.id.img1:
                        log("num1");
                        showDialog(1);
                        break;

                    case R.id.img2:
                        showDialog(2);
                        break;

                    case R.id.img3:
                        showDialog(3);
                        break;

                    case R.id.img4:
                        showDialog(4);
                        break;
                    case R.id.img5:
                        showDialog(5);
                        break;

                    case R.id.img6:
                        showDialog(6);
                        break;

                    case R.id.img7:
                        showDialog(7);
                        break;

                    case R.id.img8:
                        showDialog(8);
                        break;

                    case R.id.img9:
                        showDialog(9);
                        break;

                    case R.id.img10:
                        showDialog(10);
                        break;

                    case R.id.img11:
                        showDialog(11);
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


    public void showDialog(int Number){
        Custom_dialog custom_dialog = new Custom_dialog(getActivity(), Number, 442);
        custom_dialog.show();
    }

    public static void changePlayerName(String name, int number){

        switch (number){

            case 1:
                n1.setText(name);
                break;
            case 2:
                n2.setText(name);
                break;
            case 3:
                n3.setText(name);
                break;
            case 4:
                n4.setText(name);
                break;
            case 5:
                n5.setText(name);
                break;
            case 6:
                n6.setText(name);
                break;
            case 7:
                n7.setText(name);
                break;
            case 8:
                n8.setText(name);
                break;
            case 9:
                n9.setText(name);
                break;
            case 10:
                n10.setText(name);
                break;
            case 11:
                n10.setText(name);
                break;
        }

    }

}
