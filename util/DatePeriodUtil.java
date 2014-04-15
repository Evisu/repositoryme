package com.targ.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.targ.examine.base.common.util.DateUtil;

/**
 * 
 * 日期周期工具类
 * guochen
 * 
 */
public class DatePeriodUtil {

	/**
	 * 周期：年
	 */

	public static final int YEAR = 1;

	/**
	 * 周期：季度
	 */

	public static final int QUARTER = 2;

	/**
	 * 周期：月
	 */

	public static final int MONTH = 3;

	/** 基准时间 */

	private Date fiducialDate = null;

	private Calendar cal = null;

	/**
	 * 获取DatePeriodUtil实例
	 * 
	 * @param fiducialDate
	 * @return Date
	 */
	public static DatePeriodUtil getInstance(Date fiducialDate) {

		return new DatePeriodUtil(fiducialDate);

	}

	/**
	 * 获取DatePeriodUtil实例, 使用当前时间作为基准时间
	 * 
	 * @return Date
	 */

	public static DatePeriodUtil getInstance() {

		return new DatePeriodUtil(null);

	}

	private DatePeriodUtil(Date fiducialDate) {

		if (fiducialDate != null) {

			this.fiducialDate = fiducialDate;

		} else {

			this.fiducialDate = new Date(System.currentTimeMillis());

		}

		this.cal = Calendar.getInstance();

		this.cal.setTime(this.fiducialDate);

		this.cal.set(Calendar.HOUR_OF_DAY, 0);

		this.cal.set(Calendar.MINUTE, 0);

		this.cal.set(Calendar.SECOND, 0);

		this.cal.set(Calendar.MILLISECOND, 0);

		this.fiducialDate = this.cal.getTime();

	}

