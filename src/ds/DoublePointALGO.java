package ds;

/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DoublePointALGO {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int area = 0;
        int ans = 0;
        while(left != right){
            area = Math.min(height[left],height[right])*(right - left);
            ans = Math.max(ans,area);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return ans;

    }

    public static void main(String[] args){
        maxArea(new int[]{2,3,4,5,18,17,6});
    }
}
