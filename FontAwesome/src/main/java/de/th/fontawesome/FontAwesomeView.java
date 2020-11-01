package de.th.fontawesome;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.Html;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

public class FontAwesomeView extends AppCompatTextView {

    public FontAwesomeView(Context context) {
        this(context, null, 0);
        init(context, null);
    }

    public FontAwesomeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init(context, attrs);
    }

    public FontAwesomeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attrs){

        String txt = "";
        String strTextColor = "#575454"; // Dunkelgrau

        if (attrs != null) {
            @SuppressLint("CustomViewStyleable") TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FontAwesome);
            if (a.hasValue(R.styleable.FontAwesome_faIcon)){
                txt = a.getString(R.styleable.FontAwesome_faIcon);
            }
            if (a.hasValue(R.styleable.FontAwesome_android_textColor)){
                strTextColor = a.getString(R.styleable.FontAwesome_android_textColor);
            }
            a.recycle();
        }

        assert txt != null;
        setFaText(context, txt);
        setPadding(5,5,5,5);
        try {
            setTextColor(Color.parseColor(strTextColor)); // int
        } catch (Exception e) {
            setTextColor(Color.parseColor("#575454")); // grau
        }
    }

    public void setFaIcon(Context context, int FaIcon, int FaIconColor){
        String txt = context.getString(FaIcon);

        setFaText(context, txt);
        setTextColor(FaIconColor);
    }

    private void setFaText(Context context, String txt){
        String[] arr = txt.split("#");

        if(arr.length > 1){
            switch (arr[0]) {
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

            setText(Html.fromHtml("&#x" + arr[1] + ";"));
        }
    }

}