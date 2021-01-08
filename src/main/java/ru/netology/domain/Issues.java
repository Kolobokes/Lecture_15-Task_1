package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Issues{
    private boolean issuesClose;
    private Set author;
    private Set label;
    private Set project;
    private Set milestone;
    private Set assignee;
    private String Name;
    private int id;
    private Date date;
    private Date update;
    private int numberOfComments;
}
