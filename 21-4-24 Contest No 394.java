1.Count the Number of Special Characters I




  class Solution {
    public int numberOfSpecialChars(String word) {
                int count = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (word.indexOf(c) != -1 && word.indexOf(Character.toUpperCase(c)) != -1) {
                count++;
            }
        }
        return count;

    }
}


2.Count the Number of Special Characters II

You are given a string word. A letter c is called special if it appears both in lowercase and uppercase in word, and every lowercase occurrence of c appears before the first uppercase occurrence of c.

Return the number of special letters in word.


  class Solution {
public:
    int numberOfSpecialChars(string word) {
         int n = 26;
        int upperPos[n];
        int lowerCount[n];
        int lowerSpec[n];
        
        // Initialize arrays
        for(int i = 0; i < n; i++) {
            upperPos[i] = -1;
            lowerCount[i] = -1;
            lowerSpec[i] = -1;
        }
        
        for(int i = 0; i < word.length(); i++) {
            char ch = word[i];
            if(ch >= 'A' && ch <= 'Z' && upperPos[ch - 'A'] == -1) {
                upperPos[ch - 'A'] = i; // get the last occurrence of the upper letter in the word
            }
        }
        
        for(int i = 0; i < word.length(); i++) {
            char ch = word[i];
            if((ch >= 'a' && ch <= 'z') ) {
                lowerCount[ch - 'a']++;
                if(i < upperPos[ch - 'a']) {
                    lowerSpec[ch - 'a']++;
                }
            }
        }
        
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(lowerCount[i] == lowerSpec[i] && lowerCount[i] != -1) {
                count++;
            }
        }
        
        return count;
    }
};

 
