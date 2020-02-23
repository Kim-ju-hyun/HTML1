package com.example.html1;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.google.android.glass.widget.CardBuilder;
import com.google.android.glass.widget.CardScrollAdapter;

import java.util.List;

public class MainAdapter extends CardScrollAdapter {

    final List<CardBuilder> mCards;

    public MainAdapter(List<CardBuilder> cards) {
        mCards = cards;
    }

    @Override
    public int getCount() {
        return mCards.size();
    }

    @Override
    public Object getItem(int i) {
        return mCards.get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return mCards.get(i).getView(view, viewGroup);
    }

    @Override
    public int getPosition(Object o) {
        for (int i = 0; i < mCards.size(); i++)
        {
            if (getItem(i).equals(o)) {
                return i;
            }
        }
        return AdapterView.INVALID_POSITION;
    }

    @Override
    public int getViewTypeCount() {
        return CardBuilder.getViewTypeCount();
    }

    @Override
    public int getItemViewType(int position) {
        return mCards.get(position).getItemViewType();
    }
}
