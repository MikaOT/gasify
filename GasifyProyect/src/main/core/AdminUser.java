package main.core;

public class AdminUser extends User {

    private boolean isBoolean;

    public AdminUser(String name) {
        super (name);
        this.isBoolean = true;
    }

    public boolean isBoolean() {
        return isBoolean;
    }
}
