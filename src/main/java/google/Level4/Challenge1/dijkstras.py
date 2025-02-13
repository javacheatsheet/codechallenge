# Python program for Dijkstra's single  
# source shortest path algorithm. The program is  
# for adjacency matrix representation of the graph 
  
# Library for INT_MAX 
import sys 

# define infinity as maximum value of the integer
INF = float('inf')

class Graph(): 
   
    def __init__(self, vertices): 
        self.V = vertices 
        self.graph = [[0 for column in range(vertices)]  
                    for row in range(vertices)] 
   
    def printSolution(self, dist, src): 
        print ("Vertex t Distance from Source: ", src) 
        for node in range(self.V): 
            print (node, "t", dist[node]) 
   
    # A utility function to find the vertex with  
    # minimum distance value, from the set of vertices  
    # not yet included in shortest path tree 
    def minDistance(self, dist, sptSet, min): 
   
        # Initilaize minimum distance for next node 
        min = sys.maxsize 

        min_index = -1
        # Search not nearest vertex not in the  
        # shortest path tree 
        for v in range(self.V): 

            if dist[v] < min and sptSet[v] == False: 
                min = dist[v] 
                min_index = v 
   
        return min_index 
   
    # Funtion that implements Dijkstra's single source  
    # shortest path algorithm for a graph represented  
    # using adjacency matrix representation 
    def dijkstra(self, src): 
   
        dist = [5] * self.V 
        dist[src] = 0
        sptSet = [False] * self.V 
   
        for cout in range(self.V): 
   
            # Pick the minimum distance vertex from  
            # the set of vertices not yet processed.  
            # u is always equal to src in first iteration 
            u = self.minDistance(dist, sptSet, min) 
   
            # Put the minimum distance vertex in the  
            # shotest path tree 
            sptSet[u] = True
   
            # Update dist value of the adjacent vertices  
            # of the picked vertex only if the current  
            # distance is greater than new distance and 
            # the vertex in not in the shotest path tree 
            for v in range(self.V):

                if self.graph[u][v] > 0\
                    and sptSet[v] == False\
                    and dist[v] > dist[u] + self.graph[u][v]: 
                    dist[v] = dist[u] + self.graph[u][v] 
   
        self.printSolution(dist, src) 


if __name__ == '__main__':
    # Driver program 
     
    # g.graph = [[0, 4, 0, 0, 0, 0, 0, 8, 0], 
    #         [4, 0, 8, 0, 0, 0, 0, 11, 0], 
    #         [0, 8, 0, 7, 0, 4, 0, 0, 2], 
    #         [0, 0, 7, 0, 9, 14, 0, 0, 0], 
    #         [0, 0, 0, 9, 0, 10, 0, 0, 0], 
    #         [0, 0, 4, 14, 10, 0, 2, 0, 0], 
    #         [0, 0, 0, 0, 0, 2, 0, 1, 6], 
    #         [8, 11, 0, 0, 0, 0, 1, 0, 7], 
    #         [0, 0, 2, 0, 0, 0, 6, 7, 0] 
    #         ]
    g = Graph(5)


    # g.graph = [[0, 2, 2, 2, -1], [9, 0, 2, 2, -1], [9, 3, 0, 2, -1], [9, 3, 2, 0, -1], [9, 3, 2, 2, 0]]

    g.graph = [[0, 1, 1, 1, 1], [1, 0, 1, 1, 1], [1, 1, 0, 1, 1], [1, 1, 1, 0, 1], [1, 1, 1, 1, 0]]
    # time = 3
    
    # g.graph = [
    #         [0, 3, 3, 3, 0],
    #         [10, 0, 3, 3, 0],
    #         [10, 4, 0, 3, 0],
    #         [10, 4, 3, 0, 0],
    #         [9, 3, 2, 2, 0]]
    
    for i in range(0, len(g.graph)):
        g.dijkstra(i)
