package com.anyconsole.db;

public interface Plugin {
	Parser parse(String statement);
	String execute(Parser parser);
}
