$(document ).ready(function() {
    const currentDate = new Date();
    currentDate.setDate(currentDate.getDate() - 1);  // Trừ 1 ngày
    currentDate.setHours(24, 0, 0);

    const currentDatePM = new Date();
    currentDatePM.setDate(currentDatePM.getDate());
    currentDatePM.setHours(23, 59, 59);

    flatpickr("#datepickerFrom", {
        locale: {
            weekdays: {
                shorthand: ['CN', 'T2', 'T3', 'T4', 'T5', 'T6', 'T7'],
                longhand: ['Chủ Nhật', 'Thứ Hai', 'Thứ Ba', 'Thứ Tư', 'Thứ Năm', 'Thứ Sáu', 'Thứ Bảy'],
            },
            months: {
                shorthand: ['Th1', 'Th2', 'Th3', 'Th4', 'Th5', 'Th6', 'Th7', 'Th8', 'Th9', 'Th10', 'Th11', 'Th12'],
                longhand: ['Tháng Một', 'Tháng Hai', 'Tháng Ba', 'Tháng Tư', 'Tháng Năm', 'Tháng Sáu', 'Tháng Bảy', 'Tháng Tám', 'Tháng Chín', 'Tháng Mười', 'Tháng Mười Một', 'Tháng Mười Hai'],
            },
            firstDayOfWeek: 1, // Monday is the first day of the week
            rangeSeparator: ' đến ',
            weekAbbreviation: 'Tuần',
            scrollTitle: 'Cuộn để tăng',
            toggleTitle: 'Nhấn để chuyển đổi',
        },
        time_24hr: true,
        noCalendar:false,
        minuteIncrement: 1,
        enableSeconds: true,
        enableTime: true,
        dateFormat: "d/m/Y H:i:S",
        // maxDate: "today",
        defaultDate: currentDate,  // Thiết lập ngày giờ cụ thể (tháng bắt đầu từ 0)

    });

    flatpickr("#datepickerTo", {
        locale: {
            weekdays: {
                shorthand: ['CN', 'T2', 'T3', 'T4', 'T5', 'T6', 'T7'],
                longhand: ['Chủ Nhật', 'Thứ Hai', 'Thứ Ba', 'Thứ Tư', 'Thứ Năm', 'Thứ Sáu', 'Thứ Bảy'],
            },
            months: {
                shorthand: ['Th1', 'Th2', 'Th3', 'Th4', 'Th5', 'Th6', 'Th7', 'Th8', 'Th9', 'Th10', 'Th11', 'Th12'],
                longhand: ['Tháng Một', 'Tháng Hai', 'Tháng Ba', 'Tháng Tư', 'Tháng Năm', 'Tháng Sáu', 'Tháng Bảy', 'Tháng Tám', 'Tháng Chín', 'Tháng Mười', 'Tháng Mười Một', 'Tháng Mười Hai'],
            },
            firstDayOfWeek: 1, // Monday is the first day of the week
            rangeSeparator: ' đến ',
            weekAbbreviation: 'Tuần',
            scrollTitle: 'Cuộn để tăng',
            toggleTitle: 'Nhấn để chuyển đổi',
        },
        time_24hr: true,
        noCalendar:false,
        minuteIncrement: 1,
        enableSeconds: true,
        enableTime: true,
        dateFormat: "d/m/Y H:i:S",
        defaultDate: currentDatePM,
    });

    flatpickr("#datepickerFrom_phi", {
        locale: {
            weekdays: {
                shorthand: ['CN', 'T2', 'T3', 'T4', 'T5', 'T6', 'T7'],
                longhand: ['Chủ Nhật', 'Thứ Hai', 'Thứ Ba', 'Thứ Tư', 'Thứ Năm', 'Thứ Sáu', 'Thứ Bảy'],
            },
            months: {
                shorthand: ['Th1', 'Th2', 'Th3', 'Th4', 'Th5', 'Th6', 'Th7', 'Th8', 'Th9', 'Th10', 'Th11', 'Th12'],
                longhand: ['Tháng Một', 'Tháng Hai', 'Tháng Ba', 'Tháng Tư', 'Tháng Năm', 'Tháng Sáu', 'Tháng Bảy', 'Tháng Tám', 'Tháng Chín', 'Tháng Mười', 'Tháng Mười Một', 'Tháng Mười Hai'],
            },
            firstDayOfWeek: 1, // Monday is the first day of the week
            rangeSeparator: ' đến ',
            weekAbbreviation: 'Tuần',
            scrollTitle: 'Cuộn để tăng',
            toggleTitle: 'Nhấn để chuyển đổi',
        },
        time_24hr: true,
        noCalendar:false,
        minuteIncrement: 1,
        enableSeconds: true,
        enableTime: true,
        dateFormat: "d/m/Y H:i:S",
        defaultDate: currentDate,  // Thiết lập ngày giờ cụ thể (tháng bắt đầu từ 0)

    });

    flatpickr("#datepickerTo_phi", {
        locale: {
            weekdays: {
                shorthand: ['CN', 'T2', 'T3', 'T4', 'T5', 'T6', 'T7'],
                longhand: ['Chủ Nhật', 'Thứ Hai', 'Thứ Ba', 'Thứ Tư', 'Thứ Năm', 'Thứ Sáu', 'Thứ Bảy'],
            },
            months: {
                shorthand: ['Th1', 'Th2', 'Th3', 'Th4', 'Th5', 'Th6', 'Th7', 'Th8', 'Th9', 'Th10', 'Th11', 'Th12'],
                longhand: ['Tháng Một', 'Tháng Hai', 'Tháng Ba', 'Tháng Tư', 'Tháng Năm', 'Tháng Sáu', 'Tháng Bảy', 'Tháng Tám', 'Tháng Chín', 'Tháng Mười', 'Tháng Mười Một', 'Tháng Mười Hai'],
            },
            firstDayOfWeek: 1, // Monday is the first day of the week
            rangeSeparator: ' đến ',
            weekAbbreviation: 'Tuần',
            scrollTitle: 'Cuộn để tăng',
            toggleTitle: 'Nhấn để chuyển đổi',
        },
        time_24hr: true,
        noCalendar:false,
        minuteIncrement: 1,
        enableSeconds: true,
        enableTime: true,
        dateFormat: "d/m/Y H:i:S",
        defaultDate: currentDatePM,
    });

    flatpickr("#datepickerFrom_donvi", {
        locale: {
            weekdays: {
                shorthand: ['CN', 'T2', 'T3', 'T4', 'T5', 'T6', 'T7'],
                longhand: ['Chủ Nhật', 'Thứ Hai', 'Thứ Ba', 'Thứ Tư', 'Thứ Năm', 'Thứ Sáu', 'Thứ Bảy'],
            },
            months: {
                shorthand: ['Th1', 'Th2', 'Th3', 'Th4', 'Th5', 'Th6', 'Th7', 'Th8', 'Th9', 'Th10', 'Th11', 'Th12'],
                longhand: ['Tháng Một', 'Tháng Hai', 'Tháng Ba', 'Tháng Tư', 'Tháng Năm', 'Tháng Sáu', 'Tháng Bảy', 'Tháng Tám', 'Tháng Chín', 'Tháng Mười', 'Tháng Mười Một', 'Tháng Mười Hai'],
            },
            firstDayOfWeek: 1, // Monday is the first day of the week
            rangeSeparator: ' đến ',
            weekAbbreviation: 'Tuần',
            scrollTitle: 'Cuộn để tăng',
            toggleTitle: 'Nhấn để chuyển đổi',
        },
        time_24hr: true,
        noCalendar:false,
        minuteIncrement: 1,
        enableSeconds: true,
        enableTime: true,
        dateFormat: "d/m/Y H:i:S",
        defaultDate: currentDate,  // Thiết lập ngày giờ cụ thể (tháng bắt đầu từ 0)

    });

    flatpickr("#datepickerTo_donvi", {
        locale: {
            weekdays: {
                shorthand: ['CN', 'T2', 'T3', 'T4', 'T5', 'T6', 'T7'],
                longhand: ['Chủ Nhật', 'Thứ Hai', 'Thứ Ba', 'Thứ Tư', 'Thứ Năm', 'Thứ Sáu', 'Thứ Bảy'],
            },
            months: {
                shorthand: ['Th1', 'Th2', 'Th3', 'Th4', 'Th5', 'Th6', 'Th7', 'Th8', 'Th9', 'Th10', 'Th11', 'Th12'],
                longhand: ['Tháng Một', 'Tháng Hai', 'Tháng Ba', 'Tháng Tư', 'Tháng Năm', 'Tháng Sáu', 'Tháng Bảy', 'Tháng Tám', 'Tháng Chín', 'Tháng Mười', 'Tháng Mười Một', 'Tháng Mười Hai'],
            },
            firstDayOfWeek: 1, // Monday is the first day of the week
            rangeSeparator: ' đến ',
            weekAbbreviation: 'Tuần',
            scrollTitle: 'Cuộn để tăng',
            toggleTitle: 'Nhấn để chuyển đổi',
        },
        time_24hr: true,
        noCalendar:false,
        minuteIncrement: 1,
        enableSeconds: true,
        enableTime: true,
        dateFormat: "d/m/Y H:i:S",
        defaultDate: currentDatePM,
    });

    flatpickr("#datepicker", {
        locale: {
            weekdays: {
                shorthand: ['CN', 'T2', 'T3', 'T4', 'T5', 'T6', 'T7'],
                longhand: ['Chủ Nhật', 'Thứ Hai', 'Thứ Ba', 'Thứ Tư', 'Thứ Năm', 'Thứ Sáu', 'Thứ Bảy'],
            },
            months: {
                shorthand: ['Th1', 'Th2', 'Th3', 'Th4', 'Th5', 'Th6', 'Th7', 'Th8', 'Th9', 'Th10', 'Th11', 'Th12'],
                longhand: ['Tháng Một', 'Tháng Hai', 'Tháng Ba', 'Tháng Tư', 'Tháng Năm', 'Tháng Sáu', 'Tháng Bảy', 'Tháng Tám', 'Tháng Chín', 'Tháng Mười', 'Tháng Mười Một', 'Tháng Mười Hai'],
            },
            firstDayOfWeek: 1, // Monday is the first day of the week
            rangeSeparator: ' đến ',
            weekAbbreviation: 'Tuần',
            scrollTitle: 'Cuộn để tăng',
            toggleTitle: 'Nhấn để chuyển đổi',
        },
        time_24hr: true,
        noCalendar:false,
        minuteIncrement: 1,
        enableSeconds: true,
        enableTime: true,
        dateFormat: "d/m/Y",
        defaultDate: new Date(),
    });

});