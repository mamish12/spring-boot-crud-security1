package com.excellence.springbootcrudapisecurity.service;

import org.springframework.web.multipart.MultipartFile;

public interface UserBatchFileService {

	boolean hasCsvFormat(MultipartFile file);

	void processAndSaveData(MultipartFile file);

}
