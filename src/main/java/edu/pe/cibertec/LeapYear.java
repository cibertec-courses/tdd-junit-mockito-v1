package edu.pe.cibertec;

public class LeapYear {

    public boolean isLeapYear(int year){
        if (year <= 0 ){
            throw new IllegalArgumentException("Year cannot be negative value");
        }
        return (year % 4 == 0 && year %100 !=0 ) || (year % 400 ==0);
     }
}
