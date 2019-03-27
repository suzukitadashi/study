package tada.suzu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class BufferedReaderEx extends BufferedReader {

    public BufferedReaderEx(Reader in) {
        super(in);
    }

    public BufferedReaderEx(Reader in, int sz) {
        super(in, sz);
    }

    @Override
    public void close() throws IOException {
        System.out.println("BufferedReaderEx close call");
        super.close();
    }

}
