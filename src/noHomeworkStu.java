import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/*
 * 这里存储一二班的所有人名单
 */
public class noHomeworkStu {

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
    public  static void findNoHomeworkStu(String dirPath,List<String> name){
        File file = new File(dirPath);
        //File []files = file.listFiles();
        String []filenames = file.list();

        int curNum = 1;

        //找初这个班没交作业的同学
        Iterator<String> it = name.iterator();
        while (it.hasNext()){
            int flag = 0;
            String curname = it.next();
            for(int i=0;i<filenames.length;i++){
                if (filenames[i].indexOf(curname)!=-1){
                    flag = 1;
                }
            }
            if (flag==0){
                System.out.println("没交作业- "+curNum+" "+curname);
                curNum++;
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

        String dirPath1="E:\\分布式计算收作业\\第五次作业\\1班\\";
        String dirPath2="E:\\分布式计算收作业\\第五次作业\\2班\\";
        System.out.println("----------1班没交作业的同学:---------------");
        findNoHomeworkStu(dirPath1,name1);
        System.out.println("----------2班没交作业的同学:---------------");
        findNoHomeworkStu(dirPath2,name2);
        return ;
    }
}

