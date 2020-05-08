package action;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExamineeInfo {
	public static List<Map<String,Object>> ExamineeInfoGet() {

		  //ファイル読み込みで使用する３つのクラス
		  FileInputStream fi = null;
		  InputStreamReader is = null;
		  BufferedReader br = null;

		  //受験者情報を保持する
		  Map<String,Object> ExamineeInfo;
		  List<Map<String,Object>> ExamineeInfoList = new ArrayList<Map<String,Object>>();

		  try {

		    //読み込みファイルのインスタンス生成
		    //ファイル名を指定する
		    fi = new FileInputStream("/Test/TestResult.csv");
		    is = new InputStreamReader(fi);
		    br = new BufferedReader(is);

		    //読み込み行
		    String line;
		    //読み込み行数の管理
		    int i = 0;

		    //1行ずつ読み込みを行う
		    while ((line = br.readLine()) != null) {
		      //先頭行は列名
		      if (i > 1) {

		        //カンマで分割した内容を配列に格納する
		        String[] data = line.split(",");

		        ExamineeInfo = new HashMap<String,Object>();
		        ExamineeInfo.put("examineeId",data[0]);
		        ExamineeInfo.put("time",data[1]);
		        ExamineeInfo.put("name",data[2]);
		        ExamineeInfo.put("gender",data[3]);
		        ExamineeInfo.put("birth",data[4].replace("-","/"));
		        ExamineeInfo.put("edu",data[5]);
		        ExamineeInfo.put("status",data[6]);
		        ExamineeInfo.put("answersNum1",data[7]);
		        ExamineeInfo.put("correctNum1",data[8]);
		        ExamineeInfo.put("correctRate1",data[9]);
		        ExamineeInfo.put("answersNum2",data[10]);
		        ExamineeInfo.put("correctNum2",data[11]);
		        ExamineeInfo.put("correctRate2",data[12]);
		        ExamineeInfo.put("answersNum3",data[13]);
		        ExamineeInfo.put("correctNum3",data[14]);
		        ExamineeInfo.put("correctRate3",data[15]);
		        ExamineeInfo.put("answersNum4",data[16]);
		        ExamineeInfo.put("correctNum4",data[17]);
		        ExamineeInfo.put("correctRate4",data[18]);
		        ExamineeInfo.put("answersNumLang",data[19]);
		        ExamineeInfo.put("correctNumLang",data[20]);
		        ExamineeInfo.put("correctRateLang",data[21]);
		        ExamineeInfo.put("answersNumMath",data[22]);
		        ExamineeInfo.put("correctNumMath",data[23]);
		        ExamineeInfo.put("correctRateMath",data[24]);
		        ExamineeInfo.put("answersNumTotal",data[25]);
		        ExamineeInfo.put("correctNumTotal",data[26]);
		        ExamineeInfo.put("correctRateTotal",data[27]);;
		        ExamineeInfo.put("conScoreLang",data[29]);
		        ExamineeInfo.put("conScoreMath",data[31]);
		        ExamineeInfo.put("conScoreAns",data[33]);
		        ExamineeInfo.put("conScoreCor",data[35]);
		        ExamineeInfo.put("correctRate",data[36]);
		        ExamineeInfo.put("numOfExaminations",data[37]);

		        ExamineeInfoList.add(ExamineeInfo);

		      }
		      //行数のインクリメント
		      i++;

		    }
		    Collections.reverse(ExamineeInfoList);

		  } catch (FileNotFoundException e) {
			  return ExamineeInfoList;
		  } catch (Exception e) {
			  e.printStackTrace();
		  } finally {
		    try {
		    	if(br!=null){
		    		br.close();
		    	}
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		  }

		return ExamineeInfoList;
	}
}
