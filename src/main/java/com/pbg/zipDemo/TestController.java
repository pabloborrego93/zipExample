package com.pbg.zipDemo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	private ZipService zipService;
	
	public TestController(ZipService zipService) {
		this.zipService = zipService;
	}

	@GetMapping(value = "/zip", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<InputStreamResource> toZip() throws IOException {
		Map<String, byte[]> imagesMap = zipService.initializeMap();
		ByteArrayOutputStream out = zipService.filesWithNamesToZippedByteArrayOutputStream(imagesMap);
		InputStreamResource input = zipService.byteArrayOutputStreamToInputStreamResource(out);
		
	    String zipName = String.format("attachment; filename=%s", "myZip.zip");
	    
		return ResponseEntity
			.ok()
			.header(HttpHeaders.CONTENT_DISPOSITION, zipName)
			.body(input);
	}
	
}
