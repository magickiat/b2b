package com.starboard.b2b.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.starboard.b2b.dto.B2BFile;

public class B2BFileUtil {

	private static final Logger log = LoggerFactory.getLogger(B2BFileUtil.class);

	public static List<B2BFile> list(String rootFolder, String path) {
		log.info("root: " + rootFolder);
		log.info("path: " + path);

		ArrayList<B2BFile> files = new ArrayList<>();

		File folder = new File(rootFolder);
		if (StringUtils.isNotEmpty(path)) {
			folder = new File(rootFolder, path);
		}
		if (folder.isFile()) {
			return files;
		}

		File[] listFiles = folder.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				if(name.equalsIgnoreCase(".DS_Store") || name.contains(".db")){
					return false;
				}
				return true;
			}
		});
		if(listFiles != null && listFiles.length > 0){
			for (File file : listFiles) {
				B2BFile f = new B2BFile();
				f.setName(file.getName());
				f.setNameWithPath(file.getAbsolutePath().substring(rootFolder.length()));
				f.setFullPath(file.getAbsolutePath());
				f.setFolder(file.isDirectory());
//				f.setContentType(contentType); // Find content type before set
				files.add(f);
			}
		}
		

		return files;
	}

	public static boolean isImage(String contentType) {
		return contentType.startsWith("image/");
	}

	public static void saveFileToLocalDisk(String root, String folder, MultipartFile uploadFile) throws IOException {
		File parent = new File(root, folder);
		if(parent.exists() && parent.isDirectory()){
			File dest = new File(parent.getAbsolutePath(), uploadFile.getOriginalFilename());
			FileUtils.writeByteArrayToFile(dest, uploadFile.getBytes(), false);
		}else{
			throw new FileNotFoundException("Parent folder not found: " + folder);
		}
	}
	
	public static int delete(String root, String[] files){
		int deleted = 0;
		
		if(files != null && files.length > 0){
			for (String filename : files) {
				File file = new File(root, filename);
				if(file.exists() && file.delete()){
					deleted++;
				}
			}
		}
		
		return deleted;
	}
	
}
