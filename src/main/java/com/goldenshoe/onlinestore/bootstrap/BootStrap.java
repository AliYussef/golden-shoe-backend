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
        //loadData();
    }

    private void loadData() {
        //size
        Size size = Size.builder()
                .size(23)
                .build();
        sizeRepository.save(size);

        //color
        Color color = Color.builder()
                .name("red")
                .build();
        colorRepository.save(color);

        //shoe
        Shoe shoe = Shoe.builder()
                .name("Shoes")
                .price(55.9)
                .stock(100)
                .brand("Nike")
                .target(ShoeTarget.MEN)
                .build();

        shoe.setSizes(new HashSet<>(Arrays.asList(size)));
        shoe.setColors(new HashSet<>(Arrays.asList(color)));
        shoeRepository.save(shoe);

        //image
        Image image = Image.builder()
                .path("/image/one")
                .shoe(shoe)
                .build();

        imageRepository.save(image);

        //category
        categoryRepository.saveAll(new HashSet<>(Arrays.asList(
                Category.builder().shoes(new HashSet<>(Arrays.asList(shoe))).name("sneaker").build(),
                Category.builder().name("sandal").build(),
                Category.builder().name("heel").build(),
                Category.builder().name("boot").build()
        )));


    }
}
