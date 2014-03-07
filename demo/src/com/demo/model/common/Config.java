package com.demo.model.common;

import android.content.Context;
import android.content.res.Resources;
import com.demo.R;
import com.myideaway.easyapp.util.LogUtil;

/**
 * Created with IntelliJ IDEA.
 * User: cdm
 * Date: 13-4-19
 * Time: PM9:02
 */
public class Config {
    public static String PATH_CACHE;
    public static String PATH_CACHE_IMAGES;

    public static void init(Context context){
        Resources res = context.getResources();
        try {
            PATH_CACHE = context.getExternalCacheDir().getPath();
            LogUtil.debug(PATH_CACHE);
        } catch (Exception e) {
            PATH_CACHE = context.getCacheDir().getPath();
        }

        PATH_CACHE_IMAGES = PATH_CACHE + res.getString(R.string.app_config_path_cache_images);
    }
}
