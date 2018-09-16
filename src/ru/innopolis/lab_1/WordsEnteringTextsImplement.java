package ru.innopolis.lab_1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WordsEnteringTextsImplement implements WordsEnteringTexts {

    private int sizeBigFileThread = 60;

    ConcurrentSkipListSet<String> concurrentSkipListSetAllThread = new ConcurrentSkipListSet<>();

    public void getOccurencies(String[] sources, String[] words, String res) {
        ExecutorService threadpool = Executors.newCachedThreadPool();
        int k = sources.length;
        int j=0;
        System.out.println("Количество файлов " + k);
        while (k != 0){
            long skip = 0;
            for (int i=0; i<10; i++) {
                File file = new File(sources[j]);;
                if(file.length() > 100000000L){
//                    Запустим десять потоков для большого файла
                    System.out.println("Обработаем большой файл");
                    skip = new File(sources[j]).getTotalSpace()/sizeBigFileThread;
                    for (int u=0; u<sizeBigFileThread; u++){
                        threadpool.submit(new ThreadWorkFile(sources[j],words,concurrentSkipListSetAllThread,skip));
                        skip += skip;
                    }

                } else {
                    threadpool.submit(new ThreadWorkFile(sources[j], words, concurrentSkipListSetAllThread, skip));
                }
                k -= 1;
                System.out.println("Осталось обработать файлов " + k );
                j += 1;
                System.out.println("Количество потоков создано " + j);
                if (k == 0){break;}
            }
            System.out.println("Создали потоки");
            threadpool.shutdown();
            while (!threadpool.isTerminated()){}
            threadpool = Executors.newCachedThreadPool();
            System.out.println("Потоки закончили работать");
        }
        try {
            FileWriter fileWriter = new FileWriter(res);
            for (String s : concurrentSkipListSetAllThread){
                System.out.println("Строка записи: " + s);
                fileWriter.write("[ " + s + " ]");
                fileWriter.flush();
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
