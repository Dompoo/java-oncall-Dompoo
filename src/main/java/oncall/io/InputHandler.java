package oncall.io;

import oncall.common.dto.MonthAndDayOfWeek;
import oncall.io.reader.Reader;
import oncall.io.writer.Writer;

public class InputHandler {
	
	private final Reader reader;
	private final Writer writer;
	private final InputValidator inputValidator;
	private final InputParser inputParser;
	
	public InputHandler(Reader reader, Writer writer, InputValidator inputValidator, InputParser inputParser) {
		this.reader = reader;
		this.writer = writer;
		this.inputValidator = inputValidator;
		this.inputParser = inputParser;
	}
	
	public MonthAndDayOfWeek readMonthAndDayOfWeek() {
		writer.write("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
		String input = reader.readLine();
		inputValidator.validateMonthAndDayOfWeek(input);
		return inputParser.parseMonthAndDayOfWeek(input);
	}
}
