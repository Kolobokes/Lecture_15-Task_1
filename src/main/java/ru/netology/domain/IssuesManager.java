package ru.netology.domain;
import ru.netology.repository.IssuesRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

public class IssuesManager {

    IssuesRepository repository = new IssuesRepository();

    public void addIssues(Issues issues){
        repository.save(issues);
    }

    public ArrayList openIssues(){

       ArrayList <Issues> allIssues =  repository.findAll();
       ArrayList <Issues> openIssues = new ArrayList <Issues> ();

        for (Issues issues: allIssues) {
            if (issues.isIssuesClose() == false) {
                openIssues.add(issues);
            }
        }
        return openIssues;
    }

    public ArrayList closeIssues(){

        ArrayList <Issues> allIssues =  repository.findAll();
        ArrayList<Issues> closeIssues = new ArrayList<Issues>();

        for (Issues issues: allIssues) {
            if (issues.isIssuesClose()) {
                closeIssues.add(issues);
            }
        }

        return closeIssues;

    }

    public ArrayList filterByAuthor(ArrayList issues){

        ArrayList<Issues> filterByAuthor = new ArrayList<Issues>();
        return filterByAuthor;

    }

    public ArrayList filterByLabel(ArrayList issues){

        ArrayList<Issues> filterByLabel = new ArrayList<Issues>();
        return filterByLabel;

    }

    public ArrayList filterByAssignee(ArrayList issues){

        ArrayList<Issues> filterByAssignee = new ArrayList<Issues>();
        return filterByAssignee;

    }

    public void sortIssues(String sortingAttribute){

        ArrayList <Issues> allIssues =  repository.findAll();

        if (sortingAttribute == "Newest")
            Collections.sort(allIssues, new NewDateComparator());

        if (sortingAttribute == "Oldest")
            Collections.sort(allIssues, new OldDateComparator());

        if (sortingAttribute == "RecentlyUpdated")
            Collections.sort(allIssues, new RecentlyUpdatedComparator());

        if (sortingAttribute == "LeastRecentlyUpdated")
            Collections.sort(allIssues, new LeastRecentlyUpdatedComparator());

        if (sortingAttribute == "MostCommented")
            Collections.sort(allIssues, new MostCommentedComparator());

        if (sortingAttribute == "LeastCommented")
            Collections.sort(allIssues, new LeastCommentedComparator());

    }

    public void changeStatusIssues(Boolean closeIssues, int issuesId){

        repository.changeStatusIssues(closeIssues, issuesId);

    }

    public void filterBy(Issues author){
        Predicate<Issues> filterByAuthor = s -> s.getAuthor();
    }

}
