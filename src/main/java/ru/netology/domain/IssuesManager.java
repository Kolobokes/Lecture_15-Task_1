package ru.netology.domain;
import ru.netology.repository.IssuesRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static ru.netology.domain.Issues.*;

public class IssuesManager {

    IssuesRepository repository = new IssuesRepository();

    public void addIssues(Issues issue){
        repository.save(issue);
    }

    public ArrayList findAllIssues(){
        return repository.findAll();
    }

    public void deleteIssues(Issues issue){
        repository.remove(issue);
    }

    public ArrayList openIssues(){

       ArrayList <Issues> allIssues =  repository.findAll();
       ArrayList <Issues> openIssues = new ArrayList <Issues>();

        for (Issues issue: allIssues) {
            if (issue.isIssuesClose() == false) {
                openIssues.add(issue);
            }
        }
        return openIssues;
    }

    public ArrayList closeIssues(){

        ArrayList <Issues> allIssues =  repository.findAll();
        ArrayList<Issues> closeIssues = new ArrayList<Issues>();

        for (Issues issue: allIssues) {
            if (issue.isIssuesClose()) {
                closeIssues.add(issue);
            }
        }

        return closeIssues;

    }

    public ArrayList<Issues> filterIssuesAuthor(String author){

        ArrayList <Issues> allIssues =  repository.findAll();

        return filterBy(filterByAuthor(Set.of(author)));

    }

    public ArrayList<Issues> filterIssuesLabel(String label){

        ArrayList <Issues> allIssues =  repository.findAll();

        return filterBy(filterByLabel(Set.of(label)));

    }

    public ArrayList<Issues> filterIssuesAssignee(String assignee){

        ArrayList <Issues> allIssues =  repository.findAll();

        return filterBy(filterByAssignee(Set.of(assignee)));

    }

    public ArrayList <Issues> sortIssues(String sortingAttribute){

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

        return allIssues;

    }

    public void changeStatusIssues(Boolean closeIssues, int issuesId){

        repository.changeStatusIssues(closeIssues, issuesId);

    }

    public ArrayList<Issues> filterBy(Predicate<Issues> predicate) {

        ArrayList<Issues> allIssues = repository.findAll();

        return (ArrayList<Issues>) allIssues.stream()
                .filter( predicate )
                .collect(Collectors.<Issues>toList());
    }

}
