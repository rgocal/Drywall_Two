package sapphyx.gsd.com.drywall.util;

import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;
import android.util.Log;

import sapphyx.gsd.com.drywall.R;

public class ColorProvider {

    //PRIMARY COLORS
    public static int getDominantColor(Bitmap bitmap){
        try {
            Palette palette = Palette.from(bitmap).generate();
            Palette.Swatch dominantSwatch = palette.getDominantSwatch();
            if (dominantSwatch != null) {
                return dominantSwatch.getRgb();
            }
            return 0;
        }catch (IllegalArgumentException e){
            Log.e("Dom Col Exception", "Couldn't get dominant color, probably due to permission denile");
            return R.color.colorPrimary;
        }
    }

    //SECONDARY COLORS


    public static int getVibrantColor(Bitmap bitmap) {
        try {
            Palette palette = Palette.from(bitmap).generate();
            Palette.Swatch dominantSwatch = palette.getVibrantSwatch();
            if (dominantSwatch != null) {
                return dominantSwatch.getRgb();
            }
            return 0;
        } catch (IllegalArgumentException e) {
            return R.color.colorAccent;
        }
    }

    public static int getVibrantSecondaryColor(Bitmap bitmap){
        try {
        Palette palette = Palette.from(bitmap).generate();
        Palette.Swatch dominantSwatch = palette.getLightVibrantSwatch();
        if(dominantSwatch != null){
            return dominantSwatch.getRgb();
        }
        return 0;
    } catch (IllegalArgumentException e) {
        return R.color.colorAccent;
    }
}

    public static int getVibrantAccentColor(Bitmap bitmap){
        try{
        Palette palette = Palette.from(bitmap).generate();
        Palette.Swatch dominantSwatch = palette.getDarkVibrantSwatch();
        if(dominantSwatch != null){
            return dominantSwatch.getRgb();
        }
        return 0;
    } catch (IllegalArgumentException e) {
        return R.color.colorAccent;
    }
}

    //ACCENT COLORS

    public static int getMutedColor(Bitmap bitmap){
        try {
        Palette palette = Palette.from(bitmap).generate();
        Palette.Swatch dominantSwatch = palette.getMutedSwatch();
        if(dominantSwatch != null){
            return dominantSwatch.getRgb();
        }
        return 0;
    } catch (IllegalArgumentException e) {
        return R.color.colorPrimaryDark;
    }
}

    public static int getMutedSecondaryColor(Bitmap bitmap){
        try {
        Palette palette = Palette.from(bitmap).generate();
        Palette.Swatch dominantSwatch = palette.getLightMutedSwatch();
        if(dominantSwatch != null){
            return dominantSwatch.getRgb();
        }
        return 0;
    } catch (IllegalArgumentException e) {
        return R.color.colorPrimaryDark;
    }
}

    public static int getMutedAccentColor(Bitmap bitmap){
        try {
        Palette palette = Palette.from(bitmap).generate();
        Palette.Swatch dominantSwatch = palette.getDarkMutedSwatch();
        if(dominantSwatch != null){
            return dominantSwatch.getRgb();
        }
        return 0;
    } catch (IllegalArgumentException e) {
        return R.color.colorPrimaryDark;
    }
}

    public static int getTextColor(Bitmap bitmap){
        try{
        Palette palette = Palette.from(bitmap).generate();
        Palette.Swatch dominantSwatch = palette.getDominantSwatch();
        if(dominantSwatch != null){
            return dominantSwatch.getTitleTextColor();
        }
        return 0;
    } catch (IllegalArgumentException e) {
        return R.color.option_text;
    }
}

}
