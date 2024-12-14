package org.ntut.dei.models;

public interface User {
    public String getUsername();

    public UserProfile getUserProfile();

    public String getDescription();

    public boolean isPremium();
}