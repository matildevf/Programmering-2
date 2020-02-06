package Oblig2;

import java.time.LocalDate;

/**
 * class for the silver members, subclass from bonus member
 */

public class SilverMember extends BonusMember{

    /**
     * constructor for the class basic member
     * @param memberNo member number
     * @param personals object of the class personals
     * @param enrolledDate date of registration
     */

    public SilverMember(int memberNo, Personals personals, LocalDate enrolledDate, int points) {
        super(memberNo, personals, enrolledDate, points);
    }

    /**
     * method to register points with the silver bonus
     * @param p the number of points to register
     */

    public void registerPoints(int p) {
        super.registerPoints(p *= super.FACTOR_SILVER);
    }
}
