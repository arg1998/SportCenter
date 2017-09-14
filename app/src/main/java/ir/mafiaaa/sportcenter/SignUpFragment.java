package ir.mafiaaa.sportcenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class SignUpFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

    AppCompatEditText Name;
    AppCompatEditText lName;
    AppCompatEditText Email;
    AppCompatEditText Pass;
    AppCompatEditText rePass;
    TextInputLayout nameLayout;
    TextInputLayout lNameLayout;
    TextInputLayout emailLayout;
    TextInputLayout passLayout;
    TextInputLayout rePassLayout;
    RelativeLayout relativeLayout;

    private Button signUp;




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
        nameLayout = (TextInputLayout) root.findViewById(R.id.FName_TextInputLayout);
        lNameLayout = (TextInputLayout) root.findViewById(R.id.LName_TextInputLayout);
        emailLayout= (TextInputLayout) root.findViewById(R.id.Email_TextInputLayout);
        passLayout = (TextInputLayout) root.findViewById(R.id.PassS_TextInputLayout);
        rePassLayout = (TextInputLayout) root.findViewById(R.id.rePass_TextInputLayout);
        relativeLayout = (RelativeLayout) root.findViewById(R.id.SignUp);

        signUp = (Button) root.findViewById(R.id.btn_signUp);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getActivity(),Main.class);
               startActivity(intent);
            }
        });
        return root;
    }

    // TODO: Rename method, update argument and hook method into UI event
}
