package com.kr.my.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kr.my.dto.SampleDTO;
import com.kr.my.model.SampleDAO;

@Service
public class SampleServiceImpl implements SampleService {
	@Autowired
	SampleDAO sample;

	@Override
	public List<SampleDTO> sampleList() throws Exception {
		return sample.sampleList();
	}

	@Override
	public SampleDTO getSample(String id) throws Exception {
		return sample.getSample(id);
	}

	

	

	



}