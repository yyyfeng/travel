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
 * @Description: 腾讯云图片上传的工具类
 * @date 2019年1月19日 下午3:46:36
 * @author lpjz@foxmail.com
 * 
 */
/**
 * 特别注意：此版本代码必须使用此依赖 
 * <!-- 腾讯云上传依赖 --> 
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
// 这个方法是专门用来上传SSM框架下的文件的
// 前提条件是：①：在requestMapper的方法中必须接收HttpServletRequest，MultipartFile作为参数，然后传入此方法中
public class TxFileUploadUtil {
	private static String secretId = "AKIDKR9oF9rcbmIZ4br7bdpEgr5J0xjvuUIr";
	private static String secretKey = "3tZ0DFF4XmtwRqshT34tWyiEUeWN2sKX";

//	public static String upLoadSSM(HttpServletRequest request, MultipartFile pictureFile) throws Exception {
//		// 设置图片名称，不能重复，可以使用uuid
//		String picName = UUID.randomUUID().toString();
//		// 获取文件的原始路径这个文件夹是创建在项目下面的自己手动创建
//		String path = request.getSession().getServletContext().getRealPath("/picture");
//		picName = picName.replaceAll("-", "");
//		// 获取文件名
//		String oriName = pictureFile.getOriginalFilename();
//		// 获取图片后缀
//		String extName = oriName.substring(oriName.lastIndexOf("."));
//		// 整合新的文件名加后缀
//		String newName = "/" + picName + extName;
//		// 上传到服务器上的地址
//		String tomPath = path + newName;
//		// 开始将文件上传到tomcat的文件目录下
//		pictureFile.transferTo(new File(path + "/" + newName));
//		// 直接传一个路径进来就好啦
//		File cosFile = new File(tomPath);
//		// 将密钥配置进去
//		COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
//		// 2 设置bucket的区域, COS地域的简称请参照
//		ClientConfig clientConfig = new ClientConfig(new Region("ap-guangzhou"));
//		// 3 获得cos客户端
//		COSClient cosClient = new COSClient(cred, clientConfig);
//		String bucketName = "graduate-1258213501";
//		// 设置上传文件的存储位置
//		String key = "graduproject/" + cosFile.getName();
//		// 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20 M 以下的文件使用该接口
//		// 大文件上传请参照 API 文档高级 API 上传
//		// 指定要上传到 COS 上的路径
//		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, cosFile);
//		cosClient.putObject(putObjectRequest);
//		// 关闭客户端
//		cosClient.shutdown();
//		Date expiration = new Date(new Date().getTime() + 5 * 60 * 10000);
//		URL oldurl = cosClient.generatePresignedUrl(bucketName, key, expiration);
//		// 获得链接后解析字符串并且返回
//		// 先将url转换为字符串
//		String url = oldurl.toString();
//		// http://jobpic-1258185724.cos.ap-guangzhou.myqcloud.com/image/T.jpg?sign
//		// 直接查找到第一个？的位置
//		url = url.substring(0, url.indexOf("?"));
//		// 开始解析字符串
//		return url;
//	}

	// 如果是采用其他的方式添加文件则采用此方法
	public static String upLoadCom(String tomPath) throws Exception {
		File cosFile = new File(tomPath);
		// 将密钥配置进去
		COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
		// 2 设置bucket的区域, COS地域的简称请参照
		ClientConfig clientConfig = new ClientConfig(new Region("ap-guangzhou"));
		// 3 获得cos客户端
		COSClient cosClient = new COSClient(cred, clientConfig);
		String bucketName = "graduate-1258213501";
		// 设置上传文件的存储位置
		String key = "graduproject/" + cosFile.getName();
		// 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20 M 以下的文件使用该接口
		// 大文件上传请参照 API 文档高级 API 上传
		// 指定要上传到 COS 上的路径
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, cosFile);
		cosClient.putObject(putObjectRequest);
		// 关闭客户端
		cosClient.shutdown();
		Date expiration = new Date(new Date().getTime() + 5 * 60 * 10000);
		URL oldurl = cosClient.generatePresignedUrl(bucketName, key, expiration);
		// 获得链接后解析字符串并且返回
		// 先将url转换为字符串
		String url = oldurl.toString();
		// http://jobpic-1258185724.cos.ap-guangzhou.myqcloud.com/image/T.jpg?sign
		// 直接查找到第一个？的位置
		url = url.substring(0, url.indexOf("?"));
		// 开始解析字符串
		return url;		
	}
}
