package landlark.winboot.service.manaul;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

public class TransferFileService {
    public List<String> upload(File file) throws IOException {
        List<String> list = new ArrayList<>();

        if (file != null) {
            try (RandomAccessFile fis = new RandomAccessFile(file.getPath(), "rw")) {
                FileChannel fic = fis.getChannel();
                FileLock fl = fic.tryLock();

                if (fl == null) {
                    throw new IOException("file is locked by other user");
                } else {
                    String line;
                    while ((line = fis.readLine()) != null) {
                        list.add(line);
                    }
                }

                fl.release();
            }
        }
        return list;
    }
}
