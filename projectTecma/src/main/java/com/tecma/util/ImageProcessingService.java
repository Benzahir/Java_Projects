package com.tecma.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.im4java.core.ConvertCmd;
import org.im4java.core.IMOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageProcessingService {

	public @ResponseBody
	 List<String> handleFileUpload(MultipartFile[] file,
			String inputphotoPath) {
		String directoryPath = MyUtil.getMessage("photoDirectoryPath");
		String photoPath = directoryPath + "/" + inputphotoPath;
		List<String> s = new ArrayList<String>();
		try {
			for (int x = 0; x < file.length; x++) {
				if (!file[x].isEmpty()
						&& file[x].getContentType().equalsIgnoreCase(
								MediaType.IMAGE_JPEG_VALUE)) {
					ImageProcessingService ips = new ImageProcessingService();
					DateFormat dateFormat = new SimpleDateFormat(
							"ddMMyyyyHHmmssSSS");
					Date date = new Date();
					String imageName = dateFormat.format(date);
					String folders[] = { "large", "medium" };
					File f = new File(photoPath + "/original");
					f.mkdirs();
					for (int y = 0; y < folders.length; y++) {
						File f1 = new File(directoryPath + "/" + inputphotoPath
								+ "/" + folders[y].trim());
						f1.mkdirs();
					}
					String inputImagePath = f.getPath() + "/" + imageName;
					String outputImagePath = directoryPath + "/"
							+ inputphotoPath;
					byte[] bytes = file[x].getBytes();
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(new File(inputImagePath
									+ ".jpg")));
					stream.write(bytes);
					stream.close();
					ips.large(inputImagePath + ".jpg", outputImagePath + "/"
							+ "large/" + imageName + ".jpg");
					ips.medium(inputImagePath + ".jpg", outputImagePath + "/"
							+ "medium/" + imageName + ".jpg");
					s.add(x, imageName);
				}
			}
		} catch (Exception e) {
			System.out.println("catch :   " + e.getMessage());
		}
		return s;
	}

	public void medium(String inputImagePath, String outputImagePath)
			throws IOException {
		resize(inputImagePath, outputImagePath, 200, 150);
	}

	public void large(String inputImagePath, String outputImagePath)
			throws IOException {
		resize(inputImagePath, outputImagePath, 400, 400);
	}

	public void list(String inputImagePath[], String outputImagePath[],
			int scaledWidth[], int scaledHeight[]) throws IOException {
		if (scaledWidth.length == scaledHeight.length) {
			for (int x = 0; x < scaledWidth.length; x = x++) {
				resize(inputImagePath[x], outputImagePath[x], scaledWidth[x],
						scaledHeight[x]);
			}
		}
	}

	public void resize(String inputImagePath, String outputImagePath,
			int scaledWidth, int scaledHeight) {
		try {
			ConvertCmd cmd = new ConvertCmd();
			IMOperation op = new IMOperation();
			op.addImage(inputImagePath);
			op.quality(100d);
			op.resize(scaledWidth, scaledHeight);
			op.addImage(outputImagePath);
			cmd.run(op);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
