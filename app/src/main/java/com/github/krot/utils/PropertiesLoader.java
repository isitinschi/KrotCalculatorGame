package com.github.krot.utils;

import com.github.krot.sqlite.helper.DatabaseHelper;

public class PropertiesLoader {

    public static void loadSystemProperties() {
        DatabaseHelper databaseHelper = DatabaseHelper.getHelper();

        // Next round
        String value = databaseHelper.getProperty(Properties.NEXT_ROUND.toString());
        if (value != null) {
            SystemProperties.NEXT_ROUND = Integer.valueOf(value);
        }
    }
}
