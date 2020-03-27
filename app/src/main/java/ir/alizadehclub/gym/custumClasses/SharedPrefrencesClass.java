package ir.alizadehclub.gym.custumClasses;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefrencesClass {

    private static Context context;

    public SharedPrefrencesClass(Context context){
        this.context = context;
    }

    public final static String PREFS_NAME = "FILE";

    public static void setUserProfile(String key, String value) {
        SharedPreferences sharedPref = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getUserProfile(String key) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getString(key,null);
    }

    public static void clearData(Context c){
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        prefs.edit().clear().apply();
    }
}
