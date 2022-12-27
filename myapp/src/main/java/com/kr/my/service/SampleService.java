package com.kr.my.service;

import java.util.List;

import com.kr.my.dto.SampleDTO;

public interface SampleService {
	public List<SampleDTO> sampleList() throws Exception;
	public SampleDTO getSample(String id) throws Exception;
	
	
}
