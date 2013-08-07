package com.anyconsole.api;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.sun.jersey.api.core.ResourceContext;
import org.springframework.stereotype.Component;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

/**
 * User: kbabushkin
 * Date: 8/6/13
 */

@Path("/api")
@Consumes("application/json")
@Produces("application/json")
@Component("any-console-resource")
public class AnyConsoleResource {
	
	private static Set<String> SQL_KEYWORDS;
	
	static {
		String keywords[] = {"ABSOLUTE",
		"ACTION",
		"ADD",
		"ALL",
		"ALLOCATE",
		"ALTER",
		"AND",
		"ANY",
		"ARE",
		"AS",
		"ASC",
		"ASSERTION",
		"AT",
		"AUTHORIZATION",
		"AVG",
		"BEGIN",
		"BETWEEN",
		"BIT",
		"BIT_LENGTH",
		"BOTH",
		"BY",
		"CALL",

		"CASCADE",
		"CASCADED",
		"CASE",
		"CAST",
		"CATALOG",
		"CHAR",
		"CHAR_LENGTH",
		"CHARACTER",
		"CHARACTER_LENGTH",
		"CHECK",

		"CLOSE",
		"COALESCE",
		"COLLATE",
		"COLLATION",
		"COLUMN",
		"COMMIT",
		"CONDITION",
		"CONNECT",
		"CONNECTION",
		"CONSTRAINT",
		"CONSTRAINTS",

		"CONTAINS",
		"CONTINUE",
		"CONVERT",
		"CORRESPONDING",
		"COUNT",
		"CREATE",
		"CROSS",

		"CURRENT",
		"CURRENT_DATE",

		"CURRENT_PATH",

		"CURRENT_TIME",
		"CURRENT_TIMESTAMP",

		"CURRENT_USER",
		"CURSOR",

		"DATE",
		"DAY",
		"DEALLOCATE",
		"DEC",
		"DECIMAL",
		"DECLARE",
		"DEFAULT",
		"DEFERRABLE",
		"DEFERRED",
		"DELETE",
		"DESC",
		"DESCRIBE",
		"DESCRIPTOR",
		"DETERMINISTIC",
		"DIAGNOSTICS",
		"DISCONNECT",
		"DISTINCT",
		"DO",
		"DOMAIN",
		"DOUBLE",
		"DROP",

		"ELSE",
		"ELSEIF",
		"END",

		"ESCAPE",
		"EXCEPT",
		"EXCEPTION",
		"EXEC",
		"EXECUTE",
		"EXISTS",
		"EXIT",
		"EXTERNAL",
		"EXTRACT",
		"FALSE",
		"FETCH",

		"FIRST",
		"FLOAT",
		"FOR",
		"FOREIGN",
		"FOUND",

		"FROM",
		"FULL",
		"FUNCTION",

		"GET",
		"GLOBAL",
		"GO",
		"GOTO",
		"GRANT",
		"GROUP",

		"HANDLER",
		"HAVING",

		"HOUR",
		"IDENTITY",
		"IF",
		"IMMEDIATE",
		"IN",
		"INDICATOR",
		"INITIALLY",
		"INNER",
		"INOUT",
		"INPUT",
		"INSENSITIVE",
		"INSERT",
		"INT",
		"INTEGER",
		"INTERSECT",
		"INTERVAL",
		"INTO",
		"IS",
		"ISOLATION",

		"JOIN",
		"KEY",
		"LANGUAGE",

		"LAST",

		"LEADING",
		"LEAVE",
		"LEFT",
		"LEVEL",
		"LIKE",
		"LOCAL",



		"LOOP",
		"LOWER",

		"MATCH",
		"MAX",



		"MIN",
		"MINUTE",

		"MODULE",
		"MONTH",

		"NAMES",
		"NATIONAL",
		"NATURAL",
		"NCHAR",


		"NEXT",
		"NO",

		"NOT",
		"NULL",
		"NULLIF",
		"NUMERIC",

		"OCTET_LENGTH",
		"OF",

		"ON",
		"ONLY",
		"OPEN",
		"OPTION",
		"OR",
		"ORDER",

		"OUT",
		"OUTER",
		"OUTPUT",

		"OVERLAPS",
		"PAD",
		"PARAMETER",
		"PARTIAL",

		"PATH",
		"POSITION",
		"PRECISION",
		"PREPARE",
		"PRESERVE",
		"PRIMARY",
		"PRIOR",
		"PRIVILEGES",
		"PROCEDURE",
		"PUBLIC",

		"READ",

		"REAL",


		"REFERENCES",

		"RELATIVE",

		"REPEAT",
		"RESIGNAL",
		"RESTRICT",

		"RETURN",
		"RETURNS",
		"REVOKE",
		"RIGHT",

		"ROLLBACK",

		"ROUTINE",

		"ROWS",

		"SCHEMA",

		"SCROLL",

		"SECOND",
		"SECTION",
		"SELECT",

		"SESSION",
		"SESSION_USER",
		"SET",

		"SIGNAL",

		"SIZE",
		"SMALLINT",
		"SOME",
		"SPACE",
		"SPECIFIC",

		"SQL",
		"SQLCODE",
		"SQLERROR",
		"SQLEXCEPTION",
		"SQLSTATE",
		"SQLWARNING",




		"SUBSTRING",
		"SUM",


		"SYSTEM_USER",
		"TABLE",

		"TEMPORARY",
		"THEN",
		"TIME",
		"TIMESTAMP",
		"TIMEZONE_HOUR",
		"TIMEZONE_MINUTE",
		"TO",
		"TRAILING",
		"TRANSACTION",
		"TRANSLATE",
		"TRANSLATION",


		"TRIM",
		"TRUE",

		"UNDO",
		"UNION",
		"UNIQUE",
		"UNKNOWN",

		"UNTIL",
		"UPDATE",
		"UPPER",
		"USAGE",
		"USER",
		"USING",
		"VALUE",
		"VALUES",
		"VARCHAR",
		"VARYING",
		"VIEW",
		"WHEN",
		"WHENEVER",
		"WHERE",
		"WHILE",
		"WITH",
		"WORK",
		"WRITE",
		"YEAR",
		"ZONE"
		};
		SQL_KEYWORDS = new HashSet<String>(Arrays.asList(keywords));
	}

    @Context
    private ResourceContext resourceContext;
    
    @Path("/keywords")
    public Set<String> getSQLKeywords() {
    	return SQL_KEYWORDS;
    }

    @Path("/mongo")
    public MongoResource getMongoResource() {
        return resourceContext.getResource(MongoResource.class);
    }
}
