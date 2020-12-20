package com.fanhf.javastudy.classloader;


/**
 * @author fanhf
 * @Description 自定义加载器
 * @date 2020-11-19 13:35
 */
public class CustomClassLoader extends  ClassLoader{


   public  static void main(String[] args){
       CustomClassLoader customClassLoader = new CustomClassLoader();
       try {
            Class<?> cl  = Class.forName("com.fanhf.javastudy.classloader.CustomClassLoader",true,customClassLoader);
            Object obj = cl.newInstance();
            System.out.println(obj.getClass().getClassLoader());
       } catch (Exception e) {
           e.printStackTrace();
       }
   }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] result = getClassFromCustomPath();
        try {
            if(null == result){
                throw new ClassNotFoundException();
            }else {
                return  defineClass(name,result,0,result.length);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ClassFormatError classFormatError) {
            classFormatError.printStackTrace();
        }
        throw new ClassNotFoundException();
    }

    public byte[] getClassFromCustomPath(){
       //从自定义路径加载指定类：细节略
        //如果指定的字节码文件进行了加密，则需要在此方法中进行解密
        //如果指定路径的字节码文件进行了加密，则需要在此方法中进行解密
       return  null;
    }
}   
