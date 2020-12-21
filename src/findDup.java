import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*
 * 找出1.2班名单里有没有重复的名字
 *
 */
public class findDup {

    //读取1.2班名单里的所有名字
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

    public static void main(String[] args) {

        //1.读取1.2班的名单存放到List中
        String fileName1="E:\\分布式计算收作业\\1班名单.txt";
        String fileName2="E:\\分布式计算收作业\\2班名单.txt";

        List<String> name1 = nameALL.getNameinFile(fileName1);
        List<String> name2 = nameALL.getNameinFile(fileName2);

        //找出1.2班重复的名字
        name1.retainAll(name2);
        System.out.println("两个班有相同名字的："+name1);
    }
}

