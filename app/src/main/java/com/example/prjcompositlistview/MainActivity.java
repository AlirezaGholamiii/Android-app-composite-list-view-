package com.example.prjcompositlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.prjcompositlistview.model.FileManagement;
import com.example.prjcompositlistview.model.Player;
import com.example.prjcompositlistview.model.PlayerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvPlayer;
    ArrayList<Player> listOfPlayers;
    PlayerAdapter playerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize(){
        lvPlayer = findViewById(R.id.lvPlayers);
        listOfPlayers = FileManagement.readFile(this,"players.txt");
        playerAdapter = new PlayerAdapter(this, listOfPlayers);
        lvPlayer.setAdapter(playerAdapter);
    }
}