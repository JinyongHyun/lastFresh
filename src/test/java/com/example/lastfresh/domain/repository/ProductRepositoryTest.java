package com.example.lastfresh.domain.repository;

import com.example.lastfresh.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;


    @Test
    public void productListTest() {
        List<ProductVO> products = productRepository.findAll();
        products.stream().map(ProductVO::toString).forEach(log::info);
    }
}