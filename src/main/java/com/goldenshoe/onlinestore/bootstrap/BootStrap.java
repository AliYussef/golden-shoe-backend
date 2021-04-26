package com.goldenshoe.onlinestore.bootstrap;

import com.goldenshoe.onlinestore.models.*;
import com.goldenshoe.onlinestore.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by aliyussef on 24/04/2021
 */
@Component
public class BootStrap implements CommandLineRunner {

    private final ShoeRepository shoeRepository;
    private final ColorRepository colorRepository;
    private final SizeRepository sizeRepository;
    private final ImageRepository imageRepository;
    private final CategoryRepository categoryRepository;

    public BootStrap(ShoeRepository shoeRepository, ColorRepository colorRepository, SizeRepository sizeRepository, ImageRepository imageRepository, CategoryRepository categoryRepository) {
        this.shoeRepository = shoeRepository;
        this.colorRepository = colorRepository;
        this.sizeRepository = sizeRepository;
        this.imageRepository = imageRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
    }
}
