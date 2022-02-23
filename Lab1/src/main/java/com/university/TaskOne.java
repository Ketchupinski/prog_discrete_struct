package com.university;

/**
 * First task from lab 1:
 * Задано значення істинності висловлювань p та q.
 * Знайти значення істинності кон’юнкції, диз’юнкції,
 * альтернативного «або», імплікації й еквівалентності цих висловлювань.
 * @version 1
 * @author Arsen Savshak
 */
public class TaskOne {
    private final boolean p;
    private final boolean q;

    public TaskOne(boolean P, boolean Q) {
        p = P;
        q = Q;
    }

    /**
     * Method find logical conjunction from class fields
     * @return result of logical conjunction
     */
    public boolean findLogicConjunction() {
        return p && q;
    }

    /**
     * Method find logical disjunction from class fields
     * @return result of logical disjunction
     */
    public boolean findLogicDisjunction() {
        return p || q;
    }

    /**
     * Method find logical strict disjunction from class fields
     * @return result of strict disjunction
     */
    public boolean findStrictDisjunction() {
        return p ^ q;
    }

    /**
     * Method find result of logic implication p -> q
     * @return result of implication p -> q
     */
    public boolean findLogicImplicationOne() {
        return !p || q;
    }

    /**
     * Method find result of logic implication q -> p
     * @return result of implication q -> p
     */
    public boolean findLogicImplicationTwo() {
        return !q || p;
    }

    /**
     * Method find logic equivalence using
     * methods which find logic implication
     * @return result of logic equivalence
     */
    public boolean findLogicEquivalence() {
        return findLogicImplicationOne() && findLogicImplicationTwo();
    }

    /**
     * This method using all class methods print results of operations with class fields
     */
    public void printResults() {
        System.out.println("Logic conjunction p ˄ q: " + findLogicConjunction());
        System.out.println("Logic disjunction p ˅ q: " + findLogicDisjunction());
        System.out.println("Logic strict disjunction: " + findStrictDisjunction());
        System.out.println("Logic implication p -> q: " + findLogicImplicationOne());
        System.out.println("Logic implication q -> p: " + findLogicImplicationTwo());
        System.out.println("Logic equivalence p <-> q: " + findLogicEquivalence());
    }
}
