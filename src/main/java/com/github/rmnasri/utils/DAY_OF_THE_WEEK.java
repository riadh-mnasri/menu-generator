package com.github.rmnasri.utils;

/**
 * Created by riadh on 08/11/2015.
 */
public enum DAY_OF_THE_WEEK {
    LUNDI(Constants.LUNDI),
    MARDI(Constants.MARDI),
    MERCREDI(Constants.MERCREDI),
    JEUDI(Constants.JEUDI),
    VENDREDI(Constants.VENDREDI),
    SAMEDI(Constants.SAMEDI),
    DIMANCHE(Constants.DIMANCHE);

    private final Integer dayNumber;

    DAY_OF_THE_WEEK(Integer dayNumber) {
        this.dayNumber = dayNumber;
    }

    public Integer getDayNumber() {
        return dayNumber;
    }


    /**
     * Classe permettant de passer les constantes directement en paramètre d'annotations
     */
    public static class Constants {

        public static final Integer LUNDI = 1;
        public static final Integer MARDI = 2;
        public static final Integer MERCREDI = 3;
        public static final Integer JEUDI = 4;
        public static final Integer VENDREDI = 5;
        public static final Integer SAMEDI = 6;
        public static final Integer DIMANCHE = 7;



        private Constants() {
        }

    }
}
