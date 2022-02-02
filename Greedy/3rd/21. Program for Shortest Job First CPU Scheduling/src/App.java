/* Ref: https://www.youtube.com/watch?v=9PDUOx4MtKo */

import java.util.*;

class Process {
    int id, arrivalTime, burstTime;

    public Process(int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }

}

public class App {
    public static void main(String[] args) throws Exception {
        Process p1 = new Process(1, 2, 3);
        Process p2 = new Process(2, 0, 4);
        Process p3 = new Process(3, 4, 2);
        Process p4 = new Process(4, 5, 4);

        Process[] processes = { p1, p2, p3, p4 };
        sjfSchedule(processes);
    }

    private static void sjfSchedule(Process[] processes) {
        Arrays.sort(processes, new Comparator<Process>() {
            @Override
            public int compare(Process a, Process b) {
                if (a.arrivalTime == b.arrivalTime) { // Both arrive at same time
                    if (a.burstTime == b.burstTime) // Both take same time to exicute
                        return a.id - b.id; // Choose the process with smaller id
                    else
                        return a.burstTime - b.burstTime; // Choose the process with less burst time
                }
                return a.arrivalTime - b.arrivalTime; // The process that arrive first
            }
        });

        PriorityQueue<Process> queue = new PriorityQueue<>((Process a, Process b) -> a.burstTime - b.burstTime);
        ArrayList<Process> res = new ArrayList<>();
        queue.add(processes[0]);
        int time = 0;
        int i = 1;
        while (!queue.isEmpty()) {
            res.add(queue.peek());
            time += queue.peek().burstTime;
            queue.poll();

            while(true){
                if(i < processes.length && processes[i].arrivalTime <= time){
                    queue.add(processes[i++]);
                } else {
                    break;
                }
            }
        }

        for (Process process : res) {
            System.out.println("Process: " + process.id + " Arrival Time: " + process.arrivalTime + " Burst Time: "
                    + process.burstTime);
        }
    }
}
