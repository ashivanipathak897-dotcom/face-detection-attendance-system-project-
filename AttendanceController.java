package com.faceattendance.app.controller;

import com.faceattendance.app.service.FaceRecognitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private FaceRecognitionService faceRecognitionService;

    @PostMapping("/mark")
    public ResponseEntity<?> markAttendance(@RequestBody byte[] capturedImage) {
        // In a real app, convert byte[] to OpenCV Mat object
        boolean recognized = faceRecognitionService.recognizeFace(capturedImage);
        
        if (recognized) {
            // Save attendance record to DB
            return ResponseEntity.ok("Attendance marked successfully");
        } else {
            return ResponseEntity.status(401).body("Face not recognized");
        }
    }
}
