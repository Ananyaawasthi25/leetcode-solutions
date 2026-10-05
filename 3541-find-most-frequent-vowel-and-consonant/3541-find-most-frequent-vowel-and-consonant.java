class Solution {
    public int maxFreqSum(String s) {
       HashMap<Character, Integer> map=new HashMap<>();
       for(char ch:s.toCharArray()){
        map.put(ch,map.getOrDefault(ch, 0)+1);
       }
        int maxvo=0;
        int maxco=0;
        for(char ch:map.keySet()){
            int freq=map.get(ch);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
               maxvo= Math.max(maxvo,freq);
            }else{
                 maxco= Math.max(maxco,freq);
            }

        }
        return maxco+maxvo;
    }
}