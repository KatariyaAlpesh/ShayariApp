package com.example.shayari;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity1_Shayari_Adapter extends BaseAdapter
{

    MainActivity1 mainActivity;

    String[] shayariNameArray;
    int[] imageArray;

    public MainActivity1_Shayari_Adapter(MainActivity1 mainActivity, int[] imageArray, String[] shayariNameArray)
    {
        this.mainActivity = mainActivity;
        this.imageArray = imageArray;
        this.shayariNameArray = shayariNameArray;

    }

    @Override
    public int getCount() {
        return imageArray.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        view = LayoutInflater.from(mainActivity).inflate(R.layout.activity_main_image_page, viewGroup , false);

        TextView name = view.findViewById(R.id.Name);
        ImageView image = view.findViewById(R.id.Image);

        name.setText(shayariNameArray[i]);
        image.setImageResource(imageArray[i]);

        return view;
    }
}
