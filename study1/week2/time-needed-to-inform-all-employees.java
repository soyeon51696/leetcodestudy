//https://leetcode.com/problems/time-needed-to-inform-all-employees/description/

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        //there is n employees, ID for each form 0 to n-1
        //each employee has one direct manager given in the manager array
        //in manager array, each index is a direct manager ID
        //ex. [2,2,-1,2,2,2] -> id= 0,1,3,4,5 has a direct manager id 2

        //head wants to inform all the employees
        //i-th employee needs informTime[i] minutes to inform
        
        //so how to solve it?
        //get depth of the tree and return time of longst depth
        //if depths are same, then return max minuten of depth 
        //so I need to make a helper Method

        int sumMinuten = 0;

        if (n <= 1) {
            return sumMinuten;
        }

        return dfs(headID, manager, informTime);
        
    }
    public int dfs(int id, int[] manager, int[] informTime) {
        int sumMinuten = 0;


        return sumMinuten ;//+ dfs(nextId, manager, informTime)
    }
}
