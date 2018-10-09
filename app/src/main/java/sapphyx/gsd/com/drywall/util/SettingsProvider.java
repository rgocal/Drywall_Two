package sapphyx.gsd.com.drywall.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by ry on 1/4/18.
 */

public class SettingsProvider {

    private static SettingsProvider settings;

    public static SettingsProvider getInstance() {
        if (settings != null) {
            return settings;
        } else {
            SettingsProvider.settings = new SettingsProvider();
            return SettingsProvider.settings;
        }
    }

    public static SharedPreferences get(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static SharedPreferences.Editor put(Context context) {
        return get(context).edit();
    }

    public static String getString(Context context, String key, String defValue) {
        return get(context).getString(key, defValue);
    }

    public static void putString(Context context, String key, String value) {
        put(context).putString(key, value).commit();
    }

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        return get(context).getBoolean(key, defValue);
    }

    public static void putBoolean(Context context, String key, boolean value) {
        put(context).putBoolean(key, value).commit();
    }

    public static long getLong(Context context, String key, long defValue) {
        return get(context).getLong(key, defValue);
    }

    public static void putLong(Context context, String key, long value) {
        put(context).putLong(key, value).commit();
    }

    public static int getInt(Context context, String key, int defValue) {
        return get(context).getInt(key, defValue);
    }

    public static void putInt(Context context, String key, int value) {
        put(context).putInt(key, value);
    }

}
