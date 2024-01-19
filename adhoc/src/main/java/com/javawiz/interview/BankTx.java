package com.javawiz.interview;

public class BankTx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Example test:   ([100, 100, 100, -10], ['2020-12-31', '2020-12-22', '2020-12-03', '2020-12-29'])
WRONG ANSWER (got 370 expected 230)

Example test:   ([180, -50, -25, -25], ['2020-01-01', '2020-01-01', '2020-01-01', '2020-01-31'])
WRONG ANSWER (got 335 expected 25)

Example test:   ([1, -1, 0, -105, 1], ['2020-12-31', '2020-04-04', '2020-04-04', '2020-04-14', '2020-07-12'])
WRONG ANSWER (got 163 expected -164)

Example test:   ([100, 100, -10, -20, -30], ['2020-01-01', '2020-02-01', '2020-02-11', '2020-02-05', '2020-02-08'])
WRONG ANSWER (got 315 expected 80)

Example test:   ([-60, 60, -40, -20], ['2020-10-01', '2020-02-02', '2020-10-10', '2020-10-30'])
WRONG ANSWER (got 235 expected -115)

		 */
		int A[] = new int[]{100, 100, 100, -10};
		String[] D= new String[]{"2020-12-31", "2020-12-22", "2020-12-03", "2020-12-29"};
		System.out.println(solution(A, D));

	}
	
	public static int solution(int[] A, String[] D) {
        // write your code in Java SE 8
        int total =0, deposit=0, withdraw=0, annualFee=0, counter = 0;
        for(int i=0;i<A.length;i++){
            if(A[i]>0) {
            	deposit+=A[i];
            	if(A[i]>=100)
            		counter++;
            }else {
            	withdraw+=A[i];
            }
        }
        
        if(counter>=3 || D.length>=5)
        	annualFee=5*12;
        else
        	annualFee=5*11;
        
        total = (deposit + withdraw) - annualFee;
        
         return total;
    }
}
