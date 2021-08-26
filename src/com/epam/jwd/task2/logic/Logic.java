package com.epam.jwd.task2.logic;

import com.epam.jwd.task2.components.Sentence;
import com.epam.jwd.task2.components.Word;
import com.epam.jwd.task2.printer.Printer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Logic {
    private static final Logger logger = LogManager.getLogger(Logic.class);
    public static int countEqualWordsInSentences(ArrayList<Sentence> mySentence) {
        logger.debug("First task");
        int count = 0;
        for (Sentence sentence : mySentence) {
            Set<Word> tempSet = new HashSet<>(sentence.getWords());
            if (tempSet.size() < sentence.getWords().size()) {
                count++;
            }
        }
        return count;
    }

    public static ArrayList<Sentence> getSentencesByIncreasingNumbersOfWords(ArrayList<Sentence> sentences) {
        ArrayList<Sentence> sentencesCopy= new ArrayList<>(sentences);
        logger.debug("Second task");
        sentencesCopy.sort(Comparator.naturalOrder());
        return  sentencesCopy;
    }

    public static Word findWordNotInSentences(ArrayList<Sentence> mySentence) {
        logger.debug("Third task");
        Set<Word> allWords = new HashSet<>();
        for (int i = 1; i < mySentence.size(); i++) {
            allWords.addAll(mySentence.get(i).getWords());
        }
        for (Word word : mySentence.get(0).getWords()) {
            if (!allWords.contains(word))
                return word;
        }
        return null;
    }

    public static HashSet<String> findWordsInExclamatorySentencesByLength(ArrayList<Sentence> mySentence, int length) {
        logger.debug("Forth task");
        HashSet<String> words = new HashSet<>();
        for (Sentence sentence : mySentence) {
            if (sentence.getText().endsWith("!")) {
                for (int j = 0; j < sentence.getWords().size(); j++) {
                    if (sentence.getWords().get(j).getText().length() == length) {
                        words.add(sentence.getWords().get(j).getText());
                    }
                }
            }
        }
        return words;
    }

    public static void switchFirstAndLastWordInSentence(ArrayList<Sentence> mySentence) {
        logger.debug("Fives task");
        for (int i = 0; i < mySentence.size(); i++) {
            Word firstWord = mySentence.get(i).getWords().get(0);
            Word lastWord =  mySentence.get(i).getWords().get(mySentence.get(i).getWords().size()-2);;
            mySentence.get(i).getWords().set(0,lastWord);
            mySentence.get(i).getWords().set(mySentence.get(i).getWords().size()-2,firstWord);
            String str = " ";
            String str1 = " ";
            for (int j = 0; j < mySentence.get(i).getWords().size(); j++) {
                str = mySentence.get(i).getWords().get(j).getText();
                str1 += str + " ";
            }
            Printer.printString(str1 + "\n");
        }
    }

    public static void getStringInRandomSentence(ArrayList<Sentence> mySentence, int lengthOfWord) {
        logger.debug("Six task");
        Random random = new Random();
        int x = random.nextInt(mySentence.size());
        for (int i = 0; i < mySentence.get(x).getWords().size(); i++) {
            if (mySentence.get(x).getWords().get(i).getText().length() == lengthOfWord) {
                mySentence.get(x).getWords().get(i).setText("Hello world!");
            }
        }
        String str1 = " ";
        String str = " ";
        for (int j = 0; j < mySentence.get(x).getWords().size(); j++) {
            str = mySentence.get(x).getWords().get(j).getText();
            str1 += str + " ";
        }
        Printer.printString(str1);
    }


}

