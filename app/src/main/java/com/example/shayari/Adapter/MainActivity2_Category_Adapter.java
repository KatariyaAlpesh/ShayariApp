package com.example.shayari.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shayari.MainActivity.MainActivity2;
import com.example.shayari.R;

public class MainActivity2_Category_Adapter extends BaseAdapter
{
    MainActivity2 mainActivity2;
    int imageArray;
    String[] allShayariArray;
    String[] emoji1Array;
    String[] emoji2Array;

    public MainActivity2_Category_Adapter(MainActivity2 mainActivity2 ,
                                          int imageArray ,
                                          String[] allShayariArray ,
                                          String[] emoji1Array ,
                                          String[] emoji2Array)
    {
         this.mainActivity2 = mainActivity2;
         this.imageArray = imageArray;
         this.allShayariArray = allShayariArray;
         this.emoji1Array = emoji1Array;
         this.emoji2Array = emoji2Array;

    }

    @Override
    public int getCount()
    {
        return allShayariArray.length;
    }

    @Override
    public Object getItem(int i)
    {
        return i;
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        view = LayoutInflater.from(mainActivity2).inflate(R.layout.activity_main2_image_page , viewGroup , false);

        ImageView imageClicked = view.findViewById(R.id.ImageClicked_ImagePage);
        imageClicked.setImageResource(imageArray);

        TextView textView = view.findViewById(R.id.TextClicked_ImagePage);
        textView.setText(emoji1Array[i] + allShayariArray[i].substring(0,20) + emoji2Array[i]);

        return view;
    }
}
