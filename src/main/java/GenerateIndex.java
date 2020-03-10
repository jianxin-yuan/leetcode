import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yuan
 * @date 2020/3/11 2:51 上午
 * <p>
 * 更新README.md,生成题目列表
 */
public class GenerateIndex {
    private static String baseDir = System.getProperty("user.dir");
    private static String readme = baseDir + "/" + "README.md";
    private static String pathPrefix = "src/main/java/";

    public static void main(String[] args) throws IOException {
        File file = new File(baseDir + "/" + pathPrefix);
        List<String> catalog = new ArrayList<>();
        fileList(file, catalog);
        wirteFile(mergeContent(catalog), readme);

    }

    private static List<String> mergeContent(List<String> catalog) {
        List<String> result = catalog.stream()
                .filter(s -> !s.contains("GenerateIndex.java") && !s.contains("App.java"))
                .map(GenerateIndex::urlParse)
                .collect(Collectors.toList());

        List<String> collect = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(readme))) {
            collect = stream.filter(s -> s.startsWith("#")).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        collect.addAll(result);

        return collect;
    }

    private static void wirteFile(List<String> collect, String readme) throws IOException {
        //创建输出缓冲流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter(readme));

        for (int i = 0; i < collect.size(); i++) {
            String line = collect.get(i);
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }


    //[删除排序数组中的重复项](src/main/java/primary/array/从排序数组中删除重复项.java)
    ///Users/yuan/work/idea-project/yuan/leetcode/src/main/java/basic/BasicSort.java
    public static String urlParse(String path) {
        String fileName = path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf("."));
        String absolutePath = path.replace(baseDir, "");
        absolutePath = absolutePath.substring(absolutePath.indexOf("/") + 1);
        return "[" + fileName + "](" + absolutePath + ")";
    }


    public static void fileList(File file, List<String> catalog) {
        if (file.isDirectory()) {
            Arrays.stream(Objects.requireNonNull(file.listFiles())).forEach(listFile -> fileList(listFile, catalog));
        } else {
            catalog.add(file.getPath());
        }
    }
}
