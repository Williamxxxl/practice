package com.fchsoft.auth.test.module.javaBeans;

import org.springframework.stereotype.Service;

/**
 * @author qw
 * @version 1.0.0
 * @ClassName NutritionFactsService.java
 * @Description
 * @createTime 2022-01-14 15:28
 */
@Service
public class NutritionFactsService {

    public NutritionFacts get() {
         return new NutritionFacts.Builder(10, 20)
                .calories(30).carbohydrate(20).build();
    }
}
