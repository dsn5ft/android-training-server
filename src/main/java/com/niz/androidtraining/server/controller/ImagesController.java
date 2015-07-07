package com.niz.androidtraining.server.controller;

import java.util.List;

import com.niz.androidtraining.server.domain.Image;
import com.niz.androidtraining.server.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImagesController {

    private static final String DEFAULT_COUNT = "10";

    @Autowired ImageService imageService;

    @RequestMapping(value = "/api/v1/image", method = RequestMethod.GET)
    public Image getImage(
            @RequestParam(value = "type", required = false) String type
    ) {
        return imageService.getImage(type);
    }

    @RequestMapping(value = "/api/v1/images", method = RequestMethod.GET)
    public List<Image> getImages(
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "count", required = false, defaultValue = DEFAULT_COUNT) int count
    ) {
        return imageService.getImages(type, count);
    }
}
