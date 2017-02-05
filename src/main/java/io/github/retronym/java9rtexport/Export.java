package io.github.retronym.java9rtexport;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Export {
    public static void main(String[] args) {
        try {
            FileSystem fileSystem = FileSystems.getFileSystem(URI.create("jrt:/"));
            Path path = fileSystem.getPath("/modules");
            String destination = args[0];
            Path destPath = Paths.get(destination);
            URI uri = URI.create( "jar:" + destPath.toUri() );
            Map<String, String> env = new HashMap<>();
            env.put( "create", "true" );
            try ( FileSystem zipfs = FileSystems.newFileSystem( uri, env ) ) {
                Iterator<Path> iterator = Files.list(path).iterator();
                while(iterator.hasNext()) {
                    Path next = iterator.next();
                    Copy.copyDirectory(next, zipfs.getPath("/"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
