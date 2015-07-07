package com.niz.androidtraining.server.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.niz.androidtraining.server.domain.Image;
import com.sun.istack.internal.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ImageService {

    private static final Random random = new Random();
    private static final int MIN_SIZE = 300;
    private static final int MAX_SIZE = 800;

    public Image getImage(@Nullable String type) {
        ImageType imageType = getImageType(type);
        int width = random.nextInt(MAX_SIZE - MIN_SIZE) + MIN_SIZE;
        int height = random.nextInt(MAX_SIZE - MIN_SIZE) + MIN_SIZE;
        String url = imageType.getUrl(width, height);
        String title = String.format("%s (%dx%d)", imageType.getTitle(), width, height);
        return new Image(url, title, width, height);
    }

    public List<Image> getImages(@Nullable String type, int count) {
        return IntStream.rangeClosed(1, count).mapToObj(i -> getImage(type)).collect(Collectors.toList());
    }

    private ImageType getImageType(@Nullable String type) {
        if (type != null) {
            return ImageType.fromType(type);
        } else {
            return randomImageType();
        }
    }

    private ImageType randomImageType() {
        return ImageType.values()[random.nextInt(ImageType.values().length)];
    }
}
