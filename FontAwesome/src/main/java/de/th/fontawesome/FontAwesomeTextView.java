package de.th.fontawesome;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView; // https://androidx.de/androidx/appcompat/widget/AppCompatTextView.html

//import android.support.v7.widget.AppCompatTextView;
//import android.widget.TextView; // müsste auch gehen, ist aber nicht nötig

/**
assets/fontawesome/fa-brands-400.ttf
assets/fontawesome/fa-regular-400.ttf
assets/fontawesome/fa-solid-900.ttf


res/values/attrs.xml
res/values/icons.



https://fontawesome.com/
https://fontawesome.com/cheatsheet

**/
// Vielleicht das Beste
// https://gist.github.com/varren/4c5bced96d12c1231ac1

// https://github.com/ravi8x/Android-Font-Awesome/tree/master/fontawesome/src/main/java/info/androidhive/fontawesome

// https://github.com/mikepenz/Android-Iconics/blob/v3.2.5/iconics-view-library/src/main/java/com/mikepenz/iconics/view/IconicsTextView.java

// https://stackoverflow.com/questions/37959751/how-to-use-font-awesome-icon-in-android-application
// https://code.tutsplus.com/tutorials/how-to-use-fontawesome-in-an-android-app--cms-24167

/*
JitPack – Publish Your Android Library
https://www.journaldev.com/19364/jitpack-publish-android-library
https://101android.com/create-publish-library-android-jitpack/
https://www.youtube.com/watch?v=NyOZ27oERUw
*/


// https://github.com/finnmglas/fontawesome-android/blob/master/src/FontAwesome.kt
public class FontAwesomeTextView extends AppCompatTextView {
	
	String type = ""; // "solid", "regular" or "brand"
	Context mcontext;
	String txt = "";

	public FontAwesomeTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mcontext = context;
		init(attrs);
	}

	public FontAwesomeTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mcontext = context;
		init(attrs);
	}

	public FontAwesomeTextView(Context context) {
		super(context);
		mcontext = context;
		init(null);
	}

	private void init(AttributeSet attrs) {

		if (attrs != null) {
			@SuppressLint("CustomViewStyleable") TypedArray a = mcontext.obtainStyledAttributes(attrs, R.styleable.FontAwesome);
			if (a.hasValue(R.styleable.FontAwesome_type)){
				type = a.getString(R.styleable.FontAwesome_type);
			}
			a.recycle();
			if (type.equals("")) type = "regular";
		}
		
		// NEU
		// fab_ = brand, fas_ = solid, fa_ = regular
		txt = getText().toString(); // get Text from TextView?
		System.out.println("txt: " + txt);
		
		setIconType(type);
    }
	
	public void setIconType(String iconType){
		System.out.println("iconType: " + iconType);

		type = iconType;
		Typeface tf;

		// https://stackoverflow.com/questions/34613628/showing-custom-font-or-view-in-preview-section-of-android-studio-xml

		switch (type) {
			case "solid":
				//tf = Typeface.createFromAsset(getContext().getAssets(), "fa-solid-900.ttf");
				tf = de.th.fontawesome.FontCache.get(mcontext, de.th.fontawesome.FontCache.FA_FONT_SOLID); // NEU wegen Preview in Android Studio
				break;
			case "brands":
				//tf = Typeface.createFromAsset(getContext().getAssets(), "fa-brands-400.ttf");
				tf = de.th.fontawesome.FontCache.get(mcontext, de.th.fontawesome.FontCache.FA_FONT_BRANDS); // NEU wegen Preview in Android Studio
				break;
			default:
				// "regular"
				//tf = Typeface.createFromAsset(getContext().getAssets(), "fa-regular-400.ttf");
				tf = de.th.fontawesome.FontCache.get(mcontext, de.th.fontawesome.FontCache.FA_FONT_REGULAR); // NEU wegen Preview in Android Studio
				break;
		}
		
		setTypeface(tf);
		
		// NEU
		//setText(txt); // geht glaube ich nicht siehe: https://developer.android.com/reference/androidx/appcompat/widget/AppCompatTextView
	}
	

	
	/**
	Set FontFamily eventuell so?
	<resources>

    <style name="fontForNotificationLandingPage">
        <item name="android:textStyle">italic</item>
        <item name="android:fontFamily">sans-serif-light</item>
        <item name="android:textColor">#333333</item>
        <item name="android:textSize">32sp</item>
        <item name="android:padding">2dip</item>
    </style>

	</resources>
	setTextAppearance(getActivity(), R.style.fontForNotificationLandingPage);
	
	oder so?
	https://developer.android.com/guide/topics/ui/look-and-feel/fonts-in-xml#java
	Beispiel:
	https://github.com/segunfamisa/android-fonts-xml-sample
	**/
}