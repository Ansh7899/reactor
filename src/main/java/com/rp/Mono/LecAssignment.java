package com.rp.Mono;

import com.rp.Mono.assignment.FileService;
import com.rp.utils.Util;

public class LecAssignment {
    public static void main(String[] args) {


        //to read file
        FileService.read("file01.txt").subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        //to write in file
        FileService.write("file03.txt", "This is new file").subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        //to read from new created file
        FileService.read("file03.txt").subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        //to delete a file
        FileService.delete("file03.txt").subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

    }
}
