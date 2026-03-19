package edu.pe.cibertec;

public class PasswordValidator {

    private static final int MIN_LENGHT = 7;
    private static final String SPECIAL_CHARS = "!@#$%^&*()_+-=[]{}|;':\",./<>?";

    public boolean isValid(String password) {
        if (password == null || password.length() < MIN_LENGHT) return false;
        if (password.contains(" ")) return false;
        if (!hasUpperCase(password)) return false;
        return true;
    }

    private boolean hasUpperCase(String password) {
        return password.chars().anyMatch(Character::isUpperCase);
    }

}
