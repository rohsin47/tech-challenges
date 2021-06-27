package com.alds.hr.visa;

public class MirrorCount {
	public static int maxMirror(int[] nums) {
	    int max = 0;
	    
	    for(int i = 0; i < nums.length; i++) {
	        int count = 0;
	        for(int j = nums.length - 1; j >= 0 && i + count < nums.length; j--) {
	            if(nums[i + count] == nums[j]) {
	                count++;
	            } else {
	                max = Math.max(max, count);
	                count = 0;
	            }
	        }
	                                                                
	        max = Math.max(max, count);
	    }
	
	    return max;
	}
	
	public static int maxMirror2(int[] nums) {
        final int len = nums.length;
        if (len == 0)
            return 0;
        int maxCount = 1;
        boolean flag = false;

        for (int i = 0; i<len; i++)
        {
            int tempCount = 1;
            int count = i;

            for (int j = len-1; j>= 0 && (count<len); j--)
            {
                if (nums[count] == nums[j] && !flag)
                {
                    flag = true;
                    count++;
                    continue;
                }
                if (nums[count] == nums[j] && flag)
                {
                    tempCount++;
                    count++;
                    maxCount = (tempCount>maxCount)?tempCount:maxCount;
                    continue;
                }
                if (nums[i] != nums[j] && flag)
                {
                    flag = false;
                    count = i;
                    tempCount = 1;
                    continue;
                }
                if (j == count || (j-count)==1)
                {
                    flag = false;
                    break;
                }

            }
        }    
        return maxCount;    
    }
	
	public static int maxMirror3(int[] nums) {
	    final int len = nums.length;
	    if (len == 0)
	        return 0;
	    int maxCount = 1;
	    boolean flag = false;

	    for (int i = 0; i<len; i++)
	    {
	        int tempCount = 1;
	        int count = i;

	        for (int j = len-1; j>= 0; j--)
	        {
	            if (nums[count] == nums[j])
	            {
	                if (flag)
	                {
	                    tempCount++;
	                    maxCount = Math.max(tempCount, maxCount);
	                }
	                flag = true;
	                count++;
	                if (count>=len)
	                    break;
	            }
	            else if (nums[i] != nums[j] && flag)
	            {
	                flag = false;
	                count = i;
	                tempCount = 1;
	            }
	            else if (j == count || j == (count+1))
	            {
	                flag = false;
	                break;
	            }
	        }
	    }    
	    return maxCount;    
	}
	
	public static void main(String[] args) {
		System.out.println("Result for 1 : "+ maxMirror3(new int[]{1, 2, 3, 8, 9, 3, 2, 1}));
		System.out.println("Result for 2 : "+ maxMirror3(new int[]{2, 5, 6, 8}));
		System.out.println("Result for 3 : "+ maxMirror3(new int[]{7, 2, 3, 4, 5,8, 9, 5, 4, 3, 2}));
	}
}

