package ru.netology.repository;

import ru.netology.domain.Issues;

import java.util.ArrayList;

public class IssuesRepository {
    private ArrayList<Issues> issues = new ArrayList<Issues>();

    public void save(Issues newIssues) {
        issues.add(newIssues);
    }

    public Issues findById(int id) {
        for (Issues issues : issues) {
            if (issues.getId() == id) {
                return issues;
            }
        }
        return null;
    }

    public ArrayList<Issues> findAll() {

        return issues;
    }

    public void changeStatusIssues(Boolean closeIssues, int issuesId){
        Issues foundIssues = findById(issuesId);
        if (foundIssues != null) {
            if (closeIssues){
                foundIssues.setIssuesClose(true);
            }
            foundIssues.setIssuesClose(false);
        }
    }
}
