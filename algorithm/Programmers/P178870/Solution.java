package algorithm.Programmers.P178870;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0; int right = 0;
        int sum = sequence[left];
        int diff = 10000000;
        int curr_left = 0, curr_right = 0;
        
        while(true) {
            
            if(right >= sequence.length) break;
            if(left > right) break;
            
            if(sum < k) {
                right++;
                if(right < sequence.length) sum += sequence[right];
            }
            else if(sum == k) {
                if(right - left < diff) {
                    curr_left = left;
                    curr_right = right;
                    diff = right - left;
                }
                sum -= sequence[left];
                left++;
            }
            else {
                sum -= sequence[left];
                left++;
            }
        }
        
        
        
        int[] answer = {curr_left, curr_right};
        return answer;
    }
}
