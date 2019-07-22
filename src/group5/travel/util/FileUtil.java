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
 * @Description: �ļ����ϴ��������ļ������ص�ַ
 * @date 2018��12��10�� ����10:21:41 Company www.igeekhome.com
 * 
 */
public class FileUtil {
	// ���ú��˺ŵ�ACCESS_KEY��SECRET_KEY
	String ACCESS_KEY = "FX2lK5278tzlcIRUGa6-0dkAoMFQ5pyEF2Bw_tdm";
	String SECRET_KEY = "91iNwRTH6UtUhkVS92uF_b8curmZF2y6R8L0tDsI";
	// Ҫ�ϴ��Ŀռ�
	String bucketname = "yingf";
	// �ϴ�����ţ�󱣴���ļ���
	String key = "";
	// �ϴ��ļ���·��
	String FilePath = "";
	// ��Կ����
	Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

	// �ڶ��ַ�ʽ: �Զ�ʶ��Ҫ�ϴ��Ŀռ�(bucket)�Ĵ洢�����ǻ��������������ϡ�
	Zone z = Zone.autoZone();
	Configuration c = new Configuration(z);

	// �����ϴ�����
	UploadManager uploadManager = new UploadManager(c);

	// ����callbackUrl�Լ�callbackBody,��ţ���ļ������ļ���С�ص���ҵ�������
	public String getUpToken() {
		return auth.uploadToken(bucketname);
	}

	/**
	 * �ļ��ϴ�
	 * 
	 * @Title: upload
	 * @Description: TODO(������һ�仰�����������������)
	 * @param filePath Ҫ�ϴ����ռ���ļ�·��
	 * @param key      �ϴ����ƿռ���ļ�������
	 * @throws IOException
	 */
	public String upload(String filePath, String key) throws IOException {
		this.FilePath = filePath;
		this.key = key;
		if (new File(filePath).exists() && key!=null && !"".equals(key)) {
			try {
				// ����put�����ϴ�
				Response res = uploadManager.put(FilePath, null, getUpToken());
				// ��ӡ���ص���Ϣ
				System.out.println(res.bodyString());
				HashMap data = JSONUtils.JsonToObject(res.bodyString(), HashMap.class);
				return data.get("key").toString();
			} catch (QiniuException e) {
				System.out.println("�쳣��"+e.getMessage());
				Response r = e.response;
				// ����ʧ��ʱ��ӡ���쳣����Ϣ
				System.out.println(r.toString());
				StringMap jsonToMap = r.jsonToMap();
				System.out.println("ss:"+jsonToMap);
				//System.out.println(r.address);
				try {
					// ��Ӧ���ı���Ϣ
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
	* @Description: TODO(������һ�仰�����������������)  
	* @param key Ҫ���ص��ļ����ƶ˵�����
	* @return
	 */
	public String getDownLoadUrl(String key) {
		URL += key; 
        //����privateDownloadUrl����������������,�ڶ���������������Token�Ĺ���ʱ��
        String downloadRUL = auth.privateDownloadUrl(URL, 3600);
        return downloadRUL;
	}

}
