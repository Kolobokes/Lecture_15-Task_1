package ru.netology.domain;

import java.util.Comparator;

public class LeastRecentlyUpdatedComparator implements Comparator<Issues> {

    public int compare(Issues p1,Issues p2) {

        if (p1.getUpdate().isAfter(p2.getUpdate()))
            return 1;
        else if (p1.getUpdate().equals(p2.getUpdate()))
            return 0;
        else
            return -1;
    }
}
