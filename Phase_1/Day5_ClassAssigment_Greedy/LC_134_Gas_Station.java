package Day5_ClassAssigment_Greedy;

public class LC_134_Gas_Station {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []gas = {1,2,3,4,5};
		int []cost = {3,4,5,1,2};
		System.out.println(canCompleteCircuit(gas,cost));

	}
	public static int canCompleteCircuit(int[] gas, int[] cost) {
        // Step 1: Check if a solution is possible by comparing total gas and total cost
        int total = 0;
        for (int i = 0; i < cost.length; i++) {
            total += gas[i] - cost[i];  // net gain or loss at each station
        }

        // If total gas is less than total cost, the car can never complete the circuit
        if (total < 0) {
            return -1;
        }

        // Step 2: Find the starting index of the gas station
        int idx = 0;   // starting station index
        int curr = 0;  // current fuel balance from the chosen starting point

        for (int i = 0; i < cost.length; i++) {
            curr += gas[i] - cost[i];  // update current balance at station i

            // If balance becomes negative, the current start is not valid
            if (curr < 0) {
                // Move starting index to the next station
                idx = i + 1;
                // Reset current balance
                curr = 0;
            }
        }

        // By now, idx points to the valid starting station
        return idx;
    }


}
