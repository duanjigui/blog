package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.blog.util.MD5Coder;

public class TestMD5 {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String value="a1101971076";
		String va=	MD5Coder.encodeMD5Hex(value);
		String value2=MD5Coder.encodeMD5Hex(value);
		System.out.println(va);
		Assert.assertEquals(va, "55b185e60f194dd2e2b87c67a541fb5c");
	}

}
