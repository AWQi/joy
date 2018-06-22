package com.service;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.pojo.Dynamic;

public interface CommendDynamicsService {

List<Dynamic> CommendDynamics(int page, int row);
}
