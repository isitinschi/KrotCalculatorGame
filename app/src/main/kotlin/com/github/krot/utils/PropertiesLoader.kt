package com.github.krot.utils

import com.github.krot.sqlite.helper.DatabaseHelper

class PropertiesLoader {
    companion object {
        @JvmStatic fun loadSystemProperties() {
            val databaseHelper = DatabaseHelper.INSTANCE

            // Next round
            val value = databaseHelper.getProperty(Properties.NEXT_ROUND.toString())
            if (value != null) {
                SystemProperties.NEXT_ROUND = value.toInt()
            }
        }
    }
}
