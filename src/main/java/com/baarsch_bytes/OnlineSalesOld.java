package com.baarsch_bytes;

import static com.baarsch_bytes.OnlineSalesOld.Status.*;

public class OnlineSalesOld {

    public static enum Status { FULL_PRICE, DISCOUNT, ERROR };

    /**
     * Determine whether to give a discount for online sales.
     * Gold customers get a discount above 80 bonus points.
     * Other customers get a discount above 120 bonus points.
     *
     * @param bonusPoints How many bonus points the customer has accumulated
     *
     * @param goldCustomer Whether the customer is a Gold Customer
     *
     * @return
     * DISCOUNT - give a discount<br>
     * FULL_PRICE - charge the full price<br>
     * ERROR - invalid inputs
     */
    public static Status giveDiscount(long bonusPoints, boolean goldCustomer) {
        Status rv = FULL_PRICE;
        long threshold = 120;

        if (bonusPoints <= 0)
            rv = ERROR;

        else {
            if (goldCustomer)
                threshold = 80;
            if (bonusPoints > threshold)
                rv = DISCOUNT;
        }

        return rv;
    }
}
