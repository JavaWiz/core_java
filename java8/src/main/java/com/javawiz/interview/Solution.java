package com.javawiz.interview;

class Solution {
    public int solution(String S) {
        if(S.contains("aaa")) {
            return -1;
        } else if("aa".equals(S)) {
            return 0;
        } else{
            int countA = count(S);
            int totalCount;
            StringBuilder str = new StringBuilder("aa");
            for(int i = 0; i< S.length();i++)
                if(S.charAt(i) != 'a')
                    str.append(S.charAt(i)).append("aa");
            System.out.println("string: "+str);
            totalCount = count(str.toString());
            return totalCount - countA;
        }
    }

    private int count(String s){
        int res = 0;
        for (int i=0; i<s.length(); i++)
        {
            // checking character in string
            if (s.charAt(i) == 'a')
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("abab -> "+ s.solution("abab"));
        System.out.println("dog -> "+ s.solution("dog"));
        System.out.println("aa -> "+ s.solution("aa"));
        System.out.println("baa -> "+ s.solution("baa"));
        System.out.println("baaaa -> "+ s.solution("baaaa"));
        System.out.println("aaab -> "+ s.solution("aaab"));
        System.out.println("baaabaaa -> "+ s.solution("baaabaaa"));
    }
}