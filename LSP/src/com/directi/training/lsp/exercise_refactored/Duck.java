package com.directi.training.lsp.exercise_refactored;

/**
 * Contract: quack() and swim() always complete normally.
 * Any implementation that can throw breaks substitutability.
 */
public interface Duck
{
    void quack();

    void swim();
}
