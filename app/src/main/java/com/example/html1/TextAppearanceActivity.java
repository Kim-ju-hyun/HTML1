package com.example.html1;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.webkit.WebView;

import com.google.android.glass.widget.CardScrollView;

public class TextAppearanceActivity extends Activity {

    private static final String TAG = TextAppearanceActivity.class.getSimpleName();

    private CardScrollView mCardScroller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCardScroller = new CardScrollView(this);
        mCardScroller.setAdapter(new TextAppearanceAdapter(this));
        setContentView(mCardScroller);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mCardScroller.activate();

        WebView wv = (WebView)findViewById(R.id.webViewer);

        String storage = Environment.getExternalStorageDirectory().toString();
        String pathDCIM = Environment.DIRECTORY_DCIM;
        String loadUrlPath = "file://" + storage + "/" + pathDCIM + "/SFILE/PAGE/page_01.html";
        Log.d(TAG, loadUrlPath);

        wv.loadUrl(loadUrlPath);
    }

    @Override
    protected void onPause() {
        mCardScroller.deactivate();
        super.onPause();
    }
}
