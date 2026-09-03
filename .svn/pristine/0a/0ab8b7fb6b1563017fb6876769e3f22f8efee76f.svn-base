package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Form1AphirScheduleTest {

	@Test
	public void testDefaultConstructorAndGetterSetter() {

		Form1AphirSchedule schedule = new Form1AphirSchedule();

		schedule.setId(1L);
		schedule.setSubject("Mathematics");
		schedule.setMp1("A");
		schedule.setMp2("A-");
		schedule.setMp3("B+");
		schedule.setMp4("A+");
		schedule.setIndicator("Excellent");
		schedule.setScheduleType("REGULAR");

		assertEquals(Long.valueOf(1L), schedule.getId());
		assertEquals("Mathematics", schedule.getSubject());
		assertEquals("A", schedule.getMp1());
		assertEquals("A-", schedule.getMp2());
		assertEquals("B+", schedule.getMp3());
		assertEquals("A+", schedule.getMp4());
		assertEquals("Excellent", schedule.getIndicator());
		assertEquals("REGULAR", schedule.getScheduleType());
	}

	@Test
	public void testParameterizedConstructor() {

		Form1AphirSchedule schedule = new Form1AphirSchedule(1L, "Mathematics", "A", "A-", "B+", "A+", "Excellent",
				"REGULAR");

		assertEquals(Long.valueOf(1L), schedule.getId());
		assertEquals("Mathematics", schedule.getSubject());
		assertEquals("A", schedule.getMp1());
		assertEquals("A-", schedule.getMp2());
		assertEquals("B+", schedule.getMp3());
		assertEquals("A+", schedule.getMp4());
		assertEquals("Excellent", schedule.getIndicator());
		assertEquals("REGULAR", schedule.getScheduleType());
	}

	@Test
	void testToString() {
		Form1AphirSchedule schedule = new Form1AphirSchedule(1L, "Mathematics", "A", "A-", "B+", "A+", "Excellent",
				"REGULAR");

		String result = schedule.toString();

		assertEquals("Form1AphirSchedule [id=1, subject=Mathematics, mp1=A, mp2=A-, "
				+ "mp3=B+, mp4=A+, indicator=Excellent, scheduleType=REGULAR]", result);
	}
}
