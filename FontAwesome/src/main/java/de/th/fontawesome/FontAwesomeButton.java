package de.th.fontawesome;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.Html;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

// https://proandroiddev.com/custom-button-rehearsal-a3e0284d3e56
// https://github.com/alex31n/NoboButton
public class FontAwesomeButton extends FrameLayout {

    public FontAwesomeButton(Context context) {
        super(context);
        initView(context, null);
    }

    public FontAwesomeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public FontAwesomeButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs){

        String strText = "";
        String strTextColor = "#575454"; // Dunkelgrau
        float TextSize = 18;
        String strTextSize;
        int padding = 10;
        int gravity = Gravity.CENTER;
        String strPadding;
        float flFaSize = 24;
        String strFaPadding = "0";
        String strFaColor = "#575454"; // Dunkelgrau
        String faIconAlignment = "3"; // TOP

        // Attribute auslesen
        @SuppressLint("CustomViewStyleable") TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FontAwesome);
            // Variable für txtText
            if (a.hasValue(R.styleable.FontAwesome_android_text)) {
                strText = a.getString(R.styleable.FontAwesome_android_text);
            }

            if (a.hasValue(R.styleable.FontAwesome_android_textColor)) {
                strTextColor = a.getString(R.styleable.FontAwesome_android_textColor);
            }

        if (a.hasValue(R.styleable.FontAwesome_android_gravity)) {
            gravity = a.getInt(R.styleable.FontAwesome_android_gravity, Gravity.CENTER);
        }

            if (a.hasValue(R.styleable.FontAwesome_android_textSize)) {
                strTextSize = a.getString(R.styleable.FontAwesome_android_textSize);
                assert strTextSize != null;
                if (strTextSize.length() > 1) {
                    TextSize = Float.parseFloat(strTextSize.replaceAll("[^\\d.]+|\\.(?!\\d)", ""));
                }
            }
            if (a.hasValue(R.styleable.FontAwesome_android_padding)){
                strPadding = a.getString(R.styleable.FontAwesome_android_padding);
                assert strPadding != null;
                if(strPadding.length() > 1) {
                    padding = (int)Float.parseFloat(strPadding.replaceAll("[^\\d.]+|\\.(?!\\d)", ""));
                }
            }

            // Variable für txtIcon
            String strFaIcon = a.getString(R.styleable.FontAwesome_faIcon);

            if (a.hasValue(R.styleable.FontAwesome_faIconColor)) {
                strFaColor = a.getString(R.styleable.FontAwesome_faIconColor);
            }

            if (a.hasValue(R.styleable.FontAwesome_faIconPadding)) {
                strFaPadding = a.getString(R.styleable.FontAwesome_faIconPadding);
                assert strFaPadding != null;
                if(strFaPadding.length() < 1){
                    strFaPadding = "0";
                }
            }

            if (a.hasValue(R.styleable.FontAwesome_faIconSize)) {
                flFaSize = a.getFloat(R.styleable.FontAwesome_faIconSize, 24);
                if(flFaSize < 12) flFaSize = 12;
            }

            if (a.hasValue(R.styleable.FontAwesome_faIconAlignment)) {
                faIconAlignment = a.getString(R.styleable.FontAwesome_faIconAlignment);
            }

        a.recycle();

        // +++ Set Inflate Layout
        View view;
        assert faIconAlignment != null;
        switch (faIconAlignment) {
            case "3":
                view = View.inflate(context, R.layout.button_icon_top, this);
                break;
            case "2":
                view = View.inflate(context, R.layout.button_icon_bottom, this);
                break;
            case "1":
                view = View.inflate(context, R.layout.button_icon_right, this);
                break;
            default:
                view = View.inflate(context, R.layout.button_icon_left, this);
                break;
        }

        TextView txtIcon = view.findViewById(R.id.txtIcon);
        TextView txtText = view.findViewById(R.id.txtText);
        LinearLayout lay = view.findViewById(R.id.layIcon);

        // +++ Set FrameLayout
        if(padding < 10) padding = 10;
        setPadding(padding,padding,padding,padding);
        setClickable(true);
        setFocusable(true);
        // Gravity
        lay.setGravity(gravity);
        // Click-Animation
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
        setBackgroundResource(outValue.resourceId); // Animation bei Click

        // +++ Set txtText
        assert strText != null;
        if(strText.length() > 0) {
            txtText.setVisibility(VISIBLE);
            txtText.setText(strText);
        }else{
            txtText.setVisibility(GONE);
        }
        assert strTextColor != null;
        if(strTextColor.length() > 2) {
            txtText.setTextColor(Color.parseColor(strTextColor)); // int
        }
        if(TextSize < 12) TextSize = 12;
        txtText.setTextSize(TextSize); // float

        // +++ Set txtIcon
        // Typeface
        assert strFaIcon != null;
        String[] arr = strFaIcon.split("#");
        if(arr.length >= 2){
            switch (arr[0]) {
                case "solid":
                    txtIcon.setTextAppearance(context, R.style.fa_solid_900); // Geht
                    break;
                case "brands":
                    txtIcon.setTextAppearance(context, R.style.fa_brands_400); // Geht
                    break;
                default:
                    // "regular"
                    txtIcon.setTextAppearance(context, R.style.fa_regular_400); // Geht
                    break;
            }
        }
        // Rest
        txtIcon.setText(Html.fromHtml("&#x" + arr[1] + ";"));
        txtIcon.setTextColor(Color.parseColor(strFaColor)); // int
        txtIcon.setTextSize(flFaSize); // float
        // IconAlignment
        int faPadding = Integer.parseInt(strFaPadding);
        switch (faIconAlignment) {
            case "3":
                // Top
                txtIcon.setPadding(0,0,0, faPadding);
                break;
            case "2":
                // Bottom
                txtIcon.setPadding(0, faPadding,0, 0);
                break;
            case "1":
                // Right
                txtIcon.setPadding(faPadding,0,0, 0);
                break;
            default:
                // Left
                txtIcon.setPadding(0,0, faPadding, 0);
                break;
        }


    }
}
