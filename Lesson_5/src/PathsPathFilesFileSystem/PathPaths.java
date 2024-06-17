package PathsPathFilesFileSystem;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathPaths {
    public static void main(String[] args) {
        Path filePath = Paths.get("test/logo.png");
        System.out.println("Filepath: " + filePath);
        Path fileName = filePath.getFileName();
        System.out.println("Filename: " + fileName);
        Path parent = filePath.getParent();
        System.out.println("Parent directory: " + parent);
        boolean endWithTxt = filePath.endsWith("logo.png");
        System.out.println("Ends with filepath: " + endWithTxt);
        endWithTxt = filePath.endsWith("png");
        System.out.println("Ends with string: " + endWithTxt);
        boolean startsWithPics = filePath.startsWith("test");
        System.out.println("Starts with filepath: " + startsWithPics);
        Path path = Paths.get("../Java-Core/../pics/logo.png");
        System.out.println(path.normalize());

    }
}
