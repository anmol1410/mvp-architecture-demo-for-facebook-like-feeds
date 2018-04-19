package com.android.anmol.feeds_mvp.utility;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

/**
 * Created by anmolsehgal on 28-03-2018.
 * <p>
 * Gets various res properties.
 */
public class ResUtils {

    static int getDimen(Context context, @DimenRes int dimenRes) {
        return context.getResources().getDimensionPixelOffset(dimenRes);
    }

    public static int getColor(Context context, @ColorRes int colorRes) {
        return context.getResources().getColor(colorRes);
    }

    public static String getString(Context context, @StringRes int stringRes) {
        return context.getResources().getString(stringRes);
    }

    public static Drawable getDrawable(Context context, @DrawableRes int drawableRes) {
        return context.getResources().getDrawable(drawableRes);
    }

    static String getString(Context context
            , @StringRes int stringRes, final Object... formatArgs) {
        return context.getResources().getString(stringRes, formatArgs);
    }
}
