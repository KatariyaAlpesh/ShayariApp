package com.example.shayari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity
{
    TextView shayari,emoji1,emoji2,shayariNo;
    ImageView previousShayari,edit,copyShayari,nextShayari,shareShayari;
    ImageView expandBackground,reloadBackground;

    int shayariPosition;
    String[] shayariArray;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        shayari = findViewById(R.id.shayari);
        emoji1 = findViewById(R.id.emoji1);
        emoji2 = findViewById(R.id.emoji2);
        shayariNo = findViewById(R.id.shayariNo);
        edit = findViewById(R.id.edit);
        previousShayari = findViewById(R.id.previousShayari);
        copyShayari = findViewById(R.id.copyShayari);
        nextShayari = findViewById(R.id.nextShayari);
        shareShayari = findViewById(R.id.shareShayari);
        expandBackground = findViewById(R.id.expandBackground);
        reloadBackground = findViewById(R.id.reloadBackground);


//////////===--->>>>    Get Extra Intent From MainActivity-2   <<<<<<----======///////////////////////////////////////////////////

        shayariPosition = getIntent().getIntExtra("shayariPosition",0);
        shayariArray = getIntent().getStringArrayExtra("allshayariArray");


        shayariNo.setText( (shayariPosition + 1) + "/" + shayariArray.length);
        shayari.setText(shayariArray[shayariPosition]);
        emoji1.setText(Config.emoji1Array[shayariPosition]);
        emoji2.setText(Config.emoji2Array[shayariPosition]);


        reloadBackground.setOnClickListener(v -> {

            int min = 0;
            int max = Config.backgroundArray.length;

            int position = new Random().nextInt(max - min) + min;

            shayari.setBackgroundResource(Config.backgroundArray[position]);
            emoji1.setBackgroundResource(Config.backgroundArray[position]);
            emoji2.setBackgroundResource(Config.backgroundArray[position]);
        });

        expandBackground.setOnClickListener(v -> {

            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
//            bottomSheetDialog.setCancelable(false);
            View view = getLayoutInflater().inflate(R.layout.background_color_file,null,false);
            bottomSheetDialog.setContentView(view);

            GridView gridView = view.findViewById(R.id.BackgroundColorFile);


/////////////=========>>>>>>>     Adapter For Back Color     <<<<<<<<<===============///////////////////////////////////////////


            MainActivity3_Back_Color_Adapter backgroundColorAdapter = new MainActivity3_Back_Color_Adapter(this, Config.backgroundArray,"bg");
            gridView.setAdapter(backgroundColorAdapter);

            gridView.setOnItemClickListener((parent, view1, position, id) -> {

                shayari.setBackgroundResource(Config.backgroundArray[position]);
                emoji1.setBackgroundResource(Config.backgroundArray[position]);
                emoji2.setBackgroundResource(Config.backgroundArray[position]);
                bottomSheetDialog.dismiss();
            });

            bottomSheetDialog.show();

        });


//////////////==========>>>>     CODE FOR SHAYARI COPY       <<<<<<<<<<=======////////////////////////////////////////////


        copyShayari.setOnClickListener(v -> {

            ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("label" ,
                                                    emoji1.getText().toString() + "\n" +
                                                        shayari.getText().toString() + "\n" +
                                                        emoji2.getText().toString() );
            clipboard.setPrimaryClip(clip);
            Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show();

        });


////////////========>>>>>>>>    Go to PreviousShayari On Click     { previousShayari }   <<<==////////////////////////////////


        previousShayari.setOnClickListener(v -> {

            if( shayariPosition > 0 )
            {
                shayariPosition--;   ///    Doing -- For Going Back

                shayari.setText(shayariArray[shayariPosition]);
                emoji1.setText(Config.emoji1Array[shayariPosition]);
                emoji2.setText(Config.emoji2Array[shayariPosition]);

                shayariNo.setText( (shayariPosition + 1) + "/" + shayariArray.length);
            }

        });


////////////========>>>>>>>>    Go to NextShayari On Click     { nextShayari }   <<<==/////////////////////////////////////////


        nextShayari.setOnClickListener(v -> {

            if( shayariPosition < shayariArray.length-1 )
            {
                shayariPosition++;      ///   Doing ++ For Going next

                shayari.setText(shayariArray[shayariPosition]);
                emoji1.setText(Config.emoji1Array[shayariPosition]);
                emoji2.setText(Config.emoji2Array[shayariPosition]);

                shayariNo.setText( (shayariPosition + 1) + "/" + shayariArray.length);
            }

        });


///////////========>>>>>>>>     Code for Sharing Shayari To Another <<<<<<<<<===========//////////////////////////


        shareShayari.setOnClickListener(v -> {

            Intent intent = new Intent(android.content.Intent.ACTION_SEND);

            String shareBody = emoji1.getText().toString() + "\n" +
                               shayari.getText().toString() + "\n" +
                               emoji2.getText().toString() + "\n/*Shared by myApp*/ ";

            intent.setType("text/plain");
            intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(intent, "share"));

        });

        edit.setOnClickListener(v -> {

            Intent intent3= new Intent(MainActivity3.this,MainActivity4.class);

            intent3.putExtra("shayari",shayari.getText().toString());
            intent3.putExtra("emoji1",emoji1.getText().toString());
            intent3.putExtra("emoji2",emoji2.getText().toString());

            startActivity(intent3);

        });

    }

}