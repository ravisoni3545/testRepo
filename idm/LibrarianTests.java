package com.idm;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
/**
 * Create two tests using JUnit and Mockito (or your preferring mocking framework).
 * The tests should target the Librarian class provided in the Librarian.java file.
 *
 * The first test should be an "Integration Test" in that the code under test is
 * expected to actually make file system modifications.
 *
 * The second test should be a strict "Unit Test" in that only the code under test
 * should be executed. In this case a "mock" object should be injected into the
 * code under test so that the file system changes are not made.
 *
 * Both JUnit and Mockito libraries have been provided in the /lib/ folder but 
 * any suitable mocking library may be used.
 *
 * Please *feel free* to use Google during this test.
 **/
@RunWith(MockitoJUnitRunner.class)
public class LibrarianTests {
    // An Integration Test that will modify the file system
    @InjectMocks
    private Librarian libraryService;
    
    @Mock
    private FileReaderWriter readerWriter;
	
	@Test
    public void it_Librarian_ManagesBooks() throws IOException {
        // arrange
		String name="MyExperience";
		String content="Can't share it";
		
		Librarian lib= new Librarian(new FileReaderWriter());
		lib.storeBook(name, content);
		String returnContent=lib.retrieveBook(name);
        // act
		assertEquals(content, returnContent);
        // assert
    }

    // A strict Unit Test that will not modify the file system
    @Test
    public void ut_Librarian_ManagesBooks() throws IOException {
        // arrange
    	//FileReaderWriter writer= Mockito.mock(FileReaderWriter.class);
    	
    	String name="MyExperience";
		String dummyContent="Dummy Content";
		String originalContent="Can't share it";
		String workingDirectory = System.getProperty("user.dir");
	    String bookFileName = new File(workingDirectory, name).toString() + ".txt";
    	
	    when(readerWriter.loadFile(bookFileName)).thenReturn(dummyContent);
    	libraryService.storeBook(name, originalContent);
		String returnContent=libraryService.retrieveBook(name);
		assertEquals(dummyContent, returnContent);
		verify(readerWriter,times(1)).loadFile(bookFileName);

    }
}
