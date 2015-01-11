package com.antaev.fhc.newyearsresolution;

/**
 * Date: 11.01.15
 * Time: 18:47
 *
 * @author Evgeny Antaev
 */
public final class Triple {
    private final int protein;
    private final int carbohydrates;
    private final int fat;

    public static Triple triple(int protein, int carbohydrates, int fat) {
        return new Triple(protein, carbohydrates, fat);
    }

    private Triple(int protein, int carbohydrates, int fat) {
        this.protein = protein;
        this.carbohydrates = carbohydrates;
        this.fat = fat;
    }

    public boolean isValid() {
        return protein >= 0 && carbohydrates >= 0 && fat >= 0;
    }

    public boolean isZero() {
        return protein == 0 && carbohydrates == 0 && fat == 0;
    }

    public Triple subtract(Triple food) {
        return new Triple(protein - food.protein, carbohydrates - food.carbohydrates, fat - food.fat);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triple)) return false;

        Triple t = (Triple) o;

        return carbohydrates == t.carbohydrates
            && fat == t.fat
            && protein == t.protein;

    }

    @Override
    public int hashCode() {
        int result = protein;
        result = 31 * result + carbohydrates;
        result = 31 * result + fat;
        return result;
    }
}
