//https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/description/

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        //time complexity is O(n), if the length of s is n
        //space complexity is O(n), if the number of keys in knowledge is n

        //set new data structure, to make easier to find values
        Map<String, String> map = new HashMap<String, String>();

        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }

        StringBuilder sb = new StringBuilder(); //for return string
        StringBuilder keyString = new StringBuilder(); //for key String
        Boolean inBracket = false;

        for (char c : s.toCharArray()) {
            if (c == '(') { //start bracket
                inBracket = true; 
            } 
            else if (c == ')') { //if end bracket
                inBracket = false; //then inBracket made false
                if (map.containsKey(keyString.toString())) {
                    sb.append(map.get(keyString.toString()));
                }
                else {
                    sb.append("?");
                }
                keyString.setLength(0); //to initialize keyString
            }
            else if (inBracket) {   //if inside bracket, (and not end bracket)
                keyString.append(c); //append this c character 
            }
            else { //not inside bracket, but default/normal string
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
