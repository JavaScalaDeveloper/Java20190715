package NetworkProgram;

import java.io.*;

/*封装IO流读写的工具类
@author 黄佳豪
@create 2019-07-30-19:44
*/
public class StreamUtils {
    /**
     * 将字节输入流读取后转换成String
     *
     * @param is
     * @return
     */
    public static String streamToString(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        return builder.toString();
    }

    /**
     * 将字节输入流读取后转换成byte
     *
     * @param is
     * @return
     */
    public static byte[] streamToByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len;
        byte[] b = new byte[1024];
        while ((len = is.read()) != -1) {
            baos.write(b, 0, len);
        }
        return baos.toByteArray();
    }
}
