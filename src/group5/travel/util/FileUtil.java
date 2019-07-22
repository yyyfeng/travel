package group5.travel.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

/**
 * @ClassName: FileUtil
 * @Description: 文件的上传和生成文件的下载地址
 * @date 2018年12月10日 上午10:21:41 Company www.igeekhome.com
 * 
 */
public class FileUtil {
	// 设置好账号的ACCESS_KEY和SECRET_KEY
	String ACCESS_KEY = "FX2lK5278tzlcIRUGa6-0dkAoMFQ5pyEF2Bw_tdm";
	String SECRET_KEY = "91iNwRTH6UtUhkVS92uF_b8curmZF2y6R8L0tDsI";
	// 要上传的空间
	String bucketname = "yingf";
	// 上传到七牛后保存的文件名
	String key = "";
	// 上传文件的路径
	String FilePath = "";
	// 密钥配置
	Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

	// 第二种方式: 自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
	Zone z = Zone.autoZone();
	Configuration c = new Configuration(z);

	// 创建上传对象
	UploadManager uploadManager = new UploadManager(c);

	// 设置callbackUrl以及callbackBody,七牛将文件名和文件大小回调给业务服务器
	public String getUpToken() {
		return auth.uploadToken(bucketname);
	}

	/**
	 * 文件上传
	 * 
	 * @Title: upload
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param filePath 要上传到空间的文件路径
	 * @param key      上传到云空间的文件的名称
	 * @throws IOException
	 */
	public String upload(String filePath, String key) throws IOException {
		this.FilePath = filePath;
		this.key = key;
		if (new File(filePath).exists() && key!=null && !"".equals(key)) {
			try {
				// 调用put方法上传
				Response res = uploadManager.put(FilePath, null, getUpToken());
				// 打印返回的信息
				System.out.println(res.bodyString());
				HashMap data = JSONUtils.JsonToObject(res.bodyString(), HashMap.class);
				return data.get("key").toString();
			} catch (QiniuException e) {
				System.out.println("异常："+e.getMessage());
				Response r = e.response;
				// 请求失败时打印的异常的信息
				System.out.println(r.toString());
				StringMap jsonToMap = r.jsonToMap();
				System.out.println("ss:"+jsonToMap);
				//System.out.println(r.address);
				try {
					// 响应的文本信息
					System.out.println("---:"+r.bodyString());
				} catch (QiniuException e1) {
					// ignore
				}
			}
		}
		return "";
	}
	
	String URL = "http://putt6eowu.bkt.clouddn.com/";

	/**
	 * 
	* @Title: getDownLoadUrl  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param key 要下载的文件在云端的名称
	* @return
	 */
	public String getDownLoadUrl(String key) {
		URL += key; 
        //调用privateDownloadUrl方法生成下载链接,第二个参数可以设置Token的过期时间
        String downloadRUL = auth.privateDownloadUrl(URL, 3600);
        return downloadRUL;
	}

}
