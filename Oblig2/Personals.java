package Oblig2;

import java.util.Arrays;

/**
 * Personalia.java  2010‐01‐18
 *
 * Klasse med personopplysninger: fornavn, etternavn, epostadresse og passord.
 * Passordet kan endres, men da mÃ¥ det nye vÃ¦re forskjellig fra det gamle.
 * Passordkontrollen skiller ikke mellom store og smÃ¥ bokstaver.
 */

class Personals {
    private final String surname;
    private final String firstname;
    private final String ePostadr;
    private String password;
    /**
     * KonstruktÃ¸r:
     * Alle data mÃ¥ oppgis: fornavn, etternavn, ePostadr, passord
     * Ingen av dataene kan vÃ¦re null eller blanke strenger.
     */
    public Personals(String firstname, String surname, String ePostadr, String password) {
        if (checkString(firstname, surname, ePostadr, password)) {
            throw new IllegalArgumentException("Et eller flere konstruktrør argumenter er null og/eller blanke.");
        }
        this.firstname = firstname.trim();
        this.surname = surname.trim();
        this.ePostadr = ePostadr.trim();
        this.password = password.trim();
    }
    public String getFirstname() {
        return firstname;
    }
    public String getSurname() {
        return surname;
    }
    public String getEPostadr() {
        return ePostadr;
    }


    private boolean checkString(String ...args) {
        return Arrays.stream(args).anyMatch(a -> a == null || a.trim().equals(""));
    }

    /**
     * Metoden returnerer true dersom passordet er korrekt.
     * Passordkontrollen skiller ikke mellom store og smÃ¥ bokstaver.
     */
    public boolean okPassword(String password) {
        return this.password.equalsIgnoreCase(password);
    }
    /**
     * Metoden setter nytt passord, dersom det er forskjellig fra
     * det gamle. To passord betraktes som like dersom det kun er
     * forskjeller i store/smÃ¥ bokstaver.
     *
     * Metoden returnerer true dersom passordet ble endret, ellers false.
     */

    public boolean changePassword(String oldPassword, String newPassword) {
        if (checkString(oldPassword) || checkString(newPassword)) {
            return false;
        }
        if (!password.equalsIgnoreCase(oldPassword.trim())) {
            return false;
        }

        password = newPassword.trim();
        return true;

    }
}