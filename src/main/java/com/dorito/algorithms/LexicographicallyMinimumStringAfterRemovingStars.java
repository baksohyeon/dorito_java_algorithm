package com.dorito.algorithms;

public class LexicographicallyMinimumStringAfterRemovingStars {
    String s = "hello";
    int length = s.length();

    public String minRemoveToMakeValid(String s) {
        this.s = s;
        length = s.length();

        StringBuilder sb = new StringBuilder();



        // count the number of stars
        // if zero, then return the original string.
        // if stars * 2 == string.length(), then return ""

        // Iterate through string and remove stars
        // 1)
        // Find the first star at least index, then remove one character is lexicographically smaller than the previous character
        // if same lexicographically, delete one any of them.
        // all the cases should be covered.
        // dfs 사용 think

        // 2)
        // delete selected star and char

        // 3) check if the string is empty
        // if empty, return ""


        // base condition:
        // remove all stars



        // sorting and return index 0


    return "";
    };
}
