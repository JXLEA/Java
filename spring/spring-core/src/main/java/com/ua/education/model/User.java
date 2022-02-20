package com.ua.education.model;

public interface User {
    /**
     * User Id. UNIQUE.
     * @return User Id.
     */
    long getId();
    void setId(long id);
    String getName();
    void setName(String name);
    String getEmail();
    void setEmail(String email);
}
