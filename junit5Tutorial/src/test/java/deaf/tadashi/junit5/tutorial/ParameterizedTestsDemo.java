package deaf.tadashi.junit5.tutorial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.JavaTimeConversionPattern;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ParameterizedTestsDemo {

	@ParameterizedTest
	@ValueSource(strings = { "Hello", "World" })
	void testWithStringParameter(String argument) {
	    assertNotNull(argument);
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3 })
	void testWithValueSource(int argument) {
	    assertNotNull(argument);
	}
	
	@ParameterizedTest
	@EnumSource(TimeUnit.class)
	void testWithEnumSource(TimeUnit timeUnit) {
	    assertNotNull(timeUnit);
	}
	
	@ParameterizedTest
	@EnumSource(value = TimeUnit.class, names = { "DAYS", "HOURS" })
	void testWithEnumSourceInclude(TimeUnit timeUnit) {
	    assertTrue(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
	}
	
//	@ParameterizedTest
//	@EnumSource(value = TimeUnit.class, mode = EXCLUDE, names = { "DAYS", "HOURS" })
//	void testWithEnumSourceExclude(TimeUnit timeUnit) {
//	    assertFalse(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
//	    assertTrue(timeUnit.name().length() > 5);
//	}
//	
//	@ParameterizedTest
//	@EnumSource(value = TimeUnit.class, mode = MATCH_ALL, names = "^(M|N).+SECONDS$")
//	void testWithEnumSourceRegex(TimeUnit timeUnit) {
//	    String name = timeUnit.name();
//	    assertTrue(name.startsWith("M") || name.startsWith("N"));
//	    assertTrue(name.endsWith("SECONDS"));
//	}
	
	@ParameterizedTest
	@MethodSource("stringProvider")
	void testWithSimpleMethodSource(String argument) {
	    assertNotNull(argument);
	}

	static Stream<String> stringProvider() {
	    return Stream.of("foo", "bar");
	}
	
	@ParameterizedTest
	@MethodSource("range")
	void testWithRangeMethodSource(int argument) {
	    assertNotEquals(9, argument);
	}

	static IntStream range() {
	    return IntStream.range(0, 20).skip(10);
	}
	
	@ParameterizedTest
	@MethodSource("stringAndIntProvider")
	void testWithMultiArgMethodSource(String first, int second) {
	    assertNotNull(first);
	    assertNotEquals(0, second);
	}

	static Stream<Arguments> stringAndIntProvider() {
	    return Stream.of(Arguments.of("foo", 1), Arguments.of("bar", 2));
	}
	
	@ParameterizedTest
	@CsvSource({ "foo, 1", "bar, 2", "'baz, qux', 3" })
	void testWithCsvSource(String first, int second) {
	    assertNotNull(first);
	    assertNotEquals(0, second);
	}
	
	@ParameterizedTest
	@ArgumentsSource(MyArgumentsProvider.class)
	void testWithArgumentsSource(String argument) {
	    assertNotNull(argument);
	}

	static class MyArgumentsProvider implements ArgumentsProvider {

	    @Override
	    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
	        return Stream.of("foo", "bar").map(Arguments::of);
	    }
	}
	
	@ParameterizedTest
	@ValueSource(strings = "SECONDS")
	void testWithImplicitArgumentConversion(TimeUnit argument) {
	    assertNotNull(argument.name());
	}
	
	@ParameterizedTest
	@ValueSource(strings = "1.0")
	void testWithImplicitArgumentConversion1(double argument) {
		assertEquals(1.0d, argument);
	}	

	@ParameterizedTest
	@EnumSource(TimeUnit.class)
	void testWithExplicitArgumentConversion(@ConvertWith(ToStringArgumentConverter.class) String argument) {
	    assertNotNull(TimeUnit.valueOf(argument));
	}

	static class ToStringArgumentConverter extends SimpleArgumentConverter {

	    @Override
	    protected Object convert(Object source, Class<?> targetType) {
	        assertEquals(String.class, targetType, "Can only convert to String");
	        return String.valueOf(source);
	    }
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "01.01.2017", "31.12.2017" })
	void testWithExplicitJavaTimeConverter(@JavaTimeConversionPattern("dd.MM.yyyy") LocalDate argument) {
	    assertEquals(2017, argument.getYear());
	}
	
	@DisplayName("Display name of container")
	@ParameterizedTest(name = "{index} ==> first=''{0}'', second={1}")
	@CsvSource({ "foo, 1", "bar, 2", "'baz, qux', 3" })
	void testWithCustomDisplayNames(String first, int second) {
	}
	
	@BeforeEach
	void beforeEach(TestInfo testInfo) {
	    // ...
	}

	@ParameterizedTest
	@ValueSource(strings = "foo")
	void testWithRegularParameterResolver(String argument, TestReporter testReporter) {
	    testReporter.publishEntry("argument", argument);
	}

	@AfterEach
	void afterEach(TestInfo testInfo) {
	    // ...
	}
	
}
