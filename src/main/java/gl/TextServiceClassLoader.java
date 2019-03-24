package gl;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TextServiceClassLoader extends ClassLoader {
    @Override
    public Class<?> findClass(String name) {
        byte[] bt = loadClassData();
        return defineClass(name, bt, 0, bt.length);
    }
    private byte[] loadClassData() {
        InputStream is = null;
        try {
            // (todo) remove hardcode
            is = new FileInputStream("D:\\gl\\HomeWork\\ClassLoader\\src\\main\\java\\gl\\TextService.class");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream byteSt = new ByteArrayOutputStream();
        //write into byte
        int len =0;
        try {
            while((len=is.read())!=-1){
                byteSt.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //convert into byte array
        return byteSt.toByteArray();
    }

}