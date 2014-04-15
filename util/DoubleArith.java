package com.targ.common.util;

import java.math.BigDecimal;

public class DoubleArith {
	//默认精度 
	private static final int DEF_DIVIDE_SCALE = 2;
	 
	/**
	 * 相加
	 * @param v1
	 * @param v2
	 * @return
	 */
	 public static double add(double v1, double v2) {
	  BigDecimal b1 = new BigDecimal(Double.toString(v1));
	  BigDecimal b2 = new BigDecimal(Double.toString(v2));
	  return b1.add(b2).doubleValue();
	 }
	 
	 /**
	  * 相减
	  * @param v1
	  * @param v2
	  * @return
	  */
	 public static double subtract(double v1, double v2) {
	  BigDecimal b1 = new BigDecimal(Double.toString(v1));
	  BigDecimal b2 = new BigDecimal(Double.toString(v2));
	  return b1.subtract(b2).doubleValue();
	 }
	 
	 /**
	  * 相乘
	  * @param v1
	  * @param v2
	  * @return
	  */
	 public static double multiply(double v1, double v2) {
	  BigDecimal b1 = new BigDecimal(Double.toString(v1));
	  BigDecimal b2 = new BigDecimal(Double.toString(v2));
	  return multiply(v1,v2,DEF_DIVIDE_SCALE);
	 }
	 
	 /**
	  * 相乘
	  * @param v1
	  * @param v2
	  * @param scale
	  * @return
	  */
	 public static double multiply(double v1, double v2,int scale) {
		  BigDecimal b1 = new BigDecimal(Double.toString(v1));
		  BigDecimal b2 = new BigDecimal(Double.toString(v2));
		  return round(b1.multiply(b2).doubleValue(),scale);
		 }
	 
	 
	 
	 /**
	  * 相除
	  * @param v1
	  * @param v2
	  * @return
	  */
	 public static double divide(double v1, double v2) {
	  return divide(v1, v2, DEF_DIVIDE_SCALE);
	 }
	 
	 /**
	  * 相除
	  * @param v1
	  * @param v2
	  * @param scale
	  * @return
	  */
	 public static double divide(double v1, double v2, int scale) {
	  if (scale < 0) {
	   throw new IllegalArgumentException(
	     "精度必须是一个大于0的整数");
	  }
	  BigDecimal b1 = new BigDecimal(Double.toString(v1));
	  BigDecimal b2 = new BigDecimal(Double.toString(v2));
	  return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	 }
	 
	 /**
	  * 保留精度。四色五入
	  * @param v
	  * @param scale
	  * @return
	  */
	 public static double round(double v, int scale) {
	  if (scale < 0) {
	   throw new IllegalArgumentException(
	     "精度必须是一个大于0的整数");
	  }
	  BigDecimal b = new BigDecimal(Double.toString(v));
	  BigDecimal one = new BigDecimal("1");
	  return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	 }
}
