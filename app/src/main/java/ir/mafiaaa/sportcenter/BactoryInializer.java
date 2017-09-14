package ir.mafiaaa.sportcenter;

import android.app.Application;

import com.backtory.java.internal.BacktoryClient;
import com.backtory.java.internal.Config;

/**
 * Created by ARG on 9/14/2017 - 4:01 PM
 */

public class BactoryInializer extends Application
{
    @Override
    public void onCreate() {
        super.onCreate();

        // Initializing backtory
        BacktoryClient.Android.init(Config.newBuilder()
                .initAuth("59ba6573e4b055bfe6e605a1", "59ba6573e4b0416729e792d4")
                .initObjectStorage("59ba6573e4b055bfe6e605a2")
                .build(), this);
    }
}
