package com.starboard.b2b.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
				files.add(f);
			}
		}
		

		return files;
	}
}
