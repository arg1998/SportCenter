package ir.mafiaaa.sportcenter;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


public class LoginFragment extends Fragment {

    static Activity act;
    AppCompatEditText email;
    AppCompatEditText pass;
    RelativeLayout relativeLayout;
    TextInputLayout emailLayout;
    TextInputLayout passLayout;

    // TODO: Rename and change types of parameters

    public static void setCurrentActivity(Activity activity){

        act = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        email = (AppCompatEditText) rootView.findViewById(R.id.Email_TextField);
        emailLayout = (TextInputLayout) rootView.findViewById(R.id.Email_TextInputLayout);
        pass = (AppCompatEditText) rootView.findViewById(R.id.pass_TextField);
        passLayout = (TextInputLayout) rootView.findViewById(R.id.Pass_TextInputLayout);
        relativeLayout = (RelativeLayout) rootView.findViewById(R.id.LoginFragment);

        email.setOnFocusChangeListener(new View.OnFocusChangeListener(){

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (email.getText().toString().isEmpty()){

                    emailLayout.setErrorEnabled(true);
                    emailLayout.setError("please enter your username");

                }else {
                    emailLayout.setErrorEnabled(false);
                }

            }


        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (email.getText().toString().isEmpty()){

                    emailLayout.setErrorEnabled(true);
                    emailLayout.setError("please enter your username");

                }else {
                    emailLayout.setErrorEnabled(false);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        passLayout.setCounterEnabled(true);
        passLayout.setCounterMaxLength(8);


        // Inflate the layout for this fragment
        return rootView;

    }

}
