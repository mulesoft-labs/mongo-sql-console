package com.anyconsole.core.command.visitor;

import com.mongodb.BasicDBObject;
import net.sf.jsqlparser.expression.*;
import net.sf.jsqlparser.expression.operators.arithmetic.Addition;
import net.sf.jsqlparser.expression.operators.arithmetic.BitwiseAnd;
import net.sf.jsqlparser.expression.operators.arithmetic.BitwiseOr;
import net.sf.jsqlparser.expression.operators.arithmetic.BitwiseXor;
import net.sf.jsqlparser.expression.operators.arithmetic.Concat;
import net.sf.jsqlparser.expression.operators.arithmetic.Division;
import net.sf.jsqlparser.expression.operators.arithmetic.Modulo;
import net.sf.jsqlparser.expression.operators.arithmetic.Multiplication;
import net.sf.jsqlparser.expression.operators.arithmetic.Subtraction;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.Between;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.expression.operators.relational.ExistsExpression;
import net.sf.jsqlparser.expression.operators.relational.GreaterThan;
import net.sf.jsqlparser.expression.operators.relational.GreaterThanEquals;
import net.sf.jsqlparser.expression.operators.relational.InExpression;
import net.sf.jsqlparser.expression.operators.relational.IsNullExpression;
import net.sf.jsqlparser.expression.operators.relational.LikeExpression;
import net.sf.jsqlparser.expression.operators.relational.Matches;
import net.sf.jsqlparser.expression.operators.relational.MinorThan;
import net.sf.jsqlparser.expression.operators.relational.MinorThanEquals;
import net.sf.jsqlparser.expression.operators.relational.NotEqualsTo;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.SubSelect;

/**
 * User: kbabushkin
 * Date: 8/7/13
 */

public class MongoColumnsExpressionVisitor implements ExpressionVisitor {

    private BasicDBObject columns = new BasicDBObject();

    public BasicDBObject getExpression() {
        return columns;
    }

    @Override
    public void visit(NullValue nullValue) {
        //Implementation goes here
    }

    @Override
    public void visit(Function function) {
        //Implementation goes here
    }

    @Override
    public void visit(InverseExpression inverseExpression) {
        //Implementation goes here
    }

    @Override
    public void visit(JdbcParameter jdbcParameter) {
        //Implementation goes here
    }

    @Override
    public void visit(DoubleValue doubleValue) {
        //Implementation goes here
    }

    @Override
    public void visit(LongValue longValue) {
        //Implementation goes here
    }

    @Override
    public void visit(DateValue dateValue) {
        //Implementation goes here
    }

    @Override
    public void visit(TimeValue timeValue) {
        //Implementation goes here
    }

    @Override
    public void visit(TimestampValue timestampValue) {
        //Implementation goes here
    }

    @Override
    public void visit(Parenthesis parenthesis) {
        //Implementation goes here
    }

    @Override
    public void visit(StringValue stringValue) {
        //Implementation goes here
    }

    @Override
    public void visit(Addition addition) {
        //Implementation goes here
    }

    @Override
    public void visit(Division division) {
        //Implementation goes here
    }

    @Override
    public void visit(Multiplication multiplication) {
        //Implementation goes here
    }

    @Override
    public void visit(Subtraction subtraction) {
        //Implementation goes here
    }

    @Override
    public void visit(AndExpression andExpression) {
        //Implementation goes here
    }

    @Override
    public void visit(OrExpression orExpression) {
        //Implementation goes here
    }

    @Override
    public void visit(Between between) {
        //Implementation goes here
    }

    @Override
    public void visit(EqualsTo equalsTo) {
        //Implementation goes here
    }

    @Override
    public void visit(GreaterThan greaterThan) {
        //Implementation goes here
    }

    @Override
    public void visit(GreaterThanEquals greaterThanEquals) {
        //Implementation goes here
    }

    @Override
    public void visit(InExpression inExpression) {
        //Implementation goes here
    }

    @Override
    public void visit(IsNullExpression isNullExpression) {
        //Implementation goes here
    }

    @Override
    public void visit(LikeExpression likeExpression) {
        //Implementation goes here
    }

    @Override
    public void visit(MinorThan minorThan) {
        //Implementation goes here
    }

    @Override
    public void visit(MinorThanEquals minorThanEquals) {
        //Implementation goes here
    }

    @Override
    public void visit(NotEqualsTo notEqualsTo) {
        //Implementation goes here
    }

    @Override
    public void visit(Column column) {
        columns.append(column.getColumnName(), 1);
    }

    @Override
    public void visit(SubSelect subSelect) {
        //Implementation goes here
    }

    @Override
    public void visit(CaseExpression caseExpression) {
        //Implementation goes here
    }

    @Override
    public void visit(WhenClause whenClause) {
        //Implementation goes here
    }

    @Override
    public void visit(ExistsExpression existsExpression) {
        //Implementation goes here
    }

    @Override
    public void visit(AllComparisonExpression allComparisonExpression) {
        //Implementation goes here
    }

    @Override
    public void visit(AnyComparisonExpression anyComparisonExpression) {
        //Implementation goes here
    }

    @Override
    public void visit(Concat concat) {
        //Implementation goes here
    }

    @Override
    public void visit(Matches matches) {
        //Implementation goes here
    }

    @Override
    public void visit(BitwiseAnd bitwiseAnd) {
        //Implementation goes here
    }

    @Override
    public void visit(BitwiseOr bitwiseOr) {
        //Implementation goes here
    }

    @Override
    public void visit(BitwiseXor bitwiseXor) {
        //Implementation goes here
    }

    @Override
    public void visit(CastExpression castExpression) {
        //Implementation goes here
    }

    @Override
    public void visit(Modulo modulo) {
        //Implementation goes here
    }

    @Override
    public void visit(AnalyticExpression analyticExpression) {
        //Implementation goes here
    }

    @Override
    public void visit(ExtractExpression extractExpression) {
        //Implementation goes here
    }
}
