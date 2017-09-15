package ir.mafiaaa.sportcenter;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by Shima on 9/15/2017.
 */

public class WizardFragment extends Fragment {

    private RelativeLayout layoutMain;
    private RelativeLayout layoutButtons;
    private RelativeLayout layoutContent;
    private FloatingActionButton fab;
    private boolean isOpen = false;


    private AppCompatActivity contex;

    public WizardFragment(AppCompatActivity contex)
    {
        this.contex = contex;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_wizard, container, false);

        layoutMain = (RelativeLayout) rootView.findViewById(R.id.layoutMain);
        layoutContent = (RelativeLayout) rootView.findViewById(R.id.wizardContainer);
        layoutButtons = (RelativeLayout) rootView.findViewById(R.id.layoutButton);

        fab = (FloatingActionButton) rootView.findViewById(R.id.Fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewMenu();

            }
        });
        return rootView;
    }
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        private void  viewMenu() {

        if (!isOpen) {
            int x = layoutContent.getRight();
            int y = layoutContent.getBottom();

            int startRedios = 0;
            int endRedios = (int) Math.hypot(layoutMain.getWidth(), layoutMain.getHeight());
            fab.setBackgroundTintList(ColorStateList.valueOf(ResourcesCompat.getColor(getResources(), android.R.color.white, null)));

            Animator anim = ViewAnimationUtils.createCircularReveal(layoutButtons, x, y, startRedios, endRedios);
            layoutButtons.setVisibility(View.VISIBLE);
            anim.start();

            isOpen = true;
        } else {

            int x = layoutContent.getRight();
            int y = layoutContent.getBottom();

            int startRedios = Math.max(layoutContent.getWidth(), layoutContent.getHeight());
            int endRedios = 0;
            fab.setBackgroundTintList(ColorStateList.valueOf(ResourcesCompat.getColor(getResources(), R.color.colorAccent, null)));

            Animator anim = ViewAnimationUtils.createCircularReveal(layoutButtons, x, y, startRedios, endRedios);
            anim.addListener(new Animator.AnimatorListener() {

                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    layoutButtons.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animator) {
                }

                @Override
                public void onAnimationRepeat(Animator animator) {
                }
            });

            anim.start();
            isOpen = false;

        }
    }

}


