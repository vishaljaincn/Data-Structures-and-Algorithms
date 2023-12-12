package day66_Advanced_Greedy;

/*
Problem Statement: There is one meeting room in a firm. You are given two arrays, start and end each of size N.
For an index ‘i’, start[i] denotes the starting time of the ith meeting while end[i]  will denote the ending time of the ith
meeting. Find the maximum number of meetings that can be accommodated if only one meeting can happen in the room at a
particular time. Print the order in which these meetings will be performed.

Example:

Input:  N = 6,  start[] = {1,3,0,5,8,5}, end[] =  {2,4,5,7,9,9}

Output: 1 2 4 5
 */
/*
Time Complexity: O(n) to iterate through every position and insert them in a data structure. O(n log n)  to sort the data structure in ascending order of end time. O(n)  to iterate through the positions and check which meeting can be performed.

Overall : O(n) +O(n log n) + O(n) ~O(n log n)

Space Complexity: O(n)  since we used an additional data structure for storing the start time, end time, and meeting no.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Class to represent a meeting with start time, end time, and position
class Meeting {
    int start;
    int end;
    int pos;

    Meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

// Comparator class to compare meetings based on end times and positions
class MeetingComparator implements Comparator<Meeting> {
    @Override
    public int compare(Meeting o1, Meeting o2) {
        // Compare based on end times first, then on positions if end times are equal
        if (o1.end < o2.end)
            return -1;
        else if (o1.end > o2.end)
            return 1;
        else if (o1.pos < o2.pos)
            return -1;
        return 1;
    }
}

public class NmeetingsIn1Room_DifferentVersion {
    // Function to find the maximum number of meetings that can be performed in one room
    static void maxMeetings(int start[], int end[], int n) {
        ArrayList<Meeting> meetings = new ArrayList<>();

        // Create a list of meetings from the given start and end arrays
        for (int i = 0; i < start.length; i++)
            meetings.add(new Meeting(start[i], end[i], i + 1));

        MeetingComparator mc = new MeetingComparator();
        Collections.sort(meetings, mc);

        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(meetings.get(0).pos);
        int limit = meetings.get(0).end;

        // Iterate through the sorted list of meetings to find the maximum number of meetings
        for (int i = 1; i < start.length; i++) {
            if (meetings.get(i).start > limit) {
                limit = meetings.get(i).end;
                answer.add(meetings.get(i).pos);
            }
        }

        System.out.println("The order in which the meetings will be performed is ");
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }

    public static void main(String args[]) {
        int n = 6;
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] =   {2, 4, 5, 7, 9, 9};
        maxMeetings(start, end, n);
    }
}
