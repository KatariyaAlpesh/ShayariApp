package com.example.shayari.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shayari.Config;
import com.example.shayari.R;

public class FontAdapter extends BaseAdapter
{

    Context context;
    int[] fontArray;

    public FontAdapter(Context context , int[] fontArray)
    {
        this.context = context;
        this.fontArray = fontArray;

    }

    @Override
    public int getCount()
    {
        return fontArray.length;
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

        view = LayoutInflater.from(context).inflate(R.layout.emoji_item_page , viewGroup , false);

        TextView textView = view.findViewById(R.id.EmojiItemText);
        Typeface typeface = null;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            // Only if this font function supports in your phone
            typeface = context.getResources().getFont(fontArray[i]);
            textView.setTypeface(typeface);
            textView.setText("Shayari");

        }
        else
        {

            typeface = Typeface.createFromAsset(context.getAssets(), "font/" + Config.fontArray2[i]);
            textView.setTypeface(typeface);
            textView.setText("Shayari");
        }

        return view;
    }
}
