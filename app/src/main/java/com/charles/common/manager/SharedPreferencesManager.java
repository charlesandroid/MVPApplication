package com.charles.common.manager;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * com.charles.common.manager.SharedPreferencesManager
 *
 * @author Just.T
 * @since 16/12/27
 */
public class SharedPreferencesManager {


    private Context context;
    private String fileName;

    public SharedPreferencesManager(Context context, String fileName) {
        this.context = context;
        this.fileName = fileName;
    }

    public static SharedPreferencesManager newInstance(Context context, String fileName) {
        return new SharedPreferencesManager(context, fileName);
    }

    /**
     * @param key
     * @param defaultObject
     * @return
     */
    public <T> T getValue(String key,
                          T defaultObject) {
        SharedPreferences sp = context.getSharedPreferences(
                fileName, Context.MODE_PRIVATE);

        if (defaultObject instanceof String) {
            return (T) sp.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return (T) Integer.valueOf(sp.getInt(key, (Integer) defaultObject));
        } else if (defaultObject instanceof Boolean) {
            return (T) Boolean.valueOf(sp.getBoolean(key, (Boolean) defaultObject));
        } else if (defaultObject instanceof Float) {
            return (T) Float.valueOf(sp.getFloat(key, (Float) defaultObject));
        } else if (defaultObject instanceof Long) {
            return (T) Long.valueOf(sp.getLong(key, (Long) defaultObject));
        }

        return null;
    }

    /**
     * @param key
     * @param object
     */
    public void putValue(String key, Object object) {

        SharedPreferences sp = context.getSharedPreferences(
                fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        }

        editor.apply();
    }


    public void clearSp() {
        context.getSharedPreferences(fileName, Context.MODE_PRIVATE).edit().clear().apply();
    }
}