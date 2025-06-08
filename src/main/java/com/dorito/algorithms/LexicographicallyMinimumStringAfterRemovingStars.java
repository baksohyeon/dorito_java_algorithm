package com.dorito.algorithms;

import java.util.Arrays;

public class LexicographicallyMinimumStringAfterRemovingStars {

    public String minRemoveToMakeValid(String s) {

        char[] chars = s.toCharArray();
        int[] idxChain = new int[chars.length];
        int[] idxChainRev = new int[26];

        Arrays.fill(idxChain, -1);
        Arrays.fill(idxChainRev, -1);


        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '*') {
                for (int j = 0; j < 26; j++) {
                    if(idxChainRev[j] != -1) {
//                        int idx = idxChainRev[j];
                        chars[idxChainRev[j]] = '#';
//                        chars[idx] = '#';
//                        idxChainRev[j] = idxChain[idx];
                        idxChainRev[j] = idxChain[idxChainRev[j]];
                        break;
                    }
                }
                chars[i] = '#';
            } else {
                idxChain[i] = idxChainRev[chars[i] - 'a'];
                idxChainRev[chars[i] - 'a'] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c != '#') {
                sb.append(c);
            }
        }

    return sb.toString();
    };
}
