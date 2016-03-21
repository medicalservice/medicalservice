package com.licorice.controller.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.licorice.controller.LoadDataController;
import com.licorice.model.User;

public class LoadDataControllerTest {
	@Test
	public void shouldReturnTheSpecifiedUser() {
		String username = "zcc21";
		User expectedUser = new User();
		expectedUser.setName(username);
		
		LoadDataController controller = new LoadDataController();
		assertEquals(expectedUser.getName(), controller.signIn(username).getName());
	}
}
