package Oblig2;

import java.time.LocalDate;

/**
 * class for the basic members, subclass from bonus member
 */

public class BasicMember extends BonusMember {

    /**
     * constructor for the class basic member
     * @param memberNo member number
     * @param personals object of the class personals
     * @param enrolledDate date of registration
     */

    public BasicMember(int memberNo, Personals personals, LocalDate enrolledDate) {
        super(memberNo, personals, enrolledDate);
    }
}
