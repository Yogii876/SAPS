package System;

/******************************************************************************
 *  Compilation:  javac AssignmentProblem.java
 *  Execution:    java AssignmentProblem n
 *  Dependencies: DijkstraSP.java DirectedEdge.java
 *
 *  Solve an n-by-n assignment problem in n^3 log n time using the
 *  successive shortest path algorithm.
 *
 ******************************************************************************/

/**
 *  The {@code AssignmentProblem} class represents a data type for computing
 *  an optimal solution to an <em>n</em>-by-<em>n</em> <em>assignment problem</em>.
 *  The assignment problem is to find a minimum weight matching in an
 *  edge-weighted complete bipartite graph.
 *  <p>
 *  The data type supplies methods for determining the optimal solution
 *  and the corresponding dual solution.
 *  <p>
 *  This implementation uses the <em>successive shortest paths algorithm</em>.
 *  The order of growth of the running time in the worst case is
 *  O(<em>n</em>^3 log <em>n</em>) to solve an <em>n</em>-by-<em>n</em>
 *  instance.
 *  <p>
 *  For additional documentation, see
 *  <a href="https://algs4.cs.princeton.edu/65reductions">Section 6.5</a>
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */


public class AssignmentProblem {
    private static final int UNMATCHED = -1;

    private int n;              // number of rows 
    private int m; 				// number of columns
    private int[][] weight;  // the n-by-m cost matrix
    private int minWeight = 0;   // minimum value of any weight
    private int[] px;        // px[i] = dual variable for row i
    private int[] py;        // py[j] = dual variable for col j
    private int[] xy;           // xy[i] = j means i-j is a match
    private int[] yx;           // yx[j] = i means i-j is a match
    
    public AssignmentProblem(int[][] weight, int rows, int cols) {
    	if (weight == null) throw new IllegalArgumentException("constructor argument is null");
    	n = rows;
    	m = cols;
        this.weight = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.weight[i][j] = weight[i][j];
            }
        }
    	
        // dual variables
        px = new int[n];
        py = new int[m];

        // initial matching is empty
        xy = new int[n];
        yx = new int[m];
        for (int i = 0; i < n; i++)
             xy[i] = UNMATCHED;
        for (int j = 0; j < m; j++)
             yx[j] = UNMATCHED;

    }

}
