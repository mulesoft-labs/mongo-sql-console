package com.anyconsole.core.parser;

import com.anyconsole.core.command.CommandBuilder;

/**
 * User: kbabushkin
 * Date: 8/6/13
 */

public interface Parser {
    void execute(CommandBuilder commandBuilder) throws Exception;
}
