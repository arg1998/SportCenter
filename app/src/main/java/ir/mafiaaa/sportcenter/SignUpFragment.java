package ir.mafiaaa.sportcenter;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.backtory.java.HttpStatusCode;
import com.backtory.java.internal.BacktoryCallBack;
import com.backtory.java.internal.BacktoryResponse;
import com.backtory.java.internal.BacktoryUser;

public class SignUpFragment extends Fragment {


     private void log(String s)
     {
         Log.i("NoEmulators", s);
     }

    AppCompatEditText Name;
    AppCompatEditText lName;
    AppCompatEditText Email;
    AppCompatEditText Pass;
    AppCompatEditText rePass;
    CheckBox checkbox_larws;
    TextInputLayout nameLayout;
    TextInputLayout lNameLayout;
    TextInputLayout emailLayout;
    TextInputLayout passLayout;
    TextInputLayout rePassLayout;
    RelativeLayout relativeLayout;

    private Button signUp;

    String f_name , l_name , pass , email , repass;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_sign_up, container, false);
        // Inflate the layout for this fragment

        Name = (AppCompatEditText) root.findViewById(R.id.FName_TextField);
        lName = (AppCompatEditText) root.findViewById(R.id.LName_TextField);
        Email = (AppCompatEditText) root.findViewById(R.id.EmailS_TextField);
        Pass = (AppCompatEditText) root.findViewById(R.id.PassS_TextField);
        rePass = (AppCompatEditText) root.findViewById(R.id.rePass_TextField);
        checkbox_larws = (CheckBox) root.findViewById(R.id.CH_laws);
        nameLayout = (TextInputLayout) root.findViewById(R.id.FName_TextInputLayout);
        lNameLayout = (TextInputLayout) root.findViewById(R.id.LName_TextInputLayout);
        emailLayout= (TextInputLayout) root.findViewById(R.id.Email_TextInputLayout);
        passLayout = (TextInputLayout) root.findViewById(R.id.PassS_TextInputLayout);
        rePassLayout = (TextInputLayout) root.findViewById(R.id.rePass_TextInputLayout);
        relativeLayout = (RelativeLayout) root.findViewById(R.id.SignUp);

        signUp = (Button) root.findViewById(R.id.btn_signUp);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                if (initializeText())
                {
                    log("inside fucking IF statement");
                    signUp.setEnabled(false);

                    BacktoryUser user = new BacktoryUser.Builder()
                            .setFirstName(f_name)
                            .setLastName(l_name)
                            .setEmail(email)
                            .setUsername(email)
                            .setPhoneNumber("")
                            .setPassword(SecurityManager.hash_to_SHA1(pass))
                            .build();
                    log("user is created");
                    user.registerInBackground(new BacktoryCallBack<BacktoryUser>() {
                        @Override
                        public void onResponse(BacktoryResponse<BacktoryUser> response)
                        {
                            if (response.isSuccessful())
                            {
                                Toast.makeText(getContext() , "ایمیل خود را چک کنید و بعد ورود کنید" , Toast.LENGTH_SHORT).show();
                                signUp.setText("ایمیل خود را چک کنید");
                            }
                            else if (response.code() == HttpStatusCode.Conflict.code())
                            {
                                Toast.makeText(getContext() , "این ایمیل قبلا ثبت شده است" , Toast.LENGTH_SHORT).show();
                                signUp.setEnabled(true);
                            }
                            else
                            {
                                Toast.makeText(getContext() , "ثبت نام با مشکل مواجه شد.لطفا دوباره تلاش کنید" , Toast.LENGTH_SHORT).show();
                                signUp.setEnabled(true);
                            }
                        }
                    });

                }
            }
        });
        return root;
    }

    private boolean initializeText()
    {
        log("initializeText Method");

        f_name = Name.getText().toString();
        l_name = lName.getText().toString();
        pass = Pass.getText().toString();
        repass = rePass.getText().toString();
        email = Email.getText().toString();



        if (f_name.equals("") || l_name.equals("") || pass.equals("") || email.equals(""))
        {
            Toast.makeText(getContext() , "تمامی فیلد هارا پر کنید" , Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (!pass.equals(repass))
        {
            Toast.makeText(getContext() , "رمز عبور های وارد شده یکی نیستند" , Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (!email.contains("@") || !email.contains("."))
        {
            Toast.makeText(getContext() , "ایمیل وارد شده معتبر نیست" , Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (pass.length() < 4)
        {
            Toast.makeText(getContext() , "حد اقل طول رمز عبور 4 کاراکتر است" , Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (!checkbox_larws.isChecked())
        {
            Toast.makeText(getContext() , "برای استفاده باید قوانین را راعایت کنید" , Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            return true;
        }

    }


}
