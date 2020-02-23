package com.example.html1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.google.android.glass.widget.CardBuilder;
import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;
import java.util.List;

public class HelloWordActivity extends Activity {
    private CardScrollView mCardScroller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCardScroller = new CardScrollView(this);
        mCardScroller.setAdapter(new MainAdapter(createCards(this)));
        setContentView(mCardScroller);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCardScroller.activate();
    }

    @Override
    protected void onPause() {
        mCardScroller.deactivate();
        super.onPause();
    }

    private List<CardBuilder> createCards(Context context) {
        ArrayList<CardBuilder> cards = new ArrayList<CardBuilder>();

        cards.add(new CardBuilder(context, CardBuilder.Layout.TEXT)
                .setText(R.string.hello_world));

        return cards;
    }
}
