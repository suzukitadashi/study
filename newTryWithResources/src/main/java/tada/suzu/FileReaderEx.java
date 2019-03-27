package tada.suzu;

import java.io.*;

public class FileReaderEx extends FileReader {

    public FileReaderEx(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public FileReaderEx(File file) throws FileNotFoundException {
        super(file);
    }

    public FileReaderEx(FileDescriptor fd) {
        super(fd);
    }

    @Override
    public void close() throws IOException {
        System.out.println("FileReaderEx close call");
        super.close();
    }
}
