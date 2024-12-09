package oncall.domain;

import oncall.common.exception.CustomExceptions;
import oncall.common.dto.OncallDayPlan;
import oncall.common.dto.OncallPlanResult;
import oncall.domain.vo.CalendarDay;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OncallPlanner {
	
	private final OncallCalendar oncallCalendar;
	private final EmergencyWorkers weekdayEmergencyWorkers;
	private final EmergencyWorkers holidayEmergencyWorkers;
	
	public OncallPlanner(OncallCalendar oncallCalendar, EmergencyWorkers weekdayEmergencyWorkers, EmergencyWorkers holidayEmergencyWorkers) {
		Objects.requireNonNull(oncallCalendar);
		Objects.requireNonNull(weekdayEmergencyWorkers);
		Objects.requireNonNull(holidayEmergencyWorkers);
		validate(weekdayEmergencyWorkers, holidayEmergencyWorkers);
		this.oncallCalendar = oncallCalendar;
		this.weekdayEmergencyWorkers = weekdayEmergencyWorkers;
		this.holidayEmergencyWorkers = holidayEmergencyWorkers;
	}
	
	private void validate(EmergencyWorkers weekdayEmergencyWorkers, EmergencyWorkers holidayEmergencyWorkers) {
		if (!weekdayEmergencyWorkers.hasSameWorkers(holidayEmergencyWorkers)) {
			throw CustomExceptions.ILLEGAL_ARGUMENT.get();
		}
	}
	
	public OncallPlanResult plan() {
		//TODO : 연속 근무시 순서 변경 로직 작성 필요
		List<OncallDayPlan> oncallDayPlans = new ArrayList<>();
		int weekdayIndex = 0;
		int holidayIndex = 0;
		for (CalendarDay calendarDay : oncallCalendar.getCalendarDays()) {
			if (calendarDay.isWeekDay() && !calendarDay.isLegalHoliday()) {
				oncallDayPlans.add(new OncallDayPlan(calendarDay, weekdayEmergencyWorkers.getNameOf(weekdayIndex++)));
				continue;
			}
			oncallDayPlans.add(new OncallDayPlan(calendarDay, holidayEmergencyWorkers.getNameOf(holidayIndex++)));
		}
		return new OncallPlanResult(oncallCalendar.getMonthValue(), oncallDayPlans);
	}
}
