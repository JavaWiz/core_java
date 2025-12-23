package com.javawiz.model;

import lombok.Builder;

@Builder
public record Department (int deptId, DeptName deptName) {}

