package com.example.shayari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

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

//        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener()
//        {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
//            {
//
//        Intent Inext;
//        Inext = new Intent(MainActivity2.this , MainActivity3.class);
//        Inext.putExtra("shayariPosition",i);
//        Inext.putExtra("allshayariArray",Config.allShayariArray[shayariCategoryPosition]);
//        finish();

//            }
//        });

    }
}