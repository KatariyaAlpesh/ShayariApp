package com.example.shayari.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shayari.Config;
import com.example.shayari.R;

public class EmojiAdapter extends BaseAdapter
{

    Context context;
    String[] emojiArray;

    public EmojiAdapter(Context context, String[] emojiArray)
    {
        this.context = context;
        this.emojiArray = emojiArray;

    }

    @Override
    public int getCount()
    {
        return emojiArray.length;
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

        textView.setText(Config.emojiArray[i]);

        return view;
    }
}
