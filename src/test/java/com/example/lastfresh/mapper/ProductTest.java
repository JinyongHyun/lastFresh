package com.example.lastfresh.mapper;

import com.example.lastfresh.domain.dao.product.ProductDAO;
import com.example.lastfresh.mapper.product.ProductMapper;
import com.example.lastfresh.mapper.user.UserMapper;
import com.example.lastfresh.service.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j

public class ProductTest {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private ProductService productService;

    @Test
    public void testGetImages() {
        log.info(productMapper.getImages(15L).toString());
    };
    @Test
    public void testDAO() {
        log.info(productService.getImages(15L).toString());
    };

}
