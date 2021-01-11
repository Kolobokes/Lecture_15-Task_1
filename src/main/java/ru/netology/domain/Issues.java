package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Issues{
    private boolean issuesClose;
    private Set<String> author;
    private Set<String> label;
    private String project;
    private String milestone;
    private Set<String> assignee;
    private String Name;
    private int id;
    private OffsetDateTime date;
    private OffsetDateTime update;
    private int numberOfComments;

    public static Predicate<Issues> filterByAuthor(Set<String> author)
    {
        return p -> p.getAuthor().equals(author);
    }

    public static Predicate<Issues> filterByLabel(Set<String> label)
    {
        return p -> p.getLabel().equals(label);
    }

    public static Predicate<Issues> filterByAssignee(Set<String> assignee)
    {
        return p -> p.getAssignee().equals(assignee);
    }


}
