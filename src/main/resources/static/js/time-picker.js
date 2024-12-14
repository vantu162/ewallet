$(document ).ready(function() {
    const currentDate = new Date();
    currentDate.setDate(currentDate.getDate() - 1);  // Trừ 1 ngày
    currentDate.setHours(24, 0, 0);

    flatpickr("#timePickerFrom", {
        enableTime: true,
        noCalendar: true,
        dateFormat: "H:i", // Display format in 24-hour or use "h:i " for 12-hour with AM/PM
        defaultDate: "00:00",
        time_24hr: true    // Optional, set to true for 24-hour time format
    });

    flatpickr("#timePickerTo", {
        enableTime: true,
        noCalendar: true,
        dateFormat: "H:i", // Display format in 24-hour or use "h:i K" for 12-hour with AM/PM
        defaultDate: "23:59",
        time_24hr: true    // Optional, set to true for 24-hour time format
    });
});