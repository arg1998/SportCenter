package ir.mafiaaa.sportcenter;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ARG on 9/15/2017 - 8:23 PM
 */

public class MyFavoriteTeamHandler
{
    Context context;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public MyFavoriteTeamHandler(Context context)
    {
        this.context = context;
        preferences = context.getSharedPreferences("userdata" ,Context.MODE_PRIVATE);

    }

    public void saveMyFavoriteTeam(String teamName)
    {
        editor = preferences.edit();
        editor.putString("favoriteTeam" , teamName);
        editor.apply();
        getMyFavoriteTeam();
    }

    public Team getMyFavoriteTeam() {
        League mylLeague = new League(context, Leagues.primaryLeague);
        mylLeague.initializeLeague();

        String mTeam = preferences.getString("favoriteTeam", "پرسپولیس");
        if (mTeam.equals("پرسپولیس"))
        {
            Team.setMyTeam(mylLeague.perspolis_tehran);
        }
        else if(mTeam.equals("استقلال تهران"))
        {
            Team.setMyTeam(mylLeague.esteghlal_tehran);
        }
        return Team.getMyTeam();
    }
}
