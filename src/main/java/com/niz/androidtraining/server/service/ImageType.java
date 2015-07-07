package com.niz.androidtraining.server.service;

import org.apache.commons.lang3.StringUtils;

public enum ImageType {
    MURRAY("Bill Murray", "http://www.fillmurray.com"),
    CAGE("Nic Cage", "http://www.placecage.com"),
//    SEAGAL("Steven Seagal", "http://www.stevensegallery.com"),
    ;

    private String title;
    private String baseUrl;

    ImageType(String title, String baseUrl) {
        this.title = title;
        this.baseUrl = baseUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl(int width, int height) {
        return baseUrl + "/" + width + "/" + height;
    }

    public static ImageType fromType(String type) {
        return valueOf(StringUtils.upperCase(type));
    }
}
