package com.controller;

import com.common.JoyResult;

public interface DynamicDetialsController {

public	JoyResult getDynamicAuthor(int authorId);
public  JoyResult getComment(int dynamicId);
public  JoyResult RelevantRecom(String kind);
}
