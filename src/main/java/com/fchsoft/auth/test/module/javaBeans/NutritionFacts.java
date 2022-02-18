package com.fchsoft.auth.test.module.javaBeans;

import lombok.Data;

/**
 * @author qw
 * @version 1.0.0
 * @ClassName NutritionFacts.java
 * @Description
 * @createTime 2022-01-14 15:07
 */
@Data
public class NutritionFacts {

    private final Integer servingSize;
    private final Integer servings;
    private final Integer calories;
    private final Integer sodium;
    private final Integer carbohydrate;

    public static class Builder {
        private final Integer servingSize;
        private final Integer servings;

        private Integer calories = 0;
        private Integer sodium = 0;
        private Integer carbohydrate = 0;

        public Builder(Integer servingSize, Integer servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(Integer val) {
            calories = val;
            return this;
        }

        public Builder sodium(Integer val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(Integer val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }

    }

    private NutritionFacts(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

}
