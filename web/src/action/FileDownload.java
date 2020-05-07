package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.servlet.http.HttpServletResponse;

public class FileDownload {
	public static String fileDownload(HttpServletResponse response){
		String err = null;
		// ダウンロード対象ファイルの読み込み用オブジェクト
		FileInputStream fis = null;
		InputStreamReader isr = null;

		// ダウンロードファイルの書き出し用オブジェクト
		OutputStream os = null;
		OutputStreamWriter osw = null;

		try {
			// ダウンロード対象ファイルのFileオブジェクトを生成
			File file = new File("/Test/OriginalTestResult.csv");

			// ファイル存在チェック
			if (!file.exists() || !file.isFile()) {
				err = "1";
				return err;
			}

			// レスポンスオブジェクトのヘッダー情報を設定
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename=" +
				new String("OriginalTestResult.csv".getBytes("Windows-31J"), "ISO-8859-1"));

			// ダウンロード対象ファイルの読み込み用オブジェクトを生成
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis, "ISO-8859-1");

			// ダウンロードファイルの書き出し用オブジェクトを生成
			os = response.getOutputStream();
			osw = new OutputStreamWriter(os, "ISO-8859-1");

			// IOストリームを用いてファイルダウンロードを行う
			int i;
			while ((i = isr.read()) != -1) {
				osw.write(i);
			}
		} catch (IOException e) {
			err = "1";
			return err;
		} finally {
			try {
				// 各オブジェクトを忘れずにクローズ
				if (osw != null) {
					osw.close();
				}
				if (os != null) {
					os.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				err = "1";
				return err;
			}
		}
		return err;
	}
}
