package ru.netology.domain;

import java.util.Comparator;

public class OldDateComparator implements Comparator<Issues> {

    public int compare(Issues p1,Issues p2) {

        if (p1.getDate().isAfter(p2.getDate()))
            return 1;
        else if (p1.getDate().equals(p2.getDate()))
            return 0;
        else
            return -1;
    }
}
