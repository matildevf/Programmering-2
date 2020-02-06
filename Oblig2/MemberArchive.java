package Oblig2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class for the member archive
 */

public class MemberArchive {
    public final static int SILVER_LIMIT = 25000;
    public final static int GOLD_LIMIT = 75000;
    public final static Random RANDOM_NUMBER = new Random();
    private ArrayList<BonusMember> members = new ArrayList<>();

    /**
     * Method to register new members
     * @param personals an object of the class Personals that contains personal information
     * @param date the date of registration
     * @return int the new members member number
     */

    public int newMember(Personals personals, LocalDate date) {
        members.add(new BasicMember(findAvailableNo(), personals, date));
        return members.get(members.size()-1).getMemberNo();
    }

    /**
     * method to find an available member number
     * @return int the member number
     */

    private int findAvailableNo() {
        while (true) {
            int x = Math.abs(RANDOM_NUMBER.nextInt()+1);
            if (!members.stream().anyMatch(m -> m.getMemberNo() == x)) return x;
        }
    }

    /**
     * method to find out how many points a member has
     * @param mnr member number
     * @param password the members password
     * @return int the members points, -1 if the member doesnt exist or the password is wrong
     */

    public int findPoints(int mnr, String password) {
        if (members.stream().anyMatch(m -> m.getMemberNo() == mnr && m.okPassword(password))) {
            return members.stream().filter(m -> m.getMemberNo() == mnr && m.okPassword(password)).findFirst().get().getPoints();
        }
        return -1;
    }

    /**
     * method to register points
     * @param mnr member number
     * @param points the points being registered
     * @return boolean true if completed
     */

    public boolean registerPoints(int mnr, int points) {
        if (members.stream().anyMatch(m -> m.getMemberNo() == mnr)) {
            members.stream().filter(m -> m.getMemberNo() == mnr).findFirst().get().registerPoints(points);
            return true;
        }
        return false;
    }

    /**
     * method to check if any members can upgrade
     * @param date today's date
     */

    public void checkMembers(LocalDate date) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i) instanceof BasicMember && members.get(i).findQualificationPoints(date) >= SILVER_LIMIT && members.get(i).findQualificationPoints(date) < GOLD_LIMIT) {
                members.set(i, new SilverMember(members.get(i).getMemberNo(), members.get(i).getPersonals(), members.get(i).getEnrolledDate(), members.get(i).getPoints()));
                System.out.println(members.get(i).getMemberNo() + " is now a silver member!");
            }
            else if (members.get(i) instanceof BasicMember && members.get(i).findQualificationPoints(date) >= GOLD_LIMIT || members.get(i) instanceof SilverMember && members.get(i).findQualificationPoints(date) >= GOLD_LIMIT) {
                members.set(i, new GoldMember(members.get(i).getMemberNo(), members.get(i).getPersonals(), members.get(i).getEnrolledDate(), members.get(i).getPoints()));
                System.out.println(members.get(i).getMemberNo() + " is now a gold member!");
            }
        }
    }

}
