package com.javawiz.immutable;

import java.util.UUID;

public final class ImmutableUser {
    private final UUID id;
    private final String firstName;
    private final String lastName;

    public ImmutableUser(UUID id, String firstName, String lastName) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    /**
     * @return the id
     */
    public UUID getId() {
        return id;
    }
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }
}