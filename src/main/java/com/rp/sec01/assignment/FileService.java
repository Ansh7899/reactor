package com.rp.sec01.assignment;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    private static final Path PATH = Paths.get("src/main/resources/assignment/sec01");

    //publisher for reading
    public static Mono<String> read (String filename) {
        return Mono.fromSupplier(() -> readFromFile(filename));
    }

    //publisher for writing
    public static Mono<Void> write (String filename, String content) {
        return Mono.fromRunnable(() -> writeInFile(filename, content));
    }

    //publisher for deleting
    public static Mono<Void> delete (String filename) {
        return Mono.fromRunnable(() -> deleteFile(filename));
    }



    private static String readFromFile(String filename) {
        try {
            return Files.readString(PATH.resolve(filename));
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private static void writeInFile(String filename, String content){
        try{
            Files.writeString(PATH.resolve(filename), content);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private static void deleteFile(String filename){
        try{
            Files.delete(PATH.resolve(filename));
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
