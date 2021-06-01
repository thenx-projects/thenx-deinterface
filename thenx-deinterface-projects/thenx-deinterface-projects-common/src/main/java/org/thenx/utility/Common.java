package org.thenx.utility;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Common {

	private static String temp3 = "@[\\]\\[a-zA-Z0-9_.]+";
	private static String temp4 = "&[\\]\\[a-zA-Z0-9_.]+";

	/**
	 * 判断变量是否为空
	 *
	 * @param s
	 * @return null
	 */
	public static boolean isEmpty(Object s) {
		return null == s || "".equals(s.toString()) || "null".equals(s.toString());
	}

	/**
	 * 使用率计算
	 *
	 * @return null
	 */
	public static String fromUsage(long free, long total) {
		Double d = new BigDecimal(free * 100 / total).setScale(1,
				BigDecimal.ROUND_HALF_UP).doubleValue();
		return String.valueOf(d);
	}

	/**
	 * 生成随机数方法(全数字)
	 * @param length 生成随机数的长度
	 */
	public static String getRandomString(int length) {
		StringBuilder buffer = new StringBuilder("0123456789");
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		int range = buffer.length();
		for (int i = 0; i < length; i++) {
			sb.append(buffer.charAt(r.nextInt(range)));
		}
		return sb.toString();
	}

	/**
	 * 返回当前时间　格式：yyyy-MM-dd hh:mm:ss
	 *
	 * @return null String
	 */
	public static String fromDateH() {
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format1.format(new Date());
	}

	/**
	 * 返回当前时间　格式：yyyy-MM-dd
	 *
	 * @return null String
	 */
	public static String fromDateY() {
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		return format1.format(new Date());
	}

	/**
	 * 返回当前时间格式字符串
	 *
	 * @return String
	 */
	public static String getDateTime(String str) {
		DateFormat format1 = new SimpleDateFormat(str);
		return format1.format(new Date());
	}

	/**
	 * 用来去掉List中空值和相同项的。
	 *
	 * @param list list
	 * @return null
	 */
	public static List<String> removeSameItem(List<String> list) {
		List<String> difList = new ArrayList<String>();
		for (String t : list) {
			if (t != null && !difList.contains(t)) {
				difList.add(t);
			}
		}
		return difList;
	}

	/**
	 * 返回用户的IP地址
	 *
	 * @param request request
	 * @return null
	 */
	public static String toIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 传入原图名称，，获得一个以时间格式的新名称
	 *
	 * @param fileName
	 *            　原图名称
	 * @return null
	 */
	public static String generateFileName(String fileName) {
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String formatDate = format.format(new Date());
		int random = new Random().nextInt(10000);
		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);
		return formatDate + random + extension;
	}

	/**
	 * 取得html网页内容 UTF8编码
	 *
	 * @param urlStr
	 *            网络地址
	 * @return null String
	 */
	public static String getInputHtmlUTF8(String urlStr) {
		URL url = null;
		try {
			url = new URL(urlStr);
			HttpURLConnection httpsURLConnection = (HttpURLConnection) url
					.openConnection();

			httpsURLConnection.setRequestMethod("GET");
			httpsURLConnection.setConnectTimeout(5 * 1000);
			httpsURLConnection.connect();
			if (httpsURLConnection.getResponseCode() == 200) {
				// 通过输入流获取网络图片
				InputStream inputStream = httpsURLConnection.getInputStream();
				String data = readHtml(inputStream, "UTF-8");
				inputStream.close();
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return null;

	}

	/**
	 * 取得html网页内容 GBK编码
	 *
	 * @param urlStr
	 *            网络地址
	 * @return null String
	 */
	public static String getInputHtmlGBK(String urlStr) {
		URL url = null;
		try {
			url = new URL(urlStr);
			HttpURLConnection httpsURLConnection = (HttpURLConnection) url
					.openConnection();

			httpsURLConnection.setRequestMethod("GET");
			httpsURLConnection.setConnectTimeout(5 * 1000);
			httpsURLConnection.connect();
			if (httpsURLConnection.getResponseCode() == 200) {
				// 通过输入流获取网络图片
				InputStream inputStream = httpsURLConnection.getInputStream();
				String data = readHtml(inputStream, "GBK");
				inputStream.close();
				return data;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return null;

	}

	/**
	 * @param inputStream
	 * @param uncode
	 *            编码 GBK 或 UTF-8
	 * @return null
	 * @throws Exception
	 */
	public static String readHtml(InputStream inputStream, String uncode)
			throws Exception {
		InputStreamReader input = new InputStreamReader(inputStream, uncode);
		BufferedReader bufReader = new BufferedReader(input);
		String line = "";
		StringBuilder contentBuf = new StringBuilder();
		while ((line = bufReader.readLine()) != null) {
			contentBuf.append(line);
		}
		return contentBuf.toString();
	}

	/**
	 *
	 * @return null 返回资源的二进制数据 @
	 */
	public static byte[] readInputStream(InputStream inputStream) {

		// 定义一个输出流向内存输出数据
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		// 定义一个缓冲区
		byte[] buffer = new byte[1024];
		// 读取数据长度
		int len = 0;
		// 当取得完数据后会返回一个-1
		try {
			while ((len = inputStream.read(buffer)) != -1) {
				// 把缓冲区的数据 写到输出流里面
				byteArrayOutputStream.write(buffer, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				byteArrayOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}

		// 得到数据后返回
		return byteArrayOutputStream.toByteArray();

	}


	public static String ParseExpression(Map infoMap, String strPassedParam)
			throws Exception {
		String strRel = strPassedParam;
		Pattern p = Pattern.compile(temp3);
		Matcher m = p.matcher(strPassedParam);
		while (m.find()) {
			String strMColumn = m.group(0).toString();
			String strColumn = strMColumn.substring(1); // 除去"@"
			if (infoMap.containsKey(strColumn.toUpperCase())) {
				String strValue = infoMap.get(strColumn.toUpperCase())
						.toString(); // 查找出对应数值
				// ，
				// 进行转换
				strRel = strRel.replaceAll(strMColumn, strValue);
			}
		}
		return strRel;
	}

	public static String ParseExpression2(Map infoMap, String strPassedParam)
			throws Exception {
		String strRel = strPassedParam;
		Pattern p = Pattern.compile(temp4);
		Matcher m = p.matcher(strPassedParam);
		while (m.find()) {
			String strMColumn = m.group(0).toString();
			String strColumn = strMColumn.substring(1); // 除去"@"
			if (infoMap.containsKey(strColumn.toUpperCase())) {
				String strValue = infoMap.get(strColumn.toUpperCase())
						.toString(); // 查找出对应数值
				// ，
				// 进行转换
				strRel = strRel.replaceAll(strMColumn, strValue);
			}
		}
		return strRel;
	}



	/**
     * 动态sql处理参数方法
     *
     * @param map
     * @return
     */
    public static Map<String, String> fixSql(Map<String, String> map) {
        Map<String, String> maps = new HashMap<>();
        String sql = map.get("sql").toUpperCase();
        map.remove("sql");
        if(map.get("pms")==null||map.get("pms")==""){
        	map.remove("pms");
		}
        if (null == sql) {
            return null;
        }

        for (String param : map.keySet()) {
            String getParams = "@" + Underline2Camel.underline2Camel(param, true);
            char[] chars = getParams.toCharArray();
            chars[1] += 32;
            sql = sql.replaceAll(String.valueOf(chars).toUpperCase(), map.get(param).toUpperCase());
        }
        maps.put("sql", sql);
        return maps;
    }


	/**
	 * 动态sql处理参数+ORACLE分页语句
	 *
	 * @param pageView
	 * @return
	 */
	public static Map<String, String> fixSqlTGP(PageView pageView) {
		Map<String,String> map = pageView.getQueryMap();
		Map<String, String> maps = new HashMap<>();
		String sql = map.get("sql").toUpperCase();
		map.remove("sql");
		if(map.get("pms")==null||map.get("pms")==""){
			map.remove("pms");
		}
		if (null == sql) {
			return null;
		}

		for (String param : map.keySet()) {
			String getParams = "@" + Underline2Camel.underline2Camel(param, true);
			char[] chars = getParams.toCharArray();
			chars[1] += 32;
			sql = sql.replaceAll(String.valueOf(chars).toUpperCase(), map.get(param).toUpperCase());
		}
		int startCont = pageView.getPageNow()*pageView.getPageSize();
		int endCont = pageView.getPageNow()*pageView.getPageSize()+pageView.getPageSize();
		String strSql = "SELECT *  FROM(SELECT tt.*, ROWNUM AS rowno" +
				"    FROM ( "+sql+") tt" +
				"  WHERE ROWNUM <= "+endCont+") table_alias" +
				"  WHERE table_alias.rowno >= "+startCont;
		maps.put("sql", strSql);

		String strCountSql = " select count(1) as cont  FROM ( "+sql+")";
		maps.put("countsql", strCountSql);
		return maps;
	}


    /**
     * 动态sql处理逗号参数拼接组装map
     *
     * @return
     */
    public static List<Map<String, String>> StringToMap(String key,String desc){
    	List<Map<String, String>> resList = new ArrayList<Map<String, String>>();

    	try {
			String[] keys = key.split(",");
			String[] descs = desc.split(",");
			for(int i=0;i<keys.length;i++) {
				Map<String, String> resMap = new HashMap<String, String>();
				resMap.put("id", keys[i]);
				resMap.put("name", descs[i]);
				resList.add(resMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return resList;
		}
		return resList;

    }


    public static String getUTFStringByEncoding(String str) {
		String encode = "UTF-8";
		String returnStr = "";
		try {
			if(str!=null){
				if (str.equals(new String(str.getBytes("GB2312"), StandardCharsets.UTF_8))) {
					encode = "GB2312";
				}else if (str.equals(new String(str.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8))) {
					encode = "ISO-8859-1";
				}else if (str.equals(new String(str.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8))) {
					encode = "UTF-8";
				}else if (str.equals(new String(str.getBytes("GBK"), StandardCharsets.UTF_8))) {
					encode = "GBK";
				}
				if("UTF-8".equals(encode)){
					returnStr = str;
				}else{
					returnStr = new String(str.getBytes(encode), StandardCharsets.UTF_8);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return returnStr;
	}

    //计算两个时间之间的月数 date2>date1
    public static Integer countMonths(Date date1,Date date2) {
    	Calendar beginCal = Calendar.getInstance();
    	Calendar endCal = Calendar.getInstance();
    	beginCal.setTime(date1);
    	endCal.setTime(date2);
    	Integer months=(endCal.get(Calendar.YEAR)-beginCal.get(Calendar.YEAR))*12+(endCal.get(Calendar.MONTH)-beginCal.get(Calendar.MONTH))+1;
    	return months;
    }
}

