package com.example.prjcompositlistview.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prjcompositlistview.R;

import java.util.ArrayList;

public class PlayerAdapter extends BaseAdapter {


    private Context context;
    private ArrayList<Player> listOfPlayers;


    Player player;

    public PlayerAdapter(Context context, ArrayList<Player> listOfPlayers) {
        this.context = context;
        this.listOfPlayers = listOfPlayers;
    }

    @Override
    public int getCount() {
        return listOfPlayers.size();
    }

    @Override
    public Object getItem(int i) {
        return listOfPlayers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View oneItem;

        TextView tvFullname, tvTeamName;
        ImageView imPhoto,imMore;

        //layout inflation: convert any layout manager to java view object

        LayoutInflater inflater = LayoutInflater.from(context);
        oneItem = inflater.inflate(R.layout.one_item, viewGroup, false);


        tvFullname = oneItem.findViewById(R.id.tvFullname);
        tvTeamName = oneItem.findViewById(R.id.tvTeamName);
        imPhoto = oneItem.findViewById(R.id.imPhoto);
        imMore = oneItem.findViewById(R.id.imMore);

        player = listOfPlayers.get(i);
        tvFullname.setText(player.getFullName());
        tvTeamName.setText(player.getTeamName());
        imMore.setImageResource(R.drawable.more);
        String photoName = player.getPhoto();
        int photoResId = context.getResources().getIdentifier("drawable/"+photoName,null, context.getPackageName());
        imPhoto.setImageResource(photoResId);


        return oneItem;
    }


}
