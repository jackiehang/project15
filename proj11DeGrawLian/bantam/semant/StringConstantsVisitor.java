/*
 * File: StringConstantsVisitor.java
 * Names: Lucas DeGraw and Iris Lian
 * Class: CS 461
 * Project 11
 * Date: February 12, 2019
 */

package proj11DeGrawLian.bantam.semant;

import proj11DeGrawLian.bantam.ast.ConstStringExpr;
import proj11DeGrawLian.bantam.ast.Program;
import proj11DeGrawLian.bantam.visitor.Visitor;

import java.util.HashMap;
import java.util.Map;

/**
 * A subclass of the Visitor class, has the public method getStringConstants
 * @author Lucas DeGraw
 */
public class StringConstantsVisitor extends Visitor {

    // create the map of (StringConstant_#, stringConstantValue) pairs
    private HashMap<String,String> stringConstantsMap = new HashMap<>();

    /**
     *
     * @param ast an abstract syntax tree generated from Parser.parse()
     * @return the HashMap of string constants
     */
    public Map<String,String> getStringConstants(Program ast) {
        // traverse the abstract syntax tree
        ast.accept(this);

        return stringConstantsMap;
    }

    /**
     * each time a ConstStringExpr node is found during the traversal,
     * this method is called to visit the node
     *
     * @param node the string constant expression node
     * @return the result of the traversal
     */
    public Object visit(ConstStringExpr node) {

        // get num constants in map
        int numStringsInMap = stringConstantsMap.size();

        // build name
        String name = "StringConstant_" + Integer.toString(numStringsInMap);

        // get string value from ConstStringExpr node
        String value = node.getConstant();

        // add name, value pair to map
        stringConstantsMap.put(name, value);

        return null;
    }
}
