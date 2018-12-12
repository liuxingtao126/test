package com.mocha.work.testWorkAssertJ;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
/*
  添加错误提示信息： as
  assertThat("abc").as("校验abc").isEqualTo("abcd");
   错误提示：
	org.junit.ComparisonFailure: [校验abc] expected:<"abc[d]"> but was:<"abc[]"
	http://joel-costigliola.github.io/assertj/index.html
 */
public class testWorkAssertJ {
	@Test
    public void testPersonInfo() {
        // 准备数据
        final Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(1998, Calendar.JULY, 13);
        
        final Date date = calendar.getTime();
 
        // 获取对象
        final PersonInfo ka = new PersonInfo("KaKa", 21, date);
       
        // 断言
        assertThat(ka).isNotNull().isInstanceOf(PersonInfo.class);// Object/Class
        
        assertThat(ka.getName()).startsWith("K").contains("a").isEqualTo("KaKa");// String
        assertThat(ka.getAge()).isPositive().isGreaterThan(20).isGreaterThanOrEqualTo(21);// int  isGreaterThan
        assertThat(ka.getBirthDate()).isBeforeYear(2000).isInSameMonthAs("1998-07-01").isInSameDayAs(date);// java.util.Date
	}
}
