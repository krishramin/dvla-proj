package serviceimpl;

import com.service.directory.scanner.FileInfo;
import com.service.directory.scanner.impl.DirectoryScannerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.*;



public class DirectoryScannerServiceImplTest {

    private DirectoryScannerService directoryScannerService;
    private final String configDir = "src/test/resources/testData_service/";

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp()  {
        directoryScannerService = new DirectoryScannerService();

    }

    @Test
    public void testIfDirectoryContainsFiles() throws IOException {
        List<FileInfo> list = directoryScannerService.getFilesInfoOfDirectory(configDir);
        assertTrue("Retrieve all files from directory", (list.size() > 0));
    }



    @Test
    public void displayFileAttributeForSupportedFileType()  {
        List<FileInfo> list = directoryScannerService.getFilesInfoOfDirectory(configDir, "csv");

        assertEquals("csv", list.get(0).getExtn());
        assertEquals("test.csv", list.get(0).getFileName());
    }


    @Test
    public void testIfDirectoryContainsSupportedFileTypes()  {
        List<FileInfo> list = directoryScannerService.getFilesInfoOfDirectory(configDir, "jpg", "csv");
        assertTrue("Display only supported file types", (list.size() > 0));
    }
    @Test
    public void testEmptyDirectory()  {
        List<FileInfo> list = directoryScannerService.getFilesInfoOfDirectory(configDir + "empty", "xlsx", "txt");
        assertFalse("Empty directory", (list.size() > 0));
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        directoryScannerService = null;
    }
}