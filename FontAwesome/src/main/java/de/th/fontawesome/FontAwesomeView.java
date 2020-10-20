package de.th.fontawesome;

import android.content.Context;
import android.util.AttributeSet;
//import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;

public class FontAwesomeView extends AppCompatTextView {
    public FontAwesomeView(Context context) {
        this(context, null, 0);
    }

    public FontAwesomeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FontAwesomeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(FontCache.get(context, FontCache.FA_FONT_REGULAR));

    }
}