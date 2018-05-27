package ua.khai.golik.bl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import ua.khai.golik.bl.interfaces.CountFinalOrderPrice;
import ua.khai.golik.entities.Order;

public class BusinessLogic implements CountFinalOrderPrice{

    // TODO price formula

    // Price formula -> PRICE = DEF_PRICE * DAYS * CITY_COEFF * ()


    // Coefficients for formula



    // Type of passengers coefficients

    private static final double CHILDREN_COEFF = 0.5;
    private static final double ADULT_COEFF = 1;

    // City coefficients

    private static final double KHARKIV_KOEFF = 1.3;
    private static final double ODESSA_KOEFF = 1.2;
    private static final double KIEV_KOEFF = 1;

    // Class of places coefficients

    private static final double BUSINESS_CLASS_KOEFF = 1.6;
    private static final double ECONOM_CLASS_KOEFF = 1;

    // Default prices



    // TODO countPrice() method

    @Override
    public double countPrice(Order order){
        double answ = 0;


        return 0;
    }

    @Override
    public long countDays(int fDay, int fMonth, int fYear, int sDay, int sMonth, int sYear) {
        long answer, answerMilliSeconds = 0;

        Calendar firstDate = Calendar.getInstance();
        firstDate.set(fYear, fMonth, fDay);

        Calendar secondDate = Calendar.getInstance();
        secondDate.set(sYear, sMonth, sYear);

        long d1 = firstDate.getTimeInMillis();
        long d2 = secondDate.getTimeInMillis();

        answerMilliSeconds = d2 - d1;

        answer = answerMilliSeconds * 1000 * 60 * 60 * 24;
        return answer;
    }
}
