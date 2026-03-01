package com.baarsch_bytes;

import com.baarsch_bytes.OnlineSalesOld.Status;
import static com.baarsch_bytes.OnlineSalesOld.Status.*;


public class OnlineSalesRevised {

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
    public OnlineSalesOld.Status giveDiscount(long bonusPoints, boolean goldCustomer) {
        Status rv = ERROR;
        long threshold = goldCustomer? 80 : 120;
        long thresholdJump = goldCustomer? 20 : 30;

        if (bonusPoints > 0) {
            if (bonusPoints < thresholdJump) {
                bonusPoints -= threshold;
            }
            if (bonusPoints > thresholdJump) {
                bonusPoints -= threshold;
            }
            bonusPoints += 4 * thresholdJump;
            if (bonusPoints > threshold)
                rv = DISCOUNT;
            else
                rv = FULL_PRICE;
        }
        return rv;
    }
}
