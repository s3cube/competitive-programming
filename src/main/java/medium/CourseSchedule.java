package medium;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {

        int numCourses = 2;
        int preReq[][] = {
                {1,0}
        };

        new CourseSchedule().canFinish(numCourses, preReq);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {


        int inDegrees[] = new int[numCourses];

        HashMap<Integer, HashSet<Integer>> connections = new HashMap<>();
        int count = 0;

        for (int i = 0; i < numCourses; i++){
            connections.put(i, new HashSet<>());
        }

        for (int i = 0; i < prerequisites.length; i++){

            int course = prerequisites[i][0];
            int dependsOn = prerequisites[i][1];

            HashSet<Integer> listOfChildren = connections.get(dependsOn);
            listOfChildren.add(course);
            connections.put(dependsOn, listOfChildren);
            inDegrees[course]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();


        for (int i = 0; i < numCourses; i++){

            if(inDegrees[i] == 0){
                queue.add(i);
                count++;
            }
        }

        while (!queue.isEmpty()){
                int course = queue.poll();

                for (int enables : connections.get(course)){
                    int pointerFor = enables;
                    inDegrees[pointerFor]--;
                    if(inDegrees[pointerFor] == 0){
                        queue.add(pointerFor);
                        count++;
                    }
                }

        }


        if(count == numCourses){
            return true;
        }else {
            return false;
        }
    }
}
