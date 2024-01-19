package com.javawiz.immutable;

import java.lang.reflect.Field;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ImmutableUserTest {

	@Test
	public void reflectionFailure()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		ImmutableUser user = new ImmutableUser(UUID.randomUUID(), "john", "liu");
		Field i = user.getClass().getDeclaredField("firstName");
		i.setAccessible(true);
		i.set(user, "cassandra");
		System.out.println("user " + user.getFirstName()); // prints cassandra
		
		IllegalAccessException thrown = Assertions.assertThrows(IllegalAccessException.class, () -> {
			
	  });

	}
}