package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
*Test.
*
* @autor GoToHero (mailto:go2heromad@gmail.com)
* @version $Id$
* @since 1.0
*/

public class CalculateTest {
/**
* Test echo.
*/
@Test
	public void whenTakeNameThenTreeEchoPlusName() {
		String input = "GoToHero";
		String expect = "Echo, echo, echo : GoToHero";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}