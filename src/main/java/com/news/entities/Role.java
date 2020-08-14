package com.news.entities;

import java.util.Objects;

public class Role extends Entity{
    private String role ;

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role1 = (Role) o;
        return Objects.equals(getRole(), role1.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRole());
    }

    @Override
    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                '}';
    }
}

