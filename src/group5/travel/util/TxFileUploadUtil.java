package group5.travel.util;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;



import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;

/**
 * @ClassName: TxFileUploadUtil
 * @Description: ��Ѷ��ͼƬ�ϴ��Ĺ�����
 * @date 2019��1��19�� ����3:46:36
 * @author lpjz@foxmail.com
 * 
 */
/**
 * �ر�ע�⣺�˰汾�������ʹ�ô����� 
 * <!-- ��Ѷ���ϴ����� --> 
 * <dependency> 
 *   <groupId>com.qcloud</groupId>
 *    <artifactId>cos_api</artifactId> 
 *   <version>5.2.4</version> 
 * </dependency>
 * <dependency> 
 *   <groupId>com.qcloud</groupId>
 *    <artifactId>qcloud-java-sdk</artifactId>
 *   <version>2.0.1</version>
 * </dependency>
 *
 */
// ���������ר�������ϴ�SSM����µ��ļ���
// ǰ�������ǣ��٣���requestMapper�ķ����б������HttpServletRequest��MultipartFile��Ϊ������Ȼ����˷�����
public class TxFileUploadUtil {
	private static String secretId = "AKIDKR9oF9rcbmIZ4br7bdpEgr5J0xjvuUIr";
	private static String secretKey = "3tZ0DFF4XmtwRqshT34tWyiEUeWN2sKX";

//	public static String upLoadSSM(HttpServletRequest request, MultipartFile pictureFile) throws Exception {
//		// ����ͼƬ���ƣ������ظ�������ʹ��uuid
//		String picName = UUID.randomUUID().toString();
//		// ��ȡ�ļ���ԭʼ·������ļ����Ǵ�������Ŀ������Լ��ֶ�����
//		String path = request.getSession().getServletContext().getRealPath("/picture");
//		picName = picName.replaceAll("-", "");
//		// ��ȡ�ļ���
//		String oriName = pictureFile.getOriginalFilename();
//		// ��ȡͼƬ��׺
//		String extName = oriName.substring(oriName.lastIndexOf("."));
//		// �����µ��ļ����Ӻ�׺
//		String newName = "/" + picName + extName;
//		// �ϴ����������ϵĵ�ַ
//		String tomPath = path + newName;
//		// ��ʼ���ļ��ϴ���tomcat���ļ�Ŀ¼��
//		pictureFile.transferTo(new File(path + "/" + newName));
//		// ֱ�Ӵ�һ��·�������ͺ���
//		File cosFile = new File(tomPath);
//		// ����Կ���ý�ȥ
//		COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
//		// 2 ����bucket������, COS����ļ�������
//		ClientConfig clientConfig = new ClientConfig(new Region("ap-guangzhou"));
//		// 3 ���cos�ͻ���
//		COSClient cosClient = new COSClient(cred, clientConfig);
//		String bucketName = "graduate-1258213501";
//		// �����ϴ��ļ��Ĵ洢λ��
//		String key = "graduproject/" + cosFile.getName();
//		// ���ļ��ϴ�, ���֧�� 5 GB, ������С�ļ��ϴ�, ���� 20 M ���µ��ļ�ʹ�øýӿ�
//		// ���ļ��ϴ������ API �ĵ��߼� API �ϴ�
//		// ָ��Ҫ�ϴ��� COS �ϵ�·��
//		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, cosFile);
//		cosClient.putObject(putObjectRequest);
//		// �رտͻ���
//		cosClient.shutdown();
//		Date expiration = new Date(new Date().getTime() + 5 * 60 * 10000);
//		URL oldurl = cosClient.generatePresignedUrl(bucketName, key, expiration);
//		// ������Ӻ�����ַ������ҷ���
//		// �Ƚ�urlת��Ϊ�ַ���
//		String url = oldurl.toString();
//		// http://jobpic-1258185724.cos.ap-guangzhou.myqcloud.com/image/T.jpg?sign
//		// ֱ�Ӳ��ҵ���һ������λ��
//		url = url.substring(0, url.indexOf("?"));
//		// ��ʼ�����ַ���
//		return url;
//	}

	// ����ǲ��������ķ�ʽ����ļ�����ô˷���
	public static String upLoadCom(String tomPath) throws Exception {
		File cosFile = new File(tomPath);
		// ����Կ���ý�ȥ
		COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
		// 2 ����bucket������, COS����ļ�������
		ClientConfig clientConfig = new ClientConfig(new Region("ap-guangzhou"));
		// 3 ���cos�ͻ���
		COSClient cosClient = new COSClient(cred, clientConfig);
		String bucketName = "graduate-1258213501";
		// �����ϴ��ļ��Ĵ洢λ��
		String key = "graduproject/" + cosFile.getName();
		// ���ļ��ϴ�, ���֧�� 5 GB, ������С�ļ��ϴ�, ���� 20 M ���µ��ļ�ʹ�øýӿ�
		// ���ļ��ϴ������ API �ĵ��߼� API �ϴ�
		// ָ��Ҫ�ϴ��� COS �ϵ�·��
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, cosFile);
		cosClient.putObject(putObjectRequest);
		// �رտͻ���
		cosClient.shutdown();
		Date expiration = new Date(new Date().getTime() + 5 * 60 * 10000);
		URL oldurl = cosClient.generatePresignedUrl(bucketName, key, expiration);
		// ������Ӻ�����ַ������ҷ���
		// �Ƚ�urlת��Ϊ�ַ���
		String url = oldurl.toString();
		// http://jobpic-1258185724.cos.ap-guangzhou.myqcloud.com/image/T.jpg?sign
		// ֱ�Ӳ��ҵ���һ������λ��
		url = url.substring(0, url.indexOf("?"));
		// ��ʼ�����ַ���
		return url;		
	}
}
