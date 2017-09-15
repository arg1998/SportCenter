package ir.mafiaaa.sportcenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.backtory.java.internal.BacktoryUser;

public class WelcomeActivity extends AppCompatActivity {
    private void log(String s)
    {
        Log.i("NoEmulators", s);
    }

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        button = (Button) findViewById(R.id.start);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BacktoryUser me = BacktoryUser.getCurrentUser();

                if (me == null)
                {
                    Intent intent = new Intent(WelcomeActivity.this,
                            Register.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(WelcomeActivity.this,
                            Main.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                }
            }
        });

    }

}
