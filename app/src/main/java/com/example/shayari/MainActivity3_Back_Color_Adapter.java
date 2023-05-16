package com.example.shayari;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MainActivity3_Back_Color_Adapter extends BaseAdapter
{

    Context context;     //////     Context
    int[] backgroundArray;    //////    Color Background Array
    String str;   /////   bg , single

    public MainActivity3_Back_Color_Adapter(Context context, int[] backgroundArray, String str)
    {
        this.context = context;
        this.backgroundArray = backgroundArray;
        this.str = str;
    }

    @Override
    public int getCount()
    {
        return backgroundArray.length;
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

        view = LayoutInflater.from(context).inflate(R.layout.background_color_item_page , viewGroup , false);

        TextView textView = view.findViewById(R.id.Background_Color_Item_text);

        if(str.equals("single"))
        {
            textView.setBackgroundColor(context.getResources().getColor(backgroundArray[i]));

        } else {

            textView.setBackgroundResource(backgroundArray[i]);
        }

        return view;
    }
}
