package com.fchsoft.auth.test.module.ioStream;

import cn.hutool.core.util.ObjectUtil;
import com.fchsoft.auth.test.module.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qw
 * @version 1.0.0
 * @ClassName IoStreamService.java
 * @Description
 * @createTime 2022-01-16 12:43
 */
@Service
public class IoStreamService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Map test() throws IOException {
        Map<String, Object> map = new HashMap<>();
//        File file = new File("temp.txt");//文件
//        map.put("exists", file.exists());
//        map.put("isFile", file.isFile());
//        map.put("isDirectory", file.isDirectory());
//        map.put("absolutePath", file.getAbsolutePath());
//        map.put("length", file.length());//字节数
//        boolean flag = file.delete();
//        map.put("flag", flag);
//        File f = new File("D:");//文件夹
//        map.put("list", f.list());//无盘符，只有文件名
//        map.put("fileList", f.listFiles());//有盘符
//        String[] files = f.list((dir, name) -> name.endsWith("7"));
//        map.put("dicts", files);
        String filePath = "F:/file/test/";
        String fileName = "fileTest.txt";
        File file1 = new File(filePath);
        if (!file1.isDirectory()) {
            map.put("dir", file1.mkdirs());
        }
        boolean newFile = new File(filePath + fileName).createNewFile(); //创建文件
        map.put("newFile", newFile);
        return map;
    }

    public void outTest() {
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fos = new FileOutputStream("data.bin");
            dos = new DataOutputStream(fos);
            dos.write(100);
            dos.writeDouble(3.1415926);
            dos.writeUTF("hello!fchsoft!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ObjectUtil.isNotNull(dos)) {
                try {
                    dos.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 拷贝文件
     *
     * @param
     * @return void
     * @date 2022/1/17 16:18
     * @author qw
     */
    public void inTest() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("data.bin");
            fos = new FileOutputStream("data1.bin");
            byte[] bytes = new byte[1024];
            int c = 0;
            //off标识开始的字节,len为结束的字节
            while ((c = fis.read(bytes, 0, bytes.length)) != -1) {
                fos.write(bytes, 0, c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert fos != null;
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writerTest(String fileName, String content) throws IOException {
        FileWriter fw = new FileWriter(fileName, true);//逐个写入字符,效率低,一般放到缓冲流中提高性能
        BufferedWriter bw = new BufferedWriter(fw); //缓冲输出流
        bw.write(content);
        //fw.write(content);
        bw.close();
        fw.close();
    }

    public String readerTest(String filename) throws IOException {
        StringBuffer sb = new StringBuffer();
        FileReader fr = new FileReader(filename);
//        char[] buffer = new char[1024];
//        int c = 0;
//        while ((c = fr.read(buffer, 0, buffer.length)) != -1) { //逐个字符读取,效率低
//            System.out.println(new String(buffer, 0, c));
//        }
        BufferedReader br = new BufferedReader(fr);
        String str = "";
        while (ObjectUtil.isNotNull(str = br.readLine())) { //一次性读取一行
            sb.append(str);
        }
        redisService.hset("file_name", filename, sb);
        SaveFile saveFile = new SaveFile();
        saveFile.setName(filename);
        saveFile.setPath(new File(filename).getPath());
        saveFile.setContent(sb.toString());
        saveFile.setSize(new File(filename).length());
        mongoTemplate.insert(saveFile);
        br.close();
        fr.close();
        return sb.toString();
    }

    //字符流和字节流的适配器,用于在输入内容不确定是字符还是字节时进行使用
    //InputStreamReader,OutputStreamWriter
    public static void main(String[] args) throws IOException {
        System.out.println("请输入:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while (ObjectUtil.isNotNull(str = br.readLine())) {
            System.out.println(str);
        }
    }

    //nio区别于io流,是对缓冲区的数据进行读取或写入的操作
    //利用nio拷贝文件示例
    public void nioTest(File source, File target) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fis = new FileInputStream(source);
            fos = new FileOutputStream(target);
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();
            inChannel.transferTo(0, inChannel.size(), outChannel);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert inChannel != null;
            inChannel.close();
            assert outChannel != null;
            outChannel.close();
            fos.close();
            fis.close();
        }
    }
}
