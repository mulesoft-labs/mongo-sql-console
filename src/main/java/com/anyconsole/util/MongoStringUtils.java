package com.anyconsole.util;

import org.springframework.util.StringUtils;

public class MongoStringUtils {
	public static String trimSingleQuotes(String string) {
		return string == null ? string : StringUtils.trimTrailingCharacter(StringUtils.trimLeadingCharacter(string, '\''), '\'');
	}
}
