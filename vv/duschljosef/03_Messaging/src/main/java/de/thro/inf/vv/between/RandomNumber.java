package de.thro.inf.vv.between;

import java.util.Random;

abstract class RandomNumber {
    private final int MAX_DRIVEN_MILES = 1000;

    /**
     * generates a radnom int number
     * @return radom int number between 0 to MAX_DRIVEN_MILES, positive
     */
    public int RandomRoute(){
        Random random = new Random();

        int route = random.nextInt(MAX_DRIVEN_MILES);
        return route;
    }

    /**
     * generates a double number
     * @return double latitude number
     */
    public double RandomGpsLatitude(){

        double randomLatitude = (Math.random() * 180.0) - 90.0;
        return randomLatitude;
    }

    /**
     * generates a double number
     * @return a double longitude number
     */
     public  double RandomGpsLongitudes(){

        double randomLongitude = (Math.random() * 360.0) - 180.0;
        return randomLongitude;
    }

}
