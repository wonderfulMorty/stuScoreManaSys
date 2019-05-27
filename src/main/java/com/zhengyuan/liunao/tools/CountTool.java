package com.zhengyuan.liunao.tools;

import java.util.Collections;
import java.util.List;




public class CountTool {
	
	//求众数
	 public static float maxNum(List<Float> nums) {
		 float num = 0;
		 if(!nums.isEmpty()) {
			 Collections.sort(nums);
			 num = nums.get(nums.size()-1);
		 }
		 return num;
	    }
	 
	 
	 //求中位数
	 public static float midnum(List<Float> total) {
		 float j = 0;
		    if(!total.isEmpty()) {
		    	 Collections.sort(total);
				    int size = total.size();
				    if(size % 2 == 1){
				    	j = total.get((size-1)/2);
				    }else {
				    	//加0.0是为了把int转成double类型，否则除以2会算错
				    	j = (float) ((total.get(size/2-1) + total.get(size/2) + 0.0)/2);
				    }
		    }
			return j;
		}
	
	 public static float aveNums(float sum,int len) {
		 float f=0;
		 if(len!=0) {
			 f = (float) (sum/len*1.0);
		 }
		 return f;
	 }
	 
}
