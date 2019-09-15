package com.example.ffbackend;

import com.example.ffbackend.controller.UserController;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {
	@Autowired
	UserController userController;

	@Test
	public void insertUserTest() {
		// assertEquals(new long[] { 1L, 2L }, new long[] { 1L, 2L });
		// assertArrayEquals(new long[] { 1L, 2L }, new long[] { 1L, 2L });
		// var arr = new long[] { 1L, 2L };
		// assertEquals(2, arr.length);
	}

}
