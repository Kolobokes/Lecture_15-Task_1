package ru.netology.domain;

import java.util.Comparator;

public class LeastCommentedComparator implements Comparator<Issues> {

    public int compare(Issues p1,Issues p2) {

        if (p1.getNumberOfComments() > p2.getNumberOfComments())
            return -1;
        else if (p1.getNumberOfComments() == p2.getNumberOfComments())
            return 0;
        else
            return 1;
    }
}
