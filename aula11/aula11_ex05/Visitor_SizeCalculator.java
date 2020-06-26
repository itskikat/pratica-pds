package aula11_ex05;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicLong;

public class Visitor_SizeCalculator extends SimpleFileVisitor<Path> {
	
	public AtomicLong directorySize(String pathstr) {
		Path path;
		try {
			path = Paths.get(pathstr);
			AtomicLong size = new AtomicLong(0);
			Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
									
					size.addAndGet(attrs.size()/1024);
					return FileVisitResult.CONTINUE;
				}
			});
		} 
		catch (IOException e) {
			throw new AssertionError("walkFileTree will not throw IOException if the FileVisitor does not");
		}

		return null;
	}
}
