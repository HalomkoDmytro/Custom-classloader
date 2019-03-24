package gl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException,
            NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, InterruptedException {

        while (true) {
            TextServiceClassLoader classLoader = new TextServiceClassLoader();
            Class<?> c = classLoader.findClass("gl.TextService");
            Object textService = c.getDeclaredConstructor().newInstance();
            Method md = c.getMethod("staticText");
            System.out.println(md.invoke(textService));
            Thread.sleep(2000);
        }
    }
}
