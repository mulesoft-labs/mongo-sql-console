package com.anyconsole.plugin;

import com.anyconsole.core.parser.Parser;

public interface Plugin {
	Parser parse(String statement) throws Exception;
	String execute(Parser parser) throws Exception;
}
