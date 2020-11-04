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
        String strFaColor = "#575454"; // Dunkelgrau
		float flFaSize = 24;

        if (attrs != null) {
            @SuppressLint("CustomViewStyleable") TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FontAwesome);
            if (a.hasValue(R.styleable.FontAwesome_faIcon)){
                txt = a.getString(R.styleable.FontAwesome_faIcon);
            }
            if (a.hasValue(R.styleable.FontAwesome_faIconColor)) {
                strFaColor = a.getString(R.styleable.FontAwesome_faIconColor);
            }
			if (a.hasValue(R.styleable.FontAwesome_faIconSize)) {
                flFaSize = a.getFloat(R.styleable.FontAwesome_faIconSize, 24);
                if(flFaSize < 12) flFaSize = 12;
            }
            a.recycle();
        }

        assert txt != null;
        setFaText(context, txt);
        setPadding(5,5,5,5);
        try {
            setTextColor(Color.parseColor(strFaColor)); // int
        } catch (Exception e) {
            setTextColor(Color.parseColor("#575454")); // grau
        }
        setTextSize(flFaSize); // float
    }

    public void setFaIcon(Context context, int faIcon, int faIconColor, float faIconSize){
        String txt = context.getString(faIcon);

        setFaText(context, txt);
        setTextColor(faIconColor);
        setTextSize(faIconSize); // float
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