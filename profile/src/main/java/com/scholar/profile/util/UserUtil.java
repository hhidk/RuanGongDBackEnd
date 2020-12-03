package com.scholar.profile.util;

import java.util.UUID;

public class UserUtil {

    public static String generateUserID() {
        return UUID.randomUUID().toString()
                .replace("-","")
                .substring(0,8).toUpperCase();
    }
}
