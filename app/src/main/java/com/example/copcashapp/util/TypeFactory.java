package com.example.copcashapp.util;

import static android.os.Build.VERSION_CODES.R;

import android.content.Context;
import android.graphics.Typeface;

import androidx.core.content.res.ResourcesCompat;


public class TypeFactory {

    private Typeface regular;
    private Typeface bold;
    private Typeface title;

    public TypeFactory(Context context) {
//        regular = ResourcesCompat.getFont(context, R.font.sans_regular);
//        bold = ResourcesCompat.getFont(context, R.font.sans_bold);
//        title=ResourcesCompat.getFont(context, R.font.blacklist);
    }


    public Typeface getRegular() {
        return regular;
    }

    public Typeface getBold() {
        return bold;
    }

    public Typeface getTitle() {
        return title;
    }
}