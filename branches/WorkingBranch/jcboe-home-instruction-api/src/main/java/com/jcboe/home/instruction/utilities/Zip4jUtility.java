/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.jcboe.home.instruction.response.HIFormTransactionResp;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;

@Component
public class Zip4jUtility {

	private final Logger logger = LogManager.getLogger(Zip4jUtility.class);

	public Zip4jUtility() {
		// default constructor
	}

	/**
	 * 
	 * AES_STRENGTH_128 - For both encryption and decryption<br>
	 * AES_STRENGTH_192 - For decryption only<br>
	 * AES_STRENGTH_256 - For both encryption and decryption<br>
	 * <br>
	 * AES_STRENGTH_192 cannot be used for encryption. But if a zip file already has
	 * a file encrypted with key strength of 192, then Zip4j can decrypt this file
	 * 
	 * @return Object of java.io.File
	 * 
	 */
	public File compressWithPassword(File doc, String zipEncryptionPass, String tempFilePath) throws Exception {// NOSONAR

		ZipParameters zipParams = new ZipParameters();
		zipParams.setCompressionMethod(CompressionMethod.DEFLATE);
		zipParams.setCompressionLevel(CompressionLevel.FASTEST);
		zipParams.setEncryptFiles(true);
		zipParams.setEncryptionMethod(EncryptionMethod.AES);

		File finalZipFile = null;

		zipParams.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_256);

