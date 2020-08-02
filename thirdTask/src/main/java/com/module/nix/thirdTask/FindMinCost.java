package com.module.nix.thirdTask;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindMinCost {

    public static void dijkstra(int[][] graph, int sourceVertex, int to) throws IOException {
        int vertexCount = graph.length;
        boolean[] visitedVertex = new boolean[vertexCount];
        int[] distance = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++){
            visitedVertex[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }

        distance[sourceVertex] = 0;
        for (int i = 0; i < vertexCount; i++){

            int u = findMinDistance(distance, visitedVertex);

            visitedVertex[u] = true;

            for (int v =0 ; v < vertexCount; v++){

                if(!visitedVertex[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])){
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

        try(FileWriter writer = new FileWriter("output.txt", true))
        {
            writer.write(String.valueOf(distance[to]));
            writer.append('\n');
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static int findMinDistance(int[] distance, boolean[] visitedVertex) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        for (int i =0; i < distance.length; i++){

            if(!visitedVertex[i] && distance[i] < minDistance){
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }

    public static void writeResultToFile() throws IOException {
        File file = new File("input.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        int counter = 0;
        int counterj = 0;
        Map<String, Integer> names = new LinkedHashMap<>();

        int n = Integer.parseInt(reader.readLine());

        int[][] graph = new int[n][n];

        while (n != 0) {
            String NAME = reader.readLine();
            names.put(NAME, counter);
            counter++;
            int p = Integer.parseInt(reader.readLine());
            while (p != 0) {
                String temp = reader.readLine();
                String[] words = temp.split(" ");
                int nr = Integer.parseInt(words[0]);
                int cost = Integer.parseInt(words[1]);
                graph[nr - 1][counterj] = cost;
                p--;
            }
            n--;
            counterj++;
        }

        int r = Integer.parseInt(reader.readLine());
        while (r != 0) {
            String temp = reader.readLine();
            String[] words = temp.split(" ");
            String NAME1 = words[0];
            String NAME2 = words[1];
            r--;

            int start = names.get(NAME1);
            int end = names.get(NAME2);

            FindMinCost.dijkstra(graph, start, end);
        }

    }


}

