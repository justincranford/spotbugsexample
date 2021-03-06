package com.github.justincranford;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class SpotWarningExamples {
	// Example of the URL in a SpotBugs report generated by SpotBugs:
	// - Actual:   https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#MS_PKGPROTECT
	// - Expected: https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#MS_PKGPROTECT
	public static final String LINE_SEPARATOR       = System.getProperty("line.separator");
	public static final byte[] LINE_SEPARATOR_BYTES = LINE_SEPARATOR.getBytes(StandardCharsets.UTF_8);
	public static String base64Mime(final byte[] bytes) {
		return Base64.getMimeEncoder(64, LINE_SEPARATOR_BYTES).encodeToString(bytes);
	}

	// Example of the URL in a SpotBugs report generated by the Find-Sec-Bugs plug-in:
	// - Actual:   https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#MS_PKGPROTECT
	// - Expected: https://find-sec-bugs.github.io/bugs.htm#MS_PKGPROTECT
	public static boolean verify(final String message, final byte[] expectedDigest) throws Exception {
		final MessageDigest md = MessageDigest.getInstance("SHA-256");
		final byte[] actualDigest = md.digest(message.getBytes(StandardCharsets.UTF_8));
		return Arrays.equals(expectedDigest, actualDigest);
	}

	// Example of the URL in a SpotBugs report generated by the SB-Contrib plug-in:
	// - Actual:   https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#LUI_USE_SINGLETON_LIST
	// - Expected: http://fb-contrib.sourceforge.net/bugdescriptions.html#LUI_USE_SINGLETON_LIST
	public static List<Object> asList(final Object element) {
		return Arrays.asList(element);
	}
}