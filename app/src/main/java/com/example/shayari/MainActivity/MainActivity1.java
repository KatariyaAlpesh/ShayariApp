package com.example.shayari.MainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.shayari.Config;
import com.example.shayari.Adapter.MainActivity1_Shayari_Adapter;
import com.example.shayari.R;

public class MainActivity1 extends AppCompatActivity
{

    ListView ListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView = findViewById(R.id.ListView);


///////////------>>>>>>>   Adapter For Shayari Name     <<<<<-------///////////////////////////////////////////////////////


        MainActivity1_Shayari_Adapter mainActivity_shayari_adapter = new MainActivity1_Shayari_Adapter
                                                                    (MainActivity1.this ,
                                                                                Config.imageArray ,
                                                                                Config.shayariNameArray);
        ListView.setAdapter(mainActivity_shayari_adapter);


///////////------->>>>>>>>  Read & Write Permissition For Gallery      <<<<<<--------////////////////////////////////////////////


        ActivityCompat.requestPermissions(MainActivity1.this ,
                                          new String[]{Manifest.permission.READ_EXTERNAL_STORAGE ,
                                          Manifest.permission.WRITE_EXTERNAL_STORAGE} , 1);


        ListView.setOnItemClickListener((adapterView, view, i, l) -> {

            Intent Inext;
            Inext = new Intent(MainActivity1.this , MainActivity2.class);
            Inext.putExtra("shayariCategoryPosition" , i);
            startActivity(Inext);

        });
    }

}

// public static String[][] allShayariArray = { shubhakamanayeArray,dostiArray,majedarArray,
//                                                bhagvanArray,preamArray,jivanArray,
//                                                mohabbteinArray,yadeArray,anayaArray,
//                                                rajnitiArray};