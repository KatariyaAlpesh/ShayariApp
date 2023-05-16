package com.example.shayari;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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
        view = LayoutInflater.from(context).inflate(R.layout.emoji_file , viewGroup , false);

        TextView textView = view.findViewById(R.id.EmojiItemText);

        textView.setText(Config.emojiArray[i]);

        return view;
    }
}