		try (ZipFile zipFile = new ZipFile(
				new File(tempFilePath + File.separator + FilenameUtils.removeExtension(doc.getName()) + ".zip"),
				zipEncryptionPass.toCharArray())) {

			if (FilenameUtils.getExtension(doc.getName()).equalsIgnoreCase("zip")) {

				File subFile = new File(tempFilePath + "/XXXX/" + doc.getName());
				createDirIfNotExists(subFile.getParentFile());
				FileUtils.moveFileToDirectory(doc, subFile.getParentFile(), true);
				zipFile.addFile(subFile, zipParams);

				try {
					if (subFile.getParentFile().exists()) {
						permitFile(subFile.getParentFile());
						FileUtils.forceDelete(subFile.getParentFile());
					}
				} catch (Exception e) {
					logger.error("Error while deletion of file:{} ", e.getMessage());
				}

			} else {
				zipFile.addFile(doc, zipParams);
			}

			finalZipFile = zipFile.getFile();

			return finalZipFile;
		} catch (Exception e) {
			logger.error("Error while zipping file:{}", e.getMessage());
			throw new Exception();
		}

	}

	public File decompressWithPassword(File doc, String fileOriginalnameInsideZip, String renamedFileName,
			String originalExtension, String zipEncryptionPass, String temporaryPath) throws Exception {// NOSONAR

		try (ZipFile zipFile = new ZipFile(doc, zipEncryptionPass.toCharArray())) {

			File extractedFile = new File(temporaryPath + File.separator + fileOriginalnameInsideZip);
			/**
			 * perviously it was File renamedFile = new File( temporaryPath + "/" +
			 * StringUtils.replace(renamedFileName, originalExtension, "") +"."+
			 * originalExtension);
			 */

			File renamedFile = new File(temporaryPath + File.separator + renamedFileName);
			if (FilenameUtils.getExtension(fileOriginalnameInsideZip).equalsIgnoreCase("zip")) {

				File subFolder = new File(temporaryPath + "/XXXXXX/");
				createDirIfNotExists(subFolder);
				zipFile.extractFile(fileOriginalnameInsideZip, subFolder.getAbsolutePath());

				try {
					permitFile(zipFile.getFile());
					FileUtils.forceDelete(zipFile.getFile());
				} catch (Exception e) {// NOSONAR
					e.printStackTrace(); // NOSONAR
				}

				FileUtils.moveFileToDirectory(
						new File(subFolder.getAbsolutePath() + File.separator + fileOriginalnameInsideZip),
						new File(temporaryPath), true);

				try {
					permitFile(subFolder);
					FileUtils.forceDelete(subFolder);
				} catch (Exception e) {// NOSONAR
					logger.error("Error while deletion of file:{} ", e.getMessage());
				}

			} else {

				zipFile.extractFile(fileOriginalnameInsideZip, temporaryPath);

			}

			extractedFile.renameTo(renamedFile);// NOSONAR

			return renamedFile;

		} catch (Exception e) {
			logger.error("Error while unzipping file:{} original file extension{}", e.getMessage(), originalExtension);
			throw new Exception(e.getMessage());// NOSONAR
		}

	}

	public File zipMultipleFiles(List<HIFormTransactionResp> downloadableFiles, String tempFilePath, String fileName,
			String subfolder) throws IOException {

		File tempDir = new File(tempFilePath);
		createDirIfNotExists(tempDir);
		permitFile(tempDir);
		File zipFile = new File(tempDir, fileName);

		try (FileOutputStream fos = new FileOutputStream(zipFile); ZipOutputStream zos = new ZipOutputStream(fos)) {

			for (HIFormTransactionResp file : downloadableFiles) {

				if (!file.getDownloadedFile().exists() || file.getDownloadedFile().isDirectory()) {
					continue;
				}
				String zipEntryName = subfolder + File.separator
						+ FilenameUtils.getName(file.getDownloadedFile().getAbsolutePath());

				ZipEntry zipEntry = new ZipEntry(zipEntryName);

				zos.putNextEntry(zipEntry);

				FileUtils.copyFile(file.getDownloadedFile(), zos);

				FileUtils.forceDelete(file.getDownloadedFile());

				zos.closeEntry();

			}
		}

		return zipFile;
	}

	public void createDirIfNotExists(File dir) {

		if (!dir.exists()) {
			dir.mkdirs();
			dir.setReadable(true, false);// NOSONAR
			dir.setWritable(true, false);// NOSONAR
			dir.setExecutable(true, false);// NOSONAR
		}

	}

	public void permitFile(File file) {

		if (file.exists()) {
			file.setReadable(true, false);// NOSONAR
			file.setWritable(true, false);// NOSONAR
			file.setExecutable(true, false);// NOSONAR
		}

	}

	public File docZipMultipleFiles(List<File> files, String tempFilePath, String fileName, String subfolder)
			throws Exception {

		File tempDir = new File(tempFilePath);
		createDirIfNotExists(tempDir);
		permitFile(tempDir);
		File zipFile = new File(tempDir, fileName);

		try (FileOutputStream fos = new FileOutputStream(zipFile); ZipOutputStream zos = new ZipOutputStream(fos)) {

			for (File file : files) {

				String zipEntryName = subfolder + File.separator + FilenameUtils.getName(file.getAbsolutePath());

				ZipEntry zipEntry = new ZipEntry(zipEntryName);

				zos.putNextEntry(zipEntry);

				FileUtils.copyFile(file, zos);

				FileUtils.forceDelete(file);

				zos.closeEntry();

			}
		}

		return zipFile;
	}

	public List<File> unzip(String zipFilePath, String destDir) throws Exception {
		File destFolder = new File(destDir);
		if (!destFolder.exists()) {
			destFolder.mkdirs();
		}

		byte[] buffer = new byte[1024];
		List<File> outputFile = new ArrayList<>();

		try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath))) {
			ZipEntry zipEntry = zis.getNextEntry();

			while (zipEntry != null) {
				File newFile = newFile(destFolder, zipEntry);

				if (zipEntry.isDirectory()) {
					newFile.mkdirs();
				} else {
					// Create parent directories
					outputFile.add(newFile);

					new File(newFile.getParent()).mkdirs();

					try (FileOutputStream fos = new FileOutputStream(newFile)) {
						int len;
						while ((len = zis.read(buffer)) > 0) {
							fos.write(buffer, 0, len);
						}
					}
				}

				zipEntry = zis.getNextEntry();
			}

			zis.closeEntry();
		}
		return outputFile;
	}

	// Prevents Zip Slip vulnerability
	private File newFile(File destinationDir, ZipEntry zipEntry) throws Exception {
		File destFile = new File(destinationDir, zipEntry.getName());
		String destDirPath = destinationDir.getCanonicalPath();
		String destFilePath = destFile.getCanonicalPath();

		if (!destFilePath.startsWith(destDirPath + File.separator)) {
			throw new IOException("Zip entry is outside the target directory: " + zipEntry.getName());
		}

		return destFile;
	}

}
