package Oblig2;

import java.time.LocalDate;
class TestBonusMember {
    public static void main(String[] args) throws Exception {

        // Test objekts of the class Personals
        Personals ole = new Personals("Olsen", "Ole", "ole.olsen@dot.com", "ole");
        Personals tove = new Personals("Hansen", "Tove", "tove.hansen@dot.com", "tove");

        // Test date
        LocalDate testdato = LocalDate.of(2008, 2, 10);

        System.out.println("Totalt antall tester: 8");

        // Initiates object of the class BasicMember
        BasicMember b1 = new BasicMember(100, ole, LocalDate.of(2006, 2, 15));

        // Registers points
        b1.registerPoints(30000);

        // Checks if it's more than a year since the member registered and if the member has 30000 points
        if (b1.findQualificationPoints(testdato) == 0 && b1.getPoints() == 30000) {
            System.out.println("Test 1 ok");
        }

        // Registers points
        b1.registerPoints(15000);

        // Checks if it's more than a year since the member registered and if the member has 45000 points
        if (b1.findQualificationPoints(testdato) == 0 && b1.getPoints() == 45000) {
            System.out.println("Test 2 ok");
        }

        // Initiates object of the class BasicMember
        BasicMember b2 = new BasicMember(110, tove, LocalDate.of(2007, 3, 5));

        // Registers points
        b2.registerPoints(30000);

        // Checks if the member has 30000 valid points and if the member has 30000 points
        if (b2.findQualificationPoints(testdato) == 30000 && b2.getPoints() == 30000) {
            System.out.println("Test 3 ok");
        }

        // Initiates object of the class SilverMember
        SilverMember b3 = new SilverMember(b2.getMemberNo(), b2.getPersonals(), b2.getEnrolledDate(), b2.getPoints());

        // Registers points
        b3.registerPoints(50000);

        // Checks if the member has 90000 valid points and has 90000 points
        if (b3.findQualificationPoints(testdato) == 90000 && b3.getPoints() == 90000) {
            System.out.println("Test 4 ok");
        }

        // Initiates object of the class GoldMember
        GoldMember b4 = new GoldMember(b3.getMemberNo(), b3.getPersonals(), b3.getEnrolledDate(), b3.getPoints());

        // Registers points
        b4.registerPoints(30000);

        // Checks if the member has 135000 valid points and has 135000 points
        if (b4.findQualificationPoints(testdato) == 135000 && b4.getPoints() == 135000) {
            System.out.println("Test 5 ok");
        }

        // Changes the test date
        testdato = LocalDate.of(2008, 12, 10);

        // Checks if it's more than a year since the member registered and if the member has 135000 points
        if (b4.findQualificationPoints(testdato) == 0 && b4.getPoints() == 135000) {
            System.out.println("Test 6 ok");
        }

        // Checks if the password is'nt ok
        if (!ole.okPassword("OOO")) {
            System.out.println("Test 7 ok");
        }

        // Checks if the password is ok
        if (tove.okPassword("tove")) {
            System.out.println("Test 8 ok");
        }

        testdato = LocalDate.of(2021, 5 ,15);

        MemberArchive MA = new MemberArchive();

        int m1 = MA.newMember(new Personals("Per", "Jensen", "p@gmail.com", "Per123"), LocalDate.of(2019, 3, 12));
        int m2 = MA.newMember(new Personals("Pal", "Jonsen", "p@gmail.com", "Pal123"), LocalDate.of(2019, 4, 29));

        System.out.println(m1 + "\n" + m2);
        System.out.println(MA.registerPoints(m1, 30000));
        System.out.println(MA.registerPoints(m2, 90000));

        System.out.println(MA.findPoints(m1, "Per123"));
        System.out.println(MA.findPoints(m2, "Pal123"));

        MA.checkMembers(testdato);
    }
}