package Oblig2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Super class for the members
 */

public class BonusMember {
    public final static double FACTOR_SILVER = 1.2;
    public final static double FACTOR_GOLD = 1.5;
    private final int memberNo;
    private final Personals personals;
    private final LocalDate enrolledDate;
    private int points = 0;

    /**
     * Constructor for basic members
     * @param memberNo member number
     * @param personals object of the class Personals with personal information
     * @param enrolledDate registration date
     */

    public BonusMember(int memberNo, Personals personals, LocalDate enrolledDate) {
        this.memberNo = memberNo;
        this.personals = personals;
        this.enrolledDate = enrolledDate;
    }

    /**
     * Constructor for silver and gold members
     * @param memberNo member number
     * @param personals object of the class Personals with personal information
     * @param enrolledDate registration date
     */

    public BonusMember(int memberNo, Personals personals, LocalDate enrolledDate, int points) {
        this.memberNo = memberNo;
        this.personals = personals;
        this.enrolledDate = enrolledDate;
        this.points = points;
    }

    /**
     * get-method for member number
     * @return int the member number
     */

    public int getMemberNo() {
        return memberNo;
    }

    /**
     * get-method for the personals
     * @return Personals for the member
     */

    public Personals getPersonals() {
        return personals;
    }

    /**
     * get-method for the registration date
     * @return LocalDate registration date
     */

    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    /**
     * get-method for the members points
     * @return int the members points
     */

    public int getPoints() {
        return points;
    }

    /**
     * method to find valid points
     * @param date today's date
     * @return int the members valid points
     */

    public int findQualificationPoints(LocalDate date) {
        return ChronoUnit.DAYS.between(enrolledDate, date) <= 365 ? points : 0;
    }

    /**
     * checks if the password is correct
     * @param password password taken in
     * @return boolean true if the password is correct
     */

    public boolean okPassword(String password) {
        return personals.okPassword(password);
    }

    /**
     * method to register points
     * @param p the number of points to register
     */

    public void registerPoints(int p) {
        points += p;
    }
}