	/**
	 * 获取年的第一天
	 * 
	 * @param offset
	 *            偏移量
	 * @return Date
	 */
	public Date getFirstDayOfYear(int offset) {

		cal.setTime(this.fiducialDate);

		cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) + offset);

		cal.set(Calendar.MONTH, Calendar.JANUARY);

		cal.set(Calendar.DAY_OF_MONTH, 1);

		return cal.getTime();

	}

	/**
	 * 获取年的最后一天
	 * 
	 * @param offset
	 *            偏移量
	 * @return Date
	 */
	public Date getLastDayOfYear(int offset) {

		cal.setTime(this.fiducialDate);

		cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) + offset);

		cal.set(Calendar.MONTH, Calendar.DECEMBER);

		cal.set(Calendar.DAY_OF_MONTH, 31);

		return cal.getTime();

	}

	/**
	 * 
	 * 获取季度的第一天
	 * 
	 * @param offset
	 *            偏移量
	 * @return Date
	 * 
	 */

	public Date getFirstDayOfQuarter(int offset) {

		cal.setTime(this.fiducialDate);

		cal.add(Calendar.MONTH, offset * 3);

		int mon = cal.get(Calendar.MONTH);

		if (mon >= Calendar.JANUARY && mon <= Calendar.MARCH) {

			cal.set(Calendar.MONTH, Calendar.JANUARY);

			cal.set(Calendar.DAY_OF_MONTH, 1);

		}

		if (mon >= Calendar.APRIL && mon <= Calendar.JUNE) {

			cal.set(Calendar.MONTH, Calendar.APRIL);

			cal.set(Calendar.DAY_OF_MONTH, 1);

		}

		if (mon >= Calendar.JULY && mon <= Calendar.SEPTEMBER) {

			cal.set(Calendar.MONTH, Calendar.JULY);

			cal.set(Calendar.DAY_OF_MONTH, 1);

		}

		if (mon >= Calendar.OCTOBER && mon <= Calendar.DECEMBER) {

			cal.set(Calendar.MONTH, Calendar.OCTOBER);

			cal.set(Calendar.DAY_OF_MONTH, 1);

		}

		return cal.getTime();

	}

	/**
	 * 
	 * 获取季度的最后一天
	 * 
	 * @param offset
	 *            偏移量
	 * @return Date
	 * 
	 */

	public Date getLastDayOfQuarter(int offset) {

		cal.setTime(this.fiducialDate);

		cal.add(Calendar.MONTH, offset * 3);

		int mon = cal.get(Calendar.MONTH);

		if (mon >= Calendar.JANUARY && mon <= Calendar.MARCH) {

			cal.set(Calendar.MONTH, Calendar.MARCH);

			cal.set(Calendar.DAY_OF_MONTH, 31);

		}

		if (mon >= Calendar.APRIL && mon <= Calendar.JUNE) {

			cal.set(Calendar.MONTH, Calendar.JUNE);

			cal.set(Calendar.DAY_OF_MONTH, 30);

		}

		if (mon >= Calendar.JULY && mon <= Calendar.SEPTEMBER) {

			cal.set(Calendar.MONTH, Calendar.SEPTEMBER);

			cal.set(Calendar.DAY_OF_MONTH, 30);

		}

		if (mon >= Calendar.OCTOBER && mon <= Calendar.DECEMBER) {

			cal.set(Calendar.MONTH, Calendar.DECEMBER);

			cal.set(Calendar.DAY_OF_MONTH, 31);

		}

		return cal.getTime();

	}

	/**
	 * 获取月的第一天
	 * 
	 * @param offset
	 *            偏移量
	 * @return Date
	 */

	public Date getFirstDayOfMonth(int offset) {

		cal.setTime(this.fiducialDate);

		cal.add(Calendar.MONTH, offset);

		cal.set(Calendar.DAY_OF_MONTH, 1);

		return cal.getTime();

	}

	/**
	 * 
	 * 获取月的最后一天
	 * 
	 * @param offset
	 *            偏移量
	 * @return Date
	 * 
	 */

	public Date getLastDayOfMonth(int offset) {

		cal.setTime(this.fiducialDate);

		cal.add(Calendar.MONTH, offset + 1);

		cal.set(Calendar.DAY_OF_MONTH, 1);

		cal.add(Calendar.DAY_OF_MONTH, -1);

		return cal.getTime();

	}

	/**
	 * 取得当前日期 年-月-日
	 * @return Date
	 * 
	 */

	public static String getCurrentDate() {

		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

		return f.format(Calendar.getInstance().getTime());

	}
	
	/**
	 * 取得当前月份
	 * @return
	 */
	public int getCurrentMonth(){
		
		cal.setTime(new Date(System.currentTimeMillis()));
		
		return cal.get(Calendar.MONTH) + 1;
	}
	
	/**
	 * 取得当前季度
	 * @return
	 */
	public int getCurrentQuarter(){
		
		cal.setTime(new Date(System.currentTimeMillis()));
		
		int mon = cal.get(Calendar.MONTH);
		
		if (mon >= Calendar.JANUARY && mon <= Calendar.MARCH) {
			return 1;
		}

		if (mon >= Calendar.APRIL && mon <= Calendar.JUNE) {
			return 2;
		}

		if (mon >= Calendar.JULY && mon <= Calendar.SEPTEMBER) {
			return 3;
		}

		if (mon >= Calendar.OCTOBER && mon <= Calendar.DECEMBER) {
			return 4;
		}
		return 0;
	}
	
	/**
	 * 取得当前年份
	 * @return
	 */
	public int getCurrentYear(){
		
		cal.setTime(new Date(System.currentTimeMillis()));
		
		return cal.get(Calendar.YEAR);
	}
	
	
	/**
	 * 获取某一年某一季度的第一天
	 * @param quarter
	 * @return
	 */
	public Date getFirstDayByQuarter(int year,int quarter){
		return DatePeriodUtil.getInstance().getFirstDayOfQuarter(quarter + (year - getCurrentYear()) * 4 - DatePeriodUtil.getInstance().getCurrentQuarter());
	}
	
	/**
	 * 获取某一年某一季度的最后一天
	 * @param quarter
	 * @return
	 */
	public Date getLastDayByQuarter(int year,int quarter){
		return DatePeriodUtil.getInstance().getLastDayOfQuarter(quarter + (year - getCurrentYear()) * 4 - DatePeriodUtil.getInstance().getCurrentQuarter());
	}
	
	/**
	 * 获取某一年某一月份的第一天
	 * @param month
	 * @return
	 */
	public Date getFirstDayByMonth(int year,int month){
		return DatePeriodUtil.getInstance().getFirstDayOfMonth(month + (year - getCurrentYear()) * 12 - DatePeriodUtil.getInstance().getCurrentMonth());
	}
	
	/**
	 * 获取某一年某一月份的最后一天
	 * @param month
	 * @return
	 */
	public Date getLastDayByMonth(int year,int month){
		return DatePeriodUtil.getInstance().getLastDayOfMonth(month + (year - getCurrentYear()) * 12 - DatePeriodUtil.getInstance().getCurrentMonth());
	}
	
	/**
	 * 获取某一年的第一天
	 * @param year
	 * @return
	 */
	public Date getFirstDayByYear(int year){
		return DatePeriodUtil.getInstance().getFirstDayOfYear(year - DatePeriodUtil.getInstance().getCurrentYear());
	}
	
	/**
	 * 获取某一年的最后一天
	 * @param year
	 * @return
	 */
	public Date getLastDayByYear(int year){
		return DatePeriodUtil.getInstance().getLastDayOfYear(year - DatePeriodUtil.getInstance().getCurrentYear());
	}
	
	/**
	 * 根据参数获取某一年某一频率某一周期值的开始时间
	 * @param year 年度
	 * @param frequency 频率
	 * @param period 周期值
	 * @return 日期
	 */
	public Date getFirstDayByCondition(int year,String frequency,int period){
		Date firstDate = null;
		//月份
		if("1".equals(frequency) || "month".equals(frequency)){
			firstDate = getFirstDayByMonth(year,period);
			
		}else if("2".equals(frequency) || "period".equals(frequency)){
			//季度
			firstDate = getFirstDayByQuarter(year,period - 12);
		}else if("3".equals(frequency) || "halfYear".equals(frequency)){
			//半年
			if(period == 17){
				firstDate = getFirstDayByMonth(year,1);
			}else if(period == 18){
				firstDate = getFirstDayByMonth(year,7);
			}
		}else if("4".equals(frequency) || "year".equals(frequency)){
			//年
			firstDate = getFirstDayByYear(year);
		}
		return firstDate;
	}
	
	/**
	 * 根据参数获取某一年某一频率某一周期值的结束时间
	 * @param year 年度
	 * @param frequency 频率
	 * @param period 周期值
	 * @return 日期
	 * @return
	 */
	public Date getLastDayByCondition(int year,String frequency,int period){
		Date lastDate = null;
		//月份
		if("1".equals(frequency) || "month".equals(frequency)){
			lastDate = getLastDayByMonth(year,period);
			
		}else if("2".equals(frequency) || "period".equals(frequency)){
			//季度
			lastDate = getLastDayByQuarter(year,period - 12);
		}else if("3".equals(frequency) || "halfYear".equals(frequency)){
			//半年
			if(period == 17){
				lastDate = getLastDayByMonth(year,6);
			}else if(period == 18){
				lastDate = getLastDayByMonth(year,12);
			}
		}else if("4".equals(frequency) || "year".equals(frequency)){
			//年
			lastDate = getLastDayByYear(year);
		}
		return lastDate;
	}
	
	public static Date getEndDate(Date dateEnd){
		Calendar calendar=Calendar.getInstance();
		calendar.clear();
		calendar.setTime(dateEnd);
		calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+1);//让日期加1
		return calendar.getTime();
	}

	
	
	
	public static void main(String[] args) {
		/*********************************** 测试 *********************************/
		
		SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd");
		/**
		System.out.println(fomat.format(DatePeriodUtil.getInstance().getFirstDayOfYear(0)));
		System.out.println(fomat.format(DatePeriodUtil.getInstance().getFirstDayOfMonth(0)));
		System.out.println(DatePeriodUtil.getInstance().getCurrentQuarter());*/
		
		System.out.println(fomat.format(DatePeriodUtil.getInstance().getFirstDayByQuarter(2012,3)));
		System.out.println(fomat.format(DatePeriodUtil.getInstance().getLastDayByQuarter(2012,3)));
		System.out.println(fomat.format(DatePeriodUtil.getInstance().getFirstDayByMonth(2015,12)));
		System.out.println(fomat.format(DatePeriodUtil.getInstance().getLastDayByMonth(2015,12)));
		System.out.println(fomat.format(DatePeriodUtil.getInstance().getFirstDayByYear(2011)));
		System.out.println(fomat.format(DatePeriodUtil.getInstance().getLastDayByYear(2011)));
		System.out.println(fomat.format(DatePeriodUtil.getInstance().getFirstDayByCondition(2013, "2", 16)));
	
		
	}

}
