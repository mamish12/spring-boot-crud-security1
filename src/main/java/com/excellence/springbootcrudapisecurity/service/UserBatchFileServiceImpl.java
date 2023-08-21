package com.excellence.springbootcrudapisecurity.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.excellence.springbootcrudapisecurity.models.UserBatch;
import com.excellence.springbootcrudapisecurity.repository.UserBatchRepository;






@Service
public class UserBatchFileServiceImpl implements UserBatchFileService{
	
	@Autowired
	private UserBatchRepository repository;

	@Override
	public boolean hasCsvFormat(MultipartFile file) {
		// TODO Auto-generated method stub
		String type="text/csv";
		if(!type.equals(file.getContentType()))
		{
			return false;
		}
		return true;
	}

	@Override
	public void processAndSaveData(MultipartFile file) {
		try {
			List<UserBatch> users=CsvToUsers(file.getInputStream());
			repository.saveAll(users);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private List<UserBatch> CsvToUsers(InputStream inputStream) {
		try(BufferedReader fileReader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
				CSVParser csvParser=new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withTrim());
				){
			List<UserBatch> users=new ArrayList<UserBatch>();
			
			List<CSVRecord> records=csvParser.getRecords();
			for(CSVRecord csvRecord:records)
			{
				UserBatch user=new UserBatch(Long.parseLong(csvRecord.get("id")),csvRecord.get("first_name"),csvRecord.get("last_name"),csvRecord.get("email"),csvRecord.get("gender"));
				users.add(user);
			}
			return users;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}

}
