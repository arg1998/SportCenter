package ir.mafiaaa.sportcenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ARG on 9/15/2017 - 6:00 PM
 */

public class LeagueRankingAdapter extends RecyclerView.Adapter<LeagueRankingAdapter.ViewHolder>
{
    ArrayList<Team> teams;
    League league;

    public LeagueRankingAdapter(Context c)
    {
        league = new League(c,Leagues.primaryLeague);
        league.initializeLeague();
        teams = league.getTeams();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.league_ranking_row , parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Team team = teams.get(position);
        holder.tvRank.setText(String.valueOf(team.getRanking()));
        holder.tvName.setText(team.getName());
        holder.imgLogo.setImageBitmap(team.getLogo());
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView tvRank, tvName;
        public CircleImageView imgLogo;

        public ViewHolder(View view)
        {
            super(view);
            tvName = (TextView) view.findViewById(R.id.league_row_team_name);
            tvRank = (TextView) view.findViewById(R.id.league_row_team_rank);
            imgLogo = (CircleImageView) view.findViewById(R.id.league_row_team_logo);
        }
    }
}
