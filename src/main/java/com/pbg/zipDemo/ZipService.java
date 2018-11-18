package com.pbg.zipDemo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

import org.springframework.core.io.InputStreamResource;

public interface ZipService {

	public Map<String, byte[]> initializeMap();
	public ByteArrayOutputStream filesWithNamesToZippedByteArrayOutputStream(Map<String, byte[]> imagesMap) throws IOException;
	public InputStreamResource byteArrayOutputStreamToInputStreamResource(ByteArrayOutputStream out);
	
}
