package com.example.ffbackend;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.var;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
		// assertEquals(new long[] { 1L, 2L }, new long[] { 1L, 2L });
		assertArrayEquals(new long[] { 1L, 2L }, new long[] { 1L, 2L });
		var arr = new long[] { 1L, 2L };
		assertEquals(2, arr.length);
	}

}
