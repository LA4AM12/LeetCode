package Offer;

//归并排序
public class Solution51 {
    private int[] temp;
    private int pair;
    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        merge(nums,0, nums.length-1);
        return pair;
    }

    private void merge(int[] nums, int l, int r){
        if(l >= r) return;

        int mid = (l+r) >>> 1;
        merge(nums,l,mid);
        merge(nums,mid+1,r);

        for (int i = l; i <= mid; i++) {
            temp[i] = nums[i];
        }

        int i = l, j = mid + 1 , k = l;
        while (i<=mid && j <= r){
            if (temp[i] <= nums[j]){
                nums[k++] = temp[i++];
            }else {  //temp[i] > nums[j]
                pair += (mid-i+1);  //统计逆序对
                nums[k++] = nums[j++];
            }
        }
        while (i <= mid){
            nums[k++] = temp[i++];
        }
    }

}
