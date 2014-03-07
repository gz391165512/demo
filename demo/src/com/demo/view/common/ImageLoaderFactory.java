package com.demo.view.common;

import android.content.Context;
import android.graphics.Bitmap;
import com.demo.model.common.Config;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import com.nostra13.universalimageloader.cache.disc.impl.TotalSizeLimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: cdm
 * Date: 12/12/12
 * Time: 7:40 PM
 */
public class ImageLoaderFactory {
    private static final int CACHE_SIZE = 128 * 1024 * 1024;
    private static final int TIME_OUT = 60 * 1000;
    private static ImageLoader imageLoader;
    private static ImageLoaderConfiguration imageLoaderConfiguration;
    private static DiscCacheAware discCacheAware;
    private static Context context;

    public static void init(Context ctx) {
        context = ctx;
        initImageLoader();
    }

    public static ImageLoader getImageLoader() {
        return imageLoader;
    }

    private static void initImageLoader() {
        if (imageLoader == null) {
            imageLoader = ImageLoader.getInstance();
            initImageLoaderConfiguration();
            imageLoader.init(imageLoaderConfiguration);
        }
    }

    private static void initImageLoaderConfiguration() {

        if (imageLoaderConfiguration == null) {
            DisplayImageOptions defaultOptions = generateDefaultDisplayImageOptions();

            initDiscCacheAware();

            imageLoaderConfiguration = new ImageLoaderConfiguration.Builder(context)
                    .threadPoolSize(3)
                    .memoryCache(new WeakMemoryCache())
                    .discCache(discCacheAware)
                    .discCacheFileNameGenerator(new HashCodeFileNameGenerator())
                    .imageDownloader(new BaseImageDownloader(context,TIME_OUT, TIME_OUT)) // connectTimeout (5 s), readTimeout (20 s)
                    .defaultDisplayImageOptions(defaultOptions)
                    .build();
        }
    }

    private static void initDiscCacheAware() {
        if (discCacheAware == null) {
            TotalSizeLimitedDiscCache totalSizeLimitedDiscCache = new TotalSizeLimitedDiscCache(new File(Config.PATH_CACHE_IMAGES), CACHE_SIZE);
            discCacheAware = totalSizeLimitedDiscCache;
        }
    }

    public static File getDiscCacheImageFile(String url) {
        return discCacheAware.get(url);
    }


    public static DisplayImageOptions generateDefaultDisplayImageOptions() {
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory()
                .cacheOnDisc()
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();

        return defaultOptions;
    }

    public static DisplayImageOptions generateDefaultDisplayImageOptionsWithStubImage(int stubImageRes) {
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory()
                .cacheOnDisc()
                .showStubImage(stubImageRes)
                .showImageForEmptyUri(stubImageRes)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        return defaultOptions;
    }
}
