package com.fchsoft.auth.test.module.javaBeans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qw
 * @version 1.0.0
 * @ClassName NutritionFactsController.java
 * @Description
 * @createTime 2022-01-14 16:01
 */
@Slf4j
@RestController
public class NutritionFactsController {

    @Autowired
    private NutritionFactsService service;

    @GetMapping("/get")
    public NutritionFacts get() {
        NutritionFacts nutritionFacts;
        try {
            nutritionFacts = service.get();
        } catch (Exception e) {
            nutritionFacts = null;
            log.error("{} error {}", e.getMessage(), e);
        }
        return nutritionFacts;
    }
}
