package com.example.prjcompositlistview.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileManagement {

    public static ArrayList<Player> readFile(Context context, String filename){

        ArrayList<Player> listOfPlayers = new ArrayList<Player>();

        //1 Access to the assets folder
        AssetManager assManager = context.getResources().getAssets();

        //2 open the file
        try {
            InputStreamReader isr = new InputStreamReader(assManager.open(filename));


            //3 read and posses the file
            BufferedReader br = new BufferedReader(isr);
            String oneLine = br.readLine();
            while (oneLine!=null){

                StringTokenizer st = new StringTokenizer(oneLine, ",");

                String fullname = st.nextToken();
                String teamName = st.nextToken();
                try{
                    int yearOfBirth = Integer.valueOf(st.nextToken());
                    String photo = st.nextToken();
                    listOfPlayers.add(new Player(fullname,teamName,yearOfBirth, photo));

                }catch (Exception e){
                    Log.d("Error", e.getMessage());
                }

                oneLine = br.readLine();

            }
            //4 close buffer and stream
            br.close();
            isr.close();

        } catch (IOException e) {

            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


        return listOfPlayers;
    }
}
