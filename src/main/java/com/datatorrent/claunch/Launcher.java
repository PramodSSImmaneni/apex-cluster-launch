package com.datatorrent.claunch;

import org.apache.hadoop.conf.Configuration;

import com.datatorrent.api.StreamingApplication;

import com.datatorrent.stram.client.StramAppLauncher;

/**
 * Created by pramod on 4/3/16.
 */
public class Launcher {

    public static void launch(StreamingApplication app, String name, String libjars) throws Exception
    {
        Configuration conf = new Configuration(true);
        if (libjars != null) {
            conf.set(StramAppLauncher.LIBJARS_CONF_KEY_NAME, libjars);
        }
        StramAppLauncher appLauncher = new StramAppLauncher(name, conf);
        appLauncher.loadDependencies();
        StreamingAppFactory appFactory = new StreamingAppFactory(app, name);
        appLauncher.launchApp(appFactory);
    }

    public static void launch(StreamingApplication app, String name) throws Exception {
        launch(app, name, null);
    }

}
