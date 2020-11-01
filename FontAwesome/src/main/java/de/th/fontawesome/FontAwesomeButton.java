package de.th.fontawesome;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.text.Html;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.Arrays;

// https://www.vogella.com/tutorials/AndroidCustomViews/article.html
// Ripple
// https://guides.codepath.com/android/ripple-animation
// https://github.com/siriscac/RippleView/blob/master/RippleView/src/com/indris/material/RippleView.java

// https://proandroiddev.com/custom-button-rehearsal-a3e0284d3e56
// https://github.com/alex31n/NoboButton
public class FontAwesomeButton extends FrameLayout {

    //Context context;
    LinearLayout lay;
    View view;

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
	
	// https://github.com/siriscac/RippleView/blob/master/RippleView/src/com/indris/material/RippleView.java
	// https://developer.android.com/training/gestures/viewgroup.html#intercept



	@SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(final MotionEvent event) {

		//Log.e("TouchEvent", String.valueOf(event.getActionMasked()));
        boolean superResult = super.onTouchEvent(event);

        //int x = (int) event.getX();
        //int y = (int) event.getY();


        int action = event.getActionMasked();

        switch(action) {
            case (MotionEvent.ACTION_DOWN) : // https://developer.android.com/reference/android/view/MotionEvent#ACTION_DOWN
                Log.e("ACTION","Action was DOWN");
                startAnim();
                if (!superResult) return true;
            case (MotionEvent.ACTION_MOVE) :
                Log.e("ACTION", "moving:");
                if (!superResult) return true;
            case (MotionEvent.ACTION_UP) :
                Log.e("ACTION","Action was UP");
                if (!superResult) return true;
            case (MotionEvent.ACTION_CANCEL) :
                Log.e("ACTION","Action was CANCEL");
                if (!superResult) return true;
            case (MotionEvent.ACTION_OUTSIDE) :
                Log.e("ACTION","Movement occurred outside bounds " +
                        "of current screen element");
                if (!superResult) return true;
            default :
                return superResult;
        }
	}


    private void startAnim(){

        /* Geht
        Animation animation1 = new AlphaAnimation(0.3f, 1.0f);
        animation1.setDuration(500);
        startAnimation(animation1);
         */

        /* Geht
        animate()
                .setDuration(500)
                .rotationYBy(360);
        */


        /* Geht
        Animation myAnim = AnimationUtils.loadAnimation(this.getContext(), R.anim.bounce);
        startAnimation(myAnim);
         */

        // Geht Ripple-Effect Geht ab Android 5, sonst Farbwechsel
        // https://stackoverflow.com/questions/27787870/how-to-use-rippledrawable-programmatically-in-code-not-xml-with-android-5-0-lo
        lay.setBackground(getAdaptiveRippleDrawable(Color.GREEN, Color.WHITE));

        // ViewPropertyAnimator
        // ObjectAnimator https://developer.android.com/guide/topics/graphics/prop-animation.html#listeners
        // https://stackoverflow.com/questions/11633221/android-properties-that-can-be-animated-with-objectanimator
        // https://stackoverflow.com/questions/56286790/ripple-animation-on-a-bitmap-instead-of-view

        // Ripple
        // https://github.com/balysv/material-ripple
    }

    private static Drawable getAdaptiveRippleDrawable(int normalColor, int pressedColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return new RippleDrawable(ColorStateList.valueOf(pressedColor),null, getRippleMask(normalColor));
        } else {
            return getStateListDrawable(normalColor, pressedColor);
        }
    }

    private static Drawable getRippleMask(int color) {
        float[] outerRadii = new float[8];
        // 3 is radius of final ripple,
        // instead of 3 you can give required final radius
        Arrays.fill(outerRadii, 3);

        RoundRectShape r = new RoundRectShape(outerRadii, null, null);
        ShapeDrawable shapeDrawable = new ShapeDrawable(r);
        shapeDrawable.getPaint().setColor(color);
        return shapeDrawable;
    }

    private static StateListDrawable getStateListDrawable(
            int normalColor, int pressedColor) {
        StateListDrawable states = new StateListDrawable();
        states.addState(new int[]{android.R.attr.state_pressed},
                new ColorDrawable(pressedColor));
        states.addState(new int[]{android.R.attr.state_focused},
                new ColorDrawable(pressedColor));
        states.addState(new int[]{android.R.attr.state_activated},
                new ColorDrawable(pressedColor));
        states.addState(new int[]{},
                new ColorDrawable(normalColor));
        return states;
    }


    @SuppressLint("Range")
    private void initView(Context context, AttributeSet attrs){

        String strText = "";
        String strTextColor = "#575454"; // Dunkelgrau
        String strBackgroundColor = "#00ff0000"; // transparent
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

            if (a.hasValue(R.styleable.FontAwesome_android_background)) {
                strBackgroundColor = a.getString(R.styleable.FontAwesome_android_background);
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
        lay = view.findViewById(R.id.layIcon); // Layout um txtIcon und txtText aussen herum

        // +++ Set FrameLayout
        if(padding < 10) padding = 10;
        lay.setPadding(padding,padding,padding,padding);
        setClickable(true);
        setFocusable(true);
        // Gravity
        lay.setGravity(gravity);
        // Background
        try {
            setBackgroundColor(Color.parseColor(strBackgroundColor));
        } catch (Exception e){
            setBackgroundColor(Color.parseColor("#00ff0000")); // transparent
        }

        // +++ Set txtText
        assert strText != null;
        if(strText.length() > 0) {
            txtText.setVisibility(VISIBLE);
            txtText.setText(strText);
        }else{
            txtText.setVisibility(GONE);
        }
        try {
            txtText.setTextColor(Color.parseColor(strTextColor)); // int
        } catch (Exception e) {
            txtText.setTextColor(Color.parseColor("#575454")); // grau
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
        try {
            txtIcon.setTextColor(Color.parseColor(strFaColor)); // int
        } catch (Exception e){
            txtIcon.setTextColor(Color.parseColor("#575454")); // grau
        }
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
