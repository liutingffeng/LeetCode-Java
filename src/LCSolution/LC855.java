package LCSolution;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class LC855 {

    class ExamRoom {
        TreeSet<Integer> students;
        int N;
        public ExamRoom(int N) {
            students = new TreeSet<>();
            this.N = N;
        }

        public int seat() {
            int seat = 0;
            if (students.size()>0){

                int dist = students.first();
                Integer pre = null;
                for (Integer s : students){
                    if (pre != null){

                        int d = (s-pre)/2;
                        if (d > dist){
                            dist = d;
                            seat = pre+d;
                        }
                    }
                    pre = s;
                }

                if ((N-1-students.last()) > dist){
                    seat = N-1;
                }
            }

            students.add(seat);
            return seat;
        }

        public void leave(int p) {
            students.remove(p);
        }
    }
}
