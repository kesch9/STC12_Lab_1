package ru.innopolis.lab_1;

public class Main {
    public static void main(String[] args) {

        String[] dest = {"/VirtualMachine/testFile/082a980b-ff03-4e6e-be3d-d9430c33c75b.txt",
                "/VirtualMachine/testFile/8c039db2-2fb5-412e-9a1e-5ddc0802a32f.txt",
                "/VirtualMachine/testFile/432bfa8a-9ea1-4e9d-bdb8-602ab430ddd1.txt",
                "/VirtualMachine/testFile/904bd857-7136-4798-854c-d1d9aed00d6e.txt",
                "/VirtualMachine/testFile/ff9dcd58-dfb0-4579-88ad-6659ce3a3fff.txt",
                "/VirtualMachine/testFile/ff9dcd58-dfb0-4579-88ad-6659ce3a3fff.txt",
                "/VirtualMachine/testFile/ff9dcd58-dfb0-4579-88ad-6659ce3a3fff.txt",
                "/VirtualMachine/testFile/e4e66850-53b9-4784-814c-86a3c69948b7.txt",
                "/VirtualMachine/testFile/7485b80c-d210-42a3-8fba-9bf20dfad327.txt",
                "/VirtualMachine/testFile/06ab4062-bb2d-420a-9e4f-9b77b4099966.txt",
                "/VirtualMachine/testFile/132ded68-3473-4b2b-a1fe-8b6ad8c2a564.txt",
                "/VirtualMachine/testFile/e4e66850-53b9-4784-814c-86a3c69948b7.txt",
//                "/VirtualMachine/testFile/ae5bff35-e3c4-4a01-b9a1-1f6c6013caf5.txt",
                "/VirtualMachine/testFile/e4e66850-53b9-4784-814c-86a3c69948b7.txt",
                "/VirtualMachine/testFile/e4e66850-53b9-4784-814c-86a3c69948b7.txt"

        };
        String[] dict = {"starter", "smarter", "xxx", "zzz", "lll"};
        WordsEnteringTexts wordsEnteringTextsImplement = new WordsEnteringTextsImplement();
        wordsEnteringTextsImplement.getOccurencies(dest, dict,"/VirtualMachine/testFile/res.txt");
    }
}
