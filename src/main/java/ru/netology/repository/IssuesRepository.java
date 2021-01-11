package ru.netology.repository;

import ru.netology.domain.Issues;

import java.util.ArrayList;
import java.util.function.Predicate;

public class IssuesRepository {
    private ArrayList<Issues> issues = new ArrayList<Issues>();

    public void save(Issues newIssue) {
        issues.add(newIssue);
    }

    public boolean remove(Issues issue) {
        return issues.remove(issue);
    }

    public Issues findById(int id) {
        for (Issues issue : issues) {
            if (issue.getId() == id) {
                return issue;
            }
        }
        return null;
    }

    public ArrayList<Issues> findAll() {

        return issues;
    }

    public void changeStatusIssues(Boolean closeIssue, int issueId){
        Issues foundIssue = findById(issueId);
        if (foundIssue != null) {
            if (closeIssue){
                foundIssue.setIssuesClose(true);
            }
            foundIssue.setIssuesClose(false);
        }
    }
}
