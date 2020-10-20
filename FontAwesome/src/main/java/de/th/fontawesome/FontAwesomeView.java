package de.th.fontawesome;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
//import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;


public class FontAwesomeView extends AppCompatTextView {
    Context mcontext;
    String type = ""; // "solid", "regular" or "brand"

    public FontAwesomeView(Context context) {
        this(context, null, 0);
    }

    public FontAwesomeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FontAwesomeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (attrs != null) {
            @SuppressLint("CustomViewStyleable") TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FontAwesome);
            if (a.hasValue(R.styleable.FontAwesome_type)){
                type = a.getString(R.styleable.FontAwesome_type);
            }
            a.recycle();
            if (type.equals("")) type = "regular";
        }

        String alt = getText().toString();
        //setText(alt);
        //Log.e("text", alt);
        Log.e("type", type);
        Log.e("tag", getTag().toString());

        switch (type) {
            case "solid":
                setTextAppearance(context, R.style.fa_solid_900); // Geht
                break;
            case "brands":
                setTextAppearance(context, R.style.fa_brands_400); // Geht
                break;
            default:
                // "regular"
                setTextAppearance(context, R.style.fa_regular_400); // Geht
                break;
        }



        //Typeface typeface = ResourcesCompat.getFont(context, R.font.fa_regular_400);
        //setTypeface(typeface);

        // setTypeface(FontCache.get(context, FontCache.FA_FONT_REGULAR));

    }
}