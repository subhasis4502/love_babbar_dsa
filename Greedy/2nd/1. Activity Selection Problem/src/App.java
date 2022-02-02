/* Ref: https://www.youtube.com/watch?v=AsbDqOauGZE */

import java.util.*;

class Pair{
    int start, end;
    Pair(int s, int e){
        start = s;
        end = e;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 };

        System.out.println("Maximum no. of meeting: " + maxMeeting(start, end));
    }

    private static int maxMeeting(int[] start, int[] end) {
        ArrayList<Pair> meetings = new ArrayList<>();
        for(int i = 0; i<start.length; i++){
            meetings.add(new Pair(start[i], end[i]));
        }
        
        Collections.sort(meetings, (Pair a, Pair b) -> a.end - b.end);
        
        int count = 1;
        int i = 0;
        int j = i+1;
        while(j < meetings.size()){
            if(meetings.get(i).end < meetings.get(j).start){
                count++;
                i = j;
                j++;
            } else {
                j++;
            }
        }
        
        return count;
    }
}
