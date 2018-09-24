package ru.innopolis.lab_1;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;

public class ThreadWorkFile extends Thread {

    private String fileDest;
    private String [] words;
    public ConcurrentSkipListSet<String> concurrentSkipListSetAllThread;
    private long skip;

    public ThreadWorkFile(String fileDest, String[] words,ConcurrentSkipListSet<String> concurrentSkipListSetAllThread) {
        this.fileDest = fileDest;
        this.words = words;
        this.concurrentSkipListSetAllThread = concurrentSkipListSetAllThread;
        skip = 0;
    }

    public ThreadWorkFile(String fileDest, String[] words, ConcurrentSkipListSet<String> concurrentSkipListSetAllThread, long skip) {
        this.fileDest = fileDest;
        this.words = words;
        this.concurrentSkipListSetAllThread = concurrentSkipListSetAllThread;
        this.skip = skip;
    }

    @Override
    public void run() {

//        Чтение из файла
        Main.LOGGER.info("Читаем файл " + fileDest);
        StringBuffer buffer = new StringBuffer();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(fileDest),"UTF-8")){
            BufferedReader reader = new BufferedReader(inputStreamReader);
            reader.skip(skip);
            int ch;
            while ((ch = reader.read())>-1){
                if (((char)ch != '.')){
                    buffer.append((char)ch);
                }
                else{
                    String s = buffer.toString().trim();
                    String[] splited = s.split("\\b+");
                    List<String> list = Arrays.asList(splited);
                    for (String s1 : words){
                        if (list.contains(s1)) {
                            concurrentSkipListSetAllThread.add(s);
                        }
                    }
                    buffer.setLength(0);
                }

            }
        } catch (IOException e) {
            Main.LOGGER.error(e.getMessage());
        }

        Main.LOGGER.info("Читаем файл " + fileDest);

//        Создадим stream строк из предложений
        //String[] strings = Pattern.compile("\\.|\\?|\\!").split(buffer.toString().replace("...","."));
        //Stream<String> stringStream  = Arrays.stream(strings);
        //concurrentSkipListSetAllThread.addAll(stringStream.collect(Collectors.toCollection(ArrayList<String> :: new)));
        //System.out.println("Поток выполнился обрабатывать файл " + fileDest);
    }



}
