package de.th.fontawesome;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import java.util.Hashtable;

// https://stackoverflow.com/questions/34613628/showing-custom-font-or-view-in-preview-section-of-android-studio-xml
// oder https://github.com/ravi8x/Android-Font-Awesome/blob/master/fontawesome/src/main/java/info/androidhive/fontawesome/FontCache.java

public class FontCache {
	public static final String FA_FONT_REGULAR = "fa-regular-400.ttf";
    public static final String FA_FONT_SOLID = "fa-solid-900.ttf";
    public static final String FA_FONT_BRANDS = "fa-brands-400.ttf";
	
    private static final String TAG = "FontCache";

    private static final Hashtable<String, Typeface> cache = new Hashtable<String, Typeface>();

    public static Typeface get(Context c, String assetPath) {
        synchronized (cache) {
            if (!cache.containsKey(assetPath)) {
                try {
                    Typeface t = Typeface.createFromAsset(c.getAssets(), assetPath);
                    cache.put(assetPath, t);
                    Log.e(TAG, "Loaded '" + assetPath);
                } catch (Exception e) {
                    Log.e(TAG, "Could not get typeface '" + assetPath + "' because " + e.getMessage());
                    return null;
                }
            }
            return cache.get(assetPath);
        }
    }
}