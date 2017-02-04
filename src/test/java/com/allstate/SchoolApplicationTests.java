package com.allstate;

import com.allstate.services.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(Suite.class)
@SpringBootTest
@Suite.SuiteClasses({
		StudentServiceTest.class,
		KlassServiceTest.class,
		TeacherServiceTest.class,
		LearningServiceTest.class
})
public class SchoolApplicationTests {
	@Test
	public void contextLoads() {
	}
}
