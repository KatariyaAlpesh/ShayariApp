package com.example.shayari.MainActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.shayari.Config;
import com.example.shayari.Adapter.EmojiAdapter;
import com.example.shayari.Adapter.FontAdapter;
import com.example.shayari.Adapter.MainActivity3_Back_Color_Adapter;
import com.example.shayari.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MainActivity4 extends AppCompatActivity
{

    TextView shayariOnEditPage;
    ImageView expandBackgroundOnEditPage , reloadBackgroundOnEditPage , close;
    Button buttonBackgroundOnEditPage , buttonTextColorOnEditPage , buttonShareOnEditPage;
    Button buttonFontOnEditPage , buttonEmojiOnEditPage , buttonTextSizeOnEditPage;
    String shayari , emoji1 , emoji2;
    Typeface typeface;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        shayariOnEditPage = findViewById(R.id.ShayariOnEditPage);
        buttonBackgroundOnEditPage = findViewById(R.id.ButtonBackgroundOnEditPage);
        buttonTextColorOnEditPage = findViewById(R.id.ButtonTextColorOnEditPage);
        buttonShareOnEditPage = findViewById(R.id.ButtonShareOnEditPage);
        buttonFontOnEditPage = findViewById(R.id.ButtonFontOnEditPage);
        buttonEmojiOnEditPage = findViewById(R.id.ButtonEmojiOnEditPage);
        buttonTextSizeOnEditPage = findViewById(R.id.ButtonTextSizeOnEditPage);
        expandBackgroundOnEditPage = findViewById(R.id.ExpandBackgroundOnEditPage);
        reloadBackgroundOnEditPage = findViewById(R.id.ReloadBackgroundOnEditPage);


////////////====>>>>.    Get Data From MainActivity-3     <<<<<<====  ///////////////////////////////////////////

        shayari = getIntent().getStringExtra("shayari");
        emoji1 = getIntent().getStringExtra("emoji1");
        emoji2 = getIntent().getStringExtra("emoji2");


/////////////======>>>>>>>>>     Set Shayari On EditPage    <<<<<<<<=======////////////////////////////////////////////

        shayariOnEditPage.setText(emoji1 + "\n" + shayari + "\n" + emoji2);


/////////========>>>>>>>    For Change Background Color Click on   {  reloadBackgroundOnEditPage  }    <<---//////////////////////


        reloadBackgroundOnEditPage.setOnClickListener(v -> {

            int min = 0;     ////    MINIMUM      &&    MAXIMUM
            int max = Config.backgroundArray.length;

            int position = new Random().nextInt(max - min) + min;

            shayariOnEditPage.setBackgroundResource(Config.backgroundArray[position]);
        });


////////////////====>>>>    Change Color with Expand Butoon Click on   {  expandBackgroundOnEditPage  } //////////////////////////////


        expandBackgroundOnEditPage.setOnClickListener(v -> {

            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
//            bottomSheetDialog.setCancelable(false);
            View view = getLayoutInflater().inflate(R.layout.background_color_file,null,false);
            bottomSheetDialog.setContentView(view);

            GridView gridView = view.findViewById(R.id.BackgroundColorFile);

            MainActivity3_Back_Color_Adapter mainActivity3_back_color_adapter = new MainActivity3_Back_Color_Adapter(
                    this ,
                    Config.backgroundArray ,
                    "bg");
            gridView.setAdapter(mainActivity3_back_color_adapter);

            gridView.setOnItemClickListener((parent, view1, position, id) -> {

                    shayariOnEditPage.setBackgroundResource(Config.backgroundArray[position]);
                    bottomSheetDialog.dismiss();
                });

                    close = view.findViewById(R.id.BackgroundColorCloseButton);
                    close.setOnClickListener(view1 -> {

                        bottomSheetDialog.dismiss();

                    });

            bottomSheetDialog.show();

        });


////////////////====>>>>    Change Color with Background Butoon Click on   {  buttonBackgroundOnEditPage  } //////////////////////////////


        buttonBackgroundOnEditPage.setOnClickListener(v -> {

            BottomSheetDialog  bottomSheetDialog = new BottomSheetDialog(this);
            bottomSheetDialog.setCancelable(false);

            View view = getLayoutInflater().inflate(R.layout.background_color_file ,null,false);
            bottomSheetDialog.setContentView(view);

            GridView gridView = view.findViewById(R.id.BackgroundColorFile);
            gridView.setNumColumns(6);

            MainActivity3_Back_Color_Adapter mainActivity3_back_color_adapter = new MainActivity3_Back_Color_Adapter(
                    this ,
                    Config.colorArray ,
                    "single");
            gridView.setAdapter(mainActivity3_back_color_adapter);


            gridView.setOnItemClickListener((adapterView, view1, i, l) -> {

                        shayariOnEditPage.setBackgroundColor(getResources().getColor(Config.colorArray[i]));
                        bottomSheetDialog.dismiss();

                    });

                        close = view.findViewById(R.id.BackgroundColorCloseButton);
                        close.setOnClickListener(view1 -> {

                            bottomSheetDialog.dismiss();

                    });

                bottomSheetDialog.show();

        });


////////////////====>>>>    Change Text Color with Text Butoon Click on   {  buttonTextColorOnEditPage  } //////////////////////////////


        buttonTextColorOnEditPage.setOnClickListener(v -> {

            BottomSheetDialog  bottomSheetDialog = new BottomSheetDialog(this);
            bottomSheetDialog.setCancelable(false);
            View view = getLayoutInflater().inflate(R.layout.background_color_file,null,false);
            bottomSheetDialog.setContentView(view);

            GridView gridView = view.findViewById(R.id.BackgroundColorFile);
            gridView.setNumColumns(6);

            MainActivity3_Back_Color_Adapter mainActivity3_back_color_adapter = new MainActivity3_Back_Color_Adapter(
                    this ,
                    Config.colorArray ,
                    "single");
            gridView.setAdapter(mainActivity3_back_color_adapter);

            gridView.setOnItemClickListener((adapterView, view1, i, l) -> {

                    shayariOnEditPage.setTextColor(getResources().getColor(Config.colorArray[i]));
                    bottomSheetDialog.dismiss();

                });

                close = view.findViewById(R.id.BackgroundColorCloseButton);
                close.setOnClickListener(v1 -> {

                    bottomSheetDialog.dismiss();

                });

            bottomSheetDialog.show();

        });


///////////---->>>>>>    Add Emoji In Shayari to Click on Button Press  {  buttonEmojiOnEditPage  } <<<<----//////////////////////////


        buttonEmojiOnEditPage.setOnClickListener(v -> {

            BottomSheetDialog  bottomSheetDialog = new BottomSheetDialog(this);
            bottomSheetDialog.setCancelable(false);
            View view = getLayoutInflater().inflate(R.layout.emoji_file ,null , false);
            bottomSheetDialog.setContentView(view);

            ListView listView = view.findViewById(R.id.EmojiList);

            EmojiAdapter emojiAdapter = new EmojiAdapter(this, Config.emojiArray);
            listView.setAdapter(emojiAdapter);

            listView.setOnItemClickListener((adapterView, view1, i, l) ->  {

                    if ( i == (Config.emojiArray.length - 1) )
                    {
                        shayariOnEditPage.setText(shayari);
                    }
                    else
                    {
                        shayariOnEditPage.setText(Config.emojiArray[i] + "\n" + shayari + "\n" + Config.emojiArray[i]);
                    }

                    bottomSheetDialog.dismiss();

                });

                    close = view.findViewById(R.id.CloseEmojiButton);
                    close.setOnClickListener(v1 -> {

                        bottomSheetDialog.dismiss();

                });

            bottomSheetDialog.show();

        });



////////////----->>>>    CHANGE Font Stayel To Press On Button Click   {  buttonFontOnEditPage  }     ////////////////////////////////


        buttonFontOnEditPage.setOnClickListener(v -> {

            BottomSheetDialog  bottomSheetDialog = new BottomSheetDialog(this);
            bottomSheetDialog.setCancelable(false);
            View view = getLayoutInflater().inflate(R.layout.emoji_file ,null ,false);
            bottomSheetDialog.setContentView(view);

            ListView listView = view.findViewById(R.id.EmojiList);
            FontAdapter fontAdapter = new FontAdapter(this, Config.fontArray);
            listView.setAdapter(fontAdapter);

            listView.setOnItemClickListener((adapterView, view1, i, l) ->  {

                    typeface = Typeface.createFromAsset(getAssets(), "font/" + Config.fontArray2[i]);
                    shayariOnEditPage.setTypeface(typeface);
                    bottomSheetDialog.dismiss();

                });

                    close = view.findViewById(R.id.CloseEmojiButton);
                    close.setOnClickListener(v1 -> {

                        bottomSheetDialog.dismiss();

                });

            bottomSheetDialog.show();
        });


//////////////=====>>>>>>     Change Button Text Size Click on     { buttonTextSizeOnEditPage  }     <<<<<==/////////////////////////


        buttonTextSizeOnEditPage.setOnClickListener(v -> {

            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
            bottomSheetDialog.setCancelable(false);

            View view = getLayoutInflater().inflate(R.layout.text_size_layout , null , false);
            bottomSheetDialog.setContentView(view);

            SeekBar seekBar = view.findViewById(R.id.SeekBar);
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
            {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b)
                {
                    shayariOnEditPage.setTextSize(i);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {}

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {}

            });

            close = view.findViewById(R.id.CloseButtonTextSize);
            close.setOnClickListener(view1 -> {

                bottomSheetDialog.dismiss();

            });

            bottomSheetDialog.show();

        });


