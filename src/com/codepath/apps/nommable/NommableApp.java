package com.codepath.apps.nommable;

import android.content.Context;

import com.codepath.apps.nommable.network.FourSquareClient;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/*
 * This is the Android application itself and is used to configure various settings
 * including the image cache in memory and on disk. This also can be used to access
 * our API client singleton.
 *     
 */
public class NommableApp extends com.activeandroid.app.Application {
	private static Context context;
	
    @Override
    public void onCreate() {
        super.onCreate();
        NommableApp.context = this;
        
        // Create global configuration and initialize ImageLoader with this configuration
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().
        		cacheInMemory().cacheOnDisc().build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
            .defaultDisplayImageOptions(defaultOptions)
            .build();
        ImageLoader.getInstance().init(config);
    }
    
    public static FourSquareClient getRestClient() {
    	return (FourSquareClient) FourSquareClient.getInstance(NommableApp.context);
    }
    
}