package com.example.exercisefragments;

import java.util.ArrayList;
import java.util.Random;

public class Contact {

    String name;
    String phone;
    String email;
    int avatar;

    public Contact(String name, String phone, String email, int avatar) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.avatar = avatar;
    }

    public static ArrayList<Contact> getMockData() {
        ArrayList<Contact> contacts = new ArrayList<>();

        String [] name = {"Aaaa", "Bbbb", "Cccc", "Dddd", "Eeee", "Ffff", "Gggg", "Hhhh", "Iiii", "Jjjj", "Llll", "Kkkk"};
        String [] phone = {"0000", "1111", "2222", "3333", "4444", "5555", "6666", "7777", "8888", "9999", "1010", "0101"};
        String [] email = {"aa@exam.com", "bb@exam.com", "cc@exam.com", "dd@exam.com", "ee@exam.com", "ff@exam.com",
                            "gg@exam.com", "hh@exam.com", "ii@exam.com", "jj@exam.com", "ll@exam.com", "kk@exam.com"};

        Random random = new Random();

        for(int i = 0; i < name.length; i++)
        {
            contacts.add(new Contact(name[i], phone[i], email[i], random.nextInt(4)));
        }
        return contacts;
    }
}
