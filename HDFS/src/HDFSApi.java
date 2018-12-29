import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import java.io.*;
import java.net.URL;

public class HDFSApi {
    static{  
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());  
    }

    /**
     * 主函数 
     */
    public static void main(String[] args) throws Exception {
    	String remoteFilePath = "hdfs://localhost:9000/user/hadoop/text.txt";    // HDFS文件
        InputStream in = null; 
        try{  
            /* 通过URL对象打开数据流，从中读取数据 */
            in = new URL(remoteFilePath).openStream();  
            IOUtils.copyBytes(in,System.out,4096,false);  
        } finally{  
            IOUtils.closeStream(in);  
        }  
    }
}