import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/*
 * 这里存储一二班的所有人名单
 */
public class nameALL {

    //读取名单里的所有名字
    public static List<String> getNameinFile(String filename){
        List<String> name = new ArrayList<>();
        try{
            FileReader fr = new FileReader(filename);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            //按行读取名字
            while ((str=bf.readLine())!=null){
                name.add(str);
            }
            bf.close();
            fr.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return name;
    }

    //匹配班级并对文件名改名
    public  static void classFile(String dirPath,List<String> name1,List<String> name2){
        File file = new File(dirPath);
        //File []files = file.listFiles();
        String []filenames = file.list();
        File oldname;
        File newname;
        for (int i=0;i<filenames.length;i++){
            //System.out.println("第"+i+"个文件:"+filenames[i]);
            //在1班名单里找
            Iterator<String> it1 = name1.iterator();
            while(it1.hasNext()){
                String curname = it1.next();
                if (filenames[i].indexOf(curname)!=-1){
                    //System.out.println("1班的作业：" +filenames[i]);
                    oldname = new File(dirPath+filenames[i]);
                    newname = new File(dirPath+"1班-" +filenames[i]);
                    if (oldname.renameTo(newname)) {
                        System.out.println(filenames[i]+"文件已重命名！");
                    }else{
                        System.out.println(filenames[i]+"Error！！！！");
                    }
                }
            }
            //在2班名单里找
            Iterator<String> it2 = name2.iterator();
            while(it2.hasNext()){
                String curname = it2.next();
                if (filenames[i].indexOf(curname)!=-1){
                    oldname = new File(dirPath+filenames[i]);
                    newname = new File(dirPath+"2班-" +filenames[i]);
                    if (oldname.renameTo(newname)) {
                        System.out.println(filenames[i]+"文件已重命名！");
                    }else{
                        System.out.println(filenames[i]+"Error！！！！");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        //1.读取1.2班的名单存放到List中
        String fileName1="E:\\分布式计算收作业\\1班名单.txt";
        String fileName2="E:\\分布式计算收作业\\2班名单.txt";

        List<String> name1 = nameALL.getNameinFile(fileName1);
        List<String> name2 = nameALL.getNameinFile(fileName2);

//        System.out.println("一班人数："+name1.size());
//        System.out.println("二班人数:"+name2.size());

        classFile("E:\\分布式计算收作业\\第五次作业\\临时\\",name1,name2);
        return ;
    }
}

