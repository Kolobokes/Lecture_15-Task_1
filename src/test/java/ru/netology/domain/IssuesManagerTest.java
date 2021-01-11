package ru.netology.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class IssuesManagerTest {

    @Nested
    public class MultipleItems {

        public IssuesManager systemPreparationMultipleItems(){

            IssuesManager manager = new IssuesManager();

            ArrayList testIssues = systemPreparationMultipleItemsTestIssues();
            manager.addIssues((Issues)testIssues.get(0));
            manager.addIssues((Issues)testIssues.get(1));
            manager.addIssues((Issues)testIssues.get(2));

            return manager;
        }

        public ArrayList systemPreparationMultipleItemsTestIssues(){

            ArrayList testDate = systemPreparationMultipleItemsTestDate();
            ArrayList testUpdate = systemPreparationMultipleItemsTestUpdate();

            Issues error1 = new Issues(false, Set.of("user1"), Set.of("kotlin"), "junit5", "5.7.1", Set.of("bechte"), "critical error", 123, (OffsetDateTime)testDate.get(0), (OffsetDateTime)testUpdate.get(0), 10);
            Issues error2 = new Issues(false, Set.of("user2"), Set.of("jupiter"), "junit5", "5.7.1", Set.of("kolobokes"), "not found", 124, (OffsetDateTime)testDate.get(1), (OffsetDateTime)testUpdate.get(1), 5);
            Issues error3 = new Issues(true, Set.of("user2"), Set.of("jupiter"), "junit5", "5.7.1", Set.of("kolobokes"), "not found", 125, (OffsetDateTime)testDate.get(2), (OffsetDateTime)testUpdate.get(2), 5);

            ArrayList <Issues> testIssues = new ArrayList();
            testIssues.add(error1);
            testIssues.add(error2);
            testIssues.add(error3);

            return testIssues;

        }

        public ArrayList systemPreparationMultipleItemsTestDate(){

            OffsetDateTime date1 = OffsetDateTime.of(2020, 5, 15, 0, 0, 0, 0, ZoneOffset.ofHours(3));
            OffsetDateTime date2 = OffsetDateTime.of(2020, 6, 15, 0, 0, 0, 0, ZoneOffset.ofHours(3));
            OffsetDateTime date3 = OffsetDateTime.of(2020, 7, 15, 0, 0, 0, 0, ZoneOffset.ofHours(3));

            ArrayList <OffsetDateTime> testDate = new ArrayList();
            testDate.add(date1);
            testDate.add(date2);
            testDate.add(date3);

            return testDate;

        }

        public ArrayList systemPreparationMultipleItemsTestUpdate(){

            OffsetDateTime update1 = OffsetDateTime.of(2020, 5, 15, 0, 3, 0, 0, ZoneOffset.ofHours(3));
            OffsetDateTime update2 = OffsetDateTime.of(2020, 6, 15, 0, 3, 0, 0, ZoneOffset.ofHours(3));
            OffsetDateTime update3 = OffsetDateTime.of(2020, 7, 15, 0, 3, 0, 0, ZoneOffset.ofHours(3));

            ArrayList <OffsetDateTime> testUpdate = new ArrayList();
            testUpdate.add(update1);
            testUpdate.add(update2);
            testUpdate.add(update3);

            return testUpdate;

        }

        @Test
        void findAllIssues() {

            IssuesManager manager = systemPreparationMultipleItems();

            ArrayList actual = manager.findAllIssues();

            ArrayList expected = systemPreparationMultipleItemsTestIssues();

            assertEquals(expected, actual);

        }

        @Test
        void deleteIssues() {

            IssuesManager manager = systemPreparationMultipleItems();

            ArrayList tesIssues = systemPreparationMultipleItemsTestIssues();

            manager.deleteIssues((Issues)tesIssues.get(0));

            ArrayList actual = manager.findAllIssues();

            ArrayList expected = new ArrayList();
            expected.add(tesIssues.get(1));
            expected.add(tesIssues.get(2));

            assertEquals(expected, actual);
        }

        @Test
        void openIssues() {

            IssuesManager manager = systemPreparationMultipleItems();
            ArrayList tesIssues = systemPreparationMultipleItemsTestIssues();

            ArrayList <Issues> actual = manager.openIssues();

            ArrayList expected = new ArrayList<>();
            expected.add(tesIssues.get(0));
            expected.add(tesIssues.get(1));

            assertEquals(expected, actual);

        }

        @Test
        void closeIssues() {

            IssuesManager manager = systemPreparationMultipleItems();
            ArrayList tesIssues = systemPreparationMultipleItemsTestIssues();

            ArrayList <Issues> actual = manager.closeIssues();

            ArrayList expected = new ArrayList<>();
            expected.add(tesIssues.get(2));

            assertEquals(expected, actual);

        }

        @Test
        void filterIssuesAuthor() {

            IssuesManager manager = systemPreparationMultipleItems();
            ArrayList tesIssues = systemPreparationMultipleItemsTestIssues();

            ArrayList <Issues> actual = manager.filterIssuesAuthor("user1");

            ArrayList expected = new ArrayList<>();
            expected.add(tesIssues.get(0));

            assertEquals(expected, actual);

        }

        @Test
        void filterIssuesLabel() {

            IssuesManager manager = systemPreparationMultipleItems();
            ArrayList tesIssues = systemPreparationMultipleItemsTestIssues();

            ArrayList <Issues> actual = manager.filterIssuesLabel("jupiter");

            ArrayList expected = new ArrayList<>();
            expected.add(tesIssues.get(1));
            expected.add(tesIssues.get(2));

            assertEquals(expected, actual);

        }

        @Test
        void filterIssuesAssignee() {

            IssuesManager manager = systemPreparationMultipleItems();
            ArrayList tesIssues = systemPreparationMultipleItemsTestIssues();

            ArrayList <Issues> actual = manager.filterIssuesAssignee("bechte");

            ArrayList expected = new ArrayList<>();
            expected.add(tesIssues.get(0));

            assertEquals(expected, actual);

        }

        @Test
        void sortIssuesNewest() {
            IssuesManager manager = systemPreparationMultipleItems();
            ArrayList tesIssues = systemPreparationMultipleItemsTestIssues();

            ArrayList actual = manager.sortIssues("Newest");

            ArrayList expected = new ArrayList<>();
            expected.add(tesIssues.get(2));
            expected.add(tesIssues.get(1));
            expected.add(tesIssues.get(0));

            assertEquals(expected, actual);
        }

        @Test
        void sortIssuesOldest() {
            IssuesManager manager = systemPreparationMultipleItems();
            ArrayList tesIssues = systemPreparationMultipleItemsTestIssues();

            ArrayList actual = manager.sortIssues("Oldest");

            ArrayList expected = new ArrayList<>();
            expected.add(tesIssues.get(0));
            expected.add(tesIssues.get(1));
            expected.add(tesIssues.get(2));

            assertEquals(expected, actual);
        }

        @Test
        void sortIssuesMostCommented() {
            IssuesManager manager = systemPreparationMultipleItems();
            ArrayList tesIssues = systemPreparationMultipleItemsTestIssues();

            ArrayList actual = manager.sortIssues("MostCommented");

            ArrayList expected = new ArrayList<>();
            expected.add(tesIssues.get(0));
            expected.add(tesIssues.get(1));
            expected.add(tesIssues.get(2));

            assertEquals(expected, actual);
        }

        @Test
        void sortIssuesLeastCommented() {
            IssuesManager manager = systemPreparationMultipleItems();
            ArrayList tesIssues = systemPreparationMultipleItemsTestIssues();

            ArrayList actual = manager.sortIssues("LeastCommented");

            ArrayList expected = new ArrayList<>();
            expected.add(tesIssues.get(1));
            expected.add(tesIssues.get(2));
            expected.add(tesIssues.get(0));

            assertEquals(expected, actual);
        }

        @Test
        void sortIssuesRecentlyUpdated() {
            IssuesManager manager = systemPreparationMultipleItems();
            ArrayList tesIssues = systemPreparationMultipleItemsTestIssues();

            ArrayList actual = manager.sortIssues("RecentlyUpdated");

            ArrayList expected = new ArrayList<>();
            expected.add(tesIssues.get(2));
            expected.add(tesIssues.get(1));
            expected.add(tesIssues.get(0));

            assertEquals(expected, actual);
        }

        @Test
        void sortIssuesLeastRecentlyUpdated() {
            IssuesManager manager = systemPreparationMultipleItems();
            ArrayList tesIssues = systemPreparationMultipleItemsTestIssues();

            ArrayList actual = manager.sortIssues("LeastRecentlyUpdated");

            ArrayList expected = new ArrayList<>();
            expected.add(tesIssues.get(0));
            expected.add(tesIssues.get(1));
            expected.add(tesIssues.get(2));

            assertEquals(expected, actual);
        }

        @Test
        void changeStatusIssues() {
            IssuesManager manager = systemPreparationMultipleItems();
            ArrayList tesIssues = systemPreparationMultipleItemsTestIssues();

            manager.changeStatusIssues(true, 123);

            assertEquals(tesIssues.get(0), manager.findAllIssues().get(0));


        }
    }

    @Nested
    public class Empty {

        public IssuesManager systemPreparationMultipleItems(){

            IssuesManager manager = new IssuesManager();

            return manager;
        }

        @Test
        void findAllIssues() {

            IssuesManager manager = systemPreparationMultipleItems();

            ArrayList actual = manager.findAllIssues();

            ArrayList expected = new ArrayList();

            assertEquals(expected, actual);

        }

        @Test
        void deleteIssues() {

            IssuesManager manager = systemPreparationMultipleItems();

            Issues error1 = new Issues();
            manager.deleteIssues(error1);

            ArrayList actual = manager.findAllIssues();

            ArrayList expected = new ArrayList();

            assertEquals(expected, actual);
        }
    }
}