/////////////////===>>>>>>>     Share your Shayari Click On {  buttonShareOnEditPage  } <<<<<<------/////////////////////////////////


        buttonShareOnEditPage.setOnClickListener(v -> {

//            Intent intent = new Intent(android.content.Intent.ACTION_SEND);

//            String shareBody = emoji1.getText().toString() + "\n" +
//                    shayari.getText().toString() + "\n" +
//                    emoji2.getText().toString() + "\n/*Shared by myApp*/ ";
//
//            intent.setType("text/plain");
//            intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
//            startActivity(Intent.createChooser(intent, "share"));
            Bitmap icon = getBitmapFromView(shayariOnEditPage);

            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("image/jpeg");


            ByteArrayOutputStream BAOS = new ByteArrayOutputStream();
            icon.compress(Bitmap.CompressFormat.JPEG , 100 , BAOS);


            SimpleDateFormat dataFormat = new SimpleDateFormat("YYYYMMDD_HH_MM_SS");
            String currentTimeStamp = dataFormat.format(new Date());


            File F = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) +
                    "demo/" + currentTimeStamp + ".jpeg");

            try
            {
                F.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(F);
                fileOutputStream.write(BAOS.toByteArray());
                fileOutputStream.close();

            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }

            share.putExtra(Intent.EXTRA_STREAM , Uri.fromFile(F));
            startActivity(Intent.createChooser(share , "Share Image"));

        });

    }
    public static Bitmap getBitmapFromView(View view) {
        //Define a bitmap with the same size as the view
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable =view.getBackground();
        if (bgDrawable!=null)
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        else
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
        // draw the view on the canvas
        view.draw(canvas);
        //return the bitmap
        return returnedBitmap;
    }


}