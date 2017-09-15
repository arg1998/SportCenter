package FormationFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import ir.mafiaaa.sportcenter.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Formation532 extends Fragment {


    public Formation532() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_formation532, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView num1 = (ImageView) view.findViewById(R.id.num1);
        ImageView num2 = (ImageView) view.findViewById(R.id.num2);
        ImageView num3 = (ImageView) view.findViewById(R.id.num3);
        ImageView num4 = (ImageView) view.findViewById(R.id.num4);
        ImageView num5 = (ImageView) view.findViewById(R.id.num5);
        ImageView num6 = (ImageView) view.findViewById(R.id.num6);
        ImageView num7 = (ImageView) view.findViewById(R.id.num7);
        ImageView num8 = (ImageView) view.findViewById(R.id.num8);
        ImageView num9 = (ImageView) view.findViewById(R.id.num9);
        ImageView num10 = (ImageView) view.findViewById(R.id.num10);
        ImageView num11 = (ImageView) view.findViewById(R.id.num11);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case R.id.num1:
                        break;
                    case R.id.num2:
                    case R.id.num3:
                    case R.id.num4:
                    case R.id.num5:
                    case R.id.num6:
                        break;
                    case R.id.num7:
                    case R.id.num8:
                    case R.id.num9:
                        break;
                    case R.id.num10:
                    case R.id.num11:
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

}
