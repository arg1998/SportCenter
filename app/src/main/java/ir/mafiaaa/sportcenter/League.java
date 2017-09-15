package ir.mafiaaa.sportcenter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.backtory.java.internal.BacktoryCallBack;
import com.backtory.java.internal.BacktoryObject;
import com.backtory.java.internal.BacktoryQuery;
import com.backtory.java.internal.BacktoryResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ARG on 9/15/2017 - 9:52 AM
 */

public class League {
    Context context;
    private ArrayList<Team> teams;
    private Leagues leagueType;

    public Team padideh_mashad;
    public Team parse_jonobi_jam;
    public Team esteghlal_khozestan;
    public Team esteghlal_tehran;
    public Team zobahan_esfahan;
    public Team teractor_sazi_tabriz;
    public Team peykan_tehran;
    public Team perspolis_tehran;
    public Team siah_jamegan_mashad;
    public Team sepidrod;
    public Team sepahan_esfahan;
    public Team saipa_tehran;
    public Team naft_tehran;
    public Team naft_abadan;
    public Team gostaresh_folad;
    public Team folad_khozestan;


    public League(Context context, Leagues leagueType) {
        this.context = context;
        this.leagueType = leagueType;
        teams = new ArrayList<>();
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public Leagues getLeagueType() {
        return leagueType;
    }

    public void initializeLeague() {
        leagueType = Leagues.primaryLeague;
        teams.clear();

        padideh_mashad = new Team();
        padideh_mashad.setName("پدیده مشهد");
        padideh_mashad.getCoach().setName("محمد رضا مهاجری");
        padideh_mashad.setLeague(leagueType);
        padideh_mashad.setRanking(16);
        padideh_mashad.setLogo(BitmapFactory.decodeResource(context.getResources(), R.drawable.padideh_mashhad));
        teams.add(padideh_mashad);

        parse_jonobi_jam = new Team();
        parse_jonobi_jam.setName("پارس جنوبی");
        parse_jonobi_jam.getCoach().setName("مهدی تار تار");
        parse_jonobi_jam.setLeague(leagueType);
        parse_jonobi_jam.setRanking(15);
        parse_jonobi_jam.setLogo(BitmapFactory.decodeResource(context.getResources(), R.drawable.parsjonobi));
        teams.add(parse_jonobi_jam);

        esteghlal_khozestan = new Team();
        esteghlal_khozestan.setName("استقلال خوزستان");
        esteghlal_khozestan.getCoach().setName("عبدله ویسی");
        esteghlal_khozestan.setLeague(leagueType);
        esteghlal_khozestan.setRanking(14);
        esteghlal_khozestan.setLogo(BitmapFactory.decodeResource(context.getResources(), R.drawable.esteghlal_khozestan));
        teams.add(esteghlal_khozestan);

        esteghlal_tehran = new Team();
        esteghlal_tehran.setName("استقلال تهران");
        esteghlal_tehran.getCoach().setName("علی رضا منصوریان");
        esteghlal_tehran.setLeague(leagueType);
        esteghlal_tehran.setRanking(13);
        esteghlal_tehran.setLogo(BitmapFactory.decodeResource(context.getResources(), R.drawable.esteghlal_tehran));
        teams.add(esteghlal_tehran);

        zobahan_esfahan = new Team();
        zobahan_esfahan.setName("ذوب آهن اصفهان");
        zobahan_esfahan.getCoach().setName("اردشیر قلعه نوعی");
        zobahan_esfahan.setLeague(leagueType);
        zobahan_esfahan.setRanking(12);
        zobahan_esfahan.setLogo(BitmapFactory.decodeResource(context.getResources(), R.drawable.zobahane_esfahan));
        teams.add(zobahan_esfahan);

        teractor_sazi_tabriz = new Team();
        teractor_sazi_tabriz.setName("تراکتور سازی تبریز");
        teractor_sazi_tabriz.getCoach().setName("یحی گل محمدی");
        teractor_sazi_tabriz.setLeague(leagueType);
        teractor_sazi_tabriz.setRanking(11);
        teractor_sazi_tabriz.setLogo(BitmapFactory.decodeResource(context.getResources(), R.drawable.teractorsazi_tabriz));
        teams.add(teractor_sazi_tabriz);

        peykan_tehran = new Team();
        peykan_tehran.setName("پیکان تهران");
        peykan_tehran.getCoach().setName("مجید جلالی");
        peykan_tehran.setLeague(leagueType);
        peykan_tehran.setRanking(10);
        peykan_tehran.setLogo(BitmapFactory.decodeResource(context.getResources(), R.drawable.peykan_tehran));
        teams.add(peykan_tehran);

        perspolis_tehran = new Team();
        perspolis_tehran.setName("پرسپولیس تهران");
        perspolis_tehran.getCoach().setName("برانکو ایوانکوویچ");
        perspolis_tehran.setLeague(leagueType);
        perspolis_tehran.setRanking(9);
        perspolis_tehran.setLogo(BitmapFactory.decodeResource(context.getResources(), R.drawable.perspolis));
        teams.add(perspolis_tehran);

        siah_jamegan_mashad = new Team();
        siah_jamegan_mashad.setName("سیاه جامگان مشهد");
        siah_jamegan_mashad.getCoach().setName("اکبر میثاقیان");
        siah_jamegan_mashad.setLeague(leagueType);
        siah_jamegan_mashad.setRanking(8);
        siah_jamegan_mashad.setLogo(BitmapFactory.decodeResource(context.getResources(), R.drawable.siah_jamegan_mashhad));
        teams.add(siah_jamegan_mashad);


        sepidrod = new Team();
        sepidrod.setName("سپید رود");
        sepidrod.getCoach().setName("غلی نظر محمدی");
        sepidrod.setLeague(leagueType);
        sepidrod.setRanking(7);
        sepidrod.setLogo(BitmapFactory.decodeResource(context.getResources(), R.drawable.sepidrod));
        teams.add(sepidrod);


        sepahan_esfahan = new Team();
        sepahan_esfahan.setName("سپاهان اصفهان");
        sepahan_esfahan.getCoach().setName("زلاتکو کرانچار");
        sepahan_esfahan.setLeague(leagueType);
        sepahan_esfahan.setRanking(6);
        sepahan_esfahan.setLogo(BitmapFactory.decodeResource(context.getResources(), R.drawable.sepahan_esfahan));
        teams.add(sepahan_esfahan);


        saipa_tehran = new Team();
        saipa_tehran.setName("سایپا");
        saipa_tehran.getCoach().setName("علی دایی");
        saipa_tehran.setLeague(leagueType);
        saipa_tehran.setRanking(5);
        saipa_tehran.setLogo(BitmapFactory.decodeResource(context.getResources(), R.drawable.saipa_alborz));
        teams.add(saipa_tehran);


        naft_tehran = new Team();
        naft_tehran.setName("نفت تهران");
        naft_tehran.getCoach().setName("حمید درخشان");
        naft_tehran.setLeague(leagueType);
        naft_tehran.setRanking(4);
        naft_tehran.setLogo(BitmapFactory.decodeResource(context.getResources(), R.drawable.naft_tehram));
        teams.add(naft_tehran);


        naft_abadan = new Team();
        naft_abadan.setName("نفت آبادان");
        naft_abadan.getCoach().setName("فراز کمال وند");
        naft_abadan.setLeague(leagueType);
        naft_abadan.setRanking(3);
        naft_abadan.setLogo(BitmapFactory.decodeResource(context.getResources(), R.drawable.naft_abadan));
        teams.add(naft_abadan);


        gostaresh_folad = new Team();
        gostaresh_folad.setName("گسترش فولاد");
        gostaresh_folad.getCoach().setName("لوکا بوناچیچ");
        gostaresh_folad.setLeague(leagueType);
        gostaresh_folad.setRanking(2);
        gostaresh_folad.setLogo(BitmapFactory.decodeResource(context.getResources(), R.drawable.gostaresh_folad_tabriz));
        teams.add(gostaresh_folad);


        folad_khozestan = new Team();
        folad_khozestan.setName("فولاد خوزستان");
        folad_khozestan.getCoach().setName("اکبر پور موسوی");
        folad_khozestan.setLeague(leagueType);
        folad_khozestan.setRanking(1);
        folad_khozestan.setLogo(BitmapFactory.decodeResource(context.getResources(), R.drawable.folad_khozestan));
        teams.add(folad_khozestan);

        sortTeamsBasedOnRanks();
    }

    public void sortTeamsBasedOnRanks() {
        Collections.sort(teams);
    }


    //// TODO: 9/15/2017 AMP
    public  ArrayList<Player> getPlayer()
    {
        final ArrayList<Player> players = new ArrayList<>();
        String mTeam = Team.getMyTeam().getName();


        BacktoryQuery query = new BacktoryQuery("players");
        query.whereEqualTo("team" , mTeam);
        query.findInBackground(new BacktoryCallBack<List<BacktoryObject>>() {
            @Override
            public void onResponse(BacktoryResponse<List<BacktoryObject>> backtoryResponse) {
                if (backtoryResponse.isSuccessful()) {
                    for (int i = 0; i < backtoryResponse.body().size(); i++)
                    {
                        Player p = new Player();
                        p.setName(backtoryResponse.body().get(i).getString("name"));
                        String position = backtoryResponse.body().get(i).getString("post");
                        Position playerPosition = Position.attacker;
                        switch (position)
                        {
                            case "مهاجم":
                                playerPosition = Position.attacker;
                                break;
                            case "هافبک":
                                playerPosition = Position.halfBack;
                                break;
                            case "مدافع":
                                playerPosition = Position.defence;
                                break;
                            case "دروازه بان":
                                playerPosition = Position.goalKeeper;
                                break;
                        }
                        p.setPosition(playerPosition);
                        players.add(p);
                    }
                }
                else
                {
                    Log.i("NoEmulators", "we're Fucked up now");
                }
            }
        });



        return players;
    }


}
