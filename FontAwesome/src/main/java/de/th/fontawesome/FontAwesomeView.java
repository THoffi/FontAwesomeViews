package de.th.fontawesome;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
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

        if (attrs != null) {
            @SuppressLint("CustomViewStyleable") TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FontAwesome);
            if (a.hasValue(R.styleable.FontAwesome_faIcon)){
                txt = a.getString(R.styleable.FontAwesome_faIcon);
            }
            a.recycle();
            //if (type.equals("")) type = "regular";
        }

        assert txt != null;
        String[] arr = txt.split("#");
        //Log.e("arr.length", "" + arr.length);
        if(arr.length < 2){
            return;
        }
        //System.out.println("txt: " + arr[1]);

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