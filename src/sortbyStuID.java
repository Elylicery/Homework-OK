import java.io.*;
import java.util.*;
import java.util.Collection;

/*
 * 找到文件名里面的 姓名+学号 并打印出来
 * 到output.txt
 */

public class sortbyStuID {

    public static void getAllFileName(String path,ArrayList<String> fileName)
    {
        File file = new File(path);
        File [] files = file.listFiles();
        String [] names = file.list();
        if(names != null)
            fileName.addAll(Arrays.asList(names));
        for(File a:files)
        {
            if(a.isDirectory())
            {
                getAllFileName(a.getAbsolutePath(),fileName);
            }
        }
    }
    public static void main(String[] args) {

        System.out.println("--------------------------------");
        ArrayList<String> listFileName = new ArrayList<String>();
        getAllFileName("E:\\分布式计算收作业\\第二次作业\\1班",listFileName);
        List<String> list = new ArrayList<>();
        for(String name:listFileName)
        {
            String id_name="";
            int i;
            for(i=3;i<name.length();i++){
                //48--0  49 1 50 --2 ACSII码对照
                if((name.charAt(i)>=50)&&(name.charAt(i)<=57)){
                    break;
                }
            }
            id_name+=name.substring(i);
            id_name+="\n";
            list.add(id_name);
        }

        //学号排序后输出
        Collections.sort(list);

        File file = new File("E:\\分布式计算收作业\\output.txt");
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            PrintStream printStream = new PrintStream(fileOutputStream);

            printStream.println(list);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}