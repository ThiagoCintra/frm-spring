package br.com.cintra.helper.asserts;

public class Assert extends org.junit.Assert {

	
	public static void assertEquals(Object expected , Object actual) {
		org.junit.Assert.assertEquals(expected, actual);
	}
}
