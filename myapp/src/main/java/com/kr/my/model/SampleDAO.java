package com.kr.my.model;

import java.util.List;

import com.kr.my.dto.SampleDTO;

public interface SampleDAO {
	public List<SampleDTO> sampleList() throws Exception;
	public SampleDTO getSample(String id) throws Exception;

}