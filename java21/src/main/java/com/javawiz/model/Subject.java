package com.javawiz.model;


import lombok.Builder;

@Builder
public record Subject (
    String subjectName,
    int totalMark
) {}