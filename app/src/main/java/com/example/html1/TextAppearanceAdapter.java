package com.example.html1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;

import com.google.android.glass.widget.CardScrollAdapter;

public class TextAppearanceAdapter extends CardScrollAdapter {

    enum TextAppearanceLayout {
        PAGE_1(R.layout.text_appearance_page_1);

        private final int mResourceID;

        TextAppearanceLayout(int resourceID) {
            mResourceID = resourceID;
        }

        int getResourceID()
        {
            return mResourceID;
        }
    }

    private LayoutInflater mLayoutInflater;

    public TextAppearanceAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return TextAppearanceLayout.values().length;
    }

    @Override
    public TextAppearanceLayout getItem(int i) {
        return TextAppearanceLayout.values()[i];
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = null;

        if (view != null) {
            v = view;
        } else {
            v = mLayoutInflater.inflate(getItem(i).getResourceID(), null);
        }

        return v;
    }

    @Override
    public int getPosition(Object o) {
        for (int i = 0; i < TextAppearanceLayout.values().length; i++) {
            if (getItem(i).equals(o)) {
                return i;
            }
        }

        return AdapterView.INVALID_POSITION;
    }
}
