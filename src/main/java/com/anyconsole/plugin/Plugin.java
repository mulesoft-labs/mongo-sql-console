package com.anyconsole.plugin;

import com.anyconsole.core.command.Result;
import com.anyconsole.core.parser.Parser;

public interface Plugin {
	Parser parse(String statement) throws Exception;
	Result execute(Parser parser) throws Exception;
}
