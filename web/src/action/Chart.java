package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chart {
	public static Map<String,Object> chart(List<Map<String,Object>> examineeInfoList, String examineeId) {
		Map<String,Object> examineeInfo = new HashMap<String,Object>();

		for(Map<String,Object> info : examineeInfoList){
			if(info.get("examineeId").equals(examineeId)){
				examineeInfo = info;
				break;
			}
		}
		// 年齢の計算
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date birth;
		try {
			birth = sdFormat.parse((String)examineeInfo.get("birth"));

			examineeInfo.put("age",calcAge(birth) + "歳");
			// 受験日
			Date date = sdFormat.parse((String) examineeInfo.get("time"));
			examineeInfo.put("date", sdFormat.format(date));
			// 全体正答率を数字に変換
			String correctRate = (String)examineeInfo.get("correctRate");
			int correctRateNum = Integer.parseInt(correctRate.substring(0, correctRate.length() - 1));
			examineeInfo.put("correctRateNum", correctRateNum);
			// 評価
			if(correctRateNum == 100){
				examineeInfo.put("eval","極めて正確");
			} else if(correctRateNum >= 90){
				examineeInfo.put("eval","正確");
			} else if(correctRateNum >= 85){
				examineeInfo.put("eval","標準");
			} else if(correctRateNum >= 81){
				examineeInfo.put("eval","やや不正確");
			} else {
				examineeInfo.put("eval","不正確");
			}

		} catch (ParseException | NumberFormatException e) {
			examineeInfo.put("err", "1");
		}

		return examineeInfo;
	}

	public static int calcAge(Date birthday) {
		Date now = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	    return (Integer.parseInt(sdf.format(now)) - Integer.parseInt(sdf.format(birthday))) / 10000;
	}
}
