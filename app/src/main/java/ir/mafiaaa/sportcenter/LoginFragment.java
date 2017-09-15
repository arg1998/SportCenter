package ir.mafiaaa.sportcenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.backtory.java.HttpStatusCode;
import com.backtory.java.internal.BacktoryCallBack;
import com.backtory.java.internal.BacktoryObject;
import com.backtory.java.internal.BacktoryQuery;
import com.backtory.java.internal.BacktoryResponse;
import com.backtory.java.internal.BacktoryUser;
import com.backtory.java.internal.LoginResponse;

import java.util.List;


public class LoginFragment extends Fragment {

    private void log(String s) {
        Log.i("NoEmulators", s);
    }


    static Activity act;
    AppCompatEditText email;
    AppCompatEditText pass;
    RelativeLayout relativeLayout;
    TextInputLayout emailLayout;
    TextInputLayout passLayout;
    Button btnLogin;


    String password, emailAddress;

    // TODO: Rename and change types of parameters

    public static void setCurrentActivity(Activity activity) {

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
        btnLogin = (Button) rootView.findViewById(R.id.btn_Login);

        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (email.getText().toString().isEmpty()) {

                    emailLayout.setErrorEnabled(true);
                    emailLayout.setError("ایمیل خود را وارد کنید");

                } else {
                    emailLayout.setErrorEnabled(false);
                }

            }


        });

        if (BacktoryUser.getCurrentUser() != null) {
            log(BacktoryUser.getCurrentUser().getUserId());
        }

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (email.getText().toString().isEmpty()) {

                    emailLayout.setErrorEnabled(true);
                    emailLayout.setError("ایمیل خود را وارد کنید");

                } else {
                    emailLayout.setErrorEnabled(false);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (initStrings()) {
                    BacktoryUser.loginInBackground(emailAddress, SecurityManager.hash_to_SHA1(password), new BacktoryCallBack<LoginResponse>() {
                        @Override
                        public void onResponse(BacktoryResponse<LoginResponse> response) {
                            if (response.isSuccessful()) {
                                btnLogin.setEnabled(false);
                                Toast.makeText(getContext(), BacktoryUser.getCurrentUser().getFirstName() + "ورود موفقیت امیز بود ، خوش امدی ", Toast.LENGTH_SHORT).show();

                                BacktoryQuery query = new BacktoryQuery("users");
                                query.whereEqualTo("userid", BacktoryUser.getCurrentUser().getUserId());
                                query.findInBackground(new BacktoryCallBack<List<BacktoryObject>>() {
                                    @Override
                                    public void onResponse(BacktoryResponse<List<BacktoryObject>> backtoryResponse) {
                                        if (backtoryResponse.isSuccessful()) {
                                            String userFaveTeam = backtoryResponse.body().get(0).getString("favoriteTeam");
                                            startNextActivity();
                                        } else {
                                            Toast.makeText(getContext(), "مشکلی پیش امده، ارتباط با دیتابیس برقرار نیست", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            } else if (response.code() == HttpStatusCode.Unauthorized.code()) {
                                Toast.makeText(getContext(), "ایمیل و یا رمز عبور اشتباه است و یا نیاز به تایید ایمیل دارید", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getContext(), "مشکلی پیش امده، اتصال ب اینترنت و یا تایید ایمیل میتوانند باعث این مشکل باشند", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        // Inflate the layout for this fragment
        return rootView;

    }

    private void startNextActivity() {
        Intent intent = new Intent(getActivity(), Main.class);
        startActivity(intent);
        getActivity().finish();
    }

    private boolean initStrings() {
        password = pass.getText().toString();
        emailAddress = email.getText().toString();


        if (emailAddress.equals("") || password.equals("")) {
            Toast.makeText(getContext(), "تمامی فیلد هارو پر کنید", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
