package com.github.cwdtom.leetcode;

/**
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/description/
 * https://www.cnblogs.com/zhangziqiu/archive/2011/03/30/ComputerCode.html
 * 原码补码反码概念
 *
 * @author chenweidong
 */
public class ConvertANumberToHexadecimal405 {
    public static void main(String[] args) {
        System.out.println(
                new ConvertANumberToHexadecimal405.Solution().toHex(-1)
        );
    }

    static class Solution {
        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

        public String toHex(int num) {
            if (num == 0) {
                return "0";
            }

            StringBuilder sb = new StringBuilder();
            while(num != 0){
                sb.insert(0, map[num & 15]);
                num = (num >>> 4);
            }
            return sb.toString();
        }
    }
}
