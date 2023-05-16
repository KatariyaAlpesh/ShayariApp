package com.example.shayari.MainActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.shayari.Config;
import com.example.shayari.Adapter.MainActivity2_Category_Adapter;
import com.example.shayari.R;

public class MainActivity2 extends AppCompatActivity
{
    ListView listView2;

    int shayariCategoryPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView2 = findViewById(R.id.ListView2);


//////////////----->>>>      Get DATA From MainActivity     <<<<<<---------///////////////////////////////////////////


        shayariCategoryPosition = getIntent().getIntExtra("shayariCategoryPosition" , 0);


        MainActivity2_Category_Adapter mainActivity2_category_adapter = new MainActivity2_Category_Adapter(this ,
                                                                        Config.imageArray[shayariCategoryPosition] ,
                                                                        Config.allShayariArray[shayariCategoryPosition],
                                                                        Config.emoji1Array ,
                                                                        Config.emoji2Array);

        listView2.setAdapter(mainActivity2_category_adapter);



        listView2.setOnItemClickListener((adapterView, view, i, l) -> {

                Intent Inext;
                Inext = new Intent(MainActivity2.this , MainActivity3.class);
                Inext.putExtra("shayariPosition",i);
                Inext.putExtra("allshayariArray",Config.allShayariArray[shayariCategoryPosition]);
                startActivity(Inext);
//                finish();

        });

    }
}