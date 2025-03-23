package com.practice.demo.Pojo;

public class User {
    private Long profileId;
    private String name;

    public User(Long id, String name) {
        this.profileId = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }
}
