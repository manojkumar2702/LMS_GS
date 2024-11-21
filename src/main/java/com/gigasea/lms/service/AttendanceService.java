package com.gigasea.lms.service;

import com.gigasea.lms.model.Attendance;
import java.util.List;

public interface AttendanceService {
    void saveAttendance(Attendance attendance);
    List<Attendance> findAttendances();
    Attendance getAttendanceId(Long id);
    void deleteAttendance(Long id);
    void deleteAllAttendances(); // New method
}