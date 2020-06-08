package june;

import java.util.*;

public class ReconstructQueue {

    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0) {
            return people;
        }
        int[][] res = new int[people.length][people[0].length];
        for (int i = 0; i<res.length; i++) {
            res[i][0]=-1;
        }
        Arrays.sort(people, (int[] a, int[] b) -> a[0] - b[0]);
        for(int i = 0; i<people.length; i++) {
            int count = people[i][1];
            int j = -1;
            while(count>=0)  {
                if (j<res.length-1) j++;
                if (res[j][0] == -1 || res[j][0] == people[i][0]) count--;

            }
            res[j] = people[i];
        }

        return res;
    }

    public int[][] reconstructQueue2(int[][] people) {
        if (people.length == 0) {
            return people;
        }
        List<int[]> a = new ArrayList<>();
        Arrays.sort(people, (int[] aa, int[] b) -> aa[0] == b[0] ? aa[1]-b[1] : b[0] - aa[0]);
        for(int i = 0; i<people.length; i++) {
            a.add(people[i][1], people[i]);
        }


        return a.toArray(new int[a.size()][]);
    }

    /*
     List<int[]> result = new ArrayList<>();

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                return x[0] == y[0] ? x[1] - y[1] : y[0] - x[0];
            }
        });

        for(int[] person : people) {
            result.add(person[1], person);
        }

        return result.toArray(new int[result.size()][]);
     */


    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(new ReconstructQueue().reconstructQueue2(people));
        System.out.println(people);
    }
}